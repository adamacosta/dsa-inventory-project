## dsa-inventory-project

### Team Project for ESC DSA Course Fall 2014

#### Authors

Junko Kotake, Adam Acosta, Joe Harmon, Stephanie Fuschetti, Kevin Leonas,
and Michael Scarpace

#### Project Description

Mock point-of-sale application that loads product records from a csv file
and allows the user to search records to retrieve product information as 
well as to make sales, which automatically retrieves a record to update
stock levels, check to see whether the current level is adequate to cover
the next 30 days given the last 30 days' sales velocity, then order more
of the product if necessary, decrementing the inventory record of the remote
warehouse as necessary.

#### How to Use the Program

To run a program, navigate to the bin directory. There are currently two
different csv files with 25000 records each that can be used to load data
into the program. One, "data.csv," contains records sorted by SKU. The other, 
"rand-data.csv," contains randomly ordered records. To run a program, enter
```bash
java inventory.AppName fileName.csv
```
where "AppName" is either ArrayApp or HashApp, depending upon which you want 
to run, and "fileName" is the name of the file you wish to load data from. 
By default, if no command-line arguments are passed, the application will 
select the sorted csv file to load data from.

This will run the program in interactive mode, which is currently the only
offered mode.

The bin directory also contains a shell script named "test" that will be
used to execute each application in test mode and record the run times in
a log file. This feature is not yet offered.

#### How to Compile from Source

To compile the program, navigate to the src directory and execute 
```bash
javac @argfile
```
to compile the source files listed in the argfile.
This will generate two executable applications, one named "HashApp" and 
the other named "ArrayApp." Each application is identical except that they
use different container classes to hold records. There is a third application
source file, TreeApp, that is not currently in the argfile and will not 
compile, as it contains references to a container class that is still in 
progress.

#### Status Updates

Currently, both the HashTable and ItemArray container classes have been
tested and will run all of the desired functions. Neither has been timed.
