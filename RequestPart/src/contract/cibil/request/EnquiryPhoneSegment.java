package contract.cibil.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnquiryPhoneSegment {
    static int count = 1;
    String segmentTag = "PT03T0";
    String telephoneNumber;
    String telephoneExtension;
    String telephoneType;
    int length;

    public String phoneNumberDetails(String inpNum, String inpExtension, String inpType, int loopitr) {
        long number = 0;

        if (inpNum.matches("^[0-9]+$") != true) {
            throw new NumberFormatException("Phone Number Must Be Digit " +
                    "Only");
        } else if (inpNum.length() < 5) {
            throw new NumberFormatException("PhoneNumber Cannot Be Less Than" +
                    " 5 Digits");
        } else if (inpNum.length() > 20) {
            throw new NumberFormatException(" PhoneNumber Too Large ");
        } else {
            long start = 0;
            long numberLength = 0;
            number = Long.parseLong(inpNum);
            while (number > 0) {
                start = number % 10;
                number = number / 10;
                numberLength++;
            }
            if (start == 1) {
                throw new NumberFormatException("Phone Number cannot start " + "with 1");
            } else if (start == 6 || start == 7 || start == 8 || start == 9) {
                if (numberLength < 10 || numberLength > 10) {
                    throw new NumberFormatException("Number Must Be of 10 " +
                            "digits");
                } else {
                    if (EnquiryPhoneSegment.checkOrder(inpNum) == true) {
                        telephoneNumber = inpNum;
                        length = telephoneNumber.length();
                    }
                }
            } else if (start == 2 || start == 3 || start == 4 || start == 5) {
                if (numberLength < 9 || numberLength > 9) {
                    throw new NumberFormatException("Number Must Have 9" + " Digits");
                } else {
                    if (EnquiryPhoneSegment.checkOrder(inpNum) == true) {
                        telephoneNumber = inpNum;
                        length = telephoneNumber.length();
                    }
                }
            }
            telephoneNumber = segmentTag + count + "01" + String.format("%02d", length) + telephoneNumber;
            count++;
        }
        if (inpExtension.length() > 10) {
            throw new RuntimeException("Invalid Extension Type");
        } else if (inpExtension.isEmpty()) {
            telephoneExtension = "";
        } else {
            telephoneExtension = inpExtension;
            length = telephoneExtension.length();
            telephoneExtension = "02" + String.format("%02d", length) + telephoneExtension;
        }
        if (inpType.matches("^[a-zA-Z ]+$") != true) {
            throw new RuntimeException("Incorrect type");
        } else {
            switch (inpType) {
                case "Not Classified":
                    telephoneType = "00";
                    break;
                case "Mobile Phone":
                    telephoneType = "01";
                    break;
                case "Home Phone":
                    telephoneType = "02";
                    break;
                case "Office Phone":
                    telephoneType = "03";
                    break;
                default:
                    telephoneType = "00";
            }
            telephoneType = "0302" + telephoneType;
        }
        return telephoneNumber+telephoneExtension+telephoneType;
    }

    public static boolean checkOrder(String ber) {
        boolean flag = false;
        long number = Long.parseLong(ber);
        int count = 0;
        long start = 0;
        int numberLength = 0;
        List<Long> list = new ArrayList<>();
        while (number > 0) {
            start = number % 10;
            number = number / 10;
            numberLength++;
            list.add((Long) start);
        }
        long[] arr = new long[numberLength];
        for (int i = 0; i < list.size() - 1; i++) {
            arr[i] = (long) list.get(i);
        }
        long length = arr.length;
        long difference = arr[0] - arr[1];
        for (int i = 2; i < length - 1; i++) {
            if (arr[i] - arr[i + 1] == difference) {
                count++;
            }
        }
        if (count >= length / 2) {
            throw new NumberFormatException("Please Enter A Valid Number !");
        } else {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        EnquiryPhoneSegment request = new EnquiryPhoneSegment();
        Scanner scan = new Scanner(System.in);
        System.out.println("How Many Numbers You Will Enter : ");
        int loopIteration = scan.nextInt();
        scan.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < loopIteration; i++) {
            System.out.println("Enter phone number : ");
            String number = scan.nextLine();
            System.out.println("Enter Extension : ");
            String extension = scan.nextLine();
            System.out.println("Enter Telephone Type");
            String type = scan.nextLine();
            String data = request.phoneNumberDetails(number, extension, type, loopIteration);
            sb.append(data);
        }
        System.out.println(sb);
    }
}
