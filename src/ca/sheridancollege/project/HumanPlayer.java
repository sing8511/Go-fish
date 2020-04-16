/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Prabhjot
 */
public class HumanPlayer extends Player{
    
    @Override
    public void play()
    {
        Scanner scn = new Scanner(System.in);
        boolean playing = true;
        do{
            Card book = checkForBooks();
            if(book != null)
                System.out.println("You got a book of " + book + "s!");
 
            if (hand.size() == 0)
            {
                System.out.print("Your hand is empty, you must "); //"Go fish!"
                break;
            }
            else
            {
                System.out.print("Your hand:");
                for(Card c: hand)
                    System.out.print(c + " ");
                System.out.println();
            }
 
            System.out.println("Ask opponent for what card?");
 
            Card req;
            try{
                req = Card.getValue(scn.next().toUpperCase());
            }
            catch(IllegalArgumentException e){ //If what you said is not in Card
                System.out.println("Card not present in this deck. Try again:");
                continue;
            }
 
            if(!hand.contains(req))
            {
                System.out.println("You may not ask for a card you have none of. Try again:");
                continue;
            }
 
            System.out.println("You ask for a " + req);
            playing = askFor(req); //If you get card(s), askFor returns true and loops
        } while(playing);
        System.out.println("Go fish!");
        fish();
    
}

    
    
}
