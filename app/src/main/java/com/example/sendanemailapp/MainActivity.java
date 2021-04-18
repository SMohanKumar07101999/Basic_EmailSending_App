package com.example.sendanemailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Receiveraddress;
    private EditText Subject;
    private EditText Message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Receiveraddress = findViewById(R.id.Entertheemail);
        Subject = findViewById(R.id.enterthesubject);
        Message = findViewById(R.id.entermessage);
        Button buttonsend =findViewById(R.id.sendButton);
        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

    }

    private void sendMail() {
        String recipientlist = Receiveraddress.getText().toString();
        String[] recipient =  recipientlist.split(",");
        String subject = Subject.getText().toString();
        String message = Message.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an Email Client"));
    }
}