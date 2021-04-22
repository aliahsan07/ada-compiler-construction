import java.util.HashMap;
import java.util.Map;

class Argdecl extends SuperToken implements Token{

    boolean isArray;
    String type;
    String ID;

    public Argdecl(String type, String id, boolean isArray){
        this.type = type;
        this.ID = id;
        this.isArray = isArray;
    }


    public String toString(int t){
        return type + " " + ID + (isArray ? "[]" : "");
    }

    public void typeCheck() throws Exception{
//        HashMap<String, SymbolTable.VarData> first = symbolTable.table.getFirst();
//        for (Map.Entry<String, SymbolTable.VarData> entry : first.entrySet()) {
//            String key = entry.getKey();
//            SymbolTable.VarData value = entry.getValue();
//
//            System.out.println ("Key: " + key + " Value: " + value);
//        }

        Boolean exists = !symbolTable.addVar(ID, getTypeFromString(type), isArray);
        if (exists)
            throw new Exception("Variable " + ID + " is already defined in this scope.");
    }
}
