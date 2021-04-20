import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

// List of hashmaps implementation of Symbol table
public class SymbolTable{
    LinkedList<HashMap<String, VarData>> table;

    public SymbolTable(){
        table = new LinkedList<HashMap<String, VarData>>();
    }

    // setters for scope
    void prependScope(){
        table.addFirst(new HashMap<String, VarData>());
    }

    void removeScope(){
        table.removeFirst();
    }


    public Boolean addVar(String name, VarType type){
        if (table.getFirst().containsKey(name))
            return false;

        VarData var = new VarData(type);
        table.getFirst().put(name, var);
        return true;
    }

    public Boolean addVar(String name, VarType type, Boolean isArray){
        if (table.getFirst().containsKey(name))
            return false;

        VarData var = new VarData(type, isArray);
        table.getFirst().put(name, var);
        return true;
    }

    public Boolean addVar(String name, VarType type, Boolean isMethod, HashMap<String, VarType> args){
        if (table.getFirst().containsKey(name))
            return false;
        VarData var = new VarData(type, args);
        table.getFirst().put(name, var);
        return true;
    }

    public Boolean addVar(String name, VarType type, Boolean isArray, Boolean isMethod, Boolean isFinal){
        if (table.getFirst().containsKey(name))
            return false;
        VarData var = new VarData(type, isArray, isMethod, isFinal);

        table.getFirst().put(name, var);
        return true;
    }

    public VarData findVar(String name){
        Iterator<HashMap<String, VarData>> iterator = table.iterator();

        while (iterator.hasNext()){
            HashMap<String, VarData> currScope = iterator.next();
            if (currScope.containsKey(name))
                    return currScope.get(name);
        }

        return null;
    }

    class VarData{


        boolean isFinal = false;
        boolean isMethod = false;
        boolean isArray = false;
        VarType type;
        HashMap<String, VarType> methodArgs;

        public VarData(VarType type){
            this.type = type;
        }

        public VarData(VarType type, Boolean isArray){
            this.type = type;
            this.isArray = isArray;
        }

        public VarData(VarType type, HashMap<String, VarType> args){
            this.type = type;
            this.isMethod = true;
            this.methodArgs = args;

        }

        public VarData(VarType type, Boolean isArray, Boolean isMethod, Boolean isFinal){
            this.type = type;
            this.isArray = isArray;
            this.isMethod = isMethod;
            this.isFinal = isFinal;
        }


    }


//    class Variable{
//
//        String type;
//        String name;
//        HashMap<String, String> methodArgs;
//
//        public Variable(Var type, String name){
//            this.type = type;
//            this.name = name;
//        }
//
//        public Variable(String type, String name, HashMap<String, String> methodArgs){
//            this.type = type;
//            this.name = name;
//            this.methodArgs = methodArgs;
//        }
//
//
//
//    }

}