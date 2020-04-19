package game;

import java.util.ArrayList;
import java.util.List;

import utils.Value;

public abstract class Player 
{
	public abstract void removeMoney(double amt);
	public abstract void addMoney(double amt);
	public abstract double getMoney();
	private List<Card> hand;
	
	public Player() 
	{
		hand = new ArrayList<>();
	}
	
	/*
	 * Hand methods
	 */
	
	public List<Card> getHand()
	{
		return hand;
	}
	
	public void addCard(Card card)
	{
		hand.add(card);
	}
	
	public String handToString()
	{
		StringBuilder sb = new StringBuilder("Hand: \n");
		for(Card card : hand)
		{
			sb.append(card.toString() + "\n");
		}
		return sb.toString();
	}
	
	public int determineHandValue()
	{
		int value = 0;
		for(Card card : hand)
		{
			switch(card.getValue())
			{
			case ACE:
				value += 11;
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
		
		for(Card card : hand)
		{
			if(value > 21 && card.getValue() == Value.ACE)
			{
				value -= 10;
			}
		}
		
		return value;
	}
}
