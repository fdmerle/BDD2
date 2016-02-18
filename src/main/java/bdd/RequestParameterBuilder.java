package bdd;

import java.util.HashMap;

/**
 * Created by dmytro_moskalenko2 on 2/17/2016.
 */
public class RequestParameterBuilder {

    public HashMap<String,String> stringToHashMapTransformer(String parameterRequest) {
        String outsideParameterPairDelimiter = ",";
        String insideParameterPairDelimiter = "=";
        HashMap<String,String> requestParam=new HashMap<>();
        String[] keyValueOfParameter;
        String[] pairsOfParameters = parameterRequest.split(outsideParameterPairDelimiter);

        for (String item : pairsOfParameters) {
            keyValueOfParameter = item.split(insideParameterPairDelimiter);
            requestParam.put(keyValueOfParameter[0], keyValueOfParameter[1]);
        }

        return requestParam;
    }
}
