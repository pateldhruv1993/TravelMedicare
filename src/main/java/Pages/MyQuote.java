package Pages;

import java.util.List;

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
	@FindBy(xpath = "//input[@type='search']")
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

	
	// Web element lists
	public List <WebElement> cols;
	public List <WebElement> rows;
	public WebElement[][] tableData;
	
	// initiate page object
	public MyQuote() {
		PageFactory.initElements(driver, this); // this means current class object and driver is coming from base class
	}

	public void initPageElements() {

		Show10Rows = driver.findElement(By.className("dt-buttons")).findElements(By.className("dt-button")).get(0);
		Excel = driver.findElement(By.className("dt-buttons")).findElements(By.className("dt-button")).get(1);
		PDF = driver.findElement(By.className("dt-buttons")).findElements(By.className("dt-button")).get(2);
		CSV = driver.findElement(By.className("dt-buttons")).findElements(By.className("dt-button")).get(3);

		EmployeeNameSort = driver.findElements(By.className("sorting")).get(0);
		DesignationSort = driver.findElements(By.className("sorting")).get(1);
		QuotationNoSort = driver.findElements(By.className("sorting")).get(2);
		DateOfQuoteSort = driver.findElements(By.className("sorting")).get(3);
		CustomerNameSort = driver.findElements(By.className("sorting")).get(4);
		QuoteAmountSort = driver.findElements(By.className("sorting")).get(5);
		
	}
	
	
	// Returns false if there was no data available and true if it found data and populated the tableData array
	public Boolean initTableElements() {
		cols = driver.findElements(By.xpath(".//*[@id=\"commissionTable\"]/thead/tr/th"));
        System.out.println("No of cols are : " + cols.size()); 
        //No.of rows 
        rows = driver.findElements(By.xpath(".//*[@id='commissionTable']/tbody/tr/td[1]")); 
        System.out.println("No of rows are : " + rows.size());
        System.out.println(rows.get(0).getText());
        if(rows.size() > 1 || !rows.get(0).getText().equals("No data available in table") ) {
        
	        tableData = new WebElement[cols.size()][rows.size()];
	        
	        for(int i = 0; i < cols.size(); i++) {
	        	for(int j = 0; j < rows.size(); j++) {
	        		
	        		tableData[i][j] = driver.findElement(By.xpath(".//*[@id='commissionTable']/tbody/tr["+ (j + 1) +"]/td[" + (i + 1) + "]")); 
	        		
	        	}
	        }
	        return true;
        } else {
        	System.out.println("No data was found in the table");
        	return false;
        }
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
		driver.findElement(By.className("dt-buttons")).findElements(By.className("dt-button")).get(0).click();
	}

	public void excel() {
		driver.findElement(By.className("dt-buttons")).findElements(By.className("dt-button")).get(1).click();
	}

	public void pdf() {
		driver.findElement(By.className("dt-buttons")).findElements(By.className("dt-button")).get(2).click();
	}

	public void csv() {
		driver.findElement(By.className("dt-buttons")).findElements(By.className("dt-button")).get(3).click();
	}

	public void search(String search) {
		Search.sendKeys(search);
		Search.sendKeys(Keys.ENTER);
	}

	
	// TODO: Fix all these sort xpath stuff below. as once you click on the header to sort it, its class name changes and you wont be able to click it again to make it decending order
	public void employeeNameSort() {
		driver.findElements(By.className("sorting")).get(0).click();
	}

	public void designationSort() {
		driver.findElements(By.className("sorting")).get(1).click();
	}

	public void quotationNoSort() {
		driver.findElements(By.className("sorting")).get(2).click();
	}

	public void dateOfQuoteSort() {
		driver.findElements(By.className("sorting")).get(3).click();
	}

	public void customerNameSort() {
		driver.findElements(By.className("sorting")).get(4).click();
	}

	
	//TODO: the following element might not be clickable sometimes becauseof processing light box showing on top of it. use this to fix it: https://stackoverflow.com/questions/38327049/check-if-element-is-clickable-in-selenium-java
	public void quoteAmountSort() {
		driver.findElements(By.className("sorting")).get(5).click();
	}
	
}
