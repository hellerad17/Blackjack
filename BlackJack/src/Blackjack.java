import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author Andrew Heller
 * Copyright (C) 2020 Blackjack Project 
 *
 */
public class Blackjack
{
	private final int MIN = 100;
	private final int MAX = 10000;
	private static Random rand;
	/***
	 * 
	 */
	private static ArrayList<Opponent> opponents;
	/***
	 * 
	 */
	public Blackjack(int numPlayers) throws IOException
	{
		Blackjack.opponents = new ArrayList<>();
		addPlayersToTable(numPlayers);
	}
	public int getSize() {
		return opponents.size();
	}
	/***
	 * 
	 * @param numberOfPlayers
	 * @throws IOException
	 */
	public void addPlayersToTable(int numberOfPlayers) throws IOException
	{
		for(int i = 0; i < numberOfPlayers;i++)
		{
			opponents.add(new Opponent());
		}
	}
	/***
	 * 
	 * @param i
	 * @return
	 */
	public Opponent getOpponents(int i)
	{
		return this.opponents.get(i);
	}
	/***
	 * 
	 */
	public static void gameRules()
	{
		System.out.println("  BLACKJACK RULES: " + "\n\t-Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down." 
		+ "\n\t-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11."
		+ "\n\t-The players cards are added up for their total."
		+ "\n\t-Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total."
		+ "\n\t-Dealer “Hits” until they equal or exceed 17."
		+ "\n\t-The goal is to have a higher card total than the dealer without going over 21."
		+ "\n\t-If the player total equals the dealer total, it is a “Push” and the hand ends."
		+ "\n\t-Players win their bet if they beat the dealer. Players win 1.5x their bet if they get “Blackjack” which is 21.\n\n");
	}
	/**
	 * Determines if a user has input hit or stand.
	 * @param i
	 * @return
	 */
	public static boolean isHitorStand(int i)
	{
		boolean hitter = opponents.get(i).getDecision();
	    if(hitter==true)
	    {
	    	//opponent or player will hit
	        return true;
	    }
	    //opponent or player will stand
	    return false;
	}
	/**
	 * Determines if a user has busted.
	 * @param handvalue
	 * @return boolean
	 */
	public static boolean checkBust(int handvalue)
	{
	    if(handvalue>21)
	    {
	    	rand = new Random();
	    	int ranSentence =  rand.nextInt(10)+1;
	    	switch(ranSentence)
	    	{
	    	case 1: System.out.println("Busted!");
	    	case 2: System.out.println("Sorry, that's a Bust!");
	    	case 3: System.out.println("Can't go further! That's a Bust!");
	    	case 4: System.out.println("Better luck next time!");
	    	case 5: System.out.println("You went over 21, that's a Bust!");
	    	case 6: System.out.println("Be more careful next time! That's a Bust!");
	    	case 7: System.out.println("Bussssttteeeeed!!!");
	    	case 8: System.out.println("Over 21, that's a Bust!");
	    	case 9: System.out.println("Your streak is over, Bust!");
	    	case 10: System.out.println("You Lose, went over 21!");
	    	}
	        return true;
	    }
	    return false;
	}
	/**
	 * Called if the user wins. 
	 * Adds money to the players or opponents account and 
	 * @return String
	 */
	public static void Win()
	{
	}
	/**
	 * Called if the user loses.
	 */
	public static void Lose()
	{
	}
	/**
	 * Called if the opponent/player
	 * @throws FileNotFoundException 
	 */
	public static void opponentPush(int i) throws FileNotFoundException
	{
		rand = new Random();
    	//int ranSentence =  rand.nextInt(10)+1;
		int ranSentence = 1;
    	switch(ranSentence)
    	{
    	case 1: System.out.println("It's a push!");
    	}
	    
	    System.out.println("You get your money back " + opponents.get(i).getName());
	    System.out.println("Cash: "+ opponents.get(i).getAmount());
	}
	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean checkForBlackjack(Challenger c)
	{
		return c.getDeck().size() == 2 && c.cardsValue() == 21;
	}
	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean checkForTwentyOne(Challenger c)
	{
		return c.getDeck().size() >= 2 && c.cardsValue() == 21;
	}
	/***
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		gameRules();
		Blackjack one = new Blackjack(6);
		System.out.println(Blackjack.opponents.get(2));
	}
}