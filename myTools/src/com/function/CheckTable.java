package com.function;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import oracle.jdbc.OracleResultSet;

import com.common.HtmlToWord;
import com.db.DBConnectionManager;
import com.db.DBHelp;

/**
 * 上海市水务局（上海市海洋局）政府网站新闻类栏目信息发布审签表操作类
 * @author ChenQiQi
 *
 */
public class CheckTable {
	private String htmltemp1 = "";
	private String htmltemp2 = "";
	private String htmltemp3 = "";
	private String htmltemp4 = "";
	
	private String time = "";
	private String id = "";
	private String title = "";
	private String content = "";
	private String source = "";
	
	private DateFormat dateFormat1 = new SimpleDateFormat("yyyy.M.d");
	public CheckTable(){//初始化审签表模板
		htmltemp1 = "<style>" + 
				"/* Generator: eWebEditor */" +
				"p.MsoNormal, li.MsoNormal, div.MsoNormal {margin:0cm;margin-bottom:.0001pt;text-align:justify;text-justify:inter-ideograph;font-size:10.5pt;font-family:\"Times New Roman\",\"serif\";}" +
				".MsoChpDefault {font-size:10.0pt;}" +
				"div.WordSection1 {page:WordSection1;}" +
				"</style>" +
				"<p class=MsoNormal style=\"TEXT-ALIGN: center; LINE-HEIGHT: 150%\" align=center><b><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: 宋体; LINE-HEIGHT: 150%\">上海市水务局<span>(</span>上海市海洋局<span>)</span></span></b></p>" +
				"<p class=MsoNormal style=\"TEXT-ALIGN: center; LINE-HEIGHT: 150%\" align=center><b><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: 宋体; LINE-HEIGHT: 150%\">政府网站新闻类栏目信息发布审签表</span></b></p>" +
				"<table class=MsoNormalTable style=\"WIDTH: 430.6pt; BORDER-COLLAPSE: collapse\" cellSpacing=0 cellPadding=0 width=574 border=0>" +
				  "<tbody>" +
				    "<tr style=\"HEIGHT: 79.05pt\">" +
				      "<td style=\"BORDER-TOP: windowtext 1pt solid; HEIGHT: 79.05pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 136.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" width=182>" +
				      "<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">信息生产部门</span></p>" +
				      "</td>" +
				      "<td style=\"BORDER-TOP: windowtext 1pt solid; HEIGHT: 79.05pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 331.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" vAlign=top width=442>" +
				      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">部门</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: 宋体\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 仿宋\">局办公室</span></p>" +
				      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">拟稿人（摘录人）</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: 宋体\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 仿宋\">";
		
		htmltemp2 = "</span></p>" +
		      "</td>" +
			    "</tr>" +
			    "<tr style=\"HEIGHT: 77.25pt\">" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 77.25pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 136.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" width=182>" +
			      "<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">信息来源</span></p>" +
			      "</td>" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 77.25pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 331.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" width=442>" +
			      "<p class=MsoNormal><span style='FONT-SIZE: 14pt; FONT-FAMILY: \"Wingdings 2\"'>R</span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">自主编写</span></p>" +
			      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">□摘录（需注明来源）</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: 宋体\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">__________________</span></p>" +
			      "</td>" +
			    "</tr>" +
			    "<tr style=\"HEIGHT: 130.05pt\">" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 130.05pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 136.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" width=182>" +
			      "<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">信息名称</span></p>" +
			      "</td>" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 130.05pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 331.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" vAlign=top width=442>" +
			      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">日期</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: 宋体\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 仿宋\">";
		
		htmltemp3 = "</span></p>" +
		      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">信息名称</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: 宋体\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 仿宋\">";
		
		htmltemp4 = "</span></p>" +
		      "</td>" +
			    "</tr>" +
			    "<tr style=\"HEIGHT: 237.65pt\">" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 237.65pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 136.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" width=182>" +
			      "<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">信息内容</span></p>" +
			      "</td>" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 237.65pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 331.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" vAlign=top width=442>" +
			      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span></span>&nbsp;</p>" +
			      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">见附件</span></p>" +
			      "</td>" +
			    "</tr>" +
			    "<tr style=\"HEIGHT: 83.75pt\">" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 83.75pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 136.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" width=182>" +
			      "<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">局办公室审核</span></p>" +
			      "</td>" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 83.75pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 331.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" width=442>" +
			      "<p class=MsoNormal><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">负责人</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: 宋体\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: 宋体\">_________________</span></p>" +
			      "</td>" +
			    "</tr>" +
			  "</tbody>" +
			"</table>" +
			"<p class=MsoNormal><span></span>&nbsp;</p>";
	}
	/**
	 * 生成审签表和附件<br>
	 * <font style='color:red'>备注：</font><br>
	 *    提供一个SQL语句用来提供数据，语句查询结果字段必须包括主键，主题，内容，发布时间，作者（来源）字段，请使用（id,title,content,publish_time,info_source）来表示。
	 * @param sql
	 */
	public void makeFile(String path,String sql){
		DBConnectionManager db = DBConnectionManager.getInstance();
		Connection connection = db.getConnection("swsjzx");
		Statement statement = null; 
		ResultSet resultSet = null;
		
		HtmlToWord toWord = new HtmlToWord();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getString("id");
				title = resultSet.getString("title");
				time = dateFormat1.format(resultSet.getDate("publish_time"));
				source = resultSet.getString("info_source");
				if(source != null && !"".equals(source)){
					source = source.replaceAll("局办公室", "");
					source = source.replace("(", "");
					source = source.replace(")", "");
				}
				toWord.writeWordFile(path,time + "_" + id + "_ct",htmltemp1 + source + htmltemp2 + time + htmltemp3 + title + htmltemp4);
				try {
					content += "<div style=\"width:100%;font-size:24px;font-weight:bold;text-align:center;\">" + title + "</div><br/><br/>";
					content += (DBHelp.ClobToString(((OracleResultSet)resultSet).getCLOB("content"))) + "<br/><br/><br/><br/>";
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(content != null && !"".equals(content)){
					content = "<html>" + content + "</html>";
					toWord.writeWordFile(path,time + "_" + id + "_nr",content);
					content = "";
				}
				/*
				System.out.println("信息ID：" + id);
				System.out.println("信息名称：" + title);
				System.out.println("发布日期：" + time);
				System.out.println("拟稿人（摘录人）：" + source);
				System.out.println("信息内容：" + content);
				*/
				System.out.println(id + "," + title + "," + time + "," + source);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}