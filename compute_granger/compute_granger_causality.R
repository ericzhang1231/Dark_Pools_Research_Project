installed.packages("lmtest") 
library(lmtest)
## Computing granger causality for Amihuds Meaasure for 2 weeks of data

ah2w<- read.csv("c:/Research/Turnover_Causality/Amihud_Causality_2Weeks.csv", header = TRUE, sep=",")
attach(ah2w)
Amihud_Causality_2Weeks.csv<-read.csv(file.choose(), header=TRUE) 
grangertest(AH_Post~AH_Pre, order = 1, data = Amihud_Causality_2Weeks.csv)

## Computing granger causality for Amihuds Meaasure for 4 weeks of data
ah4w<- read.csv("c:/Research/Turnover_Causality/Amihud_Causality_4Weeks.csv", header = TRUE, sep=",")
attach(ah4w)
Amihud_Causality_4Weeks.csv<-read.csv(file.choose(), header=TRUE)
grangertest(AH_POST~AH_PRE, order = 1, data = Amihud_Causality_4Weeks.csv)

## Computing granger causality for Turnover Meaasure for 2 weeks of data
to2w<- read.csv("c:/Research/Turnover_Causality/Turnover_Causality_2Weeks.csv", header = TRUE, sep=",")
attach(to2w)
Turnover_Causality_2Weeks.csv<-read.csv(file.choose(), header=TRUE)
grangertest(TO_Post~TO_Pre, order = 1, data = Turnover_Causality_2Weeks.csv)

## Computing granger causality for Turnover Meaasure for 4 weeks of data
to4w<- read.csv("c:/Research/Turnover_Causality/Turnover_Causality_4Weeks.csv", header = TRUE, sep=",")
attach(to4w)
Turnover_Causality_4Weeks.csv<-read.csv(file.choose(), header=TRUE)
grangertest(TO_POST~TO_PRE, order = 1, data = Turnover_Causality_4Weeks.csv)