package esaTask;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsFrameNestedFrames extends MainBase{
	WebDriver driver;
	WebElement parentFrame;
	WebElement parentFrameTxt;
	WebElement childFrameTxt;
	List<WebElement> iframes;
	
	
	public AlertsFrameNestedFrames(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getParentFrame() {
		return driver.findElement(By.id("frame1"));
	}
	public WebElement getParentFrameTxt() {
		return driver.findElement(By.cssSelector("body"));
	}
	public WebElement getChildFrameTxt() {
		return driver.findElement(By.cssSelector("p"));
	}
	public List<WebElement> getIframes() {
		return driver.findElements(By.tagName("iframe"));
	}
	
	public void changeParentFrametxt(String newText) {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
	    js.executeScript("document.getElementsByTagName('body')[0].innerHTML = '" + newText + "';", getParentFrameTxt());
	}
	public void switchToChildIframe() {
		driver.switchTo().frame(getParentFrame());	
        driver.switchTo().frame(0);
        
	}
	public void changeChildFrameText(String newText) {
	      JavascriptExecutor js = (JavascriptExecutor) driver; 
	      js.executeScript("document.getElementsByTagName('p')[0].innerHTML = '" + newText + "';", getChildFrameTxt());
	}
}
