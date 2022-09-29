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

public class Assignment5 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement men = driver.findElement(By.xpath("//a[@class='desktop-main']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(men).perform();
		driver.findElement(By.xpath("//a[@href='/men-jackets']")).click();
		String jackets = driver.findElement(By.className("title-count")).getText();
		System.out.println("Total number of jackets: "+jackets);
		String matches = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		System.out.println("Sum of categories count matches: "+matches);
		driver.findElement(By.className("brand-more")).click();
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
		driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div")).click();
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
		Thread.sleep(3000);
		List<WebElement> brand = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']//h3"));
		for (int i = 0; i < brand.size(); i++) {
			String name = driver.findElement(By.xpath("//div[@class='product-productMetaInfo']//h3")).getText();
			System.out.println(name);
			//System.out.println(brand);
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='50% and above']")).click();
		String price = driver.findElement(By.className("product-discountedPrice")).getText();
		System.out.println("Price of the first product: "+price);
		driver.findElement(By.xpath("//picture[@class='img-responsive']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/myntra.png");
		FileUtils.copyFile(screenshotAs, dest);
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite pdp-notWishlistedIcon')]")).click();
		
	}

}
