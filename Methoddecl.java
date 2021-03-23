
class Methoddecl extends ExampleToken implements Token 
{
    Returntype returntype;
    String id;
    Argdecls argdecls;
    Fielddecls fielddecls;
    Stmts stmts;
    // Optionalsemi semi;

    public Methoddecl(Returntype returntype, String id, Argdecls args, Fielddecls fields, Stmts stmts){
        this.returntype = returntype;
        this.id = id; 
        this.argdecls = args;
        this.fielddecls = fields;
        this.stmts = stmts;
    }


    

    public String toString(int t){
        
        return returntype.toString(t) + " ( " +
        argdecls.toString(t) + " ) \n\t{ " + fielddecls.toString(t) +
       stmts.toString(t) + " \n\t}"
        + ";" + "\n";
    }
}