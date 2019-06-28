package ui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cn.edu.ustb.webservicetester.model.OperationInfo;
import cn.edu.ustb.webservicetester.model.ParameterInfo;
import cn.edu.ustb.webservicetester.model.TestCase;
import cn.edu.ustb.webservicetester.model.TestSet;
import cn.edu.ustb.webservicetester.util.TestSetFileParser;
import test.TestJFileChooseer.MyFileFilter;


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
public class TestSettingFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton nextPageJButton;
	private JRadioButton addTestCaseAutoRadioButton;
	private AbstractAction importTestCaseAction;
	private JButton addTestCaseAutoAdvancedSettingJButton;
	private JButton addTestCaseAutoBeginJButton;
	private JLabel addTestCaseAutoLabel2;
	private JTextField addTestCaseAutoTextField;
	private JLabel addTestCaseAutoLabel1;
	private JButton importTestCaseAddButton;
	private JButton importTestCaseScanButton;
	private JTextField importTestCaseTextField;
	private ButtonGroup buttonGroup1;
	private JRadioButton addTestCaseImportJRadioButton;
	private JLabel jLabel1;
	private JButton prePageButton;
	private JComboBox selectPageComboBox;
	private JScrollPane testSetDemoJScrollPane;
	private JTable testSetDemoJTable;
	private DefaultTableModel testSetDemoTableModel;
	private java.util.List<ParameterInfo> paraInfoList = null;
	private AbstractAction abstractAction1;
	private TestSet testSet = null;
	private OperationInfo operationInfo;
	private java.util.Map<String, String> testSetting = null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TestSettingFrame inst = new TestSettingFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TestSettingFrame() {
		super();
		initGUI();
	}
	
	public TestSettingFrame(java.util.Map<String, String> testSettingMap, OperationInfo operInfo) {
		super();
		testSetting = testSettingMap;
		initGUI(operInfo);
	}
	
	private void initGUI() {
		initGUI(null);
	}
	
	private void initGUI(OperationInfo oi) {
		operationInfo = oi;
		paraInfoList = operationInfo.getParaList();
		try {
			setTitle("测试配置");
			setResizable(false);
			GridLayout thisLayout = new GridLayout(1, 1);
			getContentPane().setLayout(thisLayout);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(228,236,243));
				{
					testSetDemoJScrollPane = new JScrollPane();
					jPanel1.add(testSetDemoJScrollPane);
					jPanel1.add(getNextPageJButton());
					jPanel1.add(getSelectPageComboBox());
					jPanel1.add(getPrePageButton());
					jPanel1.add(getJLabel1());
					jPanel1.add(getAddTestCaseImportJRadioButton());
					jPanel1.add(getAddTestCaseAutoRadioButton());
					jPanel1.add(getImpotyTestCaseTextField());
					jPanel1.add(getImportTestCaseScanButton());
					jPanel1.add(getImportTestCaseAddButton());
					jPanel1.add(getAddTestCaseAutoLabel1());
					jPanel1.add(getAddTestCaseAutoTextField());
					jPanel1.add(getAddTestCaseAutoLabel2());
					jPanel1.add(getAddTestCaseAutoBeginJButton());
					jPanel1.add(getAddTestCaseAutoAdvancedSettingJButton());
					getButtonGroup1();
					addTestCaseImportJRadioButton.setSelected(true);
					testSetDemoJScrollPane.setBounds(12, 12, 470, 183);
					testSetDemoJScrollPane.setViewportView(getTestSetDemoJTable());
				}
			}
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(500, 444);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JTable getTestSetDemoJTable() {
		if (testSetDemoJTable == null) {
			java.util.List<String> nl = new java.util.LinkedList<String>();
			nl.add("id");
			for (ParameterInfo pi : paraInfoList) {
				nl.add(pi.getName());
			}
			nl.add("expected result");
			String[] name = new String[nl.size()];
			nl.toArray(name);
			String[] a = {""};
			String[][] data = {a};
			testSetDemoTableModel = new DefaultTableModel(data, name);
			testSetDemoJTable = new JTable(testSetDemoTableModel) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			int w = testSetDemoJTable.getTableHeader().getWidth();
			testSetDemoJTable.getTableHeader().setSize(w, 17);
			testSetDemoJTable.setRowHeight(17);
		}
		return testSetDemoJTable;
	}
	
	private JButton getNextPageJButton() {
		if(nextPageJButton == null) {
			nextPageJButton = new JButton();
			nextPageJButton.setText("\u4e0b\u4e00\u9875");
			nextPageJButton.setBounds(393, 211, 90, 24);
			nextPageJButton.setAction(getAbstractAction1());
		}
		return nextPageJButton;
	}
	
	private JComboBox getSelectPageComboBox() {
		if(selectPageComboBox == null) {
			ComboBoxModel selectPageComboBoxModel = 
					new DefaultComboBoxModel(
							new String[] { "第 1 页", "第 2 页" });
			selectPageComboBox = new JComboBox();
			selectPageComboBox.setModel(selectPageComboBoxModel);
			selectPageComboBox.setBounds(279, 211, 88, 24);
			selectPageComboBox.setEditable(true);
		}
		return selectPageComboBox;
	}
	
	private JButton getPrePageButton() {
		if(prePageButton == null) {
			prePageButton = new JButton();
			prePageButton.setText("\u4e0a\u4e00\u9875");
			prePageButton.setBounds(164, 211, 90, 24);
		}
		return prePageButton;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("\u5171 0 \u6761\u6d4b\u8bd5\u7528\u4f8b");
			jLabel1.setBounds(12, 205, 134, 21);
			jLabel1.setForeground(new java.awt.Color(255,0,0));
		}
		return jLabel1;
	}
	
	private JRadioButton getAddTestCaseImportJRadioButton() {
		if(addTestCaseImportJRadioButton == null) {
			addTestCaseImportJRadioButton = new JRadioButton();
			addTestCaseImportJRadioButton.setText("\u5bfc\u5165\u6587\u4ef6");
			addTestCaseImportJRadioButton.setBounds(12, 275, 80, 21);
			addTestCaseImportJRadioButton.setBackground(new java.awt.Color(252,252,203));
			addTestCaseImportJRadioButton.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent evt) {
					addTestCaseImportJRadioButtonStateChanged(evt);
				}
			});
		}
		return addTestCaseImportJRadioButton;
	}

	private JRadioButton getAddTestCaseAutoRadioButton() {
		if(addTestCaseAutoRadioButton == null) {
			addTestCaseAutoRadioButton = new JRadioButton();
			addTestCaseAutoRadioButton.setText("\u81ea\u52a8\u6dfb\u52a0");
			addTestCaseAutoRadioButton.setBounds(12, 345, 80, 21);
			addTestCaseAutoRadioButton.setBackground(new java.awt.Color(252,252,203));
		}
		return addTestCaseAutoRadioButton;
	}
	
	private ButtonGroup getButtonGroup1() {
		if(buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		buttonGroup1.add(addTestCaseImportJRadioButton);
		buttonGroup1.add(addTestCaseAutoRadioButton);
		return buttonGroup1;
	}
	
	private JTextField getImpotyTestCaseTextField() {
		if(importTestCaseTextField == null) {
			importTestCaseTextField = new JTextField();
			importTestCaseTextField.setBounds(97, 274, 206, 24);
		}
		return importTestCaseTextField;
	}
	
	private JButton getImportTestCaseScanButton() {
		if(importTestCaseScanButton == null) {
			importTestCaseScanButton = new JButton();
			importTestCaseScanButton.setText("\u6d4f\u89c8");
			importTestCaseScanButton.setBounds(303, 274, 54, 24);
			importTestCaseScanButton.setFont(new java.awt.Font("微软雅黑",0,10));
			final javax.swing.JFrame parentFrame = this;
			importTestCaseScanButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					JFileChooser jf = new JFileChooser();
					jf.setApproveButtonText("导入");
					jf.setCurrentDirectory(new File("."));
					jf.setMultiSelectionEnabled(false);
					jf.setFileFilter(new MyFileFilter("xml"));
					jf.setDialogTitle("请选择要导入的测试集文件");
					jf.showOpenDialog(parentFrame);
					File f = jf.getSelectedFile();
					if (f != null) {
						importTestCaseTextField.setText(f.getPath());
					}
				}
			});
		}
		return importTestCaseScanButton;
	}
	
	private JButton getImportTestCaseAddButton() {
		if(importTestCaseAddButton == null) {
			importTestCaseAddButton = new JButton();
			importTestCaseAddButton.setText("\u5bfc\u5165");
			importTestCaseAddButton.setBounds(360, 274, 54, 24);
			importTestCaseAddButton.setFont(new java.awt.Font("微软雅黑",0,10));
			importTestCaseAddButton.setAction(getImportTestCaseAction());
		}
		return importTestCaseAddButton;
	}

	private JLabel getAddTestCaseAutoLabel1() {
		if(addTestCaseAutoLabel1 == null) {
			addTestCaseAutoLabel1 = new JLabel();
			addTestCaseAutoLabel1.setText("\u6dfb\u52a0");
			addTestCaseAutoLabel1.setBounds(97, 347, 30, 17);
		}
		return addTestCaseAutoLabel1;
	}
	
	private JTextField getAddTestCaseAutoTextField() {
		if(addTestCaseAutoTextField == null) {
			addTestCaseAutoTextField = new JTextField();
			addTestCaseAutoTextField.setBounds(133, 344, 56, 24);
			addTestCaseAutoTextField.setToolTipText("\u81ea\u52a8\u751f\u6210\u6d4b\u8bd5\u7528\u4f8b\u7684\u6570\u91cf");
			addTestCaseAutoTextField.setHorizontalAlignment(JTextField.RIGHT);
			addTestCaseAutoTextField.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					char kc = evt.getKeyChar();
					if (addTestCaseAutoTextField.getText().length() == 0 && kc >= KeyEvent.VK_1 && kc <=  KeyEvent.VK_9) {
						;
					} else if (addTestCaseAutoTextField.getText().length() > 0 && addTestCaseAutoTextField.getText().length() < 6 && kc >= KeyEvent.VK_0 && kc <=  KeyEvent.VK_9) {
						;
					} else {
						evt.consume();
					}
				}
			});
			addTestCaseAutoTextField.setEnabled(false);
		}
		return addTestCaseAutoTextField;
	}
	
	private JLabel getAddTestCaseAutoLabel2() {
		if(addTestCaseAutoLabel2 == null) {
			addTestCaseAutoLabel2 = new JLabel();
			addTestCaseAutoLabel2.setText("\u6761\u6d4b\u8bd5\u7528\u4f8b");
			addTestCaseAutoLabel2.setBounds(197, 347, 70, 17);
		}
		return addTestCaseAutoLabel2;
	}
	
	private JButton getAddTestCaseAutoBeginJButton() {
		if(addTestCaseAutoBeginJButton == null) {
			addTestCaseAutoBeginJButton = new JButton();
			addTestCaseAutoBeginJButton.setText("\u5f00\u59cb");
			addTestCaseAutoBeginJButton.setBounds(290, 345, 90, 24);
			addTestCaseAutoBeginJButton.setEnabled(false);
		}
		return addTestCaseAutoBeginJButton;
	}
	
	private JButton getAddTestCaseAutoAdvancedSettingJButton() {
		if(addTestCaseAutoAdvancedSettingJButton == null) {
			addTestCaseAutoAdvancedSettingJButton = new JButton();
			addTestCaseAutoAdvancedSettingJButton.setText("\u9ad8\u7ea7\u8bbe\u7f6e");
			addTestCaseAutoAdvancedSettingJButton.setBounds(393, 345, 90, 24);
			addTestCaseAutoAdvancedSettingJButton.setFont(new java.awt.Font("微软雅黑",0,10));
			addTestCaseAutoAdvancedSettingJButton.setEnabled(false);
		}
		return addTestCaseAutoAdvancedSettingJButton;
	}
	
	private AbstractAction getImportTestCaseAction() {
		if(importTestCaseAction == null) {
			importTestCaseAction = new AbstractAction("\u5bfc\u5165", null) {
				public void actionPerformed(ActionEvent evt) {
					File f = new File(importTestCaseTextField.getText());
					TestSetFileParser tsfp = new TestSetFileParser();
					tsfp.setParaInfoList(paraInfoList);
					testSet = tsfp.parseFile(importTestCaseTextField.getText());
					for (int i = 0; i < testSet.numOfTestCases(); ++i) {
						TestCase tc = testSet.get(i);
						java.util.List<String> pValueList = new java.util.ArrayList<String>(paraInfoList.size() + 2);
						pValueList.add(new Integer(tc.getId()).toString());
						for (ParameterInfo pi : paraInfoList) {
							pValueList.add(tc.getValueOfParameter(pi));
						}
						pValueList.add(tc.getExpectedResult());
						String[] pValueArray = new String[pValueList.size()];
						pValueList.toArray(pValueArray);
						for (String pv : pValueArray) {
							System.out.println(pv);
						}
						testSetDemoTableModel.addRow(pValueArray);
					}
				}
			};
		}
		return importTestCaseAction;
	}
	
	private AbstractAction getAbstractAction1() {
		if(abstractAction1 == null) {
			abstractAction1 = new AbstractAction("\u4e0b\u4e00\u9875", null) {
				public void actionPerformed(ActionEvent evt) {
					if (testSet != null) {
						String testStrategy = testSetting.get("Test Strategy");
						testSetting.put("Test Set", importTestCaseTextField.getText());
//						for (int i = 1; i <= 6; ++i) {
//							testSettingMap.put(new Integer(i).toString(), new Character((char)('a' + i)).toString());
//						}
						System.out.println(testStrategy);
						if ("Random Testing".equals(testStrategy)) {
							ExecutionFrame ef = new ExecutionFrame(testSetting, operationInfo, testSet);
							ef.setLocationRelativeTo(null);
							ef.setVisible(true);
						} else if ("Dynamic Random Testing".equals(testStrategy)){
							System.out.println("??");
							PartitionSettingFrame2 psf = new PartitionSettingFrame2(testSetting, operationInfo, testSet);
							psf.setLocationRelativeTo(null);
							psf.setVisible(true);
						} else {
							System.out.println("?");// do nothing temporary
						}
					} else {
						
					}
				}
			};
		}
		return abstractAction1;
	}
	
	private void addTestCaseImportJRadioButtonStateChanged(ChangeEvent evt) {
		System.out.println("addTestCaseImportJRadioButton.stateChanged, event="+evt);
		if (addTestCaseImportJRadioButton.isSelected()) {
			importTestCaseTextField.setEnabled(true);
			importTestCaseScanButton.setEnabled(true);
			importTestCaseAddButton.setEnabled(true);
			addTestCaseAutoTextField.setEnabled(false);
			addTestCaseAutoBeginJButton.setEnabled(false);
			addTestCaseAutoAdvancedSettingJButton.setEnabled(false);
		} else {
			importTestCaseTextField.setEnabled(false);
			importTestCaseScanButton.setEnabled(false);
			importTestCaseAddButton.setEnabled(false);
			addTestCaseAutoTextField.setEnabled(true);
			addTestCaseAutoBeginJButton.setEnabled(true);
			addTestCaseAutoAdvancedSettingJButton.setEnabled(true);
		}
	}

}
