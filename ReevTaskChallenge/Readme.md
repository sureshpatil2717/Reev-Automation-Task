## Reev Task Automation  framework is a BDD framework which Uses

1. Selenium
2. Maven
3. Cucumber BDD (Gherkin language) via Junit ,
4. using Cucumber 6 HTML report for generating PDF & Spark reports
5. Using junit for assertions
6. Reading from Properties files for storing environment variables

## Structure of Project:
1. `src/test/java`
- 'pages':Page wise object with page object model with page factory
- 'runners':Package include the test runner that run the step definitions along with the designated feature file
- 'stepDefinations.Hooks':Conatins Hooks
-  'stepDefinitions.UIStepDefinations':Package includes steps class that has the implementations of the feature files
- 'utilities' : Package includes a class of methods to read the config properties and Util functions


2. `src/test/resource`
- `Feature`: Package includes the feature file
- `config.properties`: that contains the environment variables ( URL to run against & Testdata)
- `cucumber.properties`: file includes the properties of the display of the cucumber report over the browser

## Running the project
1. Run REEV app to lauch application
2. Download the project on your local machine
3. Import the project to your editor(Eg: Eclipse)
4. Right Click on the project, choose Maven and Click on Update Project
5. After the Update Project is completed go to the RunnerUI.JAVA under Runner Package
6. Right click on the RunnerUI.java and Run As JUnit Test

## Generating The Test Reports
(open test output folder) and you will get a generated pdf report contains all the details of the execution (pass/fail)