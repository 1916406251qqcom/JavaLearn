package cn.xdl.action;


import org.springframework.stereotype.Controller;

@Controller//Ĭ��id��ΪhelloAction
public class HelloAction {
	
	public String execute(){
		System.out.println("����HelloAction");
		return "success";
	}
	
}
