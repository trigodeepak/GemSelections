package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */
//https://json.astrologyapi.com/v1/match_birth_details
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchBirthDetailResponse {
    @SerializedName("male_birth_details")
    @Expose
    private MaleBirthDetails maleBirthDetails;
    @SerializedName("female_birth_details")
    @Expose
    private FemaleBirthDetails femaleBirthDetails;

    public MaleBirthDetails getMaleBirthDetails() {
        return maleBirthDetails;
    }

    public void setMaleBirthDetails(MaleBirthDetails maleBirthDetails) {
        this.maleBirthDetails = maleBirthDetails;
    }

    public FemaleBirthDetails getFemaleBirthDetails() {
        return femaleBirthDetails;
    }

    public void setFemaleBirthDetails(FemaleBirthDetails femaleBirthDetails) {
        this.femaleBirthDetails = femaleBirthDetails;
    }

}