package multipleWindows;

import java.time.Duration;
 
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {

	public static void main(String[] args) throws InterruptedException {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	
	 driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
    driver.manage().window().maximize();
    driver.navigate().refresh();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
 String parentWindow=driver.getWindowHandle();
 System.out.println("parent window"+parentWindow);
	 driver.findElement(By.id("newWindowBtn")).click();
	 Set<String>  Handles=driver.getWindowHandles();
	 for (String  Handle :  Handles) {
		System.out.println(Handle);
		
		if(!Handle.equals(parentWindow)) {
			driver.switchTo().window(Handle);
			Thread.sleep(4000);
			driver.manage().window().maximize();
			driver.findElement(By.id("firstName")).sendKeys("sheereesh");
			Thread.sleep(3000);
			driver.close();
		}
		 
	 }
	 
	 driver.switchTo().window(parentWindow);
	 
	 driver.findElement(By.xpath("//input[@id='name']")).sendKeys("I will winnn");
	 Thread.sleep(3000);
	 driver.quit();
	 }
	}
