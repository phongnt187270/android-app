package vn.edu.hust.sis.phong.covid_19vaccinationcard.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Vaccination_info {
    @SerializedName("vaccination_info_id")
    @Expose
    private String vaccinationInfoId;
    @SerializedName("vaccination_injection_1")
    @Expose
    private String vaccinationInjection1;
    @SerializedName("vaccination_injection_2")
    @Expose
    private String vaccinationInjection2;

    public String getVaccinationInfoId() {
        return vaccinationInfoId;
    }

    public void setVaccinationInfoId(String vaccinationInfoId) {
        this.vaccinationInfoId = vaccinationInfoId;
    }

    public String getVaccinationInjection1() {
        return vaccinationInjection1;
    }

    public void setVaccinationInjection1(String vaccinationInjection1) {
        this.vaccinationInjection1 = vaccinationInjection1;
    }

    public String getVaccinationInjection2() {
        return vaccinationInjection2;
    }

    public void setVaccinationInjection2(String vaccinationInjection2) {
        this.vaccinationInjection2 = vaccinationInjection2;
    }
}
