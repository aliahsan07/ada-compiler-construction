class Printlist extends ExampleToken implements Token{
    
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
        return expr.toString() + ", " + printlist.toString(t);
    }
}