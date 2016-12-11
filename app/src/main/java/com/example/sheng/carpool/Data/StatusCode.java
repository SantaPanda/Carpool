package com.example.sheng.carpool.Data;

public interface StatusCode
{
	public static final int OK = 200;
	public static final int FAILED = 110;

	public static final int WRONG_PASSWORD = 112;
	public static final int FAILED_TO_EXCUTE_SQL = 113;
	public static final int FAILED_TO_SEARCH_USERNAME = 114;
	public static final int FAILED_TO_SEARCH_RESULT = 115;
	public static final int HAD_IN = 116;

	public static final int WROONG_TYPE_OF_REQUEST = 300;

	public static final int ACCOUNT_EXISTED = 400;

	public static final int FAILED_TOCONNECT_DATABASE = 999;
}
