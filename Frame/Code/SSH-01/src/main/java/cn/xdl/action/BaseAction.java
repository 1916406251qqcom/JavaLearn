package cn.xdl.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware,ServletRequestAware{

	protected Map<String,Object> session;
	protected HttpServletRequest httpRequest;
	
	//����Action����ʱ���ײ���Զ�����setSession������ע��session
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		httpRequest = request;
	}
}
