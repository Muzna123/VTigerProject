package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitiesPage_POM {
	@FindBy(xpath="//img[@title='Create Opportunity...']")
    private WebElement createOpportunities;

	public WebElement getCreateOpportunities() {
		return createOpportunities;
	}
	
	public void navigateToCreateOpportunities()
	{
		createOpportunities.click();
	}
}
