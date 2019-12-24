package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MyQuote;
import Pages.Login;
public class MyQuoteTest extends MyQuote{

	MyQuote Quote; // declared Contact us reference at class level so that we can use it throughout
	Login Log;
						// the class

	public MyQuoteTest() {
	super();//to call parent class/super class constructor we write super keyword,
	
	//this will call properties from testbase class.
	}
	
	@BeforeClass
	public void loginBeforeTests() {
		Log.loginWith(prop.getProperty("email"), prop.getProperty("password"));
	}

	@BeforeMethod
	public void setprop() {
		initiate();// First with super keyword it will call properties like System.setproperty and
					// then will switch to initiate method()
		
		initPageElements();
		Quote = new MyQuote(); // Assigned it to Contact_us object 
		System.out.println("tried to login");
	}

	@Test(priority = 1)
	public void selectRole() {
		Quote.selectRole("AGA");
		Quote.submit();
	}

	@Test(priority = 2)
	public void selectUser() {
		Quote.selectRole("AGA");
		Quote.submit();
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
