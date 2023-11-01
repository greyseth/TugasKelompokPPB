package com.example.segitigacalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Triangle extends AppCompatActivity {
    String selected = "luas";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_triangle);

        ImageView illustration = findViewById(R.id.illustration);

        LinearLayout kelInputs = findViewById(R.id.kelInputs);
        EditText s1Input = findViewById(R.id.s1Input);
        EditText s2Input = findViewById(R.id.s2Input);
        EditText s3Input = findViewById(R.id.s3Input);

        LinearLayout luasInputs = findViewById(R.id.luasInputs);
        EditText aInput = findViewById(R.id.aInput);
        EditText tInput = findViewById(R.id.tInput);

        TextView resDisp = findViewById(R.id.resultDisp);
        TextView formulaDisp = findViewById(R.id.formulaDisp);

        Button kBtn = findViewById(R.id.kelilingBtn);
        Button lBtn = findViewById(R.id.luasBtn);
        Button backBtn = findViewById(R.id.backBtn);
        Button countBtn = findViewById(R.id.countBtn);

        //Luas is selected by default
        lBtn.setEnabled(false);

        //Button functions
        lBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected = "luas";
                lBtn.setEnabled(false);
                kBtn.setEnabled(true);

                lBtn.setBackground(ContextCompat.getDrawable(Triangle.this, R.drawable.text_main_bg));
                lBtn.setTextColor(ContextCompat.getColor(Triangle.this, R.color.white));
                lBtn.setTypeface(lBtn.getTypeface(), Typeface.BOLD);

                kBtn.setBackground(ContextCompat.getDrawable(Triangle.this, R.drawable.btn_bg_2_bg));
                kBtn.setTextColor(ContextCompat.getColor(Triangle.this, R.color.text_main));
                kBtn.setTypeface(kBtn.getTypeface(), Typeface.NORMAL);

                kelInputs.setVisibility(View.GONE);
                luasInputs.setVisibility(View.VISIBLE);

                illustration.setImageResource(R.drawable.triangleluas);
                formulaDisp.setText(R.string.triangle_luas);
            }
        });

        kBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected = "keliling";
                kBtn.setEnabled(false);
                lBtn.setEnabled(true);

                kBtn.setBackground(ContextCompat.getDrawable(Triangle.this, R.drawable.text_main_bg));
                kBtn.setTextColor(ContextCompat.getColor(Triangle.this, R.color.white));
                kBtn.setTypeface(kBtn.getTypeface(), Typeface.BOLD);

                lBtn.setBackground(ContextCompat.getDrawable(Triangle.this, R.drawable.btn_bg_2_bg));
                lBtn.setTextColor(ContextCompat.getColor(Triangle.this, R.color.text_main));
                lBtn.setTypeface(lBtn.getTypeface(), Typeface.NORMAL);

                kelInputs.setVisibility(View.VISIBLE);
                luasInputs.setVisibility(View.GONE);

                illustration.setImageResource(R.drawable.trianglekel);
                formulaDisp.setText(R.string.triangle_keliling);
            }
        });

        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected.equals("luas")) {
                    if (aInput.getText().toString().isEmpty() || tInput.getText().toString().isEmpty()) {
                        Toast.makeText(Triangle.this, "Nilai harus diisi!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double a = Double.parseDouble(aInput.getText().toString());
                    double t = Double.parseDouble(tInput.getText().toString());
                    double res = (a * t) / 2;

                    resDisp.setText("L = "+res);
                }else if (selected.equals("keliling")) {
                    if (s1Input.getText().toString().isEmpty() || s2Input.getText().toString().isEmpty() || s3Input.getText().toString().isEmpty()) {
                        Toast.makeText(Triangle.this, "Nilai harus diisi!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double s1 = Double.parseDouble(s1Input.getText().toString());
                    double s2 = Double.parseDouble(s2Input.getText().toString());
                    double s3 = Double.parseDouble(s3Input.getText().toString());
                    double res = s1 + s2 + s3;

                    resDisp.setText("K= "+res);
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Triangle.this, MainActivity.class));
            }
        });
    }
}