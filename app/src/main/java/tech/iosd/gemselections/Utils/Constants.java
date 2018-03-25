package tech.iosd.gemselections.Utils;

/**
 * Created by anubhavmalik on 23/03/18.
 */

public class Constants {

    public static final String M_ID = "Khanna50414130495132"; //Paytm Merchant Id we got it in paytm credentials

//    public static final String M_ID ="Anubha67600253601899";
    public static final String CHANNEL_ID = "WAP"; //Paytm Channel Id, got it in paytm credentials
    public static final String INDUSTRY_TYPE_ID = "Retail"; //Paytm industry type got it in paytm credential

    public static final String WEBSITE = "APP_STAGING";
//    public static final String CALLBACK_URL = "https://securegw.paytm.in/theia/paytmCallback?ORDER_ID=";//
    public static final String CALLBACK_URL = /*"https://pguat.paytm.com/oltp-web/processTransaction";http://aa4961f4.ngrok.io/verify_checksum" ;*/"https://checksumpaytm.herokuapp.com/verify_checksum";
//    public static final String CHECKSUM_HASH = "w2QDRMgp1/BNdEnJEAPCIOmNgQvsi+BhpqijfM9KvFfRiPmGSt3Ddzw+oTaGCLneJwxFFq5mqTMwJXdQE2EzK4px2xruDqKZjHupz9yXev4=";

}
