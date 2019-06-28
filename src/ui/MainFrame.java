package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

import cn.edu.ustb.mt4ws.tcg.WsdlOperationFormat;
import cn.edu.ustb.mt4ws.wsdl.parser.WsdlReader11;
import cn.edu.ustb.webservicetester.controllor.ParseWsdlControllor;
import cn.edu.ustb.webservicetester.util.WsdlParser;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MainFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JTextField jTextField_wsdl;
	private AbstractAction ResetWSDLAction;
	private AbstractAction ParseWSDLAction;
	private JButton jButton_wsdlreset;
	private JButton jButton_wsdlJIEXI;
	private JLabel jLabel_wsdl;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("服务定位");
			this.setResizable(false);//关闭最大化
			GridLayout thisLayout = new GridLayout(1, 1);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBackground(new java.awt.Color(228,236,243));
				jPanel1.setPreferredSize(new java.awt.Dimension(403, 275));
				jPanel1.setLayout(null);
				{
					jTextField_wsdl = new JTextField();
					jPanel1.add(jTextField_wsdl);
					jTextField_wsdl.setBounds(20, 65, 347, 24);
					jTextField_wsdl.setText("http://localhost:8080/axis2/services/AddService?wsdl");
				}
				{
					jLabel_wsdl = new JLabel();
					jPanel1.add(jLabel_wsdl);
					jLabel_wsdl.setText("\u8bf7\u8f93\u5165\u5f85\u6d4b\u670d\u52a1\u5730\u5740");
					jLabel_wsdl.setBounds(18, 28, 122, 17);
				}
				{
					jButton_wsdlJIEXI = new JButton();
					jPanel1.add(jButton_wsdlJIEXI);
					jButton_wsdlJIEXI.setText("\u89e3  \u6790");
					jButton_wsdlJIEXI.setBounds(60, 157, 80, 30);
					jButton_wsdlJIEXI.setAction(getParseWSDLAction());
				}
				{
					jButton_wsdlreset = new JButton();
					jPanel1.add(jButton_wsdlreset);
					jButton_wsdlreset.setText("\u91cd  \u7f6e");
					jButton_wsdlreset.setBounds(244, 157, 80, 30);
					jButton_wsdlreset.setAction(getResetWSDLAction());
				}
			}
			pack();
			this.setSize(412, 311);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private AbstractAction getParseWSDLAction() {
		if(ParseWSDLAction == null) {
			ParseWSDLAction = new AbstractAction("\u89e3  \u6790", null) {
				public void actionPerformed(ActionEvent evt) {
					String wsdlurl = jTextField_wsdl.getText();
					ParseWsdlControllor parseControllor = new ParseWsdlControllor();
					parseControllor.parseWsdlControl(wsdlurl);
//					Object o = evt.getSource();
//					JButton sourceButton = (JButton)o;
//					System.out.println(sourceButton.getParent().getParent() instanceof JFrame);
//					WsdlParser parser = new WsdlParser();
//					java.util.List opInfoList = parser.parseWsdl(wsdlurl);
//					final Set<String> opList = operationMap.keySet();
//					SwingUtilities.invokeLater(new Runnable() {
//						public void run() {
//							OperationSelectFrame inst = new OperationSelectFrame(opList);
//							inst.setLocationRelativeTo(null);
//							inst.setVisible(true);
//						}
//					});
					
				}
			};
		}
		return ParseWSDLAction;
	}
	
	private AbstractAction getResetWSDLAction() {
		if(ResetWSDLAction == null) {
			ResetWSDLAction = new AbstractAction("\u91cd  \u7f6e", null) {
				public void actionPerformed(ActionEvent evt) {
					jTextField_wsdl.setText("");
				}
			};
		}
		return ResetWSDLAction;
	}

}
