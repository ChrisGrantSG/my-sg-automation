package features

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class Organizations {

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


	static void OrganizationProfile(Feature, ScenarioType, PermissionLevel,OrganizationName){

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

				//Profile Title
				case 'Access':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
					TestObject tObj_Feature = new TestObject(FeatureDescription)

					tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[@href = '/admin/automation-2020-1/profile' and (text() = 'Profile' or . = 'Profile')]")
					WebUI.waitForElementPresent(tObj_Feature, 3)

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

					WebUI.waitForElementPresent(tObj_Account, 3)
					WebUI.waitForElementClickable(tObj_Account, 3)

					WebUI.delay(3)
					WebUI.click(tObj_Account)

					TestObject tObj_Profile_Selection = new TestObject('Profile Menu Item')
					WebUI.waitForElementPresent(tObj_Profile_Selection, 3)
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
	}

	static void OrganizationNotesOnProfile(Feature, ScenarioType, PermissionLevel,OrganizationName){

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
	}

	static void OrganizationStatusOnProfile(Feature, ScenarioType, PermissionLevel,OrganizationName){

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
	}
}
