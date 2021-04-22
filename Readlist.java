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

        if (!nameStatus.isFinal){
            throw new Exception("Cant use read with final variable");
        } else if (!nameStatus.isMethod){
            throw new Exception("Cant use read with method");
        } else if (!nameStatus.isArray){
            throw new Exception("Cant use read with array");
        }

        if (readlist != null){
            return readlist.typeCheck();
        }

        return name.typeCheck();
    }
}