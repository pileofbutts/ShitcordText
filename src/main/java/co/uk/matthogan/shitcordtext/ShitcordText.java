/*
 * MIT License
 *
 * Copyright (c) 2017 Matthew Hogan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.uk.matthogan.shitcordtext;

import org.apache.commons.cli.*;

import java.util.Locale;

/**
 * @author Matthew Hogan
 */
public class ShitcordText {

    private static final String BLUE = ":regional_indicator_%s:";
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String... args) {
        try {
            Options options = new Options();
            options.addOption("t", true, "Text to format");

            CommandLine commandLine = new GnuParser().parse(options, args);
            String text = commandLine.getOptionValue("t").toLowerCase();
            StringBuilder output = new StringBuilder();

            for (char letter : text.toCharArray()) {
                if (letter == ' ') {
                    output.append(" ");
                    continue;
                }

                if (!String.valueOf(ShitcordText.ALPHABET)
                        .contains(String.valueOf(letter)))
                {
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