package com.jd.jr.access.concurrent;

/**
 * 保存数据源key值的threadLocal，key值由集群维度和集群下数据库编号组成
 *
 */
public class DataSourceKeyThreadLocal {

	/** 数据库路由存储 **/
	private static final ThreadLocal<String> dbHolder = new ThreadLocal<String>();
	/** 表路由存储 **/
	private static final ThreadLocal<String> tableIndexHolder = new ThreadLocal<String>();

	public static void setDbKey(String dbKey) {
		dbHolder.set(dbKey);
	}

	public static String getDbKey() {
		return (String) dbHolder.get();
	}

	public static void clearDbKey() {
		dbHolder.remove();
	}

	public static void setTableIndex(String tableIndex) {
		tableIndexHolder.set(tableIndex);
	}

	public static String getTableIndex() {
		return tableIndexHolder.get();
	}

	public static void clearTableIndex() {
		tableIndexHolder.remove();
	}


}
