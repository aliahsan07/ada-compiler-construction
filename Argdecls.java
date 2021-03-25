class Argdecls extends ExampleToken implements Token{

    ArgdeclList argdeclList;
    Boolean empty;

    public Argdecls(ArgdeclList argdeclList){
        this.argdeclList = argdeclList;
        this.empty = false;
    }

    public Argdecls(){
        this.empty = true;
    }

    public String toString(int t){
        
        if (empty)
            return "";
        return argdeclList.toString(t);
    }
}