package com.itsolife.htmltomarkdown;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * File文件工具
 * @author robin
 *
 */
public class FilesUtil {

	/**
	 * 复制文件
	 * @param fileName 文件名
	 * @param fountainheadDirs 源文件路径
	 * @param armDirs 目的文件路径
	 * @return boolean
	 */
	public boolean copyTheFile(String fileName, String fountainheadDirs,
			String armDirs) {
		boolean isSucceed = false;

		InputStream inStream = null;
		FileOutputStream fs = null;
		try {
			int byteread = 0;
			File oldFile = new File(fountainheadDirs + "/" + fileName);
			File armFileDirs = new File(armDirs);
			if (!armFileDirs.exists()) {
				armFileDirs.mkdirs();
			}
			if (!oldFile.exists()) {
				throw new Exception("要复制的文件不存在");
			}
			if (oldFile.exists()) { // 文件存在时
				inStream = new FileInputStream(fountainheadDirs + "/"
						+ fileName); // 读入原文件
				fs = new FileOutputStream(armDirs + "/" + fileName);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
			}
			isSucceed = true;
		} catch (Exception e) {
			System.out.println("读取的文件不存在或复制单个文件操作出错");
			e.printStackTrace();
		} finally {
			try {
				if (fs != null)
					fs.close();
				if (inStream != null)
					inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return isSucceed;
	}

	/**
	 * 剪切文件
	 * @param fileName 文件名称
	 * @param fountainheadDirs 源文件路径
	 * @param armDirs 目的文件路径
	 * @return boolean
	 */
	public boolean cutTheFile(String fileName, String fountainheadDirs,
			String armDirs) {
		boolean isSucceed = false;

		InputStream inStream = null;
		FileOutputStream fs = null;
		try {
			int byteread = 0;
			File oldFile = new File(fountainheadDirs + "/" + fileName);
			File armFileDirs = new File(armDirs);
			if (!armFileDirs.exists()) {
				armFileDirs.mkdirs();
			}
			if (!oldFile.exists()) {
				throw new Exception("要复制的文件不存在");
			}
			if (oldFile.exists()) { // 文件存在时
				inStream = new FileInputStream(fountainheadDirs + "/"
						+ fileName); // 读入原文件
				fs = new FileOutputStream(armDirs + "/" + fileName);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
			}
			// System.out.println(deleteFile.delete());
			isSucceed = true;
		} catch (Exception e) {
			System.out.println("读取的文件不存在或复制单个文件操作出错");
			e.printStackTrace();
		} finally {
			try {
				if (fs != null)
					fs.close();
				if (inStream != null)
					inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			File deleteFile = new File(fountainheadDirs + "/" + fileName);
			if(isSucceed)
			isSucceed = deleteFile.delete();
		}
		return isSucceed;
	}
	/**
	 * 读取文本文件内容,返回文本文件的内容字符串，以"\n"分割
	 * 
	 * @param filePathAndName
	 *            String 带有完整绝对路径的文件名
	 * @return String 返回文本文件的内容
	 */
	public static String readAll(String filePathAndName) {
		return readAll(filePathAndName, null);
	}

	/**
	 * 读取文本文件内容,返回文本文件的内容字符串，以"\n"分割
	 * 
	 * @param filePathAndName
	 *            String 带有完整绝对路径的文件名
	 * @param encoding
	 *            String 文本文件打开的编码方式
	 * @return String 返回文本文件的内容
	 */
	public static String readAll(String filePathAndName, String encoding) {
		StringBuffer str = new StringBuffer("");
		String st = "";
		FileInputStream fs =null;
		try {
			  fs = new FileInputStream(URLDecoder.decode(filePathAndName));
			InputStreamReader isr;
			if (encoding == null || "".equals(encoding)) {
				isr = new InputStreamReader(fs);
			} else {
				isr = new InputStreamReader(fs, encoding);
			}
			try {
				String data = "";
				BufferedReader br = new BufferedReader(isr);
				while ((data = br.readLine()) != null) {
					str.append(data + "\n");
				}
			} catch (Exception e) {
				return "";
			}
			st = str.toString();
		} catch (IOException es) {
			st = "";
		}finally{
			try {
				if(fs!=null)fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return st;
	}

	/**
	 * 读取第n行文本文件内容
	 * 
	 * @param filePathAndName
	 *            String 带有完整绝对路径的文件名
	 * @param encoding
	 *            String 文本文件打开的编码方式
	 * @return String 返回第一行文本文件内容
	 */
	public static String readLine(String filePathAndName, long rowIndex,
			String encoding) {
		String st = "";
		StringBuffer str = new StringBuffer("");
		long i = 0;
		FileInputStream fs =null;
		try {
			  fs = new FileInputStream(URLDecoder.decode(filePathAndName));
			InputStreamReader isr;
			if (encoding == null || "".equals(encoding)) {
				isr = new InputStreamReader(fs);
			} else {
				isr = new InputStreamReader(fs, encoding);
			}
			BufferedReader br = new BufferedReader(isr);
			try {
				String data = "";
				while ((data = br.readLine()) != null) {
					if (rowIndex == i) {
						str.append(data);
						break;
					} else {
						i++;
					}
				}
			} catch (Exception e) {
				return "";
			}
			st = str.toString();
		} catch (IOException es) {
			return "";
		}finally{
			try {
				if(fs!=null)fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return st;
	}

	/**
	 * 读取第一行文本文件内容
	 * 
	 * @param filePathAndName
	 *            String 带有完整绝对路径的文件名
	 * @return String 返回第一行文本文件内容
	 */
	public static String readLine(String filePathAndName) {
		return readLine(filePathAndName, 0, null);
	}

	/**
	 * 读取第n行文本文件内容
	 * 
	 * @param filePathAndName
	 *            String 带有完整绝对路径的文件名
	 * @return String 返回第n行文本文件内容
	 */
	public static String readLine(String filePathAndName, long rowIndex) {
		return readLine(filePathAndName, rowIndex, null);
	}

	/**
	 * 新建文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String 文件内容
	 * @return boolean 是否创建成功
	 */
	public static boolean newFile(String filePathAndName, String fileContent) {
		return newFile(filePathAndName, fileContent, false);
	}

	/**
	 * 新建文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String 文件内容
	 * @param flag
	 *            boolean 是否追加内容，true为追加，false为新建
	 * @return boolean 是否创建成功
	 */
	public static boolean newFile(String filePathAndName, String fileContent,
			boolean flag) {

		String filePath = filePathAndName;
		try {
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath, flag);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			resultFile.close();
			return true;
		} catch (Exception e) {
			filePath = "";
			System.out.println("新建文件操作出错");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 有编码方式的文件创建
	 * 
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @param fileContent
	 *            文本文件内容
	 * @param encoding
	 *            编码方式 例如 GBK 或者 UTF-8
	 * @return boolean 是否创建成功
	 */
	public static boolean newFile(String filePathAndName, String fileContent,
			String encoding) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			PrintWriter myFile = new PrintWriter(myFilePath, encoding);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
			return true;
		} catch (Exception e) {
			System.out.println("创建文件操作出错");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除文件
	 * 
	 * @param filePathAndName
	 *            String 文件路径及名称 如c:/fqf.txt
	 * @param fileContent
	 *            String
	 */
	public static boolean delFile(String filePathAndName) {
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			java.io.File myDelFile = new java.io.File(filePath);
			return myDelFile.delete();
		} catch (Exception e) {
			System.out.println("删除文件操作出错");
			e.printStackTrace();
           return false;
		}

	}

	/**
	 * 新建目录
	 * 
	 * @param folderPath
	 *            String 如 c:/fqf
	 * @return String
	 */
	public static String newFolder(String folderPath) {
		String filePath = folderPath;
		try {
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdirs();
			}
		} catch (Exception e) {
			System.out.println("新建目录操作出错");
			filePath = "";
			e.printStackTrace();
		}
		return filePath;
	}

	/**
	 * 删除文件夹
	 * 
	 * @param filePathAndName
	 *            String 文件夹路径及名称 如c:/fqf
	 * @param fileContent
	 *            String
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			System.out.println("删除文件夹操作出错");
			e.printStackTrace();

		}

	}

	/**
	 * 删除文件夹里面的所有文件
	 * 
	 * @param path
	 *            String 文件夹路径 如 c:/fqf
	 */
	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		if(file.getAbsolutePath().equalsIgnoreCase("/")){
			System.out.println("此目录为根目录，不能删除所有文件！！！");
			System.out.println("请及时修改此目录！！！");
			return;
		}
		if(file.getAbsolutePath().equalsIgnoreCase("/root")){
			System.out.println("此目录为根目录，不能删除所有文件！！！");
			System.out.println("请及时修改此目录！！！");
			return;
		}
		if(file.getAbsolutePath().equalsIgnoreCase("/usr")||file.getAbsolutePath().equalsIgnoreCase("/opt")
				||file.getAbsolutePath().equalsIgnoreCase("/bin")||file.getAbsolutePath().equalsIgnoreCase("/sbin")
				||file.getAbsolutePath().equalsIgnoreCase("/etc")||file.getAbsolutePath().equalsIgnoreCase("/selinux")
				||file.getAbsolutePath().equalsIgnoreCase("/sys")||file.getAbsolutePath().equalsIgnoreCase("/var")
				||file.getAbsolutePath().equalsIgnoreCase("/home")||file.getAbsolutePath().equalsIgnoreCase("/net")){
			System.out.println("此目录为根目录，不能删除所有文件！！！");
			System.out.println("请及时修改此目录！！！");
			return;
		}
		if(file.getAbsolutePath().equalsIgnoreCase("C://")||file.getAbsolutePath().equalsIgnoreCase("C:\\\\")){
			System.out.println("此目录为C盘根目录，不能删除所有文件！！！");
			System.out.println("请及时修改此目录！！！");
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		if(tempList==null){
			return;
		}
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
			}
		}
	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf.txt
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf.txt
	 */
	public static void copyFile(String oldPath, String newPath) {
		InputStream inStream = null;
		FileOutputStream fs = null;
		try {
			int byteread = 0;
			File oldfile = new File(oldPath);

			if (oldfile.exists()) { // 文件存在时
				inStream = new FileInputStream(oldPath); // 读入原文件
				fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}

			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		} finally {
			try {
				if (fs != null)
					fs.close();
				if (inStream != null)
					inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * 复制整个文件夹内容
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf/ff
	 */
	public static void copyFolder(String oldPath, String newPath) {

		try {
			(new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("复制整个文件夹内容操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 移动文件到指定目录
	 * 
	 * @param oldPath
	 *            String 如：c:/fqf.txt
	 * @param newPath
	 *            String 如：d:/fqf.txt
	 */
	public static void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}

	/**
	 * 移动文件到指定目录
	 * 
	 * @param oldPath
	 *            String 如：c:/fqf.txt
	 * @param newPath
	 *            String 如：d:/fqf.txt
	 */
	public static void moveFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		delFolder(oldPath);
	}

	/**
	 * 多级目录创建
	 * 
	 * @param folderPath
	 *            准备要在本级目录下创建新目录的目录路径 例如 c:myf
	 * @param paths
	 *            无限级目录参数，各级目录以单数线区分 例如 a|b|c
	 * @return String 返回创建文件后的路径 例如 c:myfac
	 */
	public static String createFolders(String folderPath, String paths) {
		String txts = folderPath;
		try {
			String txt;
			txts = folderPath;
			StringTokenizer st = new StringTokenizer(paths, "|");
			for (int i = 0; st.hasMoreTokens(); i++) {
				txt = st.nextToken();
				if (txts.lastIndexOf("/") != -1) {
					txts = newFolder(txts + txt);
				} else {
					txts = newFolder(txts + txt + "/");
				}
			}
		} catch (Exception e) {
			System.out.println("创建多级目录操作出错");
			txts = "";
			e.printStackTrace();
		}
		return txts;
	}

	/**
	 * 多级目录创建
	 * 
	 * @param folderPath
	 *            建立多级目录，一次创建
	 * @return String 返回创建文件后的路径 例如 c:\aa\bbb\cc
	 */
	public static String createFolders(String folderPath) {
		String txts = folderPath;
		try {
			File file = new File(txts);
			if (!file.exists()) {
				file.mkdirs();
			}
		} catch (Exception e) {
			System.out.println("创建多级目录操作出错");
			txts = "";
			e.printStackTrace();
		}
		return txts;
	}

	/**
	 * 判断指定的文件是否存在。
	 * 
	 * @param fileName
	 *            要判断的文件的文件名
	 * @return 存在时返回true，否则返回false。
	 */
	public static boolean isFileExist(String fileName) {
		return new File(fileName).isFile();
	}

	/**
	 * 得到文件夹里面的所有文件
	 * 
	 * @param path
	 *            String 文件夹路径 如 c:/fqf
	 * @return List
	 */
	public static List GetAllFile(String path) {
		List arrList = new ArrayList();
		File file = new File(path);
		if (!file.exists()) {
			return arrList;
		}
		if (!file.isDirectory()) {
			return arrList;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				arrList.add(temp);
			}
			if(temp.isDirectory()){
				List s=GetAllFile(temp.getAbsolutePath());
				arrList.addAll(s);
			}
		}
		return arrList;
	}
 	/**
	 * 得到文件夹里面的所有文件
	 * 
	 * @param path
	 *            String 文件夹路径 如 c:/fqf
	 * @return List
	 */
	public static List<File> GetAllFile(String path,String suffix) {
		List<File> arrList = new ArrayList<File>();
		File file = new File(path);
		if (!file.exists()) {
			return arrList;
		}
		if (!file.isDirectory()) {
			return arrList;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				if(suffix==null||"".equals(suffix))
				arrList.add(temp);
				else {
					String filePath = temp.getAbsolutePath();     
					   if (!suffix.equals("")) {  
					    int begIndex = filePath.lastIndexOf("."); // 最后一个.(即后缀名前面的.)的索引  
					    String tempsuffix = "";  
					  
					    if (begIndex != -1) {  
					     tempsuffix = filePath.substring(begIndex + 1, filePath.length());  
					     if (tempsuffix.equals(suffix)) {  
					    	 arrList.add(temp);
					     }
					    }
					   }
				}
			}
			if(temp.isDirectory()){
				List<File> s=GetAllFile(temp.getAbsolutePath(),suffix);
				arrList.addAll(s);
			}
		}
		return arrList;
	}
	/** 
	  * @param path 
	  *            文件路径 
	  * @param suffix 
	  *            后缀名, 为空则表示所有文件 
	  * @param isdepth 
	  *            是否遍历子目录 
	  * @return list 
	  */  
	 public static List<String> getListFilesName(String path, String suffix, boolean isdepth) {  
	  List<String> lstFileNames = new ArrayList<String>();  
	  File file = new File(path);  
	  return listFileName(lstFileNames, file, suffix, isdepth);  
	 }  
	  
	 private static List<String> listFileName(List<String> lstFileNames, File f, String suffix, boolean isdepth) {  
	  // 若是目录, 采用递归的方法遍历子目录    
	  if (f.isDirectory()) {  
	   File[] t = f.listFiles();  
	     
	   for (int i = 0; i < t.length; i++) {  
	    if (isdepth || t[i].isFile()) {  
	    	listFileName(lstFileNames, t[i], suffix, isdepth);  
	    }  
	   }     
	  } else {  
	   String filePath = f.getAbsolutePath();     
	   if (!suffix.equals("")) {  
	    int begIndex = filePath.lastIndexOf("."); // 最后一个.(即后缀名前面的.)的索引  
	    String tempsuffix = "";  
	  
	    if (begIndex != -1) {  
	     tempsuffix = filePath.substring(begIndex + 1, filePath.length());  
	     if (tempsuffix.equals(suffix)) {  
	      lstFileNames.add(filePath);  
	     }  
	    }  
	   } else {  
	    lstFileNames.add(filePath);  
	   }  
	  }  
	  return lstFileNames;  
	 }  
	/**
	 * 得到文件夹里面的所有文件名
	 * 
	 * @param path
	 *            String 文件夹路径 如 c:/fqf
	 * @return List<String>
	 */
	public static List<String> GetAllFileName(String path) {
		List<String>  arrList = new ArrayList<String> ();
		File file = new File(path);
		if (!file.exists()) {
			return arrList;
		}
		if (!file.isDirectory()) {
			return arrList;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				arrList.add(temp.getName());
			}
		}
		return arrList;
	}
	/**
	 * 得到文件夹里面的所有文件名
	 * 
	 * @param path
	 *            String 文件夹路径 如 c:/fqf
	 * @return Map<String,String>
	 */
	public static Map<String,String> GetAllFileNameByMap(String path) {
		Map<String,String>  arrList = new HashMap<String,String> ();
		File file = new File(path);
		if (!file.exists()) {
			return arrList;
		}
		if (!file.isDirectory()) {
			return arrList;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				arrList.put(temp.getName(), temp.getName());
			}
		}
		return arrList;
	}
	
	/**
	 * 得到文件夹里面的所有文件名
	 * 
	 * @param path
	 *            String 文件夹路径 如 c:/fqf
	 * @return List<String>
	 */
	public static String[] GetAllFileNameByPath(String path) {
		
		File file = new File(path);
		if (!file.exists()) {
			return null;
		}
		if (!file.isDirectory()) {
			return null;
		}
		String[] tempList = file.list();
//		String[]  arrList = null;
		List<String> flist  = new ArrayList<String>();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				flist.add(temp.getName());
			}
		}
		return (String[])flist.toArray(new String[flist.size()]);
	}
	/**
	 * 去掉文件名的后缀
	 * @param fileName
	 * @return String
	 */
	public static String getNameNoSuffix(String fileName){
		if(fileName.lastIndexOf(".")>=0)
    	return fileName.substring(0,fileName.lastIndexOf("."));
		else
			return fileName;
    }
	/**
	 * 返回带扩展名的文件名
	 * 
	 * @param fileName
	 *            文件全路径名
	 * @return shortFileName 文件名称
	 */
	public static String getFileName(String fileName) {
		String shortFileName = fileName;
		shortFileName = shortFileName.replace("\\", "/");
		if (shortFileName.indexOf("/") > -1)
			shortFileName = shortFileName.substring(shortFileName
					.lastIndexOf("/") + 1, shortFileName.length());
		return shortFileName;
	}
	 /**
	  * 判断文件夹是否存在，不存在在创建，如果创建失败，返回false
	  * @param path 文件夹路径
	  */
	 public static boolean isExist(String path) {
	  File file = new File(path);
	  //判断文件夹是否存在,如果不存在则创建文件夹
	  if (!file.exists()) {
	   boolean bn=file.mkdir();
	   if(!bn) FilesUtil.createFolders(path);
	   return bn;
	  }else{
		  return true;
	  }
	 }
	 /**
	  * 判断文件夹是否存在，不存在在创建，如果创建失败，返回false
	  * @param path 文件夹路径
	  */
	 public static boolean isExistNotCreate(String path) {
	  File file = new File(path);
	  //判断文件夹是否存在,如果不存在则创建文件夹
	  if (!file.exists()) {
	   return false;
	  }else{
		  return true;
	  }
	 }
}
