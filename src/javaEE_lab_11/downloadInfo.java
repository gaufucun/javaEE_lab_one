package javaEE_lab_11;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class downloadInfo extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String filename;
	private File file;
	public Student student0 = new Student("0001", "张一", 10);
	public List<Student> list_show = new ArrayList<Student>();
	@Override
	public String execute() throws Exception {

		// 根据传过来的文件名找到对应的文件
		
		String realPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/download_one");
		file = new File(realPath, filename);

		// 找到后到对应页面进行下载
		// 并且不应该只跳转逻辑视图，xml配饰stream
		return SUCCESS;

	}

	// 提供structs2框架来调用的，为了获取到下载的文件数据
	// 将获取的数据响应给浏览器
	public InputStream getInputStream() throws Exception {
		list_show.add(student0);
		
		InputStream stream;

		String lineTxt = null;
		// 将查询的信息下载
		lineTxt=list_show.get(0).id+"  "+list_show.get(0).name+"  "+list_show.get(0).age;


		System.out.println(lineTxt);

		stream = new ByteArrayInputStream(lineTxt.getBytes());

		return stream;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<Student> getList_show() {
		return list_show;
	}

	public void setList_show(List<Student> list_show) {
		this.list_show = list_show;
	}

	
}
