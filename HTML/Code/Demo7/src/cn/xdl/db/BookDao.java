package cn.xdl.db;

import java.util.List;

import cn.xdl.bean.Book;

public interface BookDao {
	
	/**
	 * ������ѯ����ͼ��ķ���
	 * @return ��ѯ����һ��ͼ���б�
	 */
	List<Book> findAll();
	/**
	 * ������ѯ����ͼ��ķ���
	 * @param id Ҫ��ѯ��ͼ��id
	 * @return ��ѯ����ͼ��������null , null��ʾid������!
	 */
	Book findBookById(int id);
	/**
	 * ����ͼ��id , �޸ĵ���ͼ����Ϣ
	 * @param id Ҫ�޸ĵ�ͼ���id
	 * @param book �µ�ͼ����Ϣ
	 * @return �޸ĵĽ��, true��ʾ�޸ĳɹ�, false��ʾ�޸�ʧ��
	 */
	boolean updateBookById(int id,Book book);
	/**
	 * ����ͼ��id ,ɾ��һ��ͼ��
	 * @param id Ҫɾ����ͼ��id
	 * @return ɾ���Ľ�� true��ʾɾ���ɹ�, false��ʾɾ��ʧ��
	 */
	boolean deleteBookById(int id);
	/**
	 * �����ݿ��м���һ���µ�ͼ�����
	 * @param book Ҫ������µ�ͼ�����
	 * @return ����Ľ��, true��ʾ��ӳɹ�, false��ʾ���ʧ��
	 */
	boolean insertBook(Book book);
	
}
