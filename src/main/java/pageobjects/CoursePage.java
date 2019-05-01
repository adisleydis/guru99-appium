package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CoursePage {
    private AndroidDriver<WebElement> driver;

    @AndroidFindBy(className = "android.widget.LinearLayout")
    List<MobileElement> lessons;

    @AndroidFindBy (id = "com.vector.guru99:id/next")
    MobileElement nextOption;

    public CoursePage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectFirstLesson() {
        if(!lessons.isEmpty()) {
           new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(lessons.get(0)));
            lessons.get(0).click();
            return;
        }
        throw new NotFoundException("Lesson's list is empty");
    }

    public void nextCoursePage() {
        nextOption.click();
    }


}
