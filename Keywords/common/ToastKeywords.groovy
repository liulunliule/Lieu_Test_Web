package common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling

class ToastKeywords {

    /**
     * Verify toast message (handle toast xuất hiện nhanh rồi biến mất)
     * @param expectedText text mong đợi
     * @param timeout thời gian chờ tối đa (giây)
     */
    @Keyword
    def verifyToast(String expectedText, int timeout = 5) {
        boolean isFound = false
        long startTime = System.currentTimeMillis()

        while ((System.currentTimeMillis() - startTime) < timeout * 1000) {
            if (WebUI.verifyTextPresent(expectedText, false, FailureHandling.OPTIONAL)) {
                isFound = true
                break
            }
        }

        if (isFound) {
            WebUI.comment("Toast found: " + expectedText)
        } else {
            WebUI.comment("Toast NOT found: " + expectedText)
            WebUI.takeScreenshot()
            assert false : "Toast not found: " + expectedText
        }
    }
	
	@Keyword
	def isToastPresent(String expectedText, int timeout = 5) {
		long endTime = System.currentTimeMillis() + (timeout * 1000)
		
		while (System.currentTimeMillis() < endTime) {
			if (WebUI.getPageSource().contains(expectedText)) {
				WebUI.comment("✅ Toast found: " + expectedText)
				return true
			}
			Thread.sleep(100)
		}
		WebUI.comment("❌ Toast NOT found: " + expectedText)
		return false
	}
}