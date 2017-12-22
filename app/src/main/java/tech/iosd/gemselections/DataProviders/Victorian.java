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
    String downloadUrl1;
    String downloadUrl2;
    String downloadUrl3;

    public Victorian(String downloadUrl1, String downloadUrl2, String downloadUrl3) {
        this.downloadUrl1 = downloadUrl1;
        this.downloadUrl2 = downloadUrl2;
        this.downloadUrl3 = downloadUrl3;
    }

    public Victorian(String code1, String code2, String code3, String downloadUrl1, String downloadUrl2, String downloadUrl3) {
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        this.downloadUrl1 = downloadUrl1;
        this.downloadUrl2 = downloadUrl2;
        this.downloadUrl3 = downloadUrl3;
    }

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

    public String getDownloadUrl1() {
        return downloadUrl1;
    }

    public String getDownloadUrl2() {
        return downloadUrl2;
    }

    public String getDownloadUrl3() {
        return downloadUrl3;
    }
}

