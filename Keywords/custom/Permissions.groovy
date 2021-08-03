package custom

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.ss.formula.functions.Today
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.time.TimeCategory as TimeCategory
import jdk.jfr.Frequency
import webUI.ContinueAs




public class Permissions {

	static void HelpCenterLink(Feature, ScenarioType, PermissionLevel, OrganizationName){
		WebUI.comment('Begin: Help_Center Permission Check')
		System.out.print("check permission level: " + PermissionLevel)
		//Object Validation - Campus

		System.out.print("Permission name: " + ScenarioType + ", Permission level: " + PermissionLevel + ", Test Organization: "+ OrganizationName)

		switch (PermissionLevel) {

			//Profile Title
			case 'Access':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
				TestObject tObj_Feature = new TestObject(Feature)

				tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[(text() = 'Center' or . = 'Center')]")

				WebUI.waitForElementPresent(tObj_Feature, 3)

				WebUI.click(tObj_Feature)

				TestObject tObj_HelpDeskPage = new TestObject('Help Desk Page')
			//tObj_HelpDeskPage.addProperty('xpath', ConditionType.EQUALS,"//div[@class = 'container-inner hero-unit__content' and (text() = 'How can we help?' or . = 'How can we help?')]")
				tObj_HelpDeskPage.addProperty('xpath', ConditionType.EQUALS, "//*[(text() = 'How can we help?' or . = 'How can we help?')]")

				WebUI.waitForElementPresent(tObj_HelpDeskPage, 3)

				break

			default:
				WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
				KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
		}
	}

	static void Dashboard(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName

		switch (PermissionLevel) {

			//Profile Title
			case 'View':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
				TestObject tObj_Feature = new TestObject(FeatureDescription)

				tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[(text() = ' Total Transaction Amount ' or . = ' Total Transaction Amount ')]")

				WebUI.waitForElementPresent(tObj_Feature, 3)
				WebUI.verifyElementPresent(tObj_Feature, 3)
				WebUI.verifyTextPresent('Total Transaction Amount', false)
				WebUI.verifyTextPresent('Largest Transaction', false)
				WebUI.verifyTextPresent('Average Transaction', false)

			//TestObject tObj_Users = new TestObject('Users')
			//tObj_Users.addProperty('xpath', ConditionType.EQUALS, "//*[(text() = ' Users ' or . = ' Users ')]")
			//WebUI.verifyElementPresent(tObj_Users, 3)
			//WebUI.comment('Element found')
				break

			case 'No view of stats':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
				TestObject tObj_Feature = new TestObject(FeatureDescription)

				tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[(text() = ' Total Transaction Amount ' or . = ' Total Transaction Amount ')]")
				WebUI.waitForElementNotPresent(tObj_Feature, 3)

				break

			case 'View only for their associated campus(es)':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject Org_OrganizationDashboardName = new TestObject('Organization Dashboard Title')
				Org_OrganizationDashboardName.addProperty('xpath', ConditionType.EQUALS,"//div[@class = 'clickable' and (text() = '$OrganizationName' or . = '$OrganizationName')]")
				WebUI.verifyElementPresent(Org_OrganizationDashboardName, 2)

				TestObject tObj_Feature = new TestObject(FeatureDescription)
				tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[(text() = ' Total Transaction Amount ' or . = ' Total Transaction Amount ')]")
				WebUI.waitForElementPresent(tObj_Feature, 3)

				WebUI.verifyTextPresent('Largest Transaction', false)
				WebUI.verifyTextPresent('Largest Transaction', false)

				break

			default:
				WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
				KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
		}
	}

	static void OrganizationProfile(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName

		switch (PermissionLevel) {

			//Profile Title
			case 'Access':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
				TestObject tObj_Feature = new TestObject(FeatureDescription)

				tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
				WebUI.waitForElementPresent(tObj_Feature, 3)
				WebUI.verifyElementPresent(tObj_Feature, 3)
				WebUI.click(tObj_Feature, 3)
				WebUI.verifyTextPresent('Organization Profile', false)

				break

			case 'No access':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
				TestObject tObj_Feature = new TestObject(FeatureDescription)

				TestObject tObj_Account = new TestObject('Account Menu')
				tObj_Account.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'account-menu' and (text() = ' Account ' or . = ' Account ')]")
				WebUI.verifyElementNotPresent(tObj_Account, 2)

				break

			case 'View':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
				TestObject tObj_Account = new TestObject('Account Menu')

				tObj_Account.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'account-menu' and (text() = ' Account ' or . = ' Account ')]")
				WebUI.click(tObj_Account)

				TestObject tObj_Profile_Selection = new TestObject('Profile Menu Item')
				tObj_Profile_Selection.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
				WebUI.click(tObj_Profile_Selection)

				WebUI.verifyTextPresent('Organization Profile', false)
				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

				break
			case 'Edit':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)


				break

			default:
				WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
				KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
		}
	}

	static void OrganizationNotesOnProfile(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName

		switch (PermissionLevel) {

			//Profile Title
			/*case 'Access':
			 WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
			 TestObject tObj_Account = new TestObject('Account Menu')
			 tObj_Account.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'account-menu' and (text() = ' Account ' or . = ' Account ')]")
			 WebUI.click(tObj_Account)
			 TestObject tObj_Feature = new TestObject(FeatureDescription)
			 tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
			 WebUI.waitForElementPresent(tObj_Feature, 3)
			 WebUI.verifyElementPresent(tObj_Feature, 3)
			 WebUI.click(tObj_Feature, 3)
			 WebUI.verifyTextPresent('Organization Profile', false)
			 break*/

			case 'No access':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
				TestObject tObj_Account = new TestObject('Account Menu')
				tObj_Account.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'account-menu' and (text() = ' Account ' or . = ' Account ')]")

				if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
					WebUI.verifyElementNotPresent(tObj_Account, 3)
				}
				else {
					WebUI.click(tObj_Account)

					TestObject tObj_Profile_Selection = new TestObject('Profile Menu Item')
					tObj_Profile_Selection.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
					WebUI.click(tObj_Profile_Selection)

					TestObject tObj_OrganizationNotesText = new TestObject('Organization Profile Notes text')
					tObj_OrganizationNotesText.addProperty('xpath', ConditionType.EQUALS, "//*div[@class = 'd-flex justify-content-between' and (text() = 'Notes' or . = 'Notes')]")

					WebUI.verifyElementNotPresent(tObj_OrganizationNotesText, 3)
				}

				break

			case 'View':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
				TestObject tObj_Account = new TestObject('Account Menu')

				tObj_Account.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'account-menu' and (text() = ' Account ' or . = ' Account ')]")
				WebUI.click(tObj_Account)

				TestObject tObj_Profile_Selection = new TestObject('Profile Menu Item')
				tObj_Profile_Selection.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
				WebUI.click(tObj_Profile_Selection)

				WebUI.verifyTextPresent('Organization Profile', false)
				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

				break
			case 'Edit':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)


				break

			default:
				WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
				KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
		}
	}

	static void OrganizationStatusOnProfile(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName

		switch (PermissionLevel) {

			//Profile Title
			/*case 'Access':
			 WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
			 TestObject tObj_Feature = new TestObject(FeatureDescription)
			 tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
			 WebUI.waitForElementPresent(tObj_Feature, 3)
			 WebUI.verifyElementPresent(tObj_Feature, 3)
			 WebUI.click(tObj_Feature, 3)
			 WebUI.verifyTextPresent('Organization Profile', false)
			 break*/

			case 'No access':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Account = new TestObject('Account Menu')
				tObj_Account.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'account-menu' and (text() = ' Account ' or . = ' Account ')]")

				if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
					WebUI.verifyElementNotPresent(tObj_Account, 3)
				}
				else {
					WebUI.click(tObj_Account)

					TestObject tObj_Profile_Selection = new TestObject('Profile Menu Item')
					tObj_Profile_Selection.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
					WebUI.click(tObj_Profile_Selection)

					TestObject tObj_OrganizationNotesText = new TestObject('Organization Profile Notes text')
					tObj_OrganizationNotesText.addProperty('xpath', ConditionType.EQUALS, "//td[(text() = 'Main Campus' or . = 'Main Campus')]")

					WebUI.verifyElementNotPresent(tObj_OrganizationNotesText, 3)
				}

				break

			case 'View':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Account = new TestObject('Account Menu')

				tObj_Account.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'account-menu' and (text() = ' Account ' or . = ' Account ')]")
				WebUI.click(tObj_Account)

				TestObject tObj_Profile_Selection = new TestObject('Profile Menu Item')
				tObj_Profile_Selection.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
				WebUI.click(tObj_Profile_Selection)

				WebUI.verifyTextPresent('Organization Profile', false)
				WebUI.verifyTextPresent('Organization Status', false)
				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

				break
			case 'Edit':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)


				break

			default:
				WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
				KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
		}
	}

	static void Campuses(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName

		switch (PermissionLevel) {

			//Profile Title
			/*case 'Access':
			 WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
			 TestObject tObj_Feature = new TestObject(FeatureDescription)
			 tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
			 WebUI.waitForElementPresent(tObj_Feature, 3)
			 WebUI.verifyElementPresent(tObj_Feature, 3)
			 WebUI.click(tObj_Feature, 3)
			 WebUI.verifyTextPresent('Organization Profile', false)
			 break*/

			case 'No access':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Account = new TestObject('Account Menu')
				tObj_Account.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'account-menu' and (text() = ' Account ' or . = ' Account ')]")

				if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
					WebUI.verifyElementNotPresent(tObj_Account, 3)
				}
				else {
					WebUI.click(tObj_Account)

					TestObject tObj_Profile_Selection = new TestObject('Profile Menu Item')
					tObj_Profile_Selection.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
					WebUI.click(tObj_Profile_Selection)

					TestObject tObj_OrganizationNotesText = new TestObject('Organization Profile Notes text')
					tObj_OrganizationNotesText.addProperty('xpath', ConditionType.EQUALS, "//*div[@class = 'd-flex justify-content-between' and (text() = 'Notes' or . = 'Notes')]")

					WebUI.verifyElementNotPresent(tObj_OrganizationNotesText, 3)
				}

				break

			case 'View':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Settings = new TestObject('Settings Menu')

				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
				WebUI.click(tObj_Settings)

				TestObject tObj_Settings_Locations = new TestObject('Settings Menu Item')
				tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
				WebUI.click(tObj_Settings_Locations)

				WebUI.verifyTextPresent('Locations', false)
				WebUI.verifyTextPresent('Main Campus', false)

				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

				break
			case 'Edit':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Settings = new TestObject('Settings Menu')

				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
				WebUI.click(tObj_Settings)

				TestObject tObj_Settings_Locations = new TestObject('Settings Menu Item')
				tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
				WebUI.click(tObj_Settings_Locations)

				WebUI.verifyTextPresent('Locations', false)

				TestObject tObj_Locations = new TestObject('Locations')
				tObj_Locations.addProperty('xpath', ConditionType.EQUALS,"//td[(text() = 'Main Campus' or . = 'Main Campus')]")
				WebUI.click(tObj_Locations)

				TestObject tObj_LocationName = new TestObject('Location Name')
				tObj_LocationName.addProperty('xpath', ConditionType.EQUALS,"//div[@class='form-group ng-star-inserted' and (text() = 'Location Name' or . = 'Location Name')]")
				WebUI.verifyElementPresent(tObj_LocationName,3)

				TestObject tObj_SaveButton = new TestObject('Save Button')
				tObj_SaveButton.addProperty('xpath', ConditionType.EQUALS,"//button[@class='btn btn-primary' and (text() = ' Save ' or . = ' Save ')]")
				WebUI.verifyElementPresent(tObj_SaveButton,3)

				TestObject tObj_CancelButton = new TestObject('Status Toggle')
				tObj_CancelButton.addProperty('xpath', ConditionType.EQUALS,"//button[@class='btn btn-secondary ng-star-inserted' and (text() = ' Cancel ' or . = ' Cancel ')]")
				WebUI.verifyElementClickable(tObj_CancelButton)

				TestObject tObj_Status = new TestObject('Status Toggle')
				tObj_Status.addProperty('xpath', ConditionType.EQUALS,"//td[(text() = 'Main Campus' or . = 'Main Campus')]")
				WebUI.click(tObj_Status)

				TestObject tObj_Displayed = new TestObject('Displayed Toggle')
				tObj_Displayed.addProperty('xpath', ConditionType.EQUALS,"//td[(text() = 'Main Campus' or . = 'Main Campus')]")
				WebUI.verifyElementClickable(tObj_Displayed)

			//TestObject tObj_SaveButton = new TestObject('Save Button')
				tObj_SaveButton.addProperty('xpath', ConditionType.EQUALS,"//button[@class='btn btn-primary' and (text() = ' Save ' or . = ' Save ')]")
				WebUI.verifyElementverifyElementPresent(tObj_SaveButton,3)

				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

			case 'Delete':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Settings = new TestObject('Account Menu')

				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
				WebUI.click(tObj_Settings)

				TestObject tObj_Settings_Locations = new TestObject('Profile Menu Item')
				tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
				WebUI.click(tObj_Settings_Locations)

				WebUI.verifyTextPresent('Locations', false)
				WebUI.verifyTextPresent('Main Campus', false)

				TestObject tObj_Locations = new TestObject('Locations')
				tObj_Locations.addProperty('xpath', ConditionType.EQUALS,"//td[(text() = 'Main Campus' or . = 'Main Campus')]")
				WebUI.click(tObj_Locations)

				TestObject tObj_LocationName = new TestObject('Location Name')
				tObj_LocationName.addProperty('xpath', ConditionType.EQUALS,"//td[(text() = 'Main Campus' or . = 'Main Campus')]")
				WebUI.click(tObj_LocationName)



				TestObject tObj_Status = new TestObject('Status Toggle')
				tObj_Status.addProperty('xpath', ConditionType.EQUALS,"//td[(text() = 'Main Campus' or . = 'Main Campus')]")
				WebUI.click(tObj_Status)

				TestObject tObj_Displayed = new TestObject('Displayed Toggle')
				tObj_Displayed.addProperty('xpath', ConditionType.EQUALS,"//td[(text() = 'Main Campus' or . = 'Main Campus')]")
				WebUI.click(tObj_Displayed)

				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)
				break

			default:
				WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
				KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
		}
	}

	static void AddCampus(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName

		switch (PermissionLevel) {

			case 'No access':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Settings = new TestObject('Settings Menu')
				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")

				if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType == 'Donate_SignIn_SettingsManager' || ScenarioType =='Donate_SignIn_CLSettingsManager'||ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
					WebUI.click(tObj_Settings)

					TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
					tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")

					WebUI.verifyElementNotPresent(tObj_Settings_Locations, 3)
				}
				else {
					WebUI.click(tObj_Settings)

					//TestObject tObj_Settings_Selection = new TestObject('Settings Menu')
					//tObj_Settings_Selection.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
					//WebUI.click(tObj_Settings_Selection)

					TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
					tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
					WebUI.click(tObj_Settings_Locations)

					TestObject tObj_Locations_Add = new TestObject('Location Add Button')
					tObj_Locations_Add.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'btn-add']")
					WebUI.verifyElementNotPresent(tObj_Locations_Add,3)

					WebUI.comment("Access for " + ScenarioType + " for " + PermissionLevel)
				}

				break

			case 'Add':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Settings = new TestObject('Settings Menu')
				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
				WebUI.click(tObj_Settings)

				TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
				tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
				WebUI.click(tObj_Settings_Locations)

				TestObject tObj_Locations_Add = new TestObject('Location Add Button')
				tObj_Locations_Add.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'btn-add']")
				WebUI.verifyElementPresent(tObj_Locations_Add,3)

				WebUI.click(tObj_Locations_Add)
				WebUI.verifyTextPresent('Add Location', false)

				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

				break


			default:
				WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
				KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
		}
	}

	static void SetCampusLimit(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName

		switch (PermissionLevel) {

			//Profile Title
			/*case 'Access':
			 WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
			 TestObject tObj_Feature = new TestObject(FeatureDescription)
			 tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
			 WebUI.waitForElementPresent(tObj_Feature, 3)
			 WebUI.verifyElementPresent(tObj_Feature, 3)
			 WebUI.click(tObj_Feature, 3)
			 WebUI.verifyTextPresent('Organization Profile', false)
			 break*/

			case 'No access':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Settings = new TestObject('Settings Menu')
				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")

				if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType == 'Donate_SignIn_SettingsManager' || ScenarioType =='Donate_SignIn_CLSettingsManager'||ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
					WebUI.click(tObj_Settings)

					TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
					tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")

					WebUI.verifyElementNotPresent(tObj_Settings_Locations, 3)
				}
				else {
					WebUI.click(tObj_Settings)

					//TestObject tObj_Settings_Selection = new TestObject('Settings Menu')
					//tObj_Settings_Selection.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
					//WebUI.click(tObj_Settings_Selection)

					TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
					tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
					WebUI.click(tObj_Settings_Locations)

					TestObject tObj_Locations_Add = new TestObject('Location Add Button')
					tObj_Locations_Add.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'btn-add']")
					WebUI.verifyElementNotPresent(tObj_Locations_Add,3)

					WebUI.comment("Access for " + ScenarioType + " for " + PermissionLevel)
				}

				break

			case 'View':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Settings = new TestObject('Settings Menu')
				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
				WebUI.click(tObj_Settings)

				TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
				tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
				WebUI.click(tObj_Settings_Locations)

				TestObject tObj_Locations_Limit = new TestObject('Location Limit')
				tObj_Locations_Limit.addProperty('xpath', ConditionType.EQUALS,"//span[@class = 'ng-star-inserted' and (text() = ' Limit: 5 ' or . = ' Limit: 5 ')]")
				WebUI.verifyElementPresent(tObj_Locations_Limit,3)


				WebUI.verifyTextPresent('Location Limit:', false)

				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

				break

			case 'Edit':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Settings = new TestObject('Settings Menu')
				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
				WebUI.click(tObj_Settings)

				TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
				tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
				WebUI.click(tObj_Settings_Locations)

				TestObject tObj_Locations_Add = new TestObject('Location Add Button')
				tObj_Locations_Add.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'btn-add']")
				WebUI.verifyElementPresent(tObj_Locations_Add,3)

				WebUI.click(tObj_Locations_Add)
				WebUI.verifyTextPresent('Add Location', false)

				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

				break

			default:
				WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
				KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
		}
	}

	static void CustomMessaging(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName

		switch (PermissionLevel) {

			case 'No access':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Settings = new TestObject('Settings Menu')
				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")

				if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType == 'Donate_SignIn_SettingsManager' || ScenarioType =='Donate_SignIn_CLSettingsManager'||ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
					WebUI.click(tObj_Settings)

					TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
					tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")

					WebUI.verifyElementNotPresent(tObj_Settings_Locations, 3)
				}
				else {
					WebUI.click(tObj_Settings)

					//TestObject tObj_Settings_Selection = new TestObject('Settings Menu')
					//tObj_Settings_Selection.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
					//WebUI.click(tObj_Settings_Selection)

					TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
					tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
					WebUI.click(tObj_Settings_Locations)

					TestObject tObj_Locations_Add = new TestObject('Location Add Button')
					tObj_Locations_Add.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'btn-add']")
					WebUI.verifyElementNotPresent(tObj_Locations_Add,3)

					WebUI.comment("Access for " + ScenarioType + " for " + PermissionLevel)
				}

				break

			case 'View':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				TestObject tObj_Settings = new TestObject('Settings Menu')
				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
				WebUI.click(tObj_Settings)

				TestObject tObj_Settings_Locations = new TestObject('Messaging Menu Item')
				tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/messaging' and (text() = 'Messaging' or . = 'Messaging')]")
				WebUI.click(tObj_Settings_Locations)

				WebUI.verifyTextPresent('On Screen Thank You', false)
				WebUI.verifyTextPresent('One Time Donation', false)
				WebUI.verifyTextPresent('Recurring Donation Setup', false)
				WebUI.verifyTextPresent('One Time Purchase', false)
				WebUI.verifyTextPresent('Recurring Purchase Setup', false)
				WebUI.verifyTextPresent('Email Receipt', false)
				WebUI.verifyTextPresent('One Time Donation', false)
				WebUI.verifyTextPresent('Recurring Donation Setup', false)
				WebUI.verifyTextPresent('One Time Purchase', false)
				WebUI.verifyTextPresent('Recurring Purchase Setup', false)
				WebUI.verifyTextPresent('Printed Receipt', false)
				WebUI.verifyTextPresent('Donation Receipt', false)
				WebUI.verifyTextPresent('Purchase Receipt', false)
				WebUI.verifyTextPresent('Pledges and Goals', false)
				WebUI.verifyTextPresent('Pledge Fulfilled Email', false)
				WebUI.verifyTextPresent('Transaction Message', false)
				WebUI.verifyTextPresent('Donation', false)
				WebUI.verifyTextPresent('Purchase', false)
				WebUI.verifyTextPresent('Custom Terms', false)
				WebUI.verifyTextPresent('ENGLISH WORDS', false)
				WebUI.verifyTextPresent('SPANISH WORDS', false)

				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

				break

			case 'Edit':
				WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

			//create test objects
				TestObject tObj_Settings = new TestObject('Settings Menu')
				tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")

				TestObject tObj_Settings_Locations = new TestObject('Messaging Menu Item')
				tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/messaging' and (text() = 'Messaging' or . = 'Messaging')]")

				TestObject  tObj_OneTimeDonation_CustomTextField= new TestObject('OneTimeDonation_TextField')
				tObj_OneTimeDonation_CustomTextField.addProperty('xpath', ConditionType.EQUALS,"(.//*[normalize-space(text()) and normalize-space(.)='CUSTOM TEXT'])[1]/following::textarea[1]")

				TestObject tObj_OneTimeDonation_CustomTextToggle = new TestObject('One Time Donation Custom Text Toggle')
				tObj_OneTimeDonation_CustomTextToggle.addProperty('xpath', ConditionType.EQUALS,"//div[@class='custom-control custom-switch custom-switch-md']")

				TestObject tObj_EnabledOneTimeDonationToggle_Label = new TestObject('Custom Text Toggle Enabled Label')
				tObj_EnabledOneTimeDonationToggle_Label.addProperty('xpath', ConditionType.EQUALS,"//label[@class = 'custom-control-label' and @for = 'OnScreenThankYouDonationOneTime-enabled' and (text() = ' Enabled ' or . = ' Enabled ')]")

				TestObject tObj_DisabledOneTimeDonationToggle_Label = new TestObject('Custom Text Toggle Disabled Label')
				tObj_DisabledOneTimeDonationToggle_Label.addProperty('xpath', ConditionType.EQUALS,"//label[@class = 'custom-control-label' and @for = 'OnScreenThankYouDonationOneTime-disabled' and (text() = ' Disabled ' or . = ' Disabled ')]")

				TestObject tObj_Save = new TestObject('Save Button')
				tObj_Save.addProperty('xpath', ConditionType.EQUALS,"//button[@class='btn btn-primary' and (text() = 'Save' or . = 'Save')]")

			//define variables
				def input_Value
				def OneTimeDonationText = "TEST - Text for One Time Donation text box"


			//Start test

			//click setting menu
				WebUI.click(tObj_Settings)

			//click settings->locations
				WebUI.click(tObj_Settings_Locations)

			//clear text and reset Custom Text to disabled
				if (WebUI.verifyElementVisible(tObj_EnabledOneTimeDonationToggle_Label, FailureHandling.OPTIONAL)) {
					WebUI.click(tObj_OneTimeDonation_CustomTextToggle)
					WebUI.comment('Custom Text Toggle was set to Disabled')
				}

				input_Value = WebUI.getAttribute(tObj_OneTimeDonation_CustomTextField, 'value')
				if (input_Value == ""){
					WebUI.comment("One Time Donation Custom Message Text area empty")
				}else{

					WebUI.clearText(tObj_OneTimeDonation_CustomTextField)
					input_Value = WebUI.getAttribute(tObj_OneTimeDonation_CustomTextField, 'value')
					WebUI.verifyMatch(input_Value, '',false)
					input_Value = ""
					WebUI.comment("One Time Donation Custom Message Text area cleared and is now empty")
				}

			//save text
				WebUI.click(tObj_Save)

			//enter test text into text field

				WebUI.setText(tObj_OneTimeDonation_CustomTextField, OneTimeDonationText)

			//save text
				WebUI.click(tObj_Save)

			//verify text value in field was saved
				input_Value = WebUI.getAttribute(tObj_OneTimeDonation_CustomTextField, 'value')
				WebUI.verifyMatch(OneTimeDonationText, input_Value, false)

			//toggle to enable
				WebUI.click(tObj_OneTimeDonation_CustomTextToggle)

			//verify toggle enabled
				WebUI.verifyElementVisible(tObj_EnabledOneTimeDonationToggle_Label, FailureHandling.CONTINUE_ON_FAILURE)

			//save toggle
				WebUI.click(tObj_Save)

			//verify text and toggle enabled saved
				WebUI.verifyMatch(OneTimeDonationText, input_Value, false)
				WebUI.verifyElementVisible(tObj_EnabledOneTimeDonationToggle_Label, FailureHandling.CONTINUE_ON_FAILURE)

			//set text to ''
			//WebUI.clearText(tObj_OneTimeDonation_CustomTextField)
				WebUI.setText(tObj_OneTimeDonation_CustomTextField, '')
			//save
				WebUI.click(tObj_Save)

			//verify text clear and toggle enabled
				input_Value = WebUI.getAttribute(tObj_OneTimeDonation_CustomTextField, 'value')
				WebUI.verifyElementVisible(tObj_EnabledOneTimeDonationToggle_Label, FailureHandling.CONTINUE_ON_FAILURE)
				WebUI.verifyMatch('', input_Value, false)

			//click toggle to disable
				WebUI.click(tObj_OneTimeDonation_CustomTextToggle)

			//save
				WebUI.click(tObj_Save)

			//get text value
				input_Value = WebUI.getAttribute(tObj_OneTimeDonation_CustomTextField, 'value')

			//verify text value is blank and custom message toggle is disabled
				WebUI.verifyMatch('', input_Value, false)
				WebUI.verifyElementNotPresent(tObj_EnabledOneTimeDonationToggle_Label,3)

				WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)

			//WebUI.setText(tObj_OneTimeDonation_CustomTextField, '')

			//save
			//WebUI.click(tObj_Save)

				break

			default:
				WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
				KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
		}
	}


}
