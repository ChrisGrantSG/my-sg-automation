import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.applitools.eyes.selenium.Eyes
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//-----------------------------------------check eyesOpen/checkWindow/checkRegion/eyesClose ------------------------------------------------------------
//use 'https://applitools.com/helloworld2?diff1' to make changes to page
WebUI.openBrowser('https://applitools.com/helloworld2?diff2')

WebUI.setViewPortSize(800, 600)

//initialize eyes
Eyes eyes = CustomKeywords.'com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen'('uniqueString0', null)

WebDriver driver = DriverFactory.getWebDriver()

driver.findElement(By.id('name')).sendKeys('My Name')

By locatorBy = By.id('name')

eyes.checkRegion(locatorBy, 'check checkRegion by selector keyword')

driver.findElement(By.tagName('button')).click()

WebElement element = driver.findElement(By.xpath('//img[contains(@class,\'diff2\')]'))

//check region by web element
CustomKeywords.'com.kms.katalon.keyword.applitools.BasicKeywords.checkElement'(eyes, element)

//check window not including eyes set up
eyes.checkWindow('check checkWindow')

CustomKeywords.'com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose'(eyes)

WebUI.closeBrowser()







//TEST SCENARIO-1
//1. log into dev as user capture window and make sure Go to Organization is present
//2. log into dev as admin capture window and make sure Go to Organizational Dashboard is present, all other items are the same

//TEST SCENARIO-2
//1. log into dev as user then go to Test Org-Automation... capture window
//2. log into dev as admin then go to Test Org-Automation... make sure all items are the same as admin

//TEST SCENARIO-3
//1. log into dev as user then go to Starr Pass Church-... click Transaction on left column, capure window without table 
//2. Run test to input transaction into user account (automation scenario 1)
//2. log into dev as user then go to Starr Pass Church-... click Transaction on left column, compare window except for table




//webpage url for dev environment
WebUI.navigateToUrl('https://sg-dev-web.securegive.com/login')

//login keyword for dev environment
CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURLDEV, SignInNameUserDEV, SignInPassword)

//login keyword for dev environment
CustomKeywords.'webUI.Login.loginIntoApplication'(SecureGiveURLDEV, SignInNameAdminDEV, SignInPassword)


