package rest_bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;

/**
 * Created by dmytro_moskalenko2 on 2/11/2016.
 */
public class StepDefinition {
    private RequestSender getRequest;
    private String respond;
    private RequestVariables requestVariables;

    @Given("^The \"([^\"]*)\" request was created with parameters: (\\s+)$")
    public void requestCreation(ListOfPossibleTypes requestType, String requestParam) {
        requestVariables.parameters = new RequestParameterBuilder().stringToHashMapTransformer(requestParam);
        requestVariables.requestType = requestType;
        getRequest = new RequestSender(requestVariables);
    }

    @When("^Client send to the server (\\s+) GET request$")
    public void requestSender(String url) {

        respond = getRequest.requestSender(url);
    }

    @Then("^Server return grreting: (\\s+)$")
    public void resultAnalyser(String serverRespond) {

        RespondAnalyser respond = new RespondAnalyser();
        HashMap<String, String> structuredRespond = respond.returnRespond(this.respond);

    }
}
