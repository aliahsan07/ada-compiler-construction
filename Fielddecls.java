class Fielddecls extends ExampleToken implements Token 
{
    Fielddecl fieldDecl;
    Fielddecls fieldDecls;

    public Fielddecls(Fielddecl fieldDecl, Fielddecls fieldDecls){
        this.fieldDecl = fieldDecl;
        this.fieldDecls = fieldDecls; 
    }

    public Fielddecls(){

        this.fieldDecl = null;
        this.fieldDecls = null;

    }


    public String toString(int t){
        return (fieldDecls == null ? "" : fieldDecl.toString(t) + fieldDecls.toString(t)) ;

    }
}