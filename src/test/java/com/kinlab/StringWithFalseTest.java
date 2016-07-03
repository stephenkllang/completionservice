package com.kinlab;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

/**
 * Created by slangg on 0028, June, 28, 2016.
 */
public class StringWithFalseTest {
    @Test
    public void aMethod() throws Exception {
        StringWithFalse stringWithFalse = new StringWithFalse();
        stringWithFalse.setEmail("\u0000");
        assertTrue(stringWithFalse.getEmail().length() > 0);
        assertTrue(stringWithFalse.getEmail().length() <= 1);
        byte[] myBytes;
        try {
            myBytes = stringWithFalse.getEmail().getBytes("UTF-8");
            assertTrue(myBytes.length > 0);
            assertTrue(myBytes.length <= 1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

}