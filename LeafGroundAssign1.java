package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssign1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement drag = driver.findElement(By.xpath("//div[@id='form:conpnl_content']"));
		System.out.println(drag.getLocation());
		Actions builder=new Actions(driver);
		builder.dragAndDropBy(drag, 100, 100).perform();
		System.out.println(drag.getLocation());

	}

}
