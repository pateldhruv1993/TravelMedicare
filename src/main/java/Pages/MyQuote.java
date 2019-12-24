package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClass.Testbase;

public class MyQuote extends Testbase {

	@FindBy(name = "role")
	WebElement Role;
	@FindBy(name = "user_id")
	WebElement User;
	@FindBy(name = "from_date")
	WebElement From_Date;
	@FindBy(name = "to_date")
	WebElement To_Date;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit;
	@FindBy(xpath = "//button[text()='Reset']")
	WebElement Reset;
	@FindBy(xpath = "//button[@type='search']")
	WebElement Search;
	@FindBy(linkText = "Previous")
	WebElement Previous;
	@FindBy(linkText = "Next")
	WebElement Next;

	// Web tables to get data from tables
	WebElement Show10Rows;
	WebElement Excel;
	WebElement PDF;
	WebElement CSV;

	WebElement EmployeeNameSort;
	WebElement DesignationSort;
	WebElement QuotationNoSort;
	WebElement DateOfQuoteSort;
	WebElement CustomerNameSort;
	WebElement QuoteAmountSort;

	// initiate page object
	public MyQuote() {
		PageFactory.initElements(driver, this); // this means current class object and driver is coming from base class
	}

	public void initPageElements() {
		if(driver == null) {
			System.out.println("driver obj is null");
		}
		Show10Rows = driver.findElements(By.className("dt-buttons")).get(0);
		Excel = driver.findElements(By.className("dt-buttons")).get(1);
		PDF = driver.findElements(By.className("dt-buttons")).get(2);
		CSV = driver.findElements(By.className("dt-buttons")).get(3);

		EmployeeNameSort = driver.findElements(By.className("sorting")).get(0);
		DesignationSort = driver.findElements(By.className("sorting")).get(1);
		QuotationNoSort = driver.findElements(By.className("sorting")).get(2);
		DateOfQuoteSort = driver.findElements(By.className("sorting")).get(3);
		CustomerNameSort = driver.findElements(By.className("sorting")).get(4);
		QuoteAmountSort = driver.findElements(By.className("sorting")).get(5);
	}

	public String validatetitleContact() {
		return driver.getTitle();
	}

	public void selectRole(String role) {
		Select dropRole = new Select(Role);
		dropRole.selectByVisibleText(role);
	}

	public void selectUser(String user) {
		Select dropUser = new Select(User);
		dropUser.selectByVisibleText(user);
	}

	public void fromDate(String fromDate) {
		From_Date.sendKeys(fromDate);
	}

	public void toDate(String toDate) {
		To_Date.sendKeys(toDate);
	}

	public void submit() {
		Submit.click();
	}

	public void reset() {
		Reset.click();
	}

	public void show10Rows() {
		Show10Rows.click();
	}

	public void excel() {
		Excel.click();
	}

	public void pdf() {
		PDF.click();
	}

	public void csv() {
		CSV.click();
	}

	public void search(String search) {
		Search.sendKeys(search);
		Search.sendKeys(Keys.ENTER);
	}

	public void employeeNameSort() {
		EmployeeNameSort.click();
	}

	public void designationSort() {
		DesignationSort.click();
	}

	public void quotationNoSort() {
		QuotationNoSort.click();
	}

	public void dateOfQuoteSort() {
		DateOfQuoteSort.click();
	}

	public void customerNameSort() {
		CustomerNameSort.click();
	}

	public void quoteAmountSort() {
		QuoteAmountSort.click();
	}
}
