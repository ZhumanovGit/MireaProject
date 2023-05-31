package ru.mirea.zhumanov.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ProfileActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    String name;
    String mail;
    String number;

    public ProfileActivity(){
        super(R.layout.activity_profile);
    }
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Button btnSave = findViewById(R.id.buttonSave);
        EditText editName = findViewById(R.id.editTextName);
        EditText editNumber = findViewById(R.id.editTextPhone);
        EditText editMail = findViewById(R.id.editTextMail);

        sharedPref = getSharedPreferences("MIREA_settings", Context.MODE_PRIVATE);

        editName.setText(sharedPref.getString("NAME", "Name"));
        editNumber.setText(sharedPref.getString("MAIL", "Number"));
        editMail.setText(sharedPref.getString("NUMBER", "Mail"));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref = getSharedPreferences("MIREA_settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                name = editName.getText().toString();
                number = editNumber.getText().toString();
                mail = editMail.getText().toString();

                editor.putString("NAME", String.valueOf(name));
                editor.putString("MAIL", String.valueOf(number));
                editor.putString("NUMBER", String.valueOf(mail));

                editor.apply();

                Log.d(TAG, sharedPref.getString("NAME", "no inf"));
                Log.d(TAG, sharedPref.getString("MAIL", "no inf"));
                Log.d(TAG, sharedPref.getString("NUMBER", "no inf"));
            }
        });
    }
}