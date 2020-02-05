package selenium_punam.selenium_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class ScreenShot {
	 WebDriver driver;
  @Test
  public void f() {
	  System.out.println("Before");
  }
  @BeforeMethod
  public void beforeMethod() {
	 
	  System.setProperty("WebDriver.chrome.driver", "D:\\Selenium_Web_Driver\\01\\src\\driver\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.linkedin.com/");
  }

  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("after");
  }

}
