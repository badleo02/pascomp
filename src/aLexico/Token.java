package aLexico;

public final class Token {


    public String lex;
    public int cod;
    public int numLin;
    public static final String[] LEXEMAS = {"",null, null, //0-1
        ";", ".", ":", ",", "(", ")", "!=", "program", "var", //2-10
        "begin", "end", "true", "false", "integer", "boolean", //11-16
        ":=", null, "+", "-", "*", "/", "not", "and", "or", "="};   //17-27


    public static final String[] TOKENS = {"EOF","id", "digito",
        "PYCOMA", "PUNTO", "DOSPUNTOS", "COMA", "PA", "PC", "DISTINTO", "INICIO", "VAR",
        "SEP", "FIN", "cierto", "falso", "tipent", "tipbool",
        "ASIG", "OPREL", "SUMA", "RESTA", "MUL", "DIV", "NOT", "AND", "OR", "IGUAL"
    };
    
    public static final int EOF = 0;
    public static final int id = 1;
    public static final int digito = 2;
    public static final int PYCOMA = 3;
    public static final int PUNTO = 4;
    public static final int DOSPUNTOS = 5;
    public static final int COMA = 6;
    public static final int PA = 7;
    public static final int PC = 8;
    public static final int DISTINTO = 9;
    public static final int INICIO = 10;
    public static final int VAR = 11;
    public static final int SEP = 12;
    public static final int FIN = 13;
    public static final int cierto = 14;
    public static final int falso = 15;
    public static final int tipent = 16;
    public static final int tipbool = 17;
    public static final int ASIG = 18;
    public static final int OPREL = 19;
    public static final int SUMA = 20;
    public static final int RESTA = 21;
    public static final int MUL = 22;
    public static final int DIV = 23;
    public static final int NOT = 24;
    public static final int AND = 25;
    public static final int OR = 26;
    public static final int IGUAL = 27;

    
    public Token(int cod, String lex, int numLin) {
        this.cod = cod;
        this.numLin = numLin;

        if (LEXEMAS[cod] == null) {
            if (cod == Token.id) {
                this.lex = lex.toLowerCase();
            } else {
                this.lex = lex;
            }
        } else {
            this.lex = LEXEMAS[cod];
        }
    }

    public String getLexema() {
        return lex;
    }

    public String toString() {
        String n = Integer.toString(numLin);
        String nl = ("00" + numLin).substring(n.length() - 1);

        return "[LINE=" + nl + ", " + TOKENS[cod] + ", " + getLexema() + "]";
    }
}