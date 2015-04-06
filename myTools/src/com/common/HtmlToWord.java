package com.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class HtmlToWord {
	/**
	 * 把数据写入指定物理路径的office Word 文档中
	 * 
	 * @param filename
	 *            提供office Word 的文件名
	 * @param content
	 *            提供office Word 的内容
	 * @return
	 */
	public boolean writeWordFile(String path, String filename, String content) {
		boolean flag = false;
		ByteArrayInputStream bais = null;
		FileOutputStream fos = null;
		try {
			byte b[] = content.getBytes();
			bais = new ByteArrayInputStream(b);
			POIFSFileSystem poifs = new POIFSFileSystem();
			DirectoryEntry directory = poifs.getRoot();
			DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
			// fos = new FileOutputStream("d:/eworkspace/clickAmount/WebRoot/doc/" + filename + ".doc");
			fos = new FileOutputStream(path + filename + ".doc");
			poifs.writeFilesystem(fos);
			bais.close();
			fos.close();
		} catch (Exception e) {

		}
		return flag;
	}

	/**
	 * 读取指定的HTML文档
	 * 
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public String readFile(String filename) throws Exception {
		StringBuffer buffer = new StringBuffer("");
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		try {
			while (br.ready()) {
				buffer.append(br.readLine());
			}
		} catch (Exception e) {

		}
		return "<html>" + buffer.toString() + "</html>";
	}
}