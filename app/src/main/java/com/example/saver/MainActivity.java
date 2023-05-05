package com.example.saver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static Context MAIN_CONTEXT=null;
    public boolean exists=false;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        MAIN_CONTEXT=MainActivity.this;
        Button loginButton=findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                try{
                   RequestAync requestAync=new RequestAync();
                   requestAync.execute();
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public class RequestAync extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            TextView username=findViewById(R.id.editTextUsername);
            TextView password=findViewById(R.id.editTextPassword);
            exists=RestApi.loginRestApi(username.getText().toString(),password.getText().toString());
            return null;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.INVISIBLE);
            if(exists){
                //Toast.makeText(MainActivity.this,"Exists",Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(MainActivity.this, BarcodeScannerActivity.class);

                // Start the destination activity
               // startActivity(intent);
            }
            else{
                Toast.makeText(MainActivity.this,"Ask to sign in",Toast.LENGTH_LONG).show();
            }

        }

    }
}