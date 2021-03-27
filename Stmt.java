import javax.print.attribute.standard.PrinterMakeAndModel;

class Stmt extends ExampleToken implements Token {

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

        switch (cond) {
            case 1:
                return "if (" + expr.toString(t) + ")\n" +
                "{\n" + stmt.toString(t+1) + "\n" + "}" +
                (elseStmt == null ? "" : "\n" + "else {\n" + elseStmt.toString(t+1) + "\n }");
            
            case 2:
                return "while (" + expr.toString(t) + ")\n" + stmt.toString(t+1) + "\n";
            case 3:
                return name.toString(t) + " = " + expr.toString(t) + ";";
            case 4:
                return  "read(" + readList.toString(t) + ");";
            case 5:
                return  "print(" + printList.toString(t) + ");";
            case 6:
                return "printlist(" + printlineList.toString(t) + ");";
            case 7:
                return ID + "();";
            case 8:
                return ID + "(" + args.toString(t) + ");";
            case 9:
                return "return;";
            case 10:
                return "return " + expr.toString(t) + ";";
            case 11:
                return name.toString(t) + unaryOperator + ";";
            case 12:
                String ret = "{\n";
                ret += fieldDecls.toString(t+1);
                ret += stmts.toString(t+1);
                ret += "\n}";
                ret += (hasSemi == false ? "" : ";");
                return ret;

            default:
                return "";
        }
    }

}