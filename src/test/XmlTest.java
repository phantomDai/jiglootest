package test;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

public class XmlTest {
	
	public static void main(String[] args) {
		File f = new File("E:\\研究生\\毕业设计\\DRT算法改进\\实验\\停车计费\\测试用例集\\随机1000规模\\testcaseset4RT.xml");
		org.dom4j.io.SAXReader saxReader = new org.dom4j.io.SAXReader();
		Document document = null;
		Element rootElement = null;
		try {
			document = saxReader.read(f);
			rootElement = document.getRootElement();
			java.util.List<Element> testCaseList = rootElement.selectNodes("testCase");
			System.out.println(testCaseList.size());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
