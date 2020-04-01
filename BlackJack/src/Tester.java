import java.io.IOException;
import java.text.NumberFormat;

public class Tester 
{
	public static void main(String[] args) throws IOException
	{
		NumberFormat formatter = NumberFormat.getCurrencyInstance();


		Deck d1 = new Deck();
		d1.createFullDeck();
		System.out.println(d1.toString());
		d1.shuffle();
		System.out.println(d1.deckSize());
		System.out.println(d1.toString());

		Opponent o1 = new Opponent();
		o1.randomPlayerName();
		System.out.println(o1.getName());
		System.out.println(formatter.format(o1.getOpponentAmount()));

		Player p1 = new Player();
		p1.getUserFileContents("user.txt");
		System.out.println("\n\n"+p1.getName() + "\n" + formatter.format(p1.getAmount()) + "\n" + formatter.format(p1.allTimeWinnings())+ "\n" + p1.winLoseRatio());


	}
}
