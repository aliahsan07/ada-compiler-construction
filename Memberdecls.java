
class Memberdecls extends ExampleToken implements Token 
{
    // Fielddecls fieldDecls;
    Methoddecls methodDecls;

    public Memberdecls(/* Fielddecls fieldDecls, */Methoddecls methodDecls){
        // this.fieldDecls = fieldDecls;
        this.methodDecls = methodDecls; 
    }


    public String toString(int t){
        // return fieldDecls.toString(t) + " " + methodDecls.toString(t);
        return methodDecls.toString(t);
    }
}