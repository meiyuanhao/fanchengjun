package com.function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.common.MSExcelManager;
import com.common.Pinyin4j;
import com.db.DBConnectionManager;
import com.db.DBHelp;
import com.jacob.com.Dispatch;
import com.vo.Code;
import com.vo.Expert;

public class ExpertInfoHandle {
	/**
	 * 初始生成专家账户信息
	 */
	public static void excel() {
		MSExcelManager excelManager = new MSExcelManager();
		excelManager
				.OpenExcel(
						"E:\\MyFolder\\水务文档\\科技与信息化服务平台\\四期\\专家名单\\2014-0916水利工程协会专家汇总表定稿.xls",
						true, false);
		Dispatch dispatch = excelManager.getSheetByIndex(1);
		String name = "";
		for (int i = 2; i <= 363; i++) {
			name = excelManager.getValue("B" + i, dispatch).toString();
			String up = Pinyin4j
					.makeStringByStringSet(Pinyin4j.getPinyin(name));
			excelManager.setValue(dispatch, "F" + i, "value", up + "/" + up
					+ "123");// 账户信息
		}
		excelManager.CloseExcel(true, true);
	}

	/**
	 * 专家账户信息自动注册
	 */
	public static void account() {
		MSExcelManager excelManager = new MSExcelManager();
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		excelManager.OpenExcel("D:\\终板专家账户信息.xlsx", true,false);
		Dispatch dispatch = excelManager.getSheetByIndex(13);
		String name = "";
		// String up = "";
		// String username = "";
		// String password = "";
		try {// 74 95
			String sql = "";
			int count = 0;
			for (int i = 1; i <= 154; i++) {
				name = excelManager.getValue("A" + i, dispatch).toString();// 读取用户姓名
				// up = excelManager.getValue("F" + i,
				// dispatch).toString();//读取生成的用户名和密码
				// username = excelManager.getValue("C" + i,
				// dispatch).toString();//读取生成的用户名和密码
				// password = excelManager.getValue("D" + i,
				// dispatch).toString();//读取生成的用户名和密码
				if (!"null".equals(name.trim())) {// 如果读取到用户姓名的话
					// String args[] = up.trim().split("/");//把用户名和密码拆分开
					sql = "SELECT COUNT(*) FROM T_EXPERT_INFO WHERE name='" + name.trim() + "'";
					count = DBHelp.count(sql, "shwater");
					if (count > 0) {// 如果专家信息存在的话，则查看他关联的账户信息
						sql = "SELECT distinct tu.Id,tu.usertype,tu.username,tu.password FROM T_EXPERT_INFO TEI,T_USER TU WHERE tei.userid = tu.id and name='"
								+ name.trim() + "'";
						connection = DBHelp.getConnection("shwater");
						statement = connection.createStatement();
						resultSet = statement.executeQuery(sql);
						if (resultSet.next()) {// 如果专家的关联账户存在的话
							//int tempId = resultSet.getInt("id");
							int tempUsertype = resultSet.getInt("usertype");
							if (tempUsertype == 0) {// 如果关联的账户为单位账户的话，则给他注册一个个人账户并关联
								regUser(i, excelManager, dispatch);
							} else {
								// 把现有的个人账户写回Excel
								excelManager.setValue(dispatch, "C" + i,"value", resultSet.getString("username"));
								excelManager.setValue(dispatch, "D" + i,"value", resultSet.getString("password"));
							}
						} else {// 如果专家的关联账户不存在的话，则给他注册一个个人账户并关联
							regUser(i, excelManager, dispatch);
						}
						DBHelp.closeConnection(resultSet, statement,preparedStatement, connection);
					} else {// 如果专家信息不存在的话，直接注册一个账户
						regUser(i, excelManager, dispatch);
					}
				}
			}
			excelManager.CloseExcel(true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void regUser(int row_num, MSExcelManager excelManager,Dispatch dispatch) {
		String sql = "";
		String name = "";
		String username = "";
		String password = "";
		
		String temp_username = "";
		String temp_password = "";
		
		name = excelManager.getValue("A" + row_num, dispatch).toString();// 读取用户姓名
		username = excelManager.getValue("C" + row_num, dispatch).toString();// 读取生成的用户名和密码
		password = excelManager.getValue("D" + row_num, dispatch).toString();// 读取生成的用户名和密码
		
		temp_username = username;
		temp_password = password;
		// 写入专家信息
		boolean isYes = false;
		do {
			// 此处要判断当前的账户信息是否存在
			sql = "select count(username) from t_user tu where username = '" + temp_username + "' and password = '" + temp_password + "'";
			int tu = DBHelp.count(sql, "shwater");
			if (tu > 0) {//如果存在，则加入随机代码
				isYes = true;
				String rcu = getRandomCharAndNumr(2).toLowerCase();
				// 加入随机代码并写回到表格中
				temp_username = username + rcu;
				temp_password = username + rcu + "123";
			} else {
				isYes = false;
				String id = DBHelp.getIDValue("SEQ_T_USER_ID", "shwater");
				sql = "INSERT INTO T_User(id,username,password,userType,isEnable) VALUES(" + id + ",'" + temp_username + "','" +temp_password + "',1,0)";
				int reg = DBHelp.executeUpdate(sql, "shwater");
				if (reg > 0) {
					excelManager.setValue(dispatch, "C" + row_num, "value", temp_username);
					excelManager.setValue(dispatch, "D" + row_num, "value", temp_password);
					System.out.print(name.trim() + "账户信息生成成功。");
				}
				sql = "update t_expert_info set userid='" + id + "' where name = '" + name.trim() + "'";
				int tei_u = DBHelp.executeUpdate(sql, "shwater");
				if (tei_u > 0) {
					System.out.println(name.trim() + "账户信息关联成功。");
				}
			}
		} while (isYes);
	}

	/**
	 * 终板账户信息生成
	 */
	public static void excelEquals() {
		MSExcelManager excelManager = new MSExcelManager();
		excelManager
				.OpenExcel(
						"E:\\MyFolder\\水务文档\\科技与信息化服务平台\\四期\\专家名单\\2014-0916水利工程协会专家汇总表定稿.xls",
						true, false);
		Dispatch dispatch = excelManager.getSheetByIndex(1);
		String up = "";
		try {
			for (int i = 2; i <= 363; i++) {
				up = excelManager.getValue("F" + i, dispatch).toString();
				String args[] = up.split("/");
				excelManager.setValue(dispatch, "G" + i, "value", args[0]);
				excelManager.setValue(dispatch, "H" + i, "value", args[1]);
			}
			excelManager.CloseExcel(true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 账户有效性验证
	 */
	public static void accountValidate() {
		MSExcelManager excelManager = new MSExcelManager();
		excelManager.OpenExcel("D:\\专家名单\\NEW\\市海洋协会-科技奖评审专家库名单拟.xlsx", true,
				false);
		Dispatch dispatch = excelManager.getSheetByIndex(1);
		String name = "";
		String username = "";
		String password = "";
		try {
			for (int i = 2; i <= 75; i++) {
				name = excelManager.getValue("B" + i, dispatch).toString();
				username = excelManager.getValue("D" + i, dispatch).toString();
				password = excelManager.getValue("E" + i, dispatch).toString();
				String sql = "select count(username) from t_user tu where username = '"
						+ username + "' and password = '" + password + "'";
				int up = DBHelp.count(sql, "shwater");
				if (up > 0) {
					System.out.println(i - 1 + "  " + name + "  " + username
							+ "/" + password + "  账户信息有效。");
				}
			}
			excelManager.CloseExcel(true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 专家信息重复性验证
	 */
	public static void repetitiveValidate() {
		List<String> hy = new ArrayList<String>();
		List<String> ps = new ArrayList<String>();
		List<String> js = new ArrayList<String>();
		List<String> gs = new ArrayList<String>();
		List<String> all = new ArrayList<String>();
		MSExcelManager excelManager = new MSExcelManager();
		excelManager.OpenExcel("D:\\副本专家信息梳理表.xlsx", true, false);
		Dispatch dispatch_hy = excelManager.getSheetByIndex(2);
		Dispatch dispatch_ps = excelManager.getSheetByIndex(3);
		Dispatch dispatch_js = excelManager.getSheetByIndex(4);
		Dispatch dispatch_gs = excelManager.getSheetByIndex(5);
		Dispatch dispatch_all = excelManager.getSheetByIndex(7);
		Dispatch dispatch_write = excelManager.getSheetByIndex(8);
		for (int i = 2; i <= 75; i++) {
			hy.add(excelManager.getValue("B" + i, dispatch_hy).toString());
		}
		for (int i = 2; i <= 96; i++) {
			ps.add(excelManager.getValue("B" + i, dispatch_ps).toString());
		}
		for (int i = 2; i <= 100; i++) {
			js.add(excelManager.getValue("B" + i, dispatch_js).toString());
		}
		for (int i = 2; i <= 81; i++) {
			gs.add(excelManager.getValue("B" + i, dispatch_gs).toString());
		}
		for (int i = 1; i <= 248; i++) {
			all.add(excelManager.getValue("A" + i, dispatch_all).toString());
		}
		for (int i = 0; i < all.size(); i++) {
			String all_name = all.get(i);
			excelManager.setValue(dispatch_write, "A" + (i + 3), "value",
					all_name);
			String sql = "select count(name) from t_expert_info where name = '"
					+ all_name.trim() + "'";
			int tei = DBHelp.count(sql, "shwater");
			if (tei > 0) {
				excelManager.setValue(dispatch_write, "F" + (i + 3), "value",
						"是");
			} else {
				excelManager.setValue(dispatch_write, "F" + (i + 3), "value",
						"否");
			}
			for (String name_hy : hy) {
				if (all_name.equals(name_hy)) {
					excelManager.setValue(dispatch_write, "B" + (i + 3),
							"value", "√");
					break;
				}
			}
			for (String name_ps : ps) {
				if (all_name.equals(name_ps)) {
					excelManager.setValue(dispatch_write, "C" + (i + 3),
							"value", "√");
					break;
				}
			}
			for (String name_js : js) {
				if (all_name.equals(name_js)) {
					excelManager.setValue(dispatch_write, "D" + (i + 3),
							"value", "√");
					break;
				}
			}
			for (String name_gs : gs) {
				if (all_name.equals(name_gs)) {
					excelManager.setValue(dispatch_write, "E" + (i + 3),
							"value", "√");
					break;
				}
			}
		}
		excelManager.CloseExcel(true, true);
	}

	public static void getExperts() {
		DBConnectionManager db = DBConnectionManager.getInstance();
		Connection connection = db.getConnection("shwater");
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "select distinct name,gender,pid,workunit,mobile,email,industry,experttype from t_expert_info";
		List<Expert> es = new ArrayList<Expert>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Expert e = new Expert();
				e.setName(resultSet.getString("name"));
				e.setGender(resultSet.getString("gender"));
				e.setPid(resultSet.getString("pid"));
				e.setWorkunit(resultSet.getString("workunit"));
				e.setMobile(resultSet.getString("mobile"));
				e.setEmail(resultSet.getString("email"));
				e.setIndustry(resultSet.getString("industry"));
				e.setExperttype(resultSet.getString("experttype"));
				e.setUsername("mob" + e.getMobile());
				e.setPassword("exp123");
				es.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelp.closeConnection(resultSet, statement, null, connection);
		}
		/*
		 * if(es.size() > 0){ // JAVA对象转换成JSON值 try { JSONValue jsonValue =
		 * JSONMapper.toJSON(es); String jsonStr = jsonValue.render(false); //
		 * 是否格式化 System.out.println(jsonStr); } catch (MapperException e) {
		 * e.printStackTrace(); } }
		 */
	}

	/**
	 * 获取随机字母数字组合
	 * 
	 * @param length
	 *            字符串长度
	 * @return
	 */
	private static String getRandomCharAndNumr(Integer length) {
		String str = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			boolean b = random.nextBoolean();
			if (b) { // 字符串
				// int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
				str += (char) (65 + random.nextInt(26));// 取得大写字母
			} else { // 数字
				str += String.valueOf(random.nextInt(10));
			}
		}
		return str;
	}
	
	public static void expExpert(){
	    String sql = "SELECT * FROM T_CODE WHERE dh = '04' AND codeValue != '-'";
	    DBConnectionManager db = DBConnectionManager.getInstance();
        Connection connection = db.getConnection("shwater");
        Statement statement = null;
        ResultSet resultSet = null;
        List<Code> codeList = new ArrayList<Code>();
        List<Expert> es = new ArrayList<Expert>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while ( resultSet.next() ) {
                Code code = new Code();
                code.setId(resultSet.getString("id"));
                code.setCodeValue(resultSet.getString("codeValue"));
                code.setCodeChinese(resultSet.getString("CODECHINESE"));
                codeList.add(code);
            }
            
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            DBHelp.closeConnection(resultSet, statement, null, connection);
        }
        
        sql = "select name,"+
        	   "    case"+
        	   "      when gender = '0' then"+
        	   "       '男'"+
        	   "      else"+
        	   "       '女'"+
        	   "    end gender,"+
        	   "    workunit,"+
        	    "   mobile,"+
        	   "    email,"+
        	   "    area"+
        	  " from t_expert_info"+
        	 " where industry in ('4', '5')"+
        	 "order by name";
        try {
            connection = db.getConnection("shwater");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while ( resultSet.next() ) {
                Expert e = new Expert();
                e.setName(resultSet.getString("name"));
                e.setGender(resultSet.getString("gender"));
                //e.setPid(resultSet.getString("pid"));
                e.setWorkunit(resultSet.getString("workunit"));
                e.setMobile(resultSet.getString("mobile"));
                e.setEmail(resultSet.getString("email"));
               // e.setIndustry(resultSet.getString("industry"));
               // e.setExperttype(resultSet.getString("experttype"));
                e.setArea(resultSet.getString("area"));
                e.setAreaName(getCodeName(e.getArea(),codeList));
                //e.setUsername("mob" + e.getMobile());
                //e.setPassword("exp123");
                es.add(e);
            }
            System.out.println("");
            
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            DBHelp.closeConnection(resultSet, statement, null, connection);
        }
        MSExcelManager excelManager = new MSExcelManager();
        excelManager.OpenExcel("D:\\协会需要的专家名单.xlsx", true, false);
        Dispatch dispatch = excelManager.getSheetByIndex(4);
        for ( int i = 0 ; i < es.size() ; i++ ) {
            Expert e = es.get(i);
            excelManager.setValue(dispatch, "A" + (i + 2), "value", e.getName());
            excelManager.setValue(dispatch, "B" + (i + 2), "value", e.getGender());
            excelManager.setValue(dispatch, "C" + (i + 2), "value", e.getWorkunit());
            excelManager.setValue(dispatch, "D" + (i + 2), "value", e.getMobile());
            excelManager.setValue(dispatch, "E" + (i + 2), "value", e.getEmail());
            excelManager.setValue(dispatch, "F" + (i + 2), "value", e.getAreaName());
        }
        excelManager.CloseExcel(true, true);
	}
	
	public static String getCodeName(String codeValue,List codeList) {
        String codeChinese = "";
        String codeValues[] = null;
        if(codeValue != null){
            codeValues = codeValue.split(",");
        }
        if (codeValues != null && codeValues.length > 0) {
            for ( String string : codeValues ) {
                Iterator iter = codeList.iterator();
                while (iter.hasNext()) {
                    Code codeTable = (Code) iter.next();
                    if (string.equals(codeTable.getCodeValue())) {
                        codeChinese += codeTable.getCodeChinese().toString() + "，";
                        break;
                    }
                }
            }
            if(!"".equals(codeChinese)){
                codeChinese = codeChinese.substring(0,codeChinese.length() -1);
            }
        }
        return codeChinese;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// excel();
		//account();
		expExpert();
		// excelEquals();
		// accountValidate();
		// repetitiveValidate();
		// getExperts();

	}

}
