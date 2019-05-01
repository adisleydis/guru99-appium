import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageobjects.CoursePage;
import pageobjects.HomePage;

public class FindCourseTest extends BaseTest {

    private static AndroidDriver<WebElement> driver;
    private HomePage homePage;
    private CoursePage coursePage;

    public FindCourseTest() {
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);
    }

    @BeforeClass
    public static void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "4ec4bd62");
        capabilities.setCapability("appPackage", "com.vector.guru99");
        capabilities.setCapability("appActivity", "com.vector.guru99.BaseActivity");
        driver = new AndroidDriver(getServiceUrl(), capabilities);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void startCourse() {
        homePage.selectCourse();
        coursePage.selectFirstLesson();
        coursePage.nextCoursePage();
    }

}
