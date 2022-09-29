package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentSix4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']//li[1]"));
		//WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']//li[2]"));
		//WebElement item3 = driver.findElement(By.xpath("//ul[@id='sortable']//li[3]"));
		WebElement item4 = driver.findElement(By.xpath("//ul[@id='sortable']//li[4]"));
		System.out.println("Clicked "+item1.getLocation());
		Actions builder=new Actions(driver);
		builder.clickAndHold(item4).dragAndDrop(item4, item1).perform();
		//builder.dragAndDrop(item1, item4).perform();
		//builder.click(item1).click(item2).click(item3).click(item4).perform();
		System.out.println("Clicked "+item1.getLocation());
		//System.out.println("Clicked "+item2.getText());
		//System.out.println("Clicked "+item3.getText());
		//System.out.println("Clicked "+item4.getText());
	}

}
