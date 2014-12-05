dsa-inventory-project
=====================

Team Project for ESC DSA Course Fall 2014

To compile the program, navigate to the src directory and execute the 
command "javac @argfile" to compile the source files listed in the argfile.
The argfile is currently configured to compile the InventoryApp and ItemRecord
classes with the ItemArray class as the container class. To compile with
another container class, simply edit the argfile.

To run the program, navigate to the bin directory. There are currently two
different csv files with 10000 records each that can be used to load data
into the program. "data.csv" contains 10000 records sorted by SKU. 
"rand-data.csv" contains 10000 records in random order. Run the program by
executing the command "java inventory.InventoryApp fileName.csv" where
"fileName" is the name of the file you wish to load data from. By default,
if no command-line arguments are passed, the application will select the
sorted csv file to load dat from.

Currently, InventoryApp has been tested with ItemArray as the container class
for ItemRecord using both the data.csv and rand-data.csv files. 
