Feature: Simple Get Request


  Scenario Outline: Sending request and obtaining respond
 scernario outline
    Given The <requestType> request was created with parameters: <requestData>
    When Client send to the server <name>  request
    Then Server return grreting: <response>
    Examples:
      | name | response |requestType|requestData|
    |serverName      | null         |  GET         |  |
    |serverName      |     respond            |    POST          | param1=value1, param2=value2, param3=value3 |