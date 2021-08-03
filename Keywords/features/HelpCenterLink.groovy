package features
import com.applitools.eyes.config.Feature
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class HelpCenterLink {

	static void HelpCenterLinkAccess(Feature, ScenarioType, PermissionLevel, OrganizationName){
		System.out.println("Passed in variables are: " +  Feature + ", " + ScenarioType + ", " + PermissionLevel + ", " + OrganizationName)
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

			WebUI.comment('Begin: Help_Center Permission Check')
			System.out.print("check permission level: " + PermissionLevel)
			//Object Validation - Campus

			System.out.print("Permission name: " + ScenarioType + ", Permission level: " + PermissionLevel + ", Test Organization: "+ OrganizationName)

			switch (PermissionLevel) {

				//Profile Title
				case 'Access':
					WebUI.comment("testing " + ScenarioType + " for " + PermissionLevel)
					TestObject tObj_Feature = new TestObject(Feature)

					tObj_Feature.addProperty('xpath', ConditionType.EQUALS, "//*[(text() = 'Help ' or . = 'Help ')]")

					WebUI.waitForElementPresent(tObj_Feature, 5)

					WebUI.waitForElementClickable(tObj_Feature, 5)



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
	}
















}