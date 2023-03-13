
## Purchase-Product-testNG

### Description
User create account in automationpractice.com. 
Login with valid and valid and invalid email and password
and also select and purchase product from the website.

### Tools and Framework
- Selenium
- TestNG
- Allure
- Chromedriver

### What I did
- SignUp on the website
- Login with valid nad invalid email and password
- Serch and purchase product


### How to run the project
#### Prerequisite
- JDK 8 or higher
- java IDE
- Configure gradle and allure home

#### Steps to run
- Clone the repo
- Give gradle clean test command in root directory
- For generating allure report write the command below

  `allure generate allure-results --clean -o allure-report`
  
  `allure serve allure-results`  

### Report
Overview
![overview](https://user-images.githubusercontent.com/108132871/187086624-9ca1278e-e94a-430d-9195-cea1cced2373.PNG)

Suites-one
![suites-one](https://user-images.githubusercontent.com/108132871/187086638-c2e63dbc-6fbe-42d4-ba10-d5a58eb6453b.PNG)

Suites-two
![suites-two](https://user-images.githubusercontent.com/108132871/187086643-ed360359-e073-4fa4-8b73-99b8be9b193f.PNG)
