package bdd;

/**
 * Created by dmytro_moskalenko2 on 2/9/2016.
 */


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/cucumber.json"})


public class testRunner {



}
