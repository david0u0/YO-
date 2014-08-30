package yo;

/**
 * Created by David on 2014/8/29.
 */
public class Token {
    public static final Token EOF = new Token(-1) {};
    public static final String EOL = "\\n";
    private int lineNumber;

    protected Token(int line) {
        lineNumber = line;
    }
    public int getLineNumber() {return lineNumber}
    public boolean isIdentifier() {return false;}
    public boolean isNumber() {return false;}
    public boolean isString() {return false;}
    public int getNumber() {throw new YoException("not number token");}
    public String getText() {return "";}
}
