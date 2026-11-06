package com.example.smsintent;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber, smsMessage;
    Button sendSMS;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        phoneNumber = findViewById(R.id.phoneNumber);
        smsMessage = findViewById(R.id.smsMessage);
        sendSMS = findViewById(R.id.sendSMS);

        sendSMS.setOnClickListener(v -> {

            String number = phoneNumber.getText().toString().trim();
            String message = smsMessage.getText().toString().trim();

            if (number.isEmpty()) {

                toast = Toast.makeText(
                        MainActivity.this,
                        "Please enter mobile number",
                        Toast.LENGTH_SHORT
                );
                toast.show();

            }
            else if (message.isEmpty()) {

                toast = Toast.makeText(
                        MainActivity.this,
                        "Please enter SMS message",
                        Toast.LENGTH_SHORT
                );
                toast.show();

            }
            else {

                Intent intent = new Intent(Intent.ACTION_SENDTO);

                intent.setData(Uri.parse("smsto:" + Uri.encode(number)));

                intent.putExtra("sms_body", message);

                if (intent.resolveActivity(getPackageManager()) != null) {

                    startActivity(intent);

                }
                else {

                    toast = Toast.makeText(
                            MainActivity.this,
                            "No SMS application found",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();

                }
            }
        });
    }
}