package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EX14B_ATACalcPoM {

	WebDriver driver;

	// *[@id="ID_nameField1"]
	// *[@id="ID_nameField2"]
	// *[@id="gwt-uid-2"]
	// *[@id="ID_calculator"]
	// *[@id="ID_nameField3"]

	By byField1 = By.xpath("//*[@id=\"ID_nameField1\"]");
	By byField2 = By.xpath("//*[@id=\"ID_nameField2\"]");
	By byMul = By.xpath("//*[@id=\"gwt-uid-2\"]");
	By byCalc = By.xpath("//*[@id=\"ID_calculator\"]");
	By byResult = By.xpath("//*[@id=\"ID_nameField3\"]");

	//*[@id="gwt-uid-1"]
	By byAdd = By.xpath("//*[@id=\"gwt-uid-1\"]");
	By byComp = By.xpath("//*[@id=\"gwt-uid-4\"]");
	
	
	public EX14B_ATACalcPoM(WebDriver driver) {
		this.driver = driver;
	}
	
	String multiply(String input1, String input2) {
		
		String returnValue = null;
		
		driver.findElement(byField1).clear();
		driver.findElement(byField1).sendKeys(input1);
		
		driver.findElement(byField2).clear();
		driver.findElement(byField2).sendKeys(input2);
		
		driver.findElement(byMul).click();
		
		driver.findElement(byCalc).click();

		returnValue = driver.findElement(byResult).getAttribute("value");
		
		return returnValue;
		
	}
	
	
	String add(String input1, String input2) {
		
		String returnValue = null;
		
		driver.findElement(byField1).clear();
		driver.findElement(byField1).sendKeys(input1);
		
		driver.findElement(byField2).clear();
		driver.findElement(byField2).sendKeys(input2);
		
		driver.findElement(byAdd).click();
		
		driver.findElement(byCalc).click();

		returnValue = driver.findElement(byResult).getAttribute("value");
		
		return returnValue;
		
	}
	
String compare(String input1, String input2) {
		
		String returnValue = null;
		
		driver.findElement(byField1).clear();
		driver.findElement(byField1).sendKeys(input1);
		
		driver.findElement(byField2).clear();
		driver.findElement(byField2).sendKeys(input2);
		
		driver.findElement(byComp).click();
		
		driver.findElement(byCalc).click();

		returnValue = driver.findElement(byResult).getAttribute("value");
		
		return returnValue;
		
	}
}
