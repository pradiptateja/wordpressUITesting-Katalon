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
import com.github.javafaker.Faker as Faker

WebUI.callTestCase(findTestCase('Profile/Ensure user successfully opens profile page'), [:], FailureHandling.STOP_ON_FAILURE)

Faker faker = new Faker()

firstName = faker.name().firstName()

lastName = faker.name().lastName()

displayName = ((firstName + lastName) + faker.number().digit())

description = faker.address().streetAddress()

WebUI.setText(findTestObject('Profile Page/input_firstName'), firstName)

WebUI.setText(findTestObject('Profile Page/input_lastName'), lastName)

WebUI.setText(findTestObject('Profile Page/input_displayName'), displayName)

WebUI.setText(findTestObject('Profile Page/input_description'), description)

WebUI.click(findTestObject('Profile Page/button_saveProfileDetails'))

WebUI.verifyElementText(findTestObject('Profile Page/notice_text'), 'Settings saved successfully!')

WebUI.verifyElementText(findTestObject('Profile Page/text_gravatar'), displayName)

WebUI.verifyElementAttributeValue(findTestObject('Profile Page/input_firstName'), 'value', firstName, 0)

