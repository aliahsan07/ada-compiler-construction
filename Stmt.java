import javax.print.attribute.standard.PrinterMakeAndModel;

class Stmt extends ExampleToken implements Token {

    Expr expr;
    Stmt stmt;
    Stmt elseStmt;
    Name name;
    String ID;
    int cond;
    Readlist readlist;
    Printlist printlist;
    Printlinelist printlinelist;
    Args args;
    String unaryOperator;
    Fielddecls fielddecls;
    Stmts stmts;

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
        this.printlist = pl;
        cond = 5;
    }

    public Stmt(Printlinelist pll){
        this.printlinelist = pll;
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

        switch (cond) {
            case 1:
                return "if (" + expr.toString() + ")\n" + 
                "{\n" + stmt.toString(t+1) + "\n" + "}" +
                (elseStmt == null ? "" : "\n" + "else {\n" + elseStmt.toString() + "\n }");
            
            case 2:
                return "while (" + expr.toString() + ")\n" + stmt.toString() + "\n";
            case 3:
                return name.toString() + " = " + expr.toString() + ";";
            case 4:
                return  "read(" + readlist.toString() + ");";
            case 5:
                return  "print(" + printlist.toString() + ");";
            case 6:
                return "printlist(" + printlinelist.toString() + ");";
            case 7:
                return ID + "();";
            case 8:
                return ID + "(" + args.toString() + ");";
            case 9:
                return "return;";
            case 10:
                return "return " + expr.toString() + ";";
            case 11:
                return name.toString() + unaryOperator + ";";
            case 12:
                String ret = "{\n";
                ret += fieldDecls.toString(t+1);
                ret += stmts.toString(t+1);
                ret += "\n}";
                ret += (hasSemi == null ? "" : ";");
                return ret;

            default:
                return "";
        }
    }

}