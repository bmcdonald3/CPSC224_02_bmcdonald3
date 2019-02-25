/*

In class assignment 4

Due Date: 2/23/2019

Name: Ben McDonald

*/

import javax.swing.*;    // Needed for Swing classes
import java.awt.event.*;
import java.util.Random;


public class Dice extends JFrame
{
	private JPanel panel;
	private JButton button1;
	private ImageIcon die1;
	private ImageIcon die2;
        private ImageIcon die3;
	private ImageIcon die4;
        private ImageIcon die5;
	private ImageIcon die6;
	private JLabel label1;
	private JLabel label2;
	public Dice()
	{
            setSize(300,180);
		setTitle("Event Object Demonstration");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		die1 = new ImageIcon("Die1.png");
		die2 = new ImageIcon("Die2.png");
                die3 = new ImageIcon("Die3.png");
		die4 = new ImageIcon("Die4.png");
                die5 = new ImageIcon("Die5.png");
		die6 = new ImageIcon("Die6.png");
		label1 = new JLabel(die1);
		label2 = new JLabel(die1);
		button1 = new JButton("Roll the dice");
                button1.addActionListener(new ButtonListener());
		panel = new JPanel();
		panel.add(label1);
		panel.add(label2);
		panel.add(button1);
                

		// Add the panel to the content pane.
		add(panel);

		// Display the window.
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Random R1 = new Random();
			int number = R1.nextInt(6);
			int number2 = R1.nextInt(6); 
			if (number == 0)
			{
				label1.setIcon(die1);							
			}
			else if(number == 1)
			{
				label1.setIcon(die2);	
			}
			else if(number == 2)
			{
				label1.setIcon(die3);	
			}
			else if(number == 3)
			{
				label1.setIcon(die4);	
			}
			else if(number == 4)
			{
				label1.setIcon(die5);	
			}
			else if(number == 5)
			{
				label1.setIcon(die6);;	
			}
			if (number2 == 0)
				label2.setIcon(die1);
			else if(number2 == 1)
				label2.setIcon(die2);
			else if(number2 == 2)
				label2.setIcon(die3);
			else if(number2 == 3)
				label2.setIcon(die4);
			else if(number2 == 4)
				label2.setIcon(die5);
			else if(number2 == 5)
				label2.setIcon(die6);
		}
	}
	public static void main(String[] args)
	{
		new Dice();
	}
}