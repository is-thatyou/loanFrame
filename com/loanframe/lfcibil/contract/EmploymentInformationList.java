package com.loanframe.lfcibil.contract;

import com.loanframe.lfcibil.util.Utility;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmploymentInformationList {
    private String accountType;
    private String dateReported;
    private String occupation;
    private String income;
    private String netGrossIncomeIndicator;
    private String monthlyAnnualIncomeIndiactor;
    private String dateOfErrorCode;
    private String errorcode;
    private String dateOfcibilremarks;
    private String cibilRemarksCode;
    private String dateOfDisputeRemarks;
    private String disputeRemarksCode;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDateReported() {
        return dateReported;
    }

    public void setDateReported(String dateReported) {
        this.dateReported = dateReported;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDateOfErrorCode() {
        return dateOfErrorCode;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getNetGrossIncomeIndicator() {
        return netGrossIncomeIndicator;
    }

    public void setNetGrossIncomeIndicator(String netGrossIncomeIndicator) {
        this.netGrossIncomeIndicator = netGrossIncomeIndicator;
    }

    public String getMonthlyAnnualIncomeIndiactor() {
        return monthlyAnnualIncomeIndiactor;
    }

    public void setMonthlyAnnualIncomeIndiactor(String monthlyAnnualIncomeIndiactor) {
        this.monthlyAnnualIncomeIndiactor = monthlyAnnualIncomeIndiactor;
    }

    public void setDateOfErrorCode(String dateOfErrorCode) {
        this.dateOfErrorCode = dateOfErrorCode;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getDateOfcibilremarks() {
        return dateOfcibilremarks;
    }

    public void setDateOfcibilremarks(String dateOfcibilremarks) {
        this.dateOfcibilremarks = dateOfcibilremarks;
    }

    public String getCibilRemarksCode() {
        return cibilRemarksCode;
    }

    public void setCibilRemarksCode(String cibilRemarksCode) {
        this.cibilRemarksCode = cibilRemarksCode;
    }

    public String getDateOfDisputeRemarks() {
        return dateOfDisputeRemarks;
    }

    public void setDateOfDisputeRemarks(String dateOfDisputeRemarks) {
        this.dateOfDisputeRemarks = dateOfDisputeRemarks;
    }

    public String getDisputeRemarksCode() {
        return disputeRemarksCode;
    }

    public void setDisputeRemarksCode(String disputeRemarksCode) {
        this.disputeRemarksCode = disputeRemarksCode;
    }

    static Map<String, String> keyValueMap = new HashMap<>();

    List<EmploymentInformationList> list;

    {
        list = new ArrayList<>();
    }

    public List<EmploymentInformationList> employmentDetails(String str) throws IOException {
        int i = 0, length;
        String tag, value;
        String word = "EM03E01";
        String tempData = "";
        for (i = -1; (i = str.indexOf(word, i - 1)) != -1; i++) {
            EmploymentInformationList obj = new EmploymentInformationList();
            i = i + 7;
            tag = str.substring(i, i + 2);
            if (tag.equals("01")) {
                keyValueMap = Utility.asMap("C:\\lf-cibil-parser\\src\\com\\loanframe\\lfcibil\\AccountTypeTable.txt", 2);
                i = i + 4;
                value = str.substring(i, i + 2);
                i = i + 2;
                obj.setAccountType(keyValueMap.get(value));
                tag = str.substring(i, i + 2);
            }

            if (tag.equals("02")) {
                i = i + 4;
                try {
                    tempData = Utility.formatStringToDate(str.substring(i, i + 8));
                    obj.setDateReported(tempData);
                } catch (ParseException exception) {
                    exception.printStackTrace();
                }
                i = i + 8;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("03")) {
                i = i + 4;
                value = str.substring(i, i + 2);
                i = i + 2;
                switch (value) {
                    case "01":
                        obj.setOccupation("Salaried");
                        break;
                    case "02":
                        obj.setOccupation("Self Employed Professional");
                        break;
                    case "03":
                        obj.setOccupation("Self Employed");
                        break;
                    case "04":
                        obj.setOccupation("Others");
                        break;
                }
                tag = str.substring(i, i + 2);
            }

            if (tag.equals("04")) {
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setIncome(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);

            }
            if (tag.equals("05")) {
                i = i + 4;
                value = str.substring(i, i + 1);
                i = i + 1;
                switch (value) {
                    case "G":
                        obj.setNetGrossIncomeIndicator("Gross Income");
                        break;
                    case "N":
                        obj.setNetGrossIncomeIndicator("Net Income");
                        break;
                }
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("06")) {
                i = i + 4;
                value = str.substring(i, i + 1);
                i = i + 1;
                switch (value) {
                    case "M":
                        obj.setMonthlyAnnualIncomeIndiactor("Monthly");
                        break;

                    case "A":
                        obj.setMonthlyAnnualIncomeIndiactor("Annual");
                        break;
                }
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("80")) {
                i = i + 4;
                try {
                    tempData = Utility.formatStringToDate(str.substring(i, i + 8));
                    obj.setDateOfErrorCode(tempData);
                } catch (ParseException exception) {
                    exception.printStackTrace();
                }
                i = i + 8;
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("82")) {
                keyValueMap = Utility.asMap("C:\\lf-cibil-parser\\src\\com\\loanframe\\lfcibil\\ErrorCodes.txt", 3);
                i = i + 4;
                value = str.substring(i, i + 3);
                i = i + 3;
                obj.setErrorcode(keyValueMap.get(value));
                tag = str.substring(i, i + 2);
            }
            if (tag.equals("83")) {
                i = i + 4;
                try {
                    tempData = Utility.formatStringToDate(str.substring(i, i + 8));
                    obj.setDateOfcibilremarks(tempData);
                } catch (ParseException exception) {
                    exception.printStackTrace();
                }

                i = i + 8;

                tag = str.substring(i, i + 2);
            } else
                obj.setDateOfcibilremarks("");
            if (tag.equals("84")) {
                keyValueMap = Utility.asMap("C:\\lf-cibil-parser\\src\\com\\loanframe\\lfcibil\\RemarksCodes.txt", 6);
                i = i + 4;
                value = str.substring(i, i + 6);
                i = i + 6;
                obj.setCibilRemarksCode(keyValueMap.get(value));

                tag = str.substring(i, i + 2);
            } else
                obj.setCibilRemarksCode("");
            if (tag.equals("85")) {
                i = i + 4;
                obj.setDateOfDisputeRemarks(str.substring(i, i + 8));
                i = i + 8;

                tag = str.substring(i, i + 2);
            }
            if (tag.equals("86") || tag.equals("87")) {
                i = i + 4;
                value = str.substring(i, i + 6);
                i = i + 6;
                obj.setDisputeRemarksCode("Disputed accepted – under investigation ");

                tag = str.substring(i, i + 2);
            }

            list.add(obj);
        }
        return list;
    }
}
