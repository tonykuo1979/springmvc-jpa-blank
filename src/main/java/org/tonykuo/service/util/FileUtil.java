package org.tonykuo.service.util;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author tonykuo
 *
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private static Class<?> searchBase = FileUtil.class;

    @SuppressWarnings("serial")
    private static ArrayList<String> searchPath = new ArrayList<String>() {
        {
            add("");
            add("../");
            add("/");
            add("/../");
            add("../../");
            add("/../../");
            add("/../../../");
        }
    };
    
    /**
     * 
     * @param fileName
     * @return
     */
    public static File searchPropFromFile(String fileName) {
        
        String base = searchBase.getProtectionDomain().getCodeSource().getLocation().getPath();
        
        File fileBase = new File(base);
        if (!fileBase.isDirectory()) {
            base = fileBase.getParent();
        }
        logger.debug("Search base: " + base + ", for: " + fileName);
        File file = new File(fileName);

        if (file.exists() && file.canRead()) {
            return file;
        }

        for (String inc : searchPath) {
            if (!inc.startsWith("/")) {
                file = new File(inc + fileName);
                if (file.exists() && file.canRead()) {
                    return file;
                }
            }

            file = new File(base + inc + fileName);
            if (file.exists() && file.canRead()) {
                return file;
            }
        }

        return null;
    }
    
    /**
     * 
     * @param fileName
     * @return
     */
    public static InputStream searchPropFromResource(String fileName) {
        
        InputStream is = null;

        for (String inc : searchPath) {
            is = searchBase.getResourceAsStream(inc + fileName);
            if (is != null) {
                logger.debug("Load properties from search path resource: " + inc + fileName);
                return is;
            }
        }

        is = Thread.currentThread().getClass().getResourceAsStream(fileName);
        if (is != null) {
            logger.debug("Load properties from current thread resource: " + fileName);
            return is;
        }

        return is;
    }

}
