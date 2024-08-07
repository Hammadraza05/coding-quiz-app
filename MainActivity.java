package com.maddy.tech.codingquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {
            "Java was introduced in 1222?",
            "Java was made by Python?",
            "Java contains abstract classes?",
            "Java contains polymorphism?",
            "Java contains multiple inheritance?"
    };

    private boolean[] answers = {false, false, true, true, false};
    private int index = 0;
    private int score = 0;
    private Button yes;
    private Button no;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        textView2 = findViewById(R.id.textView2);

        textView2.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answers[index]) {
                    score++;
                }
                index++;
                if (index < questions.length) {
                    textView2.setText(questions[index]);
                } else {
                    textView2.setText("Your score: " + score);
                    yes.setEnabled(false);
                    no.setEnabled(false);
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answers[index]) {
                    score++;
                }
                index++;
                if (index < questions.length) {
                    textView2.setText(questions[index]);
                } else {
                    textView2.setText("Your score: " + score);
                    yes.setEnabled(false);
                    no.setEnabled(false);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
