class Stmts extends ExampleToken implements Token {
    Stmt stmt;
    Stmts stmts;

    public Stmts(Stmt stmt, Stmts stmts){
        this.stmt = stmt;
        this.stmts = stmts;
    }

    public String toString(int t){
        
        return stmt.toString(t) + " " + stmts.toString(t);
        
    }
}