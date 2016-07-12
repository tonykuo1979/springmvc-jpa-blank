package org.tonykuo.service.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author tony
 *
 */
public class PropertiesUtil {
    
    private static Properties properties = PropertiesUtil.load("test.properties");
    
    /**
     * 
     * @param fileName 設定檔名稱
     * @return
     */
    public static Properties load(final String fileName) {

        Properties prop = new Properties();
        InputStream is = null;

        try {
            is = FileUtil.searchPropFromResource(fileName);
            prop.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop;
    }
    
    public static Properties getProperties() {
        return properties;
    }

}
