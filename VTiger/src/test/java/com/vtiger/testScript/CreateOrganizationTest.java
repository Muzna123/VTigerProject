package com.vtiger.testScript;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlib.BaseClass;

import objectRepository.CreateNewOrganization_POM;
import objectRepository.HomePage_POM;
import objectRepository.OrganizationInfoPage_POM;
import objectRepository.OrganizationPage_POM;
@Listeners(com.vtiger.genericlib.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {
	@Test
	public void organizationGenerationTest() throws IOException {
		HomePage_POM hp=PageFactory.initElements(driver, HomePage_POM.class);
		OrganizationPage_POM op=PageFactory.initElements(driver, OrganizationPage_POM.class);
		CreateNewOrganization_POM cno=PageFactory.initElements(driver, CreateNewOrganization_POM.class);
		OrganizationInfoPage_POM oip=PageFactory.initElements(driver, OrganizationInfoPage_POM.class);
		hp.navigateToOrganization();
		op.navigateToCreateOrganizationPage();
		String orgName = f.getExcelData("Sheet1", 2, 0);
		cno.enterOrganizationName(orgName);
		cno.clickOnSave();
		String actText = oip.successMsgText();;
		String expText = f.getExcelData("Sheet1", 2, 1);
		System.out.println(actText);
		System.out.println(expText);
		if (actText.contains(expText)) {
			System.out.println("Organization created Successfully");
		} else {
			System.out.println("Test Case Fail");
		}
		
	}
	

}
