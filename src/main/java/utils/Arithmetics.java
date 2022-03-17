package utils;

import screens.MainForm;

public class Arithmetics {
    private static MainForm mainForm;
    public static void dialNumber(String number){
        mainForm  = new MainForm();
        int start = 0;
        if (number.charAt(0) == '-'){
            start = 1;
        }
        for (int i = start; i<number.length(); i++){
            if (number.charAt(i)=='.'){
                mainForm.clickOnArithmeticButton(MainForm.Function.dot);
            }else {
                mainForm.clickOnArithmeticButton(String.valueOf(number.charAt(i)));
            }
        }
        if (start == 1){
            mainForm.clickOnArithmeticButton(MainForm.Function.changeSign);
        }
    }
}
