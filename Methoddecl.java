
class Methoddecl extends SuperToken implements Token
{
    boolean hasSemiColon;
    String type;
    String methodName;
    Argdecls argdecls;
    Fielddecls fielddecls;
    Stmts stmts;


    public Methoddecl(String type, String methodName, Argdecls argdecls, Fielddecls fielddecls, Stmts stmts, boolean hasSemiColon){
        this.type = type;
        this.methodName = methodName; 
        this.argdecls = argdecls;
        this.fielddecls = fielddecls;
        this.stmts = stmts;
        this.hasSemiColon = hasSemiColon;
    }

    public String toString(int t){
//        String ret = "";


        String tabs = "";
        for (int i = 0; i < t; ++i) tabs += "\t";

        return tabs + type + " " + methodName + "(" + argdecls.toString(t) + ")\n" + tabs + "{\n" + fielddecls.toString(t+1) + stmts.toString(t+1) + tabs + "}" + (hasSemiColon ? ";" : "") + "\n\n";
    }

    public void typeCheck() throws Exception {
        VarType methodType = getTypeFromString(type);

        // TODO: Figure out how to deal with args
        if (!symbolTable.addVar(methodName, methodType, true, null)){
            throw new Exception("Function " + methodName + " is already defined in this scope!");
        }

        typeCheckMethod(methodType);

    }

    private void typeCheckMethod(VarType methodType) throws Exception {
        symbolTable.prependScope();
        argdecls.typeCheck();
        fielddecls.typeCheck();
        stmts.typeCheck();
        // check for return
        if (!methodType.equals(VarType.Void) && !containsRet){
            throw new Exception("Fatal error: Missing return statement");
        }

        if (!isCoercible(methodType, getReturnType())){
            throw new Exception("Fatal error: Incompatible types: " + getReturnType() + " doesn't match expected return type " + methodType);
        }
        symbolTable.removeScope();
        setContainsRet(false);
    }
}