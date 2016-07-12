package org.tonykuo.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTester {

    @Test
    public void testParseDate() throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date expectedDate = sdf.parse("2016-01-01");
        
        Date actualDate = DateUtil.parseDate("2016-01-01");
        
        Assert.assertEquals(expectedDate, actualDate);
        
    }

}
