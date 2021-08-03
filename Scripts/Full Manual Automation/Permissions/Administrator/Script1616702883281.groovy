import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl('https://sg-pre-web.securegive.com/login', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Sign In  SecureGive/input_Forgot Password_emailOrPhone'), 
    'testing+auto2020_1_admin@securegive.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setEncryptedText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Sign In  SecureGive/input_Forgot Password_password'), 
    'p4nzqf2WPVEdgGhZ2tawDQ==', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Full Manual Automation Objects/Page_Sign In  SecureGive/input_Forgot Password_password'), 
    Keys.chord(Keys.ENTER), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/a_Help Center'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.switchToWindowTitle('SecureGive Help Center', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_SecureGive Help Center/div_How can we help'), 
    'How can we help?', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.switchToWindowTitle('Dashboard | Automation2020_1', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/h4_Total Transaction Amount'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/h4_Total Transaction Amount'), 
    'Total Transaction Amount', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/h5_Daily Transaction Totals'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/h5_Daily Transaction Totals'), 
    'Daily Transaction Totals', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/h5_Cumulative Transaction Totals'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/h5_Cumulative Transaction Totals'), 
    'Cumulative Transaction Totals', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/h5_One-Time vs. Recurring Transactions'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/h5_One-Time vs. Recurring Transactions'), 
    'One-Time vs. Recurring Transactions', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/h5_Giving Sources'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/h5_Giving Sources'), 
    'Giving Sources', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/svg'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/svg'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/svg'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/svg'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/svg'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/svg'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Automation2020_1/svg_1'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Organization Profile  Automation2020_1/svg'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Full Manual Automation Objects/Page_Dashboard  Automation2020_1/button_Account'))

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Organization Profile  Automation2020_1/a_Profile'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Organization Profile  Automation2020_1/h4_Organization Profile'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Organization Profile  Automation2020_1/h4_Organization Profile'), 
    'Organization Profile', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Organization Profile  Automation2020_1/h6_Basic Information'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Organization Profile  Automation2020_1/h6_Basic Information'), 
    'Basic Information', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Organization Profile  Automation2020_1/svg_1'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Organization Profile  Automation2020_1/a_Locations'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Organization Profile  Automation2020_1/a_Locations'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Locations  Automation2020_1/h4_Locations'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Locations  Automation2020_1/h4_Locations'), 
    'Locations', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Locations  Automation2020_1/td_Main Campus'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Locations  Automation2020_1/td_South Campus'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Locations  Automation2020_1/button_Location_btn-add'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Locations  Automation2020_1/span_Location Limit 5'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Locations  Automation2020_1/svg'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Locations  Automation2020_1/a_Administrators'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrators  Automation2020_1/h4_Administrators'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrators  Automation2020_1/h4_Administrators'), 
    'Administrators', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrators  Automation2020_1/button_Administrators_btn-download'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrators  Automation2020_1/button_Administrators_btn-download'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrator  Automation2020_1/h4_Add Administrator'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrator  Automation2020_1/h4_Add Administrator'), 
    'Add Administrator', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrator  Automation2020_1/button_Cancel'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrators  Automation2020_1/td_AutomationAcctManager'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrator  Automation2020_1/button_Save'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrator  Automation2020_1/button_Save'), 
    'Save', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrator  Automation2020_1/svg'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrator  Automation2020_1/button_Cancel'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrators  Automation2020_1/svg'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Administrators  Automation2020_1/a_Members'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Members  Automation2020_1/h4_Members'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Members  Automation2020_1/h4_Members'), 
    'Members', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Members  Automation2020_1/button_Members_btn-add'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Members  Automation2020_1/button_Members_btn-add'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Members  Automation2020_1/svg'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Members  Automation2020_1/a_Messaging'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/h4_Messaging'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/h4_Messaging'), 
    'Messaging', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/label_Disabled'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/label_Enabled'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/label_Disabled'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/textarea_Enabled_input-control ng-untouched_1ba6d0'), 
    'Test Message', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/button_Save'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/label_Enabled'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/button_Save'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/textarea_Enabled_input-control ng-untouched_1ba6d0'), 
    '', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/button_Save'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/svg'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Messaging  Automation2020_1/a_Theme'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/h4_Customize Theme'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/h4_Customize Theme'), 
    'Customize Theme', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/select_All Locations DefaultMain CampusSout_27ec35'), 
    'All Locations [Default]Main CampusSouth Campus', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/label_Light'), 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/label_Dark'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/label_Light'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/label_White'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/button_Save'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/label_Light'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/button_Save'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Object Repository/Full Manual Automation Objects/Page_Theme  Automation2020_1/label_Light'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)

