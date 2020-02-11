package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClass.Testbase;

public class Login extends Testbase {

	@FindBy(name = "email")
	WebElement Email;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Login_Btn;
	
	// initiate page object
	public Login() {
		PageFactory.initElements(driver, this); // this means current class object and driver is coming from base class
	}

	public void loginWith(String email, String password) {
		Email.sendKeys(email);
		Password.sendKeys(password);
		
		Login_Btn.click();
	}
}
