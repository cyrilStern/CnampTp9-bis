package fr.canm.cyrilstern1.cnamptp9deuxiemeactivit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        Intent intent = new Intent (this,MyService.class);
        startService(intent);
    }
}