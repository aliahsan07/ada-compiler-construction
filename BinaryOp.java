class BinaryOp extends SuperToken implements Token{
    Expr lhs;
    Expr rhs;
    String operator;

    public BinaryOp(Expr l, Expr r, String op){
        this.lhs = l;
        this.rhs = r;
        this.operator = op;
    }

    public String toString(int t){
        return "(" + lhs.toString(t) + " " + operator + " " + rhs.toString(t) + ")";
    }

    public VarType typeCheck() throws Exception{
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")){
            VarType lhsType = lhs.typeCheck();
            VarType rhsType = rhs.typeCheck();

            if (lhsType.equals(VarType.String) && rhsType.equals(VarType.String) && operator.equals("+")) {
                return VarType.String;
            }


            if (! lhsType.equals(VarType.Float) && !lhs.equals(VarType.Int)){
                throw new Exception("Fatal Error: Cant apply arithmetic operator on expression of type: " + lhsType + " and " + rhsType);
            }
            if (! rhsType.equals(VarType.Float) && !rhsType.equals(VarType.Int)){
                throw new Exception("Fatal Error: Cant apply arithmetic operator on expression of type: " + rhsType  + " and " + rhsType);
            }

            if (lhsType.equals(VarType.Int) && rhsType.equals(VarType.Int))
                return VarType.Int;

            return VarType.Float;
        }
        else if (operator.equals("||") || operator.equals("&&")){
            VarType lhsType = lhs.typeCheck();
            VarType rhsType = rhs.typeCheck();

            if (!lhsType.equals(VarType.Bool) && !lhsType.equals(VarType.Int)){
                throw new Exception("Fatal error: Incompatible types: " + lhsType + " cannot be converted to Boolean");
            }
            if (!rhsType.equals(VarType.Bool) && !rhsType.equals(VarType.Int)){
                throw new Exception("Fatal error: Incompatible types: " + rhsType + " cannot be converted to Boolean");
            }

            return VarType.Bool;
        }
        else{
            VarType lhsType = lhs.typeCheck();
            VarType rhsType = rhs.typeCheck();

            if (!lhsType.equals(VarType.Int) && !lhsType.equals(VarType.Float)){
                throw new Exception("Fatal error: Incompatible types: " + operator + " and " + lhsType);
            }

            if (!rhsType.equals(VarType.Int) && !rhsType.equals(VarType.Float)){
                throw new Exception("Fatal error: Incompatible types: " + operator + " and " + rhsType);
            }
            return VarType.Bool;
        }
    }

}
