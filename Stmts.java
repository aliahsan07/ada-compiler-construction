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
        if (stmts == null)
            return "";
        return stmt.toString(t) + "" + stmts.toString(t);
        
    }
}