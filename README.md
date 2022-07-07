======= Cucumber + Java + TestNG + VSCode + Maven =======


	Maven Dependencies 
	    i. Cucumber-Java
	   ii. Cucumber-TestNG
	  iii. Surefire Plugin 

	Plugins
		i. Gherkin
	   ii. Cucumber for Java
	  iii. TestNG
	   iv. Java for VSCode
	    v. Maven

	Follow Project Structure 

		+---.idea
		+---main
		|   +---java
		|   +---resources
		\---test
		|   +---java
		|   |   \---stepdefs
		|   |   |   |---ServiceHooks.java
		|   |   |   |---StepDefinitions.java
		|   |   |---TestRunner.java
		|   \---resources
		|       \---features
		|           |---LoginProfile.feature
		|           |---UpdateProfile.feature
		|---pom.xml
		|---testng.xml

	Cucumber Concepts

		i. Gherkin
	   ii. Feature Files and Scenarios
	  iii. Runner class
	   iv. Java class for a respective Feature file
	    v. Execution via cmdline 
	   vi. Data Driven Testing (DataTables, Excel)  
	  vii. Hooks  
	 viii. Tags 
	   ix. Reporting 
	    x. POM
	   xi. Page Factory
	  xii. Parallel Testing 

	* Reading Data from various source files like JSON, XML, Excel with Cucumber


	GHERKIN 

		- A set of keywords used to structure to an executable specification
		- Unambigous executable specification
		- Automated tests via Cucumber
		- Used to document the system behaviour

	  # = Comments 

	FEATURE FILE 

		- A file which is used to store features, scenarios to be tested. 

	  Feature 
		- High level description of the Test scenario

	  Scenario 
	  	- Steps followed for a test case and expected behaviour

	  Scenario Outline
	  	- Used to execute a scenario multiple times with multiple test data for a test case. 

	  Background 
	  	- Used to combine common steps of all scenarios into one.

	  	Why? 
		 	Readability
		 	Maintanability
		 	Avoiding repeatition
		 	Common steps to be visible to BA 

	  Steps 
	  	- It starts with Given, When, Then, And/But. 
	  	- Executes one at a time and searches for matching step defination during the execution.

	  	Given 
	  		- Used for the Initial context of the scenario. 
	  		- Creation/Configuration setup is done (in general)
	  	When 
	  		- Used while performing an action
	  	Then
	  		- Used to check/describe the expected behaviour of the system
	  	And/But
	  		- Used when user has multiple Given/When/Then

	STEP DEFINATION

		- Java method which is used to link Gherkin steps. 
		- Using the GLUE code under CucumberOptions, Cucumber is able to match respective step defination to the given Gherkin Steps.
		- If there's NO matching stepdefination, Cucumber throws an error stating so and so steps are undefined.

	TEST RUNNER CLASS

		- A Java class which is used to execute the Feature file.
		- created under src/test/java
		- Can be used JUnit/TestNG Test runner.

	REPORTS 

		Local Reports
			- Can be generated in HTML/XML/JSON/TXT
			- User need to add below snippets in Test Runner class to @CucumberOptions -> plugin = { }
			
				Html = html:path
				Json = json:path/report.json
				Xml  = junit:path/report.xml 

		Cucumber Report Services	
			- Add cucumber-jvm dependency
			- cucumber.publish.enabled=true add this property in cucumber.properties (file must be under src/test/resources)

		Maven cucumber Reporting 
			- Add respective dependency
			- https://stackoverflow.com/questions/51257224/maven-cucumber-reporting-plugin-is-not-generating-the-report-nothing-happens

	DATA DRIVEN TESTING 

		Scenario Outline and Examples 
			- Used to execute same tests with different set of test data using Examples keyword.

			For Example : 
				Scenario Outline: Login with invalid credentials
	 
				    Given User is on Home page
				    When User enters username as "<username>" and password as "<password>"
				    Then User should be able to see an "<errorMessage>"
				 
				    Examples:
				      | username   | password | errorMessage             |
				      | Admin1     | admin1   | Invalid credentials      |
				      |            | admin123 | Username cannot be empty |
				      | Admin      |          | Password cannot be empty |

			- Table MUST have header row same as the variable in Scenario Outline. Arguments are separated by '|'

	DATATABLES

		- Used to add set of parameters in Step Defination (Tabular format) rather than putting it in Gherkin. (List of Maps or Map of Lists)

				List<List<String>> table
				List<Map<String, String>> table
				Map<String, String> table
				Map<String, List<String>> table
				Map<String, Map<String, String>> table 

		- Here, no Keywords are used. Works for the step where it is defined

		- https://priyank-it.medium.com/cucumber-data-table-access-usage-95a0bc75011f


	HOOKS 
		- Blocks of code used to execute at various places of the execution.
		- Used to do pre-requisite steps or post execution.

			Scenario Hooks 		= @Before @After         = Executes before/after the First/Last step of a scenario.
			Step Hooks	   		= @BeforeStep @AfterStep = Executes before/after a step
			Conditional Hooks   = @Before('tagname') @After('tagname') = Used to execute selected steps w.r.t the tags mentioned in the scenario. Also referred as Tagged Hooks

	TAGS 

		Used to organize Features and Scenarios = @TagName
		- can have multiple tags or single tags
		- can have combination of tags using AND OR 
		- can skip scenarios having a specific tag

		Can be placed above Feature, Scenario Outline ot Scenario

	EXECUTION via CMD

		- If MAVEN = mvn test
		- Using Tags = mvn test -Dcucumber.filter.tags="@tagname"
		- Exe a Feature file = mvn test -Dcucumber.options="/path/of/feature/file"
		- To create a Report = mvn test -Dcucumber.options=="--plugin junit:target/cucumber-reports/cucumberReport.xml"
		- Combining Parameters = mvn test -Dcucumber.options="pathOfFeatureFile.feature" -Dcucumber.filter.tags="@InValidCredentials"
		- Exe a Feature/Scenario = mvn test -Dcucumber.options="pathOfFeatureFile.feature" 

	PARALLEL TESTING

	  Via Maven 

	  		<configuration>
		        <parallel>methods</parallel>
    		</configuration>

      Via TestNG DataProvider 

      		Add below snippet in the Runner class 
      		@DataProvider(parallel = true)
