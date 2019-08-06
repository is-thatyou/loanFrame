package com.loanframe.lfcibil.contract;

import java.util.ArrayList;
import java.util.List;

public class ResponseAccountNumber {

    private String accountNumber;

    public String getResponseAccountNumber() {
        return accountNumber;
    }

    public void setResponseAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

     List<ResponseAccountNumber> list;
     {
        list = new ArrayList<>();
    }



    public List<ResponseAccountNumber> enquiryAccountNumber(String str)
    {

    int i;
    String tag="";
    String word="PI03I0";
    for (i = -1; (i = str.indexOf(word, i-1 )) != -1; i++)
    {
        ResponseAccountNumber obj = new ResponseAccountNumber();
        i=i+7;
        tag=str.substring(i,i+2);
        if(tag.equals("01"))
        {
            i=i+2;
            int length = Integer.parseInt(str.substring(i, i + 2));
            i=i+2;
            obj.setResponseAccountNumber(str.substring(i,i+length));
            i=i+length;
            tag=str.substring(i,i+2);
        }
        list.add(obj);
    }
    return list;
    }
}
