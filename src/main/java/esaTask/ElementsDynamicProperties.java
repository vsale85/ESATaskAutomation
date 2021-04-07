package esaTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ElementsDynamicProperties {
	WebDriver driver;
	WebElement textRandomId;
	WebElement enabledBtn;
	WebElement colorChangeBtn;
	WebElement visibleBtn;
	
	public ElementsDynamicProperties(WebDriver driver) {
		super();
		this.driver = driver;
	}
	// getters
	public WebElement getTextRandomId() {
		return driver.findElement(By.xpath("//p[contains(text(),'This text has')]"));
	}

	public WebElement getEnabledBtn() {
		return driver.findElement(By.id("enableAfter"));
	}
	
	public WebElement getColorChangeBtn() {
		return driver.findElement(By.id("colorChange"));
	}
	public WebElement getVisibleBtn() {
		return driver.findElement(By.id("visibleAfter"));
	}
	
	// methods
	public boolean assertBtnEnabled() {
		if (getEnabledBtn().isEnabled()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean assertColorChange() {
		if(getColorChangeBtn().getAttribute("class").contains("text-danger")) {
			return true;
		}else {
			return false;
		}			
	}
	
	public boolean assertBtnVisible() throws InterruptedException {
		Actions action = new Actions(driver);	
		action.moveToElement(getVisibleBtn()).perform();
		String invisible = getVisibleBtn().getCssValue("background-color");
		Thread.sleep(5000);
		action.moveToElement(getColorChangeBtn()).perform();
		String visible = getVisibleBtn().getCssValue("background-color");
		if (!invisible.equals(visible)) {
			return true;
		}else {
			return false;
		}		
	}
}
