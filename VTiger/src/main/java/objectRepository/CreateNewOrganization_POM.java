package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewOrganization_POM {
	@FindBy(name="accountname")
	private WebElement OrganizationName;
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	
	public WebElement getOrganizationName() {
		return OrganizationName;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void enterOrganizationName(String OrgName) {
		OrganizationName.sendKeys(OrgName);
	}
	public void clickOnSave() {
		saveBtn.click();
	}

}
