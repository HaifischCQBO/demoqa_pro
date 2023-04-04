package TestRunner;

import org.testng.TestNG;
import java.util.Arrays;
import java.util.List;

// This is the main class that runs the TestNG test suite
public class TestRunner {

    // The main method that is executed when the program starts
    public static void main(String[] args) {

        // Create a TestNG object to run the tests
        TestNG testng = new TestNG();

        // Specify the TestNG test suite XML file to use
        List<String> suites = Arrays.asList("TestNG.xml");
        testng.setTestSuites(suites);

        // Run the TestNG tests
        testng.run();
    }
}
