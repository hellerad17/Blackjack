import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BlackjackGUI extends JFrame
{
	JLabel j1;
	JButton hit;
	JButton stand;
	JButton doubleDown;
	JButton placeBet;
	JPanel panel_one;
	JPanel panel_two;
	public BlackjackGUI()
	{
		setTitle("BlackJack");
		setSize(960,960);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel_one = new JPanel();

		add(panel_one);

		panel_one.setLayout(new FlowLayout(1,100,100));
		panel_one.add(new JButton("Hit"));
		panel_one.add(new JButton("Stand"));
		panel_one.add(new JButton("Double Down"));

		
		add(panel_one,BorderLayout.SOUTH);
	}

	public static void main(String[] args)
	{
		BlackjackGUI s =new BlackjackGUI();
	}
}
