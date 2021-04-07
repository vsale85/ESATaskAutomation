package esaTask;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PracticeForm {
	WebDriver driver;
	WebElement name;
	WebElement lastName;
	WebElement email;
	List<WebElement> gender;
	WebElement mobileNumber;
	WebElement dateOfBirth;
	WebElement subjects;
	List<WebElement> hobbies;
	WebElement state;
	WebElement city;
	WebElement submit;
	List<WebElement> days;
	WebElement month;
	List<WebElement> months;
	WebElement year;
	List<WebElement> years;

	public PracticeForm(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getName() {
		return driver.findElement(By.id("firstName"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.id("lastName"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.id("userEmail"));
	}

	public List<WebElement> getGender() {
		return driver.findElements(By.cssSelector("label[for^='gender-radio']"));
	}

	public WebElement getMobileNumber() {
		return driver.findElement(By.id("userNumber"));
	}

	public WebElement getDateOfBirth() {
		return driver.findElement(By.id("dateOfBirthInput"));
	}

	public WebElement getSubjects() {
		return driver.findElement(By.id("subjectsContainer"));
	}

	public List<WebElement> getHobbies() {
		return driver.findElements(By.cssSelector("label[for^='hobbies-checkbox']"));
	}

	public WebElement getState() {
		return driver.findElement(By.id("state"));
	}

	public WebElement getCity() {
		return driver.findElement(By.id("city"));
	}

	public List<WebElement> getDays() {
		return driver.findElements(By.cssSelector("div[class^='react-datepicker__day']"));
	}

	public WebElement getMonth() {
		return driver.findElement(By.className("react-datepicker__month-select"));
	}

	public List<WebElement> getMonths() {
		return getMonth().findElements(By.tagName("option"));
	}

	public WebElement getYear() {
		return driver.findElement(By.className("react-datepicker__year-select"));
	}

	public List<WebElement> getYears() {
		return driver.findElements(By.className("react-datepicker__year-select"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.id("submit"));
	}

	public void inputField(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void selectDate(String day, String month, String year) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		getDateOfBirth().click();
		getMonth().click();
		for (int i = 0; i < getMonths().size(); i++) {
			if (getMonths().get(i).getText().equals(month)) {
				getMonths().get(i).click();
				break;
			}
		}
		getYear().click();
		for (int i = 0; i < getYears().size(); i++) {
			if (getYears().get(i).getText().equals(year)) {
				js.executeScript("arguments[0].scrollIntoView();", getYears().get(i));
				break;
			}
		}
		for (int i = 0; i < getDays().size(); i++) {
			if (getDays().get(i).getText().equals(day)) {
				getDays().get(i).click();
				break;
			}
		}

	}

	public void selectGender(String gender) {
		for (int i = 0; i < getGender().size(); i++) {
			if (getGender().get(i).getText().equals(gender)) {
				getGender().get(i).click();
				break;
			}
		}
	}

	public void selectSubjects(String subject) {
		getSubjects().click();
		getSubjects().sendKeys(subject, Keys.ENTER);
	}

	public void selectHobbies(String hobbie) {
		for (int i = 0; i < getHobbies().size(); i++) {
			if (getHobbies().get(i).getText().equals(hobbie)) {
				getHobbies().get(i).click();
				break;
			}
		}
	}

	public void submitForm() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", getSubmit());
		getSubmit().click();
	}

}
