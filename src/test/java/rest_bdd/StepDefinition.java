package rest_bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;

/**
 * Created by dmytro_moskalenko2 on 2/11/2016.
 */
public class StepDefinition {
    private RestRequestSender getRequest;
    private String respond;

    @Given("^The GET request was created$")
            public void requestCreation(){
        getRequest = new RestRequestSender();

    }
    @When("^Client send to the server (\\s+) GET request$")
    public void requestSender(String url){
        respond=getRequest.sendGetRequest(url);
    }

    @Then("^Server return grreting: (\\s+)$")
    public void resultAnalyser(String serverName){

        RespondAnalyser respond=new RespondAnalyser();
        HashMap<String, String> structuredRespond = respond.returnRespond(this.respond);

    }
}
