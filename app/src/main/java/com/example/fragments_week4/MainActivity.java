package com.example.fragments_week4;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.menuFragmentContainer, new MenuFragment())
                    .commit();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.noteFragmentContainer, new NoteTakingFragment())
                    .commit();
        } else {
            setContentView(R.layout.activity_main);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new MenuFragment())
                    .commit();
        }
    }

    public void loadMenuFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new MenuFragment())
                .commit();
    }
}
