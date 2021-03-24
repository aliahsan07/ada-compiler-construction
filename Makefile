JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-1.8.2/lib/jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
		$(JAVAC) -cp $(CP) $*.java

# FILE=	Lexer.java	parser.java	sym.java \
# 			LexerTest.java

FILE=		Lexer.java parser.java    sym.java \
				ParserTest.java \
				Program.java Memberdecls.java Token.java \
				Expr.java Fielddecl.java Fielddecls.java \
				Memberdecls.java Methoddecl.java Methoddecls.java \
				Name.java Printlist.java Stmt.java Stmts.java \
				Argdecl.java ArgdeclList.java Argdecls.java

run: test5.as

test5.as: all
	$(JAVA) -cp $(CP) ParserTest ./tests/test5.as > testFile-output.txt
		cat -n testFile-output.txt

testFile: all
		$(JAVA) -cp $(CP) LexerTest basicRegex.txt > testFile-output.txt
		cat -n testFile-output.txt

all: Lexer.java parser.java $(FILE:java=class)

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java

Lexer.java: grammar.jflex
	$(JFLEX) grammar.jflex

parser.java: tokens.cup
		$(CUP) -interface < tokens.cup

parserD.java: tokens.cup
		$(CUP) -interface -dump < tokens.cup

