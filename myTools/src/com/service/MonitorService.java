package com.service;

import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import com.vo.HTTPStatusCode;

public class MonitorService {
	
	public String ping(Map<String,String> urlMap){
		HTTPStatusCode statusCode = new HTTPStatusCode();
		URL url = null;
		String tr = "";
		HttpURLConnection httpcon = null;
		Iterator<String> it =  urlMap.keySet().iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			System.out.print(urlMap.get(string));
			System.err.println(string);
			try {
				int respCode = 0;
				url = new URL(string);
				httpcon = (HttpURLConnection) url.openConnection();
				httpcon.connect();
				respCode = httpcon.getResponseCode();
				
				tr += "<tr>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 180.15pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=240>";
				tr += "<p class=MsoNormal style=\"TEXT-ALIGN: left\" align=left><span style=\"FONT-FAMILY: ËÎÌå\">" + urlMap.get(string) + "</span></p>";
				tr += "</td>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 245.95pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" vAlign=top width=328>";
				tr += "<p class=MsoNormal style=\"TEXT-ALIGN: left\" align=left><span><a href=\"" + string + "\">"+ string +"</a></span></p>";
				tr += "</td>";
				tr += "</tr>";
				tr += "<tr>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>";
				tr += "<p class=MsoNormal><span style=\"FONT-FAMILY: ËÎÌå\">×´Ì¬£º</span><span>" + respCode + "</span></p>";
				tr += "<p class=MsoNormal><span style=\"FONT-FAMILY: ËÎÌå\">" + statusCode.getCodes().get(String.valueOf(respCode)) + "</span></p>";
				tr += "</td>";
				tr += "</tr>";
				
				httpcon.disconnect();
				httpcon = null;
			} catch (ConnectException ex) {
				tr += "<tr>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 180.15pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=240>";
				tr += "<p class=MsoNormal style=\"TEXT-ALIGN: left\" align=left><span style=\"FONT-FAMILY: ËÎÌå\">" + urlMap.get(string) + "</span></p>";
				tr += "</td>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 245.95pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" vAlign=top width=328>";
				tr += "<p class=MsoNormal style=\"TEXT-ALIGN: left\" align=left><span><a href=\"" + string + "\">"+ string +"</a></span></p>";
				tr += "</td>";
				tr += "</tr>";
				tr += "<tr>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>";
				tr += "<p class=MsoNormal><span style=\"FONT-FAMILY: ËÎÌå\">" + ex.toString() + "</span></p>";
				tr += "</td>";
				tr += "</tr>";
			} catch (MalformedURLException ex) {
				tr += "<tr>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 180.15pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=240>";
				tr += "<p class=MsoNormal style=\"TEXT-ALIGN: left\" align=left><span style=\"FONT-FAMILY: ËÎÌå\">" + urlMap.get(string) + "</span></p>";
				tr += "</td>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 245.95pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" vAlign=top width=328>";
				tr += "<p class=MsoNormal style=\"TEXT-ALIGN: left\" align=left><span><a href=\"" + string + "\">"+ string +"</a></span></p>";
				tr += "</td>";
				tr += "</tr>";
				tr += "<tr>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>";
				tr += "<p class=MsoNormal><span style=\"FONT-FAMILY: ËÎÌå\">" + ex.toString() + "</span></p>";
				tr += "</td>";
				tr += "</tr>";
			} catch (Exception ex) {
				tr += "<tr>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 180.15pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=240>";
				tr += "<p class=MsoNormal style=\"TEXT-ALIGN: left\" align=left><span style=\"FONT-FAMILY: ËÎÌå\">" + urlMap.get(string) + "</span></p>";
				tr += "</td>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 245.95pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: medium none; PADDING-RIGHT: 5.4pt\" vAlign=top width=328>";
				tr += "<p class=MsoNormal style=\"TEXT-ALIGN: left\" align=left><span><a href=\"" + string + "\">"+ string +"</a></span></p>";
				tr += "</td>";
				tr += "</tr>";
				tr += "<tr>";
				tr += "<td style=\"BORDER-TOP: medium none; BORDER-RIGHT: windowtext 1pt solid; WIDTH: 426.1pt; BORDER-BOTTOM: windowtext 1pt solid; PADDING-BOTTOM: 0cm; PADDING-TOP: 0cm; PADDING-LEFT: 5.4pt; BORDER-LEFT: windowtext 1pt solid; PADDING-RIGHT: 5.4pt\" vAlign=top width=568 colSpan=2>";
				tr += "<p class=MsoNormal><span style=\"FONT-FAMILY: ËÎÌå\">" + ex.toString() + "</span></p>";
				tr += "</td>";
				tr += "</tr>";
			} finally {
				if (httpcon != null)
					httpcon.disconnect();
				httpcon = null;
				url = null;
			}
		}
		return tr;
	}
}
