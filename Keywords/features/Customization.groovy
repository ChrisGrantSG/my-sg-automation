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

public class Customization {

	static void CustomMessaging(Feature, ScenarioType, PermissionLevel,OrganizationName){

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

					TestObject tObj_Settings = new TestObject('Settings Menu')
					tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")

					if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType == 'Donate_SignIn_SettingsManager' || ScenarioType =='Donate_SignIn_CLSettingsManager'||ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
						WebUI.click(tObj_Settings)

						TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
						tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/messaging' and (text() = 'Messaging' or . = 'Messaging')]")

						WebUI.verifyElementNotPresent(tObj_Settings_Locations, 3)
					}
					else {
						WebUI.click(tObj_Settings)

						//TestObject tObj_Settings_Selection = new TestObject('Settings Menu')
						//tObj_Settings_Selection.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
						//WebUI.click(tObj_Settings_Selection)

						TestObject tObj_Settings_Messaging = new TestObject('Messaging Menu Item')
						tObj_Settings_Messaging.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/messaging' and (text() = 'Messaging' or . = 'Messaging')]")
						WebUI.click(tObj_Settings_Messaging)
						KeywordUtil.markFailedAndStop ("This has no purpose...fix it")
						//TestObject tObj_Messaging_Add = new TestObject('Location Add Button')
						//tObj_Messaging_Add.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'btn-add']")
						//WebUI.verifyElementNotPresent(tObj_Messaging_Add,3)

						// WebUI.comment("Access for " + ScenarioType + " for " + PermissionLevel)
					}
					WebUI.comment("Access for " + ScenarioType + " for " + PermissionLevel)
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
	static void CustomizeTheme(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName
		/*Start common Feature function code*/

		//Definitions


		//click Settings Menu
		TestObject tObj_Settings_Selection = new TestObject('Settings Menu')
		tObj_Settings_Selection.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")

		//click Theme Menu Item
		TestObject tObj_Settings_Theme = new TestObject('Theme Menu Item')
		tObj_Settings_Theme.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/theme' and (text() = 'Theme' or . = 'Theme')]")

		//Background color light selected
		TestObject tObj_Settings_BackgroundColorLightChecked = new TestObject('Background Color Light-checked')
		tObj_Settings_BackgroundColorLightChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and @class = 'checked' and (text() = ' Light ' or . = ' Light ')]")

		//Background color light unselected
		TestObject tObj_Settings_BackgroundColorLightUnchecked = new TestObject('Background Color Light-unchecked')
		tObj_Settings_BackgroundColorLightUnchecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and (text() = ' Light ' or . = ' Light ')]")

		//Background color dark selected
		TestObject tObj_Settings_BackgroundColorDarkChecked = new TestObject('Background Color Dark-checked')
		tObj_Settings_BackgroundColorDarkChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and @class = 'checked' and (text() = ' Dark ' or . = ' Dark ')]")

		//Background color dark unselected
		TestObject tObj_Settings_BackgroundColorDarkUnchecked = new TestObject('Background Color Dark-unchecked')
		tObj_Settings_BackgroundColorDarkUnchecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and (text() = ' Dark ' or . = ' Dark ')]")

		//Background color white selected
		TestObject tObj_Settings_BackgroundColorWhiteChecked = new TestObject('Background Color White-checked')
		tObj_Settings_BackgroundColorWhiteChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and @class = 'checked' and (text() = ' White ' or . = ' White ')]")

		//Background color white selected
		TestObject tObj_Settings_BackgroundColorWhiteUnChecked = new TestObject('Background Color White-unchecked')
		tObj_Settings_BackgroundColorWhiteUnChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and (text() = ' White ' or . = ' White ')]")

		//Background color accent selected
		TestObject tObj_Settings_BackgroundColorAccentChecked = new TestObject('Background Color Accent Color-checked')
		tObj_Settings_BackgroundColorAccentChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and @class = 'checked' and (text() = ' Accent' or . = ' Accent')]")

		//Background color accent selected
		TestObject tObj_Settings_BackgroundColorAccentUnChecked = new TestObject('Background Color Accent Color-unchecked')
		tObj_Settings_BackgroundColorAccentUnChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and (text() = ' Accent' or . = ' Accent')]")

		TestObject  tObj_Theme_LocationSelect= new TestObject('Location Selection')
		tObj_Theme_LocationSelect.addProperty('xpath', ConditionType.EQUALS,"//*[@name = 'themeLocation' and (text() = 'All Locations [Default]Main CampusSouth Campus' or . = 'All Locations [Default]Main CampusSouth Campus')]")

		TestObject  tObj_Theme_LocationSelect_MainOnly= new TestObject('Location Selection')
		tObj_Theme_LocationSelect_MainOnly.addProperty('xpath', ConditionType.EQUALS,"//*[@name = 'themeLocation' and (text() = 'Main Campus' or . = 'Main Campus')]")

		TestObject tObj_Theme_LocationFromList = new TestObject('Location From List')
		tObj_Theme_LocationFromList.addProperty('xpath', ConditionType.EQUALS,"//select[@class='ng-star-inserted' and (text() = 'Main Campus' or . = 'Main Campus')]")

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

					if (ScenarioType == 'Donate_SignIn_KioskManager'||ScenarioType == 'Donate_SignIn_SettingsManager' || ScenarioType =='Donate_SignIn_MemberManager'||ScenarioType =='Donate_SignIn_ReportsManager'||ScenarioType =='Donate_SignIn_CLReportsManager'){
						WebUI.click(tObj_Settings_Selection)
						WebUI.verifyElementNotPresent(tObj_Settings_Theme, 3)
					}else if (ScenarioType == 'Donate_SignIn_CLSettingsManager'||ScenarioType == 'Donate_SignIn_CLAccountManager'){
						//click setting menu
						WebUI.click(tObj_Settings_Selection)

						//click settings->locations
						WebUI.click(tObj_Settings_Theme)

						//click location and select 'Main Campus'
						WebUI.verifyElementNotPresent(tObj_Theme_LocationSelect,3)
						WebUI.verifyElementPresent(tObj_Theme_LocationSelect_MainOnly, 3)
					}

					WebUI.comment("Access for " + ScenarioType + " for " + PermissionLevel)

					break

				case 'View':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)


					WebUI.click(tObj_Settings_Selection)

					WebUI.click(tObj_Settings_Theme)

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
					WebUI.click(tObj_Settings_Selection)

				//click settings->locations
					WebUI.click(tObj_Settings_Theme)
				//click location and select 'Main Campus'
					WebUI.click(tObj_Theme_LocationSelect)

					WebUI.selectOptionByLabel(tObj_Theme_LocationSelect, "Main Campus", false)
					System.out.println(WebUI.getText(tObj_Theme_LocationSelect))

				//make sure BC light is selected
					if (WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3,FailureHandling.OPTIONAL)) {

						WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)
						WebUI.click(tObj_Save)

					}

				//select BC dark
					WebUI.click(tObj_Settings_BackgroundColorDarkUnchecked)

				//verify BC dark is selected
					WebUI.verifyElementPresent(tObj_Settings_BackgroundColorDarkChecked, 3)

				//verify BC light is not selected
					WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3)

				//save
					WebUI.verifyElementClickable(tObj_Save, FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.click(tObj_Save)

				//refresh page
					WebUI.refresh()

				//change location to 'Main Campus'
					WebUI.selectOptionByLabel(tObj_Theme_LocationSelect, "Main Campus", false)

				//verify BC dark is selected
					WebUI.verifyElementPresent(tObj_Settings_BackgroundColorDarkChecked, 3)

				//click BC light
					WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)

				//save selections
					WebUI.click(tObj_Save)

				//select All Locations
					WebUI.selectOptionByLabel(tObj_Theme_LocationSelect, "All Locations [Default]", false)

				//select light if not selected
					if (WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3,FailureHandling.OPTIONAL)) {

						WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)
						WebUI.click(tObj_Save)

					}

				//save selections
					WebUI.click(tObj_Save)

				//make sure BC light is selected again
					WebUI.verifyElementPresent(tObj_Settings_BackgroundColorLightChecked, 3)

					break

				default:
					WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
					KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
			}
		}
	}
	static void CampusTheme(Feature, ScenarioType, PermissionLevel,OrganizationName){

		def FeatureDescription = "Feature - '" + Feature + "' for user - '" + PermissionLevel + "' organization: " + OrganizationName
		/*Start common Feature function code*/

		//Definitions


		//click Settings Menu
		TestObject tObj_Settings_Selection = new TestObject('Settings Menu')
		tObj_Settings_Selection.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")

		//click Theme Menu Item
		TestObject tObj_Settings_Theme = new TestObject('Theme Menu Item')
		tObj_Settings_Theme.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/theme' and (text() = 'Theme' or . = 'Theme')]")

		//Background color light selected
		TestObject tObj_Settings_BackgroundColorLightChecked = new TestObject('Background Color Light-checked')
		tObj_Settings_BackgroundColorLightChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and @class = 'checked' and (text() = ' Light ' or . = ' Light ')]")

		//Background color light unselected
		TestObject tObj_Settings_BackgroundColorLightUnchecked = new TestObject('Background Color Light-unchecked')
		tObj_Settings_BackgroundColorLightUnchecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and (text() = ' Light ' or . = ' Light ')]")

		//Background color dark selected
		TestObject tObj_Settings_BackgroundColorDarkChecked = new TestObject('Background Color Dark-checked')
		tObj_Settings_BackgroundColorDarkChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and @class = 'checked' and (text() = ' Dark ' or . = ' Dark ')]")

		//Background color dark unselected
		TestObject tObj_Settings_BackgroundColorDarkUnchecked = new TestObject('Background Color Dark-unchecked')
		tObj_Settings_BackgroundColorDarkUnchecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and (text() = ' Dark ' or . = ' Dark ')]")

		//Background color white selected
		TestObject tObj_Settings_BackgroundColorWhiteChecked = new TestObject('Background Color White-checked')
		tObj_Settings_BackgroundColorWhiteChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and @class = 'checked' and (text() = ' White ' or . = ' White ')]")

		//Background color white selected
		TestObject tObj_Settings_BackgroundColorWhiteUnChecked = new TestObject('Background Color White-unchecked')
		tObj_Settings_BackgroundColorWhiteUnChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and (text() = ' White ' or . = ' White ')]")

		//Background color accent selected
		TestObject tObj_Settings_BackgroundColorAccentChecked = new TestObject('Background Color Accent Color-checked')
		tObj_Settings_BackgroundColorAccentChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and @class = 'checked' and (text() = ' Accent' or . = ' Accent')]")

		//Background color accent selected
		TestObject tObj_Settings_BackgroundColorAccentUnChecked = new TestObject('Background Color Accent Color-unchecked')
		tObj_Settings_BackgroundColorAccentUnChecked.addProperty('xpath', ConditionType.EQUALS,"//label[@tabindex = '0' and (text() = ' Accent' or . = ' Accent')]")

		TestObject  tObj_Theme_LocationSelect= new TestObject('Location Selection')
		tObj_Theme_LocationSelect.addProperty('xpath', ConditionType.EQUALS,"//*[@name = 'themeLocation' and (text() = 'All Locations [Default]Main CampusSouth Campus' or . = 'All Locations [Default]Main CampusSouth Campus')]")

		TestObject  tObj_Theme_LocationSelect_MainOnly= new TestObject('Location Selection')
		tObj_Theme_LocationSelect_MainOnly.addProperty('xpath', ConditionType.EQUALS,"//*[@name = 'themeLocation' and (text() = 'Main Campus' or . = 'Main Campus')]")

		TestObject tObj_Theme_LocationFromList = new TestObject('Location From List')
		tObj_Theme_LocationFromList.addProperty('xpath', ConditionType.EQUALS,"//select[@class='ng-star-inserted' and (text() = 'Main Campus' or . = 'Main Campus')]")

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
						WebUI.click(tObj_Settings_Selection)
						WebUI.verifyElementNotPresent(tObj_Settings_Theme, 3)
					}
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


					WebUI.click(tObj_Settings_Selection)

					WebUI.click(tObj_Settings_Theme)

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
					WebUI.click(tObj_Settings_Selection)

				//click settings->locations
					WebUI.click(tObj_Settings_Theme)
				//click location and select 'Main Campus'
					WebUI.click(tObj_Theme_LocationSelect)

					WebUI.selectOptionByLabel(tObj_Theme_LocationSelect, "Main Campus", false)
					System.out.println(WebUI.getText(tObj_Theme_LocationSelect))

				//make sure BC light is selected
					if (WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3,FailureHandling.OPTIONAL)) {

						WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)
						WebUI.click(tObj_Save)

					}

				//select BC dark
					WebUI.click(tObj_Settings_BackgroundColorDarkUnchecked)

				//verify BC dark is selected
					WebUI.verifyElementPresent(tObj_Settings_BackgroundColorDarkChecked, 3)

				//verify BC light is not selected
					WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3)

				//save
					WebUI.verifyElementClickable(tObj_Save, FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.click(tObj_Save)

				//refresh page
					WebUI.refresh()

				//change location to 'Main Campus'
					WebUI.selectOptionByLabel(tObj_Theme_LocationSelect, "Main Campus", false)

				//verify BC dark is selected
					WebUI.verifyElementPresent(tObj_Settings_BackgroundColorDarkChecked, 3)

				//click BC light
					WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)

				//save selections
					WebUI.click(tObj_Save)

				//select All Locations
					WebUI.selectOptionByLabel(tObj_Theme_LocationSelect, "All Locations [Default]", false)

				//select light if not selected
					if (WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3,FailureHandling.OPTIONAL)) {

						WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)
						WebUI.click(tObj_Save)

					}

				//save selections
					WebUI.click(tObj_Save)

				//make sure BC light is selected again
					WebUI.verifyElementPresent(tObj_Settings_BackgroundColorLightChecked, 3)

					break
				case 'View or Edit only for their associated campus(es)':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

				//Start test

				//click setting menu
					WebUI.click(tObj_Settings_Selection)

				//click settings->locations
					WebUI.click(tObj_Settings_Theme)
				//click location and select 'Main Campus'
					WebUI.click(tObj_Theme_LocationSelect_MainOnly)

					System.out.println(WebUI.getText(tObj_Theme_LocationSelect_MainOnly))
					if (!WebUI.getText(tObj_Theme_LocationSelect_MainOnly)=="Main Campus") {
						KeywordUtil.markFailed ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
					}

					WebUI.selectOptionByLabel(tObj_Theme_LocationSelect_MainOnly, "Main Campus", false)
					System.out.println(WebUI.getText(tObj_Theme_LocationSelect_MainOnly))

				//verify viewable
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

				//make sure BC light is selected
					if (WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3,FailureHandling.OPTIONAL)) {

						WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)
						WebUI.click(tObj_Save)

					}

				//select BC dark
					WebUI.click(tObj_Settings_BackgroundColorDarkUnchecked)

				//verify BC dark is selected
					WebUI.verifyElementPresent(tObj_Settings_BackgroundColorDarkChecked, 3)

				//verify BC light is not selected
					WebUI.verifyElementNotPresent(tObj_Settings_BackgroundColorLightChecked, 3)

				//save
					WebUI.verifyElementClickable(tObj_Save, FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.click(tObj_Save)

				//refresh page
					WebUI.refresh()

				//change location to 'Main Campus'
				//WebUI.selectOptionByLabel(tObj_Theme_LocationSelect, "Main Campus", false)

				//verify BC dark is selected
					WebUI.verifyElementPresent(tObj_Settings_BackgroundColorDarkChecked, 3)

				//click BC light
					WebUI.click(tObj_Settings_BackgroundColorLightUnchecked)

				//save selections
					WebUI.click(tObj_Save)

				//save selections
					WebUI.click(tObj_Save)

				//make sure BC light is selected again
					WebUI.verifyElementPresent(tObj_Settings_BackgroundColorLightChecked, 3)

					break
				default:
					WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
					KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
			}
		}
	}
}
