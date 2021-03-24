class Argdecls extends ExampleToken implements Token{

    ArgdeclList argdeclList;
    Boolean empty;

    public Argdecls(ArgdeclList argdeclList){
        this.argdeclList = argdeclList;
    }

    public String toString(int t){
        return "inside argdecls";
        
        // return argdeclList.toString(t);
    }
}