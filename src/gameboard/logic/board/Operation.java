package gameboard.logic.board;

public enum Operation {
    ADD("+"),SUB("-"),DIV("÷"),MOD("%"),EXP("^"),MUL("x");

    private final String symbol;


    Operation(String symbol){
        this.symbol = symbol;
    }


    public String getSymbol() {
        return symbol;
    }
}
