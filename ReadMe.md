## Framework 
```
This is Appium-based mobile testing framework written in Java which utilizes a data-driven approach to efficiently test our mobile applications. 
Using data driven approach helps us to separate test scripts from data, enabling us to easily modify test scenarios and test the same functionality with different input data sets. 
In our case we have provided data of 4 leagues therefore test executes 4 times i.e for each league.
The framework have a reporting mechanism that generates detailed test execution reports using maven-surefire-plugin. 
These reports provide insights into test pass and failures.

```

## Build With
```
 1. Appium 1.22.3
 2. Java 11
 3. Selenium Webdriver 4.11.0
 4. TestNG 6.14.3
 5. Maven 3.8.1
 6. Log4j
```

## System Requirements
```
 1. Emulator - Android version 13.0
 2. Mac OSX or Windows or Linux
 3. App TheScore - path under Project repo\apps\thescore.apk
```

## Pre Requisite:
```
Framework expects following things before execution:
 1. Emulator device is correctly configured
 2. Appium Server should be installed and up-running while executing tests
 3. Java should be installed
 4. Maven should be installed
```

## Executing Tests
```
 1. Open up Emulator device
 2. Start Appium server with following configurations:
    -  Host : 127.0.0.1
    -  Port : 4723
    -  Click Start Server button
 3. Navigate to project's root directory and execute following command inside terminal:

    -  mvn test -Dsurefire.suiteXmlFiles=smoke-testng.xml
```

## Workflow:

	#Test 1 : Test to validate the home screen and navigation to Leagues screen
		Pre-Condition : The mobile app is installed and launched
           
			step 1 Verify welcome landing screen is displayed
			step 2 Click on Login button
			**Expected Result:** Verify Login screen is displayed
			step 3 Enter valid user details and click on login
			**Expected Result:** Verify user lands on Scores screen
			step 4 Click on League tab
			**Expected Result:** verify League screen is displayed with edit and done buttons
			
		Post-conditions : User has successfully navigated from the home screen to the Leagues screen.
	
	#Test 2 : Verify the details of selected league and ensure back navigation functions correctly
		Pre-Condition : The user is logged in and is navigated to League Screen
			
			step 1 Tap on any League say NHL
			**Expected Result:** Verify user lands on selected League screen and title of the selected League is displayed
			**Expected Result:** Verify tabs of selected League say News, Chat and Leaders
			step 2 Click on Leaders tab
			**Expected Result:** Verify that data is displayed correctly for the corresponding Leaders Tab selected
			step 3 Click back button 
			**Expected Result:** User returns you to the previous page correctly
			step 4 Repeat step 1 to 3 for MLB, NFL, NCAA Football Leagues.
			
		Post-conditions: League's details pages have expected information and Back navigation correctly from league details to the Leagues screen
