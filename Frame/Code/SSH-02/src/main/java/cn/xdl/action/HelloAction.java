package cn.xdl.action;

import org.apache.struts2.ServletActionContext;

public class HelloAction {

	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	//Ĭ�Ϸ�����Ϊexecute,�޲�
	public String execute(){
		ServletActionContext.getRequest().setAttribute("msg", "Request����");
		System.out.println("����HelloAction����");
		msg = "Hello World";
		return "success";//��<result>���ö�Ӧ
	}
	
}
