import java.util.ArrayList;

public enum ArabicNumbers {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NIGHT(9);

    private int i;

    ArabicNumbers(int i){
        this.i = i;
    }

    public int getArabicNumbers(){
        return i;
    }

    public static boolean checkArabicNumbers (ArrayList<String> list) throws IllegalArgumentException{
        boolean check = false;

        try {
            for (String itString:list) {
                for (ArabicNumbers arabicNumbers: ArabicNumbers.values()) {
                    if (!ArithmeticOperator.checkArithmeticOperator(itString)){
                        if (arabicNumbers.getArabicNumbers() == Integer.parseInt(itString)){
                            check = true;
                        }
                    }
                }
            }
        } catch (NumberFormatException e){
            check = false;
        }
        return check;
    }
}
