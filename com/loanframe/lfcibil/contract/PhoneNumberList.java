package com.loanframe.lfcibil.contract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshu Goyal on 22/05/18.
 */
public class PhoneNumberList {

    private String extension;
    private String number;
    private String type;

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PhoneNumberList()
    {}
    static List<PhoneNumberList> phoneNumberList = new ArrayList<>();
    public List<PhoneNumberList> parseNumuber(String data) {
        int index = 0;
        int index1 = 0;
        String word = "PT03T0";
        for (int i = -1; (i = data.indexOf(word, i + 1)) != -1; i++) {
            PhoneNumberList obj = new PhoneNumberList();
            index = i;
            index = index + 7;
            String tag = data.substring(index, index + 2);
            index = index + 2;
            if (tag.equals("01")) {
                int length = Integer.parseInt(data.substring(index, index + 2));
                index = index + 2;
                 obj.setNumber(data.substring(index, index + length));
            }
            index1 = i;
            index1 = index1 + 9;
            int length2 = Integer.parseInt(data.substring(index1, index1 + 2));
            index1 = index1 + length2 + 2;
            String tag2 = data.substring(index1, index1 + 2);
            index1 = index1 + 2;
            if (tag2.equals("02")) {
                int length3 = Integer.parseInt(data.substring(index1, index1 + 2));
                index1 = index1 + 2;
                obj.setExtension(data.substring(index1, index1 + length3));
                index1 = index1 + length3;
                tag2 = data.substring(index1, index1 + 2);
                if (tag2.equals("03")) {
                    obj.setType(new PhoneNumberList().numberType(tag2));
                }
            } else if (tag2.equals("03")) {
                obj.setType(new PhoneNumberList().numberType(tag2));
            }
            phoneNumberList.add(obj);
        }
        return phoneNumberList;
    }
    private String numberType(String tag) {
        if (tag.equals("01")) {
            return "Mobile Phone";
        } else if (tag.equals("02")) {
            return "Home Phone";
        } else if (tag.equals("03")) {
            return "Office Phone";
        } else
            return "Not Classified";
    }
}




