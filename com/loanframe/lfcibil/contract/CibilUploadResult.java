package com.loanframe.lfcibil.contract;
/*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jongo.marshall.jackson.oid.MongoObjectId;
*/

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anshu Goyal on 22/05/2018.
 */

public class CibilUploadResult {

    //    public String loanId;
//    public String pan;
    public String name;
    //  private LatePayment latePayment;
//    private Integer personalLoanScore;
//    private Map <String, Integer> types;
//    private Integer numberOfLoansActive;
//    private Integer numberOfLoansClosed;
//    private Integer numberOfLoansApplied;
//    private Integer numberOfLoansApproved;
//    private Integer numberOfOverdueAccount;
//    private Integer totalNumberOfLatePayment;
//    private Integer numberOfCreditCardApplied;
//    private Integer numberOfCreditCardApproved;
//    private List<CreditCardList> creditCardList;
//    private Integer totalNumberOfCreditCardActive;
//    private Integer totalNumberOfCreditCardClosed;
//    private Integer numberOfLatePaymentOfCreditCard;
//    private List <AccountAnalysisList> accountAnalysisList;
//    private List <String> overdueLoans = new ArrayList <> ();
//    private Integer numberOfLatePaymentOfCreditCardLastSixMonth;
    //    private String message;
    //    private Boolean status;
    public String enquiryDate;
    private String gender;
    private String memberId;
    private String dateOfBirth;
    private String controlNumber;
    private String enquiryTime;
    //public String cibilIdentifier;
    private String memberRefNumber;
    private Integer responseLength;
    private Integer score;
    private String scoreName;
    private AccountSummary accountSummary;
    private List<ContactInformationList> addressSegmentList;
    private List<EmailAddressList> emailAddressList;
    private List<PhoneNumberList> phoneNumberList;
    private List<AccountInformationList> accountInformationList;
    private List<EnquiryInformationList> enquirySegmentsList;
    private List<ResponseNameSegment> nameSegmentList;
    private List<IdentificationList> identificationSegmentList;
    private List<EmploymentInformationList> employmentSegmentList;
    private List<ResponseAccountNumber> accountNumbersList;


    public CibilUploadResult tuefResponsetData(String tuefResponseString)
    {
        CibilUploadResult cibil = new CibilUploadResult();
        PhoneNumberList phone = new PhoneNumberList();
        cibil.setPhoneNumberList(phone.parseNumuber(tuefResponseString));
        try {
            AccountInformationList account = new AccountInformationList();
            cibil.setAccountInformationList(account.parseAccountInformation(tuefResponseString));

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        ContactInformationList addressSegment = new ContactInformationList();
        cibil.setAddressSegmentList(addressSegment.addressInformation(tuefResponseString));
        EmailAddressList emailAddressList = new EmailAddressList();
        cibil.setEmailAddressList(emailAddressList.emaliInformation(tuefResponseString));

        EnquiryInformationList enquirySegment = new EnquiryInformationList();
        cibil.setEnquirySegmentsList(enquirySegment.enquiryInformation(tuefResponseString));


        ResponseScoreSegment scoreSegment = new ResponseScoreSegment();
        List<ResponseScoreSegment> list = scoreSegment.scoreDetails(tuefResponseString);
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            ResponseScoreSegment score = (ResponseScoreSegment) itr.next();
            cibil.setScoreName(score.getScoreName());
            cibil.setScore(score.getScore());
        }

        ResponseNameSegment responseNameSegment = new ResponseNameSegment();
        responseNameSegment = responseNameSegment.nameDetails(tuefResponseString);
        cibil.setName(responseNameSegment.getName());
        cibil.setGender(responseNameSegment.getGender());
        cibil.setDateOfBirth(responseNameSegment.getDateOfBirth());

        IdentificationList identificationList = new IdentificationList();
        cibil.setIdentificationSegmentList(identificationList.identificationInformation(tuefResponseString));

        EmploymentInformationList employmentInformationList = new EmploymentInformationList();
        try {
            cibil.setEmploymentSegmentList(employmentInformationList.employmentDetails(tuefResponseString));

        } catch (IOException exception) {
            exception.printStackTrace();
        }

        ResponseAccountNumber responseAccountNumber = new ResponseAccountNumber();
        cibil.setAccountNumbersList(responseAccountNumber.enquiryAccountNumber(tuefResponseString));

        ResponseTuef responseTuef = new ResponseTuef();
        responseTuef = responseTuef.setResponseTuef(tuefResponseString);
        cibil.setMemberId(responseTuef.getMemberId());
        cibil.setMemberRefNumber(responseTuef.getMemberRefNumber());
        cibil.setControlNumber(responseTuef.getControlNumber());
        cibil.setEnquiryDate(responseTuef.getEnquiryDate());
        cibil.setEnquiryTime(responseTuef.getEnquiryTime());

        ResponseEndSegment responseEndSegment = new ResponseEndSegment();
        cibil.setResponseLength(responseEndSegment.responselength(tuefResponseString));

        cibil.setAccountSummary(new AccountSummary().sendToAccountSummary(cibil.getAccountInformationList()));
        return cibil;
    }

    public AccountSummary getAccountSummary() {
        return accountSummary;
    }

    public void setAccountSummary(AccountSummary accountSummary) {
        this.accountSummary = accountSummary;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getResponseLength() {
        return responseLength;
    }

    public void setResponseLength(Integer responseLength) {
        this.responseLength = responseLength;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberRefNumber() {
        return memberRefNumber;
    }

    public void setMemberRefNumber(String memberRefNumber) {
        this.memberRefNumber = memberRefNumber;
    }

    public String getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public List<ContactInformationList> getAddressSegmentList() {
        return addressSegmentList;
    }

    public void setAddressSegmentList(List<ContactInformationList> addressSegmentList) {
        this.addressSegmentList = addressSegmentList;
    }

    public List<EmailAddressList> getEmailAddressList() {
        return emailAddressList;
    }

    public void setEmailAddressList(List<EmailAddressList> emailAddressList) {
        this.emailAddressList = emailAddressList;
    }

    public List<PhoneNumberList> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(List<PhoneNumberList> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    public List<AccountInformationList> getAccountInformationList() {
        return accountInformationList;
    }

    public void setAccountInformationList(List<AccountInformationList> accountInformationList) {
        this.accountInformationList = accountInformationList;
    }

    public List<EnquiryInformationList> getEnquirySegmentsList() {
        return enquirySegmentsList;
    }

    public void setEnquirySegmentsList(List<EnquiryInformationList> enquirySegmentsList) {
        this.enquirySegmentsList = enquirySegmentsList;
    }

    public List<ResponseNameSegment> getNameSegmentList() {
        return nameSegmentList;
    }

    public void setNameSegmentList(List<ResponseNameSegment> nameSegmentList) {
        this.nameSegmentList = nameSegmentList;
    }

    public List<IdentificationList> getIdentificationSegmentList() {
        return identificationSegmentList;
    }

    public void setIdentificationSegmentList(List<IdentificationList> identificationSegmentList) {
        this.identificationSegmentList = identificationSegmentList;
    }

    public List<EmploymentInformationList> getEmploymentSegmentList() {
        return employmentSegmentList;
    }

    public void setEmploymentSegmentList(List<EmploymentInformationList> employmentSegmentList) {
        this.employmentSegmentList = employmentSegmentList;
    }

    public List<ResponseAccountNumber> getAccountNumbersList() {
        return accountNumbersList;
    }

    public void setAccountNumbersList(List<ResponseAccountNumber> accountNumbersList) {
        this.accountNumbersList = accountNumbersList;
    }

}