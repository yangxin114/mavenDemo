package org.lw.mavendemo.sys.utils;

public class DBUtil {

	public static String USER_PREFIX = "UR";
	public static String ROLE_PREFIX = "RL";
	public static String RESOURCE_PREFIX = "RES";
	public static String PERMISSION_PREFIX = "PERM";
	public static int INIT_NUM = 10000001;

	public static String genericUserNo(String lastUserNo) {
		return genericNo(USER_PREFIX, lastUserNo);
	}

	private static String genericNo(String prefix, String lastNo) {
		if (lastNo == null) {
			return prefix + INIT_NUM;
		} else {
			return prefix + Integer.parseInt(lastNo.replace(prefix, ""));
		}
	}
}
