package com.loanframe.lfcibil.contract;

import com.loanframe.lfcibil.util.Utility;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anshu Goyal on 22/05/18.
 */

public class AccountInformationList {

    static Map<String, String> keyValueMap = new HashMap<>();
    public String amountOverdue;
    public String dateOfLastPayment;
    public String dateOpened;
    public String emiAmount;
    public String memberName;
    public String ownership;
    List<AccountInformationList> accountInformationList;
    private String accountNumber;
    private String accountType;
    private String actualPaymentAmount;
    private String bank;
    private String cashLimit;
    private String creditLimit;
    private String currentBalance;
    private String dateClosed;
    private String dateReported;
    private String highCredit;
    private String paymentEndDate;
    private String paymentFrequency;
    private String paymentStartDate;
    private String rateOfInterest;
    private String repaymentTenure;
    private String sanctionedAmount;
    private String settledStatus;
    private String status;
    private String settlement;
    private String writtenOffPrincipal;
    private String writtenOffTotal;
    private List<AssetClassificationList> assetList;
    private String disputeRemarks1; //not in original fin360
    private String disputeRemarks2; //not in original fin360
    private String cibilRemarks;//not in original fin360
    private String errorCode; //not in original fin360
    private String suitFiled; //not in original fin360
    private String paymentHistory; //not in original fin360
    private String valueOfCollateral; //not in original fin360
    private String typeOfCollateral; //not in original fin360
    private String totalAccounts; //declared for accountSummary class
    private String dateErrorCode; //not in original fin360
    private String dateOfEntryCibilRemarks;//not in original fin360
    private String dateDisputeReamrks; //not in original fin360

    {
        accountInformationList = new ArrayList<>();
    }

    {
        assetList = new ArrayList<>();
    }
    public AccountInformationList() {
    }

    public List<AssetClassificationList> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<AssetClassificationList> assetList) {
        this.assetList = assetList;
    }

    public String getValueOfCollateral() {
        return valueOfCollateral;
    }

    public void setValueOfCollateral(String valueOfCollateral) {
        this.valueOfCollateral = valueOfCollateral;
    }

    public String getTypeOfCollateral() {
        return typeOfCollateral;
    }

    public void setTypeOfCollateral(String typeOfCollateral) {
        this.typeOfCollateral = typeOfCollateral;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getActualPaymentAmount() {
        return actualPaymentAmount;
    }

    public void setActualPaymentAmount(String actualPaymentAmount) {
        this.actualPaymentAmount = actualPaymentAmount;
    }

    public String getAmountOverdue() {
        return amountOverdue;
    }

    public void setAmountOverdue(String amountOverdue) {
        this.amountOverdue = amountOverdue;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCashLimit() {
        return cashLimit;
    }

    public void setCashLimit(String cashLimit) {
        this.cashLimit = cashLimit;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getDateErrorCode() {
        return dateErrorCode;
    }

    public void setDateErrorCode(String dateErrorCode) {
        this.dateErrorCode = dateErrorCode;
    }

    public String getDateOfEntryCibilRemarks() {
        return dateOfEntryCibilRemarks;
    }

    public void setDateOfEntryCibilRemarks(String dateOfEntryCibilRemarks) {
        this.dateOfEntryCibilRemarks = dateOfEntryCibilRemarks;
    }

    public String getDateDisputeReamrks() {
        return dateDisputeReamrks;
    }

    public void setDateDisputeReamrks(String dateDisputeReamrks) {
        this.dateDisputeReamrks = dateDisputeReamrks;
    }

    public String getDateOfLastPayment() {
        return dateOfLastPayment;
    }

    public void setDateOfLastPayment(String dateOfLastPayment) {
        this.dateOfLastPayment = dateOfLastPayment;
    }

    public String getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(String dateOpened) {
        this.dateOpened = dateOpened;
    }

    public String getDateReported() {
        return dateReported;
    }

    public void setDateReported(String dateReported) {
        this.dateReported = dateReported;
    }

    public String getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(String emiAmount) {
        this.emiAmount = emiAmount;
    }

    public String getHighCredit() {
        return highCredit;
    }

    public void setHighCredit(String highCredit) {
        this.highCredit = highCredit;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getPaymentEndDate() {
        return paymentEndDate;
    }

    public void setPaymentEndDate(String paymentEndDate) {
        this.paymentEndDate = paymentEndDate;
    }

    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public String getPaymentStartDate() {
        return paymentStartDate;
    }

    public void setPaymentStartDate(String paymentStartDate) {
        this.paymentStartDate = paymentStartDate;
    }

    public String getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(String rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getRepaymentTenure() {
        return repaymentTenure;
    }

    public void setRepaymentTenure(String repaymentTenure) {
        this.repaymentTenure = repaymentTenure;
    }

    public String getSanctionedAmount() {
        return sanctionedAmount;
    }

    public void setSanctionedAmount(String sanctionedAmount) {
        this.sanctionedAmount = sanctionedAmount;
    }

    public String getSettledStatus() {
        return settledStatus;
    }

    public void setSettledStatus(String settledStatus) {
        this.settledStatus = settledStatus;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getWrittenOffPrincipal() {
        return writtenOffPrincipal;
    }

    public void setWrittenOffPrincipal(String writtenOffPrincipal) {
        this.writtenOffPrincipal = writtenOffPrincipal;
    }

    public String getWrittenOffTotal() {
        return writtenOffTotal;
    }

    public void setWrittenOffTotal(String writtenOffTotal) {
        this.writtenOffTotal = writtenOffTotal;
    }

    public String getDisputeRemarks1() {
        return disputeRemarks1;
    }

    public void setDisputeRemarks1(String disputeRemarks1) {
        this.disputeRemarks1 = disputeRemarks1;
    }

    public String getDisputeRemarks2() {
        return disputeRemarks2;
    }

    public void setDisputeRemarks2(String disputeRemarks2) {
        this.disputeRemarks2 = disputeRemarks2;
    }

    public String getCibilRemarks() {
        return cibilRemarks;
    }

    public void setCibilRemarks(String cibilRemarks) {
        this.cibilRemarks = cibilRemarks;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getSuitFiled() {
        return suitFiled;
    }

    public void setSuitFiled(String suitFiled) {
        this.suitFiled = suitFiled;
    }

    public String getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(String paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public String getTotalAccounts() {
        return totalAccounts;
    }

    public void setTotalAccounts(String totalAccounts) {
        this.totalAccounts = totalAccounts;
    }

    public List<AccountInformationList> parseAccountInformation(String str) throws IOException {
        String word = "TL04T", tag, value;
        int i = 0, count = 1;
        String tempData = "";
        for (i = -1; (i = str.indexOf(word, i - 1)) != -1; i++) {
            AccountInformationList obj = new AccountInformationList();

            String num = String.valueOf(count);
            obj.setTotalAccounts(num);
            count++;
            paymentHistory = "";
            int length = 0;
            i = i + 8;
            tag = str.substring(i, i + 2);

            if (tag.equals("02")) {

                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;

                obj.setMemberName(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);


            }
            if (tag.equals("03")) {
                //count++;
                //System.out.println(count);
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setAccountNumber(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }


            if (tag.equals("04")) {
                //count++;
                //System.out.println(count);
                keyValueMap = Utility.asMap("C:\\lf-cibil-parser\\src\\com\\loanframe\\lfcibil\\AccountTypeTable.txt", 2);
                i = i + 4;
                value = str.substring(i, i + 2);
                obj.setAccountType(keyValueMap.get(value));
                i = i + 2;
                tag = str.substring(i, i + 2);

            }


            if (tag.equals("05")) {
                String ownershipIndicator = "";
                i = i + 4;
                value = str.substring(i, i + 1);
                i = i + 1;
                switch (value) {
                    case "1":
                        ownershipIndicator = "Individual";
                        break;
                    case "2":
                        ownershipIndicator = "Authorised Users";
                        break;
                    case "3":
                        ownershipIndicator = "Guarantor";
                        break;
                    case "4":
                        ownershipIndicator = "Joint";
                        break;
                }
                obj.setOwnership(ownershipIndicator);
                tag = str.substring(i, i + 2);
            }


            if (tag.equals("08")) {

                i = i + 4;
                obj.setDateOpened(str.substring(i, i + 8));
                i = i + 8;
                tag = str.substring(i, i + 2);

            }


            if (tag.equals("09")) {
                i = i + 4;
                obj.setDateOfLastPayment(str.substring(i, i + 8));
                i = i + 8;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("10")) {
                i = i + 4;
                obj.setDateClosed(str.substring(i, i + 8));
                i = i + 8;
                tag = str.substring(i, i + 2);
            }

            if (tag.equals("11")) {
                i = i + 4;
                obj.setDateReported(str.substring(i, i + 8));
                i = i + 8;
                tag = str.substring(i, i + 2);
            }


            if (tag.equals("12")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                //System.out.println(str.substring(i, i + length)+"   Scanction");
                obj.setSanctionedAmount(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            } else {
                obj.setSanctionedAmount("0");
                //System.out.println(0);
            }

            if (tag.equals("13")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                //System.out.println(str.substring(i, i + length));
                obj.setCurrentBalance(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }


            if (tag.equals("14")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                //System.out.println(str.substring(i, i + length)+" "+couunt++);
                obj.setAmountOverdue(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            } else {
                //System.out.println(0+" "+ couunt++);
                obj.setAmountOverdue("0");
            }
            if (tag.equals("28")) {
                //System.out.println(tag);
                //paymentHistory="";
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                tempData = str.substring(i, i + length);
                //System.out.println(tempData+ " From tag 28");
                //obj.setPaymentHistory(tempData);
                i = i + length;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("29")) {
                //System.out.println(tag);
                //paymentHistory="";
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                //System.out.println(str.substring(i, i + length)+" From tag 29");
                tempData = tempData + str.substring(i, i + length);
                obj.setPaymentHistory(tempData);
                i = i + length;
                tag = str.substring(i, i + 2);
            } else {
                obj.setPaymentHistory(tempData);
            }

            if (tag.equals("30")) {
                //System.out.println(i);
                //System.out.println(tag);
                i = i + 4;
                obj.setPaymentStartDate(str.substring(i, i + 8));
                i = i + 8;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("31")) {
                i = i + 4;
                obj.setPaymentEndDate(str.substring(i, i + 8));
                i = i + 8;
                tag = str.substring(i, i + 2);
            }
                String history = obj.getPaymentHistory();
                try {
                    String start = Utility.dateAsMonthYear(obj.getPaymentStartDate());
                  List<AssetClassificationList> list = obj.setAssets(history, start);
                   obj.setAssetList(list);
                } catch (ParseException exception) {
                    exception.printStackTrace();
                }

            if (tag.equals("32")) {
                String suitFiled = "";
                i = i + 4;
                value = str.substring(i, i + 2);
                switch (value) {
                    case "00":
                        suitFiled = "No Suit Filed";
                        break;
                    case "01":
                        suitFiled = "Suit Filed";
                        break;
                    case "02":
                        suitFiled = "Wilful Default";
                        break;
                    case "03":
                        suitFiled = "Suit Filed(Wilful default)";
                        break;
                }
                obj.setSuitFiled(suitFiled);
                i = i + 2;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("33")) {
                String settledStatus = "";
                i = i + 4;
                value = str.substring(i, i + 2);
                switch (value) {
                    case "00":
                        settledStatus = "Restructured Loan";
                        break;
                    case "01":
                        settledStatus = "Restructured Loan (Govt. Mandated)";
                        break;
                    case "02":
                        settledStatus = "Written-off";
                        break;
                    case "03":
                        settledStatus = "Settled";
                        break;
                    case "04":
                        settledStatus = "Post (WO) Settled ";
                        break;
                    case "05":
                        settledStatus = "Account Sold";
                        break;
                    case "06":
                        settledStatus = "Written Off and Account Sold";
                        break;
                    case "07":
                        settledStatus = "Account Purchased";
                        break;
                    case "08":
                        settledStatus = "Account Purchased and Written Off";
                        break;
                    case "09":
                        settledStatus = "Account Purchased and Settled";
                        break;
                    case "10":
                        settledStatus = "Account Purchased and Restructured";
                        break;
                }
                obj.setSettledStatus(settledStatus);
                i = i + 2;
                tag = str.substring(i, i + 2);
            }

            if (tag.equals("34")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setValueOfCollateral(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("35")) {
                String typeOfCollateral = "";
                i = i + 4;
                value = str.substring(i, i + 2);
                switch (value) {
                    case "00":
                        typeOfCollateral = "No Collateral";
                    case "01":
                        typeOfCollateral = "Property";
                    case "02":
                        typeOfCollateral = "Gold";
                    case "03":
                        typeOfCollateral = "Shares";
                    case "04":
                        typeOfCollateral = "Saving Account and Fixed Deposit";

                }
                obj.setTypeOfCollateral(typeOfCollateral);
                i = i + 2;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("36")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setCreditLimit(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("37")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setCashLimit(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("38")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setRateOfInterest(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("39")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setRepaymentTenure(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("40")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setEmiAmount(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("41")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setWrittenOffTotal(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("42")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setWrittenOffPrincipal(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("43")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setSettlement(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);

            }

            if (tag.equals("44")) {
                String paymentFreq = "";
                i = i + 4;
                value = str.substring(i, i + 2);
                i = i + 2;
                switch (value) {
                    case "01":
                        paymentFreq = "Weekly";
                        break;
                    case "02":
                        paymentFreq = "Fortnightly";
                        break;
                    case "03":
                        paymentFreq = "Monthly";
                        break;
                    case "04":
                        paymentFreq = "Quarterly";
                        break;
                }
                obj.setPaymentFrequency(paymentFreq);
                tag = str.substring(i, i + 2);

            }
            if (tag.equals("45")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setActualPaymentAmount(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
            }

            if (tag.equals("80")) {
                i = i + 4;
                obj.setDateErrorCode(str.substring(i, i + 8));
                i = i + 8;
                tag = str.substring(i, i + 2);
            }

            if (tag.equals("82")) {
                keyValueMap = Utility.asMap("C:\\lf-cibil-parser\\src\\com\\loanframe\\lfcibil\\ErrorCodes.txt", 3);
                i = i + 4;
                value = str.substring(i, i + 3);
                obj.setErrorCode(keyValueMap.get(value));
                i = i + 3;
                tag = str.substring(i, i + 2);
            }

            if (tag.equals("83")) {
                i = i + 4;
                obj.setDateOfEntryCibilRemarks(str.substring(i, i + 8));
                i = i + 8;
                tag = str.substring(i, i + 2);
            }

            if (tag.equals("84")) {

                keyValueMap = Utility.asMap("C:\\lf-cibil-parser\\src\\com\\loanframe\\lfcibil\\RemarksCodes" +
                                ".txt",
                        6);
                i = i + 4;
                value = str.substring(i, i + 6);
                obj.setCibilRemarks(keyValueMap.get(value));
                i = i + 6;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("85")) {
                i = i + 4;
                obj.setDateDisputeReamrks(str.substring(i, i + 8));
                i = i + 8;
                tag = str.substring(i, i + 2);


            }
            if (tag.equals("86")) {
                i = i + 4;
                value = str.substring(i, i + 6);
                i = i + 6;
                if (value.equals("000001"))
                    obj.setDisputeRemarks1("Disputed accepted – under investigation ");

                tag = str.substring(i, i + 2);
            }
            if (tag.equals("87")) {
                i = i + 4;
                value = str.substring(i, i + 6);
                i = i + 6;
                if (value.equals("000001"))
                    obj.setDisputeRemarks2("Disputed accepted – under investigation ");

            }
            accountInformationList.add(obj);
        }
        return accountInformationList;
    }
    public List<AssetClassificationList> setAssets(String history, String startDate)
    {
        List<AssetClassificationList> myList = new ArrayList();
        int length=0;
        int month = Integer.parseInt(startDate.substring(0,2));
        int year = Integer.parseInt(startDate.substring(5,7));

        for(int j=0;j<history.length()/3;j++)
        {
            AssetClassificationList assetObject = new AssetClassificationList();
            String date="";
            String code = history.substring(length,length+3);
            assetObject.setCode(code);
            if (month>=1 && month <=12) {
                date = String.valueOf(String.format("%02d",month)+"-"+String.format("%02d",year));
                assetObject.setDate(date);
                month--;
            }
            if(month==0)
            {
                month=12;
                year=year-1;
            }
            length=length+3;
            myList.add(assetObject);
        }
        return myList;
    }
}
