class Fielddecls extends ExampleToken implements Token 
{
    Fielddecl fieldDecl;
    Fielddecls fieldDecls;

    public Fielddecls(Fielddecl fieldDecl, Fielddecls fieldDecls){
        this.fieldDecl = fieldDecl;
        this.fieldDecls = fieldDecls;
//        System.out.println("Testing fielddecls without lambda prod");
    }

    public Fielddecls(){
//        System.out.println("Testing fielddecls");

        this.fieldDecl = null;
        this.fieldDecls = null;

    }


    public String toString(int t){
        return (fieldDecls == null ? "" : fieldDecl.toString(t) + fieldDecls.toString(t)) ;

    }
}