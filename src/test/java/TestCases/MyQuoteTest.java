package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
	
	@BeforeTest
	public void loginBeforeTests() {
		
	}

	@BeforeMethod
	public void setprop() throws InterruptedException {
		initiate();// First with super keyword it will call properties like System.setproperty and
					// then will switch to initiate method()
		Log = new Login();
		Log.loginWith(prop.getProperty("email"), prop.getProperty("password"));
		driver.navigate().to("https://www.travelmedicare.com/myquote");


		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		
		Quote = new MyQuote(); // Assigned it to Contact_us object 
		initPageElements();
		System.out.println("tried to login");
	}

	
	@Test(priority = 1)
	public void defaultSearch(){
		Quote.submit();
		if(!initTableElements()) {
			Assert.fail("No results were found on defaultSearch which is obviously wrong?!?!");
		}
	}
	
	@Test(priority = 2)
	public void selectRole() {
		String roleName = "MGA";
		Quote.selectRole(roleName);
		Quote.submit();
		
		if(initTableElements()) {
			for(int i = 0; i < tableData[0].length; i++) {
				System.out.println(tableData[1][i].getText());
				assertEquals(tableData[1][i].getText(), roleName);
			}
		} else {
			Assert.fail("No data found in table - SelectRole");
		}
		
	}

	
	@Test(priority = 3)
	public void selectUser() {
		String usersName = "";
		Quote.selectUser(usersName);
		Quote.submit();
		
		if(initTableElements()) {
			for(int i = 0; i < tableData[0].length; i++) {
				System.out.println(tableData[0][i].getText());
				assertEquals(tableData[0][i].getText(), usersName);
			}
		}
		initTableElements();
	}
	
	
	
	@Test(priority = 4)
	public void selectFromDate() {
		String fromDate = "2019-04-12";		  
		Quote.fromDate(fromDate);
		Quote.submit();
		
		
		
	}
	
	
	@AfterMethod
	public void close() {
		//driver.quit();
	}

}
