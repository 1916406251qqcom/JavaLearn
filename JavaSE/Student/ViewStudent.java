package xdl.day19.student;

import java.util.Scanner;

public class ViewStudent {
	
	private ManagerStudent ms;
	
	public ViewStudent(ManagerStudent ms){
		this.ms = ms;
	}
	
	//ʵ�ִ�ӡ������ķ���
	public void show() throws Exception{
		
		while(true){
			System.out.println("\n\n\t       ѧ����Ϣ����ϵͳ");
			System.out.println("-------------------------------------------");
			System.out.print("   [1] ����ѧ����Ϣ");
			System.out.println("         [2] ɾ��ѧ����Ϣ");
			System.out.print("   [3] �޸�ѧ����Ϣ");
			System.out.println("         [4] ����ѧ����Ϣ");
			System.out.print("   [5] ��ʾѧ����Ϣ");
			System.out.println("         [0] �˳�ѧ��ϵͳ");
			System.out.println("-------------------------------------------");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("��ѡ������ҵ����:");
			int choose = sc.nextInt();
			
			switch(choose){
				case 1: ms.addStudent(); break;
				case 2: ms.delStudent(); break;
				case 3: ms.modifyStudent(); break;
				case 4: ms.findStudent(); break;
				case 5: ms.printStudent(); break;
				case 0: return;
				default:System.out.println("�����������������");
			}
		}
	}
}
