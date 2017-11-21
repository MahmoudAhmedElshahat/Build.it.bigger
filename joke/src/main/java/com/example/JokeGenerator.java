package com.example;

import java.util.Random;

public class JokeGenerator {

    public static String [] jokes= {
            "What kind of doctor fixes broken websites? \n" +
                    "An URLologist."
            ,
            "My dog likes to sit down each evening and surf the Net. What an intelligent animal! Not really, it took the cat three weeks to teach him."
            ,
            "What’s O. J. Simpson’s Internet address? \n" +
                    "Slash, slash, backslash, slash, slash, escape."
            ,
            "Does your mum like shopping on the Internet? \n" +
                    "No, the trolley keeps rolling off the top of the computer."
    };



    public String generate() {
        return jokes[new Random().nextInt(jokes.length -1)];
    }
}
