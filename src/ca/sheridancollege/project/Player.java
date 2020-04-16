/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author Sivagama
 * @modifier Prabhjot
 */
public abstract class Player 
{
    ArrayList<Card> hand = new ArrayList<>();
    private int numBooks;
 
    public Player()
    {
        for(int i=0;i<8;i++)
            fish();
    }
 
    public boolean hasGiven(Card cType)
    {
        return hand.contains(cType);
    }
 
    public ArrayList<Card> giveAll(Card cType)
    {
        ArrayList<Card> x = new ArrayList<Card>(); //Complicated because simply taking the cards as they
        for(int i=0;i<hand.size();i++)            //are found would mess up the traversing of the hand
            if (hand.get(i) == cType)
              x.add(hand.get(i));
        for(int c=0;c<x.size();c++)
            hand.remove(cType);
        return x;
    }
 
     public boolean askFor(Card cType)
    {
        int tmp = 0;
        if (this instanceof HumanPlayer)
            tmp = 1;
        Player other = GoFish.Players[tmp];
 
        //Used for the computer's strategy//
        if (tmp==1)
            ((AIPlayer) other).queries.add(cType);
        //                               //
 
        if (other.hasGiven(cType))
        {
            for(Card c: other.giveAll(cType))
                hand.add(c);
            return true;
        }
        else
        {
            return false;
        }
    }
 
    public void fish()
	    {
	        if (GoFish.deckSize() > 0)
	        	hand.add(GoFish.draw());
	        else
	        	System.out.println("But that's impossible since the deck is empty.");
    }
 
    public int getNumBooks()
    {
        return numBooks;
    }
 
    public Card checkForBooks()
    {
        for(Card c: hand) //Not very elegant!
        {
            int num = 0;
            for(Card d: hand)
              if (c == d)
                  num++;
            if (num == 4)
            {
                for(int i=0;i<4;i++)
                    hand.remove(c);
                numBooks++;
                return c;
            }
        }
        return null;
 
 
    }
    
 
    public abstract void play();
    
}


