package com.example.demo.controller;

import com.example.demo.exception.NumberGenerateException;
import com.example.demo.schema.GenerateObject;
import com.example.demo.schema.request.Params;
import com.example.demo.schema.request.RequestGenerateNumber;
import com.example.demo.schema.response.ResponseGenerateNumber;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Controller
public class NumberController {

    private RestTemplate restTemplate;
    private Random random;

    public NumberController() {
        this.restTemplate = new RestTemplate();
        this.random = new Random();
    }

    public GenerateObject addNumber() {

        Integer numberFromApi = generateNumberFromApi();
        int randomNumber = getRandomNumber(1, numberFromApi);

        return new GenerateObject(numberFromApi, randomNumber);
    }

    private int getRandomNumber(int min, int max) {
        return random.ints(min, (max + 1)).findFirst().getAsInt();
    }

    private Integer generateNumberFromApi() {
        HttpEntity httpEntity = new HttpEntity(prepareRequestParam());

        ResponseEntity<ResponseGenerateNumber> response = restTemplate
                .exchange("https://api.random.org/json-rpc/2/invoke",
                    HttpMethod.POST,
                    httpEntity,
                    ResponseGenerateNumber.class
        );

        try {
            //try get one number
            return response.getBody().getResult().getRandom().getData().get(0);
        } catch (Exception ex) {
            throw new NumberGenerateException();
        }
    }

    private RequestGenerateNumber prepareRequestParam() {
        Params params = new Params();
        RequestGenerateNumber generateNumber = new RequestGenerateNumber();
        generateNumber.setParams(params);

        generateNumber.setJsonrpc("2.0");
        generateNumber.setMethod("generateIntegers");
        generateNumber.setId(44);

        params.setApiKey("a89b24ca-1c9e-47b7-a6b3-46caf64021b9");
        params.setN(1);                     //only generate one number
        params.setMin(1);
        params.setMax(100);
        params.setReplacement(true);
        return generateNumber;
    }
}
