import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * This program uses string method to
 * determine the length of a run in a string.
 *
 * @author  Sarah Andrew
 * @version 1.0
 *
 * @since   2023-03-10
 */

public final class StringStuff {
    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private StringStuff() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Create new list.
        final List<String> listOfStr = new ArrayList<String>();

        // Declare new variable.
        String stringList;

        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                stringList = sc.nextLine();

                // In case of user entering empty line,
                // display no strings found.
                if (stringList.trim().isEmpty()) {
                    write.println("No strings found on line.");
                    continue;
                }
                // Split as spaces.
                final String[] elements = stringList.split(" ");
                // Looping through each element.
                for (String element : elements) {
                    // Adding each string to list.
                    listOfStr.add(element);
                }
            }

            // Convert list of string to list of array.
            final String[] arrayOfStr = listOfStr.toArray(new String[0]);

            // Call function.
            for (String strEle : arrayOfStr) {
                final int maxLength = maxRun(strEle);

                // Displays result to user & to output file.
                System.out.println("The max run of " + strEle
                        + " is " + maxLength + ".");
                write.println("The max run of " + strEle
                        + " is " + maxLength + ".");
            }
            // Closes scanner & writer.
            write.close();
            sc.close();

        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: " + error.getMessage());
        }
    }

    /**
     * This function determines the longest run,
     * in a set of strings.
     * Referenced https://ideone.com/tnXyFb.
     *
     *
     * @param strRun passed.
     *
     * @return maxCount.
     */

    public static int maxRun(String strRun) {
        // Declare variables.
        int maxCount = 0;
        int currentCount = 1;

        // Usage of loop to access each element.
        for (int counter = 1;
            counter < strRun.length(); counter++) {
            // Checks to see if the current letter is the
            // same as the previous one.
            if (strRun.charAt(counter) == strRun.charAt(counter - 1)) {
                // Increment the current count.
                currentCount++;
            } else {
                // If not, update the max count and reset the current count.
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
                currentCount = 1;
            }
        }

        // Update max count after the loop ends.
        if (currentCount > maxCount) {
            // Set maxCount equalled to the
            // current count.
            maxCount = currentCount;
        }
        // Return the max count.
        return maxCount;
    }
}
