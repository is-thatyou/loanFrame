package contract.cibil.request;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class EnquiryTuefHeader {
    private final String SEGMENT_TAG ="TUEF";
    private final int VERSION = 12;
    private String memberRefNumber="";
    private final String FUTURE_USE02="  ";
    private String memberUserId="";
    private String password="";
    private String enq_Purpose="";
    public String getEnq_Purpose() {
        return enq_Purpose;
    }

    public void setEnq_Purpose(String enq_Purpose) {
        this.enq_Purpose = enq_Purpose;
    }

    private String enq_Amount="000000000";
    private final String FUTURE_USE03="   ";
    private String scoreType="";
    private String outputFormat="";
    private final int RESPONSE_SIZE=1;
    private String ioMedia="";
    private String authenticationMethod="";

    public String tuefSegment(String... arr) {
        StringBuffer temp = new StringBuffer();
        temp.append(arr[0]);
        if (temp.length() > 25)
            throw new RuntimeException("Name cannot be more than 25 characters");
        else {
            if (temp.length() <= 25) {
                int length = temp.length();
                while (length < 25) {
                    temp.append(' ');
                    length++;
                }
                memberRefNumber = temp.toString();
                temp.delete(0, temp.length());
            }
        }
        temp.append(arr[1]);
        if (temp.length() > 30)
            throw new RuntimeException("UserId cannot be more than " +
                    "30 characters");
        else {
            if (temp.length() <= 30) {
                int length = temp.length();
                while (length < 30) {
                    temp.append(' ');
                    length++;
                }
                memberUserId = temp.toString();
                temp.delete(0, temp.length());
            }
        }
        if (arr[2].matches("^[a-zA-Z0-9]+$") != true)
            throw new RuntimeException("only number and characters " +
                    "are allowed");
        temp.append(arr[2]);
        if (temp.length() > 30)
            throw new RuntimeException("Password length is too large");
        else {
            if (temp.length() <= 30) {
                int length = temp.length();
                while (length < 30) {
                    temp.append(' ');
                    length++;
                }
                password = temp.toString();
                temp.delete(0, temp.length());
            }
        }
        String purpose = arr[3];
        if (purpose.matches("^[a-zA-Z- /()]+$") != true) {
            throw new RuntimeException("Invalid Enquiry Purpose");
        } else {
            Map<String, String> myMap;
            myMap = new ToMap().asMap("C:\\Users\\LoanFrame " +
                            "User\\Desktop\\Useful " +
                            "Data\\RequestPart\\src\\EnquiryPurposeTable.txt"
                    , 2);
            enq_Purpose = myMap.get(purpose);
        }
        if (enq_Purpose.equals("88") || enq_Purpose.equals("90") || enq_Purpose.equals("91") || enq_Purpose.equals("92")) {
            enq_Amount = "000000000";
        } else {
            String temp2 = (arr[4]);
            if (0 >= (Integer.parseInt(temp2)) || temp2.length() > 9 || temp2.matches("^[0-9]+$") != true) {
                throw new NumberFormatException("Please enter a " + "valid amount");
            } else {
                enq_Amount = enq_Amount.substring(temp2.length()) + temp2;
            }
        }
        String tempScore = "";
        String type = arr[5];
        switch (type) {
            case "Not requesting a score":
                tempScore = "00";
                break;
            case "Requesting the CIBIL TransUnion Score Version 1" +
                    ".0 (CIBILTUSCR) only":
                tempScore = "01";
                break;
            case "Requesting the Person Loan Score (PLSCORE) only":
                tempScore = "02";
                break;
            case "Requesting both the CIBILTUSCR and PLSCORE scores":
                tempScore = "03";
                break;
            case "Requesting the CIBIL TransUnion Score Version 2.0 " +
                    "(CIBILTUSC2) only":
                tempScore = "04";
                break;
            case "Requesting both the CIBILTUSC2 and PLSCORE scores":
                tempScore = "06";
                break;
            default:
                tempScore = "00";
        }
        if (enq_Purpose.equals("91") && tempScore.equals("00")) {
            scoreType = "04";
        } else if (enq_Purpose.equals("88") || enq_Purpose.equals("92")) {
            scoreType = "00";
        } else {
            scoreType = tempScore;
        }
        String outFormat = arr[6];
        String regex = "^[a-zA-Z- ]+$";
        if (outFormat.matches(regex) != true) {
            throw new RuntimeException("Only Allowed Special " +
                    "Characters Are[- , space]");
        } else {
            switch (outFormat) {
                case "Machine-Readable Formatted Response Record":
                    outputFormat = "01";
                    break;
                case "Print Image Report":
                    outputFormat = "02";
                    break;
                case "Tab-delimited Report":
                    outputFormat = "01";
                    break;
                default:
                    outputFormat = "01";
            }
        }
        String media = arr[7];
        if (enq_Purpose.equals("88") || enq_Purpose.equals("90") || enq_Purpose.equals("91") || enq_Purpose.equals("92")) {
            ioMedia = "TT";
        } else if (media.equals("CPU-to-CPU")) {
            ioMedia = "CC";
        } else if (media.equals("Tape-to-Tape")) {
            ioMedia = "TT";
        } else {
            throw new RuntimeException("Invali Input/Output Media " +
                    "Used");
        }
        String method = arr[8];
        if (method.matches("^[a-zA-Z]+$") == false) {
            throw new RuntimeException("Invalid data");
        } else {
            if (method.equals("Legacy"))
                authenticationMethod = "L";
            else if (method.equals("Advanced"))
                authenticationMethod = "A";
            else
                authenticationMethod = "L";
        }
        return SEGMENT_TAG+VERSION+memberRefNumber+FUTURE_USE02+memberUserId+password+
                enq_Purpose+enq_Amount+FUTURE_USE03+scoreType+outputFormat+RESPONSE_SIZE+ioMedia+authenticationMethod;
    }
    public static void main(String... jos) {
        Scanner input = new Scanner (System.in);
        String[] data = new String[9];
        for (int i=0; i<data.length; i++) {
            data[i]= input.nextLine ();
        }
        System.out.println(new EnquiryTuefHeader ().tuefSegment(data));
    }
}

