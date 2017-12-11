package tech.iosd.gemselections.DataProviders;

/**
 * Created by anonymous on 19/8/17.
 */

public class JewelTypes {

    private String text,url;

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public JewelTypes(String text, String url) {

        this.text = text;
        this.url = url;
    }
}
