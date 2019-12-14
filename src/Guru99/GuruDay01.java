package Guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.AlertHandler;

import org.openqa.selenium.Alert;

public class GuruDay01 {
	 public static void main(String[] args) throws InterruptedException, ElementClickInterceptedException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    String baseUrl = "https://freemp3downloads.online/";
	    
	    driver.get(baseUrl);
	    Thread.sleep(3000);
	    
	    //driver.switchTo().alert().accept(); 
	    
	    WebElement url = driver.findElement(By.name("url"));
	    url.sendKeys("https://www.youtube.com/watch?v=_vvvSyBNiHc");
	    Thread.sleep(3000);
	    //driver.switchTo().alert().dismiss(); 

	    //driver.findElement(By.name("password")).sendKeys("emuqyme");
	    //driver.findElement(By.xpath("//*[@id=\"go\"]/div/div[2]/button")).click();
	    url.submit();
	    
	    driver.findElement(By.xpath("/html/body/section/div/div[1]/div[2]/ul/li[2]/a")).click();
	    
	    //WebElement kbps = driver.findElement(By.name("quality"));
	    Select kbps = new Select(driver.findElement(By.name("quality")));
	    kbps.selectByVisibleText("192 kbps");
	    
	    try{
	    driver.findElement(By.id("cvt-btn")).click();
	    
	    }catch(ElementClickInterceptedException e){
	    	
	    	 Thread.sleep(10000);
	    }
	    try{
	    	 Thread.sleep(10000);
	    	 driver.findElement(By.id("cvt-btn")).click();
	    }
	    catch(Exception e) {
	    	 Thread.sleep(10000);
	    }
	    Thread.sleep(10000);
   	 	driver.findElement(By.id("cvt-btn")).click();
	    WebElement dl = driver.findElement(By.xpath("//*[@id=\"dl-btn\"]"));
	    dl.click();
	 }
}




