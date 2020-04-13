import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

abstract class Challenger 
{
	/**
	 * 
	 */
	private String name;
	private int amount;
	private ArrayList<Card> deck;
	private LinkedList<Boolean> wins;
	private int wager;	
	private boolean decision;
	private Random rand;
	/**
	 * 
	 */
	public Challenger()
	{
		this.rand = new Random();
		this.wins = new LinkedList<>();
		this.deck = new ArrayList<>();
	}
	/**
	 * 
	 * @param n
	 * @throws IOException
	 */
	public void setName(String n) throws IOException
	{
		this.name = n;
	}
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public String getName() throws FileNotFoundException
	{
		return this.name;
	}
	/**
	 * 
	 * @param amt
	 */
	public void setAmount(int amt)
	{
		this.amount = amt;
	}
	/**
	 * 
	 * @return
	 */
	public int getAmount()
	{
		return this.amount;
	}
	/***
	 * 
	 * @param c
	 */
	public void addCard(Card c)
	{
		this.deck.add(c);
	}
	/***
	 * 
	 */
	public void clearPlayerDeck()
	{
		this.deck.clear();
	}
	
	public ArrayList<Card> getDeck()
	{
		return this.deck;
	}
	/***
	 * Add money to players account.
	 * @param money
	 */
	public void addMoney(int money)
	{
		this.amount += money;
	}
	/***
	 * @param money
	 */
	public void subMoney(int money)
	{
		this.amount -= money;
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
			if(totalValue > 21) //10
			{
				totalValue -= 10;	
			}
			else
			{
				totalValue += 11;
			}
		}
		return totalValue;
	}
	/***
	 * Method that randomly chooses the wager for the opponent.
	 * @param min, max, moneyTotal
	 * @return class member 'wager'
	 */
	public void wager(int min, int max, double d)
	{
		Random random =new Random();

		this.wager = (int) (random.nextInt((max-min)+1) + min);		
		while (this.wager > d)
		{
			if ((this.wager < 0) || (this.wager < min))
			{
				throw new IllegalArgumentException("Cannot bet while having less than 0 or your bet cannot be less than the minimum waging value! You current amount is " +  d + " dollars");
			}
			this.wager = (int) (random.nextInt((max-min)+1) + min);
		}
		this.amount -= this.wager;
		
	}
	/**
	 * 
	 * @return
	 */
	public int getWager()
	{
		return this.wager;
	}
	/***
	 * 
	 * @param fileName
	 * @return total number of lines in a file
	 * @throws IOException
	 */
	public int countLinesInFile(String fileName) throws IOException
	{
		int linecount = 0;
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try
		{
			String line;
			while ((line = br.readLine()) != null) 
			{
				linecount++;
			}
		} 
		finally
		{
			br.close();
		}
		return linecount;
	}
	/**
	 * @return list of cardsin the deck
	 */
	public String deckToString()
	{
		String cardListOutput = "";

		for(Card aCard: this.deck)
		{
			cardListOutput += "\n" + aCard.toString();
		}
		return cardListOutput;
	}	
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	public String challengerToString() throws FileNotFoundException
	{
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String str = this.getName() + "\n" + formatter.format(this.getAmount());
		return str;
	}
}
