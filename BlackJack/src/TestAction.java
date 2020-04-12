import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuItem;

public class TestAction extends AbstractAction
{
	public TestAction(String name)
	{
		super(name);
	}

	public void actionPerformed(ActionEvent event)
	{
		System.out.println(getValue(Action.NAME) + " selected.");
	}
}
