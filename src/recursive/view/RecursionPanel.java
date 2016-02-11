package recursive.view;

import java.awt.Color;
import javax.swing.*;

import recursive.controller.RecursionController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecursionPanel extends JPanel
{

	private RecursionController baseController;
	private JButton fibonacciButton;
	private JButton factorialButton;
	private JTextField inputField;
	private JTextArea resultsArea;
	private SpringLayout baseLayout;
	
	
	public RecursionPanel(RecursionController baseController)
	{
		this.baseController = baseController;
		fibonacciButton = new JButton("Calculate the Fibonacci number");
		factorialButton = new JButton("!n");
		baseLayout = new SpringLayout();
		inputField = new JTextField(5);
		resultsArea = new JTextArea(10,15);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupPanel()
	{
		this.add(factorialButton);
		this.add(inputField);
		this.add(fibonacciButton);
		this.add(resultsArea);
		resultsArea.setWrapStyleWord(true);
		resultsArea.setLineWrap(true);
		resultsArea.setEditable(false);
		this.setBackground(Color.BLUE);
	}
	
	private void setupListeners()
	{
		fibonacciButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = inputField.getText();
				if(checkInput(input))
				{
					resultsArea.setText(baseController.doFibonacci(input));
				}
			}
		});
		
		factorialButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = inputField.getText();
				if(checkInput(input))
				{
					resultsArea.append(baseController.doFactorial(input));
				}
			}
		});
	}
	
	private boolean checkInput(String input)
	{
		boolean isNumber = false;
		
		try
		{
			Double.parseDouble(input);
			isNumber = true;
		}
		
		catch(Exception numberException)
		{
			resultsArea.setText("You must type in a number");
		}
		return isNumber;
	}
}
