class Args implements Token{

    Expr expr;
    Args args;


    public Args(Expr expr, Args args){
        this.expr = expr;
        this.args = args;
    }

    public Args(){
        this.expr = null;
        this.args = null;
    }

    public Args(Expr expr){
        this.expr = expr;
        this.args = null;
    }

    public String toString(int t){
        if (args == null && expr == null)
            return "";
        return expr.toString(t) + (args == null ? "" : (", " + args.toString(t)));
    }

}