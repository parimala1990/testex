package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowseFactory {
			
				static WebDriver driver;
				
				public static WebDriver getBrowserName(String browserName ,String url)
				{
					
					if(browserName.equalsIgnoreCase("FireFox"))
					{
						driver = new FirefoxDriver();
					}
					
					if(browserName.equalsIgnoreCase("Chrome"))
					{
						System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chrome\\chromedriver.exe");
						driver  = new ChromeDriver();
					}
					driver.manage().window().maximize();
					driver.get(url);
					return driver;
				}
				
				
}
