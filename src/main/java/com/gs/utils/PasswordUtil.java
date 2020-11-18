package com.gs.utils;

import org.apache.shiro.crypto.hash.SimpleHash;


public class PasswordUtil {

	private PasswordUtil() {

	}

	/**
	 * 根据用户输入的明文密码进行加密
	 * @param userPassword
	 * @return
	 */
	public static String generatePassword(String salt,String userPassword) {
		// 使用SimpleHash 加密
		Object newPassword = new SimpleHash("md5", userPassword, salt, 1024);
		return newPassword.toString();
	}


}