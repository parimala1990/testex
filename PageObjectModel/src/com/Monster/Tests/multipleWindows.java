package com.Monster.Tests;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class multipleWindows {
	
	@Test
	//public static void main(String[] args) throws InterruptedException, IOException {
	
	public void methodSample() throws InterruptedException
	{
		
				
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chrome\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.naukri.com");
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				
		
				String parentWindow=driver.getWindowHandle();
				Set<String>windowsMultpile=driver.getWindowHandles();
				System.out.println(windowsMultpile.size());
				String title1=driver.getTitle();
				System.out.println(title1);
				Iterator<String> iter =windowsMultpile.iterator();
				while(iter.hasNext())
				{
					System.out.println(iter);
					String childWindow=iter.next();
					if(!parentWindow.equals(childWindow))
					{
						driver.switchTo().window(childWindow);
						String title2=driver.getTitle();
						System.out.println("child windows are "+title2);
						driver.close();
					}
				}
				driver.switchTo().window(parentWindow);
				Thread.sleep(10000);
				//Alert action=driver.switchTo().alert();		
				//action.dismiss();
				
				try {
							WebElement popup1=driver.findElement(By.xpath("//div[contains(@class,'userPrompt animate')]//following::span[text()='Later']"));
							popup1.click();
							System.out.println("pop up is present and closed");
					}
				catch(NoSuchElementException e)
				{
					System.out.println("no elelement found");
				
				}
				
				//scroll down the page
				JavascriptExecutor  js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,300)");
				
				driver.findElement(By.xpath("//a[text()='LatentView Analytics Pvt Ltd.']")).click();
				String firstWindow=driver.getWindowHandle();
				Set<String> allWindows=driver.getWindowHandles();
				Iterator<String>iter2= allWindows.iterator();
				while(iter2.hasNext())
				{
					String newWindow=iter2.next();
					if(!firstWindow.equals(newWindow)) {
							driver.switchTo().window(newWindow);
							String newTitle=driver.getTitle();
							Assert.assertEquals(newTitle, "LatentView Analytics Jobs - Career Opportunities in LatentView Analytics - Naukri.com", "title not found");
							driver.findElement(By.xpath("//span[text()='Jobs']//ancestor::li[contains(@class, 'menu-item-top-level-3')]//a")).click();
							System.out.println("navigated to new window");
							driver.findElement(By.xpath("//input[@placeholder='Keyskills, Designation' and @type='text']")).sendKeys("java",Keys.TAB);
							driver.findElement(By.xpath("//input[@placeholder='Desired Location' and @type='text']")).sendKeys("Bangalore", Keys.TAB);
							driver.findElement(By.xpath("//a[@data-id='experience_4']")).click();
							driver.findElement(By.xpath("//input[@placeholder='Min Salary' and @type='text']")).click();
							driver.findElement(By.xpath("//a[@data-id='minSalary_3']")).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@placeholder='Max Salary' and @type='text']")).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath("//a[@data-id='maxSalary_9']")).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();
					
							
						//	screenShot.screenshotMethod (driver,"C:\\Selenium\\new.png");
							 
					}
				}
				
				driver.switchTo().defaultContent();
				System.out.println("pop up closed");
				driver.quit();
				
			
				}
				
				
			

		

	}


