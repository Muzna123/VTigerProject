package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignInfoPage_Pom {
	@FindBy(xpath = "//span[contains(text(),'Campaign Information')]")
	private WebElement successMsg;

	public WebElement getSuccessMsg() {
		return successMsg;
	}

	public String successMsgtext() {
		return successMsg.getText();
	}

}
