package edu.kvcc.cis298.cis298inclass1;

/**
 * Created by amahler4096 on 9/19/2016.
 */
public class Question {

    private int mTextResID;
    private boolean mAnswerTrue;

        // After typing the next part, right click and "Generate" to get the following getters and setters.
    public Question(int textResID, boolean answerTrue) {
        mTextResID = textResID;
        mAnswerTrue = answerTrue;
    }

        // These are technically not properties - this is Java convention for getters and setters:
    public int getmTextResID() {
        return mTextResID;
    }

    public void setmTextResID(int mTextResID) {
        this.mTextResID = mTextResID;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
