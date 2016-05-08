# PaymentTracker

<b>Build</b>

Apache Maven: 3.X.X

Java: 1.7

Go to project folder and build with "mvn clean install" or open in. 

<b>Run</b>

java -jar payment-tracker-1.0-SNAPSHOT.jar 

or

java -jar payment-tracker-1.0-SNAPSHOT.jar payments-file-path

payments-file-path you can type to console after run.

paymentTracker

Reading from any payments-file containing data structure like:

USD 1000

HKD 100

USD -100

RMB 2000

HKD 200



"quit" command shut downs the application

RATE is applied if there is defined CURRENCY in ExchangeService

<b>OUTPUT:</b>

USD 900

RMB 2000 (USD 314.60)

HKD 300 (USD 38.62)



<b>NOTE: Tested on OS Windows ONLY.</b>

