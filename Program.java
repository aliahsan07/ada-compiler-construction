class Program implements Token 
{
    String className;
    Memberdecls memberDecls;

    public Program(String className, Memberdecls memberDecls){
        this.className = className;
        this.memberDecls = memberDecls; 
    }


    public String toString(int t){
        return "class " + className + " {\n\t" + memberDecls.toString(t+1) + " \n}\n";
    }
}