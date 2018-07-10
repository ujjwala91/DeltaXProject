package deltaXProject.pages;

import java.util.Objects;
import java.util.regex.Pattern;

import org.openqa.selenium.support.PageFactory;

import deltaXProject.base.TestBase;

public class RegistrationFormPage extends TestBase {
	
	// Initializing the Page Objects:
	public RegistrationFormPage() {
		PageFactory.initElements(driver, this);
	}
	
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
	
	
	

}
