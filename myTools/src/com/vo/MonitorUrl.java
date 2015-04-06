package com.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 检测的链接
 * @author cqq
 *
 */
public class MonitorUrl {
	private Map<String,String> guoneishuilibumen = new HashMap<String,String>();
	private Map<String,String> guoneihaiyangxitong = new HashMap<String,String>();
	private Map<String,String> jushudanwei = new HashMap<String,String>();
	private Map<String,String> quxianshuiwu = new HashMap<String,String>();
	private Map<String,String> benshixiangguanbumen = new HashMap<String,String>();
	public MonitorUrl(){
		//国内水利部门
		guoneishuilibumen.put("http://www.mwr.gov.cn/", "水利部");
		guoneishuilibumen.put("http://www.cjw.com.cn", "水利部长江水利委员会");
		guoneishuilibumen.put("http://www.yellowriver.gov.cn", "水利部黄河水利委员会");
		guoneishuilibumen.put("http://www.hrc.gov.cn/smodel?model=hrc", "水利部淮河水利委员会");
		guoneishuilibumen.put("http://www.hwcc.gov.cn", "水利部海河水利委员会");
		guoneishuilibumen.put("http://www.pearlwater.gov.cn/ ", "水利部珠江水利委员会");
		guoneishuilibumen.put("http://www.slwr.gov.cn/", "水利部松辽水利委员会");
		guoneishuilibumen.put("http://www.tba.gov.cn/", "水利部太湖流域管理局");
		guoneishuilibumen.put("http://rencai.chinawater.net.cn", "水利部人才资源开发中心");
		guoneishuilibumen.put("http://www.waterinfo.com.cn/", "水利部发展研究中心");
		guoneishuilibumen.put("http://www.bjwater.gov.cn/", "北京市");
		guoneishuilibumen.put("http://www.cqwater.gov.cn/", "重庆市");
		guoneishuilibumen.put("http://www.tjsw.gov.cn/index.htm", "天津市");
		guoneishuilibumen.put("http://www.hebwater.gov.cn/", "河北省");
		guoneishuilibumen.put("http://www.sxwater.gov.cn", "山西省");
		guoneishuilibumen.put("http://www.dwr.ln.gov.cn/", "辽宁省");
		guoneishuilibumen.put("http://www.hljsl.gov.cn/", "黑龙江省");
		guoneishuilibumen.put("http://www.dwr.ln.gov.cn/", "吉林省");
		guoneishuilibumen.put("http://www.jswater.gov.cn/", "江苏省");
		guoneishuilibumen.put("http://www.zjwater.com/", "浙江省");
		guoneishuilibumen.put("http://www.ahsl.gov.cn/", "安徽省");
		guoneishuilibumen.put("http://www.fjwater.gov.cn/", "福建省");
		guoneishuilibumen.put("http://www.jxsl.gov.cn/", "江西省");
		guoneishuilibumen.put("http://www.sdwr.gov.cn/", "山东省");
		guoneishuilibumen.put("http://www.hnsl.gov.cn/", "河南省");
		guoneishuilibumen.put("http://www.hubeiwater.gov.cn/", "湖北省");
		guoneishuilibumen.put("http://www.hnwr.gov.cn/", "湖南省");
		guoneishuilibumen.put("http://www.gdwater.gov.cn/", "广东省");
		guoneishuilibumen.put("http://www.gxwater.gov.cn/", "广西自治区");
		guoneishuilibumen.put("http://www.nmgslw.gov.cn/", "内蒙古自治区");
		guoneishuilibumen.put("http://swj.hainan.gov.cn/", "海南省");
		guoneishuilibumen.put("http://www.scwater.gov.cn/", "四川省");
		guoneishuilibumen.put("http://www.gzmwr.gov.cn/", "贵州省");
		guoneishuilibumen.put("http://www.wcb.yn.gov.cn/", "云南省");
		guoneishuilibumen.put("http://www.sxmwr.gov.cn/", "陕西省");
		guoneishuilibumen.put("http://www.gssl.gov.cn/", "甘肃省");
		guoneishuilibumen.put("http://www.xzwater.gov.cn/", "西藏自治区");
		guoneishuilibumen.put("http://www.qhsl.gov.cn/", "青海省");
		guoneishuilibumen.put("http://xjwater.xinjiang.gov.cn/", "新疆自治区");
		guoneishuilibumen.put("http://www.nxsl.gov.cn/", "宁夏自治区");
		guoneishuilibumen.put("http://www.wsd.gov.hk/", "香港");
		guoneishuilibumen.put("http://www.mwr.gov.cn/dfsl/dfsl32.htm", "台湾");
		//国内海洋系统
		guoneihaiyangxitong.put("http://www.soa.gov.cn/","国家海洋局");
		guoneihaiyangxitong.put("http://www.eastsea.gov.cn/","国家海洋局东海分局");
		guoneihaiyangxitong.put("http://www.scsb.gov.cn/","国家海洋局南海分局");
		guoneihaiyangxitong.put("http://www.ncsb.gov.cn/","国家海洋局北海分局");
		guoneihaiyangxitong.put("http://www.jsof.gov.cn/","江苏省海洋与渔业局");
		guoneihaiyangxitong.put("http://www.zjoaf.gov.cn/","浙江省海洋与渔业局");
		guoneihaiyangxitong.put("http://www.fjof.gov.cn/","福建省海洋与渔业局");
		guoneihaiyangxitong.put("http://www.gdofa.gov.cn/","广东省海洋与渔业局");
		guoneihaiyangxitong.put("http://www.nbhyj.gov.cn/","宁波市海洋与渔业局");
		guoneihaiyangxitong.put("http://www.zsoaf.gov.cn/","舟山市海洋与渔业局");
		guoneihaiyangxitong.put("http://www.wzscj.com/","温州市海洋与渔业网");
		guoneihaiyangxitong.put("http://www.hyj.xm.gov.cn/","厦门市海洋与渔业局");
		guoneihaiyangxitong.put("http://www.nmdis.gov.cn/","国家海洋信息中心");
		guoneihaiyangxitong.put("http://www.nmefc.gov.cn/","国家海洋环境预报中心");
		guoneihaiyangxitong.put("http://www.nmemc.gov.cn/","国家海洋环境监测中心");
		guoneihaiyangxitong.put("http://www.fio.org.cn/","国家海洋局第一海洋研究所");
		guoneihaiyangxitong.put("http://www.sio.org.cn/","国家海洋局第二海洋研究所");
		guoneihaiyangxitong.put("http://www.tio.org.cn/","国家海洋局第三海洋研究所");
		guoneihaiyangxitong.put("http://www.dhjczx.org/","东海环境监测网");
		guoneihaiyangxitong.put("http://www.dhybzx.org/OceanPortal/pages/index.html","国家海洋局东海预报中心");
		guoneihaiyangxitong.put("http://www.coi.gov.cn/","中国海洋信息网");
		guoneihaiyangxitong.put("http://www.cso.org.cn/","中国海洋协会");
		guoneihaiyangxitong.put("http://www.oceanpress.com.cn/","海洋出版社");
		//局属单位
		jushudanwei.put("http://www.shsl.org.cn", "上海市水利管理处");
		jushudanwei.put("http://www.shanghaiwaterlaw.cn", "上海市水务行政执法总队（中国海监上海市总队）");
		jushudanwei.put("http://www.shanghaiwater.gov.cn/web/jjg1-25.jsp", "上海市水务业务受理中心（上海市海洋业务受理中心）");
		jushudanwei.put("http://www.wsa.gov.cn", "上海市供水管理处(市计划用水办公室)");
		jushudanwei.put("http://www.smda.org.cn", "上海市排水管理处");
		jushudanwei.put("http://www.shdike.org.cn", "上海市堤防（泵闸）设施管理处");
		jushudanwei.put("http://www.hydrology.sh.cn", "上海市水文总站（上海市水环境监测中心 上海市海洋环境监测预报中心）");
		jushudanwei.put("http://www.shwaterplan.com", "上海市水务规划设计研究院（上海市海洋规划设计研究院）");
		jushudanwei.put("http://www.shanghaiwater.gov.cn/web/jjg1-36.jsp", "上海市供水调度监测中心");
		jushudanwei.put("http://www.shswzaj.cn", "上海市水利建设工程质量监督中心站");
		jushudanwei.put("http://www.shanghaiwater.org", "上海市防汛信息中心（上海市水务信息中心、上海市海洋信息中心）");
		jushudanwei.put("http://www.shanghaiwater.gov.cn/web/jjg1-38.jsp", "上海市海洋管理事务中心");
		//区县水务
		quxianshuiwu.put("http://211.144.95.130:9080/website/index.jsp", "浦东新区水务");
		quxianshuiwu.put("http://jswater.jinshan.gov.cn/", "金山水务");
		quxianshuiwu.put("http://www.sjsw.org.cn", "松江水务");
		quxianshuiwu.put("http://water.shqp.gov.cn", "青浦水务");
		quxianshuiwu.put("http://www.fxwater.gov.cn", "奉贤水务");
		quxianshuiwu.put("http://www.jdwater.gov.cn/", "嘉定水务");
		quxianshuiwu.put("http://www.cmwater.gov.cn", "崇明水务");
		quxianshuiwu.put("http://water.baoshan.sh.cn", "宝山水务");
		//本市相关部门
		benshixiangguanbumen.put("http://www.shio.gov.cn/", "上海市人民政府新闻办公室");
		benshixiangguanbumen.put("http://jsjtw.sh.gov.cn", "上海市城乡建设和交通委员会");
		benshixiangguanbumen.put("http://www.sepb.gov.cn/", "上海市环境保护局");
		benshixiangguanbumen.put("http://www.smb.gov.cn/SMBWeb/Default/Index.aspx", "上海市气象局");
		benshixiangguanbumen.put("http://www.smsc.sh.cn/indexpage.shtml", "上海市城市排水有限公司");
		benshixiangguanbumen.put("http://www.shanghaiwater.com/", "上海市自来水市北有限公司");
		benshixiangguanbumen.put("http://www.water-sh.com/", "上海市自来水市南有限公司");
		benshixiangguanbumen.put("http://www.pudongwater.com/", "上海市浦东威立雅自来水有限公司");
		benshixiangguanbumen.put("http://www.minhangwater.com/", "上海市自来水闵行有限公司");
		benshixiangguanbumen.put("http://www.fengxianwater.com/", "上海市自来水奉贤有限公司");
		benshixiangguanbumen.put("http://www.shhes.org.cn/", "上海市水利学会");
	}
	/**
	 * 国内水利部门
	 * @return
	 */
	public Map<String, String> getGuoneishuilibumen() {
		return guoneishuilibumen;
	}
	public void setGuoneishuilibumen(Map<String, String> guoneishuilibumen) {
		this.guoneishuilibumen = guoneishuilibumen;
	}
	/**
	 * 国内海洋系统
	 * @return
	 */
	public Map<String, String> getGuoneihaiyangxitong() {
		return guoneihaiyangxitong;
	}
	public void setGuoneihaiyangxitong(Map<String, String> guoneihaiyangxitong) {
		this.guoneihaiyangxitong = guoneihaiyangxitong;
	}
	/**
	 * 局属单位
	 * @return
	 */
	public Map<String, String> getJushudanwei() {
		return jushudanwei;
	}
	public void setJushudanwei(Map<String, String> jushudanwei) {
		this.jushudanwei = jushudanwei;
	}
	/**
	 * 区县水务
	 * @return
	 */
	public Map<String, String> getQuxianshuiwu() {
		return quxianshuiwu;
	}
	public void setQuxianshuiwu(Map<String, String> quxianshuiwu) {
		this.quxianshuiwu = quxianshuiwu;
	}
	/**
	 * 本市相关部门
	 * @return
	 */
	public Map<String, String> getBenshixiangguanbumen() {
		return benshixiangguanbumen;
	}
	public void setBenshixiangguanbumen(Map<String, String> benshixiangguanbumen) {
		this.benshixiangguanbumen = benshixiangguanbumen;
	}
	
	public static void main(String[] args) {
		System.out.println("--------------");
	}
}
