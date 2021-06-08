package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientFinderPage {
	private String finFrameName="fin";
	private By addNewPatientLocator = By.id("create_patient_btn1");
	

	private WebDriver driver;
	
	public PatientFinderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void switchToFinFrame()
	{
		driver.switchTo().frame(finFrameName);
	}
	
	public void clickOnAddNewPatient()
	{
		driver.findElement(addNewPatientLocator).click();
	}
	
	public void switchOutOfFrame()
	{
		driver.switchTo().defaultContent();
	}
}
