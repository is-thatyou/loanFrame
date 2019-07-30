package contract.cibil.fin360;

import utli.cibil.fin360.Utility;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anshu Goyal on 22/05/18.
 */
public class ResponseAccountSummary {
    private Integer totalAccount;
    private String totalOverdueAccounts;
    private String totalZeroBalanceAccounts;
    private Double highCredit;
    private Double currentBalance;
    private Double overdueBalance;
    private String recentDateOpened;
    private String oldestDateOpened;

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

    public String getTotalOverdueAccounts() {
        return totalOverdueAccounts;
    }

    public void setTotalOverdueAccounts(String totalOverdueAccounts) {
        this.totalOverdueAccounts = totalOverdueAccounts;
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

    public String getTotalZeroBalanceAccounts() {
        return totalZeroBalanceAccounts;
    }

    public void setTotalZeroBalanceAccounts(String totalZeroBalanceAccounts) {
        this.totalZeroBalanceAccounts = totalZeroBalanceAccounts;
    }
    List<ResponseAccountSummary> summaryList = new ArrayList<>();

    public List<ResponseAccountSummary> sendToAccountSummary(List<ResponseAccountSegment> accountSegmentList)
    {
        int number = 0;
        int overDueCount = 0;
        int zeroBalCount = 0;
        double currentBal = 0;
        double overdueBal = 0;
        int sanctionAmount = 0;
        int noOfAccounts = 0;
        ResponseAccountSummary accountSummary = new ResponseAccountSummary();
        List list = accountSegmentList;
        List<String> datesList = new ArrayList<>();
        Iterator itr = list.iterator();
        while (itr.hasNext())
        {
            ResponseAccountSegment resAccSegment =(ResponseAccountSegment) itr.next();
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
        accountSummary.setTotalOverdueAccounts(String.valueOf(overDueCount));
        accountSummary.setOverdueBalance(overdueBal);
        accountSummary.setTotalZeroBalanceAccounts(String.valueOf(zeroBalCount));
        accountSummary.setCurrentBalance(currentBal);
        accountSummary.setHighCredit((double)sanctionAmount);
        String[] dateArray = new String[datesList.size()];
        dateArray = datesList.toArray(dateArray);
        try {
            dateArray=Utility.formatStringToDate(dateArray);
            String oldest = dateArray[0];
            String recent = dateArray[dateArray.length-1];
            accountSummary.setOldestDateOpened(oldest);
            accountSummary.setRecentDateOpened(recent);
        }
        catch(ParseException exception)
        {
            exception.printStackTrace();
        }
        summaryList.add(accountSummary);
        return summaryList;
    }

    public static void main(String []args)
    {

    }

}



