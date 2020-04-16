/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Prabhjot
 */


 public class AIPlayer extends Player
{
    public ArrayList<Card> queries = new ArrayList<Card>();
    private int age = 0;
 
    @Override
    public void play()
    {
        boolean playing;
        do{
            Card book = checkForBooks();
            if(book != null)
                System.out.println("Your opponent got a book of " + book + "s...");
            if (hand.size() == 0)
            {
                System.out.print("Your opponent's hand is empty.");
                break;
            }
            Card req = aiMagic();
            System.out.println("Your opponent asks for cards by the name of " + req);
            playing = askFor(req);
            age++;
        } while(playing);
        System.out.println("Your opponent goes fishing.");
        fish();
    }
    private Card aiMagic()
    {
        if (age>2)
        {
            queries.remove(queries.size()-1); //gets rid of oldest entry so it won't 
            age=0;                           //get stuck asking for the same thing
        }
        for(int i=queries.size()-1; i>-1; i--) //(maybe a queue would have been better?)
            if (hand.contains(queries.get(i)))
            {
                return queries.remove(i); //once it extracts a card from you, it will stop
            }                            //asking for that card, until YOU ask for it again.
        return hand.get(GoFish.rng.nextInt(hand.size()));
    }

    
 


}
