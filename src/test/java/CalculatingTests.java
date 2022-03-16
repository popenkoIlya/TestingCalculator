import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import screens.MainForm;
import utils.Arithmetics;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatingTests extends BaseTests{
    MainForm mainForm = new MainForm();

    @BeforeEach
    void BeforeTest(){
    }

    @AfterEach
    void AfterTest(){
        mainForm.clickOnArithmeticButton(MainForm.Function.clear);
    }

    @ParameterizedTest
    @MethodSource("intProvider")
    void plusTest(String first, String second, String ans) {
        Arithmetics.dialNumber(first);
        mainForm.clickOnArithmeticButton(MainForm.Function.plus);
        Arithmetics.dialNumber(second);
        mainForm.clickOnArithmeticButton(MainForm.Function.equal);
        Assert.assertEquals(ans,mainForm.getAnswer());
    }

    static Stream<Arguments> intProvider() {
        return Stream.of(
                arguments( "1", "2", "3"),
                arguments( "-2", "5", "3"),
                arguments("89", "11", "100")
        );
    }
}
