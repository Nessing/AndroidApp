package ru.nessing.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String SAVED = "SAVED";
    Buttons buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new Buttons();
        buttons.create(this);

        findViewById(R.id.open_setting).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivitySetting.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED, buttons.getOut());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        buttons.getFieldInput().setText(savedInstanceState.getString(SAVED));
    }

    @Override
    public void onClick(View view) {
        buttons.onClick(view);
    }
}