class ArgdeclList implements Token{

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
        if (argdeclList == null)
            return argdecl.toString(t);
        return argdecl.toString(t) + ", " + argdeclList.toString(t);
    }
}