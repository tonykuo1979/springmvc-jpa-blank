package org.tonykuo.service.util;

import java.util.UUID;

/**
 * 
 * @author tony
 *
 */
public class UUIDUtil {

    public static UUID generateUUID() {
        
        return UUID.randomUUID();
    }
    
    public static void main(String[] args) {
        System.out.println(UUIDUtil.generateUUID().toString().replaceAll("-", ""));
    }
    
}
