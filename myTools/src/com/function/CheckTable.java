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
 * �Ϻ���ˮ��֣��Ϻ��к���֣�������վ��������Ŀ��Ϣ������ǩ�������
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
	public CheckTable(){//��ʼ����ǩ��ģ��
		htmltemp1 = "<style>" + 
				"/* Generator: eWebEditor */" +
				"p.MsoNormal, li.MsoNormal, div.MsoNormal {margin:0cm;margin-bottom:.0001pt;text-align:justify;text-justify:inter-ideograph;font-size:10.5pt;font-family:\"Times New Roman\",\"serif\";}" +
				".MsoChpDefault {font-size:10.0pt;}" +
				"div.WordSection1 {page:WordSection1;}" +
				"</style>" +
				"<p class=MsoNormal style=\"TEXT-ALIGN: center; LINE-HEIGHT: 150%\" align=center><b><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: ����; LINE-HEIGHT: 150%\">�Ϻ���ˮ���<span>(</span>�Ϻ��к����<span>)</span></span></b></p>" +
				"<p class=MsoNormal style=\"TEXT-ALIGN: center; LINE-HEIGHT: 150%\" align=center><b><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: ����; LINE-HEIGHT: 150%\">������վ��������Ŀ��Ϣ������ǩ��</span></b></p>" +
				"<table class=MsoNormalTable style=\"WIDTH: 430.6pt; BORDER-COLLAPSE: collapse\" cellSpacing=0 cellPadding=0 width=574 border=0>" +
				  "<tbody>" +
				    "<tr style=\"HEIGHT: 79.05pt\">" +
				      "<td style=\"BORDER-TOP: windowtext 1pt solid; HEIGHT: 79.05pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 136.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" width=182>" +
				      "<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">��Ϣ��������</span></p>" +
				      "</td>" +
				      "<td style=\"BORDER-TOP: windowtext 1pt solid; HEIGHT: 79.05pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 331.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" vAlign=top width=442>" +
				      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">����</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: ����\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">�ְ칫��</span></p>" +
				      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">����ˣ�ժ¼�ˣ�</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: ����\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">";
		
		htmltemp2 = "</span></p>" +
		      "</td>" +
			    "</tr>" +
			    "<tr style=\"HEIGHT: 77.25pt\">" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 77.25pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 136.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" width=182>" +
			      "<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">��Ϣ��Դ</span></p>" +
			      "</td>" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 77.25pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 331.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" width=442>" +
			      "<p class=MsoNormal><span style='FONT-SIZE: 14pt; FONT-FAMILY: \"Wingdings 2\"'>R</span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">������д</span></p>" +
			      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">��ժ¼����ע����Դ��</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: ����\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">__________________</span></p>" +
			      "</td>" +
			    "</tr>" +
			    "<tr style=\"HEIGHT: 130.05pt\">" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 130.05pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 136.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" width=182>" +
			      "<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">��Ϣ����</span></p>" +
			      "</td>" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 130.05pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 331.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" vAlign=top width=442>" +
			      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">����</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: ����\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">";
		
		htmltemp3 = "</span></p>" +
		      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">��Ϣ����</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: ����\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">";
		
		htmltemp4 = "</span></p>" +
		      "</td>" +
			    "</tr>" +
			    "<tr style=\"HEIGHT: 237.65pt\">" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 237.65pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 136.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" width=182>" +
			      "<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">��Ϣ����</span></p>" +
			      "</td>" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 237.65pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 331.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" vAlign=top width=442>" +
			      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span></span>&nbsp;</p>" +
			      "<p class=MsoNormal style=\"LINE-HEIGHT: 35pt\"><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">������</span></p>" +
			      "</td>" +
			    "</tr>" +
			    "<tr style=\"HEIGHT: 83.75pt\">" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 83.75pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 136.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" width=182>" +
			      "<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">�ְ칫�����</span></p>" +
			      "</td>" +
			      "<td style=\"BORDER-TOP: medium none; HEIGHT: 83.75pt; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 331.4pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" width=442>" +
			      "<p class=MsoNormal><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">������</span><span style=\"FONT-SIZE: 18pt; FONT-FAMILY: ����\">: </span><span style=\"FONT-SIZE: 14pt; FONT-FAMILY: ����\">_________________</span></p>" +
			      "</td>" +
			    "</tr>" +
			  "</tbody>" +
			"</table>" +
			"<p class=MsoNormal><span></span>&nbsp;</p>";
	}
	/**
	 * ������ǩ��͸���<br>
	 * <font style='color:red'>��ע��</font><br>
	 *    �ṩһ��SQL��������ṩ���ݣ�����ѯ����ֶα���������������⣬���ݣ�����ʱ�䣬���ߣ���Դ���ֶΣ���ʹ�ã�id,title,content,publish_time,info_source������ʾ��
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
					source = source.replaceAll("�ְ칫��", "");
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
				System.out.println("��ϢID��" + id);
				System.out.println("��Ϣ���ƣ�" + title);
				System.out.println("�������ڣ�" + time);
				System.out.println("����ˣ�ժ¼�ˣ���" + source);
				System.out.println("��Ϣ���ݣ�" + content);
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