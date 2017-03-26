package co.uk.matthogan.shitcordtext;

/**
 * @author Matthew Hogan
 */
public class Utils {

    public static boolean isInt(String value) {
        try {

            Integer.parseInt(value);
            return true;

        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
