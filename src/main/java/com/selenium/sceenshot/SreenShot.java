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
    	System.setProperty("webdriver.chrome.driver","D:\\Selenium_Web_Driver\\01\\src\\driver\\chromedriver.exe");
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
