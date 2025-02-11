package practise;

/*
 * https://www.cheapoair.com/
 *1. Select one way trip
 *2. Select Destination
 *3. Select Travel date
 *4. Select 2 adults & Click on Done
 *5. Click search Flights
 *6. Write a logic to find the lowest price and Select the lowest price flight
 * 
 */

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CheapOAir {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.cheapoair.com/");

		//driver.findElement(By.id("onewayTrip")).click();
		driver.findElement(By.xpath("//label[text()='One Way']")).click();
		driver.findElement(By.xpath("//input[@id='from0']/following-sibling::a")).click();
		driver.findElement(By.xpath("//input[@id='from0']")).sendKeys("MAA",Keys.TAB);
		driver.findElement(By.xpath("//input[@id='to0']/following-sibling::a")).click();
		driver.findElement(By.xpath("//input[@id='to0']")).sendKeys("BLR",Keys.TAB);
		driver.findElement(By.xpath("//input[@id='cal0']")).click();
		driver.findElement(By.xpath("//a[@class=' month-date is--today']")).click();

		driver.findElement(By.xpath("//div[text()='Traveler']")).click();
		driver.findElement(By.id("addadults")).click();
		driver.findElement(By.id("closeDialog")).click();
		driver.findElement(By.id("searchNow")).click();

		List<WebElement> allElements = driver.findElements(By.xpath("//span[@class='currency text-nowrap']"));
		List<Double> allPrice = new ArrayList<Double>();
		for (WebElement eachEle : allElements) {
			String priceInString = eachEle.getAttribute("title");
			double priceInDouble = Double.parseDouble(priceInString);
			allPrice.add(priceInDouble);
		}

		Collections.sort(allPrice); // Write a logic to find the least price
		Double least = allPrice.get(0);

		driver.findElement(By.xpath("//span[contains(@title,'" + least + "')]/following::span[text()='Select']"))
				.click();

	}

}


