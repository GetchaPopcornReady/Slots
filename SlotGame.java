/*
 *File name: SlotGame.java
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

import java.util.Random;

/**
 * Handles responsibility for playing the slot machine game
 *
 *@author Josh Vetter
 *
 */
public class SlotGame
{

	public int playGame(int coinsBet)
	{
		
		
//		Scanner keyboard = new Scanner(System.in);
//		System.out.print("Please enter the number of coins to bet (1 - 5):");
//		int coinsBet = keyboard.nextInt();
//		

		
//		while(coinsBet > 5 || coinsBet < 1) // or not equal a number?
//		{
//			System.out.print("Invalid number. Please enter the number of coins to bet (1 - 5):");
//			coinsBet = keyboard.nextInt();
//			
//			
//		}
		System.out.println();
		
		Random random = new Random();
		//////////////////////
		//WHEEL 1
		//////////////////////
		
		
		//needed so i didnt get a memory address
		int random1 = random.nextInt(6)+ 1;
	//	System.out.println(random1);
		
		
		//First Wheel: 
		// CHERRY, CHERRY, CHERRY, PLUM, bell, BAR 
		String wheel1 = "CCCCPBb";
		int pos1 = wheel1.length() - random1;


		//output
		String finalStrings1 = wheel1.substring(pos1, wheel1.length()) + wheel1.substring(0, pos1);
	//	System.out.println(finalStrings1);
	
		String first1 = finalStrings1.substring(0,1);
		String second1 = finalStrings1.substring(1,2);
		String third1 = finalStrings1.substring(2,3);
	
		String wheelArray1[] = new String[] {first1,second1,third1};
	//	System.out.println(Arrays.toString(wheelArray1));
	
		//////////////////////////
		//WHEEL2
		//////////////////////////
	
		int random2 = random.nextInt(6)+ 1;
		//System.out.println(random2);
		
		//Second Wheel: 
		//Cherry, Cherry, Cherry, Plum, Plum, Bell, Bar
		String wheel2 = "CCCPPBb";
		int pos2 = wheel2.length() - random2;


		//output
		String finalStrings2 = wheel2.substring(pos2, wheel2.length()) + wheel2.substring(0, pos2);
		///System.out.println(finalStrings2);
	
		String first2 = finalStrings2.substring(0,1);
		String second2 = finalStrings2.substring(1,2);
		String third2 = finalStrings2.substring(2,3);
	
		String wheelArray2[] = new String[] {first2,second2,third2};
		//System.out.println(Arrays.toString(wheelArray2));
		
		///////////////////////
		//WHEEL3
		///////////////////////
	
		int random3 = random.nextInt(6)+ 1;
	//	System.out.println(random3);
		
		
		//Third Wheel
		//Cherry, Cherry, Plum, Plum, Bell, Bell, Bar
		String wheel3 = "CCPPBBb";
		int pos3 = wheel3.length() - random3;


		//output
		String finalStrings3 = wheel3.substring(pos3, wheel3.length()) + wheel3.substring(0, pos3);
		//System.out.println(finalStrings3);
	
		String first3 = finalStrings3.substring(0,1);
		String second3 = finalStrings3.substring(1,2);
		String third3 = finalStrings3.substring(2,3);
	
		String wheelArray3[] = new String[] {first3,second3,third3};
		//System.out.println(Arrays.toString(wheelArray3));
	
	
		
		/////////////////
		//Create 2d Array
		/////////////////
		final int ROWS = 3;
		final int COLS = 3;
		String[][] matrixArray = new String [ROWS][COLS];
		//Assign each Wheel Array to the corresponding column of 2d array
		
		////////
		//Assign 
		//Wheel1
		////////
		for(int row =0; row < matrixArray.length; row++) {
		    for(int col = 0; col < matrixArray[row].length-2; col++) 
		    {
		        matrixArray[row][col] = wheelArray1[row];
		    }
		}
		
		
		
		////////
		//Assign 
		//Wheel2
		////////
		for(int row = 0; row < matrixArray.length; row++) {
		    for(int col = 1; col < matrixArray[row].length-1; col++) 
		    {
		        matrixArray[row][col] = wheelArray2[row];
		    }
		}
		
		////////
		//Assign 
		//Wheel3
		////////
		
		for(int row =0; row < matrixArray.length; row++) {
		    for(int col = 2; col < matrixArray[row].length; col++) 
		    {
		        matrixArray[row][col] = wheelArray3[row];
		    }
		}
		
		
		//
		//
		//Prints array to screen	
		for(int i = 0; i < matrixArray.length; i++)
		{
		    for(int j = 0; j < matrixArray[i].length; j++)
		    {
		    	if(matrixArray[i][j].equals("C"))
		    	{
		    		System.out.print("Cherry");
		    	}
		    	else if(matrixArray[i][j].equals("b"))
		    	{
		    		System.out.print("Bar   ");
		    	}
		    	else if(matrixArray[i][j].equals("P"))
		    	{
		    		System.out.print("Plum  ");
		    	}
		    	else if(matrixArray[i][j].equals("B"))
		    	{
		    		System.out.print("Bell  ");
		    	}
		        //System.out.print(matrixArray[i][j]);
		        if(j < matrixArray[i].length - 1) System.out.print("     ");
		    }
		    System.out.println();
		}
	
		int moneyReturn = 0;
		
		switch(coinsBet)
		{
			case 1:
					//check middle row
					moneyReturn = checkMiddleRow(matrixArray);
					break;
			case 2:
				//check middle row + check top row
				moneyReturn = checkMiddleRow(matrixArray) + checkTopRow(matrixArray);
				break;
			case 3:
				//check all rows
				moneyReturn = checkMiddleRow(matrixArray) + checkTopRow(matrixArray) + checkBottomRow(matrixArray);
				break;
			case 4:
				//check all rows and forwards diagonal
				moneyReturn = checkMiddleRow(matrixArray) + checkTopRow(matrixArray)+ checkBottomRow(matrixArray)+ checkDiagonalLeftDownRow(matrixArray);
				break;
			case 5:
				//check all rows and both diagonal
				moneyReturn = checkMiddleRow(matrixArray) + checkTopRow(matrixArray)+ checkBottomRow(matrixArray)+ checkDiagonalLeftDownRow(matrixArray) + checkDiagonalRightDownRow(matrixArray);
				break;
		}
		
		return moneyReturn;
		
	}	
	
	//has to be a less redundant code where theres not a method for each row check...

	private static int checkMiddleRow(String[][] matrixArray)
	{
		String middleRowArray[] = new String[3];
		
		int moneyReturn = 0;
			for(int i = 1; i < matrixArray.length-1; i++)
			{
			    for(int j = 0; j < matrixArray[i].length; j++)
			    {
			        middleRowArray[j] = matrixArray[i][j];
			    }
			   
			}
		//Plum Plum
		if(middleRowArray[0].equals("P") && middleRowArray[1].equals("P") && !middleRowArray[2].equals("P"))
		{
			moneyReturn += 1;
		}
		
		//Plum Plum Plum
		if(middleRowArray[0].equals("P") && middleRowArray[1].equals("P") && middleRowArray[2].equals("P"))
		{
			moneyReturn += 2;
		}
		
		//Bell
		if(middleRowArray[0].equals("B")&& !middleRowArray[1].equals("B") && !middleRowArray[2].equals("B"))
		{
			moneyReturn += 1;
		}
		//Bell Bell
		if(middleRowArray[0].equals("B") && middleRowArray[1].equals("B")&& !middleRowArray[2].equals("B"))
		{
			moneyReturn += 2;
		}
		
		//Bell Bell Bell
		if(middleRowArray[0].equals("B") && middleRowArray[1].equals("B") && middleRowArray[2].equals("B"))
		{
			moneyReturn += 3;
		}
		
		//Bar
		if(middleRowArray[0].equals("b")&& !middleRowArray[1].equals("b") && !middleRowArray[2].equals("b"))
		{
			moneyReturn += 2;
		}
		//Bar //Bar
		if(middleRowArray[0].equals("b") && middleRowArray[1].equals("b") && !middleRowArray[2].equals("b"))
		{
			moneyReturn += 3;
		}
		
		//Bar //Bar //Bar
		if(middleRowArray[0].equals("b") && middleRowArray[1].equals("b") && middleRowArray[2].equals("b"))
		{
			moneyReturn += 5;
		}		
		
		
			return moneyReturn;
	
	}
	
	private static int checkTopRow(String[][] matrixArray)
	{
		String topRowArray[] = new String[3];
		
		int moneyReturn = 0;
			for(int i = 0; i < matrixArray.length-2; i++)
			{
			    for(int j = 0; j < matrixArray[i].length; j++)
			    {
			        topRowArray[j] = matrixArray[i][j];
			    }
			   
			}
			
			//Plum Plum
			if(topRowArray[0].equals("P") && topRowArray[1].equals("P") && !topRowArray[2].equals("P"))
			{
				moneyReturn += 1;
			}
			
			//Plum Plum Plum
			if(topRowArray[0].equals("P") && topRowArray[1].equals("P") && topRowArray[2].equals("P"))
			{
				moneyReturn += 2;
			}
			
			//Bell
			if(topRowArray[0].equals("B")&& !topRowArray[1].equals("B") && !topRowArray[2].equals("B"))
			{
				moneyReturn += 1;
			}
			//Bell Bell
			if(topRowArray[0].equals("B") && topRowArray[1].equals("B")&& !topRowArray[2].equals("B"))
			{
				moneyReturn += 2;
			}
			
			//Bell Bell Bell
			if(topRowArray[0].equals("B") && topRowArray[1].equals("B") && topRowArray[2].equals("B"))
			{
				moneyReturn += 3;
			}
			
			//Bar
			if(topRowArray[0].equals("b")&& !topRowArray[1].equals("b") && !topRowArray[2].equals("b"))
			{
				moneyReturn += 2;
			}
			//Bar //Bar
			if(topRowArray[0].equals("b") && topRowArray[1].equals("b") && !topRowArray[2].equals("b"))
			{
				moneyReturn += 3;
			}
			
			//Bar //Bar //Bar
			if(topRowArray[0].equals("b") && topRowArray[1].equals("b") && topRowArray[2].equals("b"))
			{
				moneyReturn += 5;
			}		
			
			
				return moneyReturn;	
	
	}
	
	private static int checkBottomRow(String[][] matrixArray)
	{
		String BottomRowArray[] = new String[3];
		
		int moneyReturn = 0;
			for(int i = 0; i < matrixArray.length; i++)
			{
			    for(int j = 0; j < matrixArray[i].length; j++)
			    {
			        BottomRowArray[j] = matrixArray[i][j];
			    }
			   
			}
				
			//Plum Plum
			if(BottomRowArray[0].equals("P") && BottomRowArray[1].equals("P") && !BottomRowArray[2].equals("P"))
			{
				moneyReturn += 1;
			}
			
			//Plum Plum Plum
			if(BottomRowArray[0].equals("P") && BottomRowArray[1].equals("P") && BottomRowArray[2].equals("P"))
			{
				moneyReturn += 2;
			}
			
			//Bell
			if(BottomRowArray[0].equals("B")&& !BottomRowArray[1].equals("B") && !BottomRowArray[2].equals("B"))
			{
				moneyReturn += 1;
			}
			//Bell Bell
			if(BottomRowArray[0].equals("B") && BottomRowArray[1].equals("B")&& !BottomRowArray[2].equals("B"))
			{
				moneyReturn += 2;
			}
			
			//Bell Bell Bell
			if(BottomRowArray[0].equals("B") && BottomRowArray[1].equals("B") && BottomRowArray[2].equals("B"))
			{
				moneyReturn += 3;
			}
			
			//Bar
			if(BottomRowArray[0].equals("b")&& !BottomRowArray[1].equals("b") && !BottomRowArray[2].equals("b"))
			{
				moneyReturn += 2;
			}
			//Bar //Bar
			if(BottomRowArray[0].equals("b") && BottomRowArray[1].equals("b") && !BottomRowArray[2].equals("b"))
			{
				moneyReturn += 3;
			}
			
			//Bar //Bar //Bar
			if(BottomRowArray[0].equals("b") && BottomRowArray[1].equals("b") && BottomRowArray[2].equals("b"))
			{
				moneyReturn += 5;
			}		
			
			
				return moneyReturn;
	}
	
	private static int checkDiagonalLeftDownRow(String[][] matrixArray)
	{
		String DiagonalLeftRowArray[] = new String[3];
		
		int moneyReturn = 0;
			for(int i = 0; i < matrixArray.length; i++)
			{
			    
			        DiagonalLeftRowArray[i] = matrixArray[i][i];
			    
			   
			}

			//Plum Plum
			if(DiagonalLeftRowArray[0].equals("P") && DiagonalLeftRowArray[1].equals("P") && !DiagonalLeftRowArray[2].equals("P"))
			{
				moneyReturn += 1;
			}
			
			//Plum Plum Plum
			if(DiagonalLeftRowArray[0].equals("P") && DiagonalLeftRowArray[1].equals("P") && DiagonalLeftRowArray[2].equals("P"))
			{
				moneyReturn += 2;
			}
			
			//Bell
			if(DiagonalLeftRowArray[0].equals("B")&& !DiagonalLeftRowArray[1].equals("B") && !DiagonalLeftRowArray[2].equals("B"))
			{
				moneyReturn += 1;
			}
			//Bell Bell
			if(DiagonalLeftRowArray[0].equals("B") && DiagonalLeftRowArray[1].equals("B")&& !DiagonalLeftRowArray[2].equals("B"))
			{
				moneyReturn += 2;
			}
			
			//Bell Bell Bell
			if(DiagonalLeftRowArray[0].equals("B") && DiagonalLeftRowArray[1].equals("B") && DiagonalLeftRowArray[2].equals("B"))
			{
				moneyReturn += 3;
			}
			
			//Bar
			if(DiagonalLeftRowArray[0].equals("b")&& !DiagonalLeftRowArray[1].equals("b") && !DiagonalLeftRowArray[2].equals("b"))
			{
				moneyReturn += 2;
			}
			//Bar //Bar
			if(DiagonalLeftRowArray[0].equals("b") && DiagonalLeftRowArray[1].equals("b") && !DiagonalLeftRowArray[2].equals("b"))
			{
				moneyReturn += 3;
			}
			
			//Bar //Bar //Bar
			if(DiagonalLeftRowArray[0].equals("b") && DiagonalLeftRowArray[1].equals("b") && DiagonalLeftRowArray[2].equals("b"))
			{
				moneyReturn += 5;
			}		
			
			
				return moneyReturn;

	}
		
	//Need Backwards Diagonal :/
	private static int checkDiagonalRightDownRow(String[][] matrixArray)
	{
		String DiagonalRightDownRowArray[] = new String[3];
		
		int moneyReturn = 0;
		int columns = 2;	
		
		DiagonalRightDownRowArray[0] = matrixArray[0][2];
		DiagonalRightDownRowArray[1] = matrixArray[1][1];
		DiagonalRightDownRowArray[2] = matrixArray[2][0];
		
//		for(int i = 2; i < matrixArray.length; i++)
//			{
//			    
//			        DiagonalRightDownRowArray[i] = matrixArray[columns - i][i];
//			
//			        
//			        
//			        columns --;
//			   
//			}
			
		//Plum Plum
		if(DiagonalRightDownRowArray[0].equals("P") && DiagonalRightDownRowArray[1].equals("P") && !DiagonalRightDownRowArray[2].equals("P"))
		{
			moneyReturn += 1;
		}
		
		//Plum Plum Plum
		if(DiagonalRightDownRowArray[0].equals("P") && DiagonalRightDownRowArray[1].equals("P") && DiagonalRightDownRowArray[2].equals("P"))
		{
			moneyReturn += 2;
		}
		
		//Bell
		if(DiagonalRightDownRowArray[0].equals("B")&& !DiagonalRightDownRowArray[1].equals("B") && !DiagonalRightDownRowArray[2].equals("B"))
		{
			moneyReturn += 1;
		}
		//Bell Bell
		if(DiagonalRightDownRowArray[0].equals("B") && DiagonalRightDownRowArray[1].equals("B")&& !DiagonalRightDownRowArray[2].equals("B"))
		{
			moneyReturn += 2;
		}
		
		//Bell Bell Bell
		if(DiagonalRightDownRowArray[0].equals("B") && DiagonalRightDownRowArray[1].equals("B") && DiagonalRightDownRowArray[2].equals("B"))
		{
			moneyReturn += 3;
		}
		
		//Bar
		if(DiagonalRightDownRowArray[0].equals("b")&& !DiagonalRightDownRowArray[1].equals("b") && !DiagonalRightDownRowArray[2].equals("b"))
		{
			moneyReturn += 2;
		}
		//Bar //Bar
		if(DiagonalRightDownRowArray[0].equals("b") && DiagonalRightDownRowArray[1].equals("b") && !DiagonalRightDownRowArray[2].equals("b"))
		{
			moneyReturn += 3;
		}
		
		//Bar //Bar //Bar
		if(DiagonalRightDownRowArray[0].equals("b") && DiagonalRightDownRowArray[1].equals("b") && DiagonalRightDownRowArray[2].equals("b"))
		{
			moneyReturn += 5;
		}		
		
		return moneyReturn;

	}
	
	
//	public int CalculateBalance()
//	{
//		
//		SlotGame game = new SlotGame();
//		int coinsBet;
//
//		
//		
//		
//		
//		
//	}
	
	
	
	
//		 If only one coin was entered, the middle row is evaluated.
//		 If 2 were entered, the top two rows are evaluated.
//		 If 3 were entered, all three rows are evaluated.
//		 If 4 coins, then check all three rows, and the diagonal going from the upper left to the
//		 lower right.
//		 If 5 coins, then check all three rows and both diagonals.
//		Cherry in any position
//		 
//		0 coins
//		Plum in first position
//		 
//		0 coins
//		Plum in first 2 positions
//		 
//		1 coins
//		 
//		Plum in all three positions
//		2 coins
//		Bell in first position
//		 
//		1 coins
//		 
//		Bell in first 2 positions
//		2 coins
//		Bell in all three positions
//		3 coins
//		Bar in first position
//		 
//		2 coins
//		 
//		Bar in first 2 positions
//		3 coins
//		Bar in all three positions
//		 
//		5 coins
		
	
	
	
}
