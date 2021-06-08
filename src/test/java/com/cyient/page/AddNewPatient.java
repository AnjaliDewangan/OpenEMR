package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewPatient {
	private By frameLocator = By.xpath("//iframe[@name='pat']");
	private By appellationLocator = By.id("form_title");
	private By firstnameLocator = By.id("form_fname");
	private By surnameLocator = By.id("form_lname");
	private By DOBLocator = By.id("form_DOB");
	private By genderLocator = By.id("form_sex");
	private By createNewPatientLocator = By.id("create");
	private By backFrameLocator = By.xpath("//iframe[@id='modalframe']");
	private By confirmCreateNewPatientLocator = By.xpath("//input[@value='Confirm Create New Patient']");
	private By alertLocator = By.xpath("//div[@class='closeDlgIframe']");

	protected WebDriver driver;

	public AddNewPatient(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToFrame() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(frameLocator));
	}

	public void selectAppellation(String prefix) {
		Select assign = new Select(driver.findElement(appellationLocator));
		assign.selectByVisibleText(prefix);
	}

	public void enterFirstName(String name) {
		driver.findElement(firstnameLocator).sendKeys(name);
	}

	public void enterLastName(String name) {
		driver.findElement(surnameLocator).sendKeys(name);
	}

	public void selectDOB(String date) {
		driver.findElement(DOBLocator).sendKeys(date);
	}

	public void selectGender(String identity) {
		Select gender = new Select(driver.findElement(genderLocator));
		gender.selectByVisibleText(identity);
	}

	public void createNewPatient() {
		driver.findElement(createNewPatientLocator).click();
	}

	public void switchBackToFrame() {
		driver.switchTo().defaultContent();
	}

	public void switchToConfirmFrame() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(backFrameLocator));
	}

	public void confirmCreateNewPatient() {
		driver.findElement(confirmCreateNewPatientLocator).click();
		driver.switchTo().defaultContent();
	}

//	public String printAlertText() throws InterruptedException {
//		Thread.sleep(1000);
//		driver.switchTo().alert().getText();
//	}
//
	public void handleAlert() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		driver.findElement(alertLocator).click();
	}

}
