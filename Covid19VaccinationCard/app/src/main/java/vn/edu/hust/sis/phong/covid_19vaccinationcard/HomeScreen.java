package vn.edu.hust.sis.phong.covid_19vaccinationcard;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.User;
import vn.edu.hust.sis.phong.covid_19vaccinationcard.Model.Vaccination_info;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import java.util.ArrayList;
import java.util.List;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;


public class HomeScreen extends AppCompatActivity {

    ImageButton person_button;
    ImageButton setting_button;
    ImageButton logout_button;

    private ImageView qrCodeIV;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    List<Vaccination_info> vaccinationInfoList;
    private String str_dose_1_id;
    private String str_dose_2_id;

    public static final String msg_dose_1_id = "DOSE 1 ID";

    public static final String msg_dose_2_id = "DOSE 2 ID";

    String message;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        person_button = findViewById(R.id.person_button);
        setting_button = findViewById(R.id.setting_button);
        logout_button = findViewById(R.id.logout_button);

        Intent intent = getIntent();
        message = intent.getStringExtra(LoginForm.EXTRA_MESSAGE);
//        TextView textView = findViewById(R.id.title);
//        textView.setText(message);

        qrCodeIV = findViewById(R.id.idIVQrcode);

        vaccinationInfoList = new ArrayList<>();

        getListDose();

        person_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_person = new Intent(HomeScreen.this, Personal.class);

                startActivity(intent_person);
            }
        });

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_logout = new Intent(HomeScreen.this, LoginForm.class);
                startActivity(intent_logout);
            }
        });

        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("Not Available");
            }
        });

         {
                    // below line is for getting
                    // the windowmanager service.
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);

                    // initializing a variable for default display.
                    Display display = manager.getDefaultDisplay();

                    // creating a variable for point which
                    // is to be displayed in QR Code.
                    Point point = new Point();
                    display.getSize(point);

                    // getting width and
                    // height of a point
                    int width = point.x;
                    int height = point.y;

                    // generating dimension from width and height.
                    int dimen = width < height ? width : height;
                    dimen = dimen * 3 / 4;

                    // setting this dimensions inside our qr code
                    // encoder to generate our qr code.
                    qrgEncoder = new QRGEncoder("test QR code", null, QRGContents.Type.TEXT, dimen);
                    try {
                        // getting our qrcode in the form of bitmap.
                        bitmap = qrgEncoder.encodeAsBitmap();
                        // the bitmap is set inside our image
                        // view using .setimagebitmap method.
                        qrCodeIV.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        // this method is called for
                        // exception handling.
                        Log.e("Tag", e.toString());
                    }
         }

        for (Vaccination_info vaccination_info_get_dose : vaccinationInfoList){
            if(message.equals(vaccination_info_get_dose.getVaccinationInfoId())){

                str_dose_1_id = vaccination_info_get_dose.getVaccinationInjection1();
                str_dose_2_id = vaccination_info_get_dose.getVaccinationInjection2();

                textView = findViewById(R.id.title);
                textView.setText(str_dose_1_id);

            }
        }

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void QR_detail(View view) {
        Intent intent = new Intent(HomeScreen.this, MainActivity.class);
        Bundle extras = new Bundle();
        extras.putString(msg_dose_1_id,str_dose_1_id);
        extras.putString(msg_dose_2_id,str_dose_2_id);
        intent.putExtras(extras);
        startActivity(intent);
    }

    private void getListDose(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2/laravel_api/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API_Service retrofitAPI = retrofit.create(API_Service.class);

        Call<List<Vaccination_info>> call = retrofitAPI.getVaccination_info();

        call.enqueue(new Callback<List<Vaccination_info>>() {
            @Override
            public void onResponse(@NonNull Call<List<Vaccination_info>> call, @NonNull Response<List<Vaccination_info>> response) {
                vaccinationInfoList = response.body();

                Log.v("VACC", "VACC RESPONSE CODE: " + response.code());
            }

            @Override
            public void onFailure(@NonNull Call<List<Vaccination_info>> call, @NonNull Throwable t) {
                Log.e("VACC_TAG", "FAIL: " + t.getMessage());
            }
        });



    }

}