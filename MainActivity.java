package com.example.root.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_user, tv_password;
    EditText et_user,et_password;
    Button show_user, show_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_user = (TextView)findViewById(R.id.user);
        tv_password =(TextView)findViewById(R.id.password);

        et_user = (EditText)findViewById(R.id.et_user);
        et_password = (EditText)findViewById(R.id.et_password);

        show_user = (Button)findViewById(R.id.show_user);
        show_password = (Button)findViewById(R.id.show_password);

        show_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetPreference("u", et_user.getText().toString());
                SavePreference();
            }
        });

        show_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetPreference("p", et_password.getText().toString());
                SavePreference();
            }
        });
    }

    public void SetPreference(String key, String value){
        SharedPreferences sharedPreferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();        //Set a set of String values in the preferences editor, to be written
        editor.putString(key,value);
        editor.commit();
    }

    public void SavePreference(){
        SharedPreferences sharedPreferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        String user = sharedPreferences.getString("u","");
        String password = sharedPreferences.getString("p","");
        tv_user.setText(user);
        tv_password.setText(password);
    }
}
