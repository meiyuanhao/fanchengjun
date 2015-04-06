package com.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.sql.CLOB;

import com.sun.rowset.CachedRowSetImpl;

public class DBHelp {
	/**
	 * 数据库连接
	 */
	public static Connection connection = null;
	/**
	 * SQL命令执行器
	 */
	public static Statement statement = null;
	/**
	 * 可带参SQL命令执行器
	 */
	public static PreparedStatement preparedStatement = null;
	/**
	 * 结果集
	 */
	public static ResultSet resultSet = null;
	/**
	 * 离线结果集 
	 * com.sun.rowset.CachedRowSetImpl
	 */
	public static CachedRowSetImpl cachedRowSetImpl = null;
	/**
	 * 公共查询方法，默认实现离线结果集
	 * 
	 * @param sql
	 *            查询语句
	 * @param dataSourceName
	 *            数据源名称
	 * @return com.sun.rowset.CachedRowSetImpl
	 */
	public static CachedRowSetImpl query(String sql, String dataSourceName) {
		CachedRowSetImpl rowset = null;
		try {
			connection = getConnection(dataSourceName);
			statement = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery(sql);
			rowset = new CachedRowSetImpl();// 实例离线结果集
			rowset.populate(resultSet); // 填充离线结果集
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet, statement, null, connection);
		}
		return rowset;
	}

	/**
	 * @category   执行插入，删除，更改操作
	 * @param      sql  要执行的SQL语句
	 * @param      dataSourceName  数据源名称
	 * @return     返回影响行数<br/>       
	 */
	public static int executeUpdate(String sql, String dataSourceName) {
		int i = 0;
		try {
			connection = getConnection(dataSourceName);
			statement = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			i = statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(null, statement, null, connection);
		}
		return i;
	}
	/**
	 * 执行行数统计语句，返回行数
	 * @param sql
	 * @param dataSourceName
	 * @return
	 */
	public static int count(String sql, String dataSourceName){
		int i = 0;
		try {
			connection = getConnection(dataSourceName);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if(resultSet.next()){
				i = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(resultSet, statement, null, connection);
		}
		return i;
	}
	/**
     * 查询并返回int型
     * 
     * @param strSQL,connName
     * @return int
     */
    public static int getInt ( String strSQL,String connName ){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;

        try {
            conn = getConnection(connName);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(strSQL);
            if ( rs.next() ) {
                count = rs.getInt(1);
            }
        } catch ( Exception ex ) {
            ex.printStackTrace();
        } finally {
            if ( rs != null ) {
                try {
                    rs.close();
                } catch ( SQLException e ) {
                    e.printStackTrace();
                }
            }
            if ( stmt != null ) {
                try {
                    stmt.close();
                } catch ( SQLException e ) {
                    e.printStackTrace();
                }
            }
            if ( conn != null ) {
                try {
                    conn.close();
                } catch ( SQLException e ) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }
	/**
	 * 获取数据库连接
	 * 
	 * @param dataSourceName
	 *            数据源名称
	 * @return 数据库连接
	 */
	public static Connection getConnection(String dataSourceName) {
		DBConnectionManager connectionManager = DBConnectionManager
				.getInstance();
		return connectionManager.getConnection(dataSourceName);
	}

	/**
	 * 数据库资源释放
	 * 
	 * @param resultSet
	 *            结果集
	 * @param statement
	 *            执行器
	 * @param preparedStatement
	 *            高级执行器
	 * @param connection
	 *            数据库连接
	 */
	public static void closeConnection(ResultSet resultSet,
			Statement statement, PreparedStatement preparedStatement,
			Connection connection) {
		try {
			if (resultSet != null) {
				resultSet.close();
				resultSet = null;
			}
			if (statement != null) {
				statement.close();
				statement = null;
			}
			if (preparedStatement != null) {
				preparedStatement.close();
				preparedStatement = null;
			}
			if (connection != null) {
				connection.close();
				connection = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据提供的序列名调用其函数[sequences].NEXTVAL 并返回其值
	 * 
	 * @param sequencesName
	 *            序列名称
	 * @return 当前序列所在的值
	 */
	public static String getIDValue(String sequencesName, String dataSourceName) {
		Connection conn = null;
		Statement state = null;
		ResultSet reSet = null;
		try {
			conn = getConnection(dataSourceName);
			state = conn.createStatement();
			reSet = state.executeQuery("SELECT " + sequencesName + ".NEXTVAL FILEID FROM DUAL");
			if (reSet.next()) {
				return reSet.getString("FILEID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(reSet, state, null,conn);
		}
		return null;
	}
	/**
	 * 将CLOB转成STRING类型
	 * 
	 * @param clob
	 *            要处理的字段
	 * @return 转换后的字段
	 * @throws SQLException
	 * @throws IOException
	 */
	public static String ClobToString(CLOB clob) throws SQLException,
			IOException {
		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}
}
