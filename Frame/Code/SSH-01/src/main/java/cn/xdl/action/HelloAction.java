package cn.xdl.action;

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
		System.out.println("����HelloAction����");
		msg = "Hello World";
		return "success";//��<result>���ö�Ӧ
	}
	
}
