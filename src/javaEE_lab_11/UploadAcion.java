package javaEE_lab_11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import load.infoSQL;
import load.infoSQLDAO;

public class UploadAcion extends ActionSupport {

	/**
	 * 
	 */
	public String name;
	public File file;
	public String fileFileName;
	public String fileContentType;

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// 拿到文件的路径用servletContext中的getRealPath获取指定相对路径的绝对路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/up_load");

		System.out.println(realPath);
		// 构建一个目标文件
		// File desFile = new File(realPath,fileFileName);
		// FileUtils.copyFile(file, desFile);

		/**
		 * 读取出上传的文件的内容
		 */

		// File file = new File(realPath);//定义一个file对象，用来初始化FileReader
		FileReader reader = new FileReader(file);// 定义一个fileReader对象，用来初始化BufferedReader
		BufferedReader bReader = new BufferedReader(reader);// new一个BufferedReader对象，将文件内容读取到缓存
		StringBuilder sb = new StringBuilder();// 定义一个字符串缓存，将字符串存放缓存中
		String st = "";
		while ((st = bReader.readLine()) != null) {// 逐行读取文件内容，不读取换行符和末尾的空格
			sb.append(st + "\n");// 将读取的字符串添加换行符后累加存放在缓存中
			System.out.println(st);
		}
		bReader.close();
		String str = sb.toString();
		System.out.println(str);

		// 创建infoSQl对象
		infoSQL test = new infoSQL();
		test.setDetail(str);

		// 存入数据库中
		new infoSQLDAO().AddStudentInfo(test);

		return NONE;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public void setName(String name) {
		this.name = name;
	}

}
