package AAA;

import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class TestDomXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStream input = new FileInputStream(new File("C:\\Users\\m1380\\OneDrive\\Desktop\\test.xml")); // "c://book.xml)
																				// //Main.class.getResourceAsStream("/book.xml");

//			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //design pattern: factory 
//			DocumentBuilder db = dbf.newDocumentBuilder(); //工人
//			Document doc = db.parse(input);
//			
//			NodeList nList = doc.getElementsByTagName("book");
//	        System.out.println("----------------------------");
//	         
//	         for (int temp = 0; temp < nList.getLength(); temp++) {
//	            Node nNode = nList.item(temp);
//	            printNode(nNode,0);
//	         }
			
//			SAXParserFactory spf = SAXParserFactory.newInstance();
////			javax.xml.parsers.SAXParser saxParser = spf.newSAXParser();
////			saxParser.parse(input, new MyHandler());
			
			
			JacksonXmlModule module = new JacksonXmlModule();
			XmlMapper mapper = new XmlMapper(module);
			Book book = mapper.readValue(input, Book.class);
			System.out.println(book.id);
			System.out.println(book.name);
			System.out.println(book.author);
			System.out.println(book.isbn);
			System.out.println(book.tags);
			System.out.println(book.pubDate);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	


}

class MyHandler extends DefaultHandler {
    public void startDocument() throws SAXException {
        print("start document");
    }

    public void endDocument() throws SAXException {
        print("end document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        print("start element:", localName, qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        print("end element:", localName, qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        print("characters:", new String(ch, start, length));
    }

    public void error(SAXParseException e) throws SAXException {
        print("error:", e);
    }

    void print(Object... objs) {
        for (Object obj : objs) {
            System.out.print(obj);
            System.out.print(" ");
        }
        System.out.println();
    }
}
