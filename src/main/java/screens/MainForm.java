package screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class MainForm extends Screen {

    private String numberLocatorTemplate = "//Button[android:text=\"'%s'\"]";
    private IButton numberButton;
    private ITextBox inputTextBox =
            AqualityServices.getElementFactory().getTextBox(By.xpath("//TextView[@android:id='@+id/input']"),"inputTextBox");
    private ILabel outputTextBox =
            AqualityServices.getElementFactory().getLabel(By.xpath("//TextView[@android:id='@+id/output']"),"inputTextBox");

    public MainForm() {
        super(By.xpath("//androidx.constraintlayout.widget.ConstraintLayout[@tools:context='.MainActivity']"), "MainScreen");
    }

    public void clickOnArithmeticButton(String text){
        numberButton =
                AqualityServices.getElementFactory().getButton(By.xpath(String.format(numberLocatorTemplate, text)),"NumberButton");
        numberButton.click();
    }

    public void inputNumber(String num){
        inputTextBox.clearAndType(num);
    }

    public String getAnswer(){
        return outputTextBox.getText();
    }
}
