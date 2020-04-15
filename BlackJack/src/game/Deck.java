package game;
import java.util.ArrayList;
import java.util.Random;

import utils.Suit;
import utils.Value;
/**
 * 
 * @author Andrew Heller
 * Copyright (C) 2020 Blackjack Project 
 *
 */
public class Deck
{
	public ArrayList<Card> deck;
	private Random rand;
	/***
	 * 
	 * Constructor creating a new ArrayList<>() called 'deck'.
	 */
	public Deck() 
	{
		this.deck = new ArrayList<>();
	}
	/***
	 * 
	 * Generates a brand new deck of cards using both the 'suit' and 'value' enum.
	 */
	public void createFullDeck()
	{
		//Generate Cards
		for(Suit cardSuit : Suit.values()) 
		{ //Suit is an enum
			for(Value cardValue: Value.values()) 
			{
				//Value is an enum
				//Add a new card to the mix
				this.deck.add(new Card(cardSuit, cardValue));
			}
		}
	}
	/***
	 * 
	 * Shuffles the current ArrayList<>() deck to randomly swap the positions of each deck.
	 */
	public void shuffle()
	{
		ArrayList<Card> temporaryDeck = new ArrayList<Card>();
		//Using Random to randomly swap the position of the cards.
		this.rand = new Random();
		int randomCardIndex = 0;
		int originalSize = this.deck.size();

		for(int i = 0; i < originalSize; i++)
		{
			//Generate Random Index (Equation: rand.nextInt((max-min)+1)+min;)
			randomCardIndex = this.rand.nextInt((this.deck.size()-1-0)+1)+0;
			//add a card from a random index in the arraylist 'deck' and add Card object 'card' to a temporary card deck
			// called 'temp' (using 'temp' as a placeholder for all the shuffled cards)
			temporaryDeck.add(this.deck.get(randomCardIndex));

			//Remove the Card object from the index point in the arraylist 'deck'.
			this.deck.remove(randomCardIndex);
		}
		//Make the member variable 'deck' equal to 'temporaryDeck'.
		this.deck = temporaryDeck;
	}
	/***
	 * 
	 * Removes a card from ArrayList<>() 'deck' from the specific position.
	 * @param card
	 */
	public void removeCard(int card)
	{
		this.deck.remove(card);
	}	
	/***
	 * 
	 * @param card
	 * @return card at the specific index in the ArrayList<>() 'deck'
	 */
	public Card getCard(int card)
	{
		return this.deck.get(card);
	}	
	/***
	 * Adds a card to the deck
	 * @param addCard
	 */
	public void addCard(Card addCard) 
	{
		this.deck.add(addCard);
	}	
	/***
	 * 
	 * Draws top card from the deck and removes the top card from the same deck.
	 * @param comingFrom
	 */
	public void draw(Deck comingFrom) 
	{
		this.deck.add(comingFrom.getCard(0));

		//removes the top Card from the current deck
		comingFrom.removeCard(0); 
	}
	/***
	 * 
	 * @return size of ArrayList<>() 'deck'.
	 */
	public int deckSize()
	{
		return this.deck.size();
	}	
	/***
	 * 
	 * @param Deck Object 'moveTO'
	 * moves all the cards in the present deck to another deck while removing the top most card from the deck.
	 */
	public void moveAllToDeck(Deck moveTo)
	{
		int thisDeckSize = this.deck.size();

		// Check's to see if the current deck has zero cards in there!
		if(thisDeckSize==0)
		{
			throw new IllegalArgumentException("No cards are present in the deck!");
		}

		for(int i = 0; i < thisDeckSize; i++)
		{
			moveTo.addCard(this.getCard(i));
		}
		for(int i = 0; i < thisDeckSize; i++)
		{
			this.removeCard(0);
		}
	}
	/***
	 * 
	 * @return total value of cards in deck.
	 */
	public int cardsValue()
	{
		int totalValue = 0;
		int aces = 0;

		for(Card aCard: deck)
		{
			switch(aCard.getValue())
			{
			case TWO: totalValue += 2; break;
			case THREE: totalValue += 3; break;
			case FOUR: totalValue += 4; break;
			case FIVE: totalValue += 5; break;
			case SIX: totalValue += 6; break;
			case SEVEN: totalValue += 7; break;
			case EIGHT: totalValue += 8; break;
			case NINE: totalValue += 9; break;
			case TEN: totalValue += 10; break;
			case JACK: totalValue += 10; break;
			case QUEEN: totalValue += 10; break;
			case KING: totalValue += 10; break;
			case ACE: totalValue += 1; break;
			}
		}		
		//check if ACE should either be valued at 11 or 1
		for(int i = 0; i < aces; i++)
		{
			if(totalValue > 10) 
			{
				totalValue += 1;	
			}
			else
			{
				totalValue += 11;
			}
		}
		return totalValue;
	}
	/***
	 * Takes all the cards in the ArrayList 'deck' and prints out every element.
	 */
	public String toString()
	{
		String cardListOutput = "";

		for(Card aCard: deck)
		{
			cardListOutput += "\n" + aCard.toString();
		}
		return cardListOutput;
	}	
}