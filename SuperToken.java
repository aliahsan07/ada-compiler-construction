abstract class SuperToken {
    protected static SymbolTable symbolTable;

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

}
