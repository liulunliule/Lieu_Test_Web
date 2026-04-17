package auth

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import com.kms.katalon.core.annotation.Keyword

class AuthKeywords {

    @Keyword
    def login(String email, String password) {
        WebUI.openBrowser('')
        WebUI.navigateToUrl(GlobalVariable.BASE_URL + '/login')

        WebUI.setText(findTestObject('Login_Page/txt_email'), email)
        WebUI.setText(findTestObject('Login_Page/txt_pass'), password)
        WebUI.click(findTestObject('Login_Page/btn_Login'))
    }
	
	@Keyword
	def changePassword(String oldPass, String newPass, String confirmPass) {
		WebUI.click(findTestObject('Profile_Page/btn_change_pass'))

		WebUI.setText(findTestObject('Profile_Page/change_pass/txt_ex_pass'), oldPass)
		WebUI.setText(findTestObject('Profile_Page/change_pass/txt_new_pass'), newPass)
		WebUI.setText(findTestObject('Profile_Page/change_pass/txt_confirm_new_pass'), confirmPass)
		
		WebUI.click(findTestObject('Profile_Page/edit_profile/btn_save_change'))
	}
}