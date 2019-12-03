package sendMessage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ToMobileNo 
{
	WebDriver driver;
  @Parameters({"Browser"})	
  @Test(priority = 1) // Describe Browser
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
  @Test(priority = 2) // This is Browser Link
  public void link(String search) throws Exception
  {
	  driver.get(search);
	  Thread.sleep(1000);
	  Screen mini=new Screen();
	  mini.click("F:\\Download\\Images\\Bug Screenshot\\minimizeBrowser.JPG");
  }
    
  @Test(priority = 3) // Login With way2sms Mobile Number and password
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
	  
	  Thread.sleep(2000);
	  Robot r1=new Robot();
	  r1.keyPress(KeyEvent.VK_ALT);
	  r1.keyPress(KeyEvent.VK_TAB);
	  r1.keyRelease(KeyEvent.VK_ALT);
	  r1.keyRelease(KeyEvent.VK_TAB);
	  Screen mini=new Screen();
	  mini.click("F:\\Download\\Images\\Bug Screenshot\\minimizeBrowser.JPG");
	  
	  Thread.sleep(2000);
	  System.out.println("Enter password: ");  // Enter Password
	  Scanner p1=new Scanner(System.in);
	  String pass=p1.nextLine();
	  WebElement password=driver.findElement(By.id("password"));
	  password.sendKeys(pass);

	  Thread.sleep(1000);
	  Robot r2=new Robot();
	  r2.keyPress(KeyEvent.VK_ALT);
	  r2.keyPress(KeyEvent.VK_TAB);
	  r2.keyRelease(KeyEvent.VK_ALT);
	  r2.keyRelease(KeyEvent.VK_TAB); 
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/div[2]/button")).click();     // Click on Login Button
	  Thread.sleep(2000);
	  
  }
 
  @Test(priority = 4) // Send SMS ( Sender Mobile Number and Enter Text Message )
  public void sendermobilenumber() throws Exception
  {
	  Screen mini1=new Screen();
	  mini1.click("F:\\Download\\Images\\Bug Screenshot\\minimizeBrowser.JPG"); 
	  
	  Thread.sleep(2000);
	  System.out.println("Enter Sender MObile Number:"  );  // Enter sender Mobile Number
	  Scanner sendnum=new Scanner(System.in);
	  String mobnum=sendnum.nextLine();
	  driver.findElement(By.id("mobile")).sendKeys(mobnum);
	  
	  Thread.sleep(2000);
	  Robot r1=new Robot();
	  r1.keyPress(KeyEvent.VK_ALT);
	  r1.keyPress(KeyEvent.VK_TAB);
	  r1.keyRelease(KeyEvent.VK_ALT);
	  r1.keyRelease(KeyEvent.VK_TAB);
	  Thread.sleep(2000);
	  Screen mini=new Screen();
	  mini.click("F:\\Download\\Images\\Bug Screenshot\\minimizeBrowser.JPG");
	  
	  Thread.sleep(2000);
	  System.out.println("Enter Message");  // Enter sender Password
	  Scanner message=new Scanner(System.in);
	  String text=message.nextLine();
	  driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys(text);   
	  
	  Thread.sleep(2000);
	  Robot r2=new Robot();
	  r2.keyPress(KeyEvent.VK_ALT);
	  r2.keyPress(KeyEvent.VK_TAB);
	  r2.keyRelease(KeyEvent.VK_ALT);
	  r2.keyRelease(KeyEvent.VK_TAB);
	  
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"sendButton\"]")).click();
	  Thread.sleep(2000);
	  
	  Screen mini3=new Screen();
	  mini3.click("F:\\Download\\Images\\Bug Screenshot\\minimizeBrowser.JPG");
  }
  
  @Test(priority = 5) // 
  public void languageSMS() throws Exception
  {
	  
	  WebElement lang=driver.findElement(By.xpath("//*[contains (text(), 'Language SMS')]"));
	  lang.click();
	  Thread.sleep(2000);
	  
	  Screen mini1=new Screen();
	  mini1.click("F:\\Download\\Images\\Bug Screenshot\\minimizeBrowser.JPG");
	  
	  Thread.sleep(2000);
	  System.out.println("Enter Sender MObile Number:"  );  // Enter sender Mobile Number
	  Scanner sendnum=new Scanner(System.in);
	  String mobnum=sendnum.nextLine();
	  driver.findElement(By.id("mobile")).sendKeys(mobnum);
	  
	  Thread.sleep(2000);
	  Robot r2=new Robot();
	  r2.keyPress(KeyEvent.VK_ALT);
	  r2.keyPress(KeyEvent.VK_TAB);
	  r2.keyRelease(KeyEvent.VK_ALT);
	  r2.keyRelease(KeyEvent.VK_TAB);
	  
	  Select drop=new Select(driver.findElement((By.xpath("//*[@id=\"lanDiv\"]/select"))));
	  drop.equals("Telugu");
	  drop.selectByIndex(1);
	    }
  
  
}
