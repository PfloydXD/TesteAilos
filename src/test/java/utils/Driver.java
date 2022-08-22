package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	public WebDriver Webdriver() {
		System.setProperty("webdriver.chrome.driver", "E:/Projects/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
	    driver.manage().window().maximize();
	    return driver;
	}
	
}
