import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class JAXPSample {
	private String filename = "books.xml";
	private Document doc = null;

	public JAXPSample() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();
			doc = parser.parse(filename);
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
	}

	public void printBooks() {
		try {
			NodeList books = doc.getElementsByTagName("book");
			if (books != null) {
				for (int i = 0; i < books.getLength(); i++) {
					Node book = books.item(i);
					String author = book.getAttributes().getNamedItem("author")
							.getNodeValue();
					String email = book.getAttributes().getNamedItem("email")
							.getNodeValue();
					NodeList bookinfo = book.getChildNodes();
					String title = null;
					String description = null;
					for (int j = 0; j < bookinfo.getLength(); j++) {
						if (bookinfo.item(j).getNodeName().equalsIgnoreCase(
								"title")) {
							title = bookinfo.item(j).getTextContent();
						} else if (bookinfo.item(j).getNodeName()
								.equalsIgnoreCase("description")) {
							description = bookinfo.item(j).getTextContent();
						}
					}
					System.out.println("'" + title + "' by " + "author(" + email
							+ ")��	" + description);
				}
			}
		} catch (Exception e) {
			System.err.println("Exception�� " + e.getMessage());
		}
	}

	public void addBook() {
		try {
			Element root = doc.getDocumentElement();
			Element book = doc.createElement("book");
			root.appendChild(book);
			book.setAttribute("author", "robert");
			book.setAttribute("email", "robert@press.com");
			Element title = doc.createElement("title");
			String str_title = "Keep Smile on Your Face";
			Text t_title = doc.createTextNode(str_title);
			title.appendChild(t_title);	
			book.appendChild(title);
			Element description = doc.createElement("description");
			String str_desc = "Robert will show you amazing effect of smiling.";
			Text t_desc = doc.createTextNode(str_desc);
			description.appendChild(t_desc);
			book.appendChild(description);			
			// Prepare the DOM document for writing
			Source source = new DOMSource(doc);
			// Prepare the output file
			File file = new File(filename);
			Result result = new StreamResult(file);
			// Write the DOM document to the file
			Transformer xformer = TransformerFactory.newInstance()
					.newTransformer();
			xformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			System.err.println("Exception�� " + e.getMessage());
		} catch (TransformerException e) {
			System.err.println("Exception�� " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		JAXPSample application = new JAXPSample();
		application.printBooks();
		application.addBook();
		application.printBooks();
	}
}
