package com.loanframe.lfcibil.contract;

/*import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;*/

/**
 * Created by Anshu Goyal on 22/05/18.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetClassificationList {

    //@JsonProperty("code")
    private String code;
    //@JsonProperty("date")
    private String date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

