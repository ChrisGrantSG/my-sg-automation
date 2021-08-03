import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.comment('Story: User wants to select how to give')

WebUI.comment('Given that the user is giving and How would you like to give page present')

WebUI.verifyElementPresent(findTestObject('Page_How To Give/div_Donation'), 3000)

WebUI.comment('Choose the giving type')

TestObject tObj = new TestObject()

tObj.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='$GiftType'])[1]/following::*[name()='svg'][1]")
//(.//*[normalize-space(text()) and normalize-space(.)='Donation'])[1]/following::*[name()='svg'][1]

//WebUI.click(findTestObject('Page_How To Give/div_Donation'))

WebUI.comment('User is taken the the proper Give To page')

WebUI.verifyElementPresent(findTestObject('Page_Give to/p_Give to'), 3000)

