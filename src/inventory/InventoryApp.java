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

//private StockList/*needs implementation*/ stock = new StockList();
protected static Scanner INPUT = new Scanner(System.in);

protected static void loadData(String file) {
/* 
 * Code to parse a csv file was adapted from the web tutorial 
 * "Parse CSV Files in Java" by Lokesh Gupta, retrieved 4 Dec 2014
 * from http://howtodoinjava.com/2013/05/27/parse-csv-files-in-java/
 */
	try {
		BufferedReader csvReader = new BufferedReader(new FileReader(file));
		try {
	/*
	 * The BufferedReader reads each line of the csv file, 
	 * corresponding to one product record, and returns a 
	 * String to initialize an ItemRecord. Parsing the line into
	 * comma-delimited tokens occurs within the ItemRecord
	 * initialization method. 
	 */
			String line = "";
			while ((line = csvReader.readLine())!=null) {
				line = csvReader.readLine();
				//stock.insert(new ItemRecord(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				csvReader.close();
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
	System.out.println("\nPlease choose an option: ");	
	while (INPUT.nextInt()!=3) {
		System.out.println("\n(1) Make sale");
		System.out.println("(2) Find item");
		System.out.println("(3) Close store");
		if (INPUT.nextInt()==1) {
			makeSale();
		} else if (INPUT.nextInt()==2) {
			findItem();
		} else if (INPUT.nextInt()==3) {
			writeData("data.csv");
		} else {
			System.out.println("Invalid input. Choose again: ");
		}
		System.out.println("\nPlease choose an option: ");
	} 
}

protected static void makeSale() {
	System.out.println("\nPlease enter a SKU (x to exit): ");
	while (INPUT.next()!="x" && INPUT.next()!="X") {
		int SKU = INPUT.nextInt();
		System.out.println("Enter number of item to sell: ");
		int num = INPUT.nextInt();
		//stock.find(SKU).sellItem(num);
		System.out.println("\nPlease enter a SKU (x to exit): ");
	}
}

protected static void findItem() {
	System.out.println("\nPlease enter a SKU (x to exit): ");
	while (INPUT.next()!="x" && INPUT.next()!="X") {
		int SKU = INPUT.nextInt();
		//stock.find(SKU).displayItem();
		System.out.println("\nPlease enter a SKU (x to exit): ");
	}
}

protected static void writeData(String file) {

}

public static void main(String[] args) {

	loadData("data.csv");
	mainMenu();
	writeData("data.csv");	

}

}
