package com.tangv.core.util.sign;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Rc4Util {

	private static Logger log = LoggerFactory.getLogger(Rc4Util.class);

	private Rc4Util(){

	}

	private static byte[] base(byte[] data, String key) {
		byte[] result = new byte[data.length];
		try {
			int x = 0;
			int y = 0;
			byte[] keyByte = initKey(key);
			int xorIndex;

			for (int i = 0; i < data.length; i++) {
				x = (x + 1) & 0xff;
				y = ((keyByte[x] & 0xff) + y) & 0xff;
				byte tmp = keyByte[x];
				keyByte[x] = keyByte[y];
				keyByte[y] = tmp;
				xorIndex = ((keyByte[x] & 0xff) + (keyByte[y] & 0xff)) & 0xff;
				result[i] = (byte) (data[i] ^ keyByte[xorIndex]);
			}
		} catch (Exception e) {
			log.error("初始化Rc4Util的加解密失败", e);
		}

		return result;
	}

	private static byte[] initKey(String aKey) {
		byte[] bkey = aKey.getBytes();
		byte[] state = new byte[256];

		for (int i = 0; i < 256; i++) {
			state[i] = (byte) i;
		}
		int index1 = 0;
		int index2 = 0;
		if (bkey.length == 0) {
			return null;
		}
		for (int i = 0; i < 256; i++) {
			index2 = ((bkey[index1] & 0xff) + (state[i] & 0xff) + index2) & 0xff;
			byte tmp = state[i];
			state[i] = state[index2];
			state[index2] = tmp;
			index1 = (index1 + 1) % bkey.length;
		}
		return state;
	}

	public static String encrypt(String data, String key) {
		return bytes2HexString(base(data.getBytes(), key));
	}

	public static String decrypt(String data, String key) {
		return new String(base(hexStringToBytes(data), key));
	}

	private static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	private static String bytes2HexString(byte[] b) {
		String a = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}

			a = a + hex;
		}
		return a;
	}

}
