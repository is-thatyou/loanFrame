package contract.cibil.fin360;

import utli.cibil.fin360.Utility;

import java.io.IOException;
import java.util.*;
/**
 * Created by Anshu Goyal on 22/05/18.
 */

public class ResponseAccountSegment {

    private String valueOfCollateral;
    private String typeOfCollateral;
    private String accountNumber;
    private String accountType;
    private String actualPaymentAmount;
    public String amountOverdue;
    private String bank;
    private String cashLimit;
    private String creditLimit;
    private String currentBalance;
    private String dateClosed;
    private String dateErrorCode;
    private String dateOfEntryCibilRemarks;
    private String dateDisputeReamrks;
    public String dateOfLastPayment;
    public String dateOpened;
    private String dateReported;
    public String emiAmount;
    private String highCredit;
    public String memberName;
    public String ownership;
    private String paymentEndDate;
    private String paymentFrequency;
    private String paymentStartDate;
    private String rateOfInterest;
    private String repaymentTenure;
    private String sanctionedAmount;
    private String settledStatus;
    private String status;
    private String settlementAmount;
    private String writtenOffPrincipal;
    private String writtenOffTotal;
    private String disputeRemarks1;
    private String disputeRemarks2;
    private String cibilRemarks;
    private String errorCode;
    private String suitFiled;
    private String paymentHistory;
    private String totalAccounts;

    //ResponseAccountSummary summary = new ResponseAccountSummary();
    static Map<String, String> keyValueMap = new HashMap<>();

    static List<ResponseAccountSegment> accountInformationList;
    static {
        accountInformationList = new ArrayList<> ();
    }

    public ResponseAccountSegment(){}
    public String getValueOfCollateral () {
        return valueOfCollateral;
    }

    public void setValueOfCollateral (String valueOfCollateral){
        this.valueOfCollateral = valueOfCollateral;
    }

    public String getTypeOfCollateral () {
        return typeOfCollateral;
    }

    public void setTypeOfCollateral (String typeOfCollateral){
        this.typeOfCollateral = typeOfCollateral;
    }

    public String getAccountNumber () {
        return accountNumber;
    }

    public void setAccountNumber (String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountType () {
        return accountType;
    }

    public void setAccountType (String accountType){
        this.accountType = accountType;
    }

    public String getActualPaymentAmount () {
        return actualPaymentAmount;
    }

    public void setActualPaymentAmount (String actualPaymentAmount){
        this.actualPaymentAmount = actualPaymentAmount;
    }

    public String getAmountOverdue () {
        return amountOverdue;
    }

    public void setAmountOverdue (String amountOverdue){
        this.amountOverdue = amountOverdue;
    }

    public String getBank () {
        return bank;
    }

    public void setBank (String bank){
        this.bank = bank;
    }

    public String getCashLimit () {
        return cashLimit;
    }

    public void setCashLimit (String cashLimit){
        this.cashLimit = cashLimit;
    }

    public String getCreditLimit () {
        return creditLimit;
    }

    public void setCreditLimit (String creditLimit){
        this.creditLimit = creditLimit;
    }

    public String getCurrentBalance () {
        return currentBalance;
    }

    public void setCurrentBalance (String currentBalance){
        this.currentBalance = currentBalance;
    }

    public String getDateClosed () {
        return dateClosed;
    }

    public void setDateClosed (String dateClosed){
        this.dateClosed = dateClosed;
    }

    public String getDateErrorCode () {
        return dateErrorCode;
    }

    public void setDateErrorCode (String dateErrorCode){
        this.dateErrorCode = dateErrorCode;
    }

    public String getDateOfEntryCibilRemarks () {
        return dateOfEntryCibilRemarks;
    }

    public void setDateOfEntryCibilRemarks (String dateOfEntryCibilRemarks){
        this.dateOfEntryCibilRemarks = dateOfEntryCibilRemarks;
    }

    public String getDateDisputeReamrks () {
        return dateDisputeReamrks;
    }

    public void setDateDisputeReamrks (String dateDisputeReamrks){
        this.dateDisputeReamrks = dateDisputeReamrks;
    }

    public String getDateOfLastPayment () {
        return dateOfLastPayment;
    }

    public void setDateOfLastPayment (String dateOfLastPayment){
        this.dateOfLastPayment = dateOfLastPayment;
    }

    public String getDateOpened () {
        return dateOpened;
    }

    public void setDateOpened (String dateOpened){
        this.dateOpened = dateOpened;
    }

    public String getDateReported () {
        return dateReported;
    }

    public void setDateReported (String dateReported){
        this.dateReported = dateReported;
    }

    public String getEmiAmount () {
        return emiAmount;
    }

    public void setEmiAmount (String emiAmount){
        this.emiAmount = emiAmount;
    }

    public String getHighCredit () {
        return highCredit;
    }

    public void setHighCredit (String highCredit){
        this.highCredit = highCredit;
    }

    public String getMemberName () {
        return memberName;
    }

    public void setMemberName (String memberName){
        this.memberName = memberName;
    }

    public String getOwnership () {
        return ownership;
    }

    public void setOwnership (String ownership){
        this.ownership = ownership;
    }

    public String getPaymentEndDate () {
        return paymentEndDate;
    }

    public void setPaymentEndDate (String paymentEndDate){
        this.paymentEndDate = paymentEndDate;
    }

    public String getPaymentFrequency () {
        return paymentFrequency;
    }

    public void setPaymentFrequency (String paymentFrequency){
        this.paymentFrequency = paymentFrequency;
    }

    public String getPaymentStartDate () {
        return paymentStartDate;
    }

    public void setPaymentStartDate (String paymentStartDate){
        this.paymentStartDate = paymentStartDate;
    }

    public String getRateOfInterest () {
        return rateOfInterest;
    }

    public void setRateOfInterest (String rateOfInterest){
        this.rateOfInterest = rateOfInterest;
    }

    public String getRepaymentTenure () {
        return repaymentTenure;
    }

    public void setRepaymentTenure (String repaymentTenure){
        this.repaymentTenure = repaymentTenure;
    }

    public String getSanctionedAmount () {
        return sanctionedAmount;
    }

    public void setSanctionedAmount (String sanctionedAmount){
        this.sanctionedAmount = sanctionedAmount;
    }

    public String getSettledStatus () {
        return settledStatus;
    }

    public void setSettledStatus (String settledStatus){
        this.settledStatus = settledStatus;
    }

    public String getSettlementAmount () {
        return settlementAmount;
    }

    public void setSettlementAmount (String settlementAmount){
        this.settlementAmount = settlementAmount;
    }

    public String getWrittenOffPrincipal () {
        return writtenOffPrincipal;
    }

    public void setWrittenOffPrincipal (String writtenOffPrincipal){
        this.writtenOffPrincipal = writtenOffPrincipal;
    }

    public String getWrittenOffTotal () {
        return writtenOffTotal;
    }

    public void setWrittenOffTotal (String writtenOffTotal){
        this.writtenOffTotal = writtenOffTotal;
    }

    public String getDisputeRemarks1 () {
        return disputeRemarks1;
    }

    public void setDisputeRemarks1 (String disputeRemarks1){
        this.disputeRemarks1 = disputeRemarks1;
    }

    public String getDisputeRemarks2 () {
        return disputeRemarks2;
    }

    public void setDisputeRemarks2 (String disputeRemarks2){
        this.disputeRemarks2 = disputeRemarks2;
    }

    public String getCibilRemarks () {
        return cibilRemarks;
    }

    public void setCibilRemarks (String cibilRemarks){
        this.cibilRemarks = cibilRemarks;
    }

    public String getErrorCode () {
        return errorCode;
    }

    public void setErrorCode (String errorCode){
        this.errorCode = errorCode;
    }

    public String getSuitFiled () {
        return suitFiled;
    }

    public void setSuitFiled (String suitFiled){
        this.suitFiled = suitFiled;
    }

    public String getPaymentHistory () {
        return paymentHistory;
    }

    public void setPaymentHistory (String paymentHistory){
        this.paymentHistory = this.paymentHistory+paymentHistory;
    }

    public String getTotalAccounts() {
        return totalAccounts;
    }

    public void setTotalAccounts(String totalAccounts) {
        this.totalAccounts = totalAccounts;
    }
    int couunt=1;

    public List<ResponseAccountSegment> parseAccountInformation(String str) throws IOException {
        String word = "TL04T",tag,value;
        int i = 0, count = 1;
        for (i = -1; (i = str.indexOf(word, i - 1)) != -1; i++) {
            ResponseAccountSegment obj = new ResponseAccountSegment();
            String num =String.valueOf(count);
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
                keyValueMap = Utility.asMap ("AccountTypeTable.txt", 2);
                i = i + 4;
                value = str.substring(i, i + 2);
                obj.setAccountType(keyValueMap.get(value));
                i = i + 2;
                tag = str.substring(i, i + 2);

            }


            if (tag.equals("05")) {
                String ownershipIndicator="";
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
            }
            else
            {
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
            }
            else
            {
                //System.out.println(0+" "+ couunt++);
                obj.setAmountOverdue("0");
            }


            while (tag.equals("28") || tag.equals("29")) {
                //System.out.println(tag);
                //paymentHistory="";
                i = i + 2;
                length = Integer.parseInt(str.substring(i, i + 2));
                i = i + 2;
                obj.setPaymentHistory(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);
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


            if (tag.equals("32")) {
                String suitFiled="";
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
                String settledStatus="";
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
                String typeOfCollateral="";
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
                obj.setSettlementAmount(str.substring(i, i + length));
                i = i + length;
                tag = str.substring(i, i + 2);

            }

            if (tag.equals("44")) {
                String paymentFreq="";
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
                keyValueMap = Utility.asMap ("TLerrorCodes.txt", 3);
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

                keyValueMap = Utility.asMap ("TLcibilRemarksCodes" +
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
        return  accountInformationList;
    }

    public static void main (String args[]) throws IOException
    {
        String str = "TUEF1220150101_080008_BKLO       0000XX00001111                    100076615403424032015164450PN03N010110CIBIL EDGE0206SAMPLE0312TEST SUBJECT070830121978080128102ZZ82039998308031120158406PN0001ID03I010102010210AJAPB1602NID03I020102020208B32992109001YID03I030102040216FTN0050012341997PT03T0101096638469890302009001YPT03T02011098507876540302019001YPT03T03010841014105030200PT03T0401072361313030202EC03C010133KRISHNAMURTHI.BALAJI@FISERV.CO.INEC03C020119TSKBALAJI@GMAIL.COMEM03E0101021002081103201503020180081103201582039998308110320158406EM0001SC10CIBILTUSC2010204020210030824032015040500629080201250202260215270207280218290210PA03A010134NEW NO.13 OLD NO.107,UNION CARBIDE0229COLONY,5TH STREET  KODUNGAYUR0313POST,CHENNAI,06023307066001180802021008110320159001YPA03A020134NEW NO.12 OLD NO.107,UNION CARBIDE0229COLONY,5TH STREET  KODUNGAYUR0313POST,CHENNAI,06023307066001180802021008110320159001YPA03A030134NEW NO.11 OLD NO.107,UNION CARBIDE0229COLONY,5TH STREET  KODUNGAYUR0312POST,CHENNAI06023307066001180802021008110320159001YPA03A040135NO 179/1, BUILDING 2, UNION CARBIDE0230COLONY,7TH STREET , KODUNGAYUR0312POST,CHENNAI06023307066001190802021008110320159001YTL04T0010213NOT DISCLOSED0402100501108082404200709082309201411080810201412058514913052612928540000000000000000000000000000000000000000000000000000002954000000000000000000000000000000000000000000XXXXXXXXXXXX300801102014310801112011320200TL04T0020209HDFC BANK03190004346771004493285040210050110808180520040908130720041108311020141205127991303113140310828542122122122122122122122122122122122122122122122122122122954212212212212212212212212212212212212212212212212212212300801102014310801112011330202TL04T0030209HDFC BANK03190005176350000133799040210050110808200520080908150520101108311020141205261451301028540000000000000000000000000000000000000000000000000000002954000000000000000000000000000000000000000000000000000000300801102014310801112011TL04T0040213NOT DISCLOSED040210050110808210420080908240520111108080620111205282271301028540000000000000000000000000000000000000000000000000000002954000000000000000000000000000000000000000000000000000000300801062011310801072008TL04T0050213NOT DISCLOSED0402020501408082801200809081810201110081810201111083107201312071000000130102854STDXXXXXXXXX000020000000000000000000000000XXXXXXXXX0002954XXXXXXXXX000XXXXXXXXXXXXXXX018022020XXX019XXX025000000300801102011310801112008TL04T0060213NOT DISCLOSED0402020501408082812200709080609201210081009201211083107201312071102065130102854STDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX0000000002954000000000000000000000XXXXXXXXX000XXXXXX000000000000XXX300801092012310801102009TL04T0070209HDFC BANK0319000517652100435235904021005011080817052007100814052009110831102014120585762130102854000XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX2921XXXXXXXXXXXXXXXXXXXXX300801052009310801052007TL04T0080213NOT DISCLOSED04021005011080821022006100809062006110831102014130102815000XXX000000000300801062006310801022006440203TL04T0090213NOT DISCLOSED0402020501108081411200509081101200810081501200811083110201412071075000130102854000000000000XXX000XXXXXX001001002XXXXXX0000000010010012912000002XXX0003008010120083108010420068308110320158406TL0001TL04T0100213NOT DISCLOSED04021005011080818102005090829122006100811012008110831122013120541749130102803000300801012008310801012008360553000370521200440203TL04T0110213NOT DISCLOSED04021005011080807102005100813042006110831012010130102821000000000XXX000000000300801042006310801102005TL04T0120213NOT DISCLOSED04021005011080822052004100820102005110830092008120255130102854000060030XXX0000000000000000000000000000000000000000003008090120083108040120078203003840600000186060000018706000001TL04T0130213NOT DISCLOSED0402100501108081805200409081004200610081004200611083108200812047419130102836000000000000000000000000000000000000300801042006310801052005TL04T0140213NOT DISCLOSED04021005011080817052004090806102008100804042010110831012011120532097130102854000XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX2954000000000000XXX000000000000000000XXX000000000000000000300801042010310801052007TL04T0150213NOT DISCLOSED04020505014080830012004090824082005100823012006110831102014120530000130102830STDXXXXXXXXXXXX000000000XXX000300801012006310801042005TL04T0160213NOT DISCLOSED04021005011080822052004100820102005110831052011120255130102803XXX300801102005310801102005TL04T0170213NOT DISCLOSED04021005011080822052004100804062004110831012011120529735130102803XXX300801062004310801062004TL04T0180213NOT DISCLOSED04020505011080830012004090823012006100823012006110831102014120530000130102803XXX300801012006310801012006IQ04I0010108190320150409HDFC BANK05020106041000IQ04I0020108171020140413NOT DISCLOSED05020206075000000IQ04I0030108180320140413NOT DISCLOSED05021006041000IQ04I0040108080220140409HDFC BANK05021006041000IQ04I0050108141020130413NOT DISCLOSED050210060550000IQ04I0060108170720130413NOT DISCLOSED050210060510000IQ04I0070108210220130409HDFC BANK05021006041000IQ04I0080108160220130413NOT DISCLOSED05020206075000000IQ04I0090108160320120409HDFC BANK05021006041000IQ04I0100108080320120413NOT DISCLOSED050210060550000IQ04I0110108240520080413NOT DISCLOSED050210060510000IQ04I0120108180420080409HDFC BANK0502050606800000IQ04I0130108050420080409HDFC BANK0502050606800000IQ04I0140108131220070413NOT DISCLOSED05020206071500000IQ04I0150108120420070413NOT DISCLOSED0502100606300000DR03D010108121120140225THIS IS A DISPUTE REMARKS0322DISPUTE REMARKS PART 2ES0700054120102**";
        new ResponseAccountSegment().parseAccountInformation(str);

    }
}
