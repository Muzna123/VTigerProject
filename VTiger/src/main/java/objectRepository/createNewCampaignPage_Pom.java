package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class createNewCampaignPage_Pom {
	@FindBy(name = "campaignname")
	private WebElement tbCampaignName;
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;

	public WebElement getTbCampaignName() {
		return tbCampaignName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void enterCampaignName(String campName) {
		tbCampaignName.sendKeys(campName);
	}

	public void clickOnSave() {
		saveBtn.click();
	}
}
