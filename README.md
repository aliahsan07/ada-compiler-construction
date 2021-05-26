# ada-compiler-construction

Design of a Basic Compiler in Java using JFlex and Cup

## How to run
`make` or `make run` runs the tokenization, parsing and finally type checking on the test files provided in p3TestsCorrected directory.

## Grammar 

**Program** → class id { Memberdecls }  
**Memberdecls** → Fielddecls Methoddecls  
**Fielddecls** → Fielddecl Fielddecls | λ  
**Methoddecls** → Methoddecl Methoddecls | λ  
**Fielddecl** → Optionalfinal Type id Optionalexpr ; | Type id [ intlit ] ;  
**Optionalfinal** → final | λ  
**Optionalexpr** → = Expr | λ  
**Methoddecl** → Returntype id ( Argdecls ) { Fielddecls Stmts } Optionalsemi  
**Optionalsemi** → ; | λ  
**Returntype** → Type | void  
**Type** → int | char | bool | float  
**Argdecls** → ArgdeclList | λ  
**ArgdeclList** → Argdecl , ArgdeclList | Argdecl  
**Argdecl** → Type id | Type id [ ]  
**Stmts** → Stmt Stmts | λ  
**Stmt** → if ( Expr ) Stmt OptionalElse | while ( Expr ) Stmt | Name = Expr ;  
| read ( Readlist ) ; | print ( Printlist ) ; | printline ( Printlinelist ) ;  
| id ( ) ; | id ( Args ) ; | return ; | return Expr ; | Name ++ ; | Name -- ;  
| { Fielddecls Stmts } Optionalsemi  
**OptionalElse** → else Stmt | λ  
**Name** → id | id [ Expr ]  
**Args** → Expr , Args | Expr  
**Readlist** → Name , Readlist | Name  
**Printlist** → Expr , Printlist | Expr  
**Printlinelist** → Printlist | λ  
**Expr** → Name | id ( ) | id ( Args ) | intlit | charlit | strlit | floatlit | true | false  
| ( Expr ) | ~ Expr | - Expr | + Expr | ( Type ) Expr | Expr Binaryop Expr | ( Expr ? Expr : Expr )  
**Binaryop** → * | / | + | - | < | > | <= | >= | == | <> | || | &&  

