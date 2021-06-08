package com.cyient.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.AddNewPatient;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;
import com.cyient.page.PatientDashboard;
import com.cyient.page.PatientFinderPage;

public class PatientTest extends WebDriverWrapper {

	@Test
	public void addPatientTest() throws InterruptedException {
		
		LoginPage login=new LoginPage(driver);
		login.sendUsername("admin");
		login.sendPassword("pass");
		login.selectLanguageByText("English (Indian)");
		login.clickOnLogin();

		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.mousehoverOnPatientClient();
		dashboard.clickOnPatients();
		
		PatientFinderPage patientFinder=new PatientFinderPage(driver);
		patientFinder.switchToFinFrame();
		patientFinder.clickOnAddNewPatient();
		patientFinder.switchOutOfFrame();
		
		AddNewPatient patient = new AddNewPatient(driver);
		patient.switchToFrame();
		patient.selectAppellation("Ms.");
		patient.enterFirstName("Anjali");
		patient.enterLastName("Anji");
		patient.selectDOB("2021-06-09");
		patient.selectGender("Female");
		patient.createNewPatient();
		patient.switchBackToFrame();
		patient.switchToConfirmFrame();
		patient.confirmCreateNewPatient();
		Thread.sleep(1000);
		
//		String alertText = patient.printAlertText();
//		Thread.sleep(1000);
//		patient.handleAlert();

		PatientDashboard dash = new PatientDashboard(driver);
		dash.swicthToFrame();
		String patientsLocator = dash.patientDashboard();
		System.out.println(patientsLocator);

		//Assert.assertTrue(alertText.contains("New Due Clinical Remainders")); // must be true
		Assert.assertEquals(patientsLocator, "Medical Record Dashboard - Anjali Anji"); // must be Medical Record Dashboard - Anjali Anji															
	}

}
