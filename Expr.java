class Expr extends SuperToken implements Token {


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
        if ("char".equals(kind)) {
            cond = 5;
            this.charOrStr = str;
        } else {
            cond = 6;
            this.charOrStr = str;
        }
    }

    public Expr(boolean bool){
        this.boolVal = bool;
        cond = 8; // cond 8,9
    }

    public Expr(Expr e, String kind){

        if ("PAREN".equals(kind)) {
            singleExpr = e;
            cond = 9;
        } else if ("~".equals(kind) || "-".equals(kind) || "+".equals(kind)) {
            this.prefixOperator = kind;
            singleExpr = e;
            cond = 10;
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

    public VarType typeCheck() throws Exception {
        SymbolTable.VarData fn;
        VarType exprType;


        switch (cond){
            case 1:
                return name.typeCheck();
            case 2:
                fn = symbolTable.findVar(fnName);
                if (fn == null || !fn.isMethod) {
                    System.out.println("❌ Fatal error: No method found by the name of " + fn);
                    throw new Exception();
                }
                return fn.type;
            case 3:
                fn = symbolTable.findVar(fnName);
                if (fn == null || !fn.isMethod) {
                    System.out.println("❌ Fatal error: No method found by the name of " + fn);
                    throw new Exception();
                }
                // TODO: check if correct args are passed or not
                args.typeCheck(fnName, fn.methodArgs);
                return fn.type;
            case 4:
                return VarType.Int;
            case 5:
                return VarType.Char;
            case 6:
                return VarType.String;
            case 7:
                return VarType.Float;
            case 8:
                return VarType.Bool;
            case 9:
                return singleExpr.typeCheck();
            case 10:
                // check if unary operator is compatible with the expr that's followed.
                exprType = singleExpr.typeCheck();
                if (prefixOperator.equals("~")){
                    if (!isCoercible(VarType.Bool, exprType)){
                        System.out.println("❌ Fatal Error: " + prefixOperator + " is incompatible with variables of type " + exprType);
                        throw new Exception();
                    }
                }else {
                    if (!exprType.equals(VarType.Int) && !exprType.equals(VarType.Float)) {
                        System.out.println("❌ Fatal Error: " + prefixOperator + " is incompatible with variables of type " + exprType);
                        throw new Exception();
                    }
                }
                return exprType;
            case 11:
                // check if the type can be casted
                VarType castType = getTypeFromString(cast);
                exprType = singleExpr.typeCheck();
                boolean numericalConversion = !castType.equals(VarType.Int) && !castType.equals(VarType.Float) && !castType.equals(VarType.String);
                if (singleExpr.typeCheck().equals(VarType.Int)){
                    if (numericalConversion){
                        System.out.println("❌ Unable to cast expression of type " + exprType + " to " + castType);
                        throw new Exception();
                    }
                }else if (singleExpr.typeCheck().equals(VarType.Float)){
                    if (numericalConversion){
                        System.out.println("❌ Unable to cast expression of type " + exprType + " to " + castType);
                        throw new Exception();
                    }
                }
                return castType;
            case 12:
                return binaryOp.typeCheck();
            case 13:
                Expr conditional = multipleExpr[0];
                VarType conditionalType = conditional.typeCheck();
                VarType expr1Type = multipleExpr[1].typeCheck();
                VarType expr2Type = multipleExpr[2].typeCheck();

                if (!conditionalType.equals(VarType.Bool) && !conditionalType.equals(VarType.Int)){
                    System.out.println("❌ Fatal error: Incompatible types: " + conditionalType + " cannot be converted to Boolean");
                    throw new Exception();
                }
                if (!expr1Type.equals(expr2Type)){
                    System.out.println("❌ Fatal error: Incompatible types: expr1 type " + expr1Type + " doesn't match " + expr2Type + " type");
                    throw new Exception();
                }
                return expr1Type;
            default:
                return null;

        }
    }

}
