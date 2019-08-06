package com.loanframe.lfcibil.contract;
/*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
*/

import com.loanframe.lfcibil.util.Utility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anshu Goyal on 22/05/18.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class EnquiryInformationList {
    public String enquiryPurpose;
    public String dateOfEnquiry;
    public String enquiryAmount;
    public String memberName;

    public String getEnquiryPurpose() {
        return enquiryPurpose;
    }

    public void setEnquiryPurpose(String enquiryPurpose) {
        this.enquiryPurpose = enquiryPurpose;
    }

    public String getDateOfEnquiry() {
        return dateOfEnquiry;
    }

    public void setDateOfEnquiry(String dateOfEnquiry) {
        this.dateOfEnquiry = dateOfEnquiry;
    }

    public String getEnquiryAmount() {
        return enquiryAmount;
    }

    public void setEnquiryAmount(String enquiryAmount) {
        this.enquiryAmount = enquiryAmount;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public EnquiryInformationList() {
    }

    List<EnquiryInformationList> enquiryInformationList;
    {
        enquiryInformationList = new ArrayList<>();
    }
    Map<String , String> mapRepresentation = new HashMap<>();

    public List<EnquiryInformationList> enquiryInformation(String tuefResponse)
    {
        String word="IQ04I";
        int index=0;
        String tag="";
        String tempData="";
        for ( index = -1; (index = tuefResponse.indexOf(word, index-1)) != -1; index++)
        {
            EnquiryInformationList enquirySegment = new EnquiryInformationList();
            index=index+8;
            tag=tuefResponse.substring(index,index+2);
            index=index+2;
            if(tag.equals("01"))
            {
                String[] details = new EnquiryInformationList().tagDetails(tuefResponse,index);
                index=Integer.parseInt(details[0]);
                try {
                    tempData= Utility.formatStringToDate(details[1]);
                    enquirySegment.setDateOfEnquiry(tempData);
                }
                catch (ParseException exception)
                {
                    exception.printStackTrace();
                }
                tag = tuefResponse.substring(index,index+2);
                index=index+2;
            }
            else
                enquirySegment.setDateOfEnquiry("");
            if(tag.equals("04"))
            {
                String[] details = new EnquiryInformationList().tagDetails(tuefResponse,index);
                index=Integer.parseInt(details[0]);
                enquirySegment.setMemberName(details[1]);
                tag = tuefResponse.substring(index,index+2);
                index=index+2;
            }
            else
                enquirySegment.setMemberName("");
            if(tag.equals("05"))
            {
                String[] details = new EnquiryInformationList().tagDetails(tuefResponse,index);
                index=Integer.parseInt(details[0]);
                tempData=details[1];
                mapRepresentation= Utility.asMap("C:\\Users\\LoanFrame User\\Desktop\\" +
                       "Useful Data\\fin360\\AccountTypetable.txt",2);
                enquirySegment.setEnquiryPurpose(mapRepresentation.get(tempData));
                tag = tuefResponse.substring(index,index+2);
                index=index+2;
            }
            else
                enquirySegment.setEnquiryPurpose("");
            if(tag.equals("06"))
            {
                String[] details = new EnquiryInformationList().tagDetails(tuefResponse,index);
                index=Integer.parseInt(details[0]);
                enquirySegment.setEnquiryAmount(details[1]);
            }
            enquiryInformationList.add(enquirySegment);
        }
        return enquiryInformationList;
    }
    public String[] tagDetails(String tuefResponse, int index)
    {
        String tagData;
        String[] str = new String[2];
        int length=Integer.parseInt(tuefResponse.substring(index,index+2));
        index=index+2;
        tagData=tuefResponse.substring(index,index+length);
        index=index+length;
        str[0]=String.valueOf(index);
        str[1]=tagData;
        return str;
    }
}

