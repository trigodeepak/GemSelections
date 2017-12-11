package tech.iosd.gemselections.DataProviders;

/**
 * Created by anonymous on 28/8/17.
 */

public class Victorian {
    String url1;
    String url2;
    String url3;
    String code1;
    String code2;
    String code3;


    public String getCode1() {
        return code1;
    }

    public String getCode2() {
        return code2;
    }

    public String getCode3() {
        return code3;
    }


    public String getUrl1() {
        return url1;
    }

    public String getUrl2() {
        return url2;
    }

    public String getUrl3() {
        return url3;
    }

    public Victorian(String url1, String url2, String url3, String code1, String code2, String code3) {
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
    }
}
