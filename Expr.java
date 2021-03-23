class Expr extends ExampleToken implements Token {

    Name name;

    public Expr(Name name){
        this.name = name;
    }

    public String toString(int t)
    {
        return name.toString(t);
    }


}