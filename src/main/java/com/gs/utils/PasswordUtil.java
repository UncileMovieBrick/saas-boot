package com.gs.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;


public class PasswordUtil {

	private PasswordUtil() {

	}

	/**
	 * 根据用户输入的明文密码进行加密
	 * @param userPassword
	 * @return
	 */
	public static String generatePassword(String userName,String userPassword) {
		// 获取加密工具
		ByteSource password = ByteSource.Util.bytes(userPassword);
		// 使用SimpleHash 加密
		Object newPassword = new SimpleHash("md5", password, userName, 1024);
		return newPassword.toString();
	}


}