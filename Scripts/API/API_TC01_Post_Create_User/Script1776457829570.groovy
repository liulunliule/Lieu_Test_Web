import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable

GlobalVariable.randomEmail = "test_" + System.currentTimeMillis() + "@lieu.com"
GlobalVariable.randomPass = "test_" + System.currentTimeMillis() + "pass"

println("=== TEST POST API - CREATE USER ===")

def response = WS.sendRequest(findTestObject('User/POST_Create_User'))

// 3. In response ra để xem
println("=== RESPONSE ===")
println("Status Code: " + response.getStatusCode())
println("Response Body: " + response.getResponseBodyContent())

// 4. Verify Status Code (201 Created hoặc 200 OK)
WS.verifyResponseStatusCode(response, 201)

// 5. Verify dữ liệu trả về
WS.verifyElementPropertyValue(response, 'name', 'Test User')
WS.verifyElementPropertyValue(response, 'email', GlobalVariable.randomEmail)
WS.verifyElementPropertyValue(response, 'gender', false)

// 6. Verify skills là một mảng
def skills = WS.getElementPropertyValue(response, 'skills')
assert skills instanceof List : "Skills should be an array"

println("=== TEST PASSED ===")