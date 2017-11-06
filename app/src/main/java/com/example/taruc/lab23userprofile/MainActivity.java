package com.example.taruc.lab23userprofile;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_PPROFILE_UPDATE = 1;
    public static final String USER_ID = "com.example.taruc.lab23userprofile.ID";
    public static final String USER_EMAIL = "com.example.taruc.lab23userprofile.EMAIL";
    private TextView textViewID,textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Linking UI to program
        textViewID = (TextView)findViewById(R.id.textViewID);
        textViewEmail = (TextView)findViewById(R.id.textViewEmail);
    }
    public void editProfile(View view){
        //An explicit intent
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivityForResult(intent,REQUEST_PPROFILE_UPDATE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestCode = The unique code that your activity sent with an intent
        //resultCode = Store either OK or cancel
        //data = The data returned from an intent
        super.onActivityResult(requestCode, resultCode, data);


        //if(requestCode == REQUEST_PPROFILE_UPDATE && resultCode == RESULT_OK)
        if(requestCode == REQUEST_PPROFILE_UPDATE){
            String id,email;
            id = data.getStringExtra(USER_ID);
            email = data.getStringExtra(USER_EMAIL);
            //Display data on UI
            textViewID.setText(getString(R.string.id)+"  " + id);
            textViewEmail.setText(getString(R.string.email)+"  "+email);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main Activity","onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main Activity","onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Main Activity","onResume");
    }
    public void showSendTo(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:" + "lamjs-wa15@student.tarc.edu.mya"));
        startActivity(intent);
    }

}
