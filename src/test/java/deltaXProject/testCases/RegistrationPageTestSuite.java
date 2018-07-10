package deltaXProject.testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import deltaXProject.base.TestBase;
import deltaXProject.pages.RegistrationFormPage;
import deltaXProject.pages.RegistrationPageWebElements;
import deltaXProject.util.TestUtil;

public class RegistrationPageTestSuite extends TestBase {

	RegistrationFormPage reg;
	RegistrationPageWebElements ele;

	public RegistrationPageTestSuite() {
		super();

	}

	@BeforeClass
	public static void dataSetup() {
		TestUtil.loadTestData();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		reg = new RegistrationFormPage();
		ele = new RegistrationPageWebElements();
		PageFactory.initElements(driver, ele);
	}

	@Test(priority = 1)
	public void verifyFirstNameErrorBelow2Char() {
		String firstName = TestUtil.getCellData(2, 2);
		ele.getFirstName().sendKeys(firstName);
		String errorText = ele.getFirstNameError().getText();
		Assert.assertEquals(errorText, "This value is not valid");
	}

	@Test(priority = 2)
	public void verifyLastNameErrorBelow2Char() {
		String lastName = TestUtil.getCellData(3, 2);
		ele.getLastName().sendKeys(lastName);
		String errorText = ele.getLastNameError().getText();
		Assert.assertEquals(errorText, "This value is not valid");
	}

	@Test(priority = 3)
	public void verifyUserNameErrorBelow8Char() {
		String userName = TestUtil.getCellData(4, 2);
		ele.getUserName().sendKeys(userName);
		String errorText = ele.getUserNameError().getText();
		Assert.assertEquals(errorText, "This value is not valid");
	}

	@Test(priority = 4)
	public void verifyPasswordErrorBelow8Char() {
		String password = TestUtil.getCellData(5, 2);
		ele.getPassword().sendKeys(password);
		String errorText = ele.getPasswordError().getText();
		Assert.assertEquals(errorText, "This value is not valid");
	}

	@Test(priority = 5)
	public void verifyConfirmPasswordErrorBelow8Char() {
		String confirmPassword = TestUtil.getCellData(6, 2);
		ele.getConfirmPassword().sendKeys(confirmPassword);
		String errorText = ele.getConfirmPasswordError().getText();
		Assert.assertEquals(errorText, "This value is not valid");
	}

	@Test(priority = 6)
	public void verifyEmailErrorBelow8Char() {
		String email = TestUtil.getCellData(7, 2);
		ele.getEmail().sendKeys(email);
		String errorText = ele.getEmailError().getText();
		Assert.assertEquals(errorText, "This value is not valid");
	}

	@Test(priority = 7)
	public void verifyContactNoErrorBelow10Char() {
		String contactNo = TestUtil.getCellData(8, 2);
		ele.getContactNo().sendKeys(contactNo);
		String errorText = ele.getontactNoError().getText();
		Assert.assertEquals(errorText, "This value is not valid");
	}

	@Test(priority = 8)
	public void verifyFirstNameErrorClearingTheText() {
		String firstName = TestUtil.getCellData(9, 2);
		ele.getFirstName().sendKeys(firstName);
		ele.getFirstName().sendKeys(Keys.BACK_SPACE);
		ele.getFirstName().sendKeys(Keys.BACK_SPACE);
		String errorText = ele.getFirstNameError1().getText();
		
		Assert.assertEquals(errorText, "Please enter your First Name");
	}

	@Test(priority = 9)
	public void verifyLastNameErrorClearingTheText() {
		String lastName = TestUtil.getCellData(10, 2);
		ele.getLastName().sendKeys(lastName);
		ele.getLastName().sendKeys(Keys.BACK_SPACE);
		ele.getLastName().sendKeys(Keys.BACK_SPACE);
		String errorText = ele.getLastNameError1().getText();
		Assert.assertEquals(errorText, "Please enter your Last Name");
	}

	@Test(priority = 10)
	public void verifyUserNameErrorClearingTheText() {
		String username = TestUtil.getCellData(11, 2);
		ele.getUserName().sendKeys(username);
		ele.getUserName().sendKeys(Keys.BACK_SPACE);
		ele.getUserName().sendKeys(Keys.BACK_SPACE);
		String errorText = ele.getUserNameError1().getText();
		Assert.assertEquals(errorText, "Please enter your Username");
	}

	@Test(priority = 11)
	public void verifyPasswordErrorClearingTheText() {
		String password = TestUtil.getCellData(12, 2);
		ele.getPassword().sendKeys(password);
		ele.getPassword().sendKeys(Keys.BACK_SPACE);
		ele.getPassword().sendKeys(Keys.BACK_SPACE);
		String errorText = ele.getPasswordError1().getText();
		Assert.assertEquals(errorText, "Please enter your Password");
	}

	@Test(priority = 12)
	public void verifyConfirmPasswordErrorClearingTheText() {
		String confirmPassword = TestUtil.getCellData(13, 2);
		ele.getConfirmPassword().sendKeys(confirmPassword);
		ele.getConfirmPassword().sendKeys(Keys.BACK_SPACE);
		ele.getConfirmPassword().sendKeys(Keys.BACK_SPACE);
		String errorText = ele.getConfirmPasswordError1().getText();
		Assert.assertEquals(errorText, "Please confirm your Password");
	}

	@Test(priority = 13)
	public void verifyEmailErrorClearingTheText() {
		String email = TestUtil.getCellData(14, 2);
		ele.getEmail().sendKeys(email);
		ele.getEmail().sendKeys(Keys.BACK_SPACE);
		ele.getEmail().sendKeys(Keys.BACK_SPACE);
		String errorText = ele.getEmailError1().getText();
		Assert.assertEquals(errorText, "Please enter your Email Address");
	}

	@Test(priority = 14)
	public void verifyEmail() {
		String email = TestUtil.getCellData(15, 2);
		Boolean val = reg.emailValidation(email);
		if (val = false) {
			ele.getEmail().sendKeys(email);
			String errorText = ele.getEmailError().getText();
			Assert.assertEquals(errorText, "This value is not valid");
		} else {
			System.out.println("pass");
		}
	}

	@Test(priority = 15)
	public void verifyPasswordandConfirmPassword() {
		String password = TestUtil.getCellData(16, 2);
		String confirmPassword = TestUtil.getCellData(16, 3);
		Boolean val = reg.comparePassword(password, confirmPassword);
		if (val = false) {
			ele.getPassword().sendKeys(password);
			ele.getPassword().sendKeys(confirmPassword);
			String errorText = ele.getConfirmPasswordError().getText();
			Assert.assertEquals(errorText, "Password and Confirm Password did not matched");
		} else {
			System.out.println("pass");
		}
	}

	@Test(priority = 16)
	public void verifyContactNo() {
		String contactNo = TestUtil.getCellData(17, 2);
		Boolean val = reg.contactNoValidation(contactNo);
		if (val = false) {
			ele.getContactNo().sendKeys(contactNo);
			String errorText = ele.getConfirmPasswordError().getText();
			Assert.assertEquals(errorText, "This value is not valid");
		} else {
			System.out.println("pass");
		}
	}

	@Test(priority = 17)
	public void verifySubmitButtonWithFewMandatoryFieldsasBlank() throws InterruptedException {
		// With First Name and LastName as Blank
		String department = TestUtil.getCellData(18, 2);
		String userName = TestUtil.getCellData(18, 3);
		String password = TestUtil.getCellData(18, 4);
		String confirmPassword = TestUtil.getCellData(18, 5);
		String email = TestUtil.getCellData(18, 6);
		String contactNo = TestUtil.getCellData(18, 7);

		reg.selectDepartment(ele,department);
		reg.fillFormPartially(ele, userName, password, confirmPassword, email, contactNo);

		Thread.sleep(3000);

		ele.getSubmit().click();

		Assert.assertEquals(ele.getRegistrationPage().getText(), "Registration Page");

	}

	@Test(priority = 18)
	public void verifySubmitButtonWithAllFieldsWithValidValues() throws InterruptedException {
		String firstName = TestUtil.getCellData(18, 8);
		String lastName = TestUtil.getCellData(18, 9);
		String department = TestUtil.getCellData(18, 2);
		String userName = TestUtil.getCellData(18, 3);
		String password = TestUtil.getCellData(18, 4);
		String confirmPassword = TestUtil.getCellData(18, 5);
		String email = TestUtil.getCellData(18, 6);
		String contactNo = TestUtil.getCellData(18, 7);

		reg.selectDepartment(ele, department);
		reg.fillFormTotallyWithValidValues(ele, firstName, lastName, userName, password, confirmPassword, email, contactNo);

		Thread.sleep(3000);

		Assert.assertEquals(ele.getRegistrationPage().getText(), "Thanks");

	}

	@Test(priority = 19)
	public void verifySubmitButtonWithNonMandatoryFieldsasBlanks() throws InterruptedException {

		// All the Mandatory fields has to be filled
		String firstName = TestUtil.getCellData(18, 8);
		String lastName = TestUtil.getCellData(18, 9);
		String userName = TestUtil.getCellData(18, 3);
		String password = TestUtil.getCellData(18, 4);
		String confirmPassword = TestUtil.getCellData(18, 5);
		String email = TestUtil.getCellData(18, 6);

		reg.fillFormForMandatoryValues(ele, firstName, lastName, userName, password, confirmPassword, email);

		Thread.sleep(3000);

		Assert.assertEquals(ele.getRegistrationPage().getText(), "Thanks");

	}

	@AfterMethod
	public void tearDow1() {
		driver.quit();
	}

}
