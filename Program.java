class Program extends ExampleToken implements Token 
{
    String id;
    Memberdecls memberDecls;

    public Program(String id, Memberdecls memberDecls){
        this.id = id;
        this.memberDecls = memberDecls; 
    }


    public String toString(int t){
        return "class " + id + " {\n\t" + memberDecls.toString(t) + " \n}\n";
    }
}