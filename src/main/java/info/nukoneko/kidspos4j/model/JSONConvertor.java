package info.nukoneko.kidspos4j.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.nukoneko.kidspos4j.model.BaseModelAbstract;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by atsumi on 2016/02/03.
 */
public class JSONConvertor {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static String toJSON(Object obj){
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static <T extends BaseModelAbstract> T parse(String json, Class<T> clazz){
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
