package com.loanframe.lfcibil.contract;

import com.loanframe.lfcibil.util.Utility;

import java.text.ParseException;

public class ResponseTuef {

    private String segmentTag;
    private String version;
    private String memberRefNumber; //used in cibilUpload
    private String memberId; //used in cibilUpload
    private String controlNumber; //used in cibilUpload
    private String subjectReturnCode;
    private String enquiryDate; //used in cibilUpload
    private String enquiryTime; //used in cibilUpload
    private String futureUse1;
    private String futureUse2;

    public String getSegmentTag() {
        return segmentTag;
    }

    public void setSegmentTag(String segmentTag) {
        this.segmentTag = segmentTag;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMemberRefNumber() {
        return memberRefNumber;
    }

    public void setMemberRefNumber(String memberRefNumber) {
        this.memberRefNumber = memberRefNumber;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getSubjectReturnCode() {
        return subjectReturnCode;
    }

    public void setSubjectReturnCode(String subjectReturnCode) {
        this.subjectReturnCode = subjectReturnCode;
    }

    public String getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getEnquiryDate() {
        return enquiryDate;
    }

    public void setEnquiryDate(String enquiryDate) {
        this.enquiryDate = enquiryDate;
    }

    public String getEnquiryTime() {
        return enquiryTime;
    }

    public void setEnquiryTime(String enquiryTime) {
        this.enquiryTime = enquiryTime;
    }

    public String getFutureUse1() {
        return futureUse1;
    }

    public void setFutureUse1(String futureUse1) {
        this.futureUse1 = futureUse1;
    }

    public String getFutureUse2() {
        return futureUse2;
    }

    public void setFutureUse2(String futureUse2) {
        this.futureUse2 = futureUse2;
    }

    public ResponseTuef setResponseTuef(String str) {
        ResponseTuef obj = new ResponseTuef();
        obj.setSegmentTag("TUEF");
        obj.setVersion("12");
        obj.setMemberRefNumber(str.substring(6, 31));
        obj.setFutureUse1(str.substring(31, 33));
        obj.setFutureUse2(str.substring(33, 37));
        obj.setMemberId(str.substring(37, 67).trim());
        obj.setSubjectReturnCode(str.substring(67, 68));
        obj.setControlNumber(str.substring(68, 80));
        try {
            String date = Utility.formatStringToDate(str.substring(80, 88));
            obj.setEnquiryDate(date);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        obj.setEnquiryTime(str.substring(88, 94));
        return obj;
    }
}
