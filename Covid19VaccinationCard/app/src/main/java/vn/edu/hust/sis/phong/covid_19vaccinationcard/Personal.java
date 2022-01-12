package vn.edu.hust.sis.phong.covid_19vaccinationcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Personal extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        Spinner gender_spinner = findViewById(R.id.gender_spinner);
        if (gender_spinner != null) {
            gender_spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> gender_adapter = ArrayAdapter.createFromResource(this,
                R.array.genders_array, android.R.layout.simple_spinner_item);

        gender_adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (gender_spinner != null) {
            gender_spinner.setAdapter(gender_adapter);
        }

        Spinner date_spinner = findViewById(R.id.date_spinner);
        if (date_spinner != null) {
            date_spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> date_adapter = ArrayAdapter.createFromResource(this,
                R.array.date_array, android.R.layout.simple_spinner_item);

        date_adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (date_spinner != null) {
            date_spinner.setAdapter(date_adapter);
        }

        Spinner month_spinner = findViewById(R.id.month_spinner);
        if (month_spinner != null) {
            month_spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> month_adapter = ArrayAdapter.createFromResource(this,
                R.array.month_array, android.R.layout.simple_spinner_item);

        month_adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (month_spinner != null) {
            month_spinner.setAdapter(month_adapter);
        }

        Spinner year_spinner = findViewById(R.id.year_spinner);
        if (year_spinner != null) {
            year_spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> year_adapter = ArrayAdapter.createFromResource(this,
                R.array.year_array, android.R.layout.simple_spinner_item);

        year_adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (year_spinner != null) {
            year_spinner.setAdapter(year_adapter);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int
            i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveInfo(View view) {
        Toast.makeText(getApplicationContext(), "Saved",
                Toast.LENGTH_SHORT).show();
    }
}