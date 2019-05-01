package pageobjects;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private AndroidDriver<WebElement> driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Testing & QA\")")
    private MobileElement courseCategory;

    @AndroidFindBy(id = "com.vector.guru99:id/lblListItem")
    private List<MobileElement> coursesAccesibility;

    public HomePage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectCourse() {
        courseCategory.click();
        clickCourseByText("Mobile Testing");
    }

    private void clickCourseByText(String text) {
        for(MobileElement element : coursesAccesibility) {
            if (!coursesAccesibility.isEmpty() && element.getText().equals(text)) {
                element.click();
                return;
            }
        }
        throw new NotFoundException("Course not found");
    }

}
