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
java inventory.AppName -f fileName -i -t numberOne numberTwo
```
where "AppName" is either ArrayApp or HashApp, depending upon which you want 
to run, and "fileName" is the name of the file you wish to load data from. 
By default, if no command-line arguments are passed, the application will 
select the sorted csv file to load data from. The -i and -t switches allow
the program to run in either interactive mode or test mode. Interactive mode
is the default. If test mode is chosen, you can optionally supply two integers
after the -t switch. The first tells the program how many sales to make and
the second tells the program how many searches to make. By default, the program
will make 1000 sales and 1000 searches.

The bin directory also contains a shell script named "test" that can be
used to execute each application in test mode and record the run times in
a time-stamped log file. To execute the script, from the bin directory, type
```bash
./test
```
and wait a few minutes for the script to run and create the log file.

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
tested and will run all of the desired functions. 

Early results show the HashTable provides faster searches than the ordered
Array, up to nearly twice as fast, but is much slower at insertion.

Additionally, there is an unknown bug in the HashTable class that causes it to
lose about 2000 of the 25000 records as it is inserting them into the table
when it loads data from the randomized csv. This bug does not occur when loading
from the ordered csv. 
