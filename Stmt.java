import javax.print.attribute.standard.PrinterMakeAndModel;

class Stmt extends ExampleToken implements Token {

    Name printlist;

    public Stmt(Name printlist){
        this.printlist = printlist;
    }

    public String toString(int t){
        
        return printlist.toString(t);
    }

}