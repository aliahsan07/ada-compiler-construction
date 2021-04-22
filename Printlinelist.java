class Printlinelist implements Token{
    
    Printlist printlist;

    public Printlinelist(Printlist printlist){
        this.printlist = printlist;
    }

    public Printlinelist(){
        this.printlist = null;
    }

    public String toString(int t){
        if (printlist == null)
            return "";
        return printlist.toString(t);
    }

    public VarType typeCheck() throws Exception {
        return printlist.typeCheck();
    }
}
