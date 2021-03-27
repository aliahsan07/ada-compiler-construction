
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
        String ret = "";

        String args = argdecls.toString(t);
        String fields = fielddecls.toString(t);
        String statements = stmts.toString(t);

        ret += (type + " " + methodName + "(" + args + ")" + "{\n");
        ret += fields;
        ret += statements;
        ret += "/n }" + (hasSemiColon ? ";" : "");
        return ret;
    }
        
}