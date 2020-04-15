package game;

import java.util.ArrayList;
import java.util.List;

public abstract class Player 
{
	public abstract void removeMoney();
	public abstract void addMoney();
	public abstract double getMoney();
	private List<Card> hand;
	
	public Player() 
	{
		hand = new ArrayList<>();
	}
	
	/*
	 * Hand methods
	 */
	
	public void determineHandValue()
	{
		int value = 0;
		for(Card card : hand)
		{
			switch(card.getValue())
			{
			case ACE:
				if (value + 11 > 21)
				{
					value += 1;
				}
				else
				{
					value += 11;
				}
				break;
			case TWO:
				value += 2;
				break;
			case THREE:
				value += 3;
				break;
			case FOUR:
				value += 4;
				break;
			case FIVE:
				value += 5;
				break;
			case SIX:
				value += 6;
				break;
			case SEVEN:
				value += 7;
				break;
			case EIGHT:
				value += 8;
				break;
			case NINE:
				value += 9;
				break;
			case TEN:
				value += 10;
				break;
			case JACK:
				value += 10;
				break;
			case QUEEN:
				value += 10;
				break;
			case KING:
				value += 10;
				break;
			}
		}
	}
}
