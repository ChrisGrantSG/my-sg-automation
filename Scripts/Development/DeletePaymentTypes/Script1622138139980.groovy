import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('')

WebUI.navigateToUrl('https://sg-dev-web.securegive.com/login')

WebUI.setText(findTestObject('Object Repository/Page_Sign In  SecureGive/input_Forgot Password_emailOrPhone'), 'frank.page+kelly@securegive.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Sign In  SecureGive/input_Forgot Password_password'), 'p4nzqf2WPVEdgGhZ2tawDQ==')

WebUI.click(findTestObject('Object Repository/Page_Sign In  SecureGive/button_Sign In (1)'))

//WebUI.click(findTestObject('Object Repository/Page_My Organizations  My Account/button_Go to Organization'))

//WebUI.click(findTestObject('Object Repository/Page_Select an Option  Starr Pass Church-Au_4a073f/svg'))

//WebUI.click(findTestObject('Object Repository/Page_Starr Pass Church-Automation-Please do_7eccdb/svg'))

TestObject tObj_MemberProfile = new TestObject('Member Profile')

tObj_MemberProfile.addProperty('xpath', ConditionType.EQUALS, '(.//*[normalize-space(text()) and normalize-space(.)=\'My Organizations\'])[1]/preceding::*[name()=\'svg\'][1]')

//(.//*[normalize-space(text()) and normalize-space(.)='My Organizations'])[1]/preceding::*[name()='svg'][1]

//WebUI.click(findTestObject('Object Repository/Page_Donate  Starr Pass Church-Automation-P_f9dc6a/svg'))

WebUI.click(tObj_MemberProfile)

/*
 * WebUI.click(findTestObject('Object Repository/Page_Donate Starr Pass
 * Church-Automation-P_f9dc6a/button_Payment Methods'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/button_Edit'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/svg'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/button_Confirm'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/button_Edit'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/svg_1'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/button_Confirm'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/button_Update'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/svg_1_2'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/button_Confirm'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/button_Edit'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/svg-icon'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/button_Confirm'))
 * 
 * WebUI.click(findTestObject('Object Repository/Page_My Payment Methods My
 * Account/svg_1_2_3'))
 */

WebUI.click(findTestObject('Object Repository/Page_My Payment Methods  My Account/button_Recurring Transactions'))




//loop through all recurring transactions and delete
while (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_15.00'), 3)==true) {
	
	WebUI.click(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_15.00'))
	
	WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel'))
	
	WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Nov 30, 2020_btn icon-only prepend'))
	
	WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel Recurring'))
	
}
WebUI.click(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_15.00'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Nov 30, 2020_btn icon-only prepend'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel Recurring'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_15.00'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/div_Cancel'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Nov 30, 2020_btn icon-only prepend'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel Recurring'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_15.00'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Nov 30, 2020_btn icon-only prepend'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel Recurring'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_15.00'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/div_Cancel'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Nov 30, 2020_btn icon-only prepend'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel Recurring'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_15.00'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Nov 30, 2020_btn icon-only prepend'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel Recurring'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_15.00'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/div_Cancel'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Nov 30, 2020_btn icon-only prepend'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel Recurring'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_15.00'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/div_Cancel'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Nov 30, 2020_btn icon-only prepend'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel Recurring'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_59.00'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/div_Cancel'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Nov 30, 2020_btn icon-only prepend'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel Recurring'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Giving  My Account/td_59.00'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/div_Cancel'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Nov 30, 2020_btn icon-only prepend'))

WebUI.click(findTestObject('Object Repository/Page_Recurring Detail  My Account/button_Cancel Recurring'))

