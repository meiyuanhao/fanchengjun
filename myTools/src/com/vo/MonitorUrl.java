package com.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������
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
		//����ˮ������
		guoneishuilibumen.put("http://www.mwr.gov.cn/", "ˮ����");
		guoneishuilibumen.put("http://www.cjw.com.cn", "ˮ��������ˮ��ίԱ��");
		guoneishuilibumen.put("http://www.yellowriver.gov.cn", "ˮ�����ƺ�ˮ��ίԱ��");
		guoneishuilibumen.put("http://www.hrc.gov.cn/smodel?model=hrc", "ˮ��������ˮ��ίԱ��");
		guoneishuilibumen.put("http://www.hwcc.gov.cn", "ˮ��������ˮ��ίԱ��");
		guoneishuilibumen.put("http://www.pearlwater.gov.cn/ ", "ˮ�����齭ˮ��ίԱ��");
		guoneishuilibumen.put("http://www.slwr.gov.cn/", "ˮ��������ˮ��ίԱ��");
		guoneishuilibumen.put("http://www.tba.gov.cn/", "ˮ����̫����������");
		guoneishuilibumen.put("http://rencai.chinawater.net.cn", "ˮ�����˲���Դ��������");
		guoneishuilibumen.put("http://www.waterinfo.com.cn/", "ˮ������չ�о�����");
		guoneishuilibumen.put("http://www.bjwater.gov.cn/", "������");
		guoneishuilibumen.put("http://www.cqwater.gov.cn/", "������");
		guoneishuilibumen.put("http://www.tjsw.gov.cn/index.htm", "�����");
		guoneishuilibumen.put("http://www.hebwater.gov.cn/", "�ӱ�ʡ");
		guoneishuilibumen.put("http://www.sxwater.gov.cn", "ɽ��ʡ");
		guoneishuilibumen.put("http://www.dwr.ln.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.hljsl.gov.cn/", "������ʡ");
		guoneishuilibumen.put("http://www.dwr.ln.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.jswater.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.zjwater.com/", "�㽭ʡ");
		guoneishuilibumen.put("http://www.ahsl.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.fjwater.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.jxsl.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.sdwr.gov.cn/", "ɽ��ʡ");
		guoneishuilibumen.put("http://www.hnsl.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.hubeiwater.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.hnwr.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.gdwater.gov.cn/", "�㶫ʡ");
		guoneishuilibumen.put("http://www.gxwater.gov.cn/", "����������");
		guoneishuilibumen.put("http://www.nmgslw.gov.cn/", "���ɹ�������");
		guoneishuilibumen.put("http://swj.hainan.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.scwater.gov.cn/", "�Ĵ�ʡ");
		guoneishuilibumen.put("http://www.gzmwr.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.wcb.yn.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.sxmwr.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.gssl.gov.cn/", "����ʡ");
		guoneishuilibumen.put("http://www.xzwater.gov.cn/", "����������");
		guoneishuilibumen.put("http://www.qhsl.gov.cn/", "�ຣʡ");
		guoneishuilibumen.put("http://xjwater.xinjiang.gov.cn/", "�½�������");
		guoneishuilibumen.put("http://www.nxsl.gov.cn/", "����������");
		guoneishuilibumen.put("http://www.wsd.gov.hk/", "���");
		guoneishuilibumen.put("http://www.mwr.gov.cn/dfsl/dfsl32.htm", "̨��");
		//���ں���ϵͳ
		guoneihaiyangxitong.put("http://www.soa.gov.cn/","���Һ����");
		guoneihaiyangxitong.put("http://www.eastsea.gov.cn/","���Һ���ֶ����־�");
		guoneihaiyangxitong.put("http://www.scsb.gov.cn/","���Һ�����Ϻ��־�");
		guoneihaiyangxitong.put("http://www.ncsb.gov.cn/","���Һ���ֱ����־�");
		guoneihaiyangxitong.put("http://www.jsof.gov.cn/","����ʡ��������ҵ��");
		guoneihaiyangxitong.put("http://www.zjoaf.gov.cn/","�㽭ʡ��������ҵ��");
		guoneihaiyangxitong.put("http://www.fjof.gov.cn/","����ʡ��������ҵ��");
		guoneihaiyangxitong.put("http://www.gdofa.gov.cn/","�㶫ʡ��������ҵ��");
		guoneihaiyangxitong.put("http://www.nbhyj.gov.cn/","�����к�������ҵ��");
		guoneihaiyangxitong.put("http://www.zsoaf.gov.cn/","��ɽ�к�������ҵ��");
		guoneihaiyangxitong.put("http://www.wzscj.com/","�����к�������ҵ��");
		guoneihaiyangxitong.put("http://www.hyj.xm.gov.cn/","�����к�������ҵ��");
		guoneihaiyangxitong.put("http://www.nmdis.gov.cn/","���Һ�����Ϣ����");
		guoneihaiyangxitong.put("http://www.nmefc.gov.cn/","���Һ��󻷾�Ԥ������");
		guoneihaiyangxitong.put("http://www.nmemc.gov.cn/","���Һ��󻷾��������");
		guoneihaiyangxitong.put("http://www.fio.org.cn/","���Һ���ֵ�һ�����о���");
		guoneihaiyangxitong.put("http://www.sio.org.cn/","���Һ���ֵڶ������о���");
		guoneihaiyangxitong.put("http://www.tio.org.cn/","���Һ���ֵ��������о���");
		guoneihaiyangxitong.put("http://www.dhjczx.org/","�������������");
		guoneihaiyangxitong.put("http://www.dhybzx.org/OceanPortal/pages/index.html","���Һ���ֶ���Ԥ������");
		guoneihaiyangxitong.put("http://www.coi.gov.cn/","�й�������Ϣ��");
		guoneihaiyangxitong.put("http://www.cso.org.cn/","�й�����Э��");
		guoneihaiyangxitong.put("http://www.oceanpress.com.cn/","���������");
		//������λ
		jushudanwei.put("http://www.shsl.org.cn", "�Ϻ���ˮ������");
		jushudanwei.put("http://www.shanghaiwaterlaw.cn", "�Ϻ���ˮ������ִ���ܶӣ��й������Ϻ����ܶӣ�");
		jushudanwei.put("http://www.shanghaiwater.gov.cn/web/jjg1-25.jsp", "�Ϻ���ˮ��ҵ���������ģ��Ϻ��к���ҵ���������ģ�");
		jushudanwei.put("http://www.wsa.gov.cn", "�Ϻ��й�ˮ����(�мƻ���ˮ�칫��)");
		jushudanwei.put("http://www.smda.org.cn", "�Ϻ�����ˮ����");
		jushudanwei.put("http://www.shdike.org.cn", "�Ϻ��е̷�����բ����ʩ����");
		jushudanwei.put("http://www.hydrology.sh.cn", "�Ϻ���ˮ����վ���Ϻ���ˮ����������� �Ϻ��к��󻷾����Ԥ�����ģ�");
		jushudanwei.put("http://www.shwaterplan.com", "�Ϻ���ˮ��滮����о�Ժ���Ϻ��к���滮����о�Ժ��");
		jushudanwei.put("http://www.shanghaiwater.gov.cn/web/jjg1-36.jsp", "�Ϻ��й�ˮ���ȼ������");
		jushudanwei.put("http://www.shswzaj.cn", "�Ϻ���ˮ�����蹤�������ල����վ");
		jushudanwei.put("http://www.shanghaiwater.org", "�Ϻ��з�Ѵ��Ϣ���ģ��Ϻ���ˮ����Ϣ���ġ��Ϻ��к�����Ϣ���ģ�");
		jushudanwei.put("http://www.shanghaiwater.gov.cn/web/jjg1-38.jsp", "�Ϻ��к��������������");
		//����ˮ��
		quxianshuiwu.put("http://211.144.95.130:9080/website/index.jsp", "�ֶ�����ˮ��");
		quxianshuiwu.put("http://jswater.jinshan.gov.cn/", "��ɽˮ��");
		quxianshuiwu.put("http://www.sjsw.org.cn", "�ɽ�ˮ��");
		quxianshuiwu.put("http://water.shqp.gov.cn", "����ˮ��");
		quxianshuiwu.put("http://www.fxwater.gov.cn", "����ˮ��");
		quxianshuiwu.put("http://www.jdwater.gov.cn/", "�ζ�ˮ��");
		quxianshuiwu.put("http://www.cmwater.gov.cn", "����ˮ��");
		quxianshuiwu.put("http://water.baoshan.sh.cn", "��ɽˮ��");
		//������ز���
		benshixiangguanbumen.put("http://www.shio.gov.cn/", "�Ϻ��������������Ű칫��");
		benshixiangguanbumen.put("http://jsjtw.sh.gov.cn", "�Ϻ��г��罨��ͽ�ͨίԱ��");
		benshixiangguanbumen.put("http://www.sepb.gov.cn/", "�Ϻ��л���������");
		benshixiangguanbumen.put("http://www.smb.gov.cn/SMBWeb/Default/Index.aspx", "�Ϻ��������");
		benshixiangguanbumen.put("http://www.smsc.sh.cn/indexpage.shtml", "�Ϻ��г�����ˮ���޹�˾");
		benshixiangguanbumen.put("http://www.shanghaiwater.com/", "�Ϻ�������ˮ�б����޹�˾");
		benshixiangguanbumen.put("http://www.water-sh.com/", "�Ϻ�������ˮ�������޹�˾");
		benshixiangguanbumen.put("http://www.pudongwater.com/", "�Ϻ����ֶ�����������ˮ���޹�˾");
		benshixiangguanbumen.put("http://www.minhangwater.com/", "�Ϻ�������ˮ�������޹�˾");
		benshixiangguanbumen.put("http://www.fengxianwater.com/", "�Ϻ�������ˮ�������޹�˾");
		benshixiangguanbumen.put("http://www.shhes.org.cn/", "�Ϻ���ˮ��ѧ��");
	}
	/**
	 * ����ˮ������
	 * @return
	 */
	public Map<String, String> getGuoneishuilibumen() {
		return guoneishuilibumen;
	}
	public void setGuoneishuilibumen(Map<String, String> guoneishuilibumen) {
		this.guoneishuilibumen = guoneishuilibumen;
	}
	/**
	 * ���ں���ϵͳ
	 * @return
	 */
	public Map<String, String> getGuoneihaiyangxitong() {
		return guoneihaiyangxitong;
	}
	public void setGuoneihaiyangxitong(Map<String, String> guoneihaiyangxitong) {
		this.guoneihaiyangxitong = guoneihaiyangxitong;
	}
	/**
	 * ������λ
	 * @return
	 */
	public Map<String, String> getJushudanwei() {
		return jushudanwei;
	}
	public void setJushudanwei(Map<String, String> jushudanwei) {
		this.jushudanwei = jushudanwei;
	}
	/**
	 * ����ˮ��
	 * @return
	 */
	public Map<String, String> getQuxianshuiwu() {
		return quxianshuiwu;
	}
	public void setQuxianshuiwu(Map<String, String> quxianshuiwu) {
		this.quxianshuiwu = quxianshuiwu;
	}
	/**
	 * ������ز���
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
