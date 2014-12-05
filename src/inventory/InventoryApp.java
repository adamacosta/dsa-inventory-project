/** 
  * Application to read in product data from individual text files for each
  * product, store these in memory for access to decrement as sales are made
  * and to order more of a product when a threshold is reached for sales
  * velocity and number of item in stock.
  *
  * Data structures used are the ItemRecord, a single node containing fields
  * for product data and stock levels, and the StockList, which is a container
  * class holding all of the ItemRecords, allowing search, insertion, and 
  * deletion
  *
  * Written for the Fall 2014 Data Structure and Algorithms Course at
  * Empire State College, a collaboration between Adam Acosta, Joe Harmon, 
  * Junko Kotake, Stephanie Fuschetti, Kevin Leonas, and Michael Scarpace.
  */

package inventory;

import java.io.*;
import java.util.Scanner;

public class InventoryApp{

private static ItemArray stock = new ItemArray();
protected static Scanner INPUT = new Scanner(System.in);

protected static void loadData(String file) {
/* 
 * Code to parse a csv file was adapted from the web tutorial 
 * "Parse CSV Files in Java" by Lokesh Gupta, retrieved 4 Dec 2014
 * from http://howtodoinjava.com/2013/05/27/parse-csv-files-in-java/
 */
	try {
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
	/*
	 * The BufferedReader reads each line of the csv file, 
	 * corresponding to one product record, and returns a 
	 * String to initialize an ItemRecord. Parsing the line into
	 * comma-delimited tokens occurs within the ItemRecord
	 * initialization method. 
	 */
			String line = "";
			while (br.ready()) {
				line = br.readLine();
				stock.insert(new ItemRecord(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}

protected static void mainMenu() {
	System.out.println("Welcome to ABC Stores Main Menu");
	while (true) {
		System.out.println("\nPlease choose an option: ");
		System.out.println("\n(1) Make sale");
		System.out.println("(2) Find item");
		System.out.println("(3) Close store\n");
		int selection = INPUT.nextInt();
		if (selection==1) {
			makeSale();
		} else if (selection==2) {
			findItem();
		} else if (selection==3) {
			writeData("data.csv");
			break;
		} else {
			System.out.println("Invalid input. Try again.");
		}
	} 
}

protected static void makeSale() {
	while (true) {
		System.out.println("\nPlease enter a SKU (1 to exit):\n");
		int SKU = INPUT.nextInt();
		if (SKU == 1) {
			break;
		}
		System.out.println("\nEnter number of item to sell:\n");
		int num = INPUT.nextInt();
		ItemRecord retrieved = stock.find(SKU);
		if(retrieved != null) {
			stock.find(SKU).sellItem(num);
		} else {
			System.out.println("\nSKU not found.\n");
		}
	}
}

protected static void findItem() {
	while (true) {
		System.out.println("\nPlease enter a SKU (1 to exit): \n");
		int SKU = INPUT.nextInt();
		if (SKU == 1) {
			break;
		}
		ItemRecord retrieved = stock.find(SKU);
		if (retrieved != null) { 
			stock.find(SKU).displayItem();
		} else {
			System.out.println("\nSKU not found.\n");
		}
	}
}

protected static void writeData(String file) {

}

public static void main(String[] args) {

/*
 * Changed loadData method to take a file name passed from the system
 * when the application is run from the command line. If no argument is
 * passed from the command line, the default is to open "data.csv"
 */

	if (args.length == 0) {
		loadData("data.csv");
		mainMenu();
		writeData("data.csv");
	} else {
		loadData(args[0]);
		mainMenu();
		if (args.length == 2) {
			writeData(args[1]);
		} else {
			writeData(args[0]);
		}
	}

}

}
