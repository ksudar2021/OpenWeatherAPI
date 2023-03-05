# OpenWeatherAPI
This project has been written in java and maven. Please use maven commands to test it
#Setup and Tests steps
Git clone the repository
Run the tests using #mvn test
The reports will be generated under OpenWeatherAPI/reports containing json,html and xml formats


#Answers to the Questions
Q1: What other scenarios would you suggest for the given page? List 3-5 suggestions.
A1: Other scenarios I propose

Scenario outline: Register an existing station Where the API still returns 200
Given I register an existing station
When I make POST request
Then I will receive a success response 

Scenario outline: Register a station with Invalid data type for latitude where API returns 400 err
Given I register a station with latitude of string type 
When I make POST request
Then I will receive a bad request error response

Scenario outline: Register a station with missing fields where API returns 400 error
Given I register a station without latitude, longitude and altitude
When I make POST request
Then I will receive a bad request error response

Scenario outline: Register a station without a request body where API returns 415 error
Given I register a station without request body
When I make POST request
Then I will receive a Unsupported media Type error response

Scenario outline: Register a station with invalid path where API returns 404 error
Given I register a station invalid path
When I make POST request
Then I will receive a Not Found error response

Scenario outline: Try to Perform GET stations with Invalid Key where API returns 401 err
Given a list of stations
When I make GET request
Then I will receive a unauthorised error response


Q2.If this test was part of a much larger test suite, how could you run a specific test or subset/group of tests?
A2. I have implemented tags and annotations in TestRunner class, I have tested too.  Snippet of the tags "tags="@valid or @error or @verify","
For specific test we have to remove the tags accordingly
For subset of tests I have tagged 2 test cases under @valid tag

Q3:Which approaches could be used to reduce the overall execution time? Describe how they could be implemented into your code base.
A3: To reduce the overall execution time I can perform a parallel execution 
Implementation :
Move all feature files in a folder
Add the Cucumber runner class 
Add parallel method configuration to POM.xml
On executing we could see the scenarios running on  parallel threads
We can also set specific number of thread count 

Q4 and Q5 are UI related and hence its not covered in this project

