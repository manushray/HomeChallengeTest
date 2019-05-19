# HomeChallengeTest

# Description About Code/Framework :

I have created a partial Automation Framework comprise of (Selenium+ JAVA+ Page Object Model+ TestNG + log4j2+ ExtentReport).

• "Base" class is Parent Class of all the Test Class & Login Class(Class as page object repository) where Driver initialisation + capabilities are defined which is present under package name "Challenge.HomeChallenge.Base".
• All the application code is present under package: “Challenge.HomeChallenge”.
• Logging is done by using log4j2. 
• Test Cases are handled by TestNG and as I have build my code using MAVEN hence its present under “src/test/java”.
• Reporting for better visual purpose is done by ExtentReport.
• Screen Shot after each test case/ method is done is also completed and the screen shot will be present under ScreenShot folder at root level of the folder.


As I have made my code dynamic from where you can change the parameter and data set/Test scenario by changing in the config.properties file which is present under package name "src/main/java/Challenge/HomeChallenge/Configuration/config.properties”

No need to change anywhere in the code but if you want to change the test data mention in the code challenge then you can change the data in config.properties which is present in configuration package.

For eg:
• browser= ff for Firefox & safari for "safari" (but for safari also change the conifguration in the browser Menu Bar > Develop > Allow Remote Automation"
• client_to_be_mocked= give any client name which you want to mock
• embed_question= Give any question you want.
• embed_answers= Give any 3 answer comma seperated
• embed_creation_name= Give any name which you want to for creating an embed

Total time which code will run : 39.737 sec

# Steps for How to build and execute the solution/code:

# Steps to run from command line

cd /to path where you want to clone the code.

Copy the command and hit it at the terminal:

git clone https://github.com/manushray/HomeChallengeTest.git

cd / to HomeChallengeTest

run the below command:

mvn clean install

# Step to run the code from Eclipse

Clone the code at your preferred location by entering below command:

git clone https://github.com/manushray/HomeChallengeTest.git

Open the project from Eclipse:

Browse the location of the clone project from the eclipse

Click on the "Import > Maven > Existing Maven Projects > Browse > HomeChallengeTest > Finish".

Right click on the project > Run As > Maven test
