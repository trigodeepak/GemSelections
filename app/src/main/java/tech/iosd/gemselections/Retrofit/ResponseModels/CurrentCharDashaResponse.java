package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
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
    //todo error is here Expected BEGIN_ARRAY but was BEGIN_OBJECT still not resolved
    @SerializedName("sub_sub_dasha")
    @Expose
    private SubDashaArrayObj subSubDashaObject;

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

    public SubDashaArrayObj getSubSubDasha() {
        return subSubDashaObject;
    }

    public void setSubSubDasha(SubDashaArrayObj subSubDasha) {
        this.subSubDashaObject = subSubDasha;
    }

    public class SubDashaArrayObj {
        private SubSubDasha[] subSubDashas = new SubSubDasha[12];

        public SubSubDasha[] getSubSubDashas() {
            return subSubDashas;
        }

        public void setSubSubDashas(SubSubDasha[] subSubDashas) {
            this.subSubDashas = subSubDashas;
        }
        public SubDashaArrayObj(){

        }

        public SubDashaArrayObj(SubSubDasha[] subSubDashas) {
            this.subSubDashas = subSubDashas;
        }
    }
}
