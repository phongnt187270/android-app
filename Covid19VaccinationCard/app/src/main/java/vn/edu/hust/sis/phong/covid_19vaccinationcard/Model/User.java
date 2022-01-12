package vn.edu.hust.sis.phong.covid_19vaccinationcard.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("phonenumber")
    @Expose
    private String phonenumber;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("division")
    @Expose
    private String division;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("vaccination_info_id")
    @Expose
    private String vaccinationInfoId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getVaccinationInfoId() {
        return vaccinationInfoId;
    }

    public void setVaccinationInfoId(String vaccinationInfoId) {
        this.vaccinationInfoId = vaccinationInfoId;
    }


}
