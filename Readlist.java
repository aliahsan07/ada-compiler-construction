class Readlist extends SuperToken implements Token{

    Name name;
    Readlist readlist;

    public Readlist(Name name, Readlist readlist){
        this.name = name;
        this.readlist = readlist;
    }

    public Readlist(Name name){
        this.name = name;
        this.readlist = null;
    }

    public String toString(int t){
        if (readlist == null)
            return name.toString(t);
        return name.toString(t) + ", " + readlist.toString(t);
    }

    // have to test this thoroughly
    public VarType typeCheck() throws Exception {
        SymbolTable.VarData nameStatus = symbolTable.findVar(name.ID);

        if (nameStatus.isFinal){
            System.out.println("❌ Fatal error: Cant use read with final variable");
            throw new Exception();
        } else if (nameStatus.isMethod){
            System.out.println("❌ Fatal error: Cant use read with method");
            throw new Exception();
        } else if (nameStatus.isArray && name.expr == null){
            System.out.println("❌ Fatal error: Cant use read with array");
            throw new Exception();
        }

        if (readlist != null){
            return readlist.typeCheck();
        }

        return name.typeCheck();
    }
}