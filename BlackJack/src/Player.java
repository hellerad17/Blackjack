import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
/***
 * 
 * @author Andrew Heller
 * Copyright (C) 2020 Blackjack Project 
 *
 */
public class Player
{
	private String name;
	private int amount;
	private ArrayList<Card> deck;
	private static ArrayList<String> userFileContents;

	public Player()
	{
		this.deck = new ArrayList<>();
		this.userFileContents = new ArrayList<>();	
	}
	/***
	 * Replaces the current name of the player in the file 'user.txt' but keeps the amount value in the value.
	 * @param n
	 * @throws IOException
	 */
	public void setName(String n) throws IOException
	{
		this.name = n;
		Player.userFileContents.set(0, n);
	}
	/***
	 * 
	 * @return players name.
	 * @throws FileNotFoundException 
	 */
	public String getName() throws FileNotFoundException
	{
		getUserFileContents("user.txt");
		this.name = userFileContents.get(0);
		if(this.name==null)
		{
			Scanner scanName = new Scanner(System.in);
			System.out.println("Name cannot be found, please enter in a name please, first name and last name: ");
			userFileContents.set(0, scanName.nextLine());
			this.name = userFileContents.get(0);
			scanName.close();
		}
		return this.name ;
	}
	/***
	 * 	sets 'player' amount to param 'value' 
	 * @param value
	 * 
	 */
	public void setAmount(int value) 
	{
		this.amount += value;
		Player.userFileContents.set(1, this.amount +"");
	}
	/***
	 * 
	 * @return player amount.
	 * @throws FileNotFoundException 
	 */
	public int getAmount() 
	{
		return Integer.parseInt(Player.userFileContents.get(1));
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
	/***
	 * 
	 * @param args
	 * @throws IOException
	 */
	public void writeToUserFile(String fileName) throws IOException
	{
		FileWriter writer = new FileWriter(fileName); 
		for(String str: userFileContents)
		{
			//writer.write(str + System.lineSeparator());
			writer.write(str + System.lineSeparator());
		}
		writer.close();
	}
	/***
	 * 
	 * @param userFileName
	 * @throws FileNotFoundException
	 */
	public void getUserFileContents(String userFileName) throws FileNotFoundException 
	{
		Scanner userFile = new Scanner(new File(userFileName));
		userFile.useDelimiter("\n");
		while (userFile.hasNext())
		{
			this.userFileContents.add(userFile.nextLine());
		}
		userFile.close();
	}
	/***
	 * 
	 * @return
	 */
	public int totalWins()
	{
		return Integer.parseInt(Player.userFileContents.get(2));
	}
	/***
	 * 
	 * @return
	 */
	public int totalRounds()
	{
		return Integer.parseInt(Player.userFileContents.get(3));
	}
	/***
	 * 
	 * @return
	 */
	public int allTimeWinnings()
	{
		return Integer.parseInt(Player.userFileContents.get(4));
	}
	/***
	 * 
	 * @return
	 */
	public double winLoseRatio()
	{
		return Double.parseDouble(Player.userFileContents.get(5));
	}
	//*********************************************************************************************************************************
	// Everything below deals with game action for the player.
	//*********************************************************************************************************************************
	/***
	 * Add money to players account.
	 * @param money
	 */
	public void addMoney(int money)
	{
		this.amount = Integer.parseInt(this.userFileContents.get(1));
		this.amount += money;
		this.userFileContents.set(1, this.amount + "");
	}
	/***
	 * Subtract money from players account.
	 * @param money
	 */
	public void subMoney(int money)
	{
		this.amount = Integer.parseInt(this.userFileContents.get(1));
		this.amount -= money;
		this.userFileContents.set(1, this.amount + "");
	}
	//*********************************************************************************************************************************
	// Everything above is part of game actions.
	//*********************************************************************************************************************************
	//*********************************************************************************************************************************
	// Below is just extra code not necessary for the class above.
	//*********************************************************************************************************************************
	/***
	 * Used to time the response duration for the program.
	 */
	public static void programRunTime()
	{
		String x = "";
		long time = System.currentTimeMillis(); //gives the amount of time that passed since the birth of this function since 1977

		//System.out.println(time);
		StringBuilder sA = new StringBuilder();
		for(int i = 0; i < 50000; i++)
		{
			//x = x + "X"; 726 milliseconds
			sA.append("X"); 

		}
		long t2 =  System.currentTimeMillis();
		long timeTotal = t2-time;

		//Print Line
		System.out.println("\nProgram Run Time: ");
		System.out.println(timeTotal + " milliseconds");
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
	 * @return String
	 */
	public String toString()
	{
		String cardListOutput = "";

		for(Card aCard: this.deck)
		{
			cardListOutput += "\n" + aCard.toString();
		}
		return cardListOutput;
	}	
	/***
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		String inputFileName = "user.txt";
		String outputFile = "user.txt";
		//PrintWriter out = new PrintWriter(outputFileName);

		Player p1 = new Player();
		p1.getUserFileContents(inputFileName);

		for(String str: userFileContents)
		{
			System.out.println(str);
		}

		System.out.print("\n");
		//System.out.println(userFileContents.get(0));

		p1.setName("David Gonzalez");
		p1.addMoney(962);

		System.out.println("\nTesting the replace elements method:\n");

		p1.writeToUserFile(outputFile);

		for(String str: userFileContents)
		{
			System.out.println(str);
		}
		programRunTime();
	}
}