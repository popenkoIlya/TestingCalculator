import aquality.appium.mobile.application.AqualityServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import screens.MainForm;
import utils.Arithmetics;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatingTests{
    MainForm mainForm = new MainForm();

    @BeforeEach
    void BeforeTest(){
        AqualityServices.getApplication();
    }

    @AfterEach
    void AfterTest(){
        AqualityServices.getApplication().quit();
    }

    @ParameterizedTest
    @MethodSource("BinaryProvider")
    void plusTest(String first, String second) {
        Arithmetics.dialNumber(first);
        mainForm.clickOnArithmeticButton(MainForm.Function.plus);
        Arithmetics.dialNumber(second);
        mainForm.clickOnArithmeticButton(MainForm.Function.equal);
        Assertions.assertEquals(Double.parseDouble(first)+Double.parseDouble(second), Double.parseDouble(mainForm.getAnswer()));
    }

    @ParameterizedTest
    @MethodSource("BinaryProvider")
    void minusTest(String first, String second) {
        Arithmetics.dialNumber(first);
        mainForm.clickOnArithmeticButton(MainForm.Function.minus);
        Arithmetics.dialNumber(second);
        mainForm.clickOnArithmeticButton(MainForm.Function.equal);
        Assertions.assertEquals(Double.parseDouble(first)-Double.parseDouble(second),Double.parseDouble(mainForm.getAnswer()));
    }

    @ParameterizedTest
    @MethodSource("BinaryProvider")
    void multiplyTest(String first, String second) {
        Arithmetics.dialNumber(first);
        mainForm.clickOnArithmeticButton(MainForm.Function.multi);
        Arithmetics.dialNumber(second);
        mainForm.clickOnArithmeticButton(MainForm.Function.equal);
        Assertions.assertEquals(Double.parseDouble(first)*Double.parseDouble(second), Double.parseDouble(mainForm.getAnswer()));
    }

    @ParameterizedTest
    @MethodSource("BinaryProvider")
    void divideTest(String first, String second) {
        Arithmetics.dialNumber(first);
        mainForm.clickOnArithmeticButton(MainForm.Function.divide);
        Arithmetics.dialNumber(second);
        mainForm.clickOnArithmeticButton(MainForm.Function.equal);
        Assertions.assertEquals(Double.parseDouble(first)/Double.parseDouble(second), Double.parseDouble(mainForm.getAnswer()));
    }

    @ParameterizedTest
    @MethodSource("BinaryProvider")
    void modTest(String first, String second) {
        Arithmetics.dialNumber(first);
        mainForm.clickOnArithmeticButton(MainForm.Function.mod);
        Arithmetics.dialNumber(second);
        mainForm.clickOnArithmeticButton(MainForm.Function.equal);
        Assertions.assertEquals(Double.parseDouble(first)%Double.parseDouble(second), Double.parseDouble(mainForm.getAnswer()));
    }

    @ParameterizedTest
    @MethodSource("UnaryProvider")
    void changeSignTest(String num) {
        Arithmetics.dialNumber(num);
        mainForm.clickOnArithmeticButton(MainForm.Function.changeSign);
        Assertions.assertEquals(-Double.parseDouble(num), Double.parseDouble(mainForm.getAnswer()));
    }


    static Stream<Arguments> BinaryProvider() {
        return Stream.of(
                arguments( "1", "2"),
                arguments( "-2", "5"),
                arguments("89", "11"),
                arguments("7.6", "3.5")
        );
    }
    static Stream<Arguments> UnaryProvider() {
        return Stream.of(
                arguments( "1"),
                arguments( "-2"),
                arguments("0.1"),
                arguments("-0.3")
        );
    }
}
