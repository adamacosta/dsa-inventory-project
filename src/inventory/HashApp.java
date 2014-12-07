/** 
  * Application to read in product data from individual text files for each
  * product, store these in memory for access to decrement as sales are made
  * and to order more of a product when a threshold is reached for sales
  * velocity and number of item in stock.
  *
  * Data structures used are the ItemRecord, a single node containing fields
  * for product data and stock levels, and the HashTable, which is a container
  * class holding all of the ItemRecords, allowing search, insertion, and 
  * deletion
  *
  * Written for the Fall 2014 Data Structure and Algorithms Course at
  * Empire State College, a collaboration between Adam Acosta, Joe Harmon, 
  * Junko Kotake, Stephanie Fuschetti, Kevin Leonas, and Michael Scarpace.
  */

package inventory;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class HashApp{

private static HashTable stock = new HashTable();
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

protected static void mainMenu(String file) {
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
			writeData(file);
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

protected static void executeInteractive(String file) {
	loadData(file);
	mainMenu(file);
	writeData(file);
}

protected static void executeTest(String file, int[] testCases) {
	// file in with code to run a timer on the specific file
	// and number of each operation given by the user
	int numSales, numSearches;
	if (testCases[0] == 0) {
		numSales = 10000;
	} else {
		numSales = testCases[0];
	}
	if (testCases[1] == 0) {
		numSearches = 10000;
	} else {
		numSearches = testCases[1];
	}
	long startTime = System.nanoTime();
	loadData(file);
	long loadTime = System.nanoTime() - startTime;
	int numRecords = stock.size();
	startTime = System.nanoTime();
	for (int i = 1234567890; i < 1234567890 + numSales; i++ ) {
		stock.find(i).sellItem(1);
	}
	long saleTime = System.nanoTime() - startTime;
	startTime = System.nanoTime();
	for (int i = 1234567890; i < 1234567890 + numSearches; i++) {
		stock.find(i);
	}
	long searchTime = System.nanoTime() - startTime;
	System.out.print("Array");
	System.out.print("," + stock.size());
	System.out.print("," + file);
	System.out.print("," + numSales);
	System.out.print("," + numSearches);
	System.out.print("," + loadTime);
	System.out.print("," + saleTime);
	System.out.print("," + searchTime + '\n'); 
}

/**
 * @param args
 */
public static void main(String[] args) {

/*
 * Changed loadData method to take a file name passed from the system
 * when the application is run from the command line. If no argument is
 * passed from the command line, the default is to open "data.csv"
 */
	String file = "sort-10000.csv";
	boolean interactive = true;
	int[] testCases = new int[2];
	for (int i = 0; i < args.length; i++) {
		if (args[i].matches("^-\\w+$")) {
			switch (args[i].charAt(1)) {
			case 'f':
				file = args[++i];
			case 'i':
				break;
			case 't':
				interactive = false;
				if (args.length == i + 1) {
					break;
				} else if (args.length == i + 2) {
					if (args[i + 1].matches("^-\\w+$")) {
						break;
					}
					testCases[0] = Integer.parseInt(args[i + 1]);
					break;
				} else if (args.length == i + 3) {
					testCases[0] = Integer.parseInt(args[i + 1]);
					testCases[1] = Integer.parseInt(args[i + 2]);
					break;	
				}
				break;
			}
		}
	}
	if (interactive) {
		executeInteractive(file);
	} else {
		executeTest(file, testCases);
	}

}

}
