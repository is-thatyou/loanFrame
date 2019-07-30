package contract.cibil.fin360;
/*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
*/

import utli.cibil.fin360.Utility;

import java.util.*;

/**
 * Created by Anshu Goyal on 22/05/18.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseEnquirySegment {
    public String enquiryPurpose;
    public String dateOfEnquiry;
    public String enquiryAmount;
    public String memberName;

    public ResponseEnquirySegment() {
    }

    private ResponseEnquirySegment(String dateOfEnquiry,String memberName,String enquiryPurpose,String enquiryAmount ) {
        this.dateOfEnquiry = dateOfEnquiry;
        this.enquiryPurpose = enquiryPurpose;
        this.memberName = memberName;
        this.enquiryAmount = enquiryAmount;
    }

    CibilUploadResult cibil;

    {
        cibil = new CibilUploadResult();
    }
    List<ResponseEnquirySegment> enquiryInformationList;

    {
        enquiryInformationList = new ArrayList<>();
    }
    Map<String , String> mapRepresentation = new HashMap<>();
    public void enquirySegment(String tuefResponse)
    {
        String word="IQ04I";
        int index=0;
        String tag="";
        for ( index = -1; (index = tuefResponse.indexOf(word, index-1)) != -1; index++)
        {

            index=index+8;
            tag=tuefResponse.substring(index,index+2);
            index=index+2;
            if(tag.equals("01"))
            {
                String[] details = new ResponseEnquirySegment().tagDetails(tuefResponse,index);
                index=Integer.parseInt(details[0]);
                dateOfEnquiry=details[1];
                tag = tuefResponse.substring(index,index+2);
                index=index+2;
            }
            if(tag.equals("04"))
            {
                String[] details = new ResponseEnquirySegment().tagDetails(tuefResponse,index);
                index=Integer.parseInt(details[0]);
                memberName=details[1];
                tag = tuefResponse.substring(index,index+2);
                index=index+2;
            }
            if(tag.equals("05"))
            {
                String[] details = new ResponseEnquirySegment().tagDetails(tuefResponse,index);
                index=Integer.parseInt(details[0]);
                enquiryPurpose=details[1];
                mapRepresentation= Utility.asMap("C:\\Users\\LoanFrame User\\Desktop\\" +
                       "Useful Data\\fin360\\AccountTypetable.txt",2);
                enquiryPurpose=(mapRepresentation.get(enquiryPurpose));
                tag = tuefResponse.substring(index,index+2);
                index=index+2;
            }
            if(tag.equals("06"))
            {
                String[] details = new ResponseEnquirySegment().tagDetails(tuefResponse,index);
                index=Integer.parseInt(details[0]);
                enquiryAmount=details[1];
            }
            ResponseEnquirySegment eq = new ResponseEnquirySegment(dateOfEnquiry,memberName,enquiryPurpose,enquiryAmount);
            enquiryInformationList.add(eq);
        }
        cibil.setResponseEnquirySegment(enquiryInformationList);
        Iterator itr =enquiryInformationList.iterator();

        while (itr.hasNext()) {
            ResponseEnquirySegment enq = (ResponseEnquirySegment) itr.next();
            System.out.println(enq.dateOfEnquiry + " " + enq.memberName + " " + enq.enquiryPurpose + " " + enq.enquiryAmount);
        }


    }
    public String[] tagDetails(String tuefResponse, int index)
    {
        String tagData;
        String[] str = new String[2];
        int length=Integer.parseInt(tuefResponse.substring(index,index+2));
        index=index+2;
        tagData=tuefResponse.substring(index,index+length);
        index=index+length;
        str[0]=String.valueOf(index);
        str[1]=tagData;
        return str;
    }

    public static void main(String [] args)
    {
        String data = "IQ04I0010108190320150409HDFC BANK05020106041000IQ04I0020108171020140413NOT " +
                "DISCLOSED05020206075000000IQ04I0030108180320140413NOT DISCLOSED05021006041000IQ04I0040108080220140409HDFC " +
                "BANK05021006041000IQ04I0050108141020130413NOT DISCLOSED050210060550000IQ04I0060108170720130413NOT " +
                "DISCLOSED050210060510000IQ04I0070108210220130409HDFC BANK05021006041000IQ04I0080108160220130413NOT " +
                "DISCLOSED05020206075000000IQ04I0090108160320120409HDFC BANK05021006041000IQ04I0100108080320120413NOT " +
                "DISCLOSED050210060550000IQ04I0110108240520080413NOT DISCLOSED050210060510000IQ04I0120108180420080409HDFC " +
                "BANK0502050606800000IQ04I0130108050420080409HDFC BANK0502050606800000IQ04I0140108131220070413NOT " +
                "DISCLOSED05020206071500000IQ04I0150108120420070413NOT DISCLOSED0502100606300000   ";
        new ResponseEnquirySegment().enquirySegment(data);
    }



}

