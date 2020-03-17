package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampaignPage_Pom {
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCamp;

	public WebElement getCreateCamp() {
		return createCamp;
	}

	public void navigateToCreateCampaignPage() {
		createCamp.click();
	}

}
