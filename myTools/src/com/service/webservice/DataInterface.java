package com.service.webservice;

import com.service.MonitorService;
import com.vo.MonitorUrl;

public class DataInterface {
	/**
	 * ���ط���URL����Ϣ����XML��ʽ
	 * @return
	 */
	public String ericUrl(){
		StringBuffer strXml=new StringBuffer();
		
		strXml.append("<div align=center>");
		strXml.append("<table class=MsoTableGrid style=\"BORDER-TOP: medium none; BORDER-RIGHT: medium none; BORDER-COLLAPSE: collapse; BORDER-BOTTOM: medium none; BORDER-LEFT: medium none\" cellSpacing=0 cellPadding=0 border=1>");
		strXml.append("<tbody>");
		
		MonitorService ms = new MonitorService();
		MonitorUrl mu = new MonitorUrl();
		System.out.println("************************����ˮ������************************");
		strXml.append("<tr>");
		strXml.append("<td style=\"BORDER-TOP: windowtext 1pt solid; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>");
		strXml.append("<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><b><span style=\"FONT-FAMILY: ����\">����ˮ������</span></b></p>");
		strXml.append("</td>");
		strXml.append("</tr>");
		strXml.append(ms.ping(mu.getGuoneishuilibumen()));
		
		System.out.println("************************���ں���ϵͳ************************");
		strXml.append("<tr>");
		strXml.append("<td style=\"BORDER-TOP: windowtext 1pt solid; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>");
		strXml.append("<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><b><span style=\"FONT-FAMILY: ����\">���ں���ϵͳ</span></b></p>");
		strXml.append("</td>");
		strXml.append("</tr>");
		strXml.append(ms.ping(mu.getGuoneihaiyangxitong()));
		
		System.out.println("**************************������λ**************************");
		strXml.append("<tr>");
		strXml.append("<td style=\"BORDER-TOP: windowtext 1pt solid; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>");
		strXml.append("<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><b><span style=\"FONT-FAMILY: ����\">������λ</span></b></p>");
		strXml.append("</td>");
		strXml.append("</tr>");
		strXml.append(ms.ping(mu.getJushudanwei()));
		
		System.out.println("**************************����ˮ��**************************");
		strXml.append("<tr>");
		strXml.append("<td style=\"BORDER-TOP: windowtext 1pt solid; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>");
		strXml.append("<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><b><span style=\"FONT-FAMILY: ����\">����ˮ��</span></b></p>");
		strXml.append("</td>");
		strXml.append("</tr>");
		strXml.append(ms.ping(mu.getQuxianshuiwu()));
		
		System.out.println("************************������ز���************************");
		strXml.append("<tr>");
		strXml.append("<td style=\"BORDER-TOP: windowtext 1pt solid; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>");
		strXml.append("<p class=MsoNormal style=\"TEXT-ALIGN: center\" align=center><b><span style=\"FONT-FAMILY: ����\">������ز���</span></b></p>");
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
