package com.Monster.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Monster.Pages.HomePage;

import Helper.BrowseFactory;

public class HomePageEntry {

	
	@Test
	public void  enterDetailsAtHomePage()
	{
		
		
		WebDriver driver=BrowseFactory.getBrowserName("Chrome", "https://www.monsterindia.com/");
		
		HomePage page1=PageFactory.initElements(driver, HomePage.class);
		page1.enterJobDetails("Java", "Bangalore");
	//	String content1 = "All Latest Jobs";
	//	Assert.assertEquals(page1.latestJobsContent.getText(), content1);
	//	Reporter.log("assertion done");
		
	
		
	}
	
	
}
