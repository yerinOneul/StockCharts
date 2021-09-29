package com.example.stockcharts.data;

public class listData {
    private String issue, code, currentPrice, upDown,upDownRate;

    public listData(String issue, String code, String currentPrice, String upDown, String upDownRate){
        this.issue = issue;
        this.code = code;
        this.currentPrice = currentPrice;
        this.upDown = upDown;
        this.upDownRate = upDownRate;
    }



    public String getIssue(){
        return this.issue;
    }

    public String getCode(){
        return this.code;
    }

    public String getCurrentPrice(){
        return this.currentPrice;
    }

    public String getUpDown(){
        return this.upDown;
    }

    public String getUpDownRate(){
        return this.upDownRate;
    }
}
