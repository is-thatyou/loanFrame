package contract.cibil.request;

import java.util.Scanner;

public class EnquiryAccountNumber {
    private String accountNumber;
    private String segmentTag = "PI03I0";
    private int count;
    private int length;
    EnquiryTuefHeader dataCollection;

    {
        dataCollection = new EnquiryTuefHeader();
    }

    private String enquiryPurpose;

    {
        enquiryPurpose = dataCollection.getEnq_Purpose();
    }

    public String accountNumbers(String numbers) {
        if (numbers.length() > 25 || numbers.contains(" ")) {
            throw new RuntimeException("Invalid Account Number");
        }
        if ((enquiryPurpose.equals("90") || enquiryPurpose.equals("91") || enquiryPurpose.equals("92")) == true &&
                (numbers.isEmpty()) == true) {
            throw new RuntimeException("Enquiry Purpose Selected Must have Account Number");

        } else if (numbers.isEmpty()!=true) {
            length = numbers.length();
            count++;
            accountNumber = segmentTag + count + String.format("%02d", length) + numbers;
        } else {
            count++;
            accountNumber = "";
        }
        return accountNumber;
    }

    public static void main(String[] aaa) {
        EnquiryAccountNumber enq = new EnquiryAccountNumber();
        String num="";
        Scanner scan = new Scanner(System.in);
        System.out.println("How Many Numbers You Will Enter : ");
        int loopIteration = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < loopIteration; i++) {
            System.out.print("Enter Account Number  : ");
            String number = scan.nextLine();
            num =enq.accountNumbers(number);
            System.out.println(num);
        }

    }
}