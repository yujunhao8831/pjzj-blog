package com.blog.string;/**
 * Created by apple on 15/11/8.
 */

import org.junit.Test;

/**
 * com.blog.string
 *
 * @author : 余峻豪
 * @date : 15/11/8
 */
public class StringTest {
    @Test
    public void testContains () throws Exception {

        String values[] = new String[]{"aaa.js","bb.css","zzz.jpg","index","request"};

        for (String value : values ) {
            if (value.contains(".")) {
                System.err.println("value = " + value);
            }
        }

    }
}
