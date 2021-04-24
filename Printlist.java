class Printlist extends SuperToken implements Token{
    
    Expr expr;
    Printlist printlist;

    public Printlist(Expr expr, Printlist printlist){
        this.expr = expr;
        this.printlist = printlist;
    }

    public Printlist(Expr expr){
        this.printlist = null;
        this.expr = expr;
    }

    public String toString(int t){
        if (printlist == null)
            return expr.toString(t);
        return expr.toString(t) + ", " + printlist.toString(t);
    }

    public VarType typeCheck() throws Exception {
        VarType type;
        if (expr.cond == 12 && expr.binaryOp.operator.equals("+")) // hacky way of circumventing exception on print, fix this
        {
            type = VarType.String;
        }else {
            type = expr.typeCheck();
            if (type.equals(VarType.Void)) {
                System.out.println("❌ Cant apply print on variables of type void");
                System.exit(0);
            }
        }
        if (printlist != null)
            printlist.typeCheck();
        return type;
    }
}