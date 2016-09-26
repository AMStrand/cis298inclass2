package edu.kvcc.cis298.cis298inclass1;

/**
 * Created by amahler4096 on 9/19/2016.
 */
public class Question {

    private int mTextResID;
    private int mCorrectAnswerResId;
    private int[] mChoiceResIds;


    // After typing the next part, right click and "Generate" to get the following getters and setters.
    public Question(int textResID, int correctAnswerResId, int[] choiceResIds) {
        mTextResID = textResID;
        mCorrectAnswerResId = correctAnswerResId;
        mChoiceResIds = choiceResIds;

    }

    public int getCorrectAnswerResId() {
        return mCorrectAnswerResId;
    }

    public void setCorrectAnswerResId(int correctAnswerResId) {
        mCorrectAnswerResId = correctAnswerResId;
    }

    public int[] getChoiceResIds() {
        return mChoiceResIds;
    }

    public void setChoiceResIds(int[] choiceResIds) {
        mChoiceResIds = choiceResIds;
    }

        // These are technically not properties - this is Java convention for getters and setters:
    public int getmTextResID() {
        return mTextResID;
    }

    public void setmTextResID(int mTextResID) {
        this.mTextResID = mTextResID;
    }


}
