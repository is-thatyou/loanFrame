package com.loanframe.lfcibil.contract;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshu Goyal on 22/05/18.
 */

public class EmailAddressList {
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    static List<EmailAddressList> emailAddressList;
    static {
        emailAddressList = new ArrayList<>();
    }
    int index;

    public List<EmailAddressList> emaliInformation(String data)
    {
        String word ="EC03C0";
        for (int i = -1; (i = data.indexOf(word, i + 1)) != -1; i++)
        {
            EmailAddressList emails = new EmailAddressList();
            index = i;
            index = index+9;
            int length = Integer.parseInt(data.substring(index,index+2));
            index=index+2;
            emails.setEmailAddress(data.substring(index,index+length));
            emailAddressList.add(emails);
        }
        return emailAddressList;
    }
}


