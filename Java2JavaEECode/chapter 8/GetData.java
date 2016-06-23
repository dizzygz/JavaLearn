package JavaBeanWeb;
import java.io.*;
public class GetData {
	int heightArray[] = new int[5];

	public int[] getHightArray() {
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(
					"c:\\temp\\ColumnHeightArray.txt", "r");
			for (int i = 0; i < 5; i++) {
				heightArray[i] = Integer.parseInt(randomAccessFile.readLine());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return heightArray;
	}
}
