package utli.cibil.fin360;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utility {
    public static String[] formatStringToDate(String[] dateStr) throws ParseException {

        SimpleDateFormat sdf = null;
        Date[] arrayOfDates = new Date[dateStr.length];
        for(int i=0;i<dateStr.length;i++)
        {
            sdf = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
            arrayOfDates[i]=sdf.parse(dateStr[i]);
        }
        Arrays.sort(arrayOfDates);
        for(int i=0;i<dateStr.length;i++)
        {
            sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            dateStr[i] = sdf.format(arrayOfDates[i]);
        }
        return dateStr;
    }

    public static Map asMap(String fileName , int index)
    {
        Map<String,String> myMap = new HashMap<>();
        String key;
        String value;
        String line="";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while((line=bufferedReader.readLine())!=null) {
                key = line.substring(0, index);
                value = line.substring(index).trim();
                myMap.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myMap;
    }
}
