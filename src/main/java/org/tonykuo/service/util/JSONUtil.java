package org.tonykuo.service.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * 
 * @author tony
 *
 */
public class JSONUtil {
    
    public static boolean isJSONValid(String jsonString) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonString);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    public static String object2Json(Object obj) {
        return object2Json(obj, false);
    }
    
    public static String object2Json(Object obj, boolean pertty) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            ObjectWriter ow = objectMapper.writer();
            if (pertty) {
                ow = ow.withDefaultPrettyPrinter();
            }
            String json = ow.writeValueAsString(obj);
            return json;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 
     * @param mapData
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String mapToJSONString(Map mapData) {
        
        StringBuilder sb = new StringBuilder();
        
        if (mapData.size() > 0) {
            int i = 0;
            sb.append("{ ");
            Iterator it = mapData.entrySet().iterator();
            while (it.hasNext()) { 
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                
                if (key.toString().equals("name") || key.toString().equals("country")) {
                    
                    if (i++ == 0) {
                        sb.append("\"" + key.toString() + "\" : { \"origin\" : \"" + entry.getValue() + "\" }");
                    } else {
                        sb.append(", \"" + key.toString() + "\" : { \"origin\" : \"" + entry.getValue() + "\" }");
                    }
                    
                } else if (key.toString().equals("sequence")) {
                    
                    if (i++ == 0) {
                        sb.append("\"" + key.toString() + "\" : " + entry.getValue());
                    } else {
                        sb.append(", \"" + key.toString() + "\" : " + entry.getValue());
                    }
                    
                } else {
                    
                    if (i++ == 0) {
                        sb.append("\"" + key.toString() + "\" : \"" + entry.getValue() + "\"");
                    } else {
                        sb.append(", \"" + key.toString() + "\" : \"" + entry.getValue() + "\"");
                    }
                    
                }
                
            }   // end if (mapData.size() > 0)
            
            sb.append(" }");
            
        }
        
        return sb.toString();
        
    }   // end mapToJSONString
    
}
