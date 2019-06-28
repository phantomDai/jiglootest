package test;

import cn.edu.ustb.mt4ws.tcg.WsdlOperationFormat;
import cn.edu.ustb.mt4ws.wsdl.parser.WsdlReader11;

import javax.wsdl.*;
import javax.wsdl.extensions.*;
import javax.wsdl.factory.*;
import javax.wsdl.xml.*;
import javax.xml.namespace.QName;

import java.io.*;
import java.util.*;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.*;

public class ZzqTest {

	public static void main(String[] args) {
		String wsUrl = "http://localhost:8080/axis2/services/ATMService?wsdl";// Web
																				// Services'
																				// URL
		// String opName = "transfer";// operation's name
		// WsdlReader11 wsdlreader11=new WsdlReader11();
		// Map<String, WsdlOperationFormat>
		// operationMap=wsdlreader11.parseWSDL(wsUrl);
		// final Set<String> opList = operationMap.keySet();
		// System.out.println("ZzqTest Begin!");
		// //for (String e: opList) {
		// // System.out.println(e);
		// //}
		// WsdlOperationFormat transferFormat = operationMap.get(opName);
		// if (transferFormat != null) {
		// System.out.println("SimpleType information:");
		// System.out.println(transferFormat.getInput().format.simpleTypes.size());
		// System.out.println(transferFormat.getInput().format.printSimpleTypes());
		// System.out.println("ComplexType information:");
		// System.out.println(transferFormat.getInput().format.complexTypes.size());
		// System.out.println(transferFormat.getInput().format.printComplexTypes());
		// } else {}

		File f = new File("temp.xml");
		if (!f.exists()) {
		try {
			WSDLFactory factory = WSDLFactory.newInstance();
			WSDLReader reader = factory.newWSDLReader();
			reader.setFeature("javax.wsdl.verbose", true);
			reader.setFeature("javax.wsdl.importDocuments", true);
			Definition def = reader.readWSDL(wsUrl);
//			Types t = def.getTypes();
//			System.out.println(t);
			Writer xmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("temp.xml")));
			WSDLWriter wsdlWriter = factory.newWSDLWriter();
			wsdlWriter.writeWSDL(def, xmlWriter);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WSDLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		SAXReader dReader = new SAXReader();
		org.dom4j.Document document; 
		try {
			document = dReader.read(new File("temp.xml"));
			org.dom4j.Element root = document.getRootElement();
			org.dom4j.Element typesElement = root.element("types");
			org.dom4j.Element schemaElement = typesElement.element("schema");
			@SuppressWarnings("unchecked")
			List<org.dom4j.Element> elist = (List<org.dom4j.Element>)schemaElement.elements();
			for (org.dom4j.Element e : elist) {
				if (e.attribute("name").getValue().equals("accountNumber")) {
					org.dom4j.Element rElement = e.element("restriction");
					String nativeType = rElement.attribute("base").getValue();
					System.out.println(nativeType);
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
