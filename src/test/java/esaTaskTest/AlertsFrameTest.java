package esaTaskTest;

import static org.testng.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import esaTask.MainBase;

public class AlertsFrameTest extends MainBase{

	@Test(priority = 1)
	public void parentFrameActiveCheck() throws IOException, InterruptedException {
		String group = reader.getCellData("TS3", 4, 5);	
		String groupOpt = reader.getCellData("TS3", 5, 5);	
		String newText = reader.getCellData("TS3", 6, 5);
		landingPage.clickOnMainGroup(group);
		landingPage.clickOnGroupOption(groupOpt);
		
		driver.switchTo().frame(alertsFrames.getParentFrame());	
		String oldText = alertsFrames.getParentFrameTxt().getText();
	    alertsFrames.changeParentFrametxt(newText);
	    File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("screenshots/parentFrameActive.png"));
	    driver.switchTo().defaultContent();
	    
	    assertNotEquals(oldText, newText);
	}
	@Test(priority = 2)
	public void childFrameActiveCheck() throws IOException, InterruptedException {
		String group = reader.getCellData("TS3", 4, 5);	
		String groupOpt = reader.getCellData("TS3", 5, 5);	
		String newText = reader.getCellData("TS3", 9, 5);
		landingPage.clickOnMainGroup(group);
		landingPage.clickOnGroupOption(groupOpt);
		
		
		alertsFrames.switchToChildIframe();		
		String oldText = alertsFrames.getChildFrameTxt().getText();
	    alertsFrames.changeChildFrameText(newText);
	    File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("screenshots/childFrameActive.png"));
	    driver.switchTo().defaultContent();	    
	    assertNotEquals(oldText, newText);
	}
}
