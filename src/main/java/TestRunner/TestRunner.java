package TestRunner;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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