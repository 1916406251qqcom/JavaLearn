package cn.xdl.action;


public class LoginAction extends BaseAction{
	
	private String username;//��Ӧ<input type="text" name="username">
	private String password;
	private String error;

	public String execute(){
		//����û��������� 
		if("scott".equalsIgnoreCase(username)
			&&"123456".equals(password)){
			//���û���Ϣд��session
			//ʹ��Map��װ�Ķ���
//			ActionContext ac = ActionContext.getContext();
//			Map<String,Object> session = ac.getSession();//HttpSession
//			session.put("user", username);//�ײ�HttpSession.setAttribute("user",username)
//			session.get("user") //HttpSession.getAttribute("user")
//			Map<String,Object> request = ac.get("request");
			//ʹ��ԭ��Servlet���͵�
//			HttpServletRequest httpRequest = ServletActionContext.getRequest();
//			HttpSession session = httpRequest.getSession();
//			session.setAttribute("user", username);
			//ʹ��Aware�ӿڷ���ע���Session
			session.put("user", username);
			
			return "success";
		}
		error = "�û������������";
		return "login";
	}

	
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
}
