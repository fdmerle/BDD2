package rest_bdd;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.core.Response;

/**
 * Created by dmytro_moskalenko2 on 2/11/2016.
 */
public class RestRequestSender {
    private ResteasyClient client;
    public RestRequestSender() {
        client = new ResteasyClientBuilder().build();
    }
    public String sendGetRequest(String url) {
        ResteasyWebTarget target = client.target(url);
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        response.close();
        return value;
    }
}
