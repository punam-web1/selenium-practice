package day5;

import org.testng.annotations.Test;

import utils.HelperFunctions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Ex14C_ATACalcPOMDDUser {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.out.println("Entering Ex14C_ATACalcPOMDDUser.beforeTest()   :");
		driver = HelperFunctions.createAppropriateDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@DataProvider
	public Object[][] dp() {
		System.out.println("Entering Ex14C_ATACalcPOMDDUser.dp()   :");
		Object[][] data=null;
		try {
			data=utils.DataReaders.getExcelDataUsingPoi("src\\test\\resources\\data\\Day3Exercise3.xlsx", "data");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Test(dataProvider = "dp")
	public void f(String v1, String v2, String v3,String v4) {
		System.out.println("Entering Ex14C_ATACalcPOMDDUser.f()   :");
		
		/*
		 * String input1 = v1;
		 
		String input2 = v2;
		String operation = v3;
		String expectedResult = v4;
		*/
		
		driver.get("http://ata123456789123456789.appspot.com/");
		//System.out.println( v1  +  v2 + v3 +v4);
		
		EX14B_ATACalcPoM ataPage = new EX14B_ATACalcPoM(driver);
		String actualResult=null;
		
		switch (v3.toUpperCase()) {

		case "MUL":
			
			System.out.println("Inside Mul");
			
			actualResult=ataPage.multiply(v1, v2);
			
	
			break;

		case "ADD":
			System.out.println("Inside Add");
			actualResult=ataPage.add(v1, v2);
			
			
			
			break;
		case "COMPARE":
			
			System.out.println("Inside Compare");
				
			break;			
		default:
			//create chrome by default
			System.out.println("Inside Default");	
			break;
		}
       Assert.assertEquals(actualResult, v4,"result do not match");
       
       System.out.println("Exiting Ex14C_ATACalcPOMDDUser.f()   :");
		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Entering Ex14C_ATACalcPOMDDUser.afterTest()   :");
		driver.quit();
	}

}