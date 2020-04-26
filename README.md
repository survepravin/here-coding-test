# HERE coding test

As a SDET, you are tasked with creating an automated test suite for a coding exercise.


## Installation
Clone the project in your local drive.
```sh
git clone https://github.com/survepravin/here-coding-test.git
```

Import as maven project in any IDE.

## To run the automated test suite

**Pre-requisites** : Machine should have Java 8 and Maven

#### From cmd
Open cmd and navigate to project path then run below command:

```
mvn clean install surefire-report:report
```

#### From Eclipse
import as maven project in any IDE, run maven commands
```
clean install surefire-report:report
```

**Note:** If tests fails then run ```mvn surefire-report:report``` separately to generate report. Report path : ```/SimulatorTest/target/site/surefire-report.html```

## To run Application

_**Autonomous Driving Simulator Test**_,
after successful execution of the tests, jar file will be created at the path : ```/SimulatorTest/target/autonomous.driving.simulator.test-0.0.1.jar```

* Open cmd and navigate to target folder. Run this command ```java -jar autonomous.driving.simulator.test-0.0.1.jar``` 

* Another way, navigate to project folder, double click on _runApp.bat_ file 

User will be asked to Enter Driving mode and sensor event numbers, on valid input speed will be displayed as output.

```
Enter Driving Mode
A
Enter Sensor event numbers
25

Output
Speed: 70
```

## License
[MIT](https://choosealicense.com/licenses/mit/)