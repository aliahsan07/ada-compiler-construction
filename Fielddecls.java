class Fielddecls extends ExampleToken implements Token 
{
    Fielddecl fieldDecl;
    Fielddecls fieldDecls;

    public Fielddecls(Fielddecl fieldDecl, Fielddecls fieldDecls){
        this.fieldDecl = fieldDecl;
        this.fieldDecls = fieldDecls; 
    }

    public Fielddecls(Fielddecl fieldDecl){
        this.fieldDecl = fieldDecl;
    }


    public String toString(int t){
        return (fieldDecl.toString(t) + fieldDecls == null ? "" : fieldDecls.toString(t)) ;

    }
}