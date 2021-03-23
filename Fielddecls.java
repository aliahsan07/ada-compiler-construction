class Fielddecls extends ExampleToken implements Token 
{
    Fielddecl fieldDecl;
    Fielddecls fieldDecls;

    public Memberdecls(Fielddecl fieldDecl, Fielddecls fieldDecls){
        this.fieldDecl = fieldDecl;
        this.fieldDecls = fieldDecls; 
    }


    public String toString(int t){
        return fieldDecls.toString(t) + " " + methodDecls.toString(t);
    }
}