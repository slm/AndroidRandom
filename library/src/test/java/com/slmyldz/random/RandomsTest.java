package com.slmyldz.random;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by slmyldz on 09.06.2016.
 */
public class RandomsTest {

    @Test
    public void testInteger() throws Exception {
        int i =Randoms.Integer(10,50);
        assertTrue("Test failed 10-50 i="+i,i<=50 && i>=10);
    }

    @Test
    public void testDouble() throws Exception {
        double i =Randoms.Double(3.5,50.25);
        assertTrue("Test failed 3.5-50.25 d="+i,i>=3.5 && i<=50.25);
    }

    @Test
    public void testFloat() throws Exception {
        float i =Randoms.Float(3.50f,50.25f);
        assertTrue("Test failed 3.50f-50.25f f="+i,i>=1.50f && i<=150.25f);
    }

    @Test
    public void testAlphaNumericString() throws Exception {
        String s = Randoms.alphaNumericString(15);
        assertTrue("Test failed length ="+s.length(),s.length() == 15);
    }

    @Test
    public void testDateBefore() throws Exception {
        Date date =Randoms.dateBefore();
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        assertTrue("now= " +format.format(now) +" before= " + format.format(date),now.getTime() > date.getTime());

    }

    @Test
    public void testDateAfter() throws Exception {
        Date date =Randoms.dateAfter();
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        assertTrue("now= " +format.format(now) +" after= " + format.format(date), now.getTime() < date.getTime());
    }

    @Test
    public void repeatTest() throws Exception {
        for (int i = 0; i < 1000000; i++) {
            testAlphaNumericString();
            testDateAfter();
            testDateBefore();
            testDouble();
            testFloat();
            testInteger();
        }
    }


}