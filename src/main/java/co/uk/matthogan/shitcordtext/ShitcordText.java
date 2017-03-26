package co.uk.matthogan.shitcordtext;

import org.apache.commons.cli.*;

import java.util.Locale;

/**
 * @author Matthew Hogan
 */
public class ShitcordText {

    private static final String BLUE = ":regional_indicator_%s:";
    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String... args) {

        Options options = new Options();
        options.addOption("t", true, "Text to format");

        try {
            CommandLineParser parser = new GnuParser();
            CommandLine commandLine = parser.parse(options, args);

            String text = commandLine.getOptionValue("t").toLowerCase();
            StringBuilder output = new StringBuilder();
            char[] letters = text.toCharArray();

            for (char letter : letters) {
                if (letter == ' ') {
                    output.append(" ");
                    continue;
                }

                if (!String.valueOf(alphabet).contains(String.valueOf(letter))) {
                    System.out.println("Shitcord doesn't support the letter \"" + letter + "\" :(");
                    return;
                }

                output.append(String.format(
                        Locale.ENGLISH,
                        ShitcordText.BLUE,
                        letter)
                ).append(" ");
            }

            System.out.println(output.toString());

        } catch (ParseException exception) {
            exception.printStackTrace();
        }
    }
}