package sendMessage;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.BorderUIResource.MatteBorderUIResource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class ToMobileNo 
{
	WebDriver driver;
  @Parameters({"Browser"})	
  @Test(priority = 1)
  public void openBrowser(String Browser)
  {
	  System.out.println("Enter Browser Name: "+ Browser);
	  Scanner sc=new Scanner(System.in);
	  String str=sc.nextLine();
	  
	  if (str.equalsIgnoreCase("c")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Jar Files\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (str.equalsIgnoreCase("f")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Jar Files\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (str.equalsIgnoreCase("f")) {
			System.setProperty("webdriver.ie.driver", "E:\\Jar Files\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
  }
  
  @Parameters({"search"})
  @Test(priority = 2)
  public void link(String search)
  {
	  driver.get(search); 
	  driver.manage().window();
  }
  
  /*@Parameters({"mobileno"})*/
  @Test(priority = 3)
  public void validno() throws Exception
  {
	  
	  System.out.println("Enter MObile Number: "); // Enter Mobile Number
	  Scanner mobilenum=new Scanner(System.in);
	  String mob=mobilenum.nextLine();
	  Boolean z = true;
	  
	  String num= "^[6-9]\\d{9}$";
	  Pattern p=Pattern.compile(num);
	  Matcher m=p.matcher(mob);
	  if(m.matches() != z)
	  {
		  System.out.println("Invalid");
	  }
	  else
	  {
		  System.out.println("valid");
		  WebElement mobile=driver.findElement(By.id("mobileNo"));
		  mobile.sendKeys(mob);
	  }
 
	  System.out.println("Enter MObile Number: ");  // Enter Password
	  Scanner p1=new Scanner(System.in);
	  String pass=p1.nextLine();
	  WebElement password=driver.findElement(By.id("password"));
	  password.sendKeys(pass);
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]/button")).click();     // Click on Login Button
  }
  
  
  
}
