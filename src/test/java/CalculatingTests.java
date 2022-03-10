import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import screens.MainForm;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatingTests extends BaseTests{
    MainForm mainForm = new MainForm();

    @ParameterizedTest
    @MethodSource("intProvider")
    void plusTest(String first, String second, String ans) {
        mainForm.clickOnArithmeticButton(first);
        mainForm.clickOnArithmeticButton("+");
        mainForm.clickOnArithmeticButton(second);
        Assert.assertEquals(ans,mainForm.getAnswer());
    }

    static Stream<Arguments> intProvider() {
        return Stream.of(
                arguments( "1", "2", "3"),
                arguments( "-2", "5", "3"),
                arguments("-1", "-2", "-3")
        );
    }
}
