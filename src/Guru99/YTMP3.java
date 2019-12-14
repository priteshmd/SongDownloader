package Guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class YTMP3 {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		String baseUrl = "https://ytmp3.cc/en/";	    
	    driver.get(baseUrl);
		Thread.sleep(3000);
		String songUrl = "https://www.youtube.com/watch?v=Pkh8UtuejGw";
		WebElement url = driver.findElement(By.id("input"));
	    url.sendKeys(songUrl);
	    url.submit();
	    
	    Thread.sleep(2000);
	//    driver.switchTo().alert().dismiss();
	    driver.findElement(By.partialLinkText("Download")).click();
	    Thread.sleep(2000);

	}

}
