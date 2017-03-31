/*
 *File name: SlotInput.java
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
 * <insert class description here>
 *
 *@author Josh Vetter
 *
 */
public class SlotInput
{
	
	Scanner keyboard = new Scanner(System.in);
	
	public int readMenuChoice() 
	{

		int choice = 0;
		choice = keyboard.nextInt();
		return choice;

	}
	
	
}
