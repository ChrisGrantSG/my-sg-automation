import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import custom.WriteFile as WriteFile
import internal.GlobalVariable as GlobalVariable

//automation org naming pattern
//Automation Org10/28/202010_28_2020_04_04_02
//Test Description - taken from selected columns from data sheet to describe the test in general terms.
WebUI.comment(Description)

//userName: "testing+automationsuperadmin@securegive.com" and password: "test_password"
//slug: autoorg
//
/*
* Go to the SecureGive login
* Sign-in with userName: "testing+automationsuperadmin@securegive.com" and password: "test_password"
* Go to "Organizations"
* Create new Organization with name "Automation Org", slug "autoorg", country "United States", Street Address "123 automation", City "Charleston", State "South Carolina", Zip "29420", and Phone "8437201111"
* Success message displays for created Org
* Search for created Org
* Select created Org
* Go to "Campuses"
* Verify campus "Main Campus" is created
* Go to "ACH Settings"
* Setup ACH Processor Card Connect with Merchant ID "542041"
* ACH success message displays
* Go to "Organization Profile"
* Validate Organization Profile with unique org name and unique org slug and Country: "", Address: "123 automation", Address2: "", City: "Charleston", State: "", Zipcode:"29420", Tax Id: "", Phone: "8437201111", Notes: "", Admin access "disabled", Member access "disabled"

*/
/*/***********************************************
*Go to the SecureGive login
*Sign-in with userName: "testing+automationsuperadmin@securegive.com" and password: "test_password"
************************************************/
if (ScenarioType == 'Donate_SignIn_OrgAdmin') {
    //Object Validation - Sign In
    //Test Actions - Sign In 		
    CustomKeywords.'webUI.Login.loginIntoApplication'(GlobalVariable.SecureGiveURL, SignInName, SignInPassword)

    /*/***********************************************
	My Dashboard_Page
	as member or organization admin
	************************************************/
    //Object Validation - My Organizations
    //Test Actions - My Organizations
    WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE //TestObject tObj_OrgPhoneNumber = new TestObject()
        //tObj_OrgPhoneNumber.addProperty('xpath', ConditionType.EQUALS, "(.//*[normalize-space(text()) and normalize-space(.)='$PhoneNumber'])[1]/following::button[1]")
        ) //WebUI.waitForElementPresent(tObj_OrgPhoneNumber, 3)
} else if (ScenarioType == 'SignIn_SuperAdmin') {
    CustomKeywords.'webUI.Login.loginIntoApplication'(GlobalVariable.SecureGiveURL, SignInName, SignInPassword)
}

/*

//Organizations page:
button_Organizations //button[@id='btn-add']
button_Organizations-download //button[@id='btn-download']
button_Organizations-notifications //button[@id='btn-notifications']
button_Organizations-search  //button[@id='btn-next-page']
input_searchText //input[@id='filter-text']
search_selection //td[(starts-with(text(), 'Automation Org10/29/2020') or starts-with(., 'Automation Org10/29/2020'))]

button_Users //button[@id='users-menu']
a_Administrators //div[@id='dashboard-tabs']/div[3]/div/a
a_Members //div[@id='dashboard-tabs']/div[3]/div/a[2]

//Add Administrator page:
input_First Name_fistName //input[@name='fistName']
input_Last Name_lastName  //input[@name='lastName']
input_Email_email  //input[@name='email']
select_Administrator  //select[@name='role']
button_What_privileges  (//button[@type='button'])[3]
button_Cancel //button[@id='btn-cancel']
button_Send_Invite //button[@id='btn-save']

//Add Member Page:
button_Members_btn-add  //button[@id='btn-add']
input_First Name_firstName //input[@name='firstName']
input_Last Name_lastName //input[@name='lastName']
input_Email_email  //input[@name='email']
input_Phone_phone //input[@name='phone']
input_None Member ID_exportId //input[@name='exportId']
button_Save //button[@type='submit']
button_Cancel (//button[@type='button'])[2]
	
*/
WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)

/*/***********************************************
* Go to "Organizations"
* Create new Organization with name "Automation Org", slug "autoorg", country "United States", Street Address "123 automation", City "Charleston", State "South Carolina", Zip "29420", and Phone "8437201111"
* Success message displays for created Org
************************************************/
//verify at organizations
//Utilities
//create date for unique identification
//used in: email address
def now = new Date()

System.out.println(now.format('yyyy_MM_dd_HHmmssSSS', TimeZone.getTimeZone('UTC')))

UTCTime = now.format('yyyy_MM_dd_HHmmssSSS', TimeZone.getTimeZone('UTC'))

def OrgName = 'Automation Org' + UTCTime

System.out.println(OrgName)

//click "+" to add organization
WebUI.click(findTestObject('Page_Organizations/button_Organizations-add'))

WebUI.setText(findTestObject('Page_Organizations/input_OrganizationName'), OrgName)

//Automation Org10/28/202010_28_2020_04_04_02
WebUI.setText(findTestObject('Page_Organizations/input_Phone'), MemberMobileNumber)

if (OrgEnabled == 'Yes') {
    TestObject tObj_OrganizationStatusEnable = new TestObject()

    tObj_OrganizationStatusEnable.addProperty('xpath', ConditionType.EQUALS, '//label[@class = \'custom-control-label\' and @for = \'orgEnabled\']')

    WebUI.click(tObj_OrganizationStatusEnable)
}

if (OrgAdminAccessEnabled == 'Yes') {
    TestObject tObj_AdministratorAccessEnable = new TestObject()

    tObj_AdministratorAccessEnable.addProperty('xpath', ConditionType.EQUALS, '//label[@class = \'custom-control-label\' and @for = \'adminAccessEnabled\']')

    WebUI.click(tObj_AdministratorAccessEnable)
}

if (OrgMemberAccessEnabled == 'Yes') {
    TestObject tObj_MemberAccessAndProcessing = new TestObject()

    tObj_MemberAccessAndProcessing.addProperty('xpath', ConditionType.EQUALS, '//label[@class = \'custom-control-label\' and @for = \'memberAccessEnabled\']')

    WebUI.click(tObj_MemberAccessAndProcessing)
}

WebUI.setText(findTestObject('Page_Organizations/textarea_Visible to Super Admins only'), 'new organization')

WebUI.selectOptionByValue(findTestObject('Page_Organizations/select_Country'), MemberCountry, true)

WebUI.setText(findTestObject('Page_Organizations/input_StreetAddress'), MemberStreetAddress1)

//WebUI.setText(findTestObject('Page_Organizations/input_address2'), MemberStreetAddress2)
WebUI.setText(findTestObject('Page_Organizations/input_City'), MemberCity)

WebUI.selectOptionByValue(findTestObject('Page_Organizations/select_State'), MemberStateProvince, true)

WebUI.setText(findTestObject('Page_Organizations/input_ZipPostalCode'), MemberZip)

WebUI.click(findTestObject('Page_Organizations/button_Save'))

/*/***********************************************
* Search for created Org
* Select created Org
************************************************/
//verify at organizations
//search organization
//button[@id='btn-next-page']
//click Organizations page link
TestObject tObj_ChooseOrganizationsPageLink = new TestObject()

tObj_ChooseOrganizationsPageLink.addProperty('xpath', ConditionType.EQUALS, '//*[normalize-space(text()) and normalize-space(.)=\'Organizations\']')

WebUI.delay(1)

WebUI.click(tObj_ChooseOrganizationsPageLink)

//click search icon
TestObject tObj_OrganizationsSearchIcon = new TestObject()

tObj_OrganizationsSearchIcon.addProperty('xpath', ConditionType.EQUALS, '//button[@id=\'btn-next-page\']')

WebUI.delay(1)

WebUI.click(tObj_OrganizationsSearchIcon)

//choose organizations
TestObject tObj_OrganizationsSearchField = new TestObject()

tObj_OrganizationsSearchField.addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'filter-text\']')

WebUI.delay(1)

WebUI.setText(tObj_OrganizationsSearchField, OrgName)

WebUI.delay(1)

//search and verify OrgName from data
TestObject tObj_SearchResult = new TestObject()

tObj_SearchResult.addProperty('xpath', ConditionType.EQUALS, "//*[normalize-space(text()) and normalize-space(.)='$OrgName']")

if (WebUI.verifyElementPresent(tObj_SearchResult, 3, FailureHandling.STOP_ON_FAILURE)) {
    String file_name = 'Data Files//Organizations.txt'

    WriteFile data = new WriteFile(file_name, true)

    try {
        data.WriteToFile(OrgName)

        println('One record written to file...' + OrgName)
    }
    catch (IOException e) {
        System.out.println(e.getMessage())
    } 
    
    File file = new File('Data Files//Organizations.txt')

    println(file.getText())

    def OrgNames = file.getText()

    //turn text file into List
    List Orgs = OrgNames.split('\n')

    int OrgCount = Orgs.size()

    System.out.println(Orgs.size())

    for (int index = 0; index < Orgs.size(); index++) {
        System.out.println(Orgs[index])
    }
    
    String LastOrgInList = Orgs[(OrgCount - 1)]

    System.out.println('The last org in list is ' + LastOrgInList)

    WebUI.click(tObj_SearchResult)
}

//WebUI.selectOptionByIndex(findTestObject(null), null)
/*Next:
 * add each type of user to the automation account
 * Add data for each type of user to the automation account
*/
//Add Org Users
/*Sign-in with userName: "testing+automationsuperadmin@securegive.com" and password: "test_password"*/
// Add account users
//click Users page link
TestObject tObj_UsersPageLink = new TestObject()

tObj_UsersPageLink.addProperty('xpath', ConditionType.EQUALS, '//*[normalize-space(text()) and normalize-space(.)=\'Users\']')

WebUI.delay(1)

WebUI.click(tObj_UsersPageLink)

//button[@id='btn-add']
TestObject tObj_ButtonAdd = new TestObject()

tObj_ButtonAdd.addProperty('xpath', ConditionType.EQUALS, '//button[@id=\'btn-add\']')

WebUI.delay(1)

WebUI.click(tObj_ButtonAdd)

//enter firstName
TestObject tObj_UserFirstName = new TestObject()

tObj_UserFirstName.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'firstName\']')

WebUI.delay(1)

WebUI.setText(tObj_UserFirstName, 'Fred')

//enter lastName
TestObject tObj_UserLastName = new TestObject()

tObj_UserLastName.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'lastName\']')

WebUI.delay(1)

WebUI.setText(tObj_UserLastName, 'Admin')

//enter email
TestObject tObj_UserEmail = new TestObject()

tObj_UserEmail.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'email\']')

WebUI.delay(1)

WebUI.setText(tObj_UserEmail, ('testing+User_' + UTCTime) + '@securegive.com')

//enter phone
TestObject tObj_UserPhone = new TestObject()

tObj_UserPhone.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'phone\']')

WebUI.delay(1)

WebUI.setText(tObj_UserPhone, '3525551234')

//enter role
TestObject tObj_UserRole = new TestObject()

tObj_UserRole.addProperty('xpath', ConditionType.EQUALS, '//select[@name=\'selectedRole\']')

WebUI.click(tObj_UserRole)

WebUI.comment(WebUI.getText(tObj_UserRole))

WebUI.selectOptionByLabel(tObj_UserRole, 'Super Admin Manager', false)

/*Super Admin Administrator
Super Admin Manager
Super Admin User
Administrator
Account Manager
Reports Manager
Member Manager
Settings Manager
Kiosk Manager*/
//tObj_UserRole.addProperty('xpath', ConditionType.EQUALS, "//*[@name = 'role' and (text() = 'SuperAdmin'")//'$OrgRole'")
//WebUI.delay(1)
//WebUI.selectOptionByLabel(tObj_UserRole)//, "SuperAdmin")
//*[@name = 'role' and (text() = ' Administrator  Account Manager  Reports Manager  Member Manager  Settings Manager  Kiosk Manager ' or . = ' Administrator  Account Manager  Reports Manager  Member Manager  Settings Manager  Kiosk Manager ')]
//enter organization
TestObject tObj_UserOrganization = new TestObject('User Organization Lookup')

//tObj_UserOrganization.addProperty('xpath', ConditionType.EQUALS, '//app-select-input[@name=\'org-select\']')
tObj_UserOrganization.addProperty('xpath', ConditionType.EQUALS, '(//input[@type=\'text\'])[4]')

//enter organization name
WebUI.setText(tObj_UserOrganization, OrgName)

//enter address
TestObject tObj_UserAddress = new TestObject()

tObj_UserAddress.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'address\']')

WebUI.delay(1)

WebUI.setText(tObj_UserAddress, '1234 NW Main ST.')

//enter address2
TestObject tObj_UserAddress2 = new TestObject()

tObj_UserAddress2.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'address2\']')

WebUI.delay(1)

WebUI.setText(tObj_UserAddress2, 'Apt B')

//enter city
TestObject tObj_UserCity = new TestObject()

tObj_UserCity.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'city\']')

WebUI.delay(1)

WebUI.setText(tObj_UserCity, 'Augusta')

//enter state
//TODO: name attribute needs to be added SGDEV-15193 dev-only task
//WebUI.selectOptionByValue(findTestObject('Page_Organizations/select_State'), MemberStateProvince, true)
//WebUI.setText(tObj_UserState, "Georgia")
//enter zipcode
TestObject tObj_UserZip = new TestObject()

tObj_UserZip.addProperty('xpath', ConditionType.EQUALS, '//input[@name=\'zipcode\']')

WebUI.delay(1)

WebUI.setText(tObj_UserZip, '30904')

//enter country
WebUI.selectOptionByValue(findTestObject('Page_Organizations/select_Country'), MemberCountry, true)

//save Changes or cancel
TestObject tObj_UserSave = new TestObject()

tObj_UserSave.addProperty('xpath', ConditionType.EQUALS, '//button[@id=\'btn-save\']')

WebUI.delay(1)

WebUI.click(tObj_UserSave)

WebUI.delay(1)

TestObject tObj_UserProfileInfo = new TestObject()

tObj_UserProfileInfo.addProperty('xpath', ConditionType.EQUALS, ((('//*[(text() = \'testing+User_' + UTCTime) + '@securegive.com\' or . = \'testing+User_') + 
    UTCTime) + '@securegive.com\')]')

//def emailCompareText = "testing+User_" + UTCTime + "@securegive.com"*/
//WebUI.verifyElementText(findTestObject, UTCTime, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementText(tObj_UserProfileInfo, ('testing+User_' + UTCTime) + '@securegive.com', FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyElementText(findTestObject, UTCTime)
WebUI.comment('end')

WebUI.closeBrowser()

