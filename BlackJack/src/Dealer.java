import java.util.ArrayList;

public class Dealer extends Challenger
{
	public Dealer()
	{
		super();
		
	}

	public Card dealCard(int i)
	{
		Card c = this.getDeck().get(i);
		this.getDeck().remove(0);
		return c;	
	}
	/**
	 * Prints the dealer's first card (the card face up at the beginning of a blackjack game).
	 */
	public void showFirstCard()
	{
		System.out.println("["+this.getDeck().get(0)+"]");
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
		if(cardsValue() < 17)
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
		if(this.getDeck().size() == 2 && cardsValue() == 21)
		{
			System.out.println("Dealer has Blackjack!");
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
		for(int i = 0; i < this.getDeck().size(); i++)
		{
			System.out.println(this.getDeck().get(i));
		}
	}
	/**
	 * Determines if a dealer has busted.
	 * @return boolean
	 */
	public boolean busted()
	{
		if(cardsValue() > 21)
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
		if(cardsValue()>=17 && cardsValue() < 21)
		{
			System.out.print("The dealer stands.");
		}
		return cardsValue();
	}	
}