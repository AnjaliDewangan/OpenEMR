package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientDashboard {
	private By frame = By.xpath("//iframe[@name='pat']");
	private By dashboard = By.xpath("//h2[contains(text(),'Medical Record')]");
	protected WebDriver driver;

	public PatientDashboard(WebDriver driver) {
		this.driver = driver;
	}

	public void swicthToFrame() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(frame));
	}

	public String patientDashboard() {
		return driver.findElement(dashboard).getText().trim();
	}
}
