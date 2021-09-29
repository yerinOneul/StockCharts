package com.example.stockcharts.data;

public class candleData {

    Float createdAt, open, close, high, low;
    // x좌표, 시가, 종가, 최고가, 최저가

    public candleData(Float createdAt, Float open, Float close, Float high, Float low){
        this.createdAt = createdAt;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    public Float getCreatedAt(){
        return  this.createdAt;
    }

    public Float getOpen(){
        return this.open;
    }

    public Float getClose(){
        return this.close;
    }

    public Float getHigh(){
        return this.high;
    }

    public Float getLow(){
        return this.low;
    }



}
