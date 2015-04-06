package com.function;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnectionManager;
import com.vo.TB_ZFXXGKSQBCCL_Vo;

public class TB_ZFXXGKSQBCCL {

	public static void main(String[] args) {
		List<TB_ZFXXGKSQBCCL_Vo> list = new ArrayList<TB_ZFXXGKSQBCCL_Vo>();
		DBConnectionManager db = DBConnectionManager.getInstance();
		java.sql.Connection conn = null;
		java.sql.Statement stat = null;
		java.sql.ResultSet rs = null;
		try {
			conn = db.getConnection("shwater");
			stat = conn.createStatement();
		    rs = stat.executeQuery("SELECT * FROM TB_ZFXXGKSQBCCL");
		    while (rs.next()) {
		    	TB_ZFXXGKSQBCCL_Vo vo = new TB_ZFXXGKSQBCCL_Vo();
		    	vo.setTid(rs.getString("tid"));
		    	vo.setInfo_id(rs.getString("info_id"));
		    	vo.setLs_no(rs.getString("ls_no"));
		    	vo.setApplicant(rs.getString("applicant"));
		    	vo.setAttr1(rs.getString("attr1"));
		    	vo.setAttr2(rs.getString("attr2"));
		    	vo.setBc_time(rs.getString("bc_time"));
		    	vo.setDf_time(rs.getString("df_time"));
		    	
		    	list.add(vo);//·â×°µ½ListÖÐ
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (stat != null) {
					stat.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(list.size());
	}
	
}
