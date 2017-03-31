/*
 *File name: SlotDriver.java
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

import java.util.Scanner;

/**
 * Holds the main method for the Program2 project, and references the SlotOutput and SlotGame classes
 *
 *@author Josh Vetter
 *
 */
public class SlotDriver
{

	//
	
	
	//diagonal reverse
	//IF they enter something other than a number EXCEPTION
	//"Any key to continue" ..... possible?
	//Uncomment the instructions
	
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		int coinBalance = 10;
		
		SlotInput input = new SlotInput();
		SlotOutput output = new SlotOutput();
		SlotGame game = new SlotGame();
		
		output.printInstructions();
		//Press any key to continue??????????
		keyboard.nextLine();
	
		output.printMenuChoices();
		int choice = input.readMenuChoice();
		
		//Create a menu that loops
		while(choice !=3){
				
			//Switch statement for menu	
			switch(choice)
			{
			
			//Play the Game
			case 1:
				//game.playGame();
				
				
				if(coinBalance == 0)
				{
					System.out.println("Coin Balance is Zero. Thanks for playing!");
					System.exit(1);
				}
				
				System.out.print("Please enter the number of coins to bet (1 - 5):");
				int coinsBet = keyboard.nextInt();
				
				while(coinsBet > coinBalance)
				{
					System.out.print("Insufficient Funds. Try Again.\n");
					System.out.print("Please enter the number of coins to bet (1 - 5):");
					coinsBet = keyboard.nextInt();
				}
				
				while(coinsBet > 5 || coinsBet < 1) // or not equal a number?
				{
					System.out.print("Invalid number. Please enter the number of coins to bet (1 - 5):");
					coinsBet = keyboard.nextInt();
					
				}
				coinBalance -= coinsBet;
				int payout = game.playGame(coinsBet);
				System.out.println("\nPayout: " + payout);
				
				coinBalance += payout;
				
			break;
			
			//Check Balance
			case 2: 
			System.out.println("\nCurrent Balance: " + coinBalance);
			System.out.println();
			//System.out.println(game.CalculateBalance());
			break; 
				
			default: System.out.println("Invalid menu choice. Please try again.");
			}
			System.out.println();
			//Call PrintMenu
			output.printMenuChoices();
			//Call ReadMenuChoice
			choice = input.readMenuChoice();
		
			
			
		}
			
   }
	
}

