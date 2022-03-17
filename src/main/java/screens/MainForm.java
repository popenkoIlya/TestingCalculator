package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class MainForm extends Screen {

    public static class Function {

        public static final String plus = "_add";
        public static final String minus = "_sub";
        public static final String equal = "_equal";
        public static final String multi = "_multi";
        public static final String divide = "_divide";
        public static final String clear = "_clear";
        public static final String changeSign = "_para2";
        public static final String dot = "_dot";
        public static final String mod = "_para1";
    }

    private String numberLocatorTemplate = "com.example.new_sample:id/button%s";
    private IButton numberButton;
    private ITextBox inputTextBox =
            AqualityServices.getElementFactory().getTextBox(By.id("com.example.new_sample:id/input"),"inputTextBox");
    private ILabel outputTextBox =
            AqualityServices.getElementFactory().getLabel(By.id("com.example.new_sample:id/output"),"inputTextBox");

    public MainForm() {
        super(By.id("com.example.new_sample:id/action_bar_root"), "MainScreen");
    }

    public void clickOnArithmeticButton(String text){
        numberButton =
                AqualityServices.getElementFactory().getButton(By.id(String.format(numberLocatorTemplate, text)),"NumberButton");
        numberButton.click();
    }

    public void inputNumber(String num){
        inputTextBox.clearAndType(num);
    }

    public String getAnswer(){
        return outputTextBox.getText();
    }
}
