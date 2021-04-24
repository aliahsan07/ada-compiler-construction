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

//            System.out.println(lhsType);
//            System.out.println(rhsType);

            if (lhsType.equals(VarType.String) && rhsType.equals(VarType.String) && operator.equals("+")) {
                return VarType.String;
            }


            if (! lhsType.equals(VarType.Float) && !lhs.equals(VarType.Int)){
                System.out.println("❌ Fatal error: Cant apply arithmetic operator " + operator + " on expression of type: " + lhsType + " and " + rhsType);
                System.exit(0);
            }
            if (! rhsType.equals(VarType.Float) && !rhsType.equals(VarType.Int)){
                System.out.println("❌ Fatal error: Cant apply arithmetic operator " + operator + " on expression of type: " + rhsType  + " and " + rhsType);
                System.exit(0);
            }

            if (lhsType.equals(VarType.Int) && rhsType.equals(VarType.Int))
                return VarType.Int;

            return VarType.Float;
        }
        else if (operator.equals("||") || operator.equals("&&")){
            VarType lhsType = lhs.typeCheck();
            VarType rhsType = rhs.typeCheck();

            if (!lhsType.equals(VarType.Bool) && !lhsType.equals(VarType.Int)){
                System.out.println("❌ Fatal error: Incompatible types: " + lhsType + " cannot be converted to Boolean");
                System.exit(0);
            }
            if (!rhsType.equals(VarType.Bool) && !rhsType.equals(VarType.Int)){
                System.out.println("❌ Fatal error: Incompatible types: " + rhsType + " cannot be converted to Boolean");
                System.exit(0);
            }

            return VarType.Bool;
        }
        else{
            VarType lhsType = lhs.typeCheck();
            VarType rhsType = rhs.typeCheck();

            if (!lhsType.equals(VarType.Int) && !lhsType.equals(VarType.Float)){
                System.out.println("❌ Fatal error: Incompatible types: " + operator + " and " + lhsType);
                System.exit(0);
            }

            if (!rhsType.equals(VarType.Int) && !rhsType.equals(VarType.Float)){
                System.out.println("❌ Fatal error: Incompatible types: " + operator + " and " + rhsType);
                System.exit(0);
            }
            return VarType.Bool;
        }
    }

}
