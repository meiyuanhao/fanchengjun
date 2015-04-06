package com.db;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * 管理类 DBConnectionManager 支持对一个或多个由属性文件定义的数据库 连接池的访问.客户程序可以调用
 * getInstance()方法访问本类的唯一实例. 也允许不通过属性文件，而是显示通过方法 newPool() 来建立连接池。 目前，新增加了 LOG
 * 文件记录功能
 */

public class DBConnectionManager {
	private static DBConnectionManager instance; // 唯一实例
	private PrintWriter log; // LOG 记录文件
	private boolean isShowSQL = true;
	private Properties dbProps = new Properties();

	/**
	 * 返回唯一实例.如果是第一次调用此方法,则创建实例
	 * 
	 * @return DBConnectionManager 唯一实例
	 */
	public static synchronized DBConnectionManager getInstance() {
		if (instance == null) { // 只创建一次
			instance = new DBConnectionManager();
		}
		return (instance);
	}

	/**
	 * 构造函数私有以防止其它对象创建本类实例
	 */
	private DBConnectionManager() {
		init();
	}

	/**
	 * 将连接对象返回给由名字指定的连接池
	 * 
	 * @param name 在属性文件中定义的连接池名字
	 * @param con 连接对象
	 */
	public void freeConnection(String name, Connection con) {
		try {
			con.close();
			log(name + "关闭一个新的连接");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log(name + "关闭连接异常");
		}
	}

	/**
	 * 获得一个可用的连接.
	 * 
	 * @param name 在属性文件中定义的连接池名字
	 * @return Connection 可用连接或null
	 */
	public Connection getConnection(String name) {
		Connection con = null;
		String url = null;
		String user = null;
		String password = null;
		try {
			url = dbProps.getProperty(name + ".url");
			user = dbProps.getProperty(name + ".user");
			password = dbProps.getProperty(name + ".password");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			if (user == null) {
				con = DriverManager.getConnection(url);
			} else {
				con = DriverManager.getConnection(url, user, password);
			}
			if (isShowSQL) {
				log(name + "创建一个新的连接");
			}
		} catch (SQLException e) {
			System.out.print(e);
			if (isShowSQL) {
				log(name + "创建一个新的连接失败");
			}
			return null;
		}
		return con;
	}

	/**
	 * 读取属性完成初始化
	 */
	private void init() {
		InputStream is = getClass().getResourceAsStream("/db.properties");
		try {
			dbProps.load(is);
		} catch (Exception e) {
			System.err.println("不能读取属性文件. " + "请确保db.properties在CLASSPATH指定的路径中");
			return;
		}
		String logFile = dbProps.getProperty("logfile", "DBConnectionManager.log");
		try {
			log = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			System.err.println("无法打开日志文件: " + logFile);
			log = new PrintWriter(System.err);
		}
		loadDrivers(dbProps);
	}

	/**
	 * 装载和注册所有JDBC驱动程序
	 * 
	 * @param props 属性
	 */
	private void loadDrivers(Properties props) {
		String driverClasses = props.getProperty("drivers");
		StringTokenizer st = new StringTokenizer(driverClasses);
		while (st.hasMoreElements()) {
			String driverClassName = st.nextToken().trim();
			try {
				Class.forName(driverClassName);
				if (isShowSQL) {
					log("成功注册JDBC驱动程序" + driverClassName);
				}
			} catch (Exception e) {
				if (isShowSQL) {
					log("无法注册JDBC驱动程序: " + driverClassName + ", 错误: " + e);
				}
			}
		}

	}

	/**
	 * 将文本信息写入日志文件
	 */
	private void log(String msg) {
		log.println(new Date() + ": " + msg);
	}

	/**
	 * 将文本信息与异常写入日志文件
	 */
	private void log(Throwable e, String msg) {
		log.println(new Date() + ": " + msg);
		e.printStackTrace(log);
	}

}
