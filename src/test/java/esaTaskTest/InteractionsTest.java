package esaTaskTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import esaTask.MainBase;

public class InteractionsTest extends MainBase{

	@Test
	public void dragDropInDescendingOrder() throws IOException {
		String group = reader.getCellData("TS4", 4, 5);	
		String groupOpt = reader.getCellData("TS4", 5, 5);	
		landingPage.clickOnMainGroup(group);
		landingPage.clickOnGroupOption(groupOpt);
		
		interactions.getGridTab().click();
		interactions.dragAndDropItems();
		File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("screenshots/interactionsGridSortable.png"));
	}
}
