public class Name extends SuperToken implements Token
{
  String ID;
  Expr expr;

  public Name(String id)
  {
    this.ID = id;
    this.expr = null;
  }

  public Name(String id, Expr expr)
  {
    this.ID = id;
    this.expr = expr;
  }

  public String toString(int t)
  {
    return ID + ( expr == null ? "" : "[" + expr.toString(t) + "]");
  }

    public VarType typeCheck() {
      // error handling
      return symbolTable.findVar(ID).type;
    }
}
