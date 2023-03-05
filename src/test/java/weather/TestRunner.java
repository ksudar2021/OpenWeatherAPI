package weather;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
tags="@valid or @error or @verify",
plugin = {"pretty", "html:reports/weather.html","json:reports/weather.json","junit:reports/weather.xml"}
)
public class TestRunner {
}
