
class Methoddecl implements Token
{
    boolean hasSemiColon;
    String type;
    String methodName;
    Argdecls argdecls;
    Fielddecls fielddecls;
    Stmts stmts;


    public Methoddecl(String type, String methodName, Argdecls argdecls, Fielddecls fielddecls, Stmts stmts, boolean hasSemiColon){
        this.type = type;
        this.methodName = methodName; 
        this.argdecls = argdecls;
        this.fielddecls = fielddecls;
        this.stmts = stmts;
        this.hasSemiColon = hasSemiColon;
    }

    public String toString(int t){
//        String ret = "";


        String tabs = "";
        for (int i = 0; i < t; ++i) tabs += "\t";

        return tabs + type + " " + methodName + "(" + argdecls.toString(t) + ")\n" + tabs + "{\n" + fielddecls.toString(t+1) + stmts.toString(t+1) + tabs + "}" + (hasSemiColon ? ";" : "") + "\n\n";
    }
        
}