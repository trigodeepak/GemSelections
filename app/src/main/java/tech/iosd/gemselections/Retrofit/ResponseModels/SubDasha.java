package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubDasha {
    @SerializedName("sign_id")
    @Expose
    private long signId;
    @SerializedName("sign_name")
    @Expose
    private String signName;
    @SerializedName("dasha_name")
    @Expose
    private String dashaName;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;

    public long getSignId() {
        return signId;
    }

    public void setSignId(long signId) {
        this.signId = signId;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDashaName() {
        return dashaName;
    }

    public void setDashaName(String dashaName) {
        this.dashaName = dashaName;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
