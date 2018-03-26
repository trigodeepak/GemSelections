package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */


//https://json.astrologyapi.com/v1/match_manglik_report

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class MatchManglikReportResponse {

    @SerializedName("male")
    @Expose
    private Male male;
    @SerializedName("female")
    @Expose
    private Female female;
    @SerializedName("conclusion")
    @Expose
    private Conclusion conclusion;

    public Male getMale() {
        return male;
    }

    public void setMale(Male male) {
        this.male = male;
    }

    public Female getFemale() {
        return female;
    }

    public void setFemale(Female female) {
        this.female = female;
    }

    public Conclusion getConclusion() {
        return conclusion;
    }

    public void setConclusion(Conclusion conclusion) {
        this.conclusion = conclusion;
    }


}





