class Fielddecls implements Token
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
        if (fieldDecl == null && fieldDecls == null)
            return "";
        return fieldDecl.toString(t) + (fieldDecls == null ? "" : fieldDecls.toString(t));


    }
}