package com.service.webservice;

import com.service.MonitorService;
import com.vo.MonitorUrl;

public class DataInterface {
	/**
	 * 返回访问URL的信息，以XML形式
	 * @return
	 */
	public String ericUrl(){
		StringBuffer strXml=new StringBuffer();
		
		strXml.append("<div align=center>");
		strXml.append("<table class=MsoTableGrid style=\"BORDER-TOP: medium none; BORDER-RIGHT: medium none; BORDER-COLLAPSE: collapse; BORDER-BOTTOM: medium none; BORDER-LEFT: medium none\" cellSpacing=0 cellPadding=0 border=1>");
		strXml.append("<tbody>");
		
		MonitorService ms = new MonitorService();
		MonitorUrl mu = new MonitorUrl();
		System.out.println("************************国内水利部门************************");
		strXml.append("<tr>");
		strXml.append("<td style=\"BORDER-TOP: windowtext 1pt solid; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>");
		strXml.append("<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><b><span style=\"FONT-FAMILY: 宋体\">国内水利部门</span></b></p>");
		strXml.append("</td>");
		strXml.append("</tr>");
		strXml.append(ms.ping(mu.getGuoneishuilibumen()));
		
		System.out.println("************************国内海洋系统************************");
		strXml.append("<tr>");
		strXml.append("<td style=\"BORDER-TOP: windowtext 1pt solid; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>");
		strXml.append("<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><b><span style=\"FONT-FAMILY: 宋体\">国内海洋系统</span></b></p>");
		strXml.append("</td>");
		strXml.append("</tr>");
		strXml.append(ms.ping(mu.getGuoneihaiyangxitong()));
		
		System.out.println("**************************局属单位**************************");
		strXml.append("<tr>");
		strXml.append("<td style=\"BORDER-TOP: windowtext 1pt solid; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>");
		strXml.append("<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><b><span style=\"FONT-FAMILY: 宋体\">局属单位</span></b></p>");
		strXml.append("</td>");
		strXml.append("</tr>");
		strXml.append(ms.ping(mu.getJushudanwei()));
		
		System.out.println("**************************区县水务**************************");
		strXml.append("<tr>");
		strXml.append("<td style=\"BORDER-TOP: windowtext 1pt solid; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>");
		strXml.append("<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><b><span style=\"FONT-FAMILY: 宋体\">区县水务</span></b></p>");
		strXml.append("</td>");
		strXml.append("</tr>");
		strXml.append(ms.ping(mu.getQuxianshuiwu()));
		
		System.out.println("************************本市相关部门************************");
		strXml.append("<tr>");
		strXml.append("<td style=\"BORDER-TOP: windowtext 1pt solid; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>");
		strXml.append("<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><b><span style=\"FONT-FAMILY: 宋体\">本市相关部门</span></b></p>");
		strXml.append("</td>");
		strXml.append("</tr>");
		strXml.append(ms.ping(mu.getBenshixiangguanbumen()));
		strXml.append("</tr>");
		strXml.append("</tbody>");
		strXml.append("</table>");
		strXml.append("</div>");
		return strXml.toString();
	}
	
	public static void main(String[] args) {
		DataInterface d = new DataInterface();
		System.out.println(d.ericUrl());
	}
}
