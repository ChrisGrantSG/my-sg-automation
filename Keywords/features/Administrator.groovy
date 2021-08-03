package features

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.ss.formula.functions.Today
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import groovy.time.TimeCategory as TimeCategory
import jdk.jfr.Frequency
import webUI.ContinueAs
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Administrator {

	static void AdministratorList(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName
		/*Start common Feature function code*/
		List PermissionLevelList = PermissionLevel.split('\\|')
		System.out.println('Permission List Members = ' + PermissionLevelList.size())
		List PermissionLevelArray = PermissionLevel.split('\\|')
		System.out.println(PermissionLevelArray.size())
		if (PermissionLevelArray.size() < 2 ) {
			System.out.println("Only 1 access level to test")
		} else {
			System.out.println("More than 1 access level to test")
		}

		//Users Menu
		TestObject tObj_Users_Menu = new TestObject('Users Menu')
		tObj_Users_Menu.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'users-menu' and (text() = ' Users ' or . = ' Users ')]")

		//Administrators Menu Item
		TestObject tObj_Users_Administrators = new TestObject('Administrators Menu Item')
		tObj_Users_Administrators.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/administrators' and (text() = 'Administrators' or . = 'Administrators')]")

		//Search Button
		TestObject tObj_Search_Button = new TestObject('Search Button')
		tObj_Search_Button.addProperty('xpath', ConditionType.EQUALS,"//button[@id='btn-next-page']")

		//Download CSV Button
		TestObject tObj_Download_Button = new TestObject('Download Button')
		tObj_Download_Button.addProperty('xpath', ConditionType.EQUALS,"//button[@id='btn-download']")

		//Add Administrator Button
		TestObject tObj_AddAdministrator_Button = new TestObject('Add Administrator Button')
		tObj_AddAdministrator_Button.addProperty('xpath', ConditionType.EQUALS,"(//button[@id='btn-download'])[2]")



		//start loop for access levels
		for (int index = 0; index < PermissionLevelArray.size(); index++) {
			System.out.println(PermissionLevelArray[index])
			PermissionLevel = PermissionLevelArray[index]
			System.out.println("Permission - \'" + PermissionLevel + "\': \'" + (index + 1) + "\' of \'" + PermissionLevelArray.size() + "\' levels to test")
			/*End common Feature function code*/

			/*Begin function code*/		
			switch (PermissionLevel) {

				case 'No access':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

					if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType == 'Donate_SignIn_SettingsManager' || ScenarioType =='Donate_SignIn_CLSettingsManager'){

						WebUI.verifyElementNotPresent(tObj_Users_Menu,3)

					}else if (ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
						WebUI.click(tObj_Users_Menu)

						WebUI.verifyElementNotPresent(tObj_Users_Administrators, 3)
					}else {

						KeywordUtil.markFailed("ScenarioType not found in no access")
					}

					WebUI.comment("Access for " + ScenarioType + " for " + PermissionLevel)
					break

				case 'View':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

					WebUI.click(tObj_Users_Menu)

					WebUI.click(tObj_Users_Administrators)

					WebUI.verifyTextPresent('Administrators', false)

					WebUI.verifyElementPresent(tObj_Search_Button, 3)

					WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

					break

				case 'Export CSV':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				//create test objects

				//define variables


				//Start test

					WebUI.click(tObj_Users_Menu)

					WebUI.click(tObj_Users_Administrators)
					WebUI.verifyElementPresent(tObj_Download_Button, 3)

					WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

					break
				case 'Remove admin':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				//create test objects
					TestObject tObj_AccountMgrDetails = new TestObject('Administrator Details')
					tObj_AccountMgrDetails.addProperty('xpath', ConditionType.EQUALS,"//*[(text() = 'testing+auto2020_1_acctmgr@securegive.com' or . = 'testing+auto2020_1_acctmgr@securegive.com')]")


					TestObject tObj_TrashCanDelete = new TestObject('Trash Can - Delete')
					tObj_TrashCanDelete.addProperty('xpath', ConditionType.EQUALS,"//button[@id='btn-delete']")


				//define variables


				//Start test

					WebUI.click(tObj_Users_Menu)

					WebUI.click(tObj_Users_Administrators)
					WebUI.verifyElementPresent(tObj_AccountMgrDetails, 3)
					WebUI.click(tObj_AccountMgrDetails)
					WebUI.verifyTextPresent('Edit Administrator', false)
					WebUI.verifyElementPresent(tObj_TrashCanDelete, 3)

					WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

					break

				default:
					WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
					KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
			}
		}
	}
	static void AddAdministrator(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName
		/*Start common Feature function code*/

		//Definitions

		//click Users Menu
		TestObject tObj_Users_Menu = new TestObject('Users Menu')
		tObj_Users_Menu.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'users-menu' and (text() = ' Users ' or . = ' Users ')]")

		//click Administrators Menu Item
		TestObject tObj_Users_Administrators = new TestObject('Administrators Menu Item')
		tObj_Users_Administrators.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/' and (text() = 'Theme' or . = 'Theme')]")

		TestObject tObj_Save = new TestObject('Save Button')
		tObj_Save.addProperty('xpath', ConditionType.EQUALS,"//button[@class='btn btn-primary' and (text() = ' Save ' or . = ' Save ')]")



		List PermissionLevelList = PermissionLevel.split('\\|')
		System.out.println('Permission List Members = ' + PermissionLevelList.size())
		List PermissionLevelArray = PermissionLevel.split('\\|')
		System.out.println(PermissionLevelArray.size())
		if (PermissionLevelArray.size() < 2 ) {
			System.out.println("Only 1 access level to test")
		} else {
			System.out.println("More than 1 access level to test")
		}
		//start loop for access levels
		for (int index = 0; index < PermissionLevelArray.size(); index++) {
			System.out.println(PermissionLevelArray[index])
			PermissionLevel = PermissionLevelArray[index]
			System.out.println("Permission - \'" + PermissionLevel + "\': \'" + (index + 1) + "\' of \'" + PermissionLevelArray.size() + "\' levels to test")
			/*End common Feature function code*/

			/*Begin function code*/
			switch (PermissionLevel) {

				case 'No access':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

					if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType == 'Donate_SignIn_SettingsManager' || ScenarioType =='Donate_SignIn_CLSettingsManager'||ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
						//WebUI.click(tObj_Settings_Selection)
						//WebUI.verifyElementNotPresent(tObj_Settings_Theme, 3)
					}else if (ScenarioType == 'Donate_SignIn_CLSettingsManager'||ScenarioType == 'Donate_SignIn_CLAccountManager'){
						//click setting menu
						//WebUI.click(tObj_Settings_Selection)

						//click settings->locations
						//WebUI.click(tObj_Settings_Theme)

						//click location and select 'Main Campus'
						//WebUI.verifyElementNotPresent(tObj_Theme_LocationSelect,3)
						//WebUI.verifyElementPresent(tObj_Theme_LocationSelect_MainOnly, 3)
					}

					WebUI.comment("Access for " + ScenarioType + " for " + PermissionLevel)

					break

				case 'View':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)


				//WebUI.click(tObj_Settings_Selection)

				//WebUI.click(tObj_Settings_Theme)

					WebUI.verifyTextPresent('Customize Theme', false)
					WebUI.verifyTextPresent('Preview Theme', false)
					WebUI.verifyTextPresent('Accent Color', false)
					WebUI.verifyTextPresent('Background Color', false)
					WebUI.verifyTextPresent('Light', false)
					WebUI.verifyTextPresent('Dark', false)
					WebUI.verifyTextPresent('White', false)
					WebUI.verifyTextPresent('Accent Color', false)
					WebUI.verifyTextPresent('Save', false)
					WebUI.verifyTextPresent('Location-specific Themes', false)
					WebUI.verifyTextPresent('If a location needs different branding, add it here or leave blank to use the organization\'s branding.', false)

					WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

					break

				case 'Edit':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				//Start test
				//find out if campus limited or not and check Main Campus or more than Main Campus with if/else ...take no access for campus limited Settings and Account manager away from no Access switch
				//click setting menu
				//WebUI.click(tObj_Settings_Selection)

				//click settings->locations
				//WebUI.click(tObj_Settings_Theme)
				//click location and select 'Main Campus'
				//WebUI.click(tObj_Theme_LocationSelect)

				//WebUI.selectOptionByLabel(tObj_Theme_LocationSelect, "Main Campus", false)
				//System.out.println(WebUI.getText(tObj_Theme_LocationSelect))

				//make sure BC light is selected
				//if (WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3,FailureHandling.OPTIONAL)) {

				//	WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)
				//	WebUI.click(tObj_Save)

				//}

				//select BC dark
				//	WebUI.click(tObj_Settings_BackgroundColorDarkUnchecked)

				//verify BC dark is selected
				//WebUI.verifyElementPresent(tObj_Settings_BackgroundColorDarkChecked, 3)

				//verify BC light is not selected
				//WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3)



					break

				default:
					WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
					KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
			}
		}
	}
	static void ViewEditAdministrator(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName
		/*Start common Feature function code*/

		//Definitions

		List PermissionLevelList = PermissionLevel.split('\\|')
		System.out.println('Permission List Members = ' + PermissionLevelList.size())
		List PermissionLevelArray = PermissionLevel.split('\\|')
		System.out.println(PermissionLevelArray.size())
		if (PermissionLevelArray.size() < 2 ) {
			System.out.println("Only 1 access level to test")
		} else {
			System.out.println("More than 1 access level to test")
		}
		//start loop for access levels
		for (int index = 0; index < PermissionLevelArray.size(); index++) {
			System.out.println(PermissionLevelArray[index])
			PermissionLevel = PermissionLevelArray[index]
			System.out.println("Permission - \'" + PermissionLevel + "\': \'" + (index + 1) + "\' of \'" + PermissionLevelArray.size() + "\' levels to test")
			/*End common Feature function code*/

			/*Begin function code*/
			switch (PermissionLevel) {

				case 'No access':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				//if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType == 'Donate_SignIn_SettingsManager' || ScenarioType =='Donate_SignIn_CLSettingsManager'||ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
				//	WebUI.click(tObj_Settings_Selection)
				//	WebUI.verifyElementNotPresent(tObj_Settings_Theme, 3)
				//}
				/*else {
				 WebUI.click(tObj_Settings_Selection)
				 WebUI.click(tObj_Settings_Theme)
				 //verify only limited campuses available
				 System.out.println(WebUI.getText(tObj_Theme_LocationSelect_MainOnly))
				 if (WebUI.getText(tObj_Theme_LocationSelect_MainOnly) == "Main Campus") {
				 KeywordUtil.markPassed ("Limited Locations found for " + ScenarioType + " for " + PermissionLevel)
				 }else {
				 KeywordUtil.markFailed ("Limited Locations not found for " + ScenarioType + " for " + PermissionLevel)
				 }
				 def BackgroundColor
				 //if light not checked, click light
				 if (WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3, FailureHandling.OPTIONAL)) {
				 WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)
				 BackgroundColor = "light"
				 //else if light checked, click dark
				 }else if(WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorDarkChecked, 3, FailureHandling.OPTIONAL)) {
				 WebUI.click(tObj_Settings_BackgroundColorDarkUnchecked)
				 BackgroundColor = "dark"
				 }
				 //save
				 WebUI.verifyElementClickable(tObj_Save, FailureHandling.CONTINUE_ON_FAILURE)
				 WebUI.click(tObj_Save)
				 //refresh page
				 WebUI.refresh()
				 if (BackgroundColor == "light") {
				 //verify BC light is not selected
				 WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3)
				 }else if(BackgroundColor == "dark") {
				 //verify BC dark is selected
				 WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorDarkChecked, 3)
				 }
				 }*/

					WebUI.comment("Access for " + ScenarioType + " for " + PermissionLevel)

					break

				case 'View':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)


				//WebUI.click(tObj_Settings_Selection)

				//WebUI.click(tObj_Settings_Theme)

					WebUI.verifyTextPresent('Customize Theme', false)
					WebUI.verifyTextPresent('Preview Theme', false)
					WebUI.verifyTextPresent('Accent Color', false)
					WebUI.verifyTextPresent('Background Color', false)
					WebUI.verifyTextPresent('Light', false)
					WebUI.verifyTextPresent('Dark', false)
					WebUI.verifyTextPresent('White', false)
					WebUI.verifyTextPresent('Accent Color', false)
					WebUI.verifyTextPresent('Save', false)
					WebUI.verifyTextPresent('Location-specific Themes', false)
					WebUI.verifyTextPresent('If a location needs different branding, add it here or leave blank to use the organization\'s branding.', false)

					WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

					break

				case 'Edit':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				//Start test
				//find out if campus limited or not and check Main Campus or more than Main Campus with if/else ...take no access for campus limited Settings and Account manager away from no Access switch
				//click setting menu
				//WebUI.click(tObj_Settings_Selection)

				//click settings->locations
				//WebUI.click(tObj_Settings_Theme)
				//click location and select 'Main Campus'
				//WebUI.click(tObj_Theme_LocationSelect)

				//WebUI.selectOptionByLabel(tObj_Theme_LocationSelect, "Main Campus", false)
				//System.out.println(WebUI.getText(tObj_Theme_LocationSelect))

				//make sure BC light is selected
				//if (WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3,FailureHandling.OPTIONAL)) {

				//	WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)
				//	WebUI.click(tObj_Save)

				//	}



				default:
					WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
					KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
			}
		}
	}
}
