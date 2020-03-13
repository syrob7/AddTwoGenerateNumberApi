package com.example.demo.schema;

public class GenerateObject {
    private Integer apiNumber;
    private Integer randomNumber;

    public GenerateObject(Integer apiNumber, Integer randomNumber) {
        this.apiNumber = apiNumber;
        this.randomNumber = randomNumber;
    }

    public Integer getApiNumber() {
        return apiNumber;
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public Integer getSum() {
        return apiNumber + randomNumber;
    }
}
