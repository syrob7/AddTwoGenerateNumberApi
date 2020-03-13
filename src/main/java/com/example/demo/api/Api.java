package com.example.demo.api;


import com.example.demo.controller.NumberController;
import com.example.demo.schema.GenerateObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    private NumberController numberController;

    @Autowired
    public Api(NumberController numberController) {
        this.numberController = numberController;
    }

    @GetMapping("/addNumbers")
    public String addNumbers() {
        GenerateObject generateObject = numberController.addNumber();

        StringBuilder response = new StringBuilder();
        response.append("<H2>Rezultat dodawania</H2>");
        response.append("<p> Liczba wygenerowana z api:" + generateObject.getApiNumber() + "</p>");
        response.append("<p> Liczba wygenerowana losowo:" + generateObject.getRandomNumber() + "</p>");
        response.append("<p> Suma liczb:" + generateObject.getSum() + "</p>");

        return response.toString();
    }
}
