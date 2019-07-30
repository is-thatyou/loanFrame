package contract.cibil.fin360;

public class ResponseScoreSegment {
    private int score;
    private String scoreName;
    CibilUploadResult cibil;

    {
        cibil = new CibilUploadResult();
    }

    public void scoreDetails(String tuefResponse)
    {
        String word="SC10";
        int index=0;
        int length=0;
        for(index=-1;(index=tuefResponse.indexOf(word,index+1))!= -1;index++)
        {
            String tag="";
            tag = tuefResponse.substring(index,index+2);
            index=index+2;
            if
            (tag.equals("SC"))
            {
                length=Integer.parseInt(tuefResponse.substring(index,index+2));
                index=index+2;
                scoreName = tuefResponse.substring(index,index+length);
                index=index+length;
                index=index+24;
            }
            tag = tuefResponse.substring(index,index+2);
            index=index+2;
            System.out.println (tag);
            if (tag.equals("04"))
            {
                length=Integer.parseInt(tuefResponse.substring(index,index+2));
                index=index+2;
                score=Integer.parseInt(tuefResponse.substring(index,index+length));
            }
            cibil.setScoreName(scoreName);
            cibil.setScore(score);
        }
    }

    public static void main(String [] args)
    {
        String data = "SC10CIBILTUSC2010204020210030824032015040500629080201250202260215270207280218290210";
        new ResponseScoreSegment().scoreDetails(data);
    }
}
