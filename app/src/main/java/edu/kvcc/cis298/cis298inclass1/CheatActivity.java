package edu.kvcc.cis298.cis298inclass1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

        // String keys for the intent:                    *Start of the name should be the package name
    private static final String EXTRA_ANSWER_IS_TRUE =
            "edu.kvcc.cis298.cis298inclass1.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN =
            "edu.kvcc.cis298.cis298inclass1.answer_shown";

        // newIntent method - receive packageContext and the correct answer, return the intent to get the activity started:
    public static Intent newIntent (Context packageContext, boolean answerIsTrue) {
            // Declare new Intent object:
        Intent i = new Intent(packageContext, CheatActivity.class);
            // Put an extra in the Intent to save the bool answerIsTrue (where to put value, where to get value):
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
            // Return the Intent to the activity that called it:
        return i;
    }

    // This will "decode" the intent that is returned when the activity is complete and return the value:
    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

        // Pulled variable:
    private boolean mAnswerIsTrue;

        // Widget variables:
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

            // Set bool for mAnswerIsTrue by getting Intent then pulling the boolean extra (default to false):
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

            // Assign to the class level widget variables:
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswer = (Button) findViewById(R.id.show_answer_button);

            // When ShowAnswer button is clicked, show the correct answer to the current question:
        mShowAnswer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                }
                else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                    // Set the return data for the activity:
                setAnswerShownResult(true);
            }
        });
    }

        // Starts a new intent to use as the object containing activity result data.
    private void setAnswerShownResult(boolean isAnswerShown) {
            // New Intent to store data:
        Intent data = new Intent();
            // Put in whether the answer is shown:
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
            // Set result to "ok" (other option is "cancelled") and add data info:
        setResult(RESULT_OK, data);
    }
}
