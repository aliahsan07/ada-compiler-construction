JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-1.8.2/lib/jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)
MYDIR = .

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
		$(JAVAC) -cp $(CP) $*.java

# FILE=	Lexer.java	parser.java	sym.java \
# 			LexerTest.java

FILE =  Lexer.java parser.java sym.java \
        ParserTest.java TypeCheckingTest.java\
        SuperToken.java SymbolTable.java VarType.java\
        Program.java Memberdecls.java Fielddecls.java \
        Methoddecls.java Fielddecl.java Methoddecl.java \
        Argdecls.java ArgdeclList.java Argdecl.java \
        Stmts.java Stmt.java Name.java \
        Args.java Readlist.java Printlist.java \
        Printlinelist.java Expr.java BinaryOp.java Token.java


run: myTest.as

list: all
	rm -rf ./test-results/results.txt;
	for file in ./p3TestsCorrected/*.as ; do \
  		echo "Processing" $${file} >> ./test-results/results.txt; \
  		echo "Processing" $${file}; \
		$(JAVA) -cp $(CP) TypeCheckingTest $$file >> ./test-results/results.txt; \
		echo "\n" >> ./test-results/results.txt; \
	done; \
	cat -n ./test-results/results.txt;

typeCheckTest.as: all
	$(JAVA) -cp $(CP) TypeCheckingTest ./p3TestsCorrected/badString.as > ./test-results/badString-output.txt
		cat -n ./test-results/badString-output.txt

myTest.as: all
	$(JAVA) -cp $(CP) TypeCheckingTest ./p3TestsCorrected/testFile.as > ./test-results/testFile-output.txt
		cat -n ./test-results/testFile-output.txt

test1.as: all
	$(JAVA) -cp $(CP) ParserTest ./tests/test1.as > ./test-results/output1.txt
		cat -n ./test-results/output1.txt

test2.as: all
	$(JAVA) -cp $(CP) ParserTest ./tests/test2.as > ./test-results/output2.txt
		cat -n ./test-results/output2.txt

test3.as: all
	$(JAVA) -cp $(CP) ParserTest ./tests/test3.as > ./test-results/output3.txt
		cat -n ./test-results/output3.txt

test4.as: all
	$(JAVA) -cp $(CP) ParserTest ./tests/test4.as > ./test-results/output4.txt
		cat -n ./test-results/output4.txt

test5.as: all
	$(JAVA) -cp $(CP) ParserTest ./tests/test5.as > ./test-results/output5.txt
		cat -n ./test-results/output5.txt

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

