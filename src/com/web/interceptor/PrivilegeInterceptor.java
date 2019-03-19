package com.web.interceptor;

import java.util.Map;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


public class PrivilegeInterceptor extends MethodFilterInterceptor{
	
	//��У���¼��ע��ķ���
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//���session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//��õ�¼��ʶ
		User user = (User) session.get("user");
		//�жϱ�ʶ�Ƿ����
		if(user!=null){
			//���ڣ�����
			return invocation.invoke();
		}else{
			//�����ڣ���ת			
			return "toLogin";
		}
	}

}
