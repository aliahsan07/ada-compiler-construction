class Argdecl implements Token{

    boolean isArray;
    String type;
    String ID;

    public Argdecl(String t, String id, boolean isArray){
        this.type = t;
        this.ID = id;
        this.isArray = isArray;
    }


    public String toString(int t){
        return type + " " + ID + (isArray ? "[]" : "");
    }
}