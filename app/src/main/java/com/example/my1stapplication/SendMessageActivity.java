package com.example.my1stapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SendMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra("nomePessoa");
        TextView textView = findViewById(R.id.txtNomePessoaCompleto);
        textView.setText(message);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this,SendMessageActivity.class);
        PendingIntent pi= PendingIntent.getActivity(this, 0, intent,PendingIntent.FLAG_IMMUTABLE);

        EditText phone = (EditText) findViewById(R.id.editTextPhone);
        TextView nome = (TextView) findViewById(R.id.txtNomePessoaCompleto);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phone.getText().toString(), null, "Oi " + nome.getText().toString(), pi,null);

        Intent ib = new Intent(this,MainActivity.class);
        startActivity(ib);
    }
}