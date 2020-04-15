package game;
import utils.Suit;
import utils.Value;

/**
 * 
 * @author Andrew Heller
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
		return this.value.toString() + " of " + this.suit.toString(); 
	}
	/***
	 * 
	 * @return private class variable 'value'.
	 */
	public Value getValue() 
	{	
		return this.value;
	}
}
