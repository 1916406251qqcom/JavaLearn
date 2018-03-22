package cn.xdl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableUtil {
	
	/**
	 * ���л�����
	 * @param obj ����
	 * @return �ֽ�����
	 * @throws IOException 
	 */
	public static byte[] toSerialize(Object obj) throws Exception{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		byte[] bytes = bos.toByteArray();
		oos.close();
		bos.close();
		return bytes;
	}
	
	/**
	 * �����л�����
	 * @param bytes �ֽ�����
	 * @return ����
	 * @throws IOException 
	 */
	public static Object toObject(byte[] bytes) throws Exception{
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object obj = ois.readObject();
		ois.close();
		bis.close();
		return obj;
	}
	
}
