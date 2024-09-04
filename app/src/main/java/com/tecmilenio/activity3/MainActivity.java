package com.tecmilenio.activity3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        //onClick()
        Button button_click = findViewById(R.id.button_click);

        //onLongClick()
        Button buttonLongClick = findViewById(R.id.button_long_click);

        //onFocusChange()
        EditText editTextFocus = findViewById(R.id.edit_text_focus);

        //onKey()
        EditText editTextKey = findViewById(R.id.edit_text_key);

        //onTouch
        Button buttonTouch = findViewById(R.id.button_touch);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //onClick
        button_click.setOnClickListener(v -> {

            Toast.makeText(MainActivity.this, "Button click", Toast.LENGTH_SHORT).show();
            System.out.println("Clic"); // true indica que el evento ha sido manejado

        });

        //onLongClick()
        buttonLongClick.setOnLongClickListener(v -> {

            Toast.makeText(MainActivity.this, "Button Long Clicked!", Toast.LENGTH_SHORT).show();
            return true; // true indica que el evento ha sido manejado

        });

        //onFocusChange()
        editTextFocus.setOnFocusChangeListener((v, hasFocus) -> {

            if (hasFocus) {
                Toast.makeText(MainActivity.this, "EditText Focused", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "EditText Lost Focus", Toast.LENGTH_SHORT).show();
            }
        });
        //OnKey()
        editTextKey.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    Toast.makeText(MainActivity.this, "Enter key pressed", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        //OnTouch
        buttonTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(MainActivity.this, "Button Touched", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        } //OnCreate


} // MainActivity





