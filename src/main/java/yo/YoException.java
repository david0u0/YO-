package yo;
import yo.ast.ASTree;
/**
 * Created by David on 2014/8/29.
 */
public class YoException extends RuntimeException {
    public YoException(String m) {super(m);}
    public YoException(String m, ASTree t) {
        super(m + " " + t.location);
    }
}
