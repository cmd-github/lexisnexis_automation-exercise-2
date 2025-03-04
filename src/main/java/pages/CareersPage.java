package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CareersPage extends BasePage {

    @FindBy(css = "a.score-button.btn-red[href*='about-us/careers/jobs']")
    private WebElement searchJobsButton;

    @FindBy(css = "input.search-box-input")
    private WebElement searchBox;

    @FindBy(css = "button#search-box-button")
    private WebElement searchButton;

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void clickSearchJobs() {
        click(searchJobsButton);
    }

    public void searchForJob(String jobTitle) {
        type(searchBox, jobTitle);
        searchButton.click();
    }

    public int getJobListCount() {
        try {
            Thread.sleep(2000);
            List<WebElement> jobList = wait
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".ais-hits--item")));
            return jobList.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isJobListDisplayed() {
        try {
            // Ensure job listings appear dynamically
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".ais-hits--item")));
            System.out.println("Jobs Found = " + getJobListCount());
            if (getJobListCount() >= 1) {
                return true;
            } else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
}
