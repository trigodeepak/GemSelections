package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicAstroDetailsResponse {
    @SerializedName("Varna")
    @Expose
    private String varna;
    @SerializedName("Vashya")
    @Expose
    private String vashya;
    @SerializedName("Yoni")
    @Expose
    private String yoni;
    @SerializedName("sign_lord")
    @Expose
    private long signLord;
    @SerializedName("sign")
    @Expose
    private String sign;
    @SerializedName("Naksahtra")
    @Expose
    private String naksahtra;
    @SerializedName("naksahtra_lord")
    @Expose
    private String naksahtraLord;
    @SerializedName("nakshatra_charan")
    @Expose
    private long nakshatraCharan;
    @SerializedName("name_alphabet")
    @Expose
    private String nameAlphabet;

    public String getVarna() {
        return varna;
    }

    public void setVarna(String varna) {
        this.varna = varna;
    }

    public String getVashya() {
        return vashya;
    }

    public void setVashya(String vashya) {
        this.vashya = vashya;
    }

    public String getYoni() {
        return yoni;
    }

    public void setYoni(String yoni) {
        this.yoni = yoni;
    }

    public long getSignLord() {
        return signLord;
    }

    public void setSignLord(long signLord) {
        this.signLord = signLord;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getNaksahtra() {
        return naksahtra;
    }

    public void setNaksahtra(String naksahtra) {
        this.naksahtra = naksahtra;
    }

    public String getNaksahtraLord() {
        return naksahtraLord;
    }

    public void setNaksahtraLord(String naksahtraLord) {
        this.naksahtraLord = naksahtraLord;
    }

    public long getNakshatraCharan() {
        return nakshatraCharan;
    }

    public void setNakshatraCharan(long nakshatraCharan) {
        this.nakshatraCharan = nakshatraCharan;
    }

    public String getNameAlphabet() {
        return nameAlphabet;
    }

    public void setNameAlphabet(String nameAlphabet) {
        this.nameAlphabet = nameAlphabet;
    }
}
