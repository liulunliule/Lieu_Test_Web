import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable

println("=== TEST PUT API - UPDATE USER ===")

def response = WS.sendRequest(findTestObject('Object Repository/User/PUT_Edit_User'))

// 3. In response ra để xem
println("=== RESPONSE ===")
println("Status Code: " + response.getStatusCode())
println("Response Body: " + response.getResponseBodyContent())

WS.verifyResponseStatusCode(response, 200)


println("=== TEST PASSED ===")