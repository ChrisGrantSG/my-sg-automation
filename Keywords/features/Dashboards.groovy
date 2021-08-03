package features

import com.applitools.eyes.config.Feature
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class Dashboards {


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



	static void Dashboard(Feature, ScenarioType, PermissionLevel,OrganizationName){

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
	}
}
