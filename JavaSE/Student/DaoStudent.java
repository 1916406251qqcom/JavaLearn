package xdl.day19.student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DaoStudent {
	//����һ���������͵����ã�ͨ�����췽�����������ϴ���
	private List<Student> list;
	
	public DaoStudent(List<Student> list){
		this.list = list;
	}
	
	//�Զ��巽��ʵ�ֽ���������д�뵽�ļ���
	public void write() throws IOException{
		//1.����/����ļ�
		FileOutputStream fos = new FileOutputStream("./student.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//2.���������ϵ�ѧ����Ϣ��д�뵽�ļ���
		oos.writeObject(list);
		System.out.println("д�����ݵ��ļ��ɹ���");
		//3.�ر���ص������ļ�
		oos.flush();
		oos.close();
		fos.close();
	}
	
	//�Զ��巽��ʵ�ֶ�ȡ�ļ��е�����ѧ����Ϣ
	@SuppressWarnings("unchecked")
	public List<Student> read() throws IOException, ClassNotFoundException{
		//1.���ļ�
		FileInputStream fis = new FileInputStream("./student.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		//2.���ļ��е�����ѧ����Ϣ����ȡ����
		list = (List<Student>) ois.readObject();
		for(Student s : list){
			System.out.println(s);
		}
		System.out.println("��ȡ�ļ��е����ݳɹ���");
		//3.�ر���ص������ļ�
		ois.close();
		return list;
	}
}
