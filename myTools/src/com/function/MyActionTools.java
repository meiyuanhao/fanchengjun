package com.function;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import jrockit.io.FileUtils;

import com.common.FileSorter;
import com.common.FileUtil;
import com.common.HtmlToWord;
import com.common.LoadParameter;
import com.common.MSExcelManager;
import com.common.MSWordManager;
import com.common.Pinyin4j;
import com.db.DBConnectionManager;
import com.db.DBHelp;
import com.jacob.com.Dispatch;
import com.service.webservice.DataInterface;
import com.vo.Expert;

public class MyActionTools {
	/**
	 * 审签表操作
	 */
	public static void CheckTable(){
		String sql_one = "" +
		"Select id," +
				"title," +
				"content," +
				"publish_time," +
				"info_source " +
		"from TB_INFO_PUB_CONTENT WHERE id in ('9f90816c49110f41014916b1c6d7085d')";
		String sql_qujian = "" +
		"Select tbinfopubc0_.id,"+
		"       tbinfopubc0_.title,"+
		"       tbinfopubc0_.content,"+
		"       tbinfopubc0_.publish_time,"+
		"       tbinfopubc0_.info_source"+
		"  from SSOADMIN.TB_INFO_PUB_CONTENT tbinfopubc0_ "+
		"where ((tbinfopubc0_.SEND_TO != '2') and (tbinfopubc0_.SEND_TO != '3'))"+
		"   and (tbinfopubc0_.publish_time >= to_date('2014-10-16 00:00:00', 'yyyy-MM-dd hh24:mi:ss') and tbinfopubc0_.publish_time <= to_date('2014-10-16 23:59:59', 'yyyy-MM-dd hh24:mi:ss'))"+
		"   and ((tbinfopubc0_.INFO_SUBJECT in"+
		"       (select ipc.id"+
		"            From Tb_Info_Pub_Cla ipc"+
		"           start with id in ('9f90831b1d086cc4011d093cd70b0157',"+
		"                             '9f90816e2162019f012162193db20007')"+
		"          connect By prior ipc.id = ipc.parentid)))"+
		" order by Tbinfopubc0_.publish_time";
		String sql_full = ""+
		"Select tbinfopubc0_.id,"+
		"       tbinfopubc0_.title,"+
		"       tbinfopubc0_.content,"+
		"       tbinfopubc0_.publish_time,"+
		"       tbinfopubc0_.info_source"+
		"  from SSOADMIN.TB_INFO_PUB_CONTENT tbinfopubc0_ "+
		"where ((tbinfopubc0_.SEND_TO != '2') and (tbinfopubc0_.SEND_TO != '3'))"+
		"   and (tbinfopubc0_.publish_time >= to_date('2014-01-01', 'yyyy-MM-dd'))"+
		"   and ((tbinfopubc0_.INFO_SUBJECT in"+
		"       (select ipc.id"+
		"            From Tb_Info_Pub_Cla ipc"+
		"           start with id in ('9f90831b1d086cc4011d093cd70b0157',"+
		"                             '9f90816e2162019f012162193db20007')"+
		"          connect By prior ipc.id = ipc.parentid)))"+
		" order by Tbinfopubc0_.publish_time";
		LoadParameter lp = new LoadParameter("db");
		String path = lp.getStringValue("ctPath");
		
		//审签表生成
		try {
			CheckTable checkTable = new CheckTable();
			checkTable.makeFile(path,/*sql_qujian*/ sql_one);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//按修改时间升序
		File[] list = new File(path).listFiles();
		Arrays.sort(list, new FileSorter(FileSorter.TYPE_MODIFIED_DATE_DOWN));
		
		for (File file : list) {//打印生成的审签表
			MSWordManager msWordManager = new MSWordManager(true);
			msWordManager.openDocument(file.getPath());
			msWordManager.printFile();
			msWordManager.close();
			
			FileUtil.delete(file.getPath());
		}
	}
	/**
	 * 友情链接有效性检测
	 */
	public static void monitor(){
		String style = "" +
		"<style>" +
		"/* Generator: eWebEditor */" +
		"p.MsoNormal, li.MsoNormal, div.MsoNormal {margin:0cm;margin-bottom:.0001pt;text-align:justify;text-justify:inter-ideograph;font-size:10.5pt;font-family:\"Calibri\",\"sans-serif\";}" +
		"a:link, span.MsoHyperlink {color:blue;text-decoration:underline;text-underline:single;}" +
		"a:visited, span.MsoHyperlinkFollowed {color:purple;text-decoration:underline;text-underline:single;}" +
		".MsoChpDefault {font-family:\"Calibri\",\"sans-serif\";}" +
		"div.WordSection1 {page:WordSection1;}" +
		"</style>";
		DataInterface d = new DataInterface();
		HtmlToWord toWord = new HtmlToWord();
		toWord.writeWordFile("d://", "友情链接检测结果", "<html>" + style + d.ericUrl() + "</html>");
	}
	public static void main ( String[] args ){
        MyActionTools.CheckTable();
    }
}
