package TestRunner;

import org.testng.TestNG;
import java.util.Arrays;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        List<String> suites = Arrays.asList("TestNG.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}