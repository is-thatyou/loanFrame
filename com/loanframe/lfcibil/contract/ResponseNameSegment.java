package com.loanframe.lfcibil.contract;//package contract.cibil.fin360;

import com.loanframe.lfcibil.util.Utility;

import java.text.ParseException;

public class ResponseNameSegment {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String errorSegment;
    private String dateOfErrorCode;
    private String errorCode;
    private String dateOfCibilRemarksCode;
    private String cibilRemarksCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name == null)
            this.name = name;
        else
            this.name = this.name + name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getErrorSegment() {
        return errorSegment;
    }

    public void setErrorSegment(String errorSegment) {
        this.errorSegment = errorSegment;
    }

    public String getDateOfErrorCode() {
        return dateOfErrorCode;
    }

    public void setDateOfErrorCode(String dateOfErrorCode) {
        this.dateOfErrorCode = dateOfErrorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDateOfCibilRemarksCode() {
        return dateOfCibilRemarksCode;
    }

    public void setDateOfCibilRemarksCode(String dateOfCibilRemarksCode) {
        this.dateOfCibilRemarksCode = dateOfCibilRemarksCode;
    }

    public String getCibilRemarksCode() {
        return cibilRemarksCode;
    }

    public void setCibilRemarksCode(String cibilRemarksCode) {
        this.cibilRemarksCode = cibilRemarksCode;
    }


    public ResponseNameSegment nameDetails(String str) {
        int i = str.indexOf("PN03N01");
        i = i + 7;
        String tempData = "";
        ResponseNameSegment obj = new ResponseNameSegment();
        String tag = str.substring(i, i + 2);
        while (tag.equals("01") || tag.equals("02") || tag.equals("03") || tag.equals("04") || tag.equals("05")) {
            i = i + 2;
            int length = Integer.parseInt(str.substring(i, i + 2));
            i = i + 2;
            //System.out.println(str.substring(i, i + length) + " ");
            obj.setName(str.substring(i, i + length) + " ");
            i = i + length;
            tag = str.substring(i, i + 2);
        }
        while (tag.equals("07")) {
            i = i + 4;
            tempData = str.substring(i, i + 8);
            try {
                obj.setDateOfBirth(Utility.formatStringToDate(tempData));
            } catch (ParseException exception) {
                exception.printStackTrace();
            }

            i = i + 8;
            tag = str.substring(i, i + 2);
        }


        while (tag.equals("08")) {
            i = i + 4;
            obj.setGender(str.substring(i, i + 1));
            i = i + 1;
            tag = str.substring(i, i + 2);
        }

        while (tag.equals("81")) {
            i = i + 4;
            obj.setErrorSegment(str.substring(i, i + 2));
            i = i + 2;
            tag = str.substring(i, i + 2);
        }

        while (tag.equals("82")) {
            i = i + 4;
            obj.setErrorCode(str.substring(i, i + 3));
            i = i + 3;
            tag = str.substring(i, i + 2);
        }

        while (tag.equals("83")) {
            i = i + 4;
            tempData = str.substring(i, i + 8);
            try {
                obj.setDateOfCibilRemarksCode(Utility.formatStringToDate(tempData));
            } catch (ParseException exception) {
                exception.printStackTrace();
            }

            i = i + 8;
            tag = str.substring(i, i + 2);
        }

        while (tag.equals("84")) {
            i = i + 4;
            obj.setCibilRemarksCode(str.substring(i, i + 6));
            i = i + 6;
            tag = str.substring(i, i + 2);
        }
        return obj;
    }
}
