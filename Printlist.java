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
        VarType type = expr.typeCheck();
        if (type.equals(VarType.Void)){
            throw new Exception("Cant apply print on variables of type void");
        }
        if (printlist != null)
            printlist.typeCheck();
        return type;
    }
}