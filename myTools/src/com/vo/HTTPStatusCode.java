package com.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������
 * @author cqq
 *
 */
public class HTTPStatusCode {
	private Map<String,String> codes = new HashMap<String,String>();
	public HTTPStatusCode(){
		//����ˮ������
		codes.put("100", "Continue�������� ���������Ѿ������������գ�����δ���ܾ���");
		codes.put("101", "Switching Protocols���л�Э�飩 �������Ѿ�����˿ͻ��˵����󣬲���ͨ��Upgrade ��Ϣͷ֪ͨ�ͻ��˲��ò�ͬ��Э��������������");
		codes.put("102", "Processing������ִ�У�");
		codes.put("200", "OK���ɹ��� �����ѳɹ���������ϣ������Ӧͷ�������彫�����Ӧ���ء�");
		codes.put("201", "Created���Ѵ����� ����ɹ����ҷ������������µ���Դ��");
		codes.put("202", "Accepted���ѽ��ܣ� �������ѽ������󣬵���δ����");
		codes.put("203", "Non-Authoritative Information������Ȩ��Ϣ�� �������ѳɹ����������󣬵����ص���Ϣ����������һ��Դ��");
		codes.put("204", "No Content�������ݣ� �������ɹ����������󣬵�û�з����κ����ݡ�");
		codes.put("205", "Reset Content���������ݣ� �������ɹ����������󣬵�û�з����κ����ݡ�");
		codes.put("206", "Partial Content���������ݣ� �������ɹ������˲��� GET ����");
		codes.put("207", "Multi-Status ");
		codes.put("300", "Multiple Choices������ѡ�� ������󣬷�������ִ�ж��ֲ����� �������ɸ��������� (user agent) ѡ��һ����������ṩ�����б�������ѡ�� ");
		codes.put("301", "Moved Permanently�������ƶ��� �������ҳ�������ƶ�����λ�á� ���������ش���Ӧ���� GET �� HEAD �������Ӧ��ʱ�����Զ���������ת����λ�á�");
		codes.put("302", "Move temporarily����ʱ�ƶ��� ������Ŀǰ�Ӳ�ͬλ�õ���ҳ��Ӧ���󣬵�������Ӧ����ʹ��ԭ��λ���������Ժ������");
		codes.put("303", "See Other���鿴����λ�ã� ������Ӧ���Բ�ͬ��λ��ʹ�õ����� GET ������������Ӧʱ�����������ش˴��롣");
		codes.put("304", "Not Modified��δ�޸ģ� �Դ��ϴ�������������ҳδ�޸Ĺ��� ���������ش���Ӧʱ�����᷵����ҳ���ݡ�");
		codes.put("305", "Use Proxy��ʹ�ô��� ������ֻ��ʹ�ô�������������ҳ�� ������������ش���Ӧ������ʾ������Ӧʹ�ô���");
		codes.put("306", "Switch Proxy");
		codes.put("307", "Temporary Redirect����ʱ�ض��� ������Ŀǰ�Ӳ�ͬλ�õ���ҳ��Ӧ���󣬵�������Ӧ����ʹ��ԭ��λ���������Ժ������");
		codes.put("400", "Bad Request���������� �����������������﷨��");
		codes.put("401", "Unauthorized��δ��Ȩ�� ����Ҫ�������֤�� ������Ҫ��¼����ҳ�����������ܷ��ش���Ӧ�� ");
		codes.put("403", "Forbidden���������ܾ����� �������ܾ�����");
		codes.put("404", "Not Found���������Ҳ����������ҳ�� �������Ҳ����������ҳ��");
		codes.put("405", "Method Not Allowed���������ã� ����������ָ���ķ����� ");
		codes.put("406", "Not Acceptable�������ܣ� �޷�ʹ�����������������Ӧ�������ҳ��");
		codes.put("407", "Proxy Authentication Required����Ҫ������Ȩ�� ��״̬������ 401��δ��Ȩ�����ƣ���ָ��������Ӧ����Ȩʹ�ô���");
		codes.put("408", "Request Timeout������ʱ�� �������Ⱥ�����ʱ������ʱ��");
		codes.put("409", "Conflict����ͻ�� ���������������ʱ������ͻ�� ��������������Ӧ�а����йس�ͻ����Ϣ��");
		codes.put("410", "Gone����ɾ���� ����������Դ������ɾ�����������ͻ᷵�ش���Ӧ��");
		codes.put("411", "Length Required����Ҫ��Ч���ȣ� �����������ܲ�����Ч���ݳ��ȱ�ͷ�ֶε�����");
		codes.put("412", "Precondition Failed��δ����ǰ�������� ������δ���������������������õ�����һ��ǰ��������");
		codes.put("413", "Request Entity Too Large������ʵ����� �������޷�����������Ϊ����ʵ����󣬳����������Ĵ���������");
		codes.put("414", "Request-URI Too Long������� URI ������ ����� URI��ͨ��Ϊ��ַ���������������޷�����");
		codes.put("415", "Unsupported Media Type����֧�ֵ�ý�����ͣ� ����ĸ�ʽ��������ҳ���֧�֡�");
		codes.put("416", "Requested Range Not Satisfiable������Χ������Ҫ�� ���ҳ���޷��ṩ����ķ�Χ����������᷵�ش�״̬���롣");
		codes.put("417", "Expectation Failed��δ��������ֵ�� ������δ���㡰�����������ͷ�ֶε�Ҫ��");
		
		codes.put("500", "Internal Server Error �������ڲ�����");
		codes.put("501", "Not Implemented ��δʵʩ��");
		codes.put("502", "Bad Gateway �������ء�");
		codes.put("503", "Service Unavailable ���񲻿��á�");
		codes.put("504", "Gateway Timeout ���س�ʱ��");
		codes.put("505", "HTTP Version Not Supported HTTP �汾����֧�֡�");
	}
	public Map<String, String> getCodes() {
		return codes;
	}
	public static void main(String[] args) {
		HTTPStatusCode sd = new HTTPStatusCode();
		System.out.println(sd.codes.get("200"));
	}
}