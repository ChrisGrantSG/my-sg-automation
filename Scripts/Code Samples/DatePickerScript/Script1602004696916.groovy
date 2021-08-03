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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://sg-dev-web-ng.securegive.com/sp')

WebUI.click(findTestObject('Object Repository/DatePicker/Page_Select an Option  Starr Pass Church-Au_4a073f/span_Main Campus'))

WebUI.click(findTestObject('Object Repository/DatePicker/Page_How To Give  Starr Pass Church-Automat_d8f560/div_Donation'))

WebUI.setText(findTestObject('Object Repository/DatePicker/Page_Donate  Starr Pass Church-Automation-P_f9dc6a/input_General Giving_fund0.amount'), 
    '$10.00')

WebUI.click(findTestObject('Object Repository/DatePicker/Page_Donate  Starr Pass Church-Automation-P_f9dc6a/label_Recurring'))

WebUI.setText(findTestObject('Object Repository/DatePicker/Page_Sign In  Starr Pass Church-Automation-_5fd39e/input_Phone Number or Email_emailOrPhone'), 
    'frank.page+kelly@securegive.com')

WebUI.sendKeys(findTestObject('Object Repository/DatePicker/Page_Sign In  Starr Pass Church-Automation-_5fd39e/input_Phone Number or Email_emailOrPhone'), 
    Keys.chord(Keys.ENTER))

WebUI.setEncryptedText(findTestObject('Object Repository/DatePicker/Page_Sign In  Starr Pass Church-Automation-_5fd39e/input_Password_password'), 
    'xawWuIhk6eupZWVUEYnrRA==')

WebUI.sendKeys(findTestObject('Object Repository/DatePicker/Page_Sign In  Starr Pass Church-Automation-_5fd39e/input_Password_password'), 
    Keys.chord(Keys.ENTER))

WebUI.setEncryptedText(findTestObject('Object Repository/DatePicker/Page_Sign In  Starr Pass Church-Automation-_5fd39e/input_Password_password'), 
    'xawWuIhk6eupZWVUEYnrRA==')

WebUI.sendKeys(findTestObject('Object Repository/DatePicker/Page_Sign In  Starr Pass Church-Automation-_5fd39e/input_Password_password'), 
    Keys.chord(Keys.ENTER))

WebUI.setEncryptedText(findTestObject('Object Repository/DatePicker/Page_Sign In  Starr Pass Church-Automation-_5fd39e/input_Password_password'), 
    'xawWuIhk6euXUAw9wmjbrg==')

WebUI.sendKeys(findTestObject('Object Repository/DatePicker/Page_Sign In  Starr Pass Church-Automation-_5fd39e/input_Password_password'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/DatePicker/Page_Donate  Starr Pass Church-Automation-P_f9dc6a/label_Recurring'))

WebUI.click(findTestObject('Object Repository/DatePicker/Page_Donate  Starr Pass Church-Automation-P_f9dc6a/svg'))

WebUI.click(findTestObject('Page_Give to/app-date-picker_EndDate'))

WebUI.click(findTestObject('Page_Give to/app-date-picker_EndDate'))

WebUI.setText(findTestObject('Page_Give to/input_End Date'), 
    '12/12/2020')

WebUI.sendKeys(findTestObject('Page_Give to/input_End Date'), 
    Keys.chord(Keys.ENTER))

WebUI.closeBrowser()

