package sdet_FirstClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AttachDocument {
	
	ChromeDriver driver = new ChromeDriver();
	@Test
	public void attachDocumentMethod() throws InterruptedException
	{
		
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span//p[text()='Sales']")).click();
		Thread.sleep(5000);
		WebElement campaign = driver.findElement(By.xpath("//a//span[text()='Campaigns']"));
		Actions action = new Actions(driver);
		action.moveToElement(campaign).perform();
		Thread.sleep(2000);
//		campaign.click();
		driver.executeScript("arguments[0].click();", campaign);


		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Bootcamp")).click();
		Thread.sleep(5000);

		WebElement fileInput;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
        fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='file']")));
        
		}
		catch(Exception e){
			
			fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		}

        // Alternatively, if the file input is hidden, use JavaScript
        
		driver.executeScript("arguments[0].style.display='block';", fileInput);
        // Specify the path to the file you want to upload
        String filePath = "C:\\Users\\mgoku\\OneDrive\\Desktop\\Evidence.txt";

        // Send the file path to the input element
        fileInput.sendKeys(filePath);
        Thread.sleep(5000);  
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        String actual = driver.findElement(By.xpath("//span[@title='Evidence']")).getText();
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(actual, "Evidence","Attachment not present");
        sAssert.assertAll();		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
}
