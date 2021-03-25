class Expr extends ExampleToken implements Token {

    Name name;
    int intlit;
    float floatlit;
    String charOrStr;
    int cond;
    String fnName;
    Args args;
    boolean boolVal;
    Expr expr[];
    String prefixOperator;
    String cast;
    BinaryOp binaryOp;

    public Expr(Name name){
        this.name = name;
        cond = 1;
    }

    public Expr(String fnName, Args args){
        if (!args){
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

    public Expr(float floatlit){
        this.floatlit = floatlit;
        cond = 7;
    }

    public Expr(boolean bool){
        this.boolVal = bool;
        cond = 8; // cond 8,9
    }

    public Expr(Expr e, String kind){
        switch (kind) {
            case "PARA":
                expr = new Expr[]{e};
                cond = 9;
                break;
            case "~":
            case "-":
            case "+":
                this.prefixOperator = kind;
                expr = new Expr[]{e};
                cond = 10; 
            default:
                break;
        }

    }

    public Expr(String type, Expr e){
        this.cast = type;
        expr = new Expr[]{e};
        cond = 11;
    }

    public Expr(BinaryOp binaryOp){
        this.binaryOp = binaryOp;
        cond = 12;
    }

    public Expr(Expr e1, Expr e2, Expr e3){
        expr = new Expr[]{e1, e2, e3};
        cond = 13;
    }

    public String toString(int t)
    {
        switch (cond) {
            case 1:
                return name.toString();
            case 2:
                return fnName + "()";
            case 3:
                String ret = "";
                for (Expr e: args){
                    ret += e.toString() + ",";
                }
                ret = ret.substring(0, ret.length() > 0 ? ret.length() - 2 : 0);
                return fnName + "(" + ret + ")";
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
                return expr[0].toString();
            case 10:
                return "(" + prefixOperator + " " + expr[0].toString() + ")";
            case 11:
                return "(" + cast + ")" + expr[0].toString();
            case 12:
                return binaryOp.toString(t);
            case 13:
                return "(" + expr[0].toString() + " ? " + expr[1].toString() + " : " + expr[2].toString() + " )";
            default:
                return "";
        }
    }


}