package com.vtiger.testScript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlib.BaseClass;

import objectRepository.CampaignInfoPage_Pom;
import objectRepository.CampaignPage_Pom;
import objectRepository.HomePage_POM;
import objectRepository.createNewCampaignPage_Pom;

@Listeners(com.vtiger.genericlib.ListenerImplementation.class)
public class CreateCampaignTest extends BaseClass {
	@Test
	public void campaignGenerationTest() throws IOException {
		
		HomePage_POM hp = PageFactory.initElements(driver, HomePage_POM.class);
		CampaignPage_Pom cp = PageFactory.initElements(driver, CampaignPage_Pom.class);
		createNewCampaignPage_Pom cnp = PageFactory.initElements(driver, createNewCampaignPage_Pom.class);
		CampaignInfoPage_Pom cip = PageFactory.initElements(driver, CampaignInfoPage_Pom.class);
		WebElement more = hp.getMore();
		wLib.moveMousePointer(more);
		hp.navigateToCampaign();
		cp.navigateToCreateCampaignPage();
		String campName = f.getExcelData("Sheet1", 1, 0);
		cnp.enterCampaignName(campName);
		cnp.clickOnSave();
		String actText = cip.successMsgtext();
		String expText = f.getExcelData("Sheet1", 1, 1);
		if (actText.contains(expText)) {
			System.out.println("Campaign created Successfullyy");
		} else {
			System.out.println("Test Case Fail");
		}
	}

}
