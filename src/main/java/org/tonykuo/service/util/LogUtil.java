package org.tonykuo.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

/**
 * 
 * @author tony
 *
 */
public class LogUtil {
    
    public static void debug(String message) {
        log(message);
    }

    public static void info(String message) {
        log(message);
    }
    
    public static void error(String message) {
        log(message);
    }
    
    private static void log(String message) {
        
        Logger logger = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
        
        if (logger.isDebugEnabled()) {
            ((LocationAwareLogger) logger).log(null, Thread.currentThread().getStackTrace()[2].getClassName(), LocationAwareLogger.DEBUG_INT, message, null, null);
        } else if (logger.isInfoEnabled()) {
            ((LocationAwareLogger) logger).log(null, Thread.currentThread().getStackTrace()[2].getClassName(), LocationAwareLogger.INFO_INT, message, null, null);
        } else if (logger.isErrorEnabled()) {
            ((LocationAwareLogger) logger).log(null, Thread.currentThread().getStackTrace()[2].getClassName(), LocationAwareLogger.ERROR_INT, message, null, null);
        }
        
    }
    
}
