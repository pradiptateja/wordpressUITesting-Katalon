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

WebUI.click(findTestObject('Profile Page/button_addSites'))

WebUI.click(findTestObject('Profile Page/button_addURL'))

WebUI.comment('Ensure user failed add site with wrong format')

WebUI.setText(findTestObject('Profile Page/input_URL'), GlobalVariable.Email)

WebUI.verifyElementNotClickable(findTestObject('Profile Page/button_doneAddSite'))

WebUI.comment('Ensure user successfully add site with correct format')

WebUI.setText(findTestObject('Profile Page/input_URL'), 'teja.com')

WebUI.setText(findTestObject('Profile Page/input_siteDescription'), 'Description123')

WebUI.click(findTestObject('Profile Page/button_doneAddSite'))

WebUI.verifyElementText(findTestObject('Profile Page/text_siteNameAdded'), 'teja.com')

WebUI.comment('Ensure user successfully delete sites')

WebUI.click(findTestObject('Profile Page/button_deleteSites'))

WebUI.verifyElementNotPresent(findTestObject('Profile Page/text_siteNameAdded'), 0)

