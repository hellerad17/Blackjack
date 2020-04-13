import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/***
 * 
 * @author Andrew Heller
 * Copyright (C) 2020 Blackjack Project 
 *
 */
public class Player extends Challenger
{
	private ArrayList<String> userFileContents;

	public Player()
	{
		super();
		this.userFileContents = new ArrayList<>();	
	}
	/***
	 * Replaces the current name of the player in the file 'user.txt' but keeps the amount value in the value.
	 * @param n
	 * @throws IOException
	 */
	public void setName(String n) throws IOException
	{
		this.userFileContents.set(0, n);
	}
	/***
	 * 
	 * @return players name.
	 * @throws FileNotFoundException 
	 */
	public String getName() throws FileNotFoundException
	{
		return userFileContents.get(0);
	}
	/**
	 * 
	 * @param amt
	 */
	public void setAmount(int amt)
	{
		this.userFileContents.set(1, amt + "");
	}
	/**
	 * 
	 * @return
	 */
	public int getAmount()
	{
		return Integer.parseInt(this.userFileContents.get(1));
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
	/**
	 * 
	 */
	public void addWins()
	{
		userFileContents.set(2,Integer.parseInt((this.userFileContents.get(2)) + 1) + "");
	}
	/***
	 * 
	 * @return
	 */
	public int totalWins()
	{
		return Integer.parseInt(this.userFileContents.get(2));
	}
	/**
	 * 
	 */
	public void addRound()
	{
		userFileContents.set(3, Integer.parseInt((this.userFileContents.get(3)) + 1) + "");
	}
	/***
	 * 
	 * @return
	 */
	public int totalRounds()
	{
		return Integer.parseInt(this.userFileContents.get(3));
	}
	/***
	 * 
	 * @return
	 */
	public int allTimeWinnings()
	{
		return Integer.parseInt(this.userFileContents.get(4));
	}
	/**
	 * 
	 */
	public void setWinLoseRatio()
	{
		this.userFileContents.set(5, (double)(this.totalWins() / this.totalRounds()) + "");
	}
	/***
	 * 
	 * @return
	 */
	public double getWinLoseRatio()
	{
		return Double.parseDouble(this.userFileContents.get(5));
	}
	/***
	 * Add money to players account.
	 * @param money
	 */
	public void addMoney(int money)
	{
		this.userFileContents.set(1, (Integer.parseInt(this.userFileContents.get(1)) + money) + "");
	}
	/***
	 * Subtract money from players account.
	 * @param money
	 */
	public void subMoney(int money)
	{
		this.userFileContents.set(1, (Integer.parseInt(this.userFileContents.get(1)) - money) + "");
	}
}