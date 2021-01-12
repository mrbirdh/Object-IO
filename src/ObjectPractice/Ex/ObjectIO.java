package ObjectPractice.Ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import ObjectPractice.Data.Human;
import ObjectPractice.Util.MyUtil;

public class ObjectIO {
	
	private static String PATH = "Human.txt"; //���� ��ġ
	
	//���Ͽ� ������ �����ϴ� �޼���
	public static void write () { 
		Vector<Human> list = new Vector<Human>(); // ������ ������ 	
		list.add(new Human("abc" , 22, "010-1234-5678"));
		list.add(new Human("abcd" , 30, "010-1111-5678"));
		
		FileOutputStream fos = null; 
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(PATH); 
			oos = new ObjectOutputStream(fos);
			
			oos. writeObject(list); //�����͸� ����
			oos.flush(); //����� ���� ������ ���� ����
			oos.reset();
			read(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyUtil.closeAll(oos,fos);
		}
		
	}
	
	//�б� �޼��� 
	public static void read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(PATH);
			ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject(); //���Ͽ� �ִ� �����͸� o�� ����
			
			Vector<?> list = (Vector<?>)o; //Vector�� o�� ������ ����
			for (Object temp : list) { //��� �ִ� ������� �ϳ��ϳ� ���� ���
				System.out.println(temp);
			}
			
		} catch (IOException e) {
			System.out.println("����� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			MyUtil.closeAll(ois, fis);
		}
	}
	
	public static void main(String[] args) {
		write();
//		read();
	}
}
