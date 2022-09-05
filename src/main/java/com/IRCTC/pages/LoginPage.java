package com.IRCTC.pages;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.IRCTC.commons.TestBase;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
//import captcha.ITesseract;
//import captcha.Tesseract;
import net.sourceforge.tess4j.Tesseract1;

public class LoginPage extends TestBase {

	TestBase t = new TestBase();
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement OkAlert;
	
	@FindBy(xpath="//a[@aria-label='Click here to Login in application']")
	WebElement LoginButton;
	
	@FindBy(xpath="(//img[contains(@src,'https://irctclive.nlpcaptcha.in/index.php/media')])[2]")
	WebElement imageElement;
	
	@FindBy(className="captcha-img")
	WebElement captchaElement;
	
	@FindBy(css=("input.form-control[type=text]"))
	WebElement Username;
	
	@FindBy(css=("input.form-control[type=password]"))
	WebElement Password;
	
	@FindBy(id=("nlpAnswer"))
	WebElement CaptchaElement;
	
	@FindBy(xpath="//button[normalize-space()='SIGN IN']")
	WebElement SigninBtn;
	
	
	public LoginPage()
	{
		PageFactory.initElements(t.driver, this);
	}
	
	public void Login(String username, String password) throws Exception
	{
	
		OkAlert.click();
		
		//LoginButton.click();
		
		boolean login_Button = LoginButton.isEnabled();

		System.out.println("Is login_Button Enabled  :" + login_Button);

		LoginButton.click();

		System.out.println("Clicked on Login Button Successfully");
		
			//Thread.sleep(2000);
			 /*driver.findElement(By.xpath("(//input[@id='9402477'])[1]")).sendKeys("TejaswiPachpute");
			 driver.findElement(By.xpath("(//input[@id='6194095'])[1]")).sendKeys("Tejaswi@2612");*/
			
			//Username.sendKeys(username); 
			
			if (Username.isDisplayed()) { 

				System.out.println("UserName Field Displayed");

				Username.sendKeys(username);

				} else{ 

				System.out.println("UserName Field Not Displayed");
				      }
			
			//Password.sendKeys(password);
			
			if (Password.isDisplayed()) { 

				System.out.println("Password Field Displayed");

				Password.sendKeys(password);

				} else{ 

				System.out.println("Password Field Not Displayed");
				      }
			
			/*driver.findElement(By.xpath("(//input[@class='form-control input-box ng-pristine ng-valid ng-touched'])[1]")).sendKeys("TejaswiPachpute");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@class='form-control input-box ng-pristine ng-valid ng-touched'])[2]")).sendKeys("Tejaswi@2612");
			*/
			
			/*driver.findElement(By.cssSelector("input.form-control[type=text]")).sendKeys("TejaswiPachpute");
			driver.findElement(By.cssSelector("input.form-control[type=password]")).sendKeys("Tejaswi@2612");*/
			
			//Thread.sleep(1000);
			//driver.findElement(By.xpath("//button[normalize-space()='SIGN IN']")).click();
			
			//Object TakesScreenshot;//new addition 1st line 
			//WebElement imageElement = driver.findElement(By.xpath("(//img[contains(@src,'https://irctclive.nlpcaptcha.in/index.php/media')])[2]"));
			//WebElement imageElement = driver.findElement(By.className("captcha-img"));
			//TakesScreenshot imageElement = ((TakesScreenshot)driver);//new addition 2nd line 
			
			if(imageElement.equals(imageElement))
			{	File src = imageElement.getScreenshotAs(OutputType.FILE);
			System.out.println("Screenshot Captured successfully");
			
			String path = "C:\\Users\\lenovo\\eclipse-workspace\\IRCTC-CaptchaHandeling\\captchaimages\\captcha25.png";
			FileHandler.copy(src, new File(path));
			
			Thread.sleep(2000);
			ITesseract image = new Tesseract();
			String str = image.doOCR(new File(path));
			System.out.println("Image OCR Done");
			//System.out.println(str);
			
			Thread.sleep(1000);
			String captcha = str.split("below")[1].replaceAll("[^a-zA-Z0-9]","");
			System.out.println("Final captcha is "+captcha);//new addition
			/*WebElement element = driver.findElement(By.xpath("(//img[contains(@src,'https://irctclive.nlpcaptcha.in/index.php/media')])[2]"));
			String abc =element.getText();
			element = driver.findElement(By.xpath("//input[@id='nlpAnswer']"));
			element.sendKeys(abc);*/
			
			Thread.sleep(2000);
			//driver.findElement(By.id("nlpAnswer")).sendKeys(captcha);
			CaptchaElement.sendKeys(captcha);
			
			//driver.findElement(By.xpath("//button[normalize-space()='SIGN IN']")).click();
			SigninBtn.click();
			}else
			{
				File src = captchaElement.getScreenshotAs(OutputType.FILE);
				System.out.println("Screenshot Captured successfully");
				
				String path = "C:\\Users\\lenovo\\eclipse-workspace\\IRCTC-CaptchaHandeling\\captchaimages\\captcha25.png";
				FileHandler.copy(src, new File(path));
				
				Thread.sleep(2000);
				ITesseract image = new Tesseract();
				String str = image.doOCR(new File(path));
				System.out.println("Image OCR Done");
				//System.out.println(str);
				
				Thread.sleep(1000);
				String captcha = str.split("below")[1].replaceAll("[^a-zA-Z0-9]","");
				System.out.println("Final captcha is "+captcha);
				CaptchaElement.sendKeys(captcha);
				SigninBtn.click();
				
				}
			//validation
			String ActualTitle = driver.getTitle();
			
			String expTitle = "IRCTC Next Generation eTicketing System";
			
			Assert.assertEquals(ActualTitle, expTitle, "HomePage Open successfully!!");
		
				
			//driver.findElement(By.xpath("//input[@id='captcha']"));
		
			//Welcome Tejaswi Msg Xpath = //span[normalize-space()='Welcome Tejaswi (TejaswiPachpute)']
			/*WebElement imageelement = driver.findElement(By.xpath("(//img[contains(@src,'https://irctclive.nlpcaptcha.in/index.php/media')])[2]"));
			WebElement imageelement = driver.findElement(By.className("captcha-img"));
			File src = imageelement.getScreenshotAs(OutputType.FILE);
			
			public final takeScreenshotAtEndOfTest(String filename) {
		        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        String currentDir = System.getProperty("user.dir");
		        FileUtils.copyFile(scrFile, new File(currentDir + "/captchaimages/" + filename + ".png"));
		        return filename;
		    }
			
			System.out.println("Done");
			
			String path = "C:\\Users\\lenovo\\eclipse-workspace\\IRCTC-CaptchaHandeling\\captchaimages\\captcha1.png";
			FileHandler.copy(src, new File(path));
			
			Thread.sleep(5000);
			
			ITesseract image = new Tesseract();
			String str = image.doOCR(new File(path));
			System.out.println("image ocr done");
			System.out.println(str);
			
			
			String captcha = str.split("below")[1].replaceAll("[^a-zA-Z0-9", "");
			System.out.println(captcha);
			driver.findElement(By.xpath("//input[@id='captcha']"));
			*/
	}
}
