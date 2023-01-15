package com.tangv.core.util.sign;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *  Base64加解密工具类
 */
public class Base64Util {

    public static boolean isBase64(String source) {
        String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
        return Pattern.matches(base64Pattern, source);
    }

    public static String encode(String source){
        if (source == null) {
            return null;
        }
        if ("".equals(source)) {
            return "";
        }
        return java.util.Base64.getEncoder().encodeToString(source.getBytes());
    }

    public static String decode(String source){
        if (source == null) {
            return null;
        }
        if ("".equals(source)) {
            return "";
        }
        return new String(java.util.Base64.getDecoder().decode(source.getBytes()));
    }

    public static void main(String[] args) {
        System.out.println(isBase64("SU1HXzg5NTIuUE5H"));

        Map<String,String> aa = new HashMap<>();
        aa.put("111","111");
        aa.put("111","43333");
        aa.put("222","22");

    }
}
