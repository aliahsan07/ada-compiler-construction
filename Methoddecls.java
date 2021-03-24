
class Methoddecls implements Token 
{
    Methoddecl methodDecl;
    Methoddecls methodDecls;

    public Methoddecls(Methoddecl methodDecl, MethodDecls methodDecls){
        this.methodDecl = methodDecl;
        this.methodDecls = methodDecls; 
    }

    public Methoddecls(Methoddecl methodDecl){
        this.methodDecl = methodDecl;
        methodDecls = null;
    }


    public String toString(int t){
        return (methodDecl.toString(t) + methodDecls == null ? "" : methodDecls.toString(t));
        // return fieldDecls.toString(t) + " " + methodDecls.toString(t);
        // if (methodDecl == null)
        //     return "";
        // return methodDecl.toString(t) + methodDecls.toString(t);
    }
}