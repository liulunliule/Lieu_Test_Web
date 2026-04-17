import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testdata.TestData
import internal.GlobalVariable
import common.ToastKeywords


ToastKeywords toast = new ToastKeywords()


println("========================================")
println("DATA-DRIVEN LOGIN TEST")
println("========================================")

// 1. Đọc file Excel
TestData testData = TestDataFactory.findTestData('Data Files/Data Test Login')
int totalRows = testData.getRowNumbers()

println("Total test cases: ${totalRows}")

int passCount = 0
int failCount = 0

// 2. Loop qua từng dòng
for (int i = 1; i <= totalRows; i++) {
    
    // Lấy dữ liệu từ Excel
    String testCase = testData.getValue('TestCase', i)
    String email = testData.getValue('Username/Email', i)
    String password = testData.getValue('Password', i)
    String expectedResult = testData.getValue('Expected_Result', i)
    
    println("")
    println("--- Row ${i}: ${testCase} ---")
    println("Email: [${email}]")
    println("Password: [${password}]")
    
        WebUI.openBrowser(GlobalVariable.BASE_URL + '/login')
    WebUI.waitForPageLoad(5)
    
        if (email != null && !email.isEmpty()) {
        WebUI.setText(findTestObject('Login_Page/txt_email'), email)
    }
    
        if (password != null && !password.isEmpty()) {
        WebUI.setText(findTestObject('Login_Page/txt_pass'), password)
    }
    
        WebUI.click(findTestObject('Login_Page/btn_Login'))
    WebUI.delay(2)
    
        if (expectedResult == 'Success') {
        WebUI.waitForPageLoad(5)
        
		toast.verifyToast('Đăng nhập thành công')
        WebUI.click(findTestObject('Object Repository/Profile_Page/btn_logout'))
        WebUI.waitForPageLoad(3)
        
        println("PASS - Login successful")
        passCount++
        
		} else {
			// Mong đợi login thất bại -> vẫn ở trang login
			String currentUrl = WebUI.getUrl()
			WebUI.verifyEqual(currentUrl, GlobalVariable.BASE_URL + '/login')
			
			WebUI.waitForPageLoad(5)
			
			try {
				toast.verifyToast('điền đầy đủ thông tin')
				println("PASS - Empty field error")
			} catch (AssertionError e1) {
				try {
					toast.verifyToast('Email hoặc mật khẩu không chính xác')
					println("PASS - Wrong credentials error")
				} catch (AssertionError e2) {
					assert false : "Neither toast message found!"
				}
			}
			
			passCount++
		}
    // 8. Đóng browser
    WebUI.closeBrowser()
}

println("")
println("========================================")
println("TEST SUMMARY")
println("========================================")
println("Total: ${totalRows}")
println("Passed: ${passCount}")
println("Failed: ${failCount}")
println("========================================")

assert failCount == 0 : "Some tests failed!"