package day5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Ex04_AlertsHandling {

	public static void main(String[] args) {
		ChromeOptions chromeOptions = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");

		chromeOptions.setHeadless(true);

		WebDriver driver = new ChromeDriver(chromeOptions);

		//WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//*[@id="content"]/div/ul/li[1]/button

		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();

		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());


		Alert alert = driver.switchTo().alert();

		//driver.switchTo().
		alert.accept();
		
		
		String message = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
		System.out.println(message);
		if (message.equals("You successfuly clicked an alert")){
			System.out.println("Alert Message is perfect");
		}

driver.quit();

	}

}
