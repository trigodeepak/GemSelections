package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentCharDashaResponse {
    @SerializedName("dasha_date")
    @Expose
    private String dashaDate;
    @SerializedName("major_dasha")
    @Expose
    private MajorDasha majorDasha;
    @SerializedName("sub_dasha")
    @Expose
    private SubDasha subDasha;
    @SerializedName("sub_sub_dasha")
    @Expose
    private List<SubSubDasha> subSubDasha = null;

    public String getDashaDate() {
        return dashaDate;
    }

    public void setDashaDate(String dashaDate) {
        this.dashaDate = dashaDate;
    }

    public MajorDasha getMajorDasha() {
        return majorDasha;
    }

    public void setMajorDasha(MajorDasha majorDasha) {
        this.majorDasha = majorDasha;
    }

    public SubDasha getSubDasha() {
        return subDasha;
    }

    public void setSubDasha(SubDasha subDasha) {
        this.subDasha = subDasha;
    }

    public List<SubSubDasha> getSubSubDasha() {
        return subSubDasha;
    }

    public void setSubSubDasha(List<SubSubDasha> subSubDasha) {
        this.subSubDasha = subSubDasha;
    }

}
