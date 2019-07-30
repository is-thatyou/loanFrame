package contract.cibil.fin360;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResponseAddressSegment {
    private String address;
    private String stateCode;
    private String pin;
    private String category;
    private String residenceCode;
    private String dateReported;
    private String memberSName;
    private String enrichedThrEnquiry;

    CibilUploadResult cibil;

    {
        cibil = new CibilUploadResult ();
    }

    static List<ResponseAddressSegment> contactInformationList;

    static {
        contactInformationList = new ArrayList<> ();
    }

    public ResponseAddressSegment() {
    }

    private ResponseAddressSegment(
            String address,
            String stateCode,
            String pin,
            String category,
            String residenceCode,
            String dateReported,
            String memberSName,
            String enrichedThrEnquiry) {
        this.address = address;
        this.stateCode = stateCode;
        this.pin = pin;
        this.category = category;
        this.residenceCode = residenceCode;
        this.dateReported = dateReported;
        this.memberSName = memberSName;
        this.enrichedThrEnquiry = enrichedThrEnquiry;
    }

    private void contactInformation(String tuefResponse) {
        String word = "PA03A0";
        int index = 0;
        for (index = -1; (index = tuefResponse.indexOf (word, index + 1)) != -1; index++) {
            String tag = "";
            String tempAddress = "";
            index = index + 7;
            tag = tuefResponse.substring (index, index + 2);
            index = index + 2;
            if (tag.equals ("01")) {
                String[] arguments = new ResponseAddressSegment ().addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                tempAddress = arguments[1];
                address = tempAddress;
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("02")) {
                String[] arguments = new ResponseAddressSegment ().addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                tempAddress = arguments[1];
                address = address + tempAddress;
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("03")) {
                String[] arguments = new ResponseAddressSegment ().addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                tempAddress = arguments[1];
                address = address + tempAddress;
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("04")) {
                String[] arguments = ResponseAddressSegment.addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                tempAddress = arguments[1];
                address = address + tempAddress;
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("05")) {
                String[] arguments = ResponseAddressSegment.addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                tempAddress = arguments[1];
                address = address + tempAddress;
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("06")) {
                String[] arguments =  ResponseAddressSegment.addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                stateCode = arguments[1];
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("07")) {
                String[] arguments = ResponseAddressSegment.addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                pin = arguments[1];
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("08")) {
                String[] arguments = ResponseAddressSegment.addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                category = arguments[1];
                if (category.equals ("01")) {
                    category = "Permanent Address";
                } else if (category.equals ("02")) {
                    category = "Residence Address";
                } else if (category.equals ("03")) {
                    category = "Office Address";
                } else {
                    category = "Not Categorized";
                }
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("09")) {
                String[] arguments = ResponseAddressSegment.addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                residenceCode = arguments[1];
                if (residenceCode.equals ("01")) {
                    residenceCode = "Owned";
                    } else {
                    residenceCode = "Rented";

                }
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("10")) {
                String[] arguments = ResponseAddressSegment.addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                dateReported = arguments[1];
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("11")) {
                String[] arguments = ResponseAddressSegment.addressDelt (tuefResponse, index);
                index = Integer.parseInt (arguments[0]);
                memberSName = arguments[1];
                tag = tuefResponse.substring (index, index + 2);
                index = index + 2;
            }
            if (tag.equals ("90")) {
                String[] arguments = ResponseAddressSegment.addressDelt (tuefResponse, index);
                enrichedThrEnquiry = arguments[1];
            }
            ResponseAddressSegment cil = new ResponseAddressSegment (address, stateCode, pin, category, residenceCode, dateReported, memberSName, enrichedThrEnquiry);
            contactInformationList.add (cil);
        }
        cibil.setResponseAddressSegment (contactInformationList);

    }

    public static String[] addressDelt(String tuefResponse, int index) {
        String tempAddress;
        String[] str = new String[2];
        int length = Integer.parseInt (tuefResponse.substring (index, index + 2));
        index = index + 2;
        tempAddress = tuefResponse.substring (index, index + length);
        index = index + length;
        str[0] = String.valueOf (index);
        str[1] = tempAddress;
        return str;
    }

    public static void main(String[] arg) {
        String data = "PA03A010134NEW NO.13 OLD NO.107,UNION CARBIDE0229COLONY,5TH STREET  KODUNGAYUR0313POST,CHENNAI,06023307066001180802021008110320159001YPA03A020134NEW " +
                "NO.12 OLD NO.107,UNION CARBIDE0229COLONY,5TH STREET  KODUNGAYUR0313POST,CHENNAI,06023307066001180802021008110320159001YPA03A030134NEW NO.11 OLD NO.107," +
                "UNION CARBIDE0229COLONY,5TH STREET  KODUNGAYUR0312POST,CHENNAI06023307066001180802021008110320159001YPA03A040135NO 179/1, BUILDING 2, UNION CARBIDE0230COLONY," +
                "7TH STREET , KODUNGAYUR0312POST,CHENNAI06023307066001190802021008110320159001Y";

        new ResponseAddressSegment().contactInformation (data);
        Iterator itr = contactInformationList.iterator ();
        while (itr.hasNext ()) {
            ResponseAddressSegment e = (ResponseAddressSegment) itr.next ();
            System.out.println (e.address);
            System.out.println (e.stateCode);
            System.out.println (e.pin);
            System.out.println (e.category);
            System.out.println (e.residenceCode);
            System.out.println (e.dateReported);
            System.out.println (e.memberSName);
            System.out.println (e.enrichedThrEnquiry);
        }
    }
}
