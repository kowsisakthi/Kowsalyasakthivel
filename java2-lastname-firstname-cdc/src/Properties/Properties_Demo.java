package Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties_Demo {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\HP\\Desktop\\Rk.properties");
		FileWriter w = new FileWriter(f);
		//FileInputStream fi = new FileInputStream(f);
		Properties p = new Properties();
		p.setProperty("kavi", "prasanna");
		p.setProperty("kowsi", "Ranjith");
		p.store(w, "this is my new file");
		//FileOutputStream o= new FileOutputStream(f);
		//p.save(o, null);
		p.remove("kavi");
		p.remove("kowsi");
		p.store(w,null);
		p.clear();
		
	//	p.store(w, null);
		// p.load(fi);
//		//System.out.println(p.getProperty("kowsi"));
//		FileOutputStream fo= new FileOutputStream(f);
//		p.store(fo, "kalai");

		// p.clear();
	}

}
