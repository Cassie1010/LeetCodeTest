package com.zmm.gitee;

import com.sun.org.apache.xerces.internal.impl.io.ASCIIReader;
import sun.misc.ASCIICaseInsensitiveComparator;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.Base64;

public class Test {
    public static void main(String[] args) {

    }

    public static void t1(){
        try {
            System.out.println(new String(new BASE64Decoder().decodeBuffer("LmNvbS9tdnBocA==")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
