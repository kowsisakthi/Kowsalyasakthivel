package Properties;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class User {
	public static void main(String[] args) throws Exception {
		File f = new File("C:\\Users\\HP\\Desktop\\User.xml");
		DocumentBuilderFactory b = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = b.newDocumentBuilder();
		Document doc = db.parse(f);
		Element e = doc.getDocumentElement();
		NodeList n1 = e.getChildNodes();

		
		for (int i = 0; i < n1.getLength(); i++) {
			for (int j = 0; j < n1.item(i).getChildNodes().getLength(); j++) {
				String str = e.getChildNodes().item(i).getChildNodes().item(j).getFirstChild().getNodeValue();
				System.out.println("The values are::" + str);
			}

		}

	}

}
