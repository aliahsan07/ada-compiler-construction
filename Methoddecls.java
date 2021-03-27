
class Methoddecls implements Token 
{
    Methoddecl methodDecl;
    Methoddecls methodDecls;

    public Methoddecls(Methoddecl methodDecl, Methoddecls methodDecls){
        this.methodDecl = methodDecl;
        this.methodDecls = methodDecls; 
    }

    public Methoddecls(Methoddecl methodDecl){
        this.methodDecl = methodDecl;
        methodDecls = null;
    }

    public Methoddecls(){
        this.methodDecl = null;
        this.methodDecls = null;
    }


    public String toString(int t){
        if (methodDecl == null)
            return "";
        return (methodDecl.toString(t) + methodDecls == null ? "" : methodDecls.toString(t));
    }
}