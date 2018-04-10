package cn.xdl.result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

public class MyResult implements Result{
	
	private String url;
	

	public void execute(ActionInvocation invocation) throws Exception {
		//��дת���߼�
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		request.getRequestDispatcher(url).forward(request, response);
		System.out.println("����MyResult������ת��:"+url);
	}


	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



}
