package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author : dbh
 * @createTime : 2012/07/13
 * @version : 1.0
 */
public class FileUtil {
	/**
	 * 保存文件
	 * 
	 * @param filename 
	 * @throws Exception
	 */
	public static void saveFile(File file, String filename) throws Exception {
		FileOutputStream fos = new FileOutputStream(filename);
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
	}

	// save文件；
	public static long saveFile(File file, String fileName, String filePath)
			throws Exception {
		if (file == null) {
			return 0;
		}
		System.out.println(filePath + "=======");
		File filepath = new File(filePath);
		if (!filepath.isDirectory())
			filepath.mkdirs();
		File filedesc = new File(filepath, fileName);

		return copyFile(file, filedesc);
	}

	// copy文件；
	public static long copyFile(File fromFile, File toFile) {
		long len = 0;

		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(fromFile);
			out = new FileOutputStream(toFile);
			byte[] t = new byte[1024];
			int ii = 0;
			while ((ii = in.read(t)) > 0) {
				out.write(t, 0, ii);
				len += ii;
			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return len;
	}

	public static String toCharCharacter(String str) {
		try {
			/*
			 * log.info("原样="+str); log.info("GBK-UTF-8="+new
			 * String(str.getBytes("GBK"),"UTF-8")); log.info("GB2312-UTF="+new
			 * String(str.getBytes("GB2312"),"UTF-8"));
			 * log.info("ASCII-UTF="+new String(str.getBytes("ASCII"),"UTF-8"));
			 * log.info("UNICODE-UTF="+new
			 * String(str.getBytes("UNICODE"),"UTF-8"));
			 * log.info("GBK-ASCII="+new String(str.getBytes("GBK"),"ASCII"));
			 * log.info("GBK-unicode="+new
			 * String(str.getBytes("GBK"),"UNICODE"));
			 * log.info("GBK-iio-8859-1="+new
			 * String(str.getBytes("GBK"),"ISO-8859-1"));
			 * log.info("GBK-iio-8859-gbk="+new
			 * String(str.getBytes("ISO-8859-1"),"GBK"));
			 * log.info("GBK-iio-8859-utf-8="+new
			 * String(str.getBytes("ISO-8859-1"),"UTF-8"));
			 * log.info("GBK-iio-8859-1="+new
			 * String(str.getBytes("ISO-8859-1"),"UTF-8"));
			 */
			str = new String(str.getBytes("GBK"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 验证文件正确性
	 * @param file
	 * @param exts
	 * @return
	 * @throws Exception
	 */
	public static boolean verifyFile(File file, String[] exts) throws Exception {
		boolean flag = false;
		if (file != null) {
			String ext = getExtension(file.getName());
			if (ext == null) {
				return false;
			}
			if (exts != null && exts.length > 0) {

				if (exts[0].equals("*.*"))
					return true;
				for (int i = 0; i < exts.length; i++) {

					if (ext.equalsIgnoreCase(exts[i])) {
						flag = true;
						break;
					}
				}
			}
		}

		return flag;

	}

	/**
	 * 取得文件扩展名
	 */
	public static String getExtension(String fileName) {
		if(fileName != null && !"".equals(fileName)){
			int newEnd = fileName.length();
			int i = fileName.lastIndexOf('.', newEnd);
			if (i != -1) {
				return fileName.substring(i + 1, newEnd);
			} else {
				return "";
			}
		}else{
			return "";
		}
	}
	/**
	 * 取得文件名（不带扩展名）
	 * @param fileName
	 * @return
	 */
	public static String getExtensionFileName(String fileName) {

		int newEnd = fileName.length();
		int i = fileName.lastIndexOf('.', newEnd);
		if (i != -1) {
			return fileName.substring(0, i);
		} else {
			return fileName;
		}
	}
	/**
	 * 获取文件类型
	 * @param filetype
	 * @return
	 */
	public static int getType(String filetype) {
		int n = 0;
		String type = getExtension(filetype).toLowerCase();
		if ("xls".equals(type) || "xlsx".equals(type) || "docx".equals(type) || "pdf".equals(type) 
			|| "doc".equals(type) || "jpg".equals(type) || "jpeg".equals(type) || "gif".equals(type) || "txt".equals(type)) {
			n = 1; //允许的扩展名
		} else if ("exe".equals(type) || "ini".equals(type) || "bat".equals(type)) {
			n = 3;// 非法文件扩展名
		} else {
			n = 2;// 默认不通过
		}
		return n;
	}
	
	/**
	 * 获取文件明
	 * @param filePath 路径
	 * @return
	 */
	public static String getFileName(String filePath) {
		String str = "";
		str = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath
				.length());
		return str;
	}
	
	/**
	 * 删除给定的路径的文件目录或者文件
	 * @param fileName
	 * @return
	 */
	public static boolean delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			return false;
		} else {
			if (file.isFile())
				return deleteFile(fileName);
			else
				return deleteDirectory(fileName);
		}
	}

	/**
	 * 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	 * 
	 * @param fileName
	 *            文件所在地址
	 * @return
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 删除指定目录，包括指定目录中的文件
	 * 
	 * @param dir
	 * @return
	 */
	public static boolean deleteDirectory(String dir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator))
			dir = dir + File.separator;
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
			// System.out.println("删除目录失败：" + dir + "不存在！");
			return false;
		}
		boolean flag = true;
		// 删除文件夹中的所有文件包括子目录
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
			// 删除子目录
			else if (files[i].isDirectory()) {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag) {
			// System.out.println("删除目录失败！");
			return false;
		}
		// 删除当前目录
		if (dirFile.delete()) {
			// System.out.println("删除目录" + dir + "成功！");
			return true;
		} else {
			return false;
		}
	}
}
