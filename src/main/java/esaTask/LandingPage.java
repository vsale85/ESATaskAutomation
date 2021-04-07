package esaTask;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;
	List<WebElement> mainGroups;
	List<WebElement> groupOptions; 
	WebElement pageHeader;
	
	public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public List<WebElement> getMainGroups() {
		return driver.findElements(By.className("header-text"));
	}

	public List<WebElement> getGroupOptions() {
		return driver.findElements(By.className("text"));
	}
	
	public WebElement getPageHeader() {
		return driver.findElement(By.className("main-header"));
	}

	public void clickOnMainGroup(String group) {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		for (int i = 0; i < getMainGroups().size(); i++) {
			if (getMainGroups().get(i).getText().equals(group)) {
				js.executeScript("arguments[0].scrollIntoView();", getMainGroups().get(i));
				getMainGroups().get(i).click();
			}
		}
	}
	
	public void clickOnGroupOption(String groupOpt) {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		for (int i = 0; i < getGroupOptions().size(); i++) {			
			if (getGroupOptions().get(i).getText().equals(groupOpt)) {
				js.executeScript("arguments[0].scrollIntoView();", getGroupOptions().get(i));
				getGroupOptions().get(i).click();
			}
		}
	}
	
	public boolean assertGroupOptOpen(String groupOpt) {
		if (getPageHeader().getText().equals(groupOpt)) {
			return true;
		}else {
			return false;
		}
	}
	
}
