package contract.cibil.fin360;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anshu Goyal on 22/05/18.
 */

public class ResponseEmailSegment {
    private String emailAddress;
    CibilUploadResult cibil;

    {
        cibil = new CibilUploadResult();
    }

    static List<ResponseEmailSegment> emailAddressList;

    static {
        emailAddressList = new ArrayList<>();
    }
    int index;
    private ResponseEmailSegment()
    {}
    private ResponseEmailSegment(String emailAddress)
    {
        this.emailAddress=emailAddress;
    }

    private void emaliInfo(String data)
    {
        String word ="EC03C0";
        for (int i = -1; (i = data.indexOf(word, i + 1)) != -1; i++)
        {
            index = i;
            index = index+9;
            int length = Integer.parseInt(data.substring(index,index+2));
            index=index+2;
            emailAddress = data.substring(index,index+length);
            ResponseEmailSegment email = new ResponseEmailSegment(emailAddress);
            emailAddressList.add(email);
        }
        cibil.setResponseEmailSegment(emailAddressList);
    }

    public static void main(String [] args)
    {
        String data = "EC03C010133KRISHNAMURTHI.BALAJI@FISERV.CO.INEC03C020119TSKBALAJI@GMAIL.COM";
        new ResponseEmailSegment().emaliInfo(data);
        Iterator itr = emailAddressList.iterator();
        while (itr.hasNext())
        {
            ResponseEmailSegment e = (ResponseEmailSegment)itr.next();
            System.out.println(e.emailAddress);
        }
    }
}


