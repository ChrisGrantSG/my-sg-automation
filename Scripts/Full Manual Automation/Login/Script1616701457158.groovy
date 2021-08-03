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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://sg-pre-web.securegive.com/login')

WebUI.setText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Sign In  SecureGive/input_Forgot Password_emailOrPhone'), 
    'frank.page+kelly@securegive.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Sign In  SecureGive/input_Forgot Password_password'), 
    'p4nzqf2WPVEdgGhZ2tawDQ==')

WebUI.sendKeys(findTestObject('Object Repository/Full Manual Automation Objects/Page_Sign In  SecureGive/input_Forgot Password_password'), 
    Keys.chord(Keys.ENTER))

WebUI.verifyElementText(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Ashleys Test Church/h4_Ashleys Test Church'), 
    'Ashley\'s Test Church')

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Ashleys Test Church/p_0.00'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Ashleys Test Church/p_25,529.94'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Ashleys Test Church/p_181.53'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Ashleys Test Church/p_0.00'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Ashleys Test Church/p_0.00'), 
    0)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Ashleys Test Church/svg'))

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_Dashboard  Ashleys Test Church/a_All Transactions'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_All Transactions/div_Date  TimeMember IDFirst NameLast NameT_2f1e7c'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_All Transactions/button_Filters_btn-show-filter-desktop'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_All Transactions/button_Filters_btn-column-dropdown'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_All Transactions/button_Export Status_btn-export'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_All Transactions/button_Export Status_btn-download'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_All Transactions/button_Export Status_btn-print'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_All Transactions/button_Export Status_btn-more-dropdown'), 
    0)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_All Transactions/svg'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Full Manual Automation Objects/Page_All Transactions/button_Sign Out'), 
    0)

WebUI.click(findTestObject('Object Repository/Full Manual Automation Objects/Page_All Transactions/button_Sign Out'))

WebUI.closeBrowser()

