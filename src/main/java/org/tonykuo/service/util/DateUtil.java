package org.tonykuo.service.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {

    private static final Map<String, String> DATE_FORMAT_REGEXPS = new HashMap<String, String>() {
        
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        {
            put("^\\d{4}-\\d{1,2}-\\d{1,2}$", "yyyy-MM-dd");
            put("^\\d{8}$", "yyyyMMdd");
            put("^\\d{4}/\\d{1,2}/\\d{1,2}$", "yyyy/MM/dd");
            put("^\\d{1,2}-\\d{1,2}-\\d{4}$", "dd-MM-yyyy");
            put("^\\d{1,2}/\\d{1,2}/\\d{4}$", "MM/dd/yyyy");
            put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}$", "dd MMM yyyy");
            put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}$", "dd MMMM yyyy");
            put("^\\d{12}$", "yyyyMMddHHmm");
            put("^\\d{8}\\s\\d{4}$", "yyyyMMdd HHmm");
            put("^\\d{1,2}-\\d{1,2}-\\d{4}\\s\\d{1,2}:\\d{2}$",
                    "dd-MM-yyyy HH:mm");
            put("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}$",
                    "yyyy-MM-dd HH:mm");
            put("^\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{2}$",
                    "MM/dd/yyyy HH:mm");
            put("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}$",
                    "yyyy/MM/dd HH:mm");
            put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}\\s\\d{1,2}:\\d{2}$",
                    "dd MMM yyyy HH:mm");
            put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}\\s\\d{1,2}:\\d{2}$",
                    "dd MMMM yyyy HH:mm");
            put("^\\d{4}-\\d{1,2}-\\d{1,2}t\\d{1,2}:\\d{2}:\\d{2}z$",
                    "yyyy-MM-dd'T'HH:mm:ss'Z'");
            put("^\\d{14}$", "yyyyMMddHHmmss");
            put("^\\d{8}\\s\\d{6}$", "yyyyMMdd HHmmss");
            put("^\\d{1,2}-\\d{1,2}-\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$",
                    "dd-MM-yyyy HH:mm:ss");
            put("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$",
                    "yyyy-MM-dd HH:mm:ss");
            put("^\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$",
                    "MM/dd/yyyy HH:mm:ss");
            put("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$",
                    "yyyy/MM/dd HH:mm:ss");
            put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$",
                    "dd MMM yyyy HH:mm:ss");
            put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$",
                    "dd MMMM yyyy HH:mm:ss");
            
            // 19/Jun/2015
            put("^\\d{1,2}/[a-z]{3}/\\d{4}$", "dd/MMM/yyyy");
        }
    };

    private static String determineDateFormat(String dateString) {
        
        if (dateString == null) {
            return null;
        }
        
        for (String regexp : DATE_FORMAT_REGEXPS.keySet()) {
            if (dateString.toLowerCase().matches(regexp)) {
                return DATE_FORMAT_REGEXPS.get(regexp);
            }
        }
        
        return null; // Unknown format.
    }
    
    /**
     * Time Zone = Locale.ENGLISH
     *
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
        
        /*
         * data format regex valid 
         */
//        if (!(date ==~ /([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(-|\\|\/|\.)?(((0[13578]|1[02])\2?(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)\2?(0[1-9]|[12][0-9]|30))|(02\2?(0[1-9]|[1][0-9]|2[0-9])))/)) {
//            return null;
//        }
        
        String fmt = determineDateFormat(date);
        
        if (fmt == null) {
            return null;
        }

        DateFormat fmtInput = new SimpleDateFormat(fmt, Locale.ENGLISH);
        
        try {
            fmtInput.setTimeZone(TimeZone.getTimeZone("GMT"));
            return fmtInput.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 
     * @param date
     * @param dateFormat 時間格式
     * @return
     */
    public static String toISODate(Date date, String dateFormat) {
        
        TimeZone tz = TimeZone.getTimeZone("UTC");
        // DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        DateFormat df = new SimpleDateFormat(dateFormat);
        df.setTimeZone(tz);
        
        return df.format(date);
    }
    
}