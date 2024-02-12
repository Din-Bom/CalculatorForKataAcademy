import java.util.ArrayList;

enum RomanNumbers {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);
    private int i;
    RomanNumbers(int i) {
        this.i = i;
    }
    public int getRomanNumber(){
        return i;
    }

    public static boolean checkRomanNumbers (ArrayList <String> list) throws IllegalArgumentException{
        boolean check = false;

        try {
            for (String itString: list) {
                if (!ArithmeticOperator.checkArithmeticOperator(itString)){
                    RomanNumbers.valueOf(itString);
                    check = true;
                }
            }
        } catch (IllegalArgumentException e){
            check = false;
        }
        return check;
    }

    public static boolean checkRomanNumbers (String string){
        boolean check = false;

        try {
            for (char itChar:string.toCharArray()) {
                RomanNumbers.valueOf(String.valueOf(itChar));
                check = true;
            }
        } catch (IllegalArgumentException e){
            check = false;
        }
    return check;
    }

    public static int romanToInt(String string) {
        int results = 0;

        for (int i = string.length() - 1; i >= 0; i--){
            RomanNumbers romanNumbers = RomanNumbers.valueOf(String.valueOf(string.charAt(i)));
            switch (romanNumbers){
                case I: results += I.getRomanNumber();
                    break;
                case V: if (i - 1 >= 0 && string.substring(i - 1) == I.toString()) {
                    results += 4;
                    i--;
                } else results += V.getRomanNumber();
                    break;
                case X: if (i - 1 >= 0 && string.substring(i - 1) == I.toString()) {
                    results += 9;
                    i--;
                } else results += X.getRomanNumber();
                    break;
                case L: if (i - 1 >= 0 && string.substring(i - 1) == X.toString()) {
                    results += 40;
                    i--;
                } else results += L.getRomanNumber();
                    break;
                case C: if (i - 1 >= 0 && string.substring(i - 1) == X.toString()) {
                    results += 90;
                    i--;
                } else results += C.getRomanNumber();
                    break;
                case D: if (i - 1 >= 0 && string.substring(i - 1) == C.toString()) {
                    results += 400;
                    i--;
                } else results += D.getRomanNumber();
                    break;
                case M: if (i - 1 >= 0 && string.substring(i - 1) == C.toString()) {
                    results += 900;
                    i--;
                } else results += M.getRomanNumber();
                    break;
            }
        }
        return results;
    }

    public static String intToRoman(int input) throws Exception {
        String s = "";

        if (input < 1 || input > 3999)
            throw new Exception("т.к. введенные числа не соответствуют условию \"Результатом работы калькулятора с римскими числами могут быть только положительные числа\"");

        while (input >= 1000) {
            s += "M";
            input -= 1000;        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }

    public static boolean checkConditionsRoman(int romanToInt){
        boolean check = false;

        if(romanToInt <= 10 && romanToInt > 0){
            check = true;
        }
    return check;
    }
}
