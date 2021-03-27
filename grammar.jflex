/*-***
 * This grammar is defined for the example grammar defined in the
 *project part 1 instructions
 */

/*
 * NOTE: make sure that the java cup runtime file is in the same directory as this file
 * it is also alright if the runtime location is added to to the classpath, but just
 * putting in the same file is far easier.
 */
import java_cup.runtime.*;


%%
/*-*
 * LEXICAL FUNCTIONS:
 */

%cup
%line
%column
%unicode
%class Lexer
/*
 * NOTE: the above name ExampleLexer, will have to be changed here if
 * you chose to rename the lexer object.
 */
 
%{

/**
 * Return a new Symbol with the given token id, and with the current line and
 * column numbers.
 */
Symbol newSym(int tokenId) {
    return new Symbol(tokenId, yyline, yycolumn);
}

/**
 * Return a new Symbol with the given token id, the current line and column
 * numbers, and the given token value.  The value is used for tokens such as
 * identifiers and numbers.
 */
Symbol newSym(int tokenId, Object value) {
    return new Symbol(tokenId, yyline, yycolumn, value);
}

%}


/*-*
 * PATTERN DEFINITIONS:
 */

tab            = \\t
newline		   = \\n
slash		   = \\
escapeapos	   = {slash}'
escapequote	   = {slash}\"
letter         = [A-Za-z]
digit          = [0-9]
id   		   = {letter}[{letter}{digit}]*  
intlit	       = {digit}+
charchar	   = [[^\\]&&[^']]|{newline}|{tab}|{escapeapos}|{slash}{slash}
charlit        = '{charchar}'
floatlit       = {digit}+\.{digit}+  // TODO: Check this again?
stringchar	   = [[[^\\]&&[^\"]]&&[[^\n]&&[^\t]]]|{newline}|{tab}|{escapequote}|{slash}{slash}
strlit		   = \"{stringchar}*\"
whitespace     = [ \n\t\r] 
inlinecomment  = {slash}{slash}.*(\n|\r|\r\n)
blockcomment   =  ({slash}\*)([^\*]|(\*+[^\\]))*?(\*{slash}) /**/



%%
/**
 * LEXICAL RULES:
 */
read               { return newSym(sym.READ, "read"); }
print		       { return newSym(sym.PRINT, "print"); }
printline		   { return newSym(sym.PRINTLINE, "printline"); }
int                { return newSym(sym.INT, "int"); }
char               { return newSym(sym.CHAR, "char"); }
bool               { return newSym(sym.BOOL, "bool"); }
float              { return newSym(sym.FLOAT, "float"); }
void               { return newSym(sym.VOID, "void"); }
if                 { return newSym(sym.IF, "if"); } 
else               { return newSym(sym.ELSE, "else"); } 
while              { return newSym(sym.WHILE, "while"); } 
return             { return newSym(sym.RETURN, "return"); }
true               { return newSym(sym.TRUE, "true"); }
false              { return newSym(sym.FALSE, "false"); }
"*"                { return newSym(sym.TIMES, "*"); }
"+"                { return newSym(sym.PLUS, "+"); }
"+" 		       { return newSym(sym.PREFIXPLUS, "+"); }
"-"                { return newSym(sym.MINUS, "-"); }
"-"		           { return newSym(sym.PREFIXMINUS, "-"); }
"/"                { return newSym(sym.DIVIDE, "/"); }
"="                { return newSym(sym.ASSMNT, "="); }
";"                { return newSym(sym.SEMI, ";"); }
"<"                { return newSym(sym.LT, "<"); }
">"                { return newSym(sym.GT, ">"); }
"<="               { return newSym(sym.LTE, "<="); }
">="               { return newSym(sym.GTE, ">="); }
"=="               { return newSym(sym.EQ, "=="); } 
"<>"               { return newSym(sym.NOT_EQ, "<>"); }
"||"               { return newSym(sym.OR, "||"); }
"&&"               { return newSym(sym.AND, "&&"); }
"["                { return newSym(sym.L_BRACKET, "["); }
"]"                { return newSym(sym.R_BRACKET, "]"); }
"("                { return newSym(sym.L_PAREN, "("); }
")"                { return newSym(sym.R_PAREN, ")"); }
"{"                { return newSym(sym.L_BRACE, "{"); }
"}"                { return newSym(sym.R_BRACE, "}"); }
"~"                { return newSym(sym.NEGATION, "~"); }
"?"                { return newSym(sym.TERNARY, "?"); }
":"                { return newSym(sym.COLON, ":"); }
"++"               { return newSym(sym.INCREMENT, "++"); }
"--"               { return newSym(sym.DECREMENT, "--"); }
","               { return newSym(sym.COMMA, ","); }
class              { return newSym(sym.CLASS, "class"); }
final              { return newSym(sym.FINAL, "final"); }
{id}               { return newSym(sym.ID, yytext()); }
{intlit}           { return newSym(sym.INTLIT, new Integer(yytext())); }
{charlit}          { return newSym(sym.CHARLIT, yytext()); }
{strlit}           { return newSym(sym.STRLIT, yytext()); }
{floatlit}         { return newSym(sym.FLOATLIT, new Double(yytext())); }
{inlinecomment}    { /* For this stand-alone lexer, print out comments. */}
{blockcomment}     { /* For this stand-alone lexer, print out comments. */}
{whitespace}       { /* Ignore whitespace. */ }
.                  { System.out.println("Illegal char, '" + yytext() +
                    "' line: " + yyline + ", column: " + yychar); } 