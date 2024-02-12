import java.util.ArrayList;

public enum ArithmeticOperator {
    PLUS("+"),
    MINUS("-"),
    DIVIDED("/"),
    TIMES("*");

    private String string;

    ArithmeticOperator(String string){
        this.string = string;
    }

    public String getArithmeticOperator(){
        return string;
    }


    public static boolean checkArithmeticOperator(String string){
        boolean ckeck = false;

        for (ArithmeticOperator itArithmeticOp:ArithmeticOperator.values()) {
            if(itArithmeticOp.getArithmeticOperator().equals(string)){
                ckeck = true;

            }
        }
        return ckeck;
    }
    public static boolean checkArithmeticOperator(ArrayList<String> list) throws Exception {
        boolean ckeck = false;
        int i = 0;

        for (String itList:list) {
            for (ArithmeticOperator itArithmeticOp:ArithmeticOperator.values()) {
                if (i <= 1)
                {
                    if(itArithmeticOp.getArithmeticOperator().equals(itList)){
                    ckeck = true;
                    i++;
                    }
                } else throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
        if (i == 0) throw new Exception("т.к. строка не является математической операцией");
        return ckeck;
    }
}
