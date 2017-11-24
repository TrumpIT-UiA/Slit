package Diverse;

public class DataRelated {

    public StringBuffer LineBreak(String input) {

        StringBuffer text = new StringBuffer(input);

        int loc = (new String(text)).indexOf('\n');
        while(loc > 0){
            text.replace(loc, loc+1, "<BR>");
            loc = (new String(text)).indexOf('\n');
        }
        return text;
    }
}
