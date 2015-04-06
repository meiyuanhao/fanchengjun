package com.vo;

/** 
* @author		MeiYuanhao
* @ClassName	Code 对应数据表 t_code
* @category		
* @date			2014-8-19 下午03:31:49
* @version		1.0
*/ 
public class Code {
	private String id;
	private String dh;
	private String codeValue;
	private String codeChinese;
	private String parentId;
	private String hasChild;
	private String sort;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getCodeChinese() {
		return codeChinese;
	}
	public void setCodeChinese(String codeChinese) {
		this.codeChinese = codeChinese;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getHasChild() {
		return hasChild;
	}
	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
}
