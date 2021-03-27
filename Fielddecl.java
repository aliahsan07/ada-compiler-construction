class Fielddecl implements Token 
{
    boolean isFinal = false;
    String type;
    String ID;
    Expr opExpr;
    int length;
    int cond;

    public Fielddecl(boolean isFinal, String type, String ID, Expr opExpr){
        this.isFinal = isFinal;
        this.type = type; 
        this.ID = ID;
        this.opExpr = opExpr;
        cond = 1;
    }

    public Fielddecl(String type, String ID, int length){
        this.type = type; 
        this.ID = ID;
        this.length = length;
        cond = 2;
    }

    public String toString(int t){
        String tabs = "";
        for (int i = 0; i < t; ++i) tabs += "\t";
        if (cond == 1)
            return tabs + (isFinal ? "final " : "") + type + " " + ID + (opExpr == null ? "" : " = " + opExpr.toString(t)) + ";";

        return tabs + type + " " + ID + "[" + length + "]" + ";";

    }
}