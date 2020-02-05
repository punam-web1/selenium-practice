package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex00_HelloSelenium {

	public static void main(String[] args) {
		System.out.println("Hello Selenium !!!");
		
		/*System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();*/
		
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		
	driver.manage().window().maximize();
	
	driver.get("http://www.google.com");
	String pageTitle = driver.getTitle();
	System.out.println("Title of the Page is : "+ pageTitle);
	
	//*[@id="tsf"]/div[2]/div[1]/div[1]/div/div[2]/input
	
	
	By byvar = By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input");
	WebElement weinput = driver.findElement(byvar);
	
	
	
	weinput.sendKeys("Selenium");
	
	weinput.sendKeys(Keys.ENTER);
	
	
	
	
	
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.close();
	
	

	}

}
