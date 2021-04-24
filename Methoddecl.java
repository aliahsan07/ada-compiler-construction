import java.util.ArrayList;
import java.util.HashMap;

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
        setExpectedReturnType(methodType);

        // TODO: Figure out how to deal with args
        if (!symbolTable.addVar(methodName, methodType, true, null)){
            System.out.println("❌ Function " + methodName + " is already defined in this scope!");
            System.exit(0);
        }

        typeCheckMethod(methodType);

    }

    private void typeCheckMethod(VarType methodType) throws Exception {
        symbolTable.prependScope();
        symbolTable.findVar(methodName).methodArgs = new ArrayList<>();
        argdecls.typeCheck(methodName);
        fielddecls.typeCheck();
        stmts.typeCheck();
        VarType expectedReturnType = getExpectedReturnType();

        // check for return
        if (!methodType.equals(VarType.Void) && !CurrentFunction.containsRet){
            System.out.println("❌ Fatal error: Missing return statement from function " + methodName);
            System.exit(0);
        }

        if (!isCoercible(methodType, getReturnType())){
            System.out.println("❌ Fatal error: Incompatible types: " + getReturnType() + " doesn't match expected return type " + methodType);
            System.exit(0);
        }
        symbolTable.removeScope();
        setReturnType(null);
        setContainsRet(false);
    }
}