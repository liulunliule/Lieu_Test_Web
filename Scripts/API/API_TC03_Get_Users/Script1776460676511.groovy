import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable

println("=== TEST GET ALL USER ===")


def response = WS.sendRequest(findTestObject('Object Repository/User/GET_All_User'))

println("Status Code: " + response.getStatusCode())
println("Response Body: " + response.getResponseBodyContent())

WS.verifyResponseStatusCode(response, 200)

//println("User retrieved: ${name} (${email})")

println("=== TEST PASSED ===")