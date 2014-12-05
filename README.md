dsa-inventory-project
=====================

Team Project for ESC DSA Course Fall 2014

To compile the program, navigate to the src directory and execute the 
command "javac @argfile" to compile the source files listed in the argfile.
The argfile is currently configured to compile the InventoryApp and ItemRecord
classes with the ItemArray class as the container class. To compile with
another container class, simply edit the argfile.

To then run the program,navigate to the bin directory and  execute the command
java inventory.InventoryApp.

Currently, InventoryApp has been tested with ItemArray as the container class
for ItemRecord using the data.csv file, with 5000 inventory records.
