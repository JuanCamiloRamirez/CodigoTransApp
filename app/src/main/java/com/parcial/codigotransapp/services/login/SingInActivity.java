package com.parcial.codigotransapp.services.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.parcial.codigotransapp.R;
import com.parcial.codigotransapp.services.Menu;
import com.parcial.codigotransapp.services.SingupActivity;

public class SingInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void registro(View view) {
        Intent intent = new Intent(this, SingupActivity.class);
        startActivity(intent);
    }

    public void acceder(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);

    }
}