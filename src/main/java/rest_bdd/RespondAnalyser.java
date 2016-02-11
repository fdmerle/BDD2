package rest_bdd;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by dmytro_moskalenko2 on 2/11/2016.
 */
public class RespondAnalyser {


    public HashMap<String, String> returnRespond(String requestResult) {

        try {
            return new ObjectMapper().readValue(requestResult, new TypeReference<HashMap<String, Object>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
