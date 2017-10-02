package edu.upc.eseiaat.pma.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private int ids_answers[] = {
            R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    };
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView textQuestion = (TextView)findViewById(R.id.textQuestion);
        textQuestion.setText(R.string.questionContent);

        String[] answers = getResources().getStringArray(R.array.answers);

        for (int i=0; i< ids_answers.length; i++) {
            RadioButton rb = (RadioButton) findViewById(ids_answers[i]);
            rb.setText(answers[i]);
        }

        final int correctAnswer = getResources().getInteger(R.integer.correctAnswer);

        final RadioGroup group = (RadioGroup) findViewById(R.id.answerGrup);

        Button btnCheck = (Button) findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = group.getCheckedRadioButtonId();
                int answer = -1;
                for(int i = 0; i < ids_answers.length; i++ ) {
                    if(ids_answers[i] == id) {
                        answer = i;
                    }
                }
                if (toast != null) {
                    toast.cancel();
                }
                if(answer == correctAnswer) {
                    toast = Toast.makeText(QuizActivity.this, R.string.correct, Toast.LENGTH_SHORT);
                } else{
                    toast = Toast.makeText(QuizActivity.this, R.string.incorrect, Toast.LENGTH_SHORT);
                }
                toast.show();

            }
        });
    }
}
