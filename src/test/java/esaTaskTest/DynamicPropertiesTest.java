package esaTaskTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;

import esaTask.MainBase;

public class DynamicPropertiesTest extends MainBase{
	
	@Test(priority = 1)
	public void textAboveButtons() throws IOException {	
		String groupOpt = reader.getCellData("TS1", 12, 5);	
		String expectedText = reader.getCellData("TS1", 13, 5);
		
		landingPage.clickOnGroupOption(groupOpt);
		assertEquals(dynamicProps.getTextRandomId().getText(), expectedText);
		
	}
	@Test(priority = 2)
	public void enabledAfter5SecButton() throws IOException, InterruptedException {	
		String groupOpt = reader.getCellData("TS1", 15, 5);	
		
		landingPage.clickOnGroupOption(groupOpt);
		assertFalse(dynamicProps.assertBtnEnabled());
		Thread.sleep(5000);
		assertTrue(dynamicProps.assertBtnEnabled());
			
	}
	@Test(priority = 3)
	public void colorChangeBtn() throws IOException, InterruptedException {
		String groupOpt = reader.getCellData("TS1", 19, 5);	
		
		landingPage.clickOnGroupOption(groupOpt);
		assertFalse(dynamicProps.assertColorChange());
		Thread.sleep(5000);
		assertTrue(dynamicProps.assertColorChange());
			
	}
	@Test(priority = 4)
	public void visibleAfter5SecBtn() throws IOException, InterruptedException {
		String groupOpt = reader.getCellData("TS1", 22, 5);	
		
		landingPage.clickOnGroupOption(groupOpt);
		assertTrue(dynamicProps.assertBtnVisible());
		
	}
}
