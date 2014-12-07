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
type of data structure you wish to use.

##### Flags
```bash
-f fileName
```
The -f flag tells the program which file to load data from. The directory
comes pre-loaded with sort-10000.csv, sort-25000.csv, sort-50000.csv,
sort-100000.csv, sort-1000000.csv, rand-10000.csv, rand-25000.csv, 
rand-50000.csv, rand-100000.csv, and rand-1000000.csv. If no filename is
passed from the command line, the program will default to loading data from
sort-10000.csv.
```bash
-i
```
The -i flags tells the program to run in interactive mode, which allows you
to make sales, run searches, and close the store when complete.
```bash
-t numberOne numberTwo
```
The -t flag tells the program to run in test mode. Follow the flag with two
optional numbers, numberOne and numberTwo, which specify the number of
sales and the number of searches to run, respectively. If either or both
numbers are not passed from the command line, test mode defaults to running
10000 sales and 10000 searches. 

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

#### Creating the .csv Files

There is an executable file in the bin directory named "make-csv." To execute
this program, type in
```bash
./make-csv
```
The prompt will ask you for a file name, the number of records to create, and
whether or not you want the records to be sorted or in random order. Upon
completion, a csv file will be created. Note that it will only have a .csv
appended to the name if you specify that when giving a name to use. The C++
source code to create this program is also in the bin directory. If you want to
compile it from source, type in
```bash
g++ -o name -std=c++11 write-csv.cpp
```
where "name" is whatever you want to call the program. You must specify that
you want to use the C++11 standard since the source code contains features not
supported by earlier standards. 

#### Status Updates

Currently, both the HashTable and ItemArray container classes have been
tested and will run all of the desired functions. 

Early results show the HashTable provides faster searches than the ordered
Array, up to nearly twice as fast, but is much slower at insertion.

Additionally, there is an unknown bug in the HashTable class that causes it to
lose about 2000 of the 25000 records as it is inserting them into the table
when it loads data from the randomized csv. This bug does not occur when loading
from the ordered csv. 
