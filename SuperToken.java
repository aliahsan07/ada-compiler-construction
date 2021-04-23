abstract class SuperToken {
    protected static SymbolTable symbolTable;



    public static class CurrentFunction{
        protected static String currentFunc;
        protected static Boolean containsRet = false;
        protected static VarType returnType = null;
        protected static VarType expectedReturnType = null;
    }

    public static void setContainsRet(Boolean containsRet) {
        CurrentFunction.containsRet = containsRet;
    }

    public static Boolean getContainsRet() {
        return CurrentFunction.containsRet;
    }

    public static void setReturnType(VarType returnType) {
        CurrentFunction.returnType = returnType;
    }

    public static VarType getReturnType() {
        return CurrentFunction.returnType;
    }

    public static VarType getExpectedReturnType(){
        return CurrentFunction.expectedReturnType;
    }

    public static void setExpectedReturnType(VarType type){
        CurrentFunction.expectedReturnType = type;
    }

    public String toString(int t)
    {
        return "";
    }



    public VarType getTypeFromString(String type){
        if (type.equals("int"))
            return VarType.Int;
        if (type.equals("float"))
            return VarType.Float;
        if (type.equals("bool"))
            return VarType.Bool;
        if (type.equals("char"))
            return VarType.Char;
        if (type.equals("string"))
            return VarType.String;
        if (type.equals("void"))
            return VarType.Void;
        return null;
    }

    public boolean isCoercible(VarType type1, VarType type2){

//        System.out.println(type1);
//        System.out.println(type2);

        if (type1.equals(VarType.Float)){
            if (type2.equals(VarType.Int) || type2.equals(VarType.Float)){
                return true;
            }
        }
        else if (type1.equals(VarType.Int)){
            if (type2.equals(VarType.Int)){
                return true;
            }
        }
        else if (type1.equals(VarType.Void)){
            if (type2 == null || type2.equals(VarType.Void)) {
                return true;
            }
        }
        else if (type1.equals(VarType.Bool)){
            if (type2.equals(VarType.Bool) || type2.equals(VarType.Int)){
                return true;
            }
        }
        else if (type1.equals(VarType.Char)){
            if (type2.equals(VarType.Char)){
                return true;
            }
        }
        else if (type1.equals(VarType.String)){
            // TODO: handle the case of arrays
            if (type2.equals(VarType.Void)){
                return false;
            }
            return true;
        }
        return false;
    }

}
