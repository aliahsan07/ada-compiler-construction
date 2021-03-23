
class Methoddecls extends ExampleToken implements Token 
{
    Methoddecl methodDecl;
    Methoddecls methodDecls;

    public Methoddecls(Methoddecl methodDecl, Methoddecls methodDecls){
        // this.fieldDecls = fieldDecls;
        this.methodDecl = methodDecl;
        this.methodDecls = methodDecls; 
    }

    public Methoddecls(){
        methodDecl = null;
        methodDecls = null;
    }


    public String toString(int t){
        // return fieldDecls.toString(t) + " " + methodDecls.toString(t);
        if (methodDecl == null)
            return "";
        return methodDecl.toString(t) + methodDecls.toString(t);
    }
}