package com.tangv.core.util.sign;

public class SignUtil {
    private SignUtil() {

    }

    public static String sign(String str, BIT bit) {
        return ConversionUtils.generateShort(str, bit.bit);
    }


    public static String encrypt(String str, Type type) {
        String result = null;
        switch (type) {
            case Blow:
                result = BlowfishUtil.encrypt(str, type.getKey());
                break;
            case Rc4:
                result = Rc4Util.encrypt(str, type.getKey());
                break;
        }

        return result;
    }


    public static String decrypt(String str, Type type) {
        String result = null;
        switch (type) {
            case Blow:
                result = BlowfishUtil.decrypt(str, type.getKey());
                break;
            case Rc4:
                result = Rc4Util.decrypt(str, type.getKey());
                break;
        }

        return result;
    }

    public enum Type {
        Blow("signUtilBlow"), Rc4("signUtilRc4");
        private final String key;

        Type(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public enum BIT {
        _62(6), _4(4);
        private final int bit;

        BIT(int bit) {
            this.bit = bit;
        }
    }

}
