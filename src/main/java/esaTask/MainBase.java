package esaTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class MainBase {
	public WebDriver driver;
	public LandingPage landingPage;
	public ExcelReader reader;
	public ElementsDynamicProperties dynamicProps;
	public AlertsFrameNestedFrames alertsFrames;
	public InteractionsSortable interactions;
	public PracticeForm practiceForm;

	public Properties getProperties() throws IOException {
		File dataFile = new File("data/data.properties");
		String absolutePathToData = dataFile.getAbsolutePath();
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(absolutePathToData);
		properties.load(fis);
		return properties;
	}

	public WebDriver initializeDriver() throws IOException {
		String browserName = getProperties().getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}
	@BeforeClass
	public void beforeClass() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		reader = new ExcelReader("data/TestPlan.xlsx");
		dynamicProps = new ElementsDynamicProperties(driver);
		alertsFrames = new AlertsFrameNestedFrames(driver);
		interactions = new InteractionsSortable(driver);
		practiceForm = new PracticeForm(driver);
	}
	@BeforeMethod
	public void goToLandingPage() throws IOException {
		driver.get(getProperties().getProperty("url"));
	}
	@AfterClass
	public void closeAll() throws  IOException, InterruptedException {
		Thread.sleep(5000);
		reader.closeFis();
		driver.quit();
	}
}
