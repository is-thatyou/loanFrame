package contract.cibil.fin360;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anshu Goyal on 22/05/18.
 */
public class ResponsePhoneSegment {

    private String extension;
    private String number;
    private String type;

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResponsePhoneSegment()
    {}
    static List<ResponsePhoneSegment> phoneNumberList = new ArrayList<>();
    public List<ResponsePhoneSegment> parseNumuber(String data) {
        int index = 0;
        int index1 = 0;
        String word = "PT03T0";
        for (int i = -1; (i = data.indexOf(word, i + 1)) != -1; i++) {
            ResponsePhoneSegment obj = new ResponsePhoneSegment();
            index = i;
            index = index + 7;
            String tag = data.substring(index, index + 2);
            index = index + 2;
            if (tag.equals("01")) {
                int length = Integer.parseInt(data.substring(index, index + 2));
                index = index + 2;
                 obj.setNumber(data.substring(index, index + length));
            }
            index1 = i;
            index1 = index1 + 9;
            int length2 = Integer.parseInt(data.substring(index1, index1 + 2));
            index1 = index1 + length2 + 2;
            String tag2 = data.substring(index1, index1 + 2);
            index1 = index1 + 2;
            if (tag2.equals("02")) {
                int length3 = Integer.parseInt(data.substring(index1, index1 + 2));
                index1 = index1 + 2;
                obj.setExtension(data.substring(index1, index1 + length3));
                index1 = index1 + length3;
                tag2 = data.substring(index1, index1 + 2);
                if (tag2.equals("03")) {
                    obj.setType(new ResponsePhoneSegment().numberType(tag2));
                }
            } else if (tag2.equals("03")) {
                obj.setType(new ResponsePhoneSegment().numberType(tag2));
            }
            phoneNumberList.add(obj);
        }
        return phoneNumberList;
    }
    private String numberType(String tag) {
        if (tag.equals("01")) {
            return "Mobile Phone";
        } else if (tag.equals("02")) {
            return "Home Phone";
        } else if (tag.equals("03")) {
            return "Office Phone";
        } else
            return "Not Classified";
    }
   /* public static void main(String[] args) {
        String data ="PT03T01010966384698902066666660302009001YPT03T02011098507876540302019001YPT03T03010841014105030200PT03T0401072361313030202";
        ResponsePhoneSegment mt = new ResponsePhoneSegment();
        mt.parseNumuber(data);
        Iterator itr = phoneNumberList.iterator();
        while (itr.hasNext())
        {
            ResponsePhoneSegment mt2 =(ResponsePhoneSegment) itr.next();
            System.out.println(mt2.getNumber()+" "+mt2.getExtension()+" "+mt2.getType());
        }
    }*/
}




