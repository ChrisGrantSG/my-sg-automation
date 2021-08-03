import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.comment('Story: Make Campus Selection')

WebUI.comment('Given the Make Campus Selection page is present')

WebUI.verifyElementPresent(findTestObject('Page_Campus/span_Main Campus'), 3000)

WebUI.comment('Select Campus')

TestObject tObj = new TestObject()

tObj.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='$CampusName'])[1]/following::*[name()='svg'][1]")

WebUI.click(tObj)

//WebUI.click(findTestObject('Page_Campus/span_Main Campus'))

