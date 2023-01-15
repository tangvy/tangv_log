package com.tangv.core.util.sign;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    private Md5Util() {

    }

    public static String md5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            // buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        return result.toLowerCase();

    }
}
