package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class PrintVitalSource {
	private static Robot robot = null; // This is the class to auto-type/click. MUST be called first for program to work
	private static Scanner input = new Scanner(System.in); // Scanner to get user input from keyboard
	private static int printAmount;
	private static int numberOfPages;
	private final static int DELAY_TIME_MILLISECOND = 500; // Delay the task by milliseconds between each task

	/** Constructor runs needed methods to use class */
	// Helpful tip, always have a no-arg constructor otherwise any sub-class will complain
	public PrintVitalSource() {
		initializeRobot(); // First thing to be ran, otherwise Robot can't be used
		printAmount = 1;

	}

	// Program Methods *****************************************************************************************

	/** Verify user has read README */
	private static void confirmUserReadREADME() {
		boolean userVerified = false; // To end loop
		// To confirm if user read the README
		while (!userVerified) {
			System.out.println("Must read README for instructions on how to run program. Very Crucial");
			System.out.println("Did you read the README? Y (Yes) or N (No)");
			if (input.next().equalsIgnoreCase("Y")) {
				userVerified = true;
			}
		}
	}

	/** Ask the user how many pages the book has */
	private static void getTotalBookPages() {

		boolean userVerified = false; // To end loop
		// Get user input on amount of pages the book has and confirm if user is sure 
		while (!userVerified) {
			// Get total book pages
			System.out.println("How many pages are there?");
			numberOfPages = input.nextInt();
			// Ask user if it's correct otherwise re-ask for the total book pages
			System.out.println("Are you sure? Y or N");
			if (input.next().equalsIgnoreCase("Y")) {
				userVerified = true; // End loop because book pages is correct
			}
		}
	}

	/** Runs program */
	public void run() {
		// Confirm user has read README
		confirmUserReadREADME();

		// Ask the user how many pages the book has
		getTotalBookPages();

		// Select Vital Source book
		selectVitalSource();

		robot.delay(DELAY_TIME_MILLISECOND); // Delays any task in milliseconds

		// Each increment prints 10 pages, therefore increase i by 10 per loop 
		for (int i = 0; i < numberOfPages; i += 10) {

			// Scroll controlment
			if (i == 0) {
				// if i == 0 then don't scroll because the first 10 pages need to be printed
				// Do nothing
			} else {
				// Print ten pages and save them and loop until end of book
				mouseScroll(10); // Scroll down ten pages
			}
			keyboardCtrlP(); // Press Control + P; shortcut for print

			robot.delay(DELAY_TIME_MILLISECOND);

			// On Print Preview GUI
			mouseMove(917, 587); // Move to "Continue"
			mouseClick(1); // Click "Continue"

			robot.delay(DELAY_TIME_MILLISECOND);

			// On Print GUI
			mouseMove(890, 482); // Move to "OK"
			mouseClick(1); // Click "OK"

			robot.delay(DELAY_TIME_MILLISECOND);

			// Save file 
			saveFileAs();

			robot.delay(15000); // Saving files take at least 11 seconds + 4 seconds of leeway

			// Show the user what page print you're on
			System.out.println("Close the CMD or press \"Control + C\" to STOP program");
			if (i + 10 > numberOfPages) {
				System.out.println("Print " + numberOfPages + "of " + numberOfPages);
				System.out.println("DONE");
			}
			System.out.println("Print " + (i + 10) + "of " + numberOfPages);
		}
	}

	/** Initialize Robot variable to Robot Class */
	private static void initializeRobot() {
		// AWTException will only be thrown by Robot Class's Constructor and therefore only need to be initialize once
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			System.out.println("Problem with constructing Robot Class in VBKToXPSVersion4");
		}
	}

	/** Automatically creates a name and saves a file */
	private static void saveFileAs() {
		createSaveName(); // Create a save file with the printAmount as file name
		printAmount++; // Increase the print amount by one 
		keyboardEnter(); // Press keyboardEnter to save file
	}

	/**
	 * To select VitalSource program. Must have VitalSource book pre-loaded and
	 * must be the first icon in Windows's 7 taskbar
	 */
	private static void selectVitalSource() {
		// Move mouse to first taskbar icon and click it
		mouseMove(90, 882);
		mouseClick(1);

		// Move mouse on Vital Source program to be able to be scrolled
		mouseMove(811, 480);
	}

	// Keyboard Task ***************************************************************************************************
	/** Type Enter */
	private static void keyboardEnter() {
		// Click enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	/** Types Control + P to activate print shortcut */
	private static void keyboardCtrlP() {
		// Auto type Ctrl + P for shortcut of Print
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_P);
	}

	/** Types the current print attempt as the file name */
	private static void createSaveName() {

		String printAmountString = String.valueOf(printAmount); // To be able to find the print amount
		// Save a file named with the amount of prints
		for (int i = 0; i < printAmountString.length(); i++) {

			// Turn an int in a String to a char to be able to type it automatically
			switch (printAmountString.charAt(i)) {
			// Type 0 on keyboard and the same for the other cases respectively
			case '0': {
				robot.keyPress(KeyEvent.VK_0);
				robot.keyRelease(KeyEvent.VK_0);
			}
				break;
			case '1': {
				robot.keyPress(KeyEvent.VK_1);
				robot.keyRelease(KeyEvent.VK_1);
			}
				break;
			case '2': {
				robot.keyPress(KeyEvent.VK_2);
				robot.keyRelease(KeyEvent.VK_2);
			}
				break;
			case '3': {
				robot.keyPress(KeyEvent.VK_3);
				robot.keyRelease(KeyEvent.VK_3);
			}
				break;
			case '4': {
				robot.keyPress(KeyEvent.VK_4);
				robot.keyRelease(KeyEvent.VK_4);
			}
				break;
			case '5': {
				robot.keyPress(KeyEvent.VK_5);
				robot.keyRelease(KeyEvent.VK_5);
			}
				break;
			case '6': {
				robot.keyPress(KeyEvent.VK_6);
				robot.keyRelease(KeyEvent.VK_6);
			}
				break;
			case '7': {
				robot.keyPress(KeyEvent.VK_7);
				robot.keyRelease(KeyEvent.VK_7);
			}
				break;
			case '8': {
				robot.keyPress(KeyEvent.VK_8);
				robot.keyRelease(KeyEvent.VK_8);
			}
				break;
			case '9': {
				robot.keyPress(KeyEvent.VK_9);
				robot.keyRelease(KeyEvent.VK_9);
			}
				break;
			default: {
				System.out.println("Not Valid Input Found IN createSaveName()");
			}
			}

		}
	}

	// Mouse Task ******************************************************************************************************

	/**
	 * Move mouse to a location on the screen from the provided coordinates
	 * 
	 * @param xCoordinate
	 *            Vertical coordinates on the monitor
	 * @param yCoordinate
	 *            Horizontal coordinates on the monitor
	 */
	private static void mouseMove(int xCoordinate, int yCoordinate) {
		robot.mouseMove(xCoordinate, yCoordinate);
	}

	/** Automatically left click a mouse X amount */
	private static void mouseClick(int amount) {
		int click = InputEvent.BUTTON1_DOWN_MASK; // int code for left mouse button (mouse button1)
		// Code to automatically left click a mouse
		for (int i = 0; i < amount; i++) {
			robot.mousePress(click);
			robot.mouseRelease(click);
		}
	}

	/**
	 * Used to scroll mouse button
	 * 
	 * @param amountOfScrolls
	 *            Negative number scrolls up, positive number scrolls down
	 */
	private static void mouseScroll(int amountOfScrolls) {

		// scroll x amount of times
		for (int i = 0; i < amountOfScrolls; i++) {
			robot.delay(200);
			robot.mouseWheel(1); // Must be one because VitalSource doesn't register scrolls very well
		}
	}
}
