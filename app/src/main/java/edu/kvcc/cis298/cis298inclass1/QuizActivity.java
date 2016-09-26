package edu.kvcc.cis298.cis298inclass1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.Log;        // Added to be able to use Log
=======
import android.util.Log;
>>>>>>> fa18512f5572484abe4715661e3bf2df77398547
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

<<<<<<< HEAD
        // Java vs C# note: final = const
    private static final String TAG = "QuizActivity";   // use with log.d(TAG, "comment to be saved")
    private static final String KEY_INDEX = "index";

        // Variable declarations to hold the widget controls for the layout:
=======
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    //Variable to hold the widget controls from the layout
>>>>>>> fa18512f5572484abe4715661e3bf2df77398547
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

<<<<<<< HEAD
        // Question bank array generation with new instances of the Question class:
        // Note: The constructor for a Question takes in an int and a bool -
        // R.string.questionName is actually an int that references a string in the R file.
=======
    //Our question bank. We are creating new instances of the Question
    //class, and putting them into the question array that is also being
    //declared here. The constructor for a Question takes in an integer
    //and a boolean. R.string.questionName is actually an integer that
    //references a string in the R file. That is why we are storing an
    //integer and not a string. We want the 'pointer' to the string, rather
    //than the string itself.
>>>>>>> fa18512f5572484abe4715661e3bf2df77398547
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

<<<<<<< HEAD
        // Declare a currentIndex variable for the current question index and initialize to 0:
=======
    //Add a index for which question we are on.
>>>>>>> fa18512f5572484abe4715661e3bf2df77398547
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

<<<<<<< HEAD
            // Log out that the onCreate method was fired (d stands for debug)
        Log.d(TAG, "onCreate(Bundle) called");

            // Use findViewById to get a reference to the TextView in the layout:
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

            // Prevent the app from resetting to the first question when screen rotates:
            // Check the Bundle to see if there is a savedInstanceState - if so, fetch
            // out the index to save as mCurrentIndex:
=======
        //Log out that the onCreate method was fired
        Log.d(TAG, "onCreate(Bundle) called");

        //Use findViewById to get a reference to the textview in the layout.
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        //Check the Bundle to see if it is null. If it is not,
        //we will fetch out the mCurrentIndex from it using the
        //same constant key KEY_INDEX that we used to put the
        //value in the bundle.
>>>>>>> fa18512f5572484abe4715661e3bf2df77398547
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX);
        }

<<<<<<< HEAD
            // Update the question:
        UpdateQuestion();

        // This uses findViewById to get a layout resource from the layout file.
            // We send in an integer that represents which resource we would like to get.
            // The method returns a View object, and we then need to down cast it to
            // a button class before we assign it.
        mTrueButton = (Button) findViewById(R.id.true_button);
            // This will set the OnClickListener for the true button.  It uses an
            // anonymous inner class to assign the listener.  We essentially create
            // the onClickListener class inside the setOnClassListener method, and
            // override the OnClick method. This makes it call the checkAnswer method
            // and pass TRUE as the boolean for the button clicked:
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
=======
        //Call the updateQuestion method.
        updateQuestion();


        //This uses the magical method findViewById to get a
        //layout resource from the layout file. We send in a
        //integer that represents what resource we would like
        //to get. The method returns a View object, and we then
        //need to down cast it to a Button class before we assign it.
        mTrueButton = (Button) findViewById(R.id.true_button);

        //This will set the onClickListener for the true button.
        //It uses an annonymous inner class to assign the listenter.
        //We essentailly create the onClikeListener class inside the
        //setOnClickListener method, and override the OnClick method
        //all at the same time.
        //All of our onclick listeners will look like this one.
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Call the checkAnswer method and send over a true
                //since they pushed the true button.
>>>>>>> fa18512f5572484abe4715661e3bf2df77398547
                checkAnswer(true);
            }
        });

            // Same as above, but for the false button:
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

<<<<<<< HEAD
            // The Next Button:
=======
        //The Next Button
>>>>>>> fa18512f5572484abe4715661e3bf2df77398547
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                    // Increment the index and mod it by the length of the array (loops):
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                    // Update the question:
                UpdateQuestion();
            }
        });


    }

    private void UpdateQuestion() {
            // Use the currentIndex to get the question in the array at that index, and
            // call the getTextResId method to get the associated string resource ID:
        int question = mQuestionBank[mCurrentIndex].getmTextResID();
            // Set the text for the next question, using the int resource ID from array:
        mQuestionTextView.setText(question);
    }

    private void checkAnswer (boolean userPressedTrue) {
            // Sets the bool to the same as whether the question is T or F:
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswerTrue();

            // Integer to hold the resource ID of the correct/incorrect message:
        int messageResId = 0;

            // If the answer is the correct answer, set toast message:
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        }
        else
        {
            messageResId = R.string.incorrect_toast;
        }

            // Display toast message:
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

        // This method is called right before onPause() is called.
        // This is where you should use the passed in Bundle to save the status.
        // The Bundle has methods in it to put values in a key => value way.
        // We are using putInt to store the mCurrentIndex under the KEY_INDEX.
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSavedInstanceState() called");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

        // The following methods log the activities stated:
=======
                //Increment the index, and mod it by the length of the array.
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                //Call the update question method.
                updateQuestion();
            }
        });

    }

    private void updateQuestion() {
        //Use the currentIndex to get the question in the array at that
        //index, and also call the getTextResId method (Property) to get
        //the associated string resource id.
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        //Set the text for the question. Using the integer resource id
        //that was fetched out from the array of questions.
        mQuestionTextView.setText(question);
    }

    //A  method to check whether the answer is correct or not,
    //and then toast out an associated message.
    private void checkAnswer(boolean userPressedTrue) {
        //Bool to represent the answer to the question we are on.
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        //Integer to hold the resource id of the correct/incorrect message
        //to display in the toast message
        int messageResId = 0;

        //If the user's press equals the questions answer
        if (userPressedTrue == answerIsTrue) {
            //Set the message to the correct message
            messageResId = R.string.correct_toast;
        } else {
            //Else the incorrect message
            messageResId = R.string.incorrect_toast;
        }
        //Make the toast using the assigned message
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    //This method is called right before onPause is called.
    //This is where you should use the passed in Bundle to save
    //the state of the activity. The Bundle has methods on it
    //to put values in a key => value type of way.
    //We are using putInt to store the mCurrentIndex in the bundle
    //under a key of KEY_INDEX. KEY_INDEX is really a const declared
    //at the top of this class.
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSavedInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

>>>>>>> fa18512f5572484abe4715661e3bf2df77398547
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
<<<<<<< HEAD
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
=======
>>>>>>> fa18512f5572484abe4715661e3bf2df77398547
    }

        // We don't need these:
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }


    //We don't need these
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
