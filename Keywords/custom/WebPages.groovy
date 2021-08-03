package custom

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.ss.formula.functions.Today
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import jdk.jfr.Frequency
import webUI.ContinueAs




public class WebPages {

	static void Choose_Campus_Page(CampusName,CampusCount){
		WebUI.comment('Begin: Choose_Campus_Page')
		//Object Validation - Campus

		if (CampusCount != "1"){
			//Test Actions - Campus
			TestObject tObj_CampusName = new TestObject('Campus Name')
			WebUI.delay(1)
			tObj_CampusName.addProperty('xpath', ConditionType.EQUALS, "//p[(starts-with(text(), '$CampusName') or starts-with(., '$CampusName'))]")
			WebUI.delay(1)
			WebUI.waitForElementPresent(tObj_CampusName, 3)
			//WebUI.verifyElementText(tObj_CampusName, CampusName, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(tObj_CampusName)

			//CustomKeywords.'webUI.MyOrganizations.clickElement'(tObj_CampusName)
		}

	}

	static void Campus_GivingType_Page(GiftType,GiftTypeCount){
		WebUI.comment('Begin: Campus_GivingType_Page')
		//Object Validation - Giving Type

		if (GiftTypeCount != "1"){
			//Test Actions - Giving Type (Donate, Purchase or "Pledge Name")
			WebUI.waitForPageLoad(3, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(2)

			TestObject tObj_GivingType = new TestObject('Giving Type')

			tObj_GivingType.addProperty('xpath', ConditionType.EQUALS, "//*[normalize-space(text()) and normalize-space(.)='$GiftType']")

			WebUI.waitForElementPresent(tObj_GivingType, 5)
			//WebUI.verifyElementText(tObj_GivingType, GiftType, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.click(tObj_GivingType)

			//CustomKeywords.'webUI.MyOrganizations.clickElement'(tObj_GivingType)
		}
	}

	static void General_Giving(FundName,GiftInputType,GiftAmount,FundNameCount){
		WebUI.comment('Begin: General_Giving')

		WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

		WebUI.delay(1)

		List Funds = FundName.split('\\|')

		System.out.println(Funds.size())

		List InputTypes = GiftInputType.split('\\|')

		System.out.println(InputTypes.size())

		List GiftAmounts = GiftAmount.split('\\|')

		System.out.println(GiftAmounts.size())

		if ((Funds.size() != InputTypes.size()) || (InputTypes.size() != GiftAmounts.size())) {
			KeywordUtil.markFailed('FundName, InputTypes and GiftInputType need to be same number of items in data')
		} else {
			KeywordUtil.markPassed('FundName, InputTypes and GiftInputType have same number of data items')
		}

		System.out.println(Funds.size())



		for (int index = 0; index < Funds.size(); index++) {
			System.out.println(Funds[index])

			System.out.println(InputTypes[index])

			System.out.println(GiftAmounts[index])

			String FundNames = Funds[index]

			String GiftType = InputTypes[index]

			String Amount = GiftAmounts[index]

			System.out.println((((((('FundName is ' + FundNames) + ', GiftType is ') + GiftType) + ' and Amount is ') + Amount) +
					' : index is - ') + index)

			//create object for current FundName
			TestObject tObj_FundActivateButton = new TestObject('Fund Activation Button')

			WebUI.delay(1)
			tObj_FundActivateButton.addProperty('xpath', ConditionType.EQUALS, "//*[normalize-space(text()) and normalize-space(.)='$FundNames']")
			if (FundNameCount != "1"){
				if (WebUI.verifyElementPresent(tObj_FundActivateButton, 3)) {
					WebUI.waitForElementPresent(tObj_FundActivateButton, 3)
					WebUI.click(tObj_FundActivateButton)
					WebUI.waitForElementClickable(tObj_FundActivateButton, 3)
					WebUI.verifyElementPresent(tObj_FundActivateButton, 3)
				}
			}




			//InputType = "Currency" or "Quantity"
			TestObject tObj_CurrencyInputType = new TestObject('Currency Input Type')

			switch (GiftType) {
				case 'AmountCurrency':
					tObj_CurrencyInputType.addProperty('xpath', ConditionType.EQUALS, "//*[@id='$FundNames']/div[2]/app-currency-input/input")

					WebUI.comment('got to currency')

					break
				case 'AmountQuantity':
					tObj_CurrencyInputType.addProperty('xpath', ConditionType.EQUALS, "//*[@id='$FundNames']/div[2]/div/app-quantity-input/div/input")

					WebUI.comment('got to quantity')

					break
				default:
					WebUI.comment('****Case statement switch not present***')}

			WebUI.waitForElementPresent(tObj_CurrencyInputType, 3)

			WebUI.setText(tObj_CurrencyInputType, Amount)
		}
	}

	static void GivingFrequency(HowOften,Frequency,ChargeOn,DelayDayOffset,EndDayOffset){
		WebUI.comment('Begin: GivingFrequency')
		TestObject tObj_CurrencyInputType = new TestObject('Currency Input Type')

		TestObject tObj_Frequency = new TestObject('Frequency')

		TestObject tObj_ContinueAs = new TestObject('Continue As')

		switch (HowOften) {
			case 'One-Time':
				tObj_CurrencyInputType.addProperty('xpath', ConditionType.EQUALS, '//*/text()[normalize-space(.)=\'One-Time\']/parent::*')

				WebUI.comment('got to One-Time')

				WebUI.waitForElementPresent(tObj_CurrencyInputType, 3)

				WebUI.click(tObj_CurrencyInputType)

				break
			case 'Recurring':
				tObj_CurrencyInputType.addProperty('xpath', ConditionType.EQUALS, '//*/text()[normalize-space(.)=\'Recurring\']/parent::*')

				WebUI.waitForElementPresent(tObj_CurrencyInputType, 3)

				WebUI.click(tObj_CurrencyInputType)

				WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/Frequency'), Frequency, false)

				WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/ChargeON'), ChargeOn, false)

			//passed in variables from data sheet
				System.out.println("DelDayOff = " + DelayDayOffset)
				System.out.println("EndDayOff = " + EndDayOffset)

			//get todays date as define formats
				def dateFormat = "dMMMyyyy"
				def dayFormat  = "d"
				def monthFormat  = "MMM"
				def yearFormat  = "yyyy"
				def Today = new Date()

			//add delayed start date
				if (DelayDayOffset != 'N/A') {

					def DelayedStartYear
					def DelayedStartMonth
					def DelayedStartDay

					//add passed in offset to todays date to create Delay Date
					def NewDelayDate
					NewDelayDate = Today.plus(DelayDayOffset as Integer)
					DelayedStartYear = NewDelayDate.format(yearFormat) as String
					DelayedStartMonth = NewDelayDate.format(monthFormat) as String
					DelayedStartDay = NewDelayDate.format(dayFormat) as String
					System.out.println("New DelayDate = " + NewDelayDate)
					System.out.println("New DelayYear = " + DelayedStartYear)
					System.out.println("New DelayMonth = " + DelayedStartMonth)
					System.out.println("New DelayDay = " + DelayedStartDay)

					//click Add delayed Start Date option
					WebUI.click(findTestObject('Object Repository/Page_Give to/button_ Add delayed Start Date'))

					TestObject tObj_DelayedStartDate = new TestObject('Delayed Start Date')
					tObj_DelayedStartDate.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='Delayed Start Date'])[1]/following::div[2]")
					WebUI.click(tObj_DelayedStartDate)
					WebUI.delay(1)

					//choose start year
					WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/select_Year'), DelayedStartYear, false)
					//choose start month
					WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/select_Month'), DelayedStartMonth, false)

					//choose start date
					TestObject tObj_DelayedDate = new TestObject('Delayed Date')
					tObj_DelayedDate.addProperty('xpath', ConditionType.EQUALS,"//div[@class = 'btn-light ng-star-inserted' and (text() = \'$DelayedStartDay\' or . = \'$DelayedStartDay\')]")
					WebUI.click(tObj_DelayedDate)
				}

			//add end date
				if (EndDayOffset != 'N/A') {

					//page variable definitions
					def EndYear
					def EndMonth
					def EndDay

					//add passed in offset to todays date to create End Date
					def NewEndDate
					NewEndDate = Today.plus(EndDayOffset as Integer)
					EndYear = NewEndDate.format(yearFormat) as String
					EndMonth = NewEndDate.format(monthFormat) as String
					EndDay = NewEndDate.format(dayFormat) as String
					System.out.println("New EndDate = " + NewEndDate)
					System.out.println("New EndYear = " + EndYear)
					System.out.println("New EndMonth = " + EndMonth)
					System.out.println("New EndDay = " + EndDay)

					TestObject tObj_PledgeEndDate = new TestObject('Pledge End Date')
					tObj_PledgeEndDate.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='End Date'])[1]/following::div[1]")
					WebUI.click(tObj_PledgeEndDate)

					WebUI.delay(1)

					//choose start year
					WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/select_Year'), EndYear, false)
					//choose start month
					WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Give to/select_Month'), EndMonth, false)

					//choose start date
					TestObject tObj_PledgeEndDay = new TestObject('Pledge End Day')
					tObj_PledgeEndDay.addProperty('xpath', ConditionType.EQUALS,"//div[@class = 'btn-light ng-star-inserted' and (text() = \'$EndDay\' or . = \'$EndDay\')]")
					WebUI.click(tObj_PledgeEndDay)
				}

				break
			default:
				WebUI.comment('****Case statement switch not present***')
		}

	}

	static void AddGivingMessage(AddMessage,UTCTime){
		WebUI.comment('Begin: AddGivingMessage')

		if (AddMessage != 'N/A') {
			WebUI.comment('Add message not blank and is :' + AddMessage + " submitted " + UTCTime)

			TestObject tObj_MessageBox = new TestObject('Message Text Box')

			tObj_MessageBox.addProperty('xpath', ConditionType.EQUALS,  '//*/text()[normalize-space(.)=\'Add a message\']/parent::*')

			WebUI.waitForElementPresent(tObj_MessageBox, 3)

			WebUI.verifyElementPresent(tObj_MessageBox, 1, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(tObj_MessageBox)

			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Give to/AddMessage'), 3)

			WebUI.setText(findTestObject('Object Repository/Page_Give to/AddMessage'), AddMessage + " submitted " + UTCTime)
		}
	}

	static void GiveAnanymously(GiveAnonymously){
		WebUI.comment('Begin: GivingAnanymously')
		if (GiveAnonymously != 'No') {
			TestObject tObj_GiveAnonymously = new TestObject('Give Anonymously')

			tObj_GiveAnonymously.addProperty('xpath', ConditionType.EQUALS, "//app-checkbox[@id='checkbox-give-anonymously']/span")

			WebUI.waitForElementPresent(tObj_GiveAnonymously, 3)

			WebUI.click(tObj_GiveAnonymously)
		}

		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Give to/button_Next Payment Details'), 3)

		if (!(WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Give to/button_Next Payment Details')))) {
			KeywordUtil.markFailedAndStop('Next Payment Details button not clickable')
		}
	}

	static void GiveToNext(){
		WebUI.comment('Begin: GiveToNext')
		WebUI.click(findTestObject('Object Repository/Page_Give to/button_Next Payment Details'))

	}

	static void DeletePaymentMethods(){
		WebUI.comment('Begin: DeletePaymentMethods')
		TestObject tObj_PaymentMethods = new TestObject('Payment Methods')
		tObj_PaymentMethods.addProperty('xpath', ConditionType.EQUALS, "//*[@id = 'activate-paymentMethod']")

		List<WebElement> trElements1 = WebUI.findWebElements(tObj_PaymentMethods,10)
		println "trElements1.size()=${trElements1.size()}"





		//for (int index = 0; index < Funds.size(); index++) {





		//}




	}

	static void ExistingPaymentMethod(PaymentMethod,ChoosePaymentMethod,PaymentType){
		WebUI.comment('Begin: ExistingPaymentMethod')
		TestObject tObj_SavePaymentMethodButton = new TestObject('Payment Methods Button') //for credit card and bank account save

		TestObject tObj_PaymentNextButton = new TestObject('Payment Next Button') //for credit card and bank account next

		TestObject tObj_PaymentCancelButton = new TestObject('Payment Cancel Button') //for credit card and bank account next

		WebUI.comment('Payment Method not blank and is :' + PaymentMethod)

		TestObject tObj_PaymentMethod = new TestObject('Payment Method')

		WebUI.delay(1)

		List<WebElement> trElements = WebUI.findWebElements(new TestObject('Payment Type').addProperty("xpath", ConditionType.EQUALS,"//*[@data-payment-type='$PaymentType']/div"), 10)
		println "Size of trElements (payment type '"+ PaymentType + "' found =${trElements.size()}"

		println "Choosing first element of array"
		WebUI.click(WebUI.convertWebElementToTestObject(trElements[0]))
		println "After first element of array chosen"

	}

	static void NewCreditCard(AccountNumber,ExpirationMonthYear,CVC3,CVC4,NameOnCard,ZipPostalCode,SavePaymentMethod,ContinueAs){
		WebUI.comment('Begin: NewCreditCard')
		TestObject tObj_SavePaymentMethodButton = new TestObject('Save Payment Method Button') //for credit card and bank account save

		TestObject tObj_SavePaymentMethodCheckbox = new TestObject('Save Payment Method Checkbox') // for credit card and bank account save checkbox

		TestObject tObj_PaymentNextButton = new TestObject('Payment Next Button') //for credit card and bank account next

		TestObject tObj_PaymentCancelButton = new TestObject('Payment Cancel Button') //for credit card and bank account next

		TestObject tObj_AddPaymentType = new TestObject('Add Payment Type')

		WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

		if (ContinueAs != "Guest"){
			if (ContinueAs != "NewMember")	{

				//TODO add code to cover where no payments are listed
				tObj_AddPaymentType.addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'add-payment\']')
				WebUI.comment("Looking for add-payment object")
				if (WebUI.verifyElementPresent(tObj_AddPaymentType,3, FailureHandling.OPTIONAL)){
					WebUI.comment("Note: If this is a warning, it is because there are no previous payment options to choose from.")
					WebUI.waitForElementPresent(tObj_AddPaymentType, 5)
					WebUI.delay(1)
					WebUI.click(tObj_AddPaymentType)
				}
			}
		}

		TestObject tObj_ChooseCard = new TestObject('Choose Card')

		tObj_ChooseCard.addProperty('xpath', ConditionType.EQUALS, '//a[contains(text(),\'Card\')]')

		WebUI.click(tObj_ChooseCard)

		TestObject tObj_CardNumber = new TestObject('Card Number')

		tObj_CardNumber.addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'card-number\']')

		WebUI.waitForElementPresent(tObj_CardNumber, 3)

		WebUI.setText(tObj_CardNumber, AccountNumber)

		WebUI.delay(1)

		WebUI.setText(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/input_MM  YY_exp-date'),
				ExpirationMonthYear)

		WebUI.delay(1)

		if (CVC3 != 'N/A') {
			WebUI.setText(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/input_CVC_cvc'), CVC3)
		} else if (CVC4 != 'N/A') {
			WebUI.setText(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/input_CVC_cvc'), CVC4)
		} else {
			WebUI.comment("CVC not set up in data")
		}

		WebUI.setText(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/input_Name On Card_name'),
				NameOnCard)

		WebUI.setText(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/input_ZIP  Postal Code_zip'),
				ZipPostalCode)

		tObj_SavePaymentMethodCheckbox.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='Save payment method'])[1]/preceding::app-icon-button[1]")

		if (SavePaymentMethod == 'Yes') {
			WebUI.waitForElementPresent(tObj_SavePaymentMethodCheckbox, 5)

			if (!(WebUI.verifyElementClickable(tObj_SavePaymentMethodCheckbox))) {
				KeywordUtil.markFailedAndStop('ACH Save button not clickable, stopping test now...')
			}

			WebUI.waitForElementPresent(tObj_SavePaymentMethodCheckbox, 5)

			WebUI.comment('Save Payment already checked')

		}
		else if (SavePaymentMethod == 'No'){
			WebUI.waitForElementPresent(tObj_SavePaymentMethodCheckbox, 5)

			if (!(WebUI.verifyElementClickable(tObj_SavePaymentMethodCheckbox))) {
				KeywordUtil.markFailedAndStop('ACH Save button not clickable, stopping test now...')
			}

			WebUI.click(tObj_SavePaymentMethodCheckbox)

		}else {
			WebUI.comment('*>>Save Bank Payment Type NOT TESTED')

		}

		if (ContinueAs == 'Guest') {
			if (WebUI.verifyElementNotPresent(tObj_SavePaymentMethodCheckbox, 5)) {
				KeywordUtil.markFailed('Credit Card Payment Save button exist for Guest role')
			}
		}

		tObj_PaymentNextButton.addProperty('xpath', ConditionType.EQUALS, '(//button[@id=\'btn-save-new-cc\'])[2]')

		WebUI.waitForElementPresent(tObj_PaymentNextButton, 3)

		if (!(WebUI.verifyElementClickable(tObj_PaymentNextButton))) {
			KeywordUtil.markFailedAndStop('Credit Card Payment Next button not clickable, stopping test now...')
		}
		WebUI.scrollToElement(tObj_PaymentNextButton,3)
		WebUI.click(tObj_PaymentNextButton)

		WebUI.comment('nothing')
	}

	static void NewBankAccount(BankAccountHolderName,RoutingNumber,AccountNumber,CheckingOrSavings,SavePaymentMethod,ContinueAs,UTCTime){
		WebUI.comment('Begin: NewBankAccount')
		WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

		TestObject tObj_SavePaymentMethodButton = new TestObject('Save Payment Method Button') //for credit card and bank account save

		TestObject tObj_SavePaymentMethodCheckbox = new TestObject('Save Payment Method Checkbox') // for credit card and bank account save checkbox

		TestObject tObj_PaymentNextButton = new TestObject('Payment Next Button') //for credit card and bank account next

		TestObject tObj_PaymentCancelButton = new TestObject('Payment Cancel Button') //for credit card and bank account next

		TestObject tObj_AddPaymentType = new TestObject('Add Payment Type')
		WebUI.delay(1)
		if (ContinueAs != "Guest"){
			if (ContinueAs != "NewMember"){
				tObj_AddPaymentType.addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'add-payment\']')
				if (WebUI.verifyElementPresent(tObj_AddPaymentType, 2, FailureHandling.OPTIONAL)){
					WebUI.waitForElementPresent(tObj_AddPaymentType, 5)
					WebUI.click(tObj_AddPaymentType)
				}
			}
		}
		WebUI.delay(1)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/a_Bank Account'),3)

		WebUI.click(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/a_Bank Account'))
		WebUI.delay(1)
		//Enter Bank Information
		//Routing Number: 072403004
		//Account Number: 856667
		WebUI.setText(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/input_Account Holder Name_account-holder-name'),
				BankAccountHolderName)

		WebUI.setText(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/input_Routing Number_routing-number'),
				RoutingNumber)

		WebUI.setText(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/input_Account Number_account-number'),
				UTCTime)//AccountNumber replaced by UTC time to make unique 6/22/21

		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Payment Method/Add Payment Method/select_Checking  Savings'),
				CheckingOrSavings, true)

		tObj_SavePaymentMethodCheckbox.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='Save payment method'])[1]/preceding::app-icon-button[1]")

		if (SavePaymentMethod == 'Yes') {
			WebUI.waitForElementPresent(tObj_SavePaymentMethodCheckbox, 5)

			if (!(WebUI.verifyElementClickable(tObj_SavePaymentMethodCheckbox))) {
				KeywordUtil.markFailedAndStop('ACH Save button not clickable, stopping test now...')
			}

			WebUI.comment('Save Payment already checked')

		}
		else if (SavePaymentMethod == 'No') {
			WebUI.waitForElementPresent(tObj_SavePaymentMethodCheckbox, 5)

			if (!(WebUI.verifyElementClickable(tObj_SavePaymentMethodCheckbox))) {
				KeywordUtil.markFailedAndStop('ACH Save button not clickable, stopping test now...')
			}
			WebUI.delay(1)
			WebUI.check(tObj_SavePaymentMethodCheckbox)

			WebUI.comment('Save Payment in now unchecked')

		}else {
			WebUI.comment('*>>Save Bank Payment Type NOT TESTED')

		}

		/*if (SaveOrCancelPayment == 'Cancel') {
		 tObj_PaymentCancelButton.addProperty('xpath', ConditionType.EQUALS, '(//button[@id=\'btn-cancel\'])[2]')
		 WebUI.waitForElementPresent(tObj_PaymentCancelButton, 3)
		 if (!(WebUI.verifyElementClickable(tObj_PaymentCancelButton))) {
		 KeywordUtil.markFailedAndStop('Credit Card Payment Next button not clickable, stopping test now...')
		 }
		 WebUI.click(tObj_PaymentCancelButton)
		 } else {
		 WebUI.comment('Bank info not saved')
		 }*/
		WebUI.delay(1)
		//click next

		tObj_PaymentNextButton.addProperty('xpath', ConditionType.EQUALS, "(//button[@type='submit'])[2]")

		WebUI.waitForElementPresent(tObj_PaymentNextButton, 3)
		WebUI.waitForElementVisible(tObj_PaymentNextButton, 3)
		if (!(WebUI.verifyElementClickable(tObj_PaymentNextButton))) {
			KeywordUtil.markFailedAndStop('Credit Card Payment Next button not clickable, stopping test now...')
		}
		WebUI.delay(5)

		WebUI.scrollToElement(tObj_PaymentNextButton,2)
		WebUI.click(tObj_PaymentNextButton)
		WebUI.delay(5)
	}

	static void ConfirmPage(SubmitGive,FeeOffset,GiveAnonymously,DonatePurchaseGoal,HowOften){
		WebUI.comment('Begin: ConfirmPage')

		//submit Give is Yes
		if (SubmitGive == 'Yes') {
			WebUI.delay(1 /*3)*/ )

			WebUI.waitForElementPresent(findTestObject('Page_Review_Confirm/button_Give_Submit'), 3)

			//definitions
			List FeeOffsetDollarAmount
			List FinalTotalDollarAmount
			String FeeOffsetText = "Fee Offset Not Chosen"
			String OffsetStringAmount = "0"
			String FeeOffsetString = "0"
			String FinalDonateAmount = ""
			BigDecimal TotalDonateAmount = 0
			BigDecimal bigDecimalFeeOffsetCurrency = 0
			BigDecimal bigDecimalDonateCurrency
			BigDecimal bigFinalDecimalDonateCurrency

			//get total donation amount before fee offset
			TestObject tObj_DonateTotal = new TestObject('Giving Type')
			tObj_DonateTotal.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='Edit'])[3]/preceding::h4[1]")
			def TotalAmount = WebUI.getText(tObj_DonateTotal)
			println("Total Amount is '" + TotalAmount+"'")
			List TotalDollarAmount = TotalAmount.split('\\$')
			String DonateAmount = TotalDollarAmount[1]

			//remove commas
			String DonateAmountString = DonateAmount.replace(",", "")

			//change string to BigDecimal
			bigDecimalDonateCurrency=new BigDecimal(DonateAmountString);
			System.out.println("Converted String currency to bigDecimalCurrency: "+bigDecimalDonateCurrency);

			//process fee offset
			TestObject tObj_FeeOffset = new TestObject('Fee Offset')
			if (FeeOffset == 'Yes') {
				tObj_FeeOffset.addProperty('xpath', ConditionType.EQUALS, '(.//*[normalize-space(text()) and normalize-space(.)=\'Help offset transaction fees?\'])[1]/following::button[1]')

				if (WebUI.verifyElementPresent(tObj_FeeOffset, 5)) {

					KeywordUtil.markPassed('Fee Offset Checkbox Found')

					//fee offset amount text
					if (WebUI.verifyElementPresent(findTestObject('Page_Review_Confirm/div_AdditionalFeeOffsetAmount'),	5)) {
						FeeOffsetText = WebUI.getText(findTestObject('Page_Review_Confirm/div_AdditionalFeeOffsetAmount'))

						String FeeOffsetMessage = WebUI.getText(findTestObject('Object Repository/Page_Review_Confirm/div_Help offset message'))

						KeywordUtil.markPassed(((((('Fee Offset Text ' + '"') + FeeOffsetMessage) + ' ') + FeeOffsetText) + '"') +
								' is present')

						FeeOffsetDollarAmount = FeeOffsetText.split('\\$')
						OffsetStringAmount = FeeOffsetDollarAmount[1]

						//remove commas
						FeeOffsetString = OffsetStringAmount.replace(",", "")

						//change string to BigDecimal
						bigDecimalFeeOffsetCurrency=new BigDecimal(FeeOffsetString);
						System.out.println("Converted FeeOffsetString currency to bigDecimalCurrency: "+bigDecimalFeeOffsetCurrency)

						//click fee offset
						WebUI.click(tObj_FeeOffset)
					} else {
						KeywordUtil.markFailed('Fee Offset Button or Text Not present')
					}
				}
			}

			//check for anonymous transaction message
			if (GiveAnonymously == 'Yes') {
				if (WebUI.verifyElementPresent(findTestObject('Page_Review_Confirm/div_You are making an anonymous trans_popup'),5)) {
					WebUI.comment('***Anonymous Transaction message found***')

					KeywordUtil.markPassed('Anonymous Transaction Message Text: You are making an anonymous transaction.Anonymous transactions will not count towards pledge progress.You can change this with the checkbox below.')
				} else {
					KeywordUtil.markFailed('Anonymous Transaction Message Text not found')
				}
			}

			//verify submit button text and click
			if (WebUI.verifyElementPresent(findTestObject('Page_Review_Confirm/button_Give_Submit'),5)) {
				WebUI.delay(1)

				String GiveSubmitText = WebUI.getText(findTestObject('Page_Review_Confirm/button_Give_Submit'))
				WebUI.delay(1)
				KeywordUtil.markPassed(((('Give button text ' + '"') + GiveSubmitText) + '"') + ' is present')

				//verify that DonatePurchaseGoal matches

				//split submit button text by $...if exists...otherwise will be only one element in array
				List DonatePurchaseGoalText = GiveSubmitText.split('\\$')
				String DonatePurchaseGoalTextString = DonatePurchaseGoalText[0]
				println("Give button text is: '" + DonatePurchaseGoalTextString + "'")

				//add Donate amount with Fee Offset amount
				if (FeeOffsetText == "Fee Offset Not Chosen") {
					println (FeeOffsetText)

				}else {
					TotalDonateAmount = bigDecimalDonateCurrency + bigDecimalFeeOffsetCurrency

					//verify Donate total = Fee offset if used and Donate amounts
					//GiveSubmitText
					tObj_DonateTotal.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='Edit'])[3]/preceding::h4[1]")
					def FinalTotalAmount = WebUI.getText(tObj_DonateTotal)
					println("FinalTotal Amount is '" + FinalTotalAmount+"'")
					FinalTotalDollarAmount = FinalTotalAmount.split('\\$')
					FinalDonateAmount = FinalTotalDollarAmount[1]

					//remove commas
					String FinalDonateAmountString = FinalDonateAmount.replace(",", "")

					//change string to BigDecimal
					bigFinalDecimalDonateCurrency=new BigDecimal(FinalDonateAmountString);
					System.out.println("Converted String currency to bigDecimalCurrency: "+bigFinalDecimalDonateCurrency);

					if (bigFinalDecimalDonateCurrency==TotalDonateAmount){
						KeywordUtil.markPassed(((('Give button text total' + '"') + TotalDonateAmount) + '"') + ' is correct')
						//System.out.println("here" + TotalDonateAmount)
					}else{
						KeywordUtil.markFailed(((('Give button text total' + '"') + TotalDonateAmount) + '"' + " did not match " +  bigFinalDecimalDonateCurrency) + '"')
					}

				}
				WebUI.delay(2)
				WebUI.verifyElementClickable(findTestObject('Page_Review_Confirm/button_Give_Submit'), FailureHandling.STOP_ON_FAILURE)
				WebUI.comment("Got past verify, BEFORE click Give Submit button")
				//click Give button
				WebUI.delay(2)
				WebUI.scrollToElement(findTestObject('Page_Review_Confirm/button_Give_Submit'), 3)
				WebUI.click(findTestObject('Page_Review_Confirm/button_Give_Submit'))
				WebUI.comment("AFTER click Give Submit button")
				WebUI.delay(1)

				WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

				WebUI.delay(1)

				//TODO: verify transaction alert message is not shown

				custom.Custom_Functionality.VerifyThanksMessage()


			} else {
				KeywordUtil.markFailed('Give Submit button not present')

				WebUI.comment('Give button was not found')
			}

		} else {
			WebUI.comment('***Not Submitted***')
		}

	}
}