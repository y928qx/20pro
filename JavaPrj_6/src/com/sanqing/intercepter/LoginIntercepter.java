package com.sanqing.intercepter;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sanqing.po.User;

public class LoginIntercepter extends AbstractInterceptor {
	private static final long serialVersionUID = 6203506362291764836L;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx=invocation.getInvocationContext();//���ActionContext����
		Map session=ctx.getSession();		//���session����
		User user = (User)session.get("user");//����û���¼��Ϣ
		if(user != null) {	//�����Ϊ�գ����ʾ�Ѿ���¼
			return invocation.invoke();//����ִ�к���Ĳ���
		}
		return "input";//��ת����¼ҳ��
	}
}
