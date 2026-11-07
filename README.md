# Ex.No: 3 – Design an Android Application to Send SMS Using Intent

## AIM:

To create and design an Android application to send SMS using Intent in Android Studio.

## EQUIPMENTS REQUIRED:

- Android Studio (Latest Version)
- Java Programming Language
- XML

## ALGORITHM:

**Step 1:** Open Android Studio and click on File → New → New Project.

**Step 2:** Enter the application name as `SMSIntent` and click Next.

**Step 3:** Select the Minimum SDK as required and click Next.

**Step 4:** Select Empty Views Activity and click Next. Finally, click Finish.

**Step 5:** Design the user interface in the `activity_main.xml` file using EditText and Button components.

**Step 6:** Open the `MainActivity.java` file and write the Java code to handle the button click event.

**Step 7:** Create an implicit Intent using `Intent.ACTION_SENDTO` and use the `smsto:` URI to open the default SMS application.

**Step 8:** Pass the mobile number and SMS message using Intent extras.

**Step 9:** Save and run the application.

## PROGRAM:

### 1. MainActivity.java

```java
/*
Program to create and design an Android application
to send SMS using Intent.

Developed by: Iyyappan S
Register Number: YOUR_REGISTER_NUMBER
*/

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

            } else if (message.isEmpty()) {

                toast = Toast.makeText(
                        MainActivity.this,
                        "Please enter SMS message",
                        Toast.LENGTH_SHORT
                );
                toast.show();

            } else {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + Uri.encode(number)));
                intent.putExtra("sms_body", message);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {

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
```

### 2. activity_main.xml

Design the application interface with the following components:

- TextView – Application heading.
- EditText – Mobile number.
- EditText – SMS message.
- Button – Send SMS.

### 3. AndroidManifest.xml

Configure the application activity and launcher intent filter.

**Note:** `SEND_SMS` permission is not required because the application opens the default SMS application using an implicit Intent. The user manually sends the message.

## OUTPUT:
<img width="1672" height="941" alt="image" src="https://github.com/user-attachments/assets/cdccdc6a-6c38-41f8-b355-cc3c8c2387e7" />
<img width="941" height="1672" alt="image" src="https://github.com/user-attachments/assets/5124ba39-596c-4205-8be2-b99055f959cc" />



## RESULT:

Thus, a simple Android application to send SMS using Intent was successfully created, designed, developed, and executed using Android Studio.
