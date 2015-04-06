sssssspackage com.function;

import java.io.File;
import java.util.Arrays;


import com.common.FileSorter;
import com.common.FileUtil;
import com.common.HtmlToWord;
import com.common.LoadParameter;
import com.common.MSWordManager;
import com.service.webservice.DataInterface;

public class CopyMyActionTools {
	/**
	 * 审签表操作
	 */
	public static void CheckTable(){
	    String id =
	        "'9f90816c48ad11f20148ba3901c20dd0',"+
	        "'9f90816c48ad11f20148ba47097e0e0f',"+
	        "'9f90816c48ad11f20148ba80e7e20e8a',"+
	        "'9f90816c48bcb3d80148bf651ded0439',"+
	        "'9f90816c48bcb3d80148bfc4323204d4'";
		String sql_one = "" +
		"Select id," +
				"title," +
				"content," +
				"publish_time," +
				"info_source " +
		"from TB_INFO_PUB_CONTENT WHERE id in ("+id+")";
		System.out.println(sql_one);
		String sql_qujian = "" +
		"Select tbinfopubc0_.id,"+
		"       tbinfopubc0_.title,"+
		"       tbinfopubc0_.content,"+
		"       tbinfopubc0_.publish_time,"+
		"       tbinfopubc0_.info_source"+
		"  from SSOADMIN.TB_INFO_PUB_CONTENT tbinfopubc0_ "+
		"where ((tbinfopubc0_.SEND_TO != '2') and (tbinfopubc0_.SEND_TO != '3'))"+
		"   and (tbinfopubc0_.publish_time >= to_date('2014-07-01', 'yyyy-MM-dd') and tbinfopubc0_.publish_time <= to_date('2014-07-31', 'yyyy-MM-dd'))"+
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
			checkTable.makeFile(path,sql_one);
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
	
	public static void main(String[] args) {
	    //打印生成审签表
		CopyMyActionTools.CheckTable();
		//MyActionTools.monitor();
		//MyActionTools.excel();
		//MyActionTools.account();
		//MyActionTools.excelEquals();
		//MyActionTools.accountValidate();
		//MyActionTools.repetitiveValidate();
		//MyActionTools.getExperts();
		/*
		String menu_num = "";
		Scanner input = new Scanner(System.in);
		System.out.println("=========菜单=========");
		System.out.println("1.审签表生成");
		System.out.println("2.友情链接检测");
		System.out.println("3.专家账户信息初始化");
		System.out.println("4.专家账户信息注册");
		System.out.println("5.专家账户信息终板");
		System.out.println("6.专家账户有效性检测");
		System.out.println("7.专家信息重复性验证");
		System.out.println("8.导出专家信息（JSON）");
		System.out.println("请输入菜单编号：");
		menu_num = input.next();
		if(menu_num.equals("1")){
			MyActionTools.CheckTable();
		}else if(menu_num.equals("2")){
			MyActionTools.monitor();
		}else if(menu_num.equals("3")){
			MyActionTools.excel();
		}else if(menu_num.equals("4")){
			MyActionTools.account();
		}else if(menu_num.equals("5")){
			MyActionTools.excelEquals();
		}else if(menu_num.equals("6")){
			MyActionTools.accountValidate();
		}else if(menu_num.equals("7")){
			MyActionTools.repetitiveValidate();
		}else if(menu_num.equals("8")){
			MyActionTools.getExperts();
		}
		*/
	}
}
