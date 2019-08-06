package com.loanframe.lfcibil.contract;

import com.loanframe.lfcibil.util.Utility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ContactInformationList {

    List<ContactInformationList> addressList = new ArrayList<>();
    private String address;
    private String stateCode;
    private String pin;
    private String category;
    private String residenceCode;
    private String dateReported;
    private String memberSName;
    private String status;
    private String enrichedThrEnquiry;

    public ContactInformationList() {
    }

    public static String[] addressDelt(String tuefResponse, int index) {
        String tempData;
        String[] str = new String[2];
        int length = Integer.parseInt(tuefResponse.substring(index, index + 2));
        index = index + 2;
        tempData = tuefResponse.substring(index, index + length);
        index = index + length;
        str[0] = String.valueOf(index);
        str[1] = tempData;
        return str;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getResidenceCode() {
        return residenceCode;
    }

    public void setResidenceCode(String residenceCode) {
        this.residenceCode = residenceCode;
    }

    public String getDateReported() {
        return dateReported;
    }

    public void setDateReported(String dateReported) {
        this.dateReported = dateReported;
    }

    public String getMemberSName() {
        return memberSName;
    }

    public void setMemberSName(String memberSName) {
        this.memberSName = memberSName;
    }

    public String getEnrichedThrEnquiry() {
        return enrichedThrEnquiry;
    }

    public void setEnrichedThrEnquiry(String enrichedThrEnquiry) {
        this.enrichedThrEnquiry = enrichedThrEnquiry;
    }

    public List<ContactInformationList> addressInformation(String tuefResponse) {
        String word = "PA03A0";
        int index = 0;
        String tempData = "";
        for (index = -1; (index = tuefResponse.indexOf(word, index + 1)) != -1; index++) {
            ContactInformationList contactInformationList = new ContactInformationList();
            String tag = "";
            index = index + 7;
            tag = tuefResponse.substring(index, index + 2);
            index = index + 2;
            if (tag.equals("01")) {
                String[] arguments = new ContactInformationList().addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                tempData = arguments[1];
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            } else
                tempData = tempData;
            if (tag.equals("02")) {
                String[] arguments = new ContactInformationList().addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                tempData = tempData + " " + arguments[1];
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            } else
                tempData = tempData;
            if (tag.equals("03")) {
                String[] arguments = new ContactInformationList().addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                tempData = tempData + " " + arguments[1];
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            } else
                tempData = tempData;
            if (tag.equals("04")) {
                String[] arguments = ContactInformationList.addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                tempData = tempData + " " + arguments[1];
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            } else
                tempData = tempData;
            if (tag.equals("05")) {
                String[] arguments = ContactInformationList.addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                tempData = tempData + " " + arguments[1];
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            } else {
                tempData = tempData;
                contactInformationList.setAddress(tempData);
            }
            if (tag.equals("06")) {
                String[] arguments = ContactInformationList.addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                contactInformationList.setStateCode(arguments[1]);
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            }
            if (tag.equals("07")) {
                String[] arguments = ContactInformationList.addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                contactInformationList.setPin(arguments[1]);
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            } else {
                contactInformationList.setPin("");
            }
            if (tag.equals("08")) {
                String[] arguments = ContactInformationList.addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                tempData = arguments[1];
                if (tempData.equals("01")) {
                    contactInformationList.setCategory("Permanent Address");
                } else if (tempData.equals("02")) {
                    contactInformationList.setCategory("Residence Address");
                } else if (tempData.equals("03")) {
                    contactInformationList.setCategory("Office Address");
                } else {
                    contactInformationList.setCategory("Not Categorized");
                }
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            } else
                contactInformationList.setCategory("");
            if (tag.equals("09")) {
                String[] arguments = ContactInformationList.addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                tempData = arguments[1];
                if (tempData.equals("01")) {
                    contactInformationList.setResidenceCode("Owned");
                } else {
                    contactInformationList.setResidenceCode("Rented");
                }
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            } else {
                contactInformationList.setResidenceCode("");
            }
            if (tag.equals("10")) {
                String[] arguments = ContactInformationList.addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                try {
                    tempData = Utility.formatStringToDate(arguments[1]);
                    contactInformationList.setDateReported(tempData);
                } catch (ParseException exception) {
                    exception.printStackTrace();
                }
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            } else
                contactInformationList.setDateReported("");
            if (tag.equals("11")) {
                String[] arguments = ContactInformationList.addressDelt(tuefResponse, index);
                index = Integer.parseInt(arguments[0]);
                contactInformationList.setEnrichedThrEnquiry(arguments[1]);
                tag = tuefResponse.substring(index, index + 2);
                index = index + 2;
            } else
                contactInformationList.setEnrichedThrEnquiry("");
            if (tag.equals("90")) {
                String[] arguments = ContactInformationList.addressDelt(tuefResponse, index);
                contactInformationList.setEnrichedThrEnquiry(arguments[1]);
            }
            addressList.add(contactInformationList);
        }
        return addressList;

    }

}
