package com.loanframe.lfcibil.contract;

import com.loanframe.lfcibil.util.Utility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anshu Goyal on 22/05/18.
 */
public class AccountSummary {
    private Double currentBalance;
    private Double highCredit;
    private String oldestDateOpened;
    private String overdueAccount;
    private Double overdueBalance;
    private String recentDateOpened;
    private Integer totalAccount;
    private String zeroBalanceAccount;

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Double getHighCredit() {
        return highCredit;
    }

    public void setHighCredit(Double highCredit) {
        this.highCredit = highCredit;
    }

    public String getOldestDateOpened() {
        return oldestDateOpened;
    }

    public String getOverdueAccount() {
        return overdueAccount;
    }

    public void setOverdueAccount(String overdueAccount) {
        this.overdueAccount = overdueAccount;
    }

    public void setOldestDateOpened(String oldestDateOpened) {
        this.oldestDateOpened = oldestDateOpened;
    }

    public Double getOverdueBalance() {
        return overdueBalance;
    }

    public void setOverdueBalance(Double overdueBalance) {
        this.overdueBalance = overdueBalance;
    }

    public String getRecentDateOpened() {
        return recentDateOpened;
    }

    public void setRecentDateOpened(String recentDateOpened) {
        this.recentDateOpened = recentDateOpened;
    }

    public Integer getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(Integer totalAccount) {
        this.totalAccount = totalAccount;
    }

    public String getZeroBalanceAccount() {
        return zeroBalanceAccount;
    }

    public void setZeroBalanceAccount(String zeroBalanceAccount) {
        this.zeroBalanceAccount = zeroBalanceAccount;
    }

    public AccountSummary sendToAccountSummary(List<AccountInformationList> accountSegmentList)
    {
        int number = 0;
        int overDueCount = 0;
        int zeroBalCount = 0;
        double currentBal = 0;
        double overdueBal = 0;
        int sanctionAmount = 0;
        int noOfAccounts = 0;
        AccountSummary accountSummary = new AccountSummary();
        List list = accountSegmentList;
        List<String> datesList = new ArrayList<>();
        Iterator itr = list.iterator();
        while (itr.hasNext())
        {
            AccountInformationList resAccSegment =(AccountInformationList) itr.next();
            noOfAccounts = (Integer.parseInt(resAccSegment.getTotalAccounts()));
            number = Integer.parseInt(resAccSegment.getAmountOverdue());
            if(number>0)
            {
                overdueBal=overdueBal+number;
                overDueCount=overDueCount+1;

            }
            number = Integer.parseInt(resAccSegment.getCurrentBalance());
            if(number == 0){
                zeroBalCount = zeroBalCount+1;
            }
            else
            {
               currentBal = currentBal + number;
            }
            number=Integer.parseInt(resAccSegment.getSanctionedAmount());
            sanctionAmount = sanctionAmount+number;

            String date = resAccSegment.getDateOpened();
            datesList.add(date);
        }
        accountSummary.setTotalAccount(noOfAccounts);
        accountSummary.setOverdueAccount(String.valueOf(overDueCount));
        accountSummary.setOverdueBalance(overdueBal);
        accountSummary.setZeroBalanceAccount(String.valueOf(zeroBalCount));
        accountSummary.setCurrentBalance(currentBal);
        accountSummary.setHighCredit((double)sanctionAmount);
        String[] dateArray = new String[datesList.size()];
        dateArray = datesList.toArray(dateArray);
        try {
            dateArray= Utility.formatStringToDate(dateArray);
            String oldest = dateArray[0];
            String recent = dateArray[dateArray.length-1];
            accountSummary.setOldestDateOpened(oldest);
            accountSummary.setRecentDateOpened(recent);
        }
        catch(ParseException exception)
        {
            exception.printStackTrace();
        }
        return accountSummary;
    }
}



