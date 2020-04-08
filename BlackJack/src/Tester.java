import java.io.IOException;
import java.text.NumberFormat;

public class Tester extends Challenger
{
	public static void main(String[] args) throws IOException
	{
		playerTester();

	}
	/***
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void playerTester() throws IOException
	{
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		Deck deck = new Deck();
		deck.createFullDeck();
		deck.shuffle();
		System.out.println(deck.toString()+"\n");
		
		String inputFileName = "user.txt";
		String outputFile = "user.txt";
		//PrintWriter out = new PrintWriter(outputFileName);

		Player p1 = new Player();
		p1.getUserFileContents(inputFileName);

		System.out.print("\n");
		//System.out.println(userFileContents.get(0));

		p1.setName("David Gonzalez");
		p1.addMoney(1000);

		System.out.println("\nTesting the replace elements method:\n");

		p1.writeToUserFile(outputFile);
		
		p1.addCard(deck.getCard(0));
		deck.removeCard(0);
		p1.addCard(deck.getCard(0));
		deck.removeCard(0);

		System.out.println(p1.challengerToString());


		System.out.println(p1.deckToString());
		System.out.println(p1.cardsValue());

	}
}
