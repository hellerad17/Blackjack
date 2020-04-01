/**
 * 
 * @author Andrew Heller
 * Copyright (C) 2020 Blackjack Project 
 * 
 */
public class Card
{
	/***
	 * 
	 * Private class variables
	 */
	private Suit suit;
	private Value value;	
	/***
	 * 
	 * Card Constructor
	 * @param suit
	 * @param value
	 */
	public Card(Suit suit, Value value)
	{
		this.value = value;
		this.suit = suit;
	}
	/***
	 * 
	 * @return private class variables 'suit' and 'value' as a string.
	 */
	public String toString()
	{
		return this.suit.toString() + "-" + this.value.toString(); 
	}
	/***
	 * 
	 * @return private class variable 'value'.
	 */
	public Value getValue() 
	{
		// check if there is no Card value.
		if (this.value == null)
		{
			throw new IllegalArgumentException("\nCannot find card value!\nError from Card.getValue()\n");
		}		
		return this.value;
	}
}
