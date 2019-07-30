package contract.cibil.fin360;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class DateManipulation {
    public static String[] formatStringToDate(String[] dateStr) throws ParseException {

        SimpleDateFormat sdf = null;
        Date [] arrayOfDates = new Date[dateStr.length];
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
        for(String s:dateStr)
        {
            System.out.println(s);
        }
        String oldest = dateStr[0];
        String recent = dateStr[dateStr.length-1];
        System.out.println(oldest+"-------------------------"+recent);
        return dateStr;
    }

    /*public static String formatDateToString(Date date, int format) {

        SimpleDateFormat sdf = null;

        switch (format) {
            case 1: {
                sdf = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 2: {
                sdf = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 3: {
                sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 4: {
                sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 5: {
                sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 6: {
                sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 7: {
                sdf = new SimpleDateFormat("MMMyyyy", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 8: {
                sdf = new SimpleDateFormat("MMM-yyyy", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 9: {
                sdf = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 10: {
                sdf = new SimpleDateFormat("MM yyyy", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 11: {
                sdf = new SimpleDateFormat("yyyy MM", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 12: {
                sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 13: {
                sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                return sdf.format(date);
            }
            case 14: {
                sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
                return sdf.format(date);
            }
            default: {
                sdf = new SimpleDateFormat("MM/dd/yy", Locale.ENGLISH);
                return sdf.format(date);
            }
        }*/
    public static void main(String [] args) throws ParseException {
        /*Date date1 = DateManipulation.formatStringToDate("19051997",4);
        Date date2 = DateManipulation.formatStringToDate("29072019",4);
        System.out.println(date1+"\n"+date2);
        if(date2.compareTo(date1)>0)
        {
            System.out.println(date2 +": is before "+ date1);
        }
        else
        {
            System.out.println(date1 +": is afret "+ date2);
        }
        System.out.println(DateManipulation.formatDateToString(date1,00));*/
        String[] date = {"19051997","30031996","23091998","25121996"};
        new DateManipulation().formatStringToDate(date);
    }
}
