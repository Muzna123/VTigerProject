package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page {
@FindBy(name="user_name")	
private WebElement username;
@FindBy(name="user_password")
private WebElement password;
@FindBy(id="submitButton")
private WebElement login_btn;
@FindBy(xpath="//div[contains(text(),'You must specify a valid username and password')]")
private WebElement error_msg;

public void login_To_App(String un,String pwd)
{
	username.sendKeys(un);
	password.sendKeys(pwd);
	login_btn.click();
}

public WebElement getUsername() {
	return username;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLogin_btn() {
	return login_btn;
}

public WebElement getError_msg() {
	return error_msg;
}











}
