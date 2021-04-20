
class Methoddecls extends SuperToken implements Token
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
        return (methodDecl == null ? "" : methodDecl.toString(t)) + (methodDecls == null ? "" : methodDecls.toString(t));
    }

    public void typeCheck() throws Exception{
        if (methodDecl != null)
            methodDecl.typeCheck();
        if (methodDecls != null)
            methodDecls.typeCheck();
    }
}