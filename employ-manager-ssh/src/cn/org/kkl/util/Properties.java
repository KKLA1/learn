package cn.org.kkl.util;

public class Properties {

	public static final int Page_SIZE = 3;

	public static final int getId() {
		String str = System.currentTimeMillis() + "";
		return Integer.parseInt(str.substring(5, 12));
	}

	public static final int getEid() {
		String str = System.currentTimeMillis() + "";
		return Integer.parseInt(str.substring(7, 12));
	}

}
