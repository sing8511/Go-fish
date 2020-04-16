/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import static java.lang.Character.toUpperCase;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author prabhjot
 */
public abstract class GoFish extends Game
{
    static final Random rng = new Random();
    static private ArrayList<Card> cards;
    static public Player[] Players;
 
    public static Card draw()
	{
		return cards.remove(rng.nextInt(cards.size()));
	}
 
	public static int deckSize()
	{
		return cards.size();
    }
 
    public static void main(String[] args)
    {
 
        cards = new ArrayList<Card>();
        for(int i=0;i<4;i++)
            for(Card c: Card.VALUES)
                cards.add(c);
        Player human = new HumanPlayer();
        Player comp = new AIPlayer();
        Players = new Player[] {human, comp};
 
        while(Players[0].getNumBooks() + Players[1].getNumBooks() < 13)
        {
            Players[0].play();
            System.out.println("----------");
            Players[1].play();
            System.out.println("----------");
        }
 
        int humanScore = Players[0].getNumBooks(); int compScore = Players[1].getNumBooks();
        if (humanScore > compScore)
            System.out.println("Congratulations, you win "+ humanScore + " to "+ compScore +"!");
        else if (compScore > humanScore)
            System.out.println("The terrible AI beat you "+ humanScore + " to "+ compScore +"...");
        else
            System.out.println("It's a tie at "+humanScore+" each!");
    }

    public GoFish(String givenName) {
        super(givenName);
    }
}
    

