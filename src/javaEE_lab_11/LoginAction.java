package javaEE_lab_11;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	public String username;
	public String password;
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}



	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception{
		
		if("admin".equals(username)&&"1234".equals(password)) {
			//将获取的用户名密码存放在session中
			ServletActionContext.getRequest().getSession().setAttribute("user_in_session", username);
			
			return "success";
		}
		
		return Action.LOGIN;
		
	}
	@Override
	public void validate() {
		//完成数据校验
		if(username==null||username.trim().length()<3||username.trim().length()>10) {
			super.addFieldError(username, "用户账号不能为空长度需小于10");
			System.out.println("用户账号不能为空长度需小于10");
		}
		if(password==null||password.trim().length()<3||password.trim().length()>10) {
			super.addFieldError(password, "密码不能为空（长度大于3小于10）");
			System.out.println("密码不能为空（长度大于3小于10）");
		}
	}

}
