class Type extends ExampleToken implements Token 
{
    String typeName;

    public Type(String typeName){
        this.typeName = typeName;
    }


    

    public String toString(int t){
        
        return typeName;
        
    }
}