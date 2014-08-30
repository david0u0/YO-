package yo;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by David on 2014/8/29.
 */
public class Lexer {
    public static final String regexPat
            = "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"
            + "|[A-Z_a-z]|[A-Z_a-z0-9]*|==|<=|>=|&&|\|\||\p{Punct})?";
    private Pattern pattern = Pattern.compile(regexPat);
    private ArrayList<Token> queue = new ArrayList<Token>();
    private boolean hasMore;
    private LineNumberReader reader;

    public Lexer(Reader r) {
        hasMore = true;
        reader = new LineNumberReader(r);
    }
    public Token read() throws ParseException {
        if(fillQueue(0)) return queue.remove(0);
        else return Token.EOF;
    }
    private boolean fillQueue(int i) throws ParseException {
        while(i >= queue.size()) {
            if(hasMore) readLine();
            else return false;
        }
        return true;
    }
    void readLine() throws  ParseException {
        String line;
        try {
            line = reader.readLine();
        } catch(IOException e) {
            throw new ParseExeption(e);
        }
        if(line == null) {
            hasMore = false;
            return;
        }
        int lineNo = reader.getLineNumber();
    }
}
