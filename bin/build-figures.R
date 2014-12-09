#! /usr/bin/Rscript

## takes the test results from results.csv and creates a data.frame,
## then plots run times for each structure as a function of the number of 
## records processed and whether or not they were random

results <- read.csv("results.csv")

ar.sort <- results[1:10,]
ar.rand <- results[11:20,]
hs.sort <- results[21:30,]
hs.rand <- results[31:40,]
tr.sort <- results[41:50,]
tr.rand <- results[51:60,]

## six plots to produce:
## load time against records - sorted
## load time against records - random
## sale time against records - sorted
## sale time against records - random
## search time against records - sorted
## search time against records - random

## generate smooth curves to plot
ar.sort.ltime <- smooth.spline(ar.sort$nrec,ar.sort$ltime)
ar.rand.ltime <- smooth.spline(ar.rand$nrec,ar.rand$ltime)
ar.sort.saletime <- smooth.spline(ar.sort$nrec,ar.sort$saletime)
ar.rand.saletime <- smooth.spline(ar.rand$nrec,ar.rand$saletime)
ar.sort.searchtime <- smooth.spline(ar.sort$nrec,ar.sort$searchtime)
ar.rand.searchtime <- smooth.spline(ar.rand$nrec,ar.rand$searchtime)

hs.sort.ltime <- smooth.spline(hs.sort$nrec,hs.sort$ltime)
hs.rand.ltime <- smooth.spline(hs.rand$nrec,hs.rand$ltime)
hs.sort.saletime <- smooth.spline(hs.sort$nrec,hs.sort$saletime)
hs.rand.saletime <- smooth.spline(hs.rand$nrec,hs.rand$saletime)
hs.sort.searchtime <- smooth.spline(hs.sort$nrec,hs.sort$searchtime)
hs.rand.searchtime <- smooth.spline(hs.rand$nrec,hs.rand$searchtime)

tr.sort.ltime <- smooth.spline(tr.sort$nrec,tr.sort$ltime)
tr.rand.ltime <- smooth.spline(tr.rand$nrec,tr.rand$ltime)
tr.sort.saletime <- smooth.spline(tr.sort$nrec,tr.sort$saletime)
tr.rand.saletime <- smooth.spline(tr.rand$nrec,tr.rand$saletime)
tr.sort.searchtime <- smooth.spline(tr.sort$nrec,tr.sort$searchtime)
tr.rand.searchtime <- smooth.spline(tr.rand$nrec,tr.rand$searchtime)

## open the file to write to
png("figures.png",width=1000,height=1200)

## display six plots per panel
par(mfrow=c(3,2))

## plot one
plot(ar.sort.ltime,type="n",xlab="",ylab="",axes=F,ylim=c(0,max(tr.sort$ltime)))
box()
lines(ar.sort.ltime,col="blue")
lines(hs.sort.ltime,col="red")
lines(tr.sort.ltime,col="green")
title(main="Load Times - Sorted",xlab="Number of Records",ylab="time")
legend("bottomright",col=c("blue","red","green"),legend=c("Array","Hash Table","Binary Tree"),lty=1)

## plot two
plot(ar.rand.ltime,type="n",xlab="",ylab="",axes=F,ylim=c(0,max(ar.rand$ltime)))
box()
lines(ar.rand.ltime,col="blue")
lines(hs.rand.ltime,col="red")
lines(tr.rand.ltime,col="green")
title(main="Load Times - Random",xlab="Number of Records",ylab="time")
legend("bottomright",col=c("blue","red","green"),legend=c("Array","Hash Table","Binary Tree"),lty=1)

## plot three
plot(ar.sort.saletime,type="n",xlab="",ylab="",axes=F,ylim=c(0,max(tr.sort$saletime)))
box()
lines(ar.sort.saletime,col="blue")
lines(hs.sort.saletime,col="red")
lines(tr.sort.saletime,col="green")
title(main="Sale Times - Sorted",xlab="Number of Records",ylab="time")
legend("bottomright",col=c("blue","red","green"),legend=c("Array","Hash Table","Binary Tree"),lty=1)

## plot four
plot(ar.rand.saletime,type="n",xlab="",ylab="",axes=F,ylim=c(0,max(ar.rand$saletime)))
box()
lines(ar.rand.saletime,col="blue")
lines(hs.rand.saletime,col="red")
lines(tr.rand.saletime,col="green")
title(main="Sale Times - Random",xlab="Number of Records",ylab="time")
legend("bottomright",col=c("blue","red","green"),legend=c("Array","Hash Table","Binary Tree"),lty=1)

## plot five
plot(ar.sort.searchtime,type="n",xlab="",ylab="",axes=F,ylim=c(0,max(tr.sort$searchtime)))
box()
lines(ar.sort.searchtime,col="blue")
lines(hs.sort.searchtime,col="red")
lines(tr.sort.searchtime,col="green")
title(main="Search Times - Sorted",xlab="Number of Records",ylab="time")
legend("bottomright",col=c("blue","red","green"),legend=c("Array","Hash Table","Binary Tree"),lty=1)

## plot six
plot(ar.rand.searchtime,type="n",xlab="",ylab="",axes=F,ylim=c(0,max(tr.rand$searchtime)))
box()
lines(ar.rand.searchtime,col="blue")
lines(hs.rand.searchtime,col="red")
lines(tr.rand.searchtime,col="green")
title(main="Search Times - Random",xlab="Number of Records",ylab="time")
legend("bottomright",col=c("blue","red","green"),legend=c("Array","Hash Table","Binary Tree"),lty=1)

## close file
dev.off()