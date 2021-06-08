package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	private By usernameLocator = By.id("authUser");
	private By passwordLocator=By.id("clearPass");
	private By lanaguageLocator=By.name("languageChoice");
	private By loginLocator=By.xpath("//button[@type='submit']");
	private By errorLocator=By.xpath("//div[contains(text(),'Invalid')]");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void sendUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void sendPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public void selectLanguageByText(String langaugeText)
	{
		Select selectLanguage = new Select(driver.findElement(lanaguageLocator));
		selectLanguage.selectByVisibleText(langaugeText);
	}
	
	public void clickOnLogin()
	{
		driver.findElement(loginLocator).click();
	}
	
	//getErrorMessage()
	public String getErrorMessage()
	{
		return driver.findElement(errorLocator).getText().trim();
	}

}



