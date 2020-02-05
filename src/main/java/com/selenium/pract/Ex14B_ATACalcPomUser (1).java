package day5;

import org.testng.annotations.Test;

import utils.HelperFunctions;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Ex14B_ATACalcPomUser {

	WebDriver driver;

	@BeforeTest

	public void beforeTest() {

		driver = HelperFunctions.createAppropriateDriver("chrome");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		

	}


	@Test
	public void f() throws InterruptedException {
		
		driver.get("http://ata123456789123456789.appspot.com/");
		Thread.sleep(5000);
		EX14B_ATACalcPoM ataPage = new EX14B_ATACalcPoM(driver);
		
		int expectedResult = 144;
		String actualResult = ataPage.multiply("12", "12");
		int iActualResult = Integer.parseInt(actualResult);
		Assert.assertEquals(iActualResult, expectedResult,"Results do not match");
		
		int expectedResult0 = 99;
		String actualResult0 = ataPage.multiply("9", "10");
		int iActualResult0 = Integer.parseInt(actualResult0);
		Assert.assertEquals(iActualResult0, expectedResult0,"Results do not match");
		
		
		
		int expectedResult1 = 18;
		String actualResult1 = ataPage.add("14", "4");
		int iActualResult1 = Integer.parseInt(actualResult1);
		Assert.assertEquals(iActualResult1, expectedResult1,"Results do not match");
		
		int expectedResult2 = 14;
		String actualResult2 = ataPage.compare("14", "10");
		int iActualResult2 = Integer.parseInt(actualResult2);
		Assert.assertEquals(iActualResult2, expectedResult2,"Comparison Failed");
		
	}

	@AfterTest
	public void afterTest() {
		
		driver.quit();
	}

}
