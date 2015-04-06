package com.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 检测的链接
 * @author cqq
 *
 */
public class HTTPStatusCode {
	private Map<String,String> codes = new HashMap<String,String>();
	public HTTPStatusCode(){
		//国内水利部门
		codes.put("100", "Continue（继续） 部分请求已经被服务器接收，且仍未被拒绝。");
		codes.put("101", "Switching Protocols（切换协议） 服务器已经理解了客户端的请求，并将通过Upgrade 消息头通知客户端采用不同的协议来完成这个请求。");
		codes.put("102", "Processing（继续执行）");
		codes.put("200", "OK（成功） 请求已成功，请求所希望的响应头或数据体将随此响应返回。");
		codes.put("201", "Created（已创建） 请求成功并且服务器创建了新的资源。");
		codes.put("202", "Accepted（已接受） 服务器已接受请求，但尚未处理。");
		codes.put("203", "Non-Authoritative Information（非授权信息） 服务器已成功处理了请求，但返回的信息可能来自另一来源。");
		codes.put("204", "No Content（无内容） 服务器成功处理了请求，但没有返回任何内容。");
		codes.put("205", "Reset Content（重置内容） 服务器成功处理了请求，但没有返回任何内容。");
		codes.put("206", "Partial Content（部分内容） 服务器成功处理了部分 GET 请求。");
		codes.put("207", "Multi-Status ");
		codes.put("300", "Multiple Choices（多种选择） 针对请求，服务器可执行多种操作。 服务器可根据请求者 (user agent) 选择一项操作，或提供操作列表供请求者选择。 ");
		codes.put("301", "Moved Permanently（永久移动） 请求的网页已永久移动到新位置。 服务器返回此响应（对 GET 或 HEAD 请求的响应）时，会自动将请求者转到新位置。");
		codes.put("302", "Move temporarily（临时移动） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。");
		codes.put("303", "See Other（查看其他位置） 请求者应当对不同的位置使用单独的 GET 请求来检索响应时，服务器返回此代码。");
		codes.put("304", "Not Modified（未修改） 自从上次请求后，请求的网页未修改过。 服务器返回此响应时，不会返回网页内容。");
		codes.put("305", "Use Proxy（使用代理） 请求者只能使用代理访问请求的网页。 如果服务器返回此响应，还表示请求者应使用代理。");
		codes.put("306", "Switch Proxy");
		codes.put("307", "Temporary Redirect（临时重定向） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。");
		codes.put("400", "Bad Request（错误请求） 服务器不理解请求的语法。");
		codes.put("401", "Unauthorized（未授权） 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。 ");
		codes.put("403", "Forbidden（服务器拒绝请求） 服务器拒绝请求。");
		codes.put("404", "Not Found（服务器找不到请求的网页） 服务器找不到请求的网页。");
		codes.put("405", "Method Not Allowed（方法禁用） 禁用请求中指定的方法。 ");
		codes.put("406", "Not Acceptable（不接受） 无法使用请求的内容特性响应请求的网页。");
		codes.put("407", "Proxy Authentication Required（需要代理授权） 此状态代码与 401（未授权）类似，但指定请求者应当授权使用代理。");
		codes.put("408", "Request Timeout（请求超时） 服务器等候请求时发生超时。");
		codes.put("409", "Conflict（冲突） 服务器在完成请求时发生冲突。 服务器必须在响应中包含有关冲突的信息。");
		codes.put("410", "Gone（已删除） 如果请求的资源已永久删除，服务器就会返回此响应。");
		codes.put("411", "Length Required（需要有效长度） 服务器不接受不含有效内容长度标头字段的请求。");
		codes.put("412", "Precondition Failed（未满足前提条件） 服务器未满足请求者在请求中设置的其中一个前提条件。");
		codes.put("413", "Request Entity Too Large（请求实体过大） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。");
		codes.put("414", "Request-URI Too Long（请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理。");
		codes.put("415", "Unsupported Media Type（不支持的媒体类型） 请求的格式不受请求页面的支持。");
		codes.put("416", "Requested Range Not Satisfiable（请求范围不符合要求） 如果页面无法提供请求的范围，则服务器会返回此状态代码。");
		codes.put("417", "Expectation Failed（未满足期望值） 服务器未满足“期望”请求标头字段的要求。");
		
		codes.put("500", "Internal Server Error 服务器内部错误。");
		codes.put("501", "Not Implemented 尚未实施。");
		codes.put("502", "Bad Gateway 错误网关。");
		codes.put("503", "Service Unavailable 服务不可用。");
		codes.put("504", "Gateway Timeout 网关超时。");
		codes.put("505", "HTTP Version Not Supported HTTP 版本不受支持。");
	}
	public Map<String, String> getCodes() {
		return codes;
	}
	public static void main(String[] args) {
		HTTPStatusCode sd = new HTTPStatusCode();
		System.out.println(sd.codes.get("200"));
	}
}