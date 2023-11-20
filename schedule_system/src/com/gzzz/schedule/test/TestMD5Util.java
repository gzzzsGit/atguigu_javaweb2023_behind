package com.gzzz.schedule.test;

import com.gzzz.schedule.util.MD5Util;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.Test;

/**
 * className: TestMD5Util
 * Package : com.gzzz.schedule.test
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/18 0:42
 * @Version 1.0
 */
public class TestMD5Util {
    @Test
    public void testEncrypt(){
        String encrypt = MD5Util.encrypt("123456");
        System.out.println(encrypt);

    }
}
