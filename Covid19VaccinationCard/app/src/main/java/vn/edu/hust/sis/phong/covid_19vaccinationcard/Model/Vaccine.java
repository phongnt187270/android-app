package vn.edu.hust.sis.phong.covid_19vaccinationcard.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vaccine {
    @SerializedName("vaccine_id")
    @Expose
    private String vaccineId;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("dose_number")
    @Expose
    private String doseNumber;
    @SerializedName("injected_location")
    @Expose
    private String injectedLocation;
    @SerializedName("injected_date")
    @Expose
    private String injectedDate;
    @SerializedName("commodity_number")
    @Expose
    private String commodityNumber;

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(String doseNumber) {
        this.doseNumber = doseNumber;
    }

    public String getInjectedLocation() {
        return injectedLocation;
    }

    public void setInjectedLocation(String injectedLocation) {
        this.injectedLocation = injectedLocation;
    }

    public String getInjectedDate() {
        return injectedDate;
    }

    public void setInjectedDate(String injectedDate) {
        this.injectedDate = injectedDate;
    }

    public String getCommodityNumber() {
        return commodityNumber;
    }

    public void setCommodityNumber(String commodityNumber) {
        this.commodityNumber = commodityNumber;
    }

}
