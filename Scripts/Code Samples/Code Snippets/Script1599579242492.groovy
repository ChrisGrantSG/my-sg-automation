import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//for training purposes...
testButton = new TestObject()

testButton.addProperty('name', ConditionType.EQUALS, 'MyCustomButton' //works
	)

System.out.println(testButton.findPropertyValue('name') //works
	)

Org_Button = new TestObject('GoToOrganization_Button')

Org_Button.addProperty('xpath', ConditionType.EQUALS, '//app-profile-organizations/div/div[2]/div[4]/button')

//Org_Button.addProperty("xpath", ConditionType.EQUALS, "/html/body/app-root/app-profile-sidebar-layout/div/div/app-profile-organizations/div/div[2]/div[4]/button")
System.out.println(Org_Button.findPropertyValue('xpath'))

Org_Container = new TestObject('MyOrganization_Container')

Org_Container.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'(352) 434-3333\')]')

System.out.println(Org_Container.findPropertyValue('xpath'))

System.out.println(Org_Container.getParentObject())

System.out.println(Org_Container.getXpaths())

//todo: Bring if statement from above and surround below logic with it
//This works great!
TestObject tObj = new TestObject()

//tObj.addProperty("xpath", ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='${PhoneNumber}'])[1]/following::button[1]")
tObj.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='$PhoneNumber'])[1]/following::button[1]")

WebUI.click(tObj)


testButton = new TestObject()

testButton.addProperty('name', ConditionType.EQUALS, 'MyCustomButton' //works
		)

System.out.println(testButton.findPropertyValue('name') //works
		)

Org_Button = new TestObject('GoToOrganization_Button')

Org_Button.addProperty('xpath', ConditionType.EQUALS, '//app-profile-organizations/div/div[2]/div[4]/button')

//Org_Button.addProperty("xpath", ConditionType.EQUALS, "/html/body/app-root/app-profile-sidebar-layout/div/div/app-profile-organizations/div/div[2]/div[4]/button")
System.out.println(Org_Button.findPropertyValue('xpath'))

Org_Container = new TestObject('MyOrganization_Container')

Org_Container.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'(352) 434-3333\')]')

System.out.println(Org_Container.findPropertyValue('xpath'))

System.out.println(Org_Container.getParentObject())

System.out.println(Org_Container.getXpaths())






