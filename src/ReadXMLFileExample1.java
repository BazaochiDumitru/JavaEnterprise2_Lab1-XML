import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXMLFileExample1 {
    public static void main(String argv[])
    {
        try
        {
            //crearea unui constructor al clasei de fișiere și analizarea unui fișier XML
            File file = new File("XMLFile.xml");

            // Crearea unei instanțe a generatorului de documente
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            // Crearea unei instanțe a constructorului pentru a analiza fișierul XML specificat
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            // Afișarea numelui elementului rădăcină
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // Obținerea unei liste de noduri pentru elementul "student"
            NodeList nodeList = doc.getElementsByTagName("student");

            // Iterarea prin lista de noduri
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    // Conversia nodului la un element
                    Element eElement = (Element) node;

                    // Afișarea detaliilor despre student
                    System.out.println("Student id: "+ eElement.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("First Name: "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name: "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Subject: "+ eElement.getElementsByTagName("subject").item(0).getTextContent());
                    System.out.println("Marks: "+ eElement.getElementsByTagName("marks").item(0).getTextContent());
                }
            }
        }
        catch (Exception e)
        {
            // Afișarea oricăror excepții care pot apărea
            e.printStackTrace();
        }
    }
}