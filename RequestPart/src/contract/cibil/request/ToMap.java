package contract.cibil.request;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ToMap {
    Map<String,String> myMap = new HashMap<>();
    String key;
    String value;
    public Map asMap(String fileName , int index)
    {
        String line="";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while((line=bufferedReader.readLine())!=null) {
                value = line.substring(0, index);
                key = line.substring(index).trim();
                myMap.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myMap;
    }
}
