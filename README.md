# QC Technical Task by Ahmed Agamy

## Task 1
Detailed test plan for LinkedIn 
> Check [TestPlan.pdf](/Task1&2/Test Plan for LinkedIn.pdf) 

## Task 2
Reported bigs for LinkedIn mobile APP
> Check [LinkedInBugs.pdf](/Task1&2/TestCaes and Bugs of LinkedIn.xlsx) 

## Task 3
Automated Tests for Facebook login and Registration

### The main Frameworks and tools included in the project:
* Selenium Webdriver
* TestNG
* Extent Reports
* Maven
* Java

### Project design and features:
* Page Object Model (POM) design pattern: For increasing maintainability and reusability of the project.
![image](/Task3&4/POM.png)
* Data-Driven framework: All test data are in external JSON files.
* Reporting: An execution report is generated at the end of each execution.
![image](/Task3&4/report.png)
* Utilities: The utility package includes utility classes and many wrapper methods.

#### Setup
* Make sure you run the Best buy project locally 
```bash
git clone https://github.com/bestbuy/api-playground/
cd api-playground
npm install
npm start
# Best Buy API Playground started at http://localhost:3030
```
* Import or clone the maven project on any java IDE (Eclipse or IntelliJ for example)

#### Execution
* Can execute each class separately
* Or find the test suite XML file in the testng.xml* file and then click "Run As" > "TestNG Suite"
* Or you can use this command in the directory of the project ```mvn clean test```
![Alt Text](/Task3&4/uiAuto.gif)

## Task 4
Automated Tests for Facebook login and Registration

### The main Frameworks and tools included in the project:
* RestAssured
* TestNG
* Extent Reports
* Maven
* Java

### Project design and features:
* Object Model (OM) design pattern: For increasing maintainability and reusability of the project.
![image](/Task3&4/POM.png)
* Data-Driven framework: All test data are in external JSON files.
* Reporting: An execution report is generated at the end of each execution.
![image](/Task3&4/report.png)
* Utilities: The utility package includes utility classes and many wrapper methods.

### Setup
* Import or clone the maven project on any java IDE (Eclipse or IntelliJ for example)

### Execution
* Can execute each class separately
* Or find the test suite XML file in the testng.xml* file and then click "Run As" > "TestNG Suite"
* Or you can use this command in the directory of the project ```mvn clean test```

### Covered API Tests
#### Products Endpoint
* Create a product and verify it's created
* Update a product and verify it's updated
* Delete a created product and verify it's deleted
* Read product by ID and verify it's correct
* Read list of all products
#### Stores Endpoint
* Create a store and verify it's created
* Update a store and verify it's updated
* Delete a created store and verify it's deleted
* Read store by ID and verify it's correct
* Read list of all stores
#### Services Endpoint
* Create a service and verify it's created
* Update service and verify it's updated
* Delete a created service and verify it's deleted
* Read service by ID and verify it's correct
* Read list of all Services 

#### Categories Endpoint
* Create a category and verify it's created
* Update a category and verify it's updated
* Delete a created category and verify it's deleted
* Read category by ID and verify it's correct
* Read list of all categories
#### Utilities Endpoint
* Check the version
* check the healthcheck









