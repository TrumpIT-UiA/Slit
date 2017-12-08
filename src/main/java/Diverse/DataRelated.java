package Diverse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataRelated {

    /**
     * Felt
     * @param input
     * @return
     */
    public StringBuffer LineBreak(String input) {
        StringBuffer text = new StringBuffer(input);
        int loc = (new String(text)).indexOf('\n');
        while (loc > 0) {
            text.replace(loc, loc + 1, "<BR>");
            loc = (new String(text)).indexOf('\n');
        }
        return text;
    }

    /**
     * Felt for å
     * @return timeWritten
     */
    public String getCurrentTimeString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String timeWritten = df.format(dateobj);
        return timeWritten;
    }

    /**
     * Felt for å reversere en string/"gjøre den bakvendt"
     * Dette feltet er ikke i bruk så lang, så slett dersom
     * @param input
     * @return reversedStr
     */
    public String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * Felt for å fjerne de siste bokstavene i en string.
     * Index er antall tegn som blir fjernet.
     * @param input
     * @param index
     * @return str = input - index
     */
    public String rmCharsFromString(String input, int index) {
        return input.substring(0, input.length() - index);
    }
}

