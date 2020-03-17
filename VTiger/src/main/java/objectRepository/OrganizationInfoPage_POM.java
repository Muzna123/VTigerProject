package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationInfoPage_POM {
	@FindBy(xpath="//span[contains(text(),'Organization Information')]")
	private WebElement successMsg2;

	public WebElement getSuccessMsg2() {
		return successMsg2;
	}
	
	public String successMsgText() {
		return successMsg2.getText();
	}
	

}
