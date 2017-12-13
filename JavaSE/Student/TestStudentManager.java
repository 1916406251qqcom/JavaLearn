package xdl.day19.student;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class TestStudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//����һ���������ڴ洢����ѧ����Ϣ
			List<Student> list = new LinkedList<Student>();
			
			//����DaoStudent���͵Ķ��󣬸����ļ��е��������ݶ�ȡ��������
			DaoStudent ds = new DaoStudent(list);
			try{	
				list = ds.read();
			}catch(FileNotFoundException e){
				//e.printStackTrace();
			}
			
			ManagerStudent ms = new ManagerStudent(list);
			ViewStudent vs = new ViewStudent(ms);
			vs.show();
			
			ds.write();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
