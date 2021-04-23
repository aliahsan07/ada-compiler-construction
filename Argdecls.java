class Argdecls extends SuperToken implements Token{

    ArgdeclList argdeclList;

    public Argdecls(ArgdeclList argdeclList){
        this.argdeclList = argdeclList;
    }

    public Argdecls(){
        this.argdeclList = null;
    }

    public String toString(int t){
        
        if (argdeclList == null)
            return "";
        return argdeclList.toString(t);
    }

    public void typeCheck(String methodName) throws Exception{
        if (argdeclList != null)
            argdeclList.typeCheck(methodName);
    }
}