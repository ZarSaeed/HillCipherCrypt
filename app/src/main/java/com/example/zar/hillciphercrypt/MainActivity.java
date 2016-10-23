package com.example.zar.hillciphercrypt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
private String cipherString,plainString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //all fields from activityMain xmal
        final EditText plainText=(EditText) findViewById(R.id.plain_text);
        final TextView encryptText=(TextView) findViewById(R.id.encrypted_text);
        final TextView decrtyptText=(TextView) findViewById(R.id.decrypted_text);
        Button clear=(Button) findViewById(R.id.clear_button);
        Button encrypt=(Button) findViewById(R.id.encrypt_button);
        Button decrypt=(Button) findViewById(R.id.decrypt_button);

     //enryption will be done when encrypt button pressed and return an encrypted string.

       encrypt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               plainString = plainText.getText().toString();


               //checking if plain text string given by user not in pairs
               if (plainString.length() % 2 != 0) {


                   AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create(); //Read Update
                   alertDialog.setTitle("Required Pairs");
                   alertDialog.setMessage("Text is not in proper pairs");

                   alertDialog.setButton("Try with pair", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int which) {

                           plainText.setText("");
                           encryptText.setText("");
                       }
                   });

                   alertDialog.show();

               } else {

                   Encryption encryption = new Encryption(plainString);
                   encryptText.setText(encryption.encryption());
               }
           }
       });


        //the encrypted string from Encryption will be used here for decryption and return an decrypted plain text.
        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cipherString=encryptText.getText().toString();
                Decryption decryption=new Decryption(cipherString);
                decrtyptText.setText(decryption.decryption());

            }
        });

        //fields cleared on clear click
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                plainText.setText("");
                decrtyptText.setText("");
                encryptText.setText("");
            }
        });
    }
}
