Feature: Validating place APIs
@AddPlace @RegressionTest
Scenario Outline: verify if place is bing successfully added using add place API's
  Given Add place payload with "<name>" "<language>" "<address>"
  When user call's "AddPlaceAPI" with "post" http request 
  Then The API call got success with status code 200
  And "status" in response body is "OK"
  And verify "place_id" created maps to "<name>" using "GetPlaceAPI" with "get" method

Examples: 
     |name|language|address             |
     |Rhouse|Hindi   |india bangalore|
  #   |Shouse|Hindi    |india Rewa       |
 @DeletePlace @RegressionTest 
Scenario: verify if delete place API's is working
  Given delete place payload
  When user call's "DeletePlaceAPI" with "post" http request 
  Then The API call got success with status code 200
  And "status" in response body is "OK"

  
  