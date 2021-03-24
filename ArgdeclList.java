class ArgdeclList extends ExampleToken implements Token{

    boolean single;
    Argdecl argdecl;
    ArgdeclList argdeclList;

    public ArgdeclList(Argdecl argdecl, ArgdeclList argdeclList, boolean single){
        this.argdecl = argdecl;
        if (!single){
            this.argdeclList = argdeclList;
        }
        this.single = single;
    }


    public String toString(int t){
        return "inside argdecl list";
        // if (single)
        //     return argdecl.toString(t);
        // return argdecl.toString(t) + ", " + argdeclList.toString(t);
    }
}