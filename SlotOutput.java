/*
 *File name: SlotOutput.java
 *
 *Programmer: Josh Vetter
 * ULID: jvetter
 *
 *Date: Jan 31, 2016
 *
 *Class: IT 179
 *
 *Lecture Section: 001
 *Lecture Instructor: Holbrook
 */
package edu.ilstu;

/**
 * Handles all printing and output for Program2 project
 *
 *@author Josh Vetter
 *
 */
public class SlotOutput
{

	public void printInstructions()
	{
		System.out.println("Thank you for choosing the Redbird IT Slot Machines.\n"
				+ "On the following screen, you will find a menu with three choices. \n"
				+ "The first choice will be to play the game.\n"
				+ "The second choice will be to check your balance.\n"
				+ "The third choice will be to quit playing the game.\n");
		
		System.out.print("Playing the game: \n"
				+ "You will begin with 10 coins.\n"
				+ "You can bet 1 - 5 coins.\n"
				+ "Rows evaluated to determine winnings are determined by the number of coins bet.\n"
				+ "1 coin  - second row\n"
				+ "2 coins - first and second rows\n"
				+ "3 coins - first, second, and third rows\n"
				+ "4 coins - first, second, third rows, and diagonal top left to bottom right \n"
				+ "5 coins - all rows and both diagonals\n"
				+ "Your balance cannot be negative\n"
				+ "You cannot bet more coins than what is in your balance.\n\n"
				+ "Press Enter to continue: ");	
	}
	
	public void printMenuChoices()
	{
		System.out.print("Slot Machine Menu: \n"
				+ "1. Play a game \n"
				+ "2. Check Balance \n"
				+ "3. Quit \n"
				+ "Please enter your choice: ");
	}
	
	public void checkBalance(int coinsBet)
	{
		
		int balance = 10;
		
		balance = balance - coinsBet;
		
		System.out.println("Current Balance: " + balance);
		
	}
	
	
	

}
