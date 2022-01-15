package vn.edu.hust.sis.phong.covid_19vaccinationcard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.User;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.Vaccination_info;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.Vaccine;

public interface API_Service {

    @GET("user")
    Call<List<User>> getUser();

    @GET("vaccination_info")
    Call<List<Vaccination_info>> getVaccination_info();

    @GET("vaccine")
    Call<List<Vaccine>> getVaccine();

}
