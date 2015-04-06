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
	 * �����ļ�
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

	// save�ļ���
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

	// copy�ļ���
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
			 * log.info("ԭ��="+str); log.info("GBK-UTF-8="+new
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
	 * ��֤�ļ���ȷ��
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
	 * ȡ���ļ���չ��
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
	 * ȡ���ļ�����������չ����
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
	 * ��ȡ�ļ�����
	 * @param filetype
	 * @return
	 */
	public static int getType(String filetype) {
		int n = 0;
		String type = getExtension(filetype).toLowerCase();
		if ("xls".equals(type) || "xlsx".equals(type) || "docx".equals(type) || "pdf".equals(type) 
			|| "doc".equals(type) || "jpg".equals(type) || "jpeg".equals(type) || "gif".equals(type) || "txt".equals(type)) {
			n = 1; //�������չ��
		} else if ("exe".equals(type) || "ini".equals(type) || "bat".equals(type)) {
			n = 3;// �Ƿ��ļ���չ��
		} else {
			n = 2;// Ĭ�ϲ�ͨ��
		}
		return n;
	}
	
	/**
	 * ��ȡ�ļ���
	 * @param filePath ·��
	 * @return
	 */
	public static String getFileName(String filePath) {
		String str = "";
		str = filePath.substring(filePath.lastIndexOf("\\") + 1, filePath
				.length());
		return str;
	}
	
	/**
	 * ɾ��������·�����ļ�Ŀ¼�����ļ�
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
	 * ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
	 * 
	 * @param fileName
	 *            �ļ����ڵ�ַ
	 * @return
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
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
	 * ɾ��ָ��Ŀ¼������ָ��Ŀ¼�е��ļ�
	 * 
	 * @param dir
	 * @return
	 */
	public static boolean deleteDirectory(String dir) {
		// ���dir�����ļ��ָ�����β���Զ�����ļ��ָ���
		if (!dir.endsWith(File.separator))
			dir = dir + File.separator;
		File dirFile = new File(dir);
		// ���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
		if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
			// System.out.println("ɾ��Ŀ¼ʧ�ܣ�" + dir + "�����ڣ�");
			return false;
		}
		boolean flag = true;
		// ɾ���ļ����е������ļ�������Ŀ¼
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// ɾ�����ļ�
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
			// ɾ����Ŀ¼
			else if (files[i].isDirectory()) {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag) {
			// System.out.println("ɾ��Ŀ¼ʧ�ܣ�");
			return false;
		}
		// ɾ����ǰĿ¼
		if (dirFile.delete()) {
			// System.out.println("ɾ��Ŀ¼" + dir + "�ɹ���");
			return true;
		} else {
			return false;
		}
	}
}
