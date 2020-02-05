package com.selenium.sceenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SreenShot {
    public static void main(String[] args) throws Exception {
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.chrome.driver","E:\\punam\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.linkedin.com/");
        takeSnapShot(driver, "ScreenShot//First_ScreenShot.png") ;  
        driver.close();

    }
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

               // File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination
                File source = scrShot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("./ScreenShot/Screen.png"));
                System.out.println("the Screenshot is taken");
               

                

               // FileUtils.copyFile(SrcFile, DestFile);
                
    }

	

}

// alert hamdling
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







package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Ex06_SocialMedia {
public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

driver.get("http://agiletestingalliance.org/");
// /html/body/footer/div/a[1]/img

By byvar = By.xpath("/html/body/footer/div/a[*]");
// driver.findElements(by)




List<WebElement> welist = driver.findElements(byvar);

for ( WebElement we :welist ) {
System.out.println(we.getAttribute("href"));
}

driver.quit();
}
}

 







package day5;

import org.testng.annotations.Test;

import utils.HelperFunctions;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Ex07_IMDB_NG {
WebDriver driver;

@BeforeTest
public void beforeTest() {
driver = HelperFunctions.createAppropriateDriver("chrome");
driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}

@Test
public void f1() {

String movieName = "Raazi";
String expectedDirectorName = "Meghna";
String expectedStarName = "Vicky Kaushal";

driver.get("https://www.imdb.com/");

//*[@id="navbar-query"]
//*[@id="suggestion-search"]
By byVar = By.xpath("//*[@id=\"suggestion-search\"]");
WebElement weText = driver.findElement(byVar);
weText.sendKeys(movieName);
weText.sendKeys(Keys.ENTER);

WebDriverWait wait = new WebDriverWait(driver,10);

By byMovieLink = By.partialLinkText(movieName);

wait.until(ExpectedConditions.elementToBeClickable(byMovieLink));

WebElement we = driver.findElement(byMovieLink);
we.getAttribute("href");
we.click();


//*[@id="title-overview-widget"]/div[2]/div[1]/div[2]/a
//String director = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[1]/div[2]/a")).getText();

//*[@class='inline' and contains(text(),"Director")]/following-sibling::*

By byAllDirectors = By.xpath("//*[@class='inline' and contains(text(),\"Director\")]/following-sibling::*");

List<WebElement> listOfDirectors = driver.findElements(byAllDirectors);

boolean directorFound = false;

for (int i=0;i<listOfDirectors.size();i++) {
String directorName = listOfDirectors.get(i).getText();
//expectedDirectorName
if (directorName.contains(expectedDirectorName)) {
directorFound = true;
break;
}
}

System.out.println("Director " + expectedDirectorName + " Found =" + directorFound);

//*[@class='inline' and text()="Stars:"]/following-sibling::*
By byAllStars = By.xpath("//*[@class='inline' and text()=\"Stars:\"]/following-sibling::*");

List<WebElement> listOfStars = driver.findElements(byAllStars);

boolean starFound = false;

for (int i=0;i<listOfStars.size();i++) {
String starName = listOfStars.get(i).getText();
//expectedDirectorName
if (starName.contains(expectedStarName)) {
starFound = true;
break;
}
}

System.out.println("Star Name " + expectedStarName + " Found =" + starFound);


}

@Test
public void f2() {

String movieName = "Baazigar";
String expectedDirectorName = "Mastan";
String expectedStarName = "Shah Rukh Khan";

driver.get("https://www.imdb.com/");

//*[@id="navbar-query"]
//By byVar = By.xpath("//*[@id=\"navbar-query\"]");

//*[@id="suggestion-search"]
By byVar = By.xpath("//*[@id=\"suggestion-search\"]");

WebElement weText = driver.findElement(byVar);
weText.clear();
weText.sendKeys(movieName);
WebDriverWait wait = new WebDriverWait(driver,10);
weText.sendKeys(Keys.ENTER);

// //*[@id='main']/div/div[2]/table/tbody/tr[1]/td[2]/a
// By moviename = By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a");

By byMovieLink = By.partialLinkText(movieName);

wait.until(ExpectedConditions.elementToBeClickable(byMovieLink));

WebElement we = driver.findElement(byMovieLink);
we.getAttribute("href");
we.click();

//*[@id="title-overview-widget"]/div[2]/div[1]/div[2]/a
//String director = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[1]/div[2]/a")).getText();

//*[@class='inline' and contains(text(),"Director")]/following-sibling::*

By byAllDirectors = By.xpath("//*[@class='inline' and contains(text(),\"Director\")]/following-sibling::*");

List<WebElement> listOfDirectors = driver.findElements(byAllDirectors);

boolean directorFound = false;

for (int i=0;i<listOfDirectors.size();i++) {
String directorName = listOfDirectors.get(i).getText();
//expectedDirectorName
if (directorName.contains(expectedDirectorName)) {
directorFound = true;
break;
}
}

System.out.println("Director " + expectedDirectorName + " Found =" + directorFound);


//*[@class='inline' and text()="Stars:"]/following-sibling::*
By byAllStars = By.xpath("//*[@class='inline' and text()=\"Stars:\"]/following-sibling::*");

List<WebElement> listOfStars = driver.findElements(byAllStars);

boolean starFound = false;

for (int i=0;i<listOfStars.size();i++) {
String starName = listOfStars.get(i).getText();
System.out.println("Star Names : " + i + starName );
//expectedDirectorName
if (starName.contains(expectedStarName)) {
starFound = true;
break;
}
}

System.out.println("Star Name " + expectedStarName + " Found =" + starFound);

}


@Test
public void f3() {

String movieName = "Uri";
String expectedDirectorName = "Aditya Dhar";
String expectedStarName = "Vicky Kaushal";

driver.get("https://www.imdb.com/");

//*[@id="navbar-query"]
//By byVar = By.xpath("//*[@id=\"navbar-query\"]");

//*[@id="suggestion-search"]
By byVar = By.xpath("//*[@id=\"suggestion-search\"]");

WebElement weText = driver.findElement(byVar);
weText.clear();
weText.sendKeys(movieName);
WebDriverWait wait = new WebDriverWait(driver,10);
weText.sendKeys(Keys.ENTER);

// //*[@id='main']/div/div[2]/table/tbody/tr[1]/td[2]/a
// By moviename = By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a");

By byMovieLink = By.partialLinkText(movieName);

wait.until(ExpectedConditions.elementToBeClickable(byMovieLink));

WebElement we = driver.findElement(byMovieLink);
we.getAttribute("href");
we.click();

//*[@id="title-overview-widget"]/div[2]/div[1]/div[2]/a
//String director = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[1]/div[2]/a")).getText();

//*[@class='inline' and contains(text(),"Director")]/following-sibling::*

By byAllDirectors = By.xpath("//*[@class='inline' and contains(text(),\"Director\")]/following-sibling::*");

List<WebElement> listOfDirectors = driver.findElements(byAllDirectors);

boolean directorFound = false;

for (int i=0;i<listOfDirectors.size();i++) {
String directorName = listOfDirectors.get(i).getText();
//expectedDirectorName
if (directorName.contains(expectedDirectorName)) {
directorFound = true;
break;
}
}

System.out.println("Director " + expectedDirectorName + " Found =" + directorFound);


//*[@class='inline' and text()="Stars:"]/following-sibling::*
By byAllStars = By.xpath("//*[@class='inline' and text()=\"Stars:\"]/following-sibling::*");

List<WebElement> listOfStars = driver.findElements(byAllStars);

boolean starFound = false;

for (int i=0;i<listOfStars.size();i++) {
String starName = listOfStars.get(i).getText();
System.out.println("Star Names : " + i + starName );
//expectedDirectorName
if (starName.contains(expectedStarName)) {
starFound = true;
break;
}
}

System.out.println("Star Name " + expectedStarName + " Found =" + starFound);

}

 

@AfterTest
public void afterTest() {
driver.quit();
}

}

 


package day5;

import org.testng.annotations.Test;

import utils.HelperFunctions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Ex07_IMDB_DP_NG {
WebDriver driver;

@BeforeTest
public void beforeTest() {
driver = HelperFunctions.createAppropriateDriver("chrome");
driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}


@DataProvider
public Object[][] dp() {
// String[] mv1 = {"Raazi","Meghna", "Vicky"};
// String[] mv2 = {"Baazigar","Mastan", "Shah Rukh"};
// String[] mv3 = {"Uri","Aditya", "Vicky"};
//

//String[][] mdata = { mv1, mv2, mv3 };

String[][] mdata = { {"Raazi","Meghna", "Vicky"},
{"Baazigar","Mastan", "Shah Rukh"},
{"Uri","Aditya", "Vicky"}
};


return mdata;


}



@Test(dataProvider="dp")
public void f(String v1, String v2, String v3) {

String movieName = v1 ; //"Raazi";
String expectedDirectorName = v2 ; //"Meghna";
String expectedStarName = v3 ; //"Vicky Kaushal";

driver.get("https://www.imdb.com/");

//*[@id="navbar-query"]
//*[@id="suggestion-search"]
By byVar = By.xpath("//*[@id=\"suggestion-search\"]");
WebElement weText = driver.findElement(byVar);
weText.sendKeys(movieName);
weText.sendKeys(Keys.ENTER);

WebDriverWait wait = new WebDriverWait(driver,10);

By byMovieLink = By.partialLinkText(movieName);

wait.until(ExpectedConditions.elementToBeClickable(byMovieLink));

WebElement we = driver.findElement(byMovieLink);
we.getAttribute("href");
we.click();


//*[@id="title-overview-widget"]/div[2]/div[1]/div[2]/a
//String director = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[1]/div[2]/a")).getText();

//*[@class='inline' and contains(text(),"Director")]/following-sibling::*

By byAllDirectors = By.xpath("//*[@class='inline' and contains(text(),\"Director\")]/following-sibling::*");

List<WebElement> listOfDirectors = driver.findElements(byAllDirectors);

boolean directorFound = false;

for (int i=0;i<listOfDirectors.size();i++) {
String directorName = listOfDirectors.get(i).getText();
//expectedDirectorName
if (directorName.contains(expectedDirectorName)) {
directorFound = true;
break;
}
}

System.out.println("Director " + expectedDirectorName + " Found =" + directorFound);

//*[@class='inline' and text()="Stars:"]/following-sibling::*
By byAllStars = By.xpath("//*[@class='inline' and text()=\"Stars:\"]/following-sibling::*");

List<WebElement> listOfStars = driver.findElements(byAllStars);

boolean starFound = false;

for (int i=0;i<listOfStars.size();i++) {
String starName = listOfStars.get(i).getText();
//expectedDirectorName
if (starName.contains(expectedStarName)) {
starFound = true;
break;
}
}

System.out.println("Star Name " + expectedStarName + " Found =" + starFound);


}

@AfterTest
public void afterTest() {
driver.quit();
}

}

















package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.HelperFunctions.createAppropriateDriver;


public class Ex07_IMDB_DataDriven_XL_NG {
WebDriver driver;

@BeforeTest
public void beforeTest() {

driver = createAppropriateDriver("CHROME");
driver.manage().window().maximize();

driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.get("https://www.imdb.com/");
}

@DataProvider
public Object[][] dp() throws Exception {
String[][] datafromxl = utils.DataReaders.getExcelDataUsingPoi("src\\test\\resources\\data\\imdbdata.xlsx", "data");
return datafromxl;
}


@Test(dataProvider = "dp")
public void f1(String v1, String v2, String v3) throws Exception {

String movieName = v1;
String expectedDirectorName = v2;
String expectedStarName = v3;

//driver.get("https://www.imdb.com/");

//*[@id="navbar-query"]
//*[@id="suggestion-search"]
By byVar = By.xpath("//*[@id=\"suggestion-search\"]");
WebElement weText = driver.findElement(byVar);
weText.sendKeys(movieName);
weText.sendKeys(Keys.ENTER);

WebDriverWait wait = new WebDriverWait(driver, 10);

By byMovieLink = By.partialLinkText(movieName);

wait.until(ExpectedConditions.elementToBeClickable(byMovieLink));

WebElement we = driver.findElement(byMovieLink);
we.getAttribute("href");
we.click();


//*[@id="title-overview-widget"]/div[2]/div[1]/div[2]/a
//String director = driver.findElement(By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[1]/div[2]/a")).getText();

//*[@class='inline' and contains(text(),"Director")]/following-sibling::*

By byAllDirectors = By.xpath("//*[@class='inline' and contains(text(),\"Director\")]/following-sibling::*");

List<WebElement> listOfDirectors = driver.findElements(byAllDirectors);

boolean directorFound = false;

for (int i = 0; i < listOfDirectors.size(); i++) {
String directorName = listOfDirectors.get(i).getText();
//expectedDirectorName
if (directorName.contains(expectedDirectorName)) {
directorFound = true;
break;
}
}

System.out.println("Director " + expectedDirectorName + " Found =" + directorFound);

//*[@class='inline' and text()="Stars:"]/following-sibling::*
By byAllStars = By.xpath("//*[@class='inline' and text()=\"Stars:\"]/following-sibling::*");

List<WebElement> listOfStars = driver.findElements(byAllStars);

boolean starFound = false;

for (int i = 0; i < listOfStars.size(); i++) {
String starName = listOfStars.get(i).getText();
//expectedDirectorName
if (starName.contains(expectedStarName)) {
starFound = true;
break;
}
}

System.out.println("Star Name " + expectedStarName + " Found =" + starFound);


}

@AfterTest
public void afterTest() {
driver.quit();
}

}













package day5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.HelperFunctions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ex11_JqueryIframe_NG {
WebDriver driver ;
@BeforeTest
public void beforeTest() {
driver = HelperFunctions.createAppropriateDriver("chrome",false);

driver.get("http://jqueryui.com/autocomplete/");
driver.manage().window().maximize();

driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}

 


@Test
public void f() throws InterruptedException {

// To handle the frame (Using by index)
driver.switchTo().frame(0);
WebElement element = driver.findElement(By.className("ui-autocomplete-input"));
element.sendKeys("j");


WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/ul/li")));


List<WebElement> lst = driver.findElements(By.xpath("/html/body/ul/li"));
for(int i=0; i < lst.size(); i++){
//WebElement ele = driver.findElement(By.xpath("/html/body/ul/li["+i+"]"));
WebElement ele = lst.get(i);
System.out.println(ele.getText());
/*if(ele.getText().equals("Java")){
System.out.println(i);
ele.click();
Thread.sleep(3000);
}*/
}




















