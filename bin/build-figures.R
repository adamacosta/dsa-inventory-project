#! /usr/bin/Rscript

## takes the test results from results.csv and creates a data.frame,
## then plots run times for each structure as a function of the number of 
## records processed and whether or not they were random

results <- read.csv("results.csv")

array.sort <- results[1:5,]
array.rand <- results[6:10,]
hash.sort <- results[11:15,]
hash.rand <- results[16:20,]
tree.sort <- na.omit(results[21:25,])
tree.rand <- results[26:30,]

## display six plots per panel
par(mfrow=c(3,2))

## six plots to produce:
## load time against records - sorted
## load time against records - random
## sale time against records - sorted
## sale time against records - random
## search time against records - sorted
## search time against records - random

## generate smooth curves to plot
ar.sort.ltime <- spline(array.sort$ltime)
ar.rand.ltime <- spline(array.rand$ltime)
ar.sort.saletime <- spline(array.sort$saletime)
ar.rand.saletime <- spline(array.rand$saletime)
ar.sort.searchtime <- spline(array.sort$searchtime)
ar.rand.searchtime <- spline(array.rand$searchtime)

hs.sort.ltime <- spline(hash.sort$ltime)
hs.rand.ltime <- spline(hash.rand$ltime)
hs.sort.saletime <- spline(hash.sort$saletime)
hs.rand.saletime <- spline(hash.rand$saletime)
hs.sort.searchtime <- spline(hash.sort$searchtime)
hs.rand.searchtime <- spline(hash.rand$searchtime)

tr.sort.ltime <- spline(tree.sort$ltime)
tr.rand.ltime <- spline(tree.rand$ltime)
tr.sort.saletime <- spline(tree.sort$saletime)
tr.rand.saletime <- spline(tree.rand$saletime)
tr.sort.searchtime <- spline(tree.sort$searchtime)
tr.rand.searchtime <- spline(tree.rand$searchtime)

png("figures.png")

## plot one

