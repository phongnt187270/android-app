package vn.edu.hust.sis.phong.covid_19vaccinationcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.User;

public class LoginForm extends AppCompatActivity {

    private EditText edtPhonenumber;
    private EditText edtPassword;
    private Button btnLogin;

    List<User> userList;
    private String str_vaccination_info_id;

    public static final String EXTRA_MESSAGE =
            "SEND VACCINATION INFO ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        edtPhonenumber = findViewById(R.id.phone_input);
        edtPassword = findViewById(R.id.password_input);
        btnLogin = findViewById(R.id.login_button);

        userList = new ArrayList<>();
        getListUser();
    }

    public void Login(View view) {
        String strPhonenumber = edtPhonenumber.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();

        if (userList == null || userList.isEmpty()){
            return;
        }

        boolean isUser = false;
        for (User user : userList){
            if (strPhonenumber.equals(user.getPhonenumber()) && strPassword.equals(user.getPassword())){
                isUser = true;
                str_vaccination_info_id = user.getVaccinationInfoId();
                break;
            }
        }

        if(isUser){
            Intent intent = new Intent(LoginForm.this, HomeScreen.class);
            intent.putExtra(EXTRA_MESSAGE, str_vaccination_info_id);
            startActivity(intent);
        }else {
            Toast.makeText(LoginForm.this, "Phonenumber or Password invalid", Toast.LENGTH_SHORT).show();
        }

    }

    private void getListUser(){
        Retrofit API_user = new Retrofit.Builder().baseUrl("http://10.0.2.2/laravel_api/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API_Service userAPI = API_user.create(API_Service.class);

        Call<List<User>> call_user = userAPI.getUser();

        call_user.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList = response.body();

                Log.v("TAG", "LOGIN RESPONSE CODE: " + response.code());

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("TAG", "FAIL: " + t.getMessage());

            }
        });
    }

}