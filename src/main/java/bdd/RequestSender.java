package bdd;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dmytro_moskalenko2 on 2/11/2016.
 */
public class RequestSender {
    private ResteasyClient client;
    private RequestVariables requestType;


    public RequestSender(RequestVariables requestType) {
        this.requestType = requestType;
        client = new ResteasyClientBuilder().build();
    }

    public String requestSender(String url) {
        Response response;
        String value;
        ResteasyWebTarget target = client.target(url);
        switch (requestType.requestType) {

            case GET:

                response = target.request().get();
                value = response.readEntity(String.class);
                response.close();
                return value;

            case POST:
                Form form = new Form();
                for (String item : requestType.parameters.keySet()) {
                    form.param(item, requestType.parameters.get(item));
                }
                Entity<Form> entity = Entity.form(form);
                Response serviceResponse = target.request(MediaType.APPLICATION_JSON).post(entity);
                serviceResponse.close();
                return serviceResponse.readEntity(String.class);

            default:
                return null;
        }
    }
}
