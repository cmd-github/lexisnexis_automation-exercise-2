# LexisNexis Job Search Automation

This project automates job search testing on the LexisNexis Risk website using Java, Selenium, Cucumber, and Serenity BDD, with optional TestNG reporting. It verifies search results for "automation tester" (expecting results) and "notarealcareer" (expecting no results).

## Prerequisites
- **Java**: JDK 11 or higher (tested with JDK 21).
- **Maven**: Version 3.6.0 or higher.
- **Chrome Browser**: Latest version installed (or configure `serenity.properties` for another browser like Firefox).
- **Git**: To clone the repository.

## Setup
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/lexisnexis-test.git
   cd lexisnexis-test
Replace yourusername with your GitHub username after creating the repository.

2. **Install Dependencies:** Run the following command to download all Maven dependencies:

mvn clean install

## Running the Tests
Run the tests and generate reports with:
mvn clean verify

**What it does:**
clean: Removes old build artifacts.
verify: Runs tests via Serenity (JUnit) and generates the Serenity report.


## Checking the Output (Reports)
After running mvn clean verify, reports are generated in the following locations:

**Serenity Report:**
Location: target/site/serenity/index.html
Open in a browser to view detailed test results, including steps and screenshots.

**Console Output:** Check the terminal for real-time logs (e.g., "Jobs Found = X").

## Project Structure
src/test/resources/features/job_search.feature: Cucumber feature file with test scenarios.
src/test/java/stepDefinitions/: Step definitions and test runners (JobSearchSteps.java, RunCucumberTest.java, RunCucumberTestNG.java).
src/main/java/pages/: Page objects (HomePage.java, CareersPage.java).
src/main/java/utils/: Utility classes (e.g., DriverManager.java).
pom.xml: Maven configuration file.
serenity.properties: Serenity configuration (e.g., browser settings).

## Test Scenarios
- Search for "automation tester": Expects at least one job listing (passes if jobs exist, fails if none).
- Search for "notarealcareer": Expects no job listings (passes if none found, fails if any).
- Search for "exampleoffailure": Expects some job listings but won't find any so will list the test as failing.

## Troubleshooting
**ChromeDriver Issues:** Ensure Chrome is installed and matches the version managed by WebDriverManager. Update webdrivermanager if needed (mvn dependency:tree to check).

**Serenity Report Missing:** Use mvn verify (not just mvn test) to trigger the serenity-maven-plugin.

## Customization
**Change Browser:** Edit serenity.properties (e.g., webdriver.driver=firefox) and ensure the browser is installed.
**Modify Search Terms:** Update the Examples table in job_search.feature to test different terms.


## Running on Any OS
- This project uses WebDriverManager to handle browser drivers across Windows, macOS, and Linux.
- No OS-specific configurations are required as long as Java, Maven, and Chrome are installed.