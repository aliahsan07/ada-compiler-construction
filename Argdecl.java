class Argdecl extends SuperToken implements Token{

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

    public void typeCheck() throws Exception{
        Boolean exists = symbolTable.addVar(ID, getTypeFromString(type), isArray);
        if (exists)
            throw new Exception("Variable " + ID + " is already defined in this scope.");
    }
}