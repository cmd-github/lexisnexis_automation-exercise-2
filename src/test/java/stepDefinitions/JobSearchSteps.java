package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverManager;

public class JobSearchSteps {
    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);
    CareersPage careersPage = new CareersPage(driver);

    @Given("I open the LexisNexis website")
    public void openLexisNexis() {
        driver.get("https://risk.lexisnexis.co.uk/");
        homePage.acceptCookies();
    }

    @When("I navigate to the Careers page")
    public void navigateToCareers() {
        homePage.navigateToCareers();
    }

    @And("I search for {string}")
    public void searchForJob(String jobTitle) {
        careersPage.clickSearchJobs();
        careersPage.searchForJob(jobTitle);
    }

    @Then("I should see results matching {string}")
    public void verifyJobListings(String expectResults) {
        boolean resultsDisplayed = careersPage.isJobListDisplayed();
        if ("yes".equalsIgnoreCase(expectResults)) {
            Assert.assertTrue("Expected at least one job listing, but none were found!", resultsDisplayed);
        } else if ("no".equalsIgnoreCase(expectResults)) {
            Assert.assertFalse("Expected no job listings, but some were found!", resultsDisplayed);
        } else {
            throw new IllegalArgumentException("Invalid expectResults value: " + expectResults);
        }
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
