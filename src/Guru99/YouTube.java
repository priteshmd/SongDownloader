package Guru99;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class YouTube extends StringExample {

	@SuppressWarnings("null")
	public static void main(String[] args) throws InterruptedException{

		//To run headless:
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		/*System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); */
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Enter the Film/Artist name:");
		String inputText = myObj.nextLine();
		
		System.out.println("Enter the Song name:");
		String songName = myObj.nextLine();
		
		//String inputText = "Camila Cabello";
		//String songName = "Senorita";
		
		String songName1 = songName.toLowerCase();
		String songName2 = songName.toUpperCase();
		String songName3 = titleCaseConversion(songName);
		
		System.out.println(songName3);
		
		if(inputText != "" && songName != "")
		{
			driver.get("https://www.youtube.com");
			WebElement textBox = driver.findElement(By.id("search"));
			textBox.sendKeys(inputText);
			
			driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]")).click();
			Thread.sleep(3000);
			driver.manage().window().maximize();
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement s1 = null;
			int i,j=0;
			for(j = 0; j<=3; j++)
			{
				i = 0;
				switch(i)				
				{
				case 0:
					try{
					if(driver.findElement(By.partialLinkText(songName)) != null) {
						s1 = driver.findElement(By.partialLinkText(songName));
						break;
				
					}}catch(Exception e){
						System.out.println("NoSuchElementException1");
						i++;
					}						
										
					
				case 1:
					try{
					if(driver.findElement(By.partialLinkText(songName2)) != null) {
						s1 = driver.findElement(By.partialLinkText(songName2));
						break;
						
					}}catch(Exception e){
						System.out.println("NoSuchElementException2");
						i++;
					}	
					
					
				case 2:
					try{
					if(driver.findElement(By.partialLinkText(songName3)) != null) {
						
						s1 = driver.findElement(By.partialLinkText(songName3));
						break;
						
					}}catch(Exception e){
						System.out.println("NoSuchElementException3");
						i++;
					}		
					
					
				default:
					try{
					if(driver.findElement(By.partialLinkText(songName1)) != null) {
						s1 = driver.findElement(By.partialLinkText(songName1));
						break;
					}}catch(Exception e){
						System.out.println("NoSuchElementException..");
						
					}		
					
					if(j >=3) {
						System.out.println("entered song not found...quitting");
						driver.close();	
						
					}
					else {
							System.out.println("entered song not found!!!.....Trying again!");
							js.executeScript("window.scrollBy(0,4000)");
							Thread.sleep(10000);
					}
					break;
				}
				
			}
			if(s1 != null)
			{
			
			String songUrl = s1.getAttribute("href");
			System.out.println(songUrl);
			String baseUrl = "https://ytmp3.cc/en/";
		    
		    driver.get(baseUrl);
	
				Thread.sleep(3000);
	
		    //driver.switchTo().alert().dismiss();
	
		    WebElement url = driver.findElement(By.id("input"));
		    url.sendKeys(songUrl);
		    url.submit();
	
			Thread.sleep(3000);
			//driver.switchTo().alert().dismiss();
		    try{
		    driver.findElement(By.partialLinkText("Download")).click();
		    //driver.switchTo().
		    System.out.println("Download has started....!!!!!");
		    
		    Thread.sleep(3000);
		    
		    }
		    catch(Exception e)
		    {
		    	System.out.println("entered song not found OR song cannot be downloaded!!!");
		    	driver.quit();
		    }
		    
		}
			
		}
		
		else{
		System.out.println("Please enter a valid song/artist name!!!");
    	driver.quit();
		
		}
		
		
		
		
		
		
		
		
		

	}



}
