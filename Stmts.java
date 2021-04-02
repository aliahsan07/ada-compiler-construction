class Stmts implements Token {
    Stmt stmt;
    Stmts stmts;

    public Stmts(Stmt stmt, Stmts stmts){
        this.stmt = stmt;
        this.stmts = stmts;
    }

    public Stmts(){
        this.stmt = null;
        this.stmts = null;
    }

    public String toString(int t){
//        String tabs = "";
//        for (int i = 0; i < t; ++i) tabs += "\t";
        return (stmt == null ? "" : stmt.toString(t)) + (stmts == null ? "" : stmts.toString(t));
        
    }
}