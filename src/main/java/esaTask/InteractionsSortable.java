package esaTask;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InteractionsSortable {
	WebDriver driver;
	WebElement gridTab;
	WebElement gridContainer;
	List<WebElement> itemsGrid;
	
	public InteractionsSortable(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getGridTab() {
		return driver.findElement(By.id("demo-tab-grid"));
	}
	public WebElement getGridContainer() {
		return driver.findElement(By.className("create-grid"));
	}
	public List<WebElement> getItemsGrid() {
		return getGridContainer().findElements(By.cssSelector("div[class^='list-group-item']"));
	}
	
	public void dragAndDropItems() {	
        Actions act=new Actions(driver);
     
        for (int i = 1; i < getItemsGrid().size(); i++) {
        	act.dragAndDrop(getItemsGrid().get(i), getItemsGrid().get(0)).build().perform();	
		}        
	}
	
}
