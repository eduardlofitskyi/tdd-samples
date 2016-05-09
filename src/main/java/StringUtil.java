/**
 * Created by eduard on 1/6/16.
 */
public class StringUtil {
    public static final String TYPE = "TYPE";

    public String reverse(String str) {
        if (str==null){
            throw new  IllegalArgumentException("Cannot receive null");
        }

        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString();
    }
}
