public class Name implements Token
{
  String ID;
  Expr expr = null;

  public Name(String id)
  {
    this.ID = id;
  }

  public Name(String id, Expr expr)
  {
    this.ID = id;
    this.expr = expr;
  }

  public String toString(int t)
  {
    return ID + ( expr == null ? "" : "[" + expr.toString() + "]");
  }

}
