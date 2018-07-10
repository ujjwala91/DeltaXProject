package deltaXProject.testCases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import deltaXProject.base.TestBase;
import deltaXProject.pages.RegistrationFormPage;
import deltaXProject.pages.RegistrationPageWebElements;
import deltaXProject.util.TestUtil;

public class RegistrationPageTestSuite extends TestBase {

	TestUtil testUtil=new TestUtil();
	RegistrationFormPage reg=new RegistrationFormPage();
	RegistrationPageWebElements ele=new RegistrationPageWebElements();
	
	
	String sheetName = "contacts";
	
	   
	public RegistrationPageTestSuite(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
		contactsPage.selectContactsByName("ui uiii");

	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}

