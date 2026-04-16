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

WebUI.setText(findTestObject('Page_Signup/txt_name'), 'Test User')

WebUI.setText(findTestObject('Page_Signup/txt_email'), 'test123@gmail.com')

WebUI.setText(findTestObject('Page_Signup/txt_password'), '123456')

WebUI.setText(findTestObject('Page_Signup/txt_confirmPassword'), '123456')

WebUI.click(findTestObject('Page_Signup/radio_0'))

WebUI.click(findTestObject('Page_Signup/radio_1'))

WebUI.click(findTestObject('Page_Signup/btn_Register'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Email này đã được đăng ký', true)

WebUI.delay(0.5) //delay UI

boolean found = WebUI.verifyTextPresent('Email này đã được đăng ký', false, FailureHandling.CONTINUE_ON_FAILURE)

if (found) {
    println('Toast xuất hiện thành công')
} else {
    println('Không thấy toast - có thể đã redirect hoặc lỗi')
}

