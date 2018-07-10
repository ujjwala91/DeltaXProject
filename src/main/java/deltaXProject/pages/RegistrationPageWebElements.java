package deltaXProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageWebElements {

	@FindBy(xpath="//input[@type='text' and @name='first_name']")
	private WebElement firstName;

	public WebElement getFirstName() {
		return firstName;
	}
	
	@FindBy(xpath="//input[@name='first_name']")
	private WebElement LastName;

	public WebElement getLastName() {
		return LastName;
	}
	
	@FindBy(xpath="//select[@name='department']")
	private WebElement department;

	public WebElement getDepartment() {
		return department;
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(xpath="//input[@name='confirm_password']")
	private WebElement confirmPassword;

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;

	public WebElement getEmail() {
		return email;
	}
	
	@FindBy(xpath="//input[@name='contact_no']")
	private WebElement contactNo;

	public WebElement getContactNo() {
		return contactNo;
	}
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;

	public WebElement getSubmit() {
		return submit;
	}
	
	@FindBy(xpath="//small[@data-bv-validator-for='first_name']")
	private WebElement firstNameError;

	public WebElement getFirstNameError() {
		return firstNameError;
	}
	
	@FindBy(xpath="//small[@data-bv-validator-for='last_name']")
	private WebElement lastNameError;

	public WebElement getLastNameError() {
		return lastNameError;
	}
	
	
	@FindBy(xpath="//small[@data-bv-validator-for='user_name']")
	private WebElement userNameError;

	public WebElement getUserNameError() {
		return userNameError;
	}
	
	@FindBy(xpath="//small[@data-bv-validator-for='password']")
	private WebElement passwordError;

	public WebElement getPasswordError() {
		return passwordError;
	}
	
	@FindBy(xpath="//small[@data-bv-validator-for='confirm_password']")
	private WebElement confirmPasswordError;

	public WebElement getConfirmPasswordError() {
		return confirmPasswordError;
	}
	
	@FindBy(xpath="//small[@data-bv-validator-for='email']")
	private WebElement emailError;

	public WebElement getEmailError() {
		return confirmPasswordError;
	}
	
	@FindBy(xpath="//small[@data-bv-validator-for='contact_no']")
	private WebElement contactNoError;

	public WebElement getContactNoError() {
		return contactNoError;
	}
	
	
	
	
}
