public class Name extends ExampleToken implements Token
{
  String id;
  Expr expr;

  public Name(String id)
  {
    this.id = id;
  }

//   public Name(String strinput, Expr exprinput)
//   {
//     id = strinput;
//     expr = exprinput;
//     state = 1;
//   }

  public String toString(int t)
  {
    return id;
  }

}
