package game;

public class Dealer extends Player 
{

	public boolean determineHit() 
	{
		// will use the hadn value to determine
		return false;
	}

	@Override
	public void removeMoney() 
	{
		// won't do anything, the dealer has unlimited cash
		
	}

	@Override
	public void addMoney() 
	{
		// won't do anything, dealer has unilimited cash
		
	}

	@Override
	public double getMoney() 
	{
		return Double.MAX_VALUE;
		
	}

}
