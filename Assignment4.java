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

public class Assignment4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ChromeDriver driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(price);
		String ratings = driver.findElement(By.xpath("(//a[contains(@class,'a-link-normal s-underline-text s')])[3]")).getText();
		System.out.println(ratings);
		WebElement star = driver.findElement(By.xpath("//i[contains(@class,'a-icon a-icon-star-small')]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(star).click().perform();
		Thread.sleep(50000);
		String percent = driver.findElement(By.xpath("//table[@id='histogramTable']/tbody[1]/tr[1]/td[3]/span[2]/a[1]")).getText();
		System.out.println(percent);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/amazon.png");
		FileUtils.copyFile(screenshotAs, dest);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		String grandtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println(grandtotal);
		if(price==grandtotal) {
			System.out.println("Grand Total Verified");
		}
	}

}
