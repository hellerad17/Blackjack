import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				BlackjackGUI frame = new BlackjackGUI();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
