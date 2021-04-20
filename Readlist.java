class Readlist implements Token{

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

    public VarType typeCheck() {
        return name.typeCheck();
    }
}