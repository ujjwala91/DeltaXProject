package deltaXProject.pages;

import java.util.Objects;
import java.util.regex.Pattern;

import org.openqa.selenium.support.ui.Select;

public class RegistrationFormPage {
	
	public boolean emailValidation(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
                 
		Pattern pat = Pattern.compile(emailRegex);
		if (Objects.isNull(email))
			return false;
		return pat.matcher(email).matches();
	}
	
	public boolean contactNoValidation(String contactNo) {
		String contactNoRegex = "^\\d{10}$" ;
                 
		Pattern pat = Pattern.compile(contactNoRegex);
		if (Objects.isNull(contactNo))
			return false;
		return pat.matcher(contactNo).matches();
	}
	
	public boolean comparePassword(String password, String comparePassword)
	{
		if(password.equals(comparePassword))
		    return true;
		else
			return false;
	}
	
	public void selectDepartment(RegistrationPageWebElements ele,String Value)
	{
		Select s=new Select(ele.getDepartment());
		s.selectByVisibleText(Value);
	}
	
	public void fillFormPartially(RegistrationPageWebElements ele, String userName, String password, String confirmPassword, String email, String contactNo)
	{
		ele.getUserName().sendKeys(userName);
		ele.getPassword().sendKeys(password);
		ele.getConfirmPassword().sendKeys(confirmPassword);
		ele.getEmail().sendKeys(email);
		ele.getContactNo().sendKeys(contactNo);
	}
	
	public void fillFormTotallyWithValidValues(RegistrationPageWebElements ele,String firstName, String lastName, String userName, String password, String confirmPassword, String email, String contactNo)
	{
		ele.getFirstName().sendKeys(firstName);
		ele.getLastName().sendKeys(lastName);
		ele.getUserName().sendKeys(userName);
		ele.getPassword().sendKeys(password);
		ele.getConfirmPassword().sendKeys(confirmPassword);
		ele.getEmail().sendKeys(email);
		ele.getContactNo().sendKeys(contactNo);
		
		ele.getSubmit().click();
		
	}
	
	public void fillFormForMandatoryValues(RegistrationPageWebElements ele,String firstName,String lastName, String userName, String password,String confirmPassword,String email) {
		ele.getFirstName().sendKeys(firstName);
		ele.getLastName().sendKeys(lastName);
		ele.getUserName().sendKeys(userName);
		ele.getPassword().sendKeys(password);
		ele.getConfirmPassword().sendKeys(confirmPassword);
		ele.getEmail().sendKeys(email);
		
		ele.getSubmit().click();
	}
	

}
