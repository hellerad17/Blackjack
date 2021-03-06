import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;
/***
 * 
 * @author Andrew Heller
 * Copyright (C) 2020 Blackjack Project 
 *
 */
public class Opponent extends Challenger
{
	
	private int choice_probability;
	private int probability_factor_coefficient;
	private int probability_factor;
	private int wager;	
	private boolean decision;
	private Random rand;
	/**
	 * @throws IOException *
	 * 
	 */
	//*********************************************************************
	public Opponent() throws IOException 
	{	
		super();
		randomPlayerName();
		// generates random amount of money for each random player.
		//this.amount = (double)rand.nextInt((500-5)+1)+5;//minimum bet is $5 and maximum bet is $500		
	}	
	/***
	 * 
	 * @throws IOException
	 */
	public void randomPlayerName() throws IOException 
	{
		String fileName ="names.txt";
		int randomIndex = this.rand.nextInt(countLinesInFile(fileName))+1;

		int maxLines = this.countLinesInFile(fileName);

		try
		{
			FileReader readfile = new FileReader(fileName);
			BufferedReader readbuffer = new BufferedReader(readfile);
			for (int lineNumber = 1; lineNumber < maxLines; lineNumber++)
			{
				if (lineNumber == randomIndex)
				{
					readbuffer.readLine();
				} 
				else
				{
					readbuffer.readLine();
				}
			}
			readfile.close();
			readbuffer.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//*********************************************************************************************************************************
	// Everything below is where this opponent will make decisions 
	// based off the results from the game.
	//*********************************************************************************************************************************
	/***
	 * 
	 * @param chance
	 * @return a random value based on the current circumstances at hand for the round,
	 */
	public double generateRandomProbabilityChoice(double chance) 
	{
		Random random = new Random();

		if (chance < 0)
		{
			throw new IllegalArgumentException("Cannot have a chance with less than 0!\nError in generateRandomProbability method");
		}

		//Probability from 1 out of chance
		this.choice_probability = random.nextInt() ;

		if (this.choice_probability < 0)
		{
			throw new IllegalArgumentException("Choice cannot be less than 0!\nError in generateRandomProbability method");
		}
		return this.choice_probability;
	}
	/***
	 * CHECK THIS METHOD
	 * Method that checks the current playing value in his/her deck.
	 * @return
	 */
	public boolean goingFromDeck()
	{
		boolean choice = false;

		//FIX:  int deckValue = ((Challenger) this.deck).cardsValue();

		if (deckValue == 21)
		{
			System.out.println("BLACKJACK! coming from the goingFromDeck() method");
			choice = false;
		}
		if((deckValue == 17) && (deckValue < 21))
		{
			 // The number is the probability of the program getting a card that has a value of 4 or lower
			if(generateRandomProbabilityChoice(3/13) >= (3/13))
			{
				choice = true;
			}
			else
			{
				choice = false;
			}
		}	
		else
		{
			choice = false;
		}
		return choice;
	}
	/***
	 * Factor Method to determine to continue due to a winning streak.
	 * @return
	 */
	public boolean goingForWinningStreak()
	{
		int randomChoiceFactor = rand.nextInt(wins.size()+1)+1;
		boolean choice = false;
		if ((winningStreak() > randomChoiceFactor) || (winningStreak() == randomChoiceFactor))
		{
			choice = true;
		}
		else
		{
			choice = false;
		}
		return choice;
	}
	/***
	 * Method that says to just do it or dont do it.
	 * @return random 'true' or 'false' output
	 */
	public boolean getRandomBoolean() 
	{
		return Math.random() < 0.5;
	}
	//*********************************************************************************************************************************
	// Everything above is considered part of the decision making process
	//*********************************************************************************************************************************
	//*********************************************************************************************************************************
	// Below is the decision being made by the opponent.
	//*********************************************************************************************************************************
	/***
	 * 
	 */
	public void setDecision()
	{
		ArrayList<Boolean> decisions = new ArrayList<>();

		//We are adding all the method outputs that are part of the decision making process to the arraylist decisions.
		decisions.add(getRandomBoolean());
		decisions.add(goingForWinningStreak());

		//count up the total number of outputs that are true from the methods
		int yes = 0;
		for(int i = 0; i < decisions.size(); i++)
		{
			if (decisions.get(i)==true)
			{
				yes++;
			}
		}
		//see if more than half of the values in the arraylist are true
		if (yes > (int) (decisions.size()/2))
		{
			this.decision = true;
		}
		// if half the options are 'true' and 'false' randomly choose one of the methods outputs to return.
		else if (yes == (int) (decisions.size()/2))
		{
			Random rand = new Random();
			int index = rand.nextInt(decisions.size())+1;

			this.decision = decisions.get(index);
		}
		else
		{
			this.decision = false;
		}	
	}
	/***
	 * 
	 * @return opponents decision.
	 */
	public boolean getDecision()
	{
		return this.decision;
	}
	//*********************************************************************************************************************************
	// Ends the decision making methods.
	//*********************************************************************************************************************************
	//*********************************************************************************************************************************
	// All the methods below are considered extra for the opponent class
	//*********************************************************************************************************************************
	/***
	 * Method that return's an opponents output of all the rounds they have played.
	 * @return 
	 */
	public int getTotalWins()
	{
		int totalWins = 0;
		for(boolean value: wins)
		{
			if (value==true) {totalWins += 1 ;}
		}
		return totalWins;
	}
	/***
	 * 
	 */
	public void allWinsValues()
	{
		int i = 0;
		String str ="";
		for(boolean value: wins)
		{
			i++;
			if (value==true) {str = "won";}
			else  {str = "lost";}
			System.out.println("Rounds: " + i + "\tOutcome: " + str);
		}	
	}
	/***
	 * 
	 * @param value
	 * 
	 */
	public void setWinsValue(boolean value)
	{
		this.wins.add(value);
	}
	/***
	 * 
	 * @param value
	 * @return
	 */
	public boolean getWinsValue(int value)
	{
		return this.wins.get(value);
	}
	/***
	 * 
	 * @return
	 */
	public int winningStreak()
	{
		int streak = 0;
		int recentPlay = wins.size();
		//Determines our current winning streak;
		while(wins.get(recentPlay)==true) 
		{
			streak += 1;
			recentPlay--;
			if(recentPlay + wins.size() == wins.size())
			{
				break;
			}
		}
		return streak;
	}
}