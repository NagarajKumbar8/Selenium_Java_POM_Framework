**Selenium Java POM Framework**
A Maven‑based Selenium automation framework built using the Page Object Model (POM) design pattern, TestNG, and Java. This framework enables clean separation of test logic and UI page interactions.

🧠 **Key Features**
Page Object Model (POM): Clear structure separating locators, page actions, and tests.
Selenium WebDriver with Java

TestNG as the testing framework

Maven-based project structure

External test data support (JSON, Excel, etc.)

Parallel test execution

Logging & Reporting (e.g., TestNG reports or ExtentReports)

Designed for easy enhancement and scalability


R**un the tests**
Run all tests (default):

bash
Copy
Edit
mvn clean test
To specify browser or run specific suite:

bash
Copy
Edit
mvn test -Dbrowser=firefox
Use profiles if configured in your pom.xml, for example:

bash
Copy
Edit
mvn test -P smoke

🧪 **TestNG Suite Configuration**
The main suite file is located at src/test/resources/testng.xml and includes your test classes for execution.

Example:

xml
Copy
Edit
<suite parallel="tests" thread-count="3" name="Suite">
  <test name="SmokeTests">
    <classes>
      <class name="Basic.Basics"/>
      <class name="Basic.Api_Test_with_Json_file"/>
    </classes>
  </test>
</suite>
Ensure your test classes and packages align correctly with entries in testng.xml.

📄 **Handling Test Data**
Test data is stored outside the code—e.g., in JSON files such as:

bash
Copy
Edit
src/test/resources/test_data.json
You can parse it using Jackson ObjectMapper and map the content via TypeReference<List<HashMap<String, String>>>.

🧩 **Project Utilities**
Driver Factory: Centralized WebDriver instantiation (Chrome, Firefox, etc.)

Base Test Class: Handles setup (@BeforeClass) and teardown (@AfterClass) logic

Page Object Classes: Each page class encapsulates page-specific elements and actions

Utility Classes: Helpers for file operations, JSON parsing, waits, screenshots, and logging

✅ **Best Practices**
Maintain naming consistency between package names and testng.xml

Clean build frequently using mvn clean test to avoid stale artifacts

Prefer explicit key names in your JSON or DataProvider maps to avoid null lookups

Always keep dependencies updated in pom.xml, including TestNG, Selenium, Jackson, and commons‑io

