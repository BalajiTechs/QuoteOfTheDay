import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class QuoteList {

    private Quote[] listOfQuotes = new Quote[366];
    private int nextQuotePos = 0;

    public QuoteList() {
        this(new File("quotelist"));
    }

    /**
     * Accepts file with list of quotes separated by # char
     *
     * @param quoteFile
     */
    public QuoteList(File quoteFile) {
        populateQuoteList(quoteFile);
    }


    private void populateDefaultQuotes() {


        Quote quote = new Quote("The greatest danger for most of us is not that our aim is too high and we miss it, " +
                "but that it is too low and we reach it.", "Michelangelo");
        listOfQuotes[nextQuotePos++] = quote;
        //TODO
    }

    private void populateQuoteList(File quoteFile) {
        try {
            Scanner scanner = new Scanner(quoteFile, "utf-8");
            do {
                String line = scanner.nextLine();
                Quote quote;
                if (line.contains("#")) {
                    quote = new Quote(line.split("#")[0], line.split("#")[1]);
                } else {
                    quote = new Quote(line, "");
                }

                listOfQuotes[nextQuotePos++] = quote;
            } while (scanner.hasNextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Returns the quote for the day. day should be in range [1 - 366]
     *
     * @param day
     * @return
     */

    public String getQuoteOfDay(int day) {
        if (nextQuotePos == 0) {
            System.out.println("QuoteList list is empty");
            return null;
        }

        if (day < 1 || day > 366) {
            System.out.println("Invalid Day specified");
            return null;
        }
        Quote quote = listOfQuotes[day - 1];
        return quote.getMessage() + " -- " + quote.getAuthor();
    }


}
