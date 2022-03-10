import aquality.appium.mobile.application.AqualityServices;
import org.junit.Before;

public class BaseTests {
    @Before
    public void setUp() {
        AqualityServices.getApplication();
    }
}
