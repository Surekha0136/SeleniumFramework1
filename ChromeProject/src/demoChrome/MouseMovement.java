package demoChrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    
    driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html.26146");
    
    driver.manage().window().maximize();
    
    Actions action = new Actions(driver);
    
    action.moveToElement(driver.findElement(By.className("menulink"))).build().perform();
    
    Thread.sleep(3000);
    
    driver.findElement(By.xpath("//ul[@class='submenu']//li//a[text()='Articles']")).click();
    
    
    
	}

}
