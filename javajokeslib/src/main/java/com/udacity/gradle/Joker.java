package com.udacity.gradle;

import java.util.Random;

public class Joker {

    //Initialize a finite array of 20 jokes
    private String[] jokesDB = new String[10];

    private void populateStringArray(){
        jokesDB[0] = " It’s hard to explain puns to kleptomaniacs\n\n" +
                "because they always take things literally.";
        jokesDB[1] = "I used to think the brain was the most important organ.\n\n" +
                "Then I thought, look what’s telling me that.";
        jokesDB[2] = "Just went to an emotional wedding. \n\n" +
                "Even the cake was in tiers.";
        jokesDB[3] = "I started a band called 999 Megabytes \n\n" +
                "— we haven’t gotten a gig yet.";
        jokesDB[4] = "What do you call a dinosaur with a extensive vocabulary? \n\n" +
                "A thesaurus.";
        jokesDB[5] = "I wrote a song about a tortilla. \n\n" +
                "Well actually, it’s more of a wrap.";
        jokesDB[6] = "What did Jay-Z call his girlfriend before they got married? \n\n" +
                "Feyoncé.";
        jokesDB[7] = "What’s the best part about living in Switzerland? \n\n" +
                "Not sure, but the flag is a big plus.";
        jokesDB[8] = "Why can’t a bike stand on its own? \n\n" +
                "It’s two tired.";
        jokesDB[9] = "Why didn’t the lifeguard save the hippie? \n\n" +
                "Because he was too far out man!";
    }

    public String getJoke(){

        //Populate your jokes database
        populateStringArray();

        //Generate a random number from 0 to 9
        int randomInt = 0; //Default

        //note a single Random object is reused here
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(10);

        //Pull the joke from your little db
        String joke = jokesDB[randomInt];

        return joke;
    }

}