package webUI

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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Methods {


	def VerifyThanksMessage(){
		tObj_ThanksMessage = new TestObject('Thanks Message')
		tObj_ThanksMessage.addProperty('xpath', ConditionType.EQUALS, '//h5[(text() = \'Thanks!\' or . = \'Thanks!\')]')

		if (CustomKeywords.'webUI.WebUICustomKeywords.isElementPresent'(tObj_ThanksMessage, 3)) {
			WebUI.verifyElementPresent(tObj_ThanksMessage, 5, FailureHandling.OPTIONAL)

			KeywordUtil.markPassed('***Found Thank You message***')

			WebUI.comment('***Found Thank You message***')
		} else {
			KeywordUtil.markFailed('Thank You Message not found')
		}
	}

	def VerifyMethodWorks(){
		WebUI.comment("********************method worked************************")
	}
}
