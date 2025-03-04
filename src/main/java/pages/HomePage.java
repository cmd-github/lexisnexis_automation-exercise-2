package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class HomePage extends BasePage {

    @FindBy(xpath = "//li[contains(@class, 'score-megamenu-dropdown')]//a[@data-toggle='dropdown' and contains(text(),'About Us')]")
    private WebElement aboutUsMenu;

    @FindBy(xpath = "//div[contains(@class, 'caption')][h4[text()='Careers']]")
    private WebElement careersSection;

    @FindBy(id = "onetrust-accept-btn-handler") // Cookie consent button
    private WebElement acceptCookiesButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        try {
            click(acceptCookiesButton);
        } catch (Exception e) {
            System.out.println("No cookie popup detected.");
        }
    }

    public void navigateToCareers() {
        click(aboutUsMenu);
        click(careersSection);
        BrowserUtils.switchToNewTab(driver);
    }
}
