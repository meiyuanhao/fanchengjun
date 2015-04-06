package com.db;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * ������ DBConnectionManager ֧�ֶ�һ�������������ļ���������ݿ� ���ӳصķ���.�ͻ�������Ե���
 * getInstance()�������ʱ����Ψһʵ��. Ҳ����ͨ�������ļ���������ʾͨ������ newPool() ���������ӳء� Ŀǰ���������� LOG
 * �ļ���¼����
 */

public class DBConnectionManager {
	private static DBConnectionManager instance; // Ψһʵ��
	private PrintWriter log; // LOG ��¼�ļ�
	private boolean isShowSQL = true;
	private Properties dbProps = new Properties();

	/**
	 * ����Ψһʵ��.����ǵ�һ�ε��ô˷���,�򴴽�ʵ��
	 * 
	 * @return DBConnectionManager Ψһʵ��
	 */
	public static synchronized DBConnectionManager getInstance() {
		if (instance == null) { // ֻ����һ��
			instance = new DBConnectionManager();
		}
		return (instance);
	}

	/**
	 * ���캯��˽���Է�ֹ�������󴴽�����ʵ��
	 */
	private DBConnectionManager() {
		init();
	}

	/**
	 * �����Ӷ��󷵻ظ�������ָ�������ӳ�
	 * 
	 * @param name �������ļ��ж�������ӳ�����
	 * @param con ���Ӷ���
	 */
	public void freeConnection(String name, Connection con) {
		try {
			con.close();
			log(name + "�ر�һ���µ�����");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log(name + "�ر������쳣");
		}
	}

	/**
	 * ���һ�����õ�����.
	 * 
	 * @param name �������ļ��ж�������ӳ�����
	 * @return Connection �������ӻ�null
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
				log(name + "����һ���µ�����");
			}
		} catch (SQLException e) {
			System.out.print(e);
			if (isShowSQL) {
				log(name + "����һ���µ�����ʧ��");
			}
			return null;
		}
		return con;
	}

	/**
	 * ��ȡ������ɳ�ʼ��
	 */
	private void init() {
		InputStream is = getClass().getResourceAsStream("/db.properties");
		try {
			dbProps.load(is);
		} catch (Exception e) {
			System.err.println("���ܶ�ȡ�����ļ�. " + "��ȷ��db.properties��CLASSPATHָ����·����");
			return;
		}
		String logFile = dbProps.getProperty("logfile", "DBConnectionManager.log");
		try {
			log = new PrintWriter(new FileWriter(logFile, true), true);
		} catch (IOException e) {
			System.err.println("�޷�����־�ļ�: " + logFile);
			log = new PrintWriter(System.err);
		}
		loadDrivers(dbProps);
	}

	/**
	 * װ�غ�ע������JDBC��������
	 * 
	 * @param props ����
	 */
	private void loadDrivers(Properties props) {
		String driverClasses = props.getProperty("drivers");
		StringTokenizer st = new StringTokenizer(driverClasses);
		while (st.hasMoreElements()) {
			String driverClassName = st.nextToken().trim();
			try {
				Class.forName(driverClassName);
				if (isShowSQL) {
					log("�ɹ�ע��JDBC��������" + driverClassName);
				}
			} catch (Exception e) {
				if (isShowSQL) {
					log("�޷�ע��JDBC��������: " + driverClassName + ", ����: " + e);
				}
			}
		}

	}

	/**
	 * ���ı���Ϣд����־�ļ�
	 */
	private void log(String msg) {
		log.println(new Date() + ": " + msg);
	}

	/**
	 * ���ı���Ϣ���쳣д����־�ļ�
	 */
	private void log(Throwable e, String msg) {
		log.println(new Date() + ": " + msg);
		e.printStackTrace(log);
	}

}
