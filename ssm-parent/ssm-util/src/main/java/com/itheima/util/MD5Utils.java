package com.itheima.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	/**
	 * 使用md5的算法进行加密
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
		// 如果生成数字未满32位，需要前面补0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}

	public static void main(String[] args) {
		System.out.println(md5("1234"));


		String prefix="!@#$%";
		String suffix="(&*%^&%&^%^&";
		String e1 = md5(prefix+"abc"+suffix);

		String e2 = md5(prefix+e1+suffix);
		String e3 = md5(prefix+e2+suffix);

		System.out.println(e3);

		//混淆字符

		//多次加密

		Md5Hash md5Hash = new Md5Hash("需要加密的明文","盐1",3);
		System.out.println(md5Hash);

		//b071074c2708c179686a75c14cd09c20

	}

}