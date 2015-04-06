package com.common;

import java.io.InputStream;
import java.util.Properties;

/**
 * 装载参数配置文件，将各参数填充到Parameter对象
 * @author wusilin
 *
 */
public class LoadParameter {
	private Properties props = new Properties(); 	// 属性文件实例
	
	/**
	 * 装在属性文件
	 * @param propertieName 属性文件名称,不包括后缀名，当前仅支持properties后缀名
	 */
	public LoadParameter(String propertieName) {
		InputStream is = getClass().getResourceAsStream("/"+propertieName+".properties");
		try {
			props.load(is);
		} catch (Exception e) {
			System.err.println("不能读取属性文件。请检查“" + propertieName + ".properties”是否在CLASSPATH指定的路径中。");
		}
	}
	
	/**
	 * 从配置文件中获取字符串内容值
	 */
	public String getStringValue(String key) {
		return props.getProperty(key);
	}
	
	/**
	 * 设置配置文件中指定键的值
	 * @param key 键
	 * @param value 值
	 */
	public void setStringValue(String key,String value){
		props.setProperty(key, value);
	}
	
	/**
	 * 获取整型值
	 */
	public int getIntValue(String key) {
		int i = 0;
		try {
			i = Integer.parseInt(props.getProperty(key));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return i;
	}
}
