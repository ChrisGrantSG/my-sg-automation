package features

import com.applitools.eyes.config.Feature
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class Campus {

	/*Start common Feature function code
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
	 End common Feature function code
	 Begin function code*/

	static void Campuses(Feature, ScenarioType, PermissionLevel,OrganizationName){

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
			System.out.println("index = " + index)
			System.out.println(PermissionLevelArray[index])
			PermissionLevel = PermissionLevelArray[index]
			System.out.println("Permission - \'" + PermissionLevel + "\': \'" + (index + 1) + "\' of \'" + PermissionLevelArray.size() + "\' levels to test")
			/*End common Feature function code*/

			/*Begin function code*/
			switch (PermissionLevel) {

				case 'No access':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

					TestObject tObj_Account = new TestObject('Account Menu')
				//WebUI.verifyElementPresent(tObj_Account, 5)
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

					TestObject tObj_CancelButton = new TestObject('Cancel Button')
					tObj_CancelButton.addProperty('xpath', ConditionType.EQUALS,"//button[@class='btn btn-secondary ng-star-inserted' and (text() = ' Cancel ' or . = ' Cancel ')]")
					WebUI.verifyElementClickable(tObj_CancelButton)

				//TestObject tObj_StatusToggleSwitch = new TestObject('Status Toggle Switch')
				//tObj_StatusToggleSwitch.addProperty('xpath', ConditionType.EQUALS,"//div[@class='custom-control custom-switch custom-switch-md' and @for = 'active' and (text() = ' Disabled ' or . = ' Disabled ')]")

				//TestObject tObj_StatusToggleBanner = new TestObject('Status Toggle Banner Text')
				//tObj_StatusToggleBanner.addProperty('xpath', ConditionType.EQUALS,"//label[@class = 'custom-control-input' and @for = 'active' and (text() = ' Disabled ' or . = ' Disabled ')]")

				//Status (enabled)
					TestObject tObj_LocationStatusEnabled = new TestObject('Location Status Enabled Toggle')
					tObj_LocationStatusEnabled.addProperty('xpath', ConditionType.EQUALS,"(.//*[normalize-space(text()) and normalize-space(.)='Status (enabled)'])[1]/following::div[1]")

				//Status (disabled)
					TestObject tObj_LocationStatusDisabled = new TestObject('Location Status Enabled Toggle')
					tObj_LocationStatusDisabled.addProperty('xpath', ConditionType.EQUALS,"(.//*[normalize-space(text()) and normalize-space(.)='Status (disabled)'])[1]/following::div[1]")

				//Displayed (displayed)
					TestObject tObj_LocationDisplayed = new TestObject('Location Displayed Toggle')
					tObj_LocationDisplayed.addProperty('xpath', ConditionType.EQUALS,"(.//*[normalize-space(text()) and normalize-space(.)='Displayed (displayed)'])[1]/following::div[1]")

				//Displayed (hidden)
					TestObject tObj_LocationHidden = new TestObject('Location Hidden Toggle')
					tObj_LocationHidden.addProperty('xpath', ConditionType.EQUALS,"(.//*[normalize-space(text()) and normalize-space(.)='Displayed (hidden)'])[1]/following::div[1]")

				//click Status toggle to verify edit
					if (WebUI.verifyElementPresent(tObj_LocationStatusEnabled, 3, FailureHandling.OPTIONAL)) {
						WebUI.click(tObj_LocationStatusEnabled)
					}else {
						if (WebUI.verifyElementPresent(tObj_LocationStatusEnabled, 3, FailureHandling.OPTIONAL)) {
							WebUI.click(tObj_LocationStatusDisabled)
						}else {
							WebUI.comment("tObj_LocationStatusEnabled not found")
						}
					}

				//click Displayed toggle to verify edit
					if (WebUI.verifyElementVisible(tObj_LocationDisplayed, FailureHandling.OPTIONAL)) {
						WebUI.click(tObj_LocationDisplayed)
					}else {
						if (WebUI.verifyElementPresent(tObj_LocationStatusEnabled, 3, FailureHandling.OPTIONAL)) {
							WebUI.click(tObj_LocationHidden)
						}else {
							WebUI.comment("tObj_LocationStatusEnabled not found")
						}
					}

					tObj_SaveButton.addProperty('xpath', ConditionType.EQUALS,"//button[@class='btn btn-primary' and (text() = ' Save ' or . = ' Save ')]")
					WebUI.verifyElementPresent(tObj_SaveButton,3)
					WebUI.verifyElementClickable(tObj_SaveButton)

					WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)
					break

				case 'View and Edit only for associated campus(es)':

					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)

					KeywordUtil.markWarning('This feature not tested yet')

					WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)
					break
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
					WebUI.verifyElementPresent(tObj_Locations,3)
					WebUI.click(tObj_Locations)

					WebUI.verifyTextPresent('Delete', false)

				//TestObject tObj_DeleteButton = new TestObject('Delete Button')
				//tObj_DeleteButton.addProperty('xpath', ConditionType.EQUALS,"//div[@id='btn-delete' and (text() = ' Delete Location ' or . = ' Delete Location ')]")
				//WebUI.click(tObj_DeleteButton)

					WebUI.comment("Found " + ScenarioType + " for " + PermissionLevel)
					break

				default:
					WebUI.comment("****** " + ScenarioType + " for " + PermissionLevel + " >> Test Not Found <<")
					KeywordUtil.markFailedAndStop ("ScenarioType not found " + ScenarioType + " for " + PermissionLevel)
			}
		}
	}

	static void AddCampus(Feature, ScenarioType, PermissionLevel,OrganizationName){

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
						tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")

						WebUI.verifyElementNotPresent(tObj_Settings_Locations, 3)
					}
					else if (ScenarioType=='Donate_SignIn_CLAccountManager') {
						WebUI.click(tObj_Settings)

						//TestObject tObj_Settings_Selection = new TestObject('Settings Menu')
						//tObj_Settings_Selection.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
						//WebUI.click(tObj_Settings_Selection)

						//******This test will fail because it should not see the Add Campus button and it is there.

						TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
						tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
						WebUI.click(tObj_Settings_Locations)

						TestObject tObj_Locations_Add = new TestObject('Location Add Button')
						tObj_Locations_Add.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'btn-add']")
						WebUI.verifyElementNotPresent(tObj_Locations_Add,3)
					}
					else {
						WebUI.click(tObj_Settings)

						//TestObject tObj_Settings_Selection = new TestObject('Settings Menu')
						//tObj_Settings_Selection.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
						//WebUI.click(tObj_Settings_Selection)


						//******This test will fail because it should not see the Add Campus button and it is there.


						TestObject tObj_Settings_Locations = new TestObject('Locations Menu Item')
						tObj_Settings_Locations.addProperty('xpath', ConditionType.EQUALS,"//*[@href = '/admin/automation-2020-1/locations' and (text() = 'Locations' or . = 'Locations')]")
						WebUI.click(tObj_Settings_Locations)

						TestObject tObj_Locations_Add = new TestObject('Location Add Button')
						tObj_Locations_Add.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'btn-add']")
						WebUI.verifyElementPresent(tObj_Locations_Add,3)

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
	}

	static void SetCampusLimit(Feature, ScenarioType, PermissionLevel,OrganizationName){

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
	}

}
