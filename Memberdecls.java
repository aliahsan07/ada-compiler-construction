
class Memberdecls implements Token 
{
    Fielddecls fieldDecls;
    Methoddecls methodDecls;
    int cond;

    public Memberdecls(Fielddecls fieldDecls){
        this.fieldDecls = fieldDecls;
        cond = 1;
    }

    public Memberdecls(Methoddecls methodDecls){
        this.methodDecls = methodDecls;
        cond = 2;
    }

    public Memberdecls(Fielddecls fieldDecls, Methoddecls methodDecls){
        this.fieldDecls = fieldDecls;
        this.methodDecls = methodDecls; 
        cond = 3;
    }


    public String toString(int t){

        if (cond == 1){
            return fieldDecls.toString(t);
        } else if (cond == 2){
            return methodDecls.toString(t);
        } else{
            return fieldDecls.toString(t) + methodDecls.toString(t);
        }
    }
}