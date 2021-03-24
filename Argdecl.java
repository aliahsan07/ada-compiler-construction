class Argdecl extends ExampleToken implements Token{

    boolean isArray;
    String type;
    String id;

    public Argdecl(String t, String id, boolean isArray){
        this.type = t;
        this.id = id;
        this.isArray = isArray;
    }


    public String toString(int t){
        return "inside arg decl";
        // if (!isArray)
        //     return type + " " + id;
        // return type + " " + id + "[]";
    }
}