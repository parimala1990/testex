package com.Monster.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how=How.XPATH, using="//input[@type='text' and @id='fts_id']")
	WebElement jobTitleBar;
	
	@FindBy(how=How.XPATH,using="//a[@data-value='selExp' and @data-id='3']")
	WebElement yearsOfExperience;
	
	@FindBy(how=How.ID,using="selExp")
	WebElement exp;
	
	
	@FindBy(how=How.XPATH,using="//input[@type='text' and @placeholder='Location']")
	WebElement jobLocation;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit' and @value='Search']")
	WebElement searchButton;
	
	
	@FindBy(how=How.XPATH,using="//h1[text()='All Latest Jobs']")
	public
	WebElement latestJobsContent;

	
	
	public void enterJobDetails(String jobTitle,  String Location)
	{
			
		jobTitleBar.sendKeys(jobTitle);
		//yearsOfExperience.sendKeys(years,Keys.TAB);
		exp.click();
		yearsOfExperience.click();
		jobLocation.sendKeys(Location,Keys.TAB);
		searchButton.click();
		
		
	}
	
	
	
	
	
	
	
}

