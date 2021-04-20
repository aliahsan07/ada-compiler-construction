class Program extends SuperToken implements Token
{
    String className;
    Memberdecls memberDecls;

    public Program(String className, Memberdecls memberDecls){
        this.className = className;
        this.memberDecls = memberDecls;
        symbolTable = new SymbolTable();
    }


    public String toString(int t){
        return "class " + className + " {\n" + memberDecls.toString(t+1) + "}\n";
    }

    public void typeCheck(){
        memberDecls.typeCheck();
    }
}