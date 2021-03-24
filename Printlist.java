class Printlist extends ExampleToken implements Token{
    
    Expr expr;

    public Printlist(Expr expr){
        this.expr = expr;
    }

    public String toString(int t){
        return expr.toString(t);
    }
}