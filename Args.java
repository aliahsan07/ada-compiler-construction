import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

class Args extends SuperToken implements Token{

    Expr expr;
    Args args;



    public Args(Expr expr, Args args){
        this.expr = expr;
        this.args = args;
    }

    public Args(){
        this.expr = null;
        this.args = null;
    }

    public Args(Expr expr){

        this.expr = expr;
        this.args = null;
    }

    public String toString(int t){
        if (args == null && expr == null)
            return "";
        return expr.toString(t) + (args == null ? "" : (", " + args.toString(t)));
    }


    public void typeCheck(String fnName, List<VarType> methodArgs) throws Exception{
        List<VarType> argTypes = new ArrayList<>();


        gatherTypesFromCall(argTypes);



        if (argTypes.size() != methodArgs.size()){
            System.out.println("❌ Fatal error: Function " + fnName + " expected " + methodArgs.size() + " arguments, " + argTypes.size() + " provided");
            System.exit(0);
        }

        for (int i=0; i < methodArgs.size(); i++){
            VarType expectedArg = methodArgs.get(i);
            VarType actualArg = argTypes.get(i);

            if (!isCoercible(expectedArg, actualArg)){
                System.out.println("❌ Fatal error: Expected argument of type " + expectedArg + " in position " + i + " of function " + fnName + ", " + actualArg + " provided");
                System.exit(0);
            }
        }

    }

    private void gatherTypesFromCall(List<VarType> argTypes) throws Exception {
        if (expr != null) {
            VarType exprType = expr.typeCheck();
            argTypes.add(exprType);
            if (args != null && args.expr != null)
                args.gatherTypesFromCall(argTypes);
        }
    }

}