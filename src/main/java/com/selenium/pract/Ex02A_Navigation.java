package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex02A_Navigation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        System.out.println("Title of page1: "+driver.getTitle());
        By bySearch = By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input");
        WebElement wsearch = driver.findElement(bySearch);
        wsearch.sendKeys("ataevents.org ");
        wsearch.sendKeys(Keys.ENTER);

        System.out.println("Title of page2 : "+driver.getTitle());

        By bylink1 = By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/div[1]/a/h3/span");
        WebElement link1 = driver.findElement(bylink1);
        link1.click();

        System.out.println("Title of page3  : "+driver.getTitle());

        driver.navigate().back();
        
        String Title1 = driver.getTitle();
        System.out.println("Title of page1: "+Title1);
        driver.navigate().back();
        String Title2 = driver.getTitle();
        System.out.println("Title of page2: "+Title2);
        Thread.sleep(3000);
        driver.close();
    }
}