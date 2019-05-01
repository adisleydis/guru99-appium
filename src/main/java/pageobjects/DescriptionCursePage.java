package pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DescriptionCursePage {
    AndroidDriver<WebElement> driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Mobile Testing: Complete Guide to Test your Mobile Apps\")")
    private MobileElement pageTitle;

    public DescriptionCursePage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pageLoad() {
        pageTitle.isDisplayed();
    }
}
