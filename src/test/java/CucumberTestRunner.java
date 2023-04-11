import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        }
)
@ExtendWith(AllureJunit5.class)
public class CucumberTestRunner {
}