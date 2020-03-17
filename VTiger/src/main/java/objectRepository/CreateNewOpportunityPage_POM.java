package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewOpportunityPage_POM {
   @FindBy(xpath="//input[@name='potentialname']")
   private WebElement OpportunityName;
  // @FindBy(xpath="//img[@title='Select']")
  // private WebElement 
   
   
   //public WebElement getOpportunityName() {
	//return OpportunityName;
//}


public void enterOpportunityName(String OpporName) {
	OpportunityName.sendKeys(OpporName);
	   
   }
}
