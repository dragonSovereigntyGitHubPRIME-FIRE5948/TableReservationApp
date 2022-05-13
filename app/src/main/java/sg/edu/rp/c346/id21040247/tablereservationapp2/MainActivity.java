package sg.edu.rp.c346.id21040247.tablereservationapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText editnName;
    EditText editNumber;
    EditText editPax;

    ToggleButton toggleLocation1;
    ToggleButton toggleLocation2;
    ToggleButton toggleLocation3;
    ToggleButton toggleLocation4;
    ToggleButton toggleLocation5;


    TimePicker pickerTimePicker;
    DatePicker pickerDatePicker;

    CheckBox checkSmoking;

    Button btnReset;
    Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editnName = findViewById(R.id.name);
        editNumber = findViewById(R.id.number);
        editPax = findViewById(R.id.pax);
        pickerTimePicker = findViewById(R.id.timePicker);
        pickerDatePicker = findViewById(R.id.datePicker);
        checkSmoking = findViewById(R.id.smoking);

        btnEnter = findViewById(R.id.enter);
        btnReset = findViewById(R.id.reset);

        toggleLocation1 = findViewById(R.id.location1);
        toggleLocation2 = findViewById(R.id.location2);
        toggleLocation3 = findViewById(R.id.location3);
        toggleLocation4 = findViewById(R.id.location4);
        toggleLocation5 = findViewById(R.id.location5);

        pickerDatePicker.updateDate(2020, 6, 1);
        pickerTimePicker.setHour(19);
        pickerTimePicker.setMinute(30);

        toggleLocation1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            toggleLocation2.setChecked(false);
            toggleLocation3.setChecked(false);
            toggleLocation4.setChecked(false);
            toggleLocation5.setChecked(false);
            }
        });

        toggleLocation2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toggleLocation1.setChecked(false);
                toggleLocation3.setChecked(false);
                toggleLocation4.setChecked(false);
                toggleLocation5.setChecked(false);
            }
            });


            toggleLocation3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){

                toggleLocation2.setChecked(false);
                toggleLocation1.setChecked(false);
                toggleLocation4.setChecked(false);
                toggleLocation5.setChecked(false);
                }
            });


            toggleLocation4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        toggleLocation2.setChecked(false);
                        toggleLocation1.setChecked(false);
                        toggleLocation3.setChecked(false);
                        toggleLocation5.setChecked(false);
                    }
            });


            toggleLocation5.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       toggleLocation2.setChecked(false);
                       toggleLocation1.setChecked(false);
                       toggleLocation4.setChecked(false);
                       toggleLocation3.setChecked(false);
                   }
               });

        //RESET
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editnName.setText("");
                editNumber.setText("");
                editPax.setText("");
                editnName.setHint("Enter Name");
                editNumber.setHint("Enter Number");
                editPax.setHint("Enter No. of Pax");
                checkSmoking.setChecked(false);

                toggleLocation1.setChecked(false);
                toggleLocation2.setChecked(false);
                toggleLocation3.setChecked(false);
                toggleLocation4.setChecked(false);
                toggleLocation5.setChecked(false);


                pickerDatePicker.updateDate(2020, 6, 1);
                pickerTimePicker.setHour(19);
                pickerTimePicker.setMinute(30);

            }
        });


        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((editnName.getText().toString().trim().isEmpty()) ||
                        (editNumber.getText().toString().trim().isEmpty()) ||
                        (editPax.getText().toString().trim().isEmpty()) ||
                        (!toggleLocation1.isChecked()) && (!toggleLocation2.isChecked()) &&
                                (!toggleLocation3.isChecked()) && (!toggleLocation4.isChecked()) &&
                                (!toggleLocation5.isChecked())) {
                } else {

                    String smokingStatus = "Table with no Smoking Area";
                    String location = "";

                    if (checkSmoking.isChecked()){
                        smokingStatus = "Table with Smoking Area";
                    }

                    if (toggleLocation1.isChecked()){
                        location = "Sun Plaze";
                    }
                    if (toggleLocation2.isChecked()){
                        location = "Bugis+";
                    }
                    if (toggleLocation3.isChecked()){
                        location = "J Cube";
                    }
                    if (toggleLocation4.isChecked()){
                        location = "Junction 8";
                    }
                    if (toggleLocation5.isChecked()){
                        location = "Northpoint";
                    }


                    //very complicated to make Toast contain all the text
                    Toast.makeText(MainActivity.this,
                            "Name: " + editnName.getText() +"\n" +
                                    "Number: " + editNumber.getText() +"\n" +
                                    "No. of Pax" + editPax.getText() +"\n" +
                                    "Date: " + pickerDatePicker.getDayOfMonth()+"/"+pickerDatePicker.getMonth()+"/"+pickerDatePicker.getYear()+
                                    "Time: " + pickerTimePicker.getHour() + ":" + pickerTimePicker.getMinute()+
                                    "Location: " + location + "\n" +
                                    smokingStatus, Toast.LENGTH_LONG).show();


        }
            }
            });



    }
}