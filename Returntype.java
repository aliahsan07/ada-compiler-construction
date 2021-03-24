class Returntype extends ExampleToken implements Token 
{
    Type type;

    public Returntype(Type t){
        this.type = t;
    }

    public String toString(int t){
        
        return type.toString(t);
        
    }
}