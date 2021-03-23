class Stmt extends ExampleToken implements Token {


    public Stmt(Stmt stmt, Stmts stmts){
        this.stmt = stmt;
        this.stmts = stmts;
    }

}