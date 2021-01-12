package ObjectPractice.Util;

import java.io.Closeable;
import java.io.IOException;

public class MyUtil {
	
	public static void closeAll (Closeable... close) {
		for(Closeable temp : close) {
			if (temp != null) {
				try{
					temp.close();
				} catch (IOException e) {}
			}
		}
	}
}
