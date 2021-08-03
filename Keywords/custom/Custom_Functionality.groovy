package custom

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.*

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Custom_Functionality {

	static void SignInAsMember(SignInName,SignInPassword){
		WebUI.delay(2)
		//def username,def password){
		//Choose Signin from Donate/Signin page
		TestObject tObj_SignInMembers = new TestObject('Sign In Members')
		tObj_SignInMembers.addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'ngb-nav-0' and (text() = 'Sign In' or . = 'Sign In')]")
		WebUI.click(tObj_SignInMembers)
		WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

		//enter email or phone
		WebUI.setText(findTestObject('Object Repository/Page_Continue As Member New Guest/MemberSignIn/input_EmailorPhone'), SignInName)

		//click continue
		//WebUI.click(findTestObject('Object Repository/Page_Continue As Member New Guest/MemberSignIn/button_Continue'))

		//enter password
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_Password'), SignInPassword)

		//click Sign In
		WebUI.click(findTestObject('Object Repository/Page_Continue As Member New Guest/MemberSignIn/button_Sign In'))


	}

	static void SignInAsGuest(MemberFirstName,MemberLastName,SignInName){

		//Choose Guest from Donate/Signin page
		WebUI.delay(2)
		TestObject tObj_ContinueAs = new TestObject('Continue As')
		tObj_ContinueAs.addProperty('xpath', ConditionType.EQUALS, '//*[@id = \'ngb-nav-2\' and (text() = \'Guest\' or . = \'Guest\')]')

		WebUI.click(tObj_ContinueAs)

		WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

		//enter First Name
		WebUI.setText(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_First Name'),MemberFirstName)

		//enter Last Name
		WebUI.setText(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_Last Name'),MemberLastName)

		//enter Email
		WebUI.setText(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_Email'),SignInName)

		//click Continue
		WebUI.click(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/button_Sign Up'))

	}

	static void SignUpAsNewMember(MemberFirstName,MemberLastName,UTCTime,MemberMobileNumber,MemberStreetAddress1,MemberCity,MemberStateProvince,MemberZip,MemberCountry,NewMemberPassword){
		WebUI.delay(2)
		TestObject tObj_SignUpNewMember = new TestObject('Sign Up New Member')
		tObj_SignUpNewMember.addProperty('xpath', ConditionType.EQUALS, '//*[@id = \'ngb-nav-1\' and (text() = \'Sign Up\' or . = \'Sign Up\')]')
		WebUI.click(tObj_SignUpNewMember)

		WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

		WebUI.delay(1)

		WebUI.sendKeys(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_First Name'),MemberFirstName)

		WebUI.sendKeys(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_Last Name'),MemberLastName)

		WebUI.setText(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_Email'),('testing+' + UTCTime) + '+load@securegive.com')

		WebUI.setText(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_Mobile Number'),MemberMobileNumber)

		WebUI.setText(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_Street Address 1'),MemberStreetAddress1)

		WebUI.setText(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_City'),MemberCity)

		WebUI.selectOptionByValue(findTestObject('Page_Continue As Member New Guest/GuestSignUp/select_Country'), MemberCountry,true)

		WebUI.selectOptionByValue(findTestObject('Page_Continue As Member New Guest/GuestSignUp/select_StateProvince'),MemberStateProvince, true)

		WebUI.setText(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_Zip'), MemberZip)

		WebUI.setText(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/input_Password'),NewMemberPassword)

		WebUI.click(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/button_Sign Up'))

		if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Continue As Member New Guest/GuestSignUp/div_Success_Your account has been created'),5)) {
			KeywordUtil.markPassed('Success: Your account has been created! Message Found')
		} else {
			KeywordUtil.markFailed('Message: Your account has been created was not found')
		}
	}

	static void VerifyThanksMessage(){
		TestObject tObj_ThanksMessage = new TestObject('Thanks Message')
		tObj_ThanksMessage.addProperty('xpath', ConditionType.EQUALS, '//h5[(text() = \'Thanks!\' or . = \'Thanks!\')]')

		if (WebUI.verifyElementPresent(tObj_ThanksMessage, 3)) {
			WebUI.verifyElementPresent(tObj_ThanksMessage, 5, FailureHandling.OPTIONAL)

			KeywordUtil.markPassed('***Found Thank You message***')

			WebUI.comment('***Found Thank You message***')
		} else {
			KeywordUtil.markFailed('Thank You Message not found')
		}
	}

	static void PrintDate(){

		Date mydate = new Date()

		println(mydate)
	}


	public static GetGMTDate(){
		Date date = new Date();
		TimeZone.setDefault(TimeZone.getTimeZone('GMT'))
		Calendar cal = Calendar.getInstance(TimeZone.getDefault())
		date = cal.getTime();

		return date
	}

	//Keyword to get the date takes the numeric parameter which is the number of days to be added to the current date(UTC)@Keyword
	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
	}

	//Function that adds mentioned minutes to given Date
	public static Date addMinutes(Date date, int minutes) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

	public static GetLastFileEntry(FilePath){

		File file = new File(FilePath)//('Data Files//Organizations.txt')

		println(file.getText())

		def FileContents = file.getText()

		//turn text file into List
		List Lines = FileContents.split('\n')

		int LineCount = Lines.size()

		System.out.println(Lines.size())

		for (int index = 0; index < Lines.size(); index++) {
			System.out.println(Lines[index])
		}

		String LastLineInList = Lines[(LineCount - 1)]

		System.out.println('The last org in list is ' + LastLineInList)

		return LastLineInList;
	}



}



