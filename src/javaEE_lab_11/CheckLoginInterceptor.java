package javaEE_lab_11;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String, Object> session =invocation.getInvocationContext().getSession();
		Object currentUser = session.get("user_in_session");
		
		if(currentUser==null) {
			return Action.LOGIN;
		}
		
		return invocation.invoke();
	}

}
