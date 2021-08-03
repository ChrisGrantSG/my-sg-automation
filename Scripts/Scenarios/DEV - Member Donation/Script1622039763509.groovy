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
import custom.Custom_Functionality.*
import custom.WebPages.*
import webUI.MyOrganizations.*
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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import groovy.time.TimeCategory as TimeCategory

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
if ((ScenarioType == 'Donate_SignIn_Member') || (ScenarioType == 'Donate_SignIn_OrgAdmin')) {
    //Object Validation - Sign In
    //Test Actions - Sign In 		
    CustomKeywords.'webUI.Login.loginIntoApplication'(GlobalVariable.SecureGiveURL, SignInName, SignInPassword)

    /*/***********************************************
	My Organizations_Page
	as member or organization admin
	************************************************/
    //Object Validation - My Organizations
    //Test Actions - My Organizations
    WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

    if (OrganizationCount != '1') {
        WebUI.delay(1)

        TestObject tObj_OrgPhoneNumber = new TestObject('Organization Phone Number')

        WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

        tObj_OrgPhoneNumber.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='$PhoneNumber'])[1]/following::button[1]")

        WebUI.waitForElementPresent(tObj_OrgPhoneNumber, 10)

        WebUI.delay(1)

        CustomKeywords.'webUI.MyOrganizations.clickElement'(tObj_OrgPhoneNumber) /*/***********************************************
	Choose Campus_Page "slug"
	as member or guest
	************************************************/
    }
} else if (((ScenarioType == 'Donate_Slug_SignIn_Member') || (ScenarioType == 'Donate_Slug_Guest')) || (ScenarioType == 
'Donate_Slug_SignUp_NewMember')) {
	
	System.out.println(GlobalVariable.SecureGiveURL + Slug)
	
    CustomKeywords.'webUI.Login.loginIntoApplicationSlug'(GlobalVariable.SecureGiveURL + Slug)
}

WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

/*/***********************************************
Choose_Campus_Page .securegive.com/<slug>
Title: Select an Option Below
chosen based on campus name
************************************************/
custom.WebPages.Choose_Campus_Page(CampusName, CampusCount)

/*/***********************************************
Campus_Giving_Type_Page .securegive.com/<campus name>
Title: <Campus Name>
selected based on donation/campaign name
************************************************/
custom.WebPages.Campus_GivingType_Page(GiftType, GiftTypeCount)

//Donation, Purchase or Campaign
/*/***********************************************
Donation, Purchase or Campaign 
Giving_Page .securegive.com/<campus name>/donate/category
Giving_Page .securegive.com/<campus name>/purchase/category
Giving_Page .securegive.com/<campus name>/goals/<name>
Titles: Give to <Campus Name> or <Goal Name>
input give to information and click Next: Payment Details button
************************************************/
TestObject tObj_PledgeAction = new TestObject()

tObj_PledgeAction.addProperty('xpath', ConditionType.EQUALS, "//*[normalize-space(text()) and normalize-space(.)='$PledgeAction']")

switch (DonatePurchaseGoal) {
    case 'Donate':
        //giving flow
        WebUI.comment('*Donate or Purchase*')

        //general giving
        custom.WebPages.General_Giving(FundName, GiftInputType, GiftAmount, FundNameCount)

        //frequency
        custom.WebPages.GivingFrequency(HowOften, Frequency, ChargeOn, DelayDayOffset, EndDayOffset)

        //add message
        custom.WebPages.AddGivingMessage(AddMessage, UTCTime)

        //give ananymously
        custom.WebPages.GiveAnanymously(GiveAnonymously)

        //Click Next
        custom.WebPages.GiveToNext()

        if (ContinueAs != 'N/A') {
            switch (ContinueAs) {
                case 'Member':
                    custom.Custom_Functionality.SignInAsMember(SignInName, SignInPassword)

                    break
                case 'NewMember':
                    custom.Custom_Functionality.SignUpAsNewMember(MemberFirstName, MemberLastName, UTCTime, MemberMobileNumber, 
                        MemberStreetAddress1, MemberCity, MemberStateProvince, MemberZip, MemberCountry, NewMemberPassword)

                    break
                case 'Guest':
                    custom.Custom_Functionality.SignInAsGuest(MemberFirstName, MemberLastName, SignInName)
                default:
                    WebUI.comment('****Case ContinueAs statement switch not present***')}
        }
        
        //existing payment plan
        if (PaymentMethod == 'Existing Payment Method') {
            custom.WebPages.ExistingPaymentMethod(PaymentMethod, ChoosePaymentMethod, PaymentType //new credit card
                ) //new bank account
            //no payment method
        } else if (PaymentMethod == 'New Credit Card') {
            custom.WebPages.NewCreditCard(AccountNumber, ExpirationMonthYear, CVC3, CVC4, NameOnCard, ZipPostalCode, SavePaymentMethod, 
                ContinueAs)
        } else if (PaymentMethod == 'New Bank Account') {
            custom.WebPages.NewBankAccount(BankAccountHolderName, RoutingNumber, AccountNumber, CheckingOrSavings, SavePaymentMethod, 
                ContinueAs,UTCTime)
        } else {
            WebUI.comment('***No Payment Method***')
        }
        
        //confirmation page
        custom.WebPages.ConfirmPage(SubmitGive, FeeOffset, GiveAnonymously, DonatePurchaseGoal, HowOften)

        break
    case 'Purchase':
        //giving flow
        WebUI.comment('*Donate or Purchase*')

        //general giving
        custom.WebPages.General_Giving(FundName, GiftInputType, GiftAmount, FundNameCount)

        //frequency
        custom.WebPages.GivingFrequency(HowOften, Frequency, ChargeOn, DelayDayOffset, EndDayOffset)

        //add message
        custom.WebPages.AddGivingMessage(AddMessage, UTCTime)

        //give ananymously
        custom.WebPages.GiveAnanymously(GiveAnonymously)

        //Click Next
        custom.WebPages.GiveToNext()

        if (ContinueAs != 'N/A') {
            switch (ContinueAs) {
                case 'Member':
                    custom.Custom_Functionality.SignInAsMember(SignInName, SignInPassword)

                    break
                case 'NewMember':
                    custom.Custom_Functionality.SignUpAsNewMember(MemberFirstName, MemberLastName, UTCTime, MemberMobileNumber, 
                        MemberStreetAddress1, MemberCity, MemberStateProvince, MemberZip, MemberCountry, NewMemberPassword)

                    break
                case 'Guest':
                    custom.Custom_Functionality.SignInAsGuest(MemberFirstName, MemberLastName, SignInName)
                default:
                    WebUI.comment('****Case ContinueAs statement switch not present***')}
        }
        
        //existing payment plan
        if (PaymentMethod == 'Existing Payment Method') {
            custom.WebPages.ExistingPaymentMethod(PaymentMethod, ChoosePaymentMethod, PaymentType //new credit card
                ) //new bank account
            //no payment method
        } else if (PaymentMethod == 'New Credit Card') {
            custom.WebPages.NewCreditCard(AccountNumber, ExpirationMonthYear, CVC3, CVC4, NameOnCard, ZipPostalCode, SavePaymentMethod, 
                ContinueAs)
        } else if (PaymentMethod == 'New Bank Account') {
            custom.WebPages.NewBankAccount(BankAccountHolderName, RoutingNumber, AccountNumber, CheckingOrSavings, SavePaymentMethod, 
                ContinueAs,UTCTime)
        } else {
            WebUI.comment('***No Payment Method***')
        }
        
        //confirmation page
        custom.WebPages.ConfirmPage(SubmitGive, FeeOffset, GiveAnonymously, DonatePurchaseGoal, HowOften)

        break
    case 'Goal_Pledge':
        //goal pledge flow
        WebUI.comment('*Goal_Pledge*')

        WebUI.delay(1)

        //PledgeAction		
        WebUI.waitForElementPresent(tObj_PledgeAction, 3)

        WebUI.click(tObj_PledgeAction)

        WebUI.delay(1)

        //if pledge and slug login, sign up/sign in
        if (ContinueAs == 'Member') {
            custom.Custom_Functionality.SignInAsMember(SignInName, SignInPassword)
        } else if ((ContinueAs == 'NewMember') || (ContinueAs == 'Guest')) {
            custom.Custom_Functionality.SignUpAsNewMember(MemberFirstName, MemberLastName, UTCTime, MemberMobileNumber, 
                MemberStreetAddress1, MemberCity, MemberStateProvince, MemberZip, MemberCountry, NewMemberPassword)
        }
        
        //WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/ChargeON'), ChargeOn, false)
        //add giving end date
        WebUI.delay(1)

        WebUI.click(findTestObject('Page_Give to/startDate_app-date-picker'))

        WebUI.delay(1)

        //passed in variables from data sheet
        System.out.println('Pledge Start Day Offset = ' + PledgeStartDayOffset)

        System.out.println('Pledge End Day Offset = ' + PledgeEndDayOffset)

        //get todays date as define formats
        def dateFormat = 'dMMMyyyy'

        def dayFormat = 'd'

        def monthFormat = 'MMM'

        def yearFormat = 'yyyy'

        def Today = new Date()

        def PledgeStartYear

        def PledgeStartMonth

        def PledgeStartDay

        def PledgeEndYear

        def PledgeEndMonth

        def PledgeEndDay

        //add passed in offset to todays date to create Pledge Start Date
        def NewPledgeStartDate

        NewPledgeStartDate = Today.plus(((PledgeStartDayOffset) as Integer))

        PledgeStartYear = ((NewPledgeStartDate.format(yearFormat)) as String)

        PledgeStartMonth = ((NewPledgeStartDate.format(monthFormat)) as String)

        PledgeStartDay = ((NewPledgeStartDate.format(dayFormat)) as String)

        System.out.println('New PledgeStartDate = ' + NewPledgeStartDate)

        System.out.println('New PledgeStartYear = ' + PledgeStartYear)

        System.out.println('New PledgeStartMonth = ' + PledgeStartMonth)

        System.out.println('New PledgeStartDay = ' + PledgeStartDay)

        //add passed in offset to todays date to create Pledge End Date
        def NewPledgeEndDate

        NewPledgeEndDate = Today.plus(((PledgeEndDayOffset) as Integer))

        PledgeEndYear = ((NewPledgeEndDate.format(yearFormat)) as String)

        PledgeEndMonth = ((NewPledgeEndDate.format(monthFormat)) as String)

        PledgeEndDay = ((NewPledgeEndDate.format(dayFormat)) as String)

        System.out.println('New PledgeEndDate = ' + NewPledgeEndDate)

        System.out.println('New PledgeEndYear = ' + PledgeEndYear)

        System.out.println('New PledgeEndMonth = ' + PledgeEndMonth)

        System.out.println('New PledgeEndDay = ' + PledgeEndDay)

        //choose start year
        WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/select_Year'), PledgeStartYear, false)

        //choose start month
        WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/select_Month'), PledgeStartMonth, false)

        //choose start day
        TestObject tObj_StartDate = new TestObject('Start Date')

        tObj_StartDate.addProperty('xpath', ConditionType.EQUALS, "//div[@class = 'btn-light ng-star-inserted' and (text() = '$PledgeStartDay' or . = '$PledgeStartDay')]")

        WebUI.click(tObj_StartDate)

        WebUI.delay(1)

        WebUI.click(findTestObject('Page_Give to/endDate_app-date-picker'))

        //choose end year
        WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/select_Year'), PledgeEndYear, false)

        //choose end month
        WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/select_Month'), PledgeEndMonth, false)

        WebUI.delay(1)

        //choose end day
        tObj_StartDate.addProperty('xpath', ConditionType.EQUALS, "//div[@class = 'btn-light ng-star-inserted' and (text() = '$PledgeEndDay' or . = '$PledgeEndDay')]")

        WebUI.click(tObj_StartDate)

        //Amount
        TestObject tObj_PledgeAmount = new TestObject('Pledge Amount')

        tObj_PledgeAmount.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'amount\']')

        WebUI.setText(tObj_PledgeAmount, PledgeAmount)

        //Frequency
        WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/Frequency'), PledgeFrequency, false)

        //Save/Cancel
        TestObject tObj_SaveCancelPledge = new TestObject('Save Cancel Pledge')

        if (PledgeSaveCancel == 'Save') {
            tObj_SaveCancelPledge.addProperty('xpath', ConditionType.EQUALS, '//button[@id=\'btn-save\']')
        } else if (PledgeSaveCancel == 'Cancel') {
            tObj_SaveCancelPledge.addProperty('xpath', ConditionType.EQUALS, '//button[@id=\'btn-cancel\']')
        }
        
        WebUI.click(tObj_SaveCancelPledge)

        //Verify Thank You message
        custom.Custom_Functionality.VerifyThanksMessage()

        break
    case 'Goal_Donate':
        //goal donate flow
        WebUI.comment('*Goal_Donate*')

        WebUI.delay(2)

        //PledgeAction
        WebUI.waitForElementPresent(tObj_PledgeAction, 3)

        WebUI.click(tObj_PledgeAction)

        WebUI.delay(2)

        //general giving
        //custom.WebPages.General_Giving(FundName,GiftInputType,GiftAmount) **changed FundName to CategoryName for Goal_Donate only. Category name must be there 
        //instead of FundName for donation.
        custom.WebPages.General_Giving(CategoryName, GiftInputType, GiftAmount, FundNameCount)

        //frequency
        custom.WebPages.GivingFrequency(HowOften, Frequency, ChargeOn, DelayDayOffset, EndDayOffset)

        //add message
        custom.WebPages.AddGivingMessage(AddMessage, UTCTime)

        //give ananymously
        custom.WebPages.GiveAnanymously(GiveAnonymously)

        //Click Next
        custom.WebPages.GiveToNext()

        //sign in from slug
        //if pledge and slug login, sign up/sign in
        if (ContinueAs == 'Member') {
            custom.Custom_Functionality.SignInAsMember(SignInName, SignInPassword)
        } else if ((ContinueAs == 'NewMember') || (ContinueAs == 'Guest')) {
            custom.Custom_Functionality.SignUpAsNewMember(MemberFirstName, MemberLastName, UTCTime, MemberMobileNumber, 
                MemberStreetAddress1, MemberCity, MemberStateProvince, MemberZip, MemberCountry, NewMemberPassword)
        }
        
        //new credit card
        if (PaymentMethod == 'New Credit Card') {
            custom.WebPages.NewCreditCard(AccountNumber, ExpirationMonthYear, CVC3, CVC4, NameOnCard, ZipPostalCode, SavePaymentMethod, 
                ContinueAs //new bank account
                ) //confirmation page
            //no payment method
        } else if (PaymentMethod == 'New Bank Account') {
            custom.WebPages.NewBankAccount(BankAccountHolderName, RoutingNumber, AccountNumber, CheckingOrSavings, SavePaymentMethod, 
                ContinueAs,UTCTime)
        } else if (PaymentMethod == 'Existing Payment Method') {
            custom.WebPages.ConfirmPage(SubmitGive, FeeOffset, GiveAnonymously, DonatePurchaseGoal, HowOften)
        } else {
            WebUI.comment('***No Payment Method***')
        }
        
        //confirmation page
        custom.WebPages.ConfirmPage(SubmitGive, FeeOffset, GiveAnonymously, DonatePurchaseGoal, HowOften)

        break
    default:
        WebUI.comment('****Case statement DonatePurchaseGoal switch not present***')}

WebUI.comment('end')

/*/***********************************************
Give To_Page /category
choose gift type
************************************************/
WebUI.closeBrowser()