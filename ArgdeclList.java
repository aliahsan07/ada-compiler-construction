class ArgdeclList extends SuperToken implements Token{

    Argdecl argdecl;
    ArgdeclList argdeclList;

    public ArgdeclList(Argdecl argdecl, ArgdeclList argdeclList){
        this.argdecl = argdecl;
        this.argdeclList = argdeclList;
    }

    public ArgdeclList(Argdecl argdecl){
        this.argdecl = argdecl;
        this.argdeclList = null;
    }


    public String toString(int t){
        if (argdecl == null && argdeclList == null)
            return "";
        return argdecl.toString(t) + (argdeclList == null ? "" : ", " + argdeclList.toString(t));
    }

    public void typeCheck() throws Exception{
        if (argdecl != null)
            argdecl.typeCheck();
        if (argdeclList != null)
            argdeclList.typeCheck();
    }
}
