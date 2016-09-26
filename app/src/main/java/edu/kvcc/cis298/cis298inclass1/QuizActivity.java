package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;            // Added to use log
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;  // Added to use radio buttons
import android.widget.RadioGroup;   // Added to use radio group
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

        // Variable declarations to hold the widget controls for the layout:

    private Button mNextButton;
    private TextView mQuestionTextView;

    private RadioGroup mQuestionGroup;
    private RadioButton mChoice1;
    private RadioButton mChoice2;
    private RadioButton mChoice3;
    private RadioButton mChoice4;
    private Button mSubmitButton;

        // Question bank array generation with new instances of the Question class:
        // Note: The constructor for a Question takes in an int and a bool -
        // R.string.questionName is actually an int that references a string in the R file.
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_1_multiple, R.id.multiple_choice_3, new int[]{
                    R.string.question_1_choice_1,
                    R.string.question_1_choice_2,
                    R.string.question_1_choice_3,
                    R.string.question_1_choice_4
            }),
            new Question(R.string.question_2_multiple, R.id.multiple_choice_2, new int[]{
                    R.string.question_2_choice_1,
                    R.string.question_2_choice_2,
                    R.string.question_2_choice_3,
                    R.string.question_2_choice_4
            })
    };

        // Declare a currentIndex variable for the current question index and initialize to 0:
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

            // Use findViewById to get a reference to the textview in the layout:
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mChoice1 = (RadioButton) findViewById(R.id.multiple_choice_1);
        mChoice2 = (RadioButton) findViewById(R.id.multiple_choice_2);
        mChoice3 = (RadioButton) findViewById(R.id.multiple_choice_3);
        mChoice4 = (RadioButton) findViewById(R.id.multiple_choice_4);

        mQuestionGroup = (RadioGroup) findViewById(R.id.multiple_group);

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSubmitButton.setText(R.string.submit_button);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // Query the radio button group to find out which radio button was selected.
                    // Store the ID of the selected one as selectedAnswerId:
                int selectedAnswerId = mQuestionGroup.getCheckedRadioButtonId();
                    // Call the checkAnswer method and pass the selected answer:
                checkAnswer(selectedAnswerId);
            }
        });

        // Update the question:
        UpdateQuestion();

            // The Next Button:
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // Increment the index and mod it by the length of the array (loops):
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                    // Update the question:
                UpdateQuestion();
            }
        });


    }

    private void UpdateQuestion() {
            // Clear the previously selected radio button for the next question:
        mQuestionGroup.clearCheck();

            // Use the currentIndex to get the question in the array at that index, and
            // call the getTextResId method to get the associated string resource ID:
        int question = mQuestionBank[mCurrentIndex].getmTextResID();

            // Set the text for the next question, using the int resource ID from array:
        mQuestionTextView.setText(question);

            // Fetch the question choice strings from the question object:
        int[] choices = mQuestionBank[mCurrentIndex].getChoiceResIds();

            // Assign each question choice text to the text property of the radio button:
        mChoice1.setText(choices[0]);
        mChoice2.setText(choices[1]);
        mChoice3.setText(choices[2]);
        mChoice4.setText(choices[3]);
    }

    private void checkAnswer (int selectedAnswer) {
            // The current question's correct radio button id:
        int correctAnswer = mQuestionBank[mCurrentIndex].getCorrectAnswerResId();

            // Integer to hold the resource ID of the correct/incorrect message:
        int messageResId = 0;

            // If the answer is the correct answer, set toast message:
        if (selectedAnswer == correctAnswer) {
            messageResId = R.string.correct_toast;
        }
        else
        {
            messageResId = R.string.incorrect_toast;
        }

            // Display toast message:
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

            //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
