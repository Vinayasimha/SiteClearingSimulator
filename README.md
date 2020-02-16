1) Object-oriented design principles with following design patterns are used to implement the solution:
	-> Command Design Pattern
	-> Composite Design Pattern

2) It is a Maven project.
3) "demo.siteClearingSimulator.SiteClearingSimulator" is the main class.
   Code reading can be started from this class for easy navigation through the implementation.
4) JUnit4 is used for unit testing.
5) To keep the coding simple following elements are not used:
	-> Loggers
	-> Resource bundle for static texts
6) Please follow the below steps to run the simulator
    i)   Run "mvn clean install" command under project directory to build the Jar
    ii)  SiteClearingSimulator-1.0.jar file will be built under target folder of the project
    iii) Run "java -jar SiteClearingSimulator-1.0.jar ..\src\test\resources\sitemap.txt" command under target folder of the project
    iV)  Site-map file path can be changed to run the simulator with a different input
