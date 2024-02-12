
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }
    public static String calc(String input) throws Exception {
        String results;
        ArrayList<String> list;

        list = new ArrayList<>(parseStringToArrayString(input));
        ArithmeticOperator.checkArithmeticOperator(list);
        if (!(RomanNumbers.checkRomanNumbers(list) || ArabicNumbers.checkArabicNumbers(list))){
            throw new Exception();
        }
        results = operation(splitString(list));

        return results;
    }

    private static ArrayList <String> parseStringToArrayString (String input) {
        String str;

        str = input.replaceAll("\\s","");
        str = str.replaceAll("", " ").trim();
        return new ArrayList<>(Arrays.asList(str.split(" ")));
    }

    private static ArrayList <String> splitString(ArrayList<String> list){
        for(int i = 0;i < list.size() ; ){
            if(!(i == list.size() - 1) & !ArithmeticOperator.checkArithmeticOperator(list.get(i)) && !ArithmeticOperator.checkArithmeticOperator(list.get(i+1))){
                list.set(i, (list.get(i) + list.get(i+1)));
                list.remove(i+1);
            } else i++;
        }
        return list;
    }

    private static String operation (ArrayList<String> list) throws Exception {
        String results = null;

        if(RomanNumbers.checkRomanNumbers(list.getFirst()) && RomanNumbers.checkRomanNumbers(list.getLast())){
            if(RomanNumbers.checkConditionsRoman(RomanNumbers.romanToInt(list.getFirst())) && RomanNumbers.checkConditionsRoman(RomanNumbers.romanToInt(list.getLast()))){
                results = switch (list.get(1)) {
                    case "+" -> RomanNumbers.intToRoman(RomanNumbers.romanToInt(list.getFirst()) + RomanNumbers.romanToInt(list.getLast()));
                    case "-" -> RomanNumbers.intToRoman((RomanNumbers.romanToInt(list.getFirst()) - RomanNumbers.romanToInt(list.getLast())));
                    case "/" -> RomanNumbers.intToRoman((RomanNumbers.romanToInt(list.getFirst()) / RomanNumbers.romanToInt(list.getLast())));
                    case "*" -> RomanNumbers.intToRoman((RomanNumbers.romanToInt(list.getFirst()) * RomanNumbers.romanToInt(list.getLast())));
                    default -> results;
                };
            } else throw new Exception("т.к. введенные числа не соответствуют условию \"Калькулятор должен принимать на вход числа от 1 до 10 включительно\"");
        } else {
            if ((Integer.parseInt(list.getFirst()) > 0 && Integer.parseInt(list.getFirst()) <= 10) && (Integer.parseInt(list.getLast()) > 0 && Integer.parseInt(list.getLast()) <= 10)){
            results = switch (list.get(1)) {
                case "+" -> String.valueOf(Integer.parseInt(list.getFirst()) + Integer.parseInt(list.getLast()));
                case "-" -> String.valueOf(Integer.parseInt(list.getFirst()) - Integer.parseInt(list.getLast()));
                case "/" -> String.valueOf(Integer.parseInt(list.getFirst()) / Integer.parseInt(list.getLast()));
                case "*" -> String.valueOf(Integer.parseInt(list.getFirst()) * Integer.parseInt(list.getLast()));
                default -> results;
            };} else throw new Exception("т.к. введенные числа не соответствуют условию \"Калькулятор должен принимать на вход числа от 1 до 10 включительно\"");
        }
        return results;
    }
}