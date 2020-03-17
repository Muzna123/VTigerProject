package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPage_POM {
	@FindBy(xpath="//img[@title='Create Organization...']")
    private WebElement createOrganisation;

	public WebElement getCreateOrganisation() {
		return createOrganisation;
	}
	public void navigateToCreateOrganizationPage()
	{
		createOrganisation.click();
	}
	
}
