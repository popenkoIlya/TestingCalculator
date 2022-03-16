import aquality.appium.mobile.application.AqualityServices;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseTests {
    @BeforeClass
    public void setUp() {
        AqualityServices.getApplication();
    }
}
