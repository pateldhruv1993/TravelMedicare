package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.TestUtil;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;

	public Testbase() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					"C:\\Users\\DhruvPC\\eclipse-workspace\\TravelMedicare\\src\\main\\java\\Environment\\config.properties");
			prop.load(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initiate() {

		// read properties from config file
		String Browsername = prop.getProperty("browser");
		/*
		 * if (Browsername=="Firefox") { System.setProperty("webdriver.gecko.driver",
		 * "geckodriver.exe"); driver=new FirefoxDriver(); } else
		 * if(Browsername=="Chrome") { //System.setProperty("webdriver.chrome.driver",
		 * "chromedriver.exe"); driver=new ChromeDriver();
		 */

		// }
		System.setProperty("webdriver.gecko.driver", "H:\\SeleniumWebDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize(); // we will specify common features
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implict_wait, TimeUnit.SECONDS);// time can be changes
																							// according to page, so we
																							// will put static variable
																							// in testutil.java class
		driver.get(prop.getProperty("url")); // prop is defined at global level so we can use it anywhere

	}

}