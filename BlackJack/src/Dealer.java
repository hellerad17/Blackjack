import java.util.ArrayList;

public class Dealer 
{
	private ArrayList<Card> deck;
	public Dealer()
	{
		this.deck = new ArrayList<>();
	}

	public Card dealCard(int i)
	{
		Card c = this.deck.get(i);
		deck.remove(0);
		return c;	
	}
	/**
	 * Prints the dealer's first card (the card face up at the beginning of a blackjack game).
	 */
	public void showFirstCard()
	{
		System.out.println("["+this.deck.get(0)+"]");
	}
	/**
	 * Gives the dealer another card and updates the value of his hand. Takes into account the value of aces.
	 * @param deck
	 */
	public void Hit(Deck deck)
	{
		hand.add(deck.drawCard());
		aHand = hand.toArray(aHand);
		handvalue = 0;
		for(int i=0; i<aHand.length; i++)
		{
			handvalue += aHand[i].getValue();
			if(aHand[i].getValue()==11)
			{
				AceCounter++;
			}
			while(AceCounter>0 && handvalue>21)
			{
				handvalue-=10;
				AceCounter--;
			}
		}
	}
	/**
	 * Determines if the dealer wants to hit according to classic Blackjack rules.
	 */
	public boolean wantsToHit()
	{
		if(getHandValue()<17)
		{
			return true;
		}
		return false;
	}
	/**
	 * Returns true if the dealer has blackjack.
	 * @return boolean
	 */
	public boolean hasBlackJack()
	{
		if(deck.size()==2 && getHandValue()==21)
		{
			System.out.println("The dealer has blackjack!");
			return true;
		}
		return false;
	}
	/**
	 * Prints the dealer's hand.
	 */
	public void showHand()
	{
		System.out.println("\tDealer's Hand");
		for(int i = 0; i < deck.size(); i++)
		{
			System.out.println(this.deck.get(i));
		}
	}
	/**
	 * Returns the value of the dealer's hand.
	 * @return int
	 */
	public int getHandValue()
	{
		int totalValue = 0;
		int aces = 0;

		for(Card aCard: this.deck)
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
	/**
	 * Determines if a dealer has busted.
	 * @return boolean
	 */
	public boolean busted()
	{
		if(getHandValue() > 21)
		{
			System.out.println("The dealer busted!");
			return true;
		}
		return false;
	}
	/**
	 * Takes the turn for the dealer and returns the value of his hand.
	 * @param Deck
	 * @return int
	 */
	public int takeTurn(Deck deck)
	{
		while(wantsToHit())
		{
			System.out.println("The dealer hits");
			Hit(deck);
			if(busted())
			{
				break;
			}
		}
		if(getHandValue()>=17 && getHandValue() < 21)
		{
			System.out.print("The dealer stands.");
		}
		return getHandValue();
	}	
}