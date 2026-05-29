package com.example.drawables_styles_themes;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private TextView mScoreText1;
    private TextView mScoreText2;

    private int mScore1 = 0;
    private int mScore2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);
    }

    // Decrease buttons onClick
    public void decreaseScore(View view) {
        int viewID = view.getId();
        if (viewID == R.id.decreaseTeam1) {
            mScore1--;
            mScoreText1.setText(String.valueOf(mScore1));
        } else if (viewID == R.id.decreaseTeam2) {
            mScore2--;
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    // Increase buttons onClick
    public void increaseScore(View view) {
        int viewID = view.getId();
        if (viewID == R.id.increaseTeam1) {
            mScore1++;
            mScoreText1.setText(String.valueOf(mScore1));
        } else if (viewID == R.id.increaseTeam2) {
            mScore2++;
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
