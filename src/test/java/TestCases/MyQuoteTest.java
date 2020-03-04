package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.MyQuote;
import Pages.Login;

public class MyQuoteTest extends MyQuote {

	MyQuote Quote; // declared Contact us reference at class level so that we can use it throughout
	Login Log;

	SimpleDateFormat inputDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat tableDateFormatter = new SimpleDateFormat("dd-MMM-yyyy");
	// the class

	public MyQuoteTest() {
		super();// to call parent class/super class constructor we write super keyword,

		// this will call properties from testbase class.
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
		System.out.println("tried to login");
	}

	/*
	 * @Test(priority = 1) public void defaultSearch(){ Quote.submit();
	 * if(!initTableElements()) { Assert.
	 * fail("No results were found on defaultSearch which is obviously wrong?!?!");
	 * } }
	 * 
	 * @Test(priority = 2) public void selectRole() { String roleName = "MGA";
	 * Quote.selectRole(roleName); Quote.submit();
	 * 
	 * if(initTableElements()) { for(int i = 0; i < tableData[0].length; i++) {
	 * System.out.println(tableData[1][i].getText());
	 * assertEquals(tableData[1][i].getText(), roleName); } } else {
	 * Assert.fail("No data found in table - SelectRole"); }
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority = 3) public void selectUser() { String usersName = "";
	 * Quote.selectUser(usersName); Quote.submit();
	 * 
	 * if(initTableElements()) { for(int i = 0; i < tableData[0].length; i++) {
	 * assertEquals(tableData[0][i].getText(), usersName); } } }
	 * 
	 * 
	 * @Test(priority = 4) public void selectFromDate() throws ParseException {
	 * String fromDate = "2019-04-12"; Quote.fromDate(fromDate); Quote.submit();
	 * 
	 * Date inputDate = inputDateFormatter.parse(fromDate); Date tableDate;
	 * 
	 * 
	 * if(initTableElements()) { for(int i = 0; i < tableData[3].length; i++) {
	 * tableDate = tableDateFormatter.parse(tableData[3][i].getText()); int
	 * dateCompare = inputDate.compareTo(tableDate); if(dateCompare == 0 ||
	 * dateCompare < 0) { System.out.println("Date passed"); } else {
	 * Assert.fail("Quotes generated before " + fromDate + " are showing"); break; }
	 * } } }
	 * 
	 * 
	 * @Test(priority = 5) public void selectToDate() throws ParseException { String
	 * toDate = "2019-12-01"; Quote.toDate(toDate); Quote.submit();
	 * 
	 * Date inputDate = inputDateFormatter.parse(toDate); Date tableDate;
	 * 
	 * 
	 * if(initTableElements()) { for(int i = 0; i < tableData[3].length; i++) {
	 * tableDate = tableDateFormatter.parse(tableData[3][i].getText()); int
	 * dateCompare = inputDate.compareTo(tableDate); if(dateCompare == 0 ||
	 * dateCompare > 0) { } else { Assert.fail("Quotes generated after " + toDate +
	 * " are showing"); break; } } } }
	 * 
	 * 
	 * @Test(priority = 6) public void selectFromAndToDate() throws ParseException {
	 * String fromDate = "2019-11-01"; String toDate = "2019-12-01";
	 * Quote.fromDate(fromDate); Quote.toDate(toDate); Quote.submit();
	 * 
	 * Date inputFromDate = inputDateFormatter.parse(fromDate); Date inputToDate =
	 * inputDateFormatter.parse(toDate); Date tableDate;
	 * 
	 * 
	 * if(initTableElements()) { for(int i = 0; i < tableData[3].length; i++) {
	 * tableDate = tableDateFormatter.parse(tableData[3][i].getText()); int
	 * dateCompare1 = inputFromDate.compareTo(tableDate); int dateCompare2 =
	 * inputToDate.compareTo(tableDate);
	 * 
	 * if(dateCompare1 == 0 || dateCompare1 < 0) {
	 * System.out.println("Date passed"); } else {
	 * Assert.fail("Quotes generated before " + fromDate + " are showing"); break; }
	 * 
	 * if(dateCompare2 == 0 || dateCompare2 > 0) { } else {
	 * Assert.fail("Quotes generated after " + toDate + " are showing"); break; }
	 * 
	 * } } }
	 
	
	
	// TODO: Not working
	@Test(priority = 7)
	public void downloadDataInExcelFile() {
		Quote.excel();
	}

	@Test(priority = 8)
	public void downloadDataInPDFFile() {
		Quote.pdf();
	}

	@Test(priority = 9)
	public void downloadDataInCSVFile() {
		Quote.csv();
	}

	
	
	@Test(priority = 10)
	public void show10Rows() {
		Quote.show10Rows();
	}

	@Test(priority = 11)
	public void employeeNameAssending() {
		Quote.employeeNameSort();
	}

	@Test(priority = 12)
	public void employeeNameDesending() {
		Quote.employeeNameSort();
		Quote.employeeNameSort();
	}
	
	@Test(priority = 13)
	public void designationAssending() {
		Quote.designationSort();
	}
	
	@Test(priority = 14)
	public void designationDesending() {
		Quote.designationSort();
		Quote.designationSort();
	}
	
	@Test(priority = 15)
	public void quoteNoAssending() {
		Quote.quotationNoSort();
	}
	
	@Test(priority = 16)
	public void quoteNoDesending() {
		Quote.quotationNoSort();
		Quote.quotationNoSort();
	}*/
	
	@Test(priority = 17)
	public void dateOfQuoteAssending() {
		Quote.dateOfQuoteSort();
	}
	
	@Test(priority = 18)
	public void dateOfQuoteDesending() {
		Quote.dateOfQuoteSort();
		Quote.dateOfQuoteSort();
	}
	
	
	@Test(priority = 19)
	public void customerNameAssending() {
		Quote.customerNameSort();
	}
	
	@Test(priority = 20)
	public void customerNameDesending() {
		Quote.customerNameSort();
		Quote.customerNameSort();
	}
	
	@Test(priority = 21)
	public void quoteAmountAssending() {
		Quote.quoteAmountSort();
	}
	
	@Test(priority = 22)
	public void quoteAmountDesending() {
		Quote.quoteAmountSort();
		Quote.quoteAmountSort();
	}
	
	/*
	@Test(priority = 23)
	public void quoteActionViewQuote() {
		initTableElements();
		tableData[6][0].findElement(By.linkText("View")).click();
	}
	
	
	

	
	@Test(priority = 100) public void searchField() throws InterruptedException {
	String searchQuery = "2019QTM54817"; Quote.search(searchQuery);
	Thread.sleep(1000);
	if(initTableElements()) { for(int i = 0; i < tableData[0].length; i++) {
	System.out.println(tableData[2][i].getText());
	assertEquals(tableData[2][i].getText(), searchQuery); } } }
	*/
	
	@AfterMethod
	public void close() {
		// driver.quit();
	}

}
