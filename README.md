dsa-inventory-project
=====================

Team Project for ESC DSA Course Fall 2014

To compile the program, navigate to the src directory and execute the 
command "javac @argfile" to compile the source files listed in the argfile.
This will generate two executable applications, one named "HashApp" and 
the other named "ArrayApp." Each application is identical except that they
use different container classes to hold records.

To run a program, navigate to the bin directory. There are currently two
different csv files with 25000 records each that can be used to load data
into the program. One, "data.csv," contains records sorted by SKU. The other, 
"rand-data.csv," contains records in random order. Run the program by
executing the command "java inventory.AppName fileName.csv" where 
"AppName" is either ArrayApp or HashApp, depending upon which you want to run,
and "fileName" is the name of the file you wish to load data from. By default,
if no command-line arguments are passed, the application will select the
sorted csv file to load data from.

Currently, both the HashTable and ItemArray container classes have been
tested and will run all of the desired functions. Neither has been timed.
