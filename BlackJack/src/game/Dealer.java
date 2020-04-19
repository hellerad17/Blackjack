package game;

public class Dealer extends Player 
{

	public boolean determineHit() 
	{
		if(determineHandValue() > 16)
		{
			return false;
		}
		return true;
	}

	@Override
	public void removeMoney(double amt) 
	{
		// won't do anything, the dealer has unlimited cash
		
	}

	@Override
	public void addMoney(double amt) 
	{
		// won't do anything, dealer has unilimited cash
		
	}

	@Override
	public double getMoney() 
	{
		return Double.MAX_VALUE;
		
	}

}