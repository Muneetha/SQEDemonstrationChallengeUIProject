## Demo Challenge

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: sqedemonstrationchallenge@nbcuni.com


#### Expectations
We will be evaluating
1. Naming conventions
2. Code readability
3. Code encapsulation
4. Code structure and organization
5. Quality of test cases
6. Variety  of testing types (examples: boundary, happy path, negative, etc) 


#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/


#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

 Happy Path Test Cases:
1. User able to complete the order with valid details for all the fields using "Credit Card" as Payment information.
2. User able to complete the order with valid details for all the fields using "Cash on Pickup" as Payment information.
3. User not able to complete the order with valid details for all the fields and missing Name/Email as "Cash on Pickup"/"Credit Card" as Payment information.

Negative Tests
1. User able to complete the order with invalid details for all the fields using "Credit Card" as Payment information.
2. User able to complete the order with invalid details for all the fields using "Cash on Pickup" as Payment information.


Field Validations
1. Quantity is allowing from 0-99999 only
2. Name/Email/Phone text fields are allowing max of 100 characters only.
3. Error message is displayed for missing Name while ordering.
4. Error message is displayed for missing Phone while ordering.
5. User able to clear the quantity field without any default number.
6. Success Message is not displayed properly.  


Bugs:
1. User able to select toppings1 and topings2 though Pizza 1 is selected as no toppings.
2. User able to select toppings1 and topings2 though Pizza 1 is selected as only 1 topping.
3. User able to select same topping for both Topings1 and Topings2 dropdowns.(In my openion, user should not be able to pick but Not sure if this is a bug as expected as per the BRD).
4. Quantity text box is accepting Alpha Numerics, special characters and floating point numbers. Need to restrict to whole numbers.
5. when User enters invalid text in Quantity, Cost field is showing as NaN. Is this a functional requirement? if pointer 5 is acceptable for everything.
6. User able to enter Alpha Numerics, special characters for name text field.
7. User able to enter Alpha Numerics, special characters for email text field. NO email format validation.
8.User able to enter Alpha Numerics, special characters for Phone text field.
9. User able to select both "Credit Card" and "Cash on Pickup" radio buttons.
10. No payment section is displayed on selecting "Credit Card" radio button.
11. User able to complete the order without selecting toppings when Pizza1 is selected as 2 toppings.
12. User able to complete the order by providing zero to Quantity text field.
13. Toppings1 and Toppings2 fields are not set to defaults on selecting Reset button to clear everything.
14. User able to complete the order without selecting the topings on selecting Pizza1 as 2 toppings.


 

