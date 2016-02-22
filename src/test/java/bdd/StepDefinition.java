package bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by dmytro_moskalenko2 on 2/11/2016.
 */
public class StepDefinition {
    private RequestSender getRequest;
    private int respond;


    @Given("^The \"([a-zA-Z() ]+)\" request was created with parameters: \"(.*)\"$")
    public void requestCreation(ListOfPossibleTypes requestType, String requestParam) {
        RequestVariables requestVariables = new RequestVariables();
        requestVariables.parameters = new RequestParameterBuilder().stringToHashMapTransformer(requestParam);
        requestVariables.requestType = requestType;
        getRequest = new RequestSender(requestVariables);
    }

    @When("^Client send to the server \"(http:.+)\" request$")
    public void requestSender(String url) {

        respond = getRequest.requestSender(url);
    }

    @Then("^Server return grreting: \"([1-9].+)\"$")
    public void resultAnalyser(int serverRespond) {
        Assert.assertTrue(respond==serverRespond);



    }
}
