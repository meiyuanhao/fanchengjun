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
	 * ��ʼ����ר���˻���Ϣ
	 */
	public static void excel() {
		MSExcelManager excelManager = new MSExcelManager();
		excelManager
				.OpenExcel(
						"E:\\MyFolder\\ˮ���ĵ�\\�Ƽ�����Ϣ������ƽ̨\\����\\ר������\\2014-0916ˮ������Э��ר�һ��ܱ���.xls",
						true, false);
		Dispatch dispatch = excelManager.getSheetByIndex(1);
		String name = "";
		for (int i = 2; i <= 363; i++) {
			name = excelManager.getValue("B" + i, dispatch).toString();
			String up = Pinyin4j
					.makeStringByStringSet(Pinyin4j.getPinyin(name));
			excelManager.setValue(dispatch, "F" + i, "value", up + "/" + up
					+ "123");// �˻���Ϣ
		}
		excelManager.CloseExcel(true, true);
	}

	/**
	 * ר���˻���Ϣ�Զ�ע��
	 */
	public static void account() {
		MSExcelManager excelManager = new MSExcelManager();
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		excelManager.OpenExcel("D:\\�հ�ר���˻���Ϣ.xlsx", true,false);
		Dispatch dispatch = excelManager.getSheetByIndex(13);
		String name = "";
		// String up = "";
		// String username = "";
		// String password = "";
		try {// 74 95
			String sql = "";
			int count = 0;
			for (int i = 1; i <= 154; i++) {
				name = excelManager.getValue("A" + i, dispatch).toString();// ��ȡ�û�����
				// up = excelManager.getValue("F" + i,
				// dispatch).toString();//��ȡ���ɵ��û���������
				// username = excelManager.getValue("C" + i,
				// dispatch).toString();//��ȡ���ɵ��û���������
				// password = excelManager.getValue("D" + i,
				// dispatch).toString();//��ȡ���ɵ��û���������
				if (!"null".equals(name.trim())) {// �����ȡ���û������Ļ�
					// String args[] = up.trim().split("/");//���û����������ֿ�
					sql = "SELECT COUNT(*) FROM T_EXPERT_INFO WHERE name='" + name.trim() + "'";
					count = DBHelp.count(sql, "shwater");
					if (count > 0) {// ���ר����Ϣ���ڵĻ�����鿴���������˻���Ϣ
						sql = "SELECT distinct tu.Id,tu.usertype,tu.username,tu.password FROM T_EXPERT_INFO TEI,T_USER TU WHERE tei.userid = tu.id and name='"
								+ name.trim() + "'";
						connection = DBHelp.getConnection("shwater");
						statement = connection.createStatement();
						resultSet = statement.executeQuery(sql);
						if (resultSet.next()) {// ���ר�ҵĹ����˻����ڵĻ�
							//int tempId = resultSet.getInt("id");
							int tempUsertype = resultSet.getInt("usertype");
							if (tempUsertype == 0) {// ����������˻�Ϊ��λ�˻��Ļ��������ע��һ�������˻�������
								regUser(i, excelManager, dispatch);
							} else {
								// �����еĸ����˻�д��Excel
								excelManager.setValue(dispatch, "C" + i,"value", resultSet.getString("username"));
								excelManager.setValue(dispatch, "D" + i,"value", resultSet.getString("password"));
							}
						} else {// ���ר�ҵĹ����˻������ڵĻ��������ע��һ�������˻�������
							regUser(i, excelManager, dispatch);
						}
						DBHelp.closeConnection(resultSet, statement,preparedStatement, connection);
					} else {// ���ר����Ϣ�����ڵĻ���ֱ��ע��һ���˻�
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
		
		name = excelManager.getValue("A" + row_num, dispatch).toString();// ��ȡ�û�����
		username = excelManager.getValue("C" + row_num, dispatch).toString();// ��ȡ���ɵ��û���������
		password = excelManager.getValue("D" + row_num, dispatch).toString();// ��ȡ���ɵ��û���������
		
		temp_username = username;
		temp_password = password;
		// д��ר����Ϣ
		boolean isYes = false;
		do {
			// �˴�Ҫ�жϵ�ǰ���˻���Ϣ�Ƿ����
			sql = "select count(username) from t_user tu where username = '" + temp_username + "' and password = '" + temp_password + "'";
			int tu = DBHelp.count(sql, "shwater");
			if (tu > 0) {//������ڣ�������������
				isYes = true;
				String rcu = getRandomCharAndNumr(2).toLowerCase();
				// ����������벢д�ص������
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
					System.out.print(name.trim() + "�˻���Ϣ���ɳɹ���");
				}
				sql = "update t_expert_info set userid='" + id + "' where name = '" + name.trim() + "'";
				int tei_u = DBHelp.executeUpdate(sql, "shwater");
				if (tei_u > 0) {
					System.out.println(name.trim() + "�˻���Ϣ�����ɹ���");
				}
			}
		} while (isYes);
	}

	/**
	 * �հ��˻���Ϣ����
	 */
	public static void excelEquals() {
		MSExcelManager excelManager = new MSExcelManager();
		excelManager
				.OpenExcel(
						"E:\\MyFolder\\ˮ���ĵ�\\�Ƽ�����Ϣ������ƽ̨\\����\\ר������\\2014-0916ˮ������Э��ר�һ��ܱ���.xls",
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
	 * �˻���Ч����֤
	 */
	public static void accountValidate() {
		MSExcelManager excelManager = new MSExcelManager();
		excelManager.OpenExcel("D:\\ר������\\NEW\\�к���Э��-�Ƽ�������ר�ҿ�������.xlsx", true,
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
							+ "/" + password + "  �˻���Ϣ��Ч��");
				}
			}
			excelManager.CloseExcel(true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ר����Ϣ�ظ�����֤
	 */
	public static void repetitiveValidate() {
		List<String> hy = new ArrayList<String>();
		List<String> ps = new ArrayList<String>();
		List<String> js = new ArrayList<String>();
		List<String> gs = new ArrayList<String>();
		List<String> all = new ArrayList<String>();
		MSExcelManager excelManager = new MSExcelManager();
		excelManager.OpenExcel("D:\\����ר����Ϣ�����.xlsx", true, false);
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
						"��");
			} else {
				excelManager.setValue(dispatch_write, "F" + (i + 3), "value",
						"��");
			}
			for (String name_hy : hy) {
				if (all_name.equals(name_hy)) {
					excelManager.setValue(dispatch_write, "B" + (i + 3),
							"value", "��");
					break;
				}
			}
			for (String name_ps : ps) {
				if (all_name.equals(name_ps)) {
					excelManager.setValue(dispatch_write, "C" + (i + 3),
							"value", "��");
					break;
				}
			}
			for (String name_js : js) {
				if (all_name.equals(name_js)) {
					excelManager.setValue(dispatch_write, "D" + (i + 3),
							"value", "��");
					break;
				}
			}
			for (String name_gs : gs) {
				if (all_name.equals(name_gs)) {
					excelManager.setValue(dispatch_write, "E" + (i + 3),
							"value", "��");
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
		 * if(es.size() > 0){ // JAVA����ת����JSONֵ try { JSONValue jsonValue =
		 * JSONMapper.toJSON(es); String jsonStr = jsonValue.render(false); //
		 * �Ƿ��ʽ�� System.out.println(jsonStr); } catch (MapperException e) {
		 * e.printStackTrace(); } }
		 */
	}

	/**
	 * ��ȡ�����ĸ�������
	 * 
	 * @param length
	 *            �ַ�������
	 * @return
	 */
	private static String getRandomCharAndNumr(Integer length) {
		String str = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			boolean b = random.nextBoolean();
			if (b) { // �ַ���
				// int choice = random.nextBoolean() ? 65 : 97; ȡ��65��д��ĸ����97Сд��ĸ
				str += (char) (65 + random.nextInt(26));// ȡ�ô�д��ĸ
			} else { // ����
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
        	   "       '��'"+
        	   "      else"+
        	   "       'Ů'"+
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
        excelManager.OpenExcel("D:\\Э����Ҫ��ר������.xlsx", true, false);
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
                        codeChinese += codeTable.getCodeChinese().toString() + "��";
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
