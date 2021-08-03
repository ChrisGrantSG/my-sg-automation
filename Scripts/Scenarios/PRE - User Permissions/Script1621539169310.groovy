import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.apache.commons.lang3.StringUtils as StringUtils
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.TestObjectXpath as TestObjectXpath
import java.text.DateFormat as DateFormat
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.*
import java.text.SimpleDateFormat as SimpleDateFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import org.openqa.selenium.WebElement as WebElement
import groovy.time.TimeCategory as TimeCategory
import custom.Custom_Functionality.*
import custom.WebPages.*
import webUI.MyOrganizations.*
import features.HelpCenterLinks.*
import internal.GlobalVariable as GlobalVariable

//Utilities
//create date for unique identification
//used in: email address
def now = new Date()

System.out.println(now.format('yyyyMMddHHmmssSSS', TimeZone.getTimeZone('UTC')))

UTCTime = now.format('yyyyMMddHHmmssSSS', TimeZone.getTimeZone('UTC'))

System.out.println(UTCTime)

//Test Description - taken from selected columns from data sheet to describe the test in general terms.
WebUI.comment(Description)

//Capture web version
/* Your test case steps */
//KeywordUtil.markPassed("Your log message here")
//return null
/*/***********************************************
Sign In_Page
as member or organization admin
************************************************/
CustomKeywords.'webUI.Login.loginIntoApplication'(GlobalVariable.SecureGiveURL, SignInName, SignInPassword)

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

def LoginUser = 'None'

//menu items
TestObject tObj_Analytics = new TestObject('Analytics Menu')

TestObject tObj_Account = new TestObject('Account Menu')

TestObject tObj_Users = new TestObject('Users Menu')

TestObject tObj_Reporting = new TestObject('Reporting Menu')

TestObject tObj_Categories = new TestObject('Categories Menu')

TestObject tObj_Settings = new TestObject('Settings Menu')

TestObject tObj_Notifications = new TestObject('Notifications Link')

TestObject tObj_SuperAdminUsers = new TestObject('Super Admin Users Link')

TestObject tObj_SuperAdminOrganizations = new TestObject('Super Admin Organizations Link')

TestObject tObj_SuperAdminReports = new TestObject('Super Admin Reports Link')

TestObject tObj_SuperAdminJobs = new TestObject('Super Admin Jobs Link')

TestObject tObj_SuperAdminMore = new TestObject('Super Admin More Link')

switch (ScenarioType) {
    case 'Donate_SignIn_AccountManager':
        //CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURL, SignInName, SignInPassword)
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_TotalTransaction = new TestObject('Total Transaction Amount')

        Org_TotalTransaction.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Total Transaction Amount\')]')

        WebUI.verifyElementPresent(Org_TotalTransaction, 2)

        tObj_Analytics.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'analytics-menu\' and (text() = \' Analytics \' or . = \' Analytics \')]')

        WebUI.verifyElementPresent(tObj_Analytics, 2)

        tObj_Account.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'account-menu\' and (text() = \' Account \' or . = \' Account \')]')

        WebUI.verifyElementPresent(tObj_Account, 2)

        tObj_Users.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'users-menu\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementPresent(tObj_Users, 2)

        tObj_Reporting.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'reporting-menu\' and (text() = \' Reporting \' or . = \' Reporting \')]')

        WebUI.verifyElementPresent(tObj_Reporting, 2)

        tObj_Categories.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'categories-menu\' and (text() = \' Categories \' or . = \' Categories \')]')

        WebUI.verifyElementPresent(tObj_Categories, 2)

        tObj_Settings.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'settings-menu\' and (text() = \' Settings \' or . = \' Settings \')]')

        WebUI.verifyElementPresent(tObj_Settings, 2)

        tObj_Notifications.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'nav-tab\' and (text() = \' Notifications \' or . = \' Notifications \')]')

        WebUI.verifyElementPresent(tObj_Notifications, 2)

        PermissionLevel = AccountManager

        break
    case 'Donate_SignIn_Administrator':
        //CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURL, SignInName, SignInPassword)
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_TotalTransaction = new TestObject('Total Transaction Amount')

        Org_TotalTransaction.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Total Transaction Amount\')]')

        WebUI.verifyElementPresent(Org_TotalTransaction, 2)

        //User Menu Check				
        tObj_Analytics.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'analytics-menu\' and (text() = \' Analytics \' or . = \' Analytics \')]')

        WebUI.verifyElementPresent(tObj_Analytics, 2)

        tObj_Account.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'account-menu\' and (text() = \' Account \' or . = \' Account \')]')

        WebUI.verifyElementPresent(tObj_Account, 2)

        tObj_Users.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'users-menu\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementPresent(tObj_Users, 2)

        tObj_Reporting.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'reporting-menu\' and (text() = \' Reporting \' or . = \' Reporting \')]')

        WebUI.verifyElementPresent(tObj_Reporting, 2)

        tObj_Categories.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'categories-menu\' and (text() = \' Categories \' or . = \' Categories \')]')

        WebUI.verifyElementPresent(tObj_Categories, 2)

        tObj_Settings.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'settings-menu\' and (text() = \' Settings \' or . = \' Settings \')]')

        WebUI.verifyElementPresent(tObj_Settings, 2)

        tObj_Notifications.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'nav-tab\' and (text() = \' Notifications \' or . = \' Notifications \')]')

        WebUI.verifyElementPresent(tObj_Notifications, 2)

        PermissionLevel = Administrator

        break
    case 'Donate_SignIn_KioskManager':
        //CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURL, SignInName, SignInPassword)
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_Kiosks = new TestObject('Kiosks')

        Org_Kiosks.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Kiosks\')]')

        WebUI.verifyElementPresent(Org_Kiosks, 2)

        //User Menu Check		
        tObj_Analytics.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'analytics-menu\' and (text() = \' Analytics \' or . = \' Analytics \')]')

        WebUI.verifyElementNotPresent(tObj_Analytics, 2)

        tObj_Account.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'account-menu\' and (text() = \' Account \' or . = \' Account \')]')

        WebUI.verifyElementNotPresent(tObj_Account, 2)

        tObj_Users.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'users-menu\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementNotPresent(tObj_Users, 2)

        tObj_Reporting.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'reporting-menu\' and (text() = \' Reporting \' or . = \' Reporting \')]')

        WebUI.verifyElementNotPresent(tObj_Reporting, 2)

        tObj_Categories.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'categories-menu\' and (text() = \' Categories \' or . = \' Categories \')]')

        WebUI.verifyElementNotPresent(tObj_Categories, 2)

        tObj_Settings.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'settings-menu\' and (text() = \' Settings \' or . = \' Settings \')]')

        WebUI.verifyElementPresent(tObj_Settings, 2)

        tObj_Notifications.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'nav-tab\' and (text() = \' Notifications \' or . = \' Notifications \')]')

        WebUI.verifyElementPresent(tObj_Notifications, 2)

        PermissionLevel = KioskManager

        break
    case 'Donate_SignIn_MemberManager':
        //CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURL, SignInName, SignInPassword)
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_Members = new TestObject('Members')

        Org_Members.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Members\')]')

        WebUI.verifyElementPresent(Org_Members, 2)

        //User Menu Check		
        tObj_Analytics.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'analytics-menu\' and (text() = \' Analytics \' or . = \' Analytics \')]')

        WebUI.verifyElementNotPresent(tObj_Analytics, 2)

        tObj_Account.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'account-menu\' and (text() = \' Account \' or . = \' Account \')]')

        WebUI.verifyElementNotPresent(tObj_Account, 2)

        tObj_Users.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'users-menu\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementPresent(tObj_Users, 2)

        tObj_Reporting.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'reporting-menu\' and (text() = \' Reporting \' or . = \' Reporting \')]')

        WebUI.verifyElementNotPresent(tObj_Reporting, 2)

        tObj_Categories.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'categories-menu\' and (text() = \' Categories \' or . = \' Categories \')]')

        WebUI.verifyElementNotPresent(tObj_Categories, 2)

        tObj_Settings.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'settings-menu\' and (text() = \' Settings \' or . = \' Settings \')]')

        WebUI.verifyElementPresent(tObj_Settings, 2)

        tObj_Notifications.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'nav-tab\' and (text() = \' Notifications \' or . = \' Notifications \')]')

        WebUI.verifyElementPresent(tObj_Notifications, 2)

        PermissionLevel = MemberManager

        break
    case 'Donate_SignIn_ReportsManager':
        //CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURL, SignInName, SignInPassword)
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_TotalTransaction = new TestObject('Total Transaction Amount')

        Org_TotalTransaction.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Total Transaction Amount\')]')

        WebUI.verifyElementPresent(Org_TotalTransaction, 2)

        //User Menu Check		
        tObj_Analytics.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'analytics-menu\' and (text() = \' Analytics \' or . = \' Analytics \')]')

        WebUI.verifyElementPresent(tObj_Analytics, 2)

        tObj_Account.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'account-menu\' and (text() = \' Account \' or . = \' Account \')]')

        WebUI.verifyElementNotPresent(tObj_Account, 2)

        tObj_Users.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'users-menu\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementPresent(tObj_Users, 2)

        tObj_Reporting.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'reporting-menu\' and (text() = \' Reporting \' or . = \' Reporting \')]')

        WebUI.verifyElementPresent(tObj_Reporting, 2)

        tObj_Categories.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'categories-menu\' and (text() = \' Categories \' or . = \' Categories \')]')

        WebUI.verifyElementPresent(tObj_Categories, 2)

        tObj_Settings.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'settings-menu\' and (text() = \' Settings \' or . = \' Settings \')]')

        WebUI.verifyElementPresent(tObj_Settings, 2)

        tObj_Notifications.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'nav-tab\' and (text() = \' Notifications \' or . = \' Notifications \')]')

        WebUI.verifyElementPresent(tObj_Notifications, 2)

        PermissionLevel = ReportsManager

        break
    case 'Donate_SignIn_SettingsManager':
        //CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURL, SignInName, SignInPassword)
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_OrganizationSettings = new TestObject('Organization Settings')

        Org_OrganizationSettings.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Organization Settings\')]')

        WebUI.verifyElementPresent(Org_OrganizationSettings, 2)

        //User Menu Check
        tObj_Analytics.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'analytics-menu\' and (text() = \' Analytics \' or . = \' Analytics \')]')

        WebUI.verifyElementNotPresent(tObj_Analytics, 2)

        tObj_Account.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'account-menu\' and (text() = \' Account \' or . = \' Account \')]')

        WebUI.verifyElementPresent(tObj_Account, 2)

        tObj_Users.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'users-menu\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementNotPresent(tObj_Users, 2)

        tObj_Reporting.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'reporting-menu\' and (text() = \' Reporting \' or . = \' Reporting \')]')

        WebUI.verifyElementNotPresent(tObj_Reporting, 2)

        tObj_Categories.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'categories-menu\' and (text() = \' Categories \' or . = \' Categories \')]')

        WebUI.verifyElementPresent(tObj_Categories, 2)

        tObj_Settings.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'settings-menu\' and (text() = \' Settings \' or . = \' Settings \')]')

        WebUI.verifyElementPresent(tObj_Settings, 2)

        tObj_Notifications.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'nav-tab\' and (text() = \' Notifications \' or . = \' Notifications \')]')

        WebUI.verifyElementPresent(tObj_Notifications, 2)

        PermissionLevel = SettingsManager

        break
    case 'Donate_SignIn_CLAccountManager':
        //CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURL, SignInName, SignInPassword)
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_TotalTransaction = new TestObject('Total Transaction Amount')

        Org_TotalTransaction.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Total Transaction Amount\')]')

        WebUI.verifyElementPresent(Org_TotalTransaction, 2)

        //User Menu Check		
        tObj_Analytics.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'analytics-menu\' and (text() = \' Analytics \' or . = \' Analytics \')]')

        WebUI.verifyElementPresent(tObj_Analytics, 2)

        tObj_Account.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'account-menu\' and (text() = \' Account \' or . = \' Account \')]')

        WebUI.verifyElementPresent(tObj_Account, 2)

        tObj_Users.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'users-menu\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementPresent(tObj_Users, 2)

        tObj_Reporting.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'reporting-menu\' and (text() = \' Reporting \' or . = \' Reporting \')]')

        WebUI.verifyElementPresent(tObj_Reporting, 2)

        tObj_Categories.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'categories-menu\' and (text() = \' Categories \' or . = \' Categories \')]')

        WebUI.verifyElementPresent(tObj_Categories, 2)

        tObj_Settings.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'settings-menu\' and (text() = \' Settings \' or . = \' Settings \')]')

        WebUI.verifyElementPresent(tObj_Settings, 2)

        tObj_Notifications.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'nav-tab\' and (text() = \' Notifications \' or . = \' Notifications \')]')

        WebUI.verifyElementPresent(tObj_Notifications, 2)

        PermissionLevel = CampusLimitedAccountManager

        break
    case 'Donate_SignIn_CLReportsManager':
        //CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURL, SignInName, SignInPassword)
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_TotalTransaction = new TestObject('Total Transaction Amount')

        Org_TotalTransaction.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Total Transaction Amount\')]')

        WebUI.verifyElementPresent(Org_TotalTransaction, 2)

        //User Menu Check		
        tObj_Analytics.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'analytics-menu\' and (text() = \' Analytics \' or . = \' Analytics \')]')

        WebUI.verifyElementPresent(tObj_Analytics, 2)

        tObj_Account.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'account-menu\' and (text() = \' Account \' or . = \' Account \')]')

        WebUI.verifyElementNotPresent(tObj_Account, 2)

        tObj_Users.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'users-menu\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementPresent(tObj_Users, 2)

        tObj_Reporting.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'reporting-menu\' and (text() = \' Reporting \' or . = \' Reporting \')]')

        WebUI.verifyElementPresent(tObj_Reporting, 2)

        tObj_Categories.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'categories-menu\' and (text() = \' Categories \' or . = \' Categories \')]')

        WebUI.verifyElementPresent(tObj_Categories, 2)

        tObj_Settings.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'settings-menu\' and (text() = \' Settings \' or . = \' Settings \')]')

        WebUI.verifyElementPresent(tObj_Settings, 2)

        tObj_Notifications.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'nav-tab\' and (text() = \' Notifications \' or . = \' Notifications \')]')

        WebUI.verifyElementPresent(tObj_Notifications, 2)

        PermissionLevel = CampusLimitedReportsManager

        break
    case 'Donate_SignIn_CLSettingsManager':
        //CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURL, SignInName, SignInPassword)
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_OrganizationSettings = new TestObject('Organization Settings')

        Org_OrganizationSettings.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Organization Settings\')]')

        WebUI.verifyElementPresent(Org_OrganizationSettings, 2)

        //User Menu Check
        tObj_Analytics.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'analytics-menu\' and (text() = \' Analytics \' or . = \' Analytics \')]')

        WebUI.verifyElementNotPresent(tObj_Analytics, 2)

        tObj_Account.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'account-menu\' and (text() = \' Account \' or . = \' Account \')]')

        WebUI.verifyElementPresent(tObj_Account, 2)

        tObj_Users.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'users-menu\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementNotPresent(tObj_Users, 2)

        tObj_Reporting.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'reporting-menu\' and (text() = \' Reporting \' or . = \' Reporting \')]')

        WebUI.verifyElementNotPresent(tObj_Reporting, 2)

        tObj_Categories.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'categories-menu\' and (text() = \' Categories \' or . = \' Categories \')]')

        WebUI.verifyElementPresent(tObj_Categories, 2)

        tObj_Settings.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'settings-menu\' and (text() = \' Settings \' or . = \' Settings \')]')

        WebUI.verifyElementPresent(tObj_Settings, 2)

        tObj_Notifications.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'nav-tab\' and (text() = \' Notifications \' or . = \' Notifications \')]')

        WebUI.verifyElementPresent(tObj_Notifications, 2)

        PermissionLevel = CampusLimitedSettingsManager

        break /*case 'Donate_SignIn_Member':
		//CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURL, SignInName, SignInPassword)
		if (OrganizationCount != "1"){
			WebUI.delay(1)
			TestObject tObj_OrgPhoneNumber = new TestObject()
			
			WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)
			tObj_OrgPhoneNumber.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='$PhoneNumber'])[1]/following::button[1]")
			WebUI.waitForElementPresent(tObj_OrgPhoneNumber, 10)
			WebUI.delay(1)
			CustomKeywords.'webUI.MyOrganizations.clickElement'(tObj_OrgPhoneNumber)
		}
		
		'Select an Option Below'
		TestObject Org_UserLogin = new TestObject('User Login Campus Landing Page')
		Org_UserLogin.addProperty('xpath', ConditionType.EQUALS,"//div[@class = 'clickable' and (text() = 'Select an Option Below' or . = 'Select an Option Below')]")
		WebUI.verifyElementPresent(Org_UserLogin, 2)
		
		//User Menu Check
		tObj_Analytics.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'analytics-menu' and (text() = ' Analytics ' or . = ' Analytics ')]")
		WebUI.verifyElementNotPresent(tObj_Analytics, 2)
		tObj_Account.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'account-menu' and (text() = ' Account ' or . = ' Account ')]")
		WebUI.verifyElementNotPresent(tObj_Account, 2)
		tObj_Users.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'users-menu' and (text() = ' Users ' or . = ' Users ')]")
		WebUI.verifyElementNotPresent(tObj_Users, 2)
		tObj_Reporting.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'reporting-menu' and (text() = ' Reporting ' or . = ' Reporting ')]")
		WebUI.verifyElementNotPresent(tObj_Reporting, 2)
		tObj_Categories.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'categories-menu' and (text() = ' Categories ' or . = ' Categories ')]")
		WebUI.verifyElementNotPresent(tObj_Categories, 2)
		tObj_Settings.addProperty('xpath', ConditionType.EQUALS,"//button[@id = 'settings-menu' and (text() = ' Settings ' or . = ' Settings ')]")
		WebUI.verifyElementNotPresent(tObj_Settings, 2)
		tObj_Notifications.addProperty('xpath', ConditionType.EQUALS,"//button[@class = 'nav-tab' and (text() = ' Notifications ' or . = ' Notifications ')]")
		WebUI.verifyElementNotPresent(tObj_Notifications, 2)
		
		PermissionLevel = CLSettingsManager
			
	break*/
    case 'Donate_SignIn_SuperAdminUser':
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_Organizations = new TestObject('Organizations')

        Org_Organizations.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Organizations\')]')

        WebUI.verifyElementPresent(Org_Organizations, 2)

        tObj_SuperAdminUsers.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'btn btn-md txt-only d-none d-md-inline ng-star-inserted\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementPresent(tObj_SuperAdminUsers, 2)

        tObj_SuperAdminOrganizations.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'btn btn-md txt-only d-none d-md-inline ng-star-inserted\' and (text() = \' Organizations \' or . = \' Organizations \')]')

        WebUI.verifyElementPresent(tObj_SuperAdminOrganizations, 2)

        tObj_SuperAdminReports.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'dropdownBasic1\' and (text() = \'Reports\' or . = \'Reports\')]')

        WebUI.verifyElementPresent(tObj_SuperAdminReports, 2)

        tObj_SuperAdminJobs.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'dropdownBasic3\' and (text() = \'Jobs\' or . = \'Jobs\')]')

        WebUI.verifyElementPresent(tObj_SuperAdminJobs, 2)

        tObj_SuperAdminMore.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'dropdownBasic3\' and (text() = \'More\' or . = \'More\')]')

        WebUI.verifyElementPresent(tObj_SuperAdminMore, 2)

        PermissionLevel = SuperAdminUser

        break
    case 'Donate_SignIn_SuperAdminManager':
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_Organizations = new TestObject('Organizations')

        Org_Organizations.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Organizations\')]')

        WebUI.verifyElementPresent(Org_Organizations, 2)

        tObj_SuperAdminUsers.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'btn btn-md txt-only d-none d-md-inline ng-star-inserted\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementPresent(tObj_SuperAdminUsers, 2)

        tObj_SuperAdminOrganizations.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'btn btn-md txt-only d-none d-md-inline ng-star-inserted\' and (text() = \' Organizations \' or . = \' Organizations \')]')

        WebUI.verifyElementPresent(tObj_SuperAdminOrganizations, 2)

        tObj_SuperAdminReports.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'dropdownBasic1\' and (text() = \'Reports\' or . = \'Reports\')]')

        WebUI.verifyElementPresent(tObj_SuperAdminReports, 2)

        tObj_SuperAdminJobs.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'dropdownBasic3\' and (text() = \'Jobs\' or . = \'Jobs\')]')

        WebUI.verifyElementPresent(tObj_SuperAdminJobs, 2)

        tObj_SuperAdminMore.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'dropdownBasic3\' and (text() = \'More\' or . = \'More\')]')

        WebUI.verifyElementPresent(tObj_SuperAdminMore, 2)

        PermissionLevel = SuperAdminManager

        break
    case 'Donate_SignIn_SuperAdminAdministrator':
        WebUI.delay(1)

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        TestObject Org_Organizations = new TestObject('Organizations')

        Org_Organizations.addProperty('xpath', ConditionType.CONTAINS, '//*[contains(text(),\'Organizations\')]')

        WebUI.verifyElementPresent(Org_Organizations, 2)

        tObj_SuperAdminUsers.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'btn btn-md txt-only d-none d-md-inline ng-star-inserted\' and (text() = \' Users \' or . = \' Users \')]')

        WebUI.verifyElementPresent(tObj_SuperAdminUsers, 2)

        tObj_SuperAdminOrganizations.addProperty('xpath', ConditionType.EQUALS, '//button[@class = \'btn btn-md txt-only d-none d-md-inline ng-star-inserted\' and (text() = \' Organizations \' or . = \' Organizations \')]')

        WebUI.verifyElementPresent(tObj_SuperAdminOrganizations, 2)

        tObj_SuperAdminReports.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'dropdownBasic1\' and (text() = \'Reports\' or . = \'Reports\')]')

        WebUI.verifyElementPresent(tObj_SuperAdminReports, 2)

        tObj_SuperAdminJobs.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'dropdownBasic3\' and (text() = \'Jobs\' or . = \'Jobs\')]')

        WebUI.verifyElementPresent(tObj_SuperAdminJobs, 2)

        tObj_SuperAdminMore.addProperty('xpath', ConditionType.EQUALS, '//button[@id = \'dropdownBasic3\' and (text() = \'More\' or . = \'More\')]')

        WebUI.verifyElementPresent(tObj_SuperAdminMore, 2)

        PermissionLevel = SuperAdminAdministrator

        break
    default:
        WebUI.comment('****Signin User case statement switch not present***')}

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

//Make this a separate function in Keywords
List PermissionLevelList = PermissionLevel.split('\\|')

System.out.println('Permission List Members = ' + PermissionLevelList.size())

List PermissionLevelArray = PermissionLevel.split('\\|')

System.out.println(PermissionLevelArray.size())

if (PermissionLevelArray.size() < 2) {
    System.out.println('Only 1 access level to test')
} else {
    System.out.println('More than 1 access level to test')
}

System.out.println((((((('Passed variables are: ' + Feature) + ', ') + ScenarioType) + ', ') + PermissionLevel) + ', ') + 
    OrganizationName)

/*System.out.println("ScenarioType is: " +ScenarioType)
System.out.println("PermissionLevel is: " +PermissionLevel)
System.out.println("OrganizationName is: " +OrganizationName)*/
switch (Feature) {
    //Profile Title
    case 'PROFILE':
        WebUI.comment('starting PROFILE labeled features')

        break //Help Center Link
    case 'Help Center Link':
        System.out.println(('>>>Starting - \'' + Feature) + '\' feature')

        features.HelpCenterLink.HelpCenterLinkAccess(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Dashboard
    case 'Dashboard':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        features.Dashboards.Dashboard(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Organization
    case 'Organization':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Organization Profile
    case 'Organization Profile':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        features.Organizations.OrganizationProfile(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Organization Notes (on Profile)
    case 'Organization Notes on Profile':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        features.Organizations.OrganizationNotesOnProfile(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Organization Status (on profile)
    case 'Organization Status on Profile':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        features.Organizations.OrganizationStatusOnProfile(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Campuses
    case 'Campuses':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        features.Campus.Campuses(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Add campus
    case 'Add Campus':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        features.Campus.AddCampus(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Set Campus limit
    case 'Set Campus Limit':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        //PermissionLevel = PermissionLevelArray[index]	
        features.Campus.SetCampusLimit(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Custom Messaging
    case 'Custom Messaging':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        features.Customization.CustomMessaging(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Customize Theme
    case 'Customize Theme':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        features.Customization.CustomizeTheme(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Campus Theme
    case 'Campus Theme':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        features.Customization.CampusTheme(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //USERS
    case 'USERS':
        WebUI.comment('starting USERS labeled features')

        break //Administrators list
    case 'Administrators List':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        features.Administrator.AdministratorList(Feature, ScenarioType, PermissionLevel, OrganizationName)

        break //Add administrator
    case 'Add Administrator':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //View / Edit administrator
    case 'View_Edit Administrator':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Members list
    case 'Members List':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Member profile (enrolled)
    case 'Member Profile Enrolled':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Member profile (unenrolled)
    case 'Member Profile Unenrolled':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Member giving statements 
    case 'Member Giving Statements':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Member Text Giving Numbers
    case 'Member Text Giving Numbers':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Add unenrolled member 
    case 'Add Unenrolled Member':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //REPORTING
    case 'REPORTING':
        WebUI.comment('starting REPORTING labeled features')

        break //All transactions list	
    case 'All Transactions List':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Full Report
    case 'Full Report':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Scan Checks
    case 'Scan Checks':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Transaction details
    case 'Transaction Details':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Add offline transaction
    case 'Add Offline Transaction':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Recurring transactions list
    case 'Recurring Transactions List':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Recurring transaction details
    case 'Recurring Transaction Details':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Batches list
    case 'Batches List':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Check Scanning
    case 'Check Scanning':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Pledges list
    case 'Pledges List':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Pledge details
    case 'Pledge Details':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Add pledge on behalf of member
    case 'Add Pledge On Behalf Of Member':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //SETTINGS
    case 'SETTINGS':
        WebUI.comment('starting SETTINGS labeled features')

        break //Module management
    case 'Module Management':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Organization settings
    case 'Organization Settings':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //ACH settings
    case 'ACH Settings':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Monetra Settings 
    case 'Monetra Settings':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Donation categories
    case 'Donation Categories':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Add donation category
    case 'Add Donation Category':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Purchase categories
    case 'Purchase Categories':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Add purchase category
    case 'Add Purchase Category':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Check scanning Settings
    case 'Check Scanning Settings':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Check scanning Location IDs
    case 'Check Scanning Location IDs':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Direct Category Link
    case 'Direct Category Link':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Embeddable Widgets			  
    case 'Embeddable Widgets':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Export Format
    case 'Export Format':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Export Format API Settings
    case 'Export Format API Settings':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Giving statement templates
    case 'Giving Statement Templates':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Goals / Pledge Drives list
    case 'Goals_Pledge Drives List':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Add Goal / Pledge Drive
    case 'Add Goal_Pledge Drive':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Goal / Pledge Drive details
    case 'Goal_Pledge Drive Details':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //View list of Kiosks (web)
    case 'View List Of Kiosks Web':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Kiosk details (web)
    case 'Kiosk Details Web':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Register/re-register kiosk (on kiosk)
    case 'Register_Re_Register Kiosk On Kiosk':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Manage kiosk settings / update kiosk software (on kiosk)
    case 'Manage Kiosk Settings_Update Kiosk Software_On Kiosk':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Licenses List
    case 'Licenses List':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Add Licenses
    case 'Add Licenses':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //License Details
    case 'License Details':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //TTG Settings:  Phone number & keyword limit
    case 'TTG Settings_Phone Number And Keyword Limit':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //TTG Settings: Keywords & default keyword 
    case 'TTG Settings_Keywords And Default Keyword':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break
        
        //Notifications
        //case 'Nothing':
        //System.out.println(">>>Starting - " + Feature + " feature")
        break //Notifications badge
    case 'Notifications Badge':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break //Notifications list
    case 'Notifications List':
        break //Email opt in / out for their account
    case 'Email Opt In_Out For Their Account':
        System.out.println(('>>>Starting - ' + Feature) + ' feature')

        break
    default:
        WebUI.comment('****Permissions case statement switch not present***')

        KeywordUtil.markFailedAndStop('Feature not found ' + Feature)}

WebUI.comment('end')

/*/***********************************************
Give To_Page /category
choose gift type
************************************************/
WebUI.closeBrowser()

