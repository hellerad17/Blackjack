package game;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import utils.Value;
/**
 * @author Andrew Heller
 *
 */
public class Blackjack
{
	Random rand;
	private LinkedList<Player> players;
	private User user;
	private Dealer dealer;
	private Deck deck;
	private Scanner scan;
	
	public Blackjack(int numOpponents)
	{
		user = new User();
		deck = new Deck();
		scan = new Scanner(System.in);
		
//		rand = new Random();
//		players = new LinkedList<>();
//		for(int i = 0; i < numOpponents; i++)
//		{
//			players.add(new Opponent());
//		}
//		players.add(rand.nextInt(players.size()), user);
//		players.add(dealer);
//		deck = new Deck();
	}
	
	/* Implementation
	 * 
	 * Print rules
	 * deal cards
	 * go around table, ask if the player/opponent wants to hit or stay
	 * 		if it is a hit, give them another card, then check for a bust and ask again
	 * 		if it is a stay, move on
	 * once every player has been reached, run the dealer's turn
	 * 		if the dealer has 17 or more, he stays (if he has an ace, it counts as 11 for this purpose)
	 * 		if the dealer has 16 or less, he hits
	 * calculate payout (in this order)
	 * 		if a player went bust, they lose their money
	 * 		if the dealer went bust, he pays out equal bets to the players
	 * 		if the dealer stands at 21 or less, he pays out any player with a total higher than his (1.5x if its blackjack) and collects the bets of any lower
	 * 		if the player and dealer have equal numbers, the bet is returned and nothing is paid
	 * return to the deal cards phase
	 */
	public void gameLoop()
	{		
		printGameRules();
		user.addCard(deck.draw());
		user.addCard(deck.draw());
		System.out.println(user.handToString());
		System.out.println("Type H to hit or S to stay");
		boolean stillPlayingHand = true;
		while(stillPlayingHand)
		{
			String next = scan.next();
			if(next.charAt(0) == 'H' || next.charAt(0) == 'h') 
			{
				System.out.println("\nHits for new card");
				Card hit = deck.draw();
				System.out.println(hit.toString());
				user.addCard(hit);
				System.out.println("\n" + user.handToString());
				
				if(user.determineHandValue() > 21)
				{
					System.out.println("Busted");
					stillPlayingHand = false;
				}
			}
			else if(next.charAt(0) == 'S' || next.charAt(0) == 's')
			{
				System.out.println("\nStays with current hand");
				System.out.println("Hand was worth: " + user.determineHandValue());
				System.out.println("\n" + user.handToString());
				stillPlayingHand = false;
				
			}
			else 
			{
				System.out.println("Please enter a valid command");
			}
		}
		
		System.out.println("Hand complete, score " + user.determineHandValue());
	}
	
	public static void printGameRules()
	{
		System.out.println("  BLACKJACK RULES: " + "\n\t-Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down." 
		+ "\n\t-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11."
		+ "\n\t-The players cards are added up for their total."
		+ "\n\t-Players Hit to gain another card from the deck. Players Stay to keep their current card total."
		+ "\n\t-Dealer Hits until they equal or exceed 17."
		+ "\n\t-The goal is to have a higher card total than the dealer without going over 21."
		+ "\n\t-If the player total equals the dealer total, it is a Push and the hand ends."
		+ "\n\t-Players win their bet if they beat the dealer. Players win 1.5x their bet if they get Blackjack which is 21.\n\n");
	}
	
	// Will calculate the payout given the player in question's hand
	public double calculatePayout()
	{
		return 0.0;
	}
}