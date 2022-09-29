package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement Brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(Brands).perform();
		//driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("(//div[@class='css-ov2o3v']//a)[6]")).click();
		System.out.println(driver.findElement(By.xpath("(//div[@class='css-ov2o3v']//a)[6]")).getText());
		//WebElement paris = driver.findElement(By.xpath("(//div[@class='css-ov2o3v']//a)[3]"));
		//paris.click();
		//System.out.println(paris.getText());
		//driver.findElement(By.className("arrow-icon")).click();
		//driver.findElement(By.className("control-indicator radio ")).click();
		WebElement hair = driver.findElement(By.xpath("//a[text()='hair']"));
		Actions builder1=new Actions(driver);
		builder1.moveToElement(hair).perform();
		driver.findElement(By.xpath("(//a[text()='Shampoo'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']")).click();
		driver.findElement(By.xpath("(//div[@class='css-xrzmfa'])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String>lstwindow2=new ArrayList<String>(windowHandles2);
		driver.switchTo().window(lstwindow2.get(2));
		WebElement MRP = driver.findElement(By.xpath("//span[@class='css-1jczs19']"));
		System.out.println(MRP.getText());
		driver.findElement(By.xpath("(//span[@class='btn-text'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		driver.switchTo().frame(0);
		WebElement grandtotal = driver.findElement(By.xpath("//span[@class='css-n8gwxi e171rb9k3']"));
		System.out.println(grandtotal.getText());
		WebElement proceed = driver.findElement(By.xpath("(//button[@class='css-11o9a27 e8tshxd0'])[2]"));
		Actions builder2=new Actions(driver);
		builder2.moveToElement(proceed).click().perform();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String>lstwindow3=new ArrayList<String>(windowHandles3);
		driver.switchTo().window(lstwindow3.get(3));
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		WebElement grandtotal2 = driver.findElement(By.xpath("(//div[@class='value'])[2]"));
		System.out.println(grandtotal2.getText());
		
	}

}
