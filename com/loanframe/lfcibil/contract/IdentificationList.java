package com.loanframe.lfcibil.contract;

import com.loanframe.lfcibil.util.Utility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class IdentificationList {
    static List<IdentificationList> list;

    static {
        list = new ArrayList<>();
    }

    private String IDnumber;
    private String IDtype;
    private String issueDate;
    private String expiryDate;

    public String getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    public String getIDtype() {
        return IDtype;
    }

    public void setIDtype(String IDtype) {
        this.IDtype = IDtype;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<IdentificationList> identificationInformation(String str) {
        int index, i, length = 0;
        String word = "ID03I0";
        String tempData = "";
        for (i = -1; (i = str.indexOf(word, i - 1)) != -1; i++) {
            IdentificationList obj = new IdentificationList();
            i = i + 7;
            String tag = str.substring(i, i + 2);
            if (tag.equals("01")) {
                i = i + 4;
                String demo = str.substring(i, i + 2);
                i = i + 2;
                if (demo.equals("01"))
                    obj.setIDtype("Income Tax ID Number (PAN)");
                if (demo.equals("02"))
                    obj.setIDtype("Passport Number");
                if (demo.equals("03"))
                    obj.setIDtype("Voter ID Number");
                if (demo.equals("04"))
                    obj.setIDtype("Driver’s License Number");
                if (demo.equals("05"))
                    obj.setIDtype("Ration Card Number");
                if (demo.equals("06"))
                    obj.setIDtype("Universal ID Number (UID)");


                tag = str.substring(i, i + 2);
            }


            if (tag.equals("02")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setIDnumber(str.substring(i, i + length));
                i = i + length;


                tag = str.substring(i, i + 2);
            }
            if (tag.equals("03")) {

                i = i + 4;
                tempData = str.substring(i, i + 8);
                try {
                    obj.setIssueDate(Utility.formatStringToDate(tempData));
                } catch (ParseException exception) {
                    exception.printStackTrace();
                }

                i = i + 8;

                tag = str.substring(i, i + 2);
            }
            if (tag.equals("04")) {

                i = i + 4;
                tempData = str.substring(i, i + 8);
                try {
                    obj.setExpiryDate(Utility.formatStringToDate(tempData));
                } catch (ParseException exception) {
                    exception.printStackTrace();
                }
                i = i + 8;

            }
            list.add(obj);
        }
        return list;
    }
}
