package JavaBasic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReaderWriter {
	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("E://testdata.txt");
		BufferedReader br = new BufferedReader(reader);
		String[] line = br.readLine().split(" ");
		
		FileWriter writer = new FileWriter("E://testdata2.txt");
		BufferedWriter bw = new BufferedWriter(writer);
		String str;
		str = line[0] + " " + line[1] + " " + line[2] + "\n";
		bw.append(str);
		for (int i = 3; i < line.length; i++) {
			str = line[i] + " " + line[i+1]  + "\n";
			i++;
			bw.append(str);
		}
		
		br.close();
		bw.close();
	}
}
