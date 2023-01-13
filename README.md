# most_active_cookie
Most active cookie submission for Quantcast.
# How To Run Program
Use the .jar file inside of the repository named most_active_cookie.jar. In the terminal make sure to cd into the directory the jar is located in. Make sure your csv file is in the same file path.
Run the command: java -jar most_active_cookie.jar FILENAME.csv -d YYYY-MM-DD
# How To Run The Test Suite
Note: The jar is built with the test suite compiled in, so when I compiled the jar it passed the test suite. If you want to recompile, I built the application with gradle, so if you download the repo and run ./gradlew build, it will install gradle as the wrapper and build a new jar after running tests. Navigate to build/libs and the most_active_cookie.jar file will be in there to run. Then you can navigate and run it with the command above.
1. In src/test/java/org.example there are two test classes CSVManagerTests and InputValidatorTests. The green arrow on the left will run tests in the file. A console will popup and say if a test failed (which they shouldn't) or if a test passed.
2. The correctFormat.csv and empty.csv are csv files used in the CSVManagerTests file, the file routing is hard coded into the tests so if you want to run the tests in a different file structures you will have to go edit the file paths inside the file.
