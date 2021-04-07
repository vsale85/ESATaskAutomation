package esaTaskTest;

import static org.testng.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import esaTask.MainBase;

public class PracticeFormTest extends MainBase{
	String testSuite2 = "ts2";
	
	@Test(priority = 1)
	public void validFormSubmit() throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		landingPage.clickOnMainGroup(reader.getCellData(testSuite2, 4, 5));// group
		landingPage.clickOnGroupOption(reader.getCellData(testSuite2, 5, 5));// group option
		
		practiceForm.inputField(practiceForm.getName(), reader.getCellData(testSuite2, 6, 5));
		practiceForm.inputField(practiceForm.getLastName(), reader.getCellData(testSuite2, 7, 5));
		practiceForm.inputField(practiceForm.getEmail(), reader.getCellData(testSuite2, 8, 5));
		practiceForm.selectGender(reader.getCellData(testSuite2, 9, 5));
		practiceForm.inputField(practiceForm.getMobileNumber(), reader.getCellData(testSuite2, 10, 5));
		practiceForm.selectHobbies(reader.getCellData(testSuite2, 14, 5));
		practiceForm.selectHobbies(reader.getCellData(testSuite2, 15, 5));
		practiceForm.submitForm();
	}
	
	@Test(priority = 2)
	public void emptyFormSubmit() throws IOException, InterruptedException {
		System.out.println(reader.getCellData("TS2", 4, 5));
		landingPage.clickOnMainGroup(reader.getCellData("TS2", 4, 5));// group
		System.out.println(reader.getCellData("TS2", 5, 5));
		landingPage.clickOnGroupOption(reader.getCellData("TS2", 5, 5));// group option
		
		practiceForm.submitForm();
	}
	
	@Test(priority = 3)
	public void vali() throws IOException, InterruptedException {
		System.out.println(reader.getCellData("TS2", 4, 5));
		landingPage.clickOnMainGroup(reader.getCellData("TS2", 4, 5));// group
		System.out.println(reader.getCellData("TS2", 5, 5));
		landingPage.clickOnGroupOption(reader.getCellData("TS2", 5, 5));// group option
		
		
		
		practiceForm.submitForm();
	}
}
