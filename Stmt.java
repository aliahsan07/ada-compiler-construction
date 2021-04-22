
class Stmt extends SuperToken implements Token {

    Expr expr;
    Stmt stmt;
    Stmt elseStmt;
    Name name;
    String ID;
    int cond;
    Readlist readList;
    Printlist printList;
    Printlinelist printlineList;
    Args args;
    String unaryOperator;
    Fielddecls fieldDecls;
    Stmts stmts;
    boolean hasSemi;

    public Stmt(Expr expr, Stmt stmt, Stmt ie){
        this.expr = expr;
        this.stmt = stmt;
        this.elseStmt = ie;
        cond = 1;
    }

    public Stmt(Expr expr, Stmt stmt){
        this.expr = expr;
        this.stmt = stmt;
        cond = 2;
    }

    public Stmt(Name n, Expr expr){
        this.name = n;
        this.expr = expr;
        cond = 3;
    }

    public Stmt(Readlist rl){
        this.readList = rl;
        cond = 4;
    }

    public Stmt(Printlist pl){
        this.printList = pl;
        cond = 5;
    }

    public Stmt(Printlinelist pll){
        this.printlineList = pll;
        cond = 6;
    }

    public Stmt(String id){
        this.ID = id;
        cond = 7;
    }

    public Stmt(String id, Args args){
        this.ID = id;
        this.args = args;
        cond = 8;
    }

    public Stmt(){
        cond = 9;
    }

    public Stmt(Expr expr){
        this.expr = expr;
        cond = 10;
    }

    public Stmt(Name name, String kind){
        this.name = name;  
        this.unaryOperator = kind;
        cond = 11;
    }

    public Stmt(Fielddecls fd, Stmts stmts, boolean hasSemi){
        this.fieldDecls = fd;
        this.stmts = stmts;
        this.hasSemi = hasSemi;
        cond = 12;
    }


    public String toString(int t){

        String tabs = "";
        for (int i = 0; i < t; ++i) {
            tabs += "\t";
        }

        String ret = "";
        switch (cond) {
            case 1:
                ret = tabs + "if (" + expr.toString(t) + ")\n" +
                        (stmt.cond == 12 ? stmt.toString(t) : tabs + "{\n" + stmt.toString(t+1) + tabs + "}\n") +
                        ((elseStmt == null ? "" : tabs + "else\n" + ( elseStmt.cond == 12 ? elseStmt.toString(t) : tabs + "{\n" + elseStmt.toString(t+1) + tabs + "}\n")));
                return ret;
            case 2:
                return tabs + "while (" + expr.toString(t) + ")\n" + (stmt.cond == 12 ? stmt.toString(t) : tabs + "{\n" + stmt.toString(t+1) + tabs + "}\n");
            case 3:
                return tabs + name.toString(t) + " = " + expr.toString(t) + ";\n";
            case 4:
                return  tabs + "read(" + readList.toString(t) + ");\n";
            case 5:
                return  tabs + "print(" + printList.toString(t) + ");\n";
            case 6:
                return tabs + "printline(" + printlineList.toString(t) + ");\n";
            case 7:
                return tabs + ID + "();\n";
            case 8:
                return tabs + ID + "(" + args.toString(t) + ");\n";
            case 9:
                return tabs + "return;\n";
            case 10:
                return tabs + "return " + expr.toString(t) + ";\n";
            case 11:
                return tabs + name.toString(t) + unaryOperator + ";\n";
            case 12:
                ret = tabs + "{\n";
                ret += fieldDecls.toString(t+1);
                ret += stmts.toString(t+1);
                ret += tabs;
                ret += "}";
                ret += (hasSemi == false ? "\n" : ";\n");
                return ret;

            default:
                return "";
        }
    }

    public VarType typeCheck() throws Exception {

        VarType stmtType;
        SymbolTable.VarData var;
        switch (cond){
            case 1:
                stmtType = expr.typeCheck();
                if (!stmtType.equals(VarType.Bool) && !stmtType.equals(VarType.Int))
                    throw new Exception("Incompatible types: " + stmtType + " cannot be converted to Boolean");

                typeCheckConditional(stmt);
                if (elseStmt != null){
                    typeCheckConditional(elseStmt);
                }
                break;

            case 2:
                stmtType = expr.typeCheck();
                if (!stmtType.equals(VarType.Bool) && !stmtType.equals(VarType.Int))
                    throw new Exception("Incompatible types: " + stmtType + " cannot be converted to Boolean");
                typeCheckConditional(stmt);
                break;
            case 3:
                VarType nameType = name.typeCheck();
                if (!nameType.equals(expr.typeCheck()))
                    throw new Exception("Fatal error: Incompatible types: " + expr.typeCheck() + " cannot be casted to " + nameType);
                // TODO: fix final var from changing
                var = symbolTable.findVar(name.ID);
                if (var.isFinal)
                    throw new Exception("Fatal error: Cannot reassign a value to final variable " + name.ID);
                break;
            case 4:
                readList.typeCheck();
                break;
            case 5:
                printList.typeCheck();
                break;
            case 6:
                printlineList.typeCheck();
                break;
            case 7:
                // check if function exists in scope
                var = symbolTable.findVar(ID);
                if (var == null || !var.isMethod )
                    throw new Exception("Fatal error: No method found by the name of " + ID);
                break;
            case 8:
                var = symbolTable.findVar(ID);
                if (var == null || !var.isMethod )
                    throw new Exception("Fatal error: No method found by the name of " + ID);
                // check if method's arguments are comptible
                args.typeCheck();
                break;
            case 9:
//                System.out.println(symbolTable.table.getFirst().);
                setContainsRet(true);
                setReturnType(VarType.Void);
                return VarType.Void;
            case 10:
                VarType retType = expr.typeCheck();
                setContainsRet(true);
                setReturnType(retType);
                return retType;
            case 11:
                if (!name.typeCheck().equals(VarType.Int)){
                    throw new Exception("Fatal Error: bad operand type " + name.typeCheck() + " for unary operator " + unaryOperator);
                }
                return VarType.Int;
            case 12:
                typeCheckBlock();
            default:
                return null;

        }

        return null;
    }

    // case 12
    private void typeCheckBlock() throws Exception{
        symbolTable.prependScope();
        fieldDecls.typeCheck();
        stmts.typeCheck();
        symbolTable.removeScope();
    }

    private void typeCheckConditional(Stmt stmt) throws Exception {
        symbolTable.prependScope();
        stmt.typeCheck();
        symbolTable.removeScope();
    }
}