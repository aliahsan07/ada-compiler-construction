class BinaryOp implements Token{
    Expr lhs;
    Expr rhs;
    String operator;

    public BinaryOp(Expr l, Expr r, String op){
        this.lhs = l;
        this.rhs = r;
        this.operator = op;
    }

    public String toString(t){
        return "(" + lhs.toString(t) + " " + operator + " " + rhs.toString(t) + ")";
    }

}