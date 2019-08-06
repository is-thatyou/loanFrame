package com.loanframe.lfcibil.contract;

public class ResponseEndSegment {
    private int lengthOfTransmission;



    public int  responselength(String str) {
        String word = "ES07", tag;
        int i = 0;
        for (i = -1; (i = str.indexOf(word, i )) != -1; i++) {
            i=i+4;
            lengthOfTransmission = Integer.parseInt(str.substring(i,i+7));
        }
        return lengthOfTransmission;

    }
}
