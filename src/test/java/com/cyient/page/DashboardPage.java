package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {
	
	private By patientClientLocator=By.xpath("//div[text()='Patient/Client']");
	private By patientsLocator=By.xpath("//div[text()='Patients']");

	private WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getDashboardPageTitle()
	{
		return driver.getTitle().trim();
	}
	
	
	public void mousehoverOnPatientClient()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(patientClientLocator)).perform();
	}
	
	public void clickOnPatients()
	{
		driver.findElement(patientsLocator).click();
	}

}
