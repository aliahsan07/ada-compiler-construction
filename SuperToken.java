abstract class SuperToken {
    protected static SymbolTable symbolTable;

    protected static String currentFunc;
    protected static Boolean containsRet = false;
    protected static VarType returnType = null;

    public static void setContainsRet(Boolean containsRet) {
        SuperToken.containsRet = containsRet;
    }

    public static Boolean getContainsRet() {
        return containsRet;
    }

    public static void setReturnType(VarType returnType) {
        SuperToken.returnType = returnType;
    }

    public static VarType getReturnType() {
        return returnType;
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
        return false;
    }

}
