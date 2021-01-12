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
	
	private static String PATH = "Human.txt"; //파일 위치
	
	//파일에 정보를 저장하는 메서드
	public static void write () { 
		Vector<Human> list = new Vector<Human>(); // 저장할 데이터 	
		list.add(new Human("abc" , 22, "010-1234-5678"));
		list.add(new Human("abcd" , 30, "010-1111-5678"));
		
		FileOutputStream fos = null; 
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(PATH); 
			oos = new ObjectOutputStream(fos);
			
			oos. writeObject(list); //데이터를 저장
			oos.flush(); //저장된 내용 보내고 내용 삭제
			oos.reset();
			read(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyUtil.closeAll(oos,fos);
		}
		
	}
	
	//읽기 메서드 
	public static void read() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(PATH);
			ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject(); //파일에 있는 데이터를 o에 대입
			
			Vector<?> list = (Vector<?>)o; //Vector에 o의 정보가 대입
			for (Object temp : list) { //들어 있는 내용들을 하나하나 빼서 출력
				System.out.println(temp);
			}
			
		} catch (IOException e) {
			System.out.println("입출력 오류");
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
