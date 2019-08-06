package com.loanframe.lfcibil.contract;

import java.util.ArrayList;
import java.util.List;

public class ResponseScoreSegment {
    static List<ResponseScoreSegment> scoreSegmentsList;
    private int score;
    private String scoreName;

    {
        scoreSegmentsList = new ArrayList<>();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    public List<ResponseScoreSegment> scoreDetails(String tuefResponse) {
        String word1 = "SC07";
        String word2 = "SC10";
        String word = "";
        int index = 0;
        int length = 0;
        if (tuefResponse.indexOf(word1, 0) > 0) {
            word = word1;
        }
        if (tuefResponse.indexOf(word2, 0) > 0) {
            word = word2;
        }

        for (index = -1; (index = tuefResponse.indexOf(word, index + 1)) != -1; index++) {
            ResponseScoreSegment responseEnquirySegment = new ResponseScoreSegment();
            String tag = "";
            tag = tuefResponse.substring(index, index + 2);
            index = index + 2;
            if (tag.equals("SC")) {
                length = Integer.parseInt(tuefResponse.substring(index, index + 2));
                index = index + 2;
                responseEnquirySegment.setScoreName(tuefResponse.substring(index, index + length));
                index = index + length;
                index = index + 24;
            } else
                responseEnquirySegment.setScoreName("");
            tag = tuefResponse.substring(index, index + 2);
            index = index + 2;
            if (tag.equals("04")) {
                length = Integer.parseInt(tuefResponse.substring(index, index + 2));
                index = index + 2;
                responseEnquirySegment.setScore(Integer.parseInt(tuefResponse.substring(index, index + length)));
            }
            scoreSegmentsList.add(responseEnquirySegment);
        }
        return scoreSegmentsList;
    }
}
