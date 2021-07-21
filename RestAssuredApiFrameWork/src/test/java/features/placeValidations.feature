Feature: Validating Place api's

@AddPlace @Regression
Scenario Outline: verify if place being add successfully using addplaceapi
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When User call "addPlaceAPI" with "POST" http request
	Then The api call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created maps to "<name>" using "getPlaceAPI"
#scenario outline require when we want do data driven using Examples keyword

Examples:
	|name |language| address |
	|ashwini|hindi   | sangmaner tajane mala |
#	|tajanne |minglish | dholewadi sangamner |

@DeletePlace @Regression
Scenario: verify if delete place functionality working
	Given delete Place payload
	When User call "deletePlaceAPI" with "POST" http request
	Then The api call is success with status code 200
	And "status" in response body is "OK"