package week4.day2;

import java.io.File;  
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ChromeDriver driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement men = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(men).perform();
		driver.findElement(By.xpath("//span[@class='linkTest']")).click();
		WebElement count = driver.findElement(By.xpath("//div[@class='child-cat-count ']"));
		System.out.println(count.getText());
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		System.out.println(prices.size());
		String text = driver.findElement(By.xpath("//span[@class='lfloat product-price']")).getText();
		for (int i = 0; i < prices.size(); i++) {
			
			System.out.println(text);
		}
		WebElement from = driver.findElement(By.xpath("//input[@name='fromVal']"));
		from.clear();
		from.sendKeys("900");
		WebElement to = driver.findElement(By.xpath("//input[@name='toVal']"));
		to.clear();
		to.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();
		driver.findElement(By.xpath("//span[@class='filter-color-tile Yellow ']")).click();
		WebElement image = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		Actions builder1=new Actions(driver);
		builder1.moveToElement(image).perform();
		driver.findElement(By.xpath("//img[@class='product-image wooble']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		WebElement mrp = driver.findElement(By.xpath("//span[@class='pdp-final-price']"));
		System.out.println(mrp.getText());
		WebElement percentage = driver.findElement(By.xpath("//span[@class='pdpDiscount ']"));
		System.out.println(percentage.getText());
		File snapshot = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps1/snapshot.png");
		FileUtils.copyFile(snapshot, dest);
		
		
	}

}
