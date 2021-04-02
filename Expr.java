class Expr implements Token {


    Name name;
    int intlit;
    float floatlit;
    String charOrStr;
    int cond;
    String fnName;
    Args args;
    boolean boolVal;
    Expr singleExpr;
    Expr multipleExpr[];
    String prefixOperator;
    String cast;
    BinaryOp binaryOp;

    public Expr(Name name){
        this.name = name;
        cond = 1;
    }

    public Expr(String fnName, Args args){
        if (args == null){
            cond = 2;
        }else{
            cond = 3;
        }
        this.fnName = fnName;
        this.args = args;
    }

    public Expr(int intlit){
        this.intlit = intlit;
        cond = 4;
    }

    public Expr(float floatlit){
        this.floatlit = floatlit;
        cond = 7;
    }

    public Expr(String str, String kind){
        switch (kind) {
            case "char":
                cond = 5;
                this.charOrStr = str;
                break;
        
            case "str":
            default:
                cond = 6;
                this.charOrStr = str;
                break;
        }
    }

    public Expr(boolean bool){
        this.boolVal = bool;
        cond = 8; // cond 8,9
    }

    public Expr(Expr e, String kind){

        switch (kind) {
            case "PAREN":
                singleExpr = e;
                cond = 9;
                break;
            case "~":
            case "-":
            case "+":
                this.prefixOperator = kind;
                singleExpr = e;
                cond = 10; 
            default:
                break;
        }

    }

    public Expr(String type, Expr e){
        this.cast = type;
        singleExpr = e;
        cond = 11;
    }

    public Expr(BinaryOp binaryOp){
        this.binaryOp = binaryOp;
        cond = 12;
    }



    public Expr(Expr e1, Expr e2, Expr e3){
        this.multipleExpr = new Expr[]{e1, e2, e3};
        cond = 13;
    }

    public String toString(int t)
    {

        switch (cond) {
            case 1:
                return name.toString(t);
            case 2:
                return fnName + "()";
            case 3:
                return fnName + "(" + args.toString(t) + ")";
            case 4:
                return "" + intlit;
            case 5:
            case 6:
                return charOrStr;
            case 7:
                return "" + floatlit;
            case 8:
                return boolVal ? "true" : "false";
            case 9:
                return "(" + singleExpr.toString(t) + ")";
            case 10:
                return "(" + prefixOperator + " " + singleExpr.toString(t) + ")";
            case 11:
                return "(" + cast + ")" + singleExpr.toString(t);
            case 12:
                return binaryOp.toString(t);
            case 13:
                return "(" + multipleExpr[0].toString(t) + " ? " + multipleExpr[1].toString(t) + " : " + multipleExpr[2].toString(t) + ")";
            default:
                return "";
        }
    }


}