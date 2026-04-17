package common

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.annotation.Keyword
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


class CommonKeywords {

    @Keyword
    def waitAndVerify(def testObject) {
        WebUI.waitForElementVisible(testObject, 10)
        WebUI.verifyElementPresent(testObject, 5)
    }

	@Keyword
	def verifyToastMessage(String expectedText) {
		WebUI.waitForElementVisible(findTestObject('Toast/message'), 5)
		WebUI.verifyTextPresent(expectedText, true)
	}
    @Keyword
    def closeBrowser() {
        WebUI.closeBrowser()
    }
}