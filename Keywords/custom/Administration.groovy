package custom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import custom.Custom_Functionality.*
import com.kms.katalon.core.testobject.ConditionType
import internal.GlobalVariable
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.*
import java.text.SimpleDateFormat as SimpleDateFormat


public class Administration {

	static void CreateNewAdminUser(OrganizationName){

		//def now = new Date()
		//System.out.println(now.format('yyyyMMddHHmmssSSS', TimeZone.getTimeZone('UTC'))
		//UTCTime = now.format('yyyyMMddHHmmssSSS', TimeZone.getTimeZone('UTC'))
		//System.out.println(UTCTime)

		//CustomKeywords.'webUI.Login.loginIntoApplication'("https://sg-dev-web.securegive.com/", "testing+automationsuperadmin@securegive.com", "8w9a2zVa0r6x8oBTljNeEA==")

		WebUI.click(findTestObject('testtemp/Page_Organizations/svg'))

		WebUI.setText(findTestObject('testtemp/Page_Organizations/input_Organizations_filter-text'),OrganizationName)

		WebUI.click(findTestObject('testtemp/Page_Organizations/td_automation-org-20201105182101967'))

		WebUI.click(findTestObject('Object Repository/testtemp/Page_Dashboard/button_Users'))

		WebUI.click(findTestObject('Object Repository/testtemp/Page_Dashboard/a_Administrators'))

		WebUI.click(findTestObject('testtemp/Page_Administrators/button_Administrators_btn-download'))

		WebUI.setText(findTestObject('testtemp/Page_Administrators/input_First Name_fistName'),
				'FirstName')

		WebUI.setText(findTestObject('testtemp/Page_Administrators/input_Last Name_lastName'),
				'LastName')

		WebUI.setText(findTestObject('testtemp/Page_Administrators/input_Email_email'),
				'frank.page+newAdmin@securegive.com')

		WebUI.selectOptionByValue(findTestObject('testtemp/Page_Administrators/select_Administrator  Account Manager  Repo_e3df32'),
				'Standard', true)

		WebUI.click(findTestObject('testtemp/Page_Administrators/div_All Locations'))

		WebUI.click(findTestObject('testtemp/Page_Administrators/span_Main Campus'))

		WebUI.verifyElementText(findTestObject('testtemp/Page_Administrators/input_First Name_fistName'),
				'')

		WebUI.verifyElementText(findTestObject('testtemp/Page_Administrators/input_Last Name_lastName'),
				'')

		WebUI.verifyElementText(findTestObject('testtemp/Page_Administrators/input_Email_email'),
				'')

		//WebUI.verifyElementText(findTestObject('testtemp/Page_Administrators/select_Administrator  Account Manager  Repo_e3df32'),
		//'Administrator Account Manager Reports Manager Member Manager Settings Manager Kiosk Manager')

		//WebUI.verifyElementText(findTestObject('testtemp/Page_Administrators/span_Main Campus'),
		// 'Main Campus')

		WebUI.verifyElementClickable(findTestObject('testtemp/Page_Administrators/button_Send Invite'))

		WebUI.verifyElementText(findTestObject('testtemp/Page_Administrators/svg'),
				'')

		//WebUI.verifyElementText(findTestObject('testtemp/Page_Administrators/path'),
		// '')

		WebUI.verifyElementPresent(findTestObject('testtemp/Page_Administrators/a_Terms of Service'),
				2)

		WebUI.verifyElementPresent(findTestObject('testtemp/Page_Administrators/a_Help Center'),
				2)

		WebUI.verifyElementPresent(findTestObject('testtemp/Page_Administrators/a_1 (855) 895-8951'),
				2)

		//WebUI.verifyElementPresent(findTestObject('testtemp/Page_Administrators/path'),
		// 2)

		WebUI.verifyElementPresent(findTestObject('testtemp/Page_Administrators/p_Send Invite_d-none d-lg-block'),
				2)
		WebUI.click(findTestObject('testtemp/Page_Administrators/button_Send Invite'))

		WebUI.closeBrowser()




	}
}


