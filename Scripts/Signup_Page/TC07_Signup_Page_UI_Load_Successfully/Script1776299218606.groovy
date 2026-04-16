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

WebUI.openBrowser('https://lieu-web-test.vercel.app/signup')

WebUI.verifyElementPresent(findTestObject('Page_Signup/txt_name'), 3)

WebUI.verifyElementPresent(findTestObject('Page_Signup/txt_email'), 3)

WebUI.verifyElementPresent(findTestObject('Page_Signup/txt_password'), 3)

WebUI.verifyElementPresent(findTestObject('Page_Signup/txt_confirmPassword'), 3)

WebUI.verifyElementPresent(findTestObject('Page_Signup/gender'), 3)

WebUI.verifyElementPresent(findTestObject('Page_Signup/opt_skill'), 3)

WebUI.verifyElementPresent(findTestObject('Page_Signup/btn_Register'), 3)

WebUI.closeBrowser()

