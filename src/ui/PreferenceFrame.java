package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.edu.ustb.webservicetester.model.OperationInfo;
import cn.edu.ustb.webservicetester.model.ParameterInfo;


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
public class PreferenceFrame  extends javax.swing.JFrame {

	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private AbstractAction nextAction;
	private JButton jButtonPre;
	private JButton jButtonNext;
	private JComboBox testStrategyJComboBox;
	private JLabel testStrategyJLabel;
	private DefaultTableModel paraInfoTableModel;
	private JTable paraInfoJTable;
	private JTextArea paraResJTextArea;
	private JLabel paraResJLabel;
	private JLabel paraInfoJLabel;
	private AbstractAction operationSelectionAction;
	private JComboBox operationComboBox;
	private JLabel opSelectionJLabel;
	private java.util.List<OperationInfo> opInfoList;
	private OperationInfo selectedOperationInfo;
	private java.util.List<ParameterInfo> paraInfoList;
	private java.util.Map<String, String> setting = null;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PreferenceFrame inst = new PreferenceFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PreferenceFrame() {
		super();
		initGUI();
	}
	
	public PreferenceFrame(Map<String, String> setting, java.util.List list) {
		super();
		this.setting = setting;
		initGUI(list);
	}
	
	private void initGUI() {
		initGUI(null);
	}
	
	private void initGUI(java.util.List<OperationInfo> oil) {
		this.opInfoList = oil;
		try {
			setTitle("操作选择");
			setResizable(false);
			GridLayout thisLayout = new GridLayout(1, 1);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(228,236,243));
				jPanel1.setPreferredSize(new java.awt.Dimension(506, 349));
				{
					opSelectionJLabel = new JLabel();
					jPanel1.add(opSelectionJLabel);
					opSelectionJLabel.setText("\u8bf7\u9009\u62e9\u5f85\u6d4b\u8bd5\u7684\u64cd\u4f5c");
					opSelectionJLabel.setBounds(12, 36, 128, 17);
				}
				{
					ComboBoxModel operationSelectionComboBoxModel;
					if (opInfoList == null)
						operationSelectionComboBoxModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
					else {
						String[] opNames = new String[opInfoList.size()];
						for (int i = 0; i < opNames.length; ++i) {
							opNames[i] = opInfoList.get(i).getOpName();
						}
						operationSelectionComboBoxModel = new DefaultComboBoxModel(opNames);
					}
					operationComboBox = new JComboBox();
					jPanel1.add(operationComboBox);
					operationComboBox.setModel(operationSelectionComboBoxModel);
					operationComboBox.setBounds(140, 32, 162, 24);
					operationComboBox.setAction(getOperationSelectionAction());
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(24, 101, 183, 132);
					jScrollPane1.setViewportView(getParaInfoJTable());
				}
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2);
					jPanel1.add(getJLabelParameterInformation());
					jPanel1.add(getParaResJLabel());
					jPanel1.add(getTestStrategyJLabel());
					jPanel1.add(getTestStrategyJComboBox());
					jPanel1.add(getJButtonNext());
					jPanel1.add(getJButtonPre());
					jScrollPane2.setBounds(290, 101, 183, 132);
					jScrollPane2.setViewportView(getParaResJTextArea());
				}
			}
			pack();
			this.setSize(500, 444);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private AbstractAction getOperationSelectionAction() {
		if(operationSelectionAction == null) {
			operationSelectionAction = new AbstractAction("", null) {
				public void actionPerformed(ActionEvent evt) {
					int opIndexSelected = operationComboBox.getSelectedIndex();
					selectedOperationInfo = opInfoList.get(opIndexSelected);
					paraInfoList = selectedOperationInfo.getParaList();
					int oldPInfoCount = paraInfoTableModel.getRowCount();
					while (oldPInfoCount-- > 0) {
						paraInfoTableModel.removeRow(0);
					}
					for (ParameterInfo pi : paraInfoList) {
						paraInfoTableModel.addRow(new String[] {pi.getName(), pi.getClassInfo()});
					}
				}
			};
		}
		return operationSelectionAction;
	}
	
	private JLabel getJLabelParameterInformation() {
		if(paraInfoJLabel == null) {
			paraInfoJLabel = new JLabel();
			paraInfoJLabel.setText("\u8f93\u5165\u53c2\u6570");
			paraInfoJLabel.setBounds(24, 73, 61, 17);
		}
		return paraInfoJLabel;
	}
	
	private JLabel getParaResJLabel() {
		if(paraResJLabel == null) {
			paraResJLabel = new JLabel();
			paraResJLabel.setText("\u53c2\u6570\u8bf4\u660e");
			paraResJLabel.setBounds(274, 73, 64, 17);
		}
		return paraResJLabel;
	}
	
	private JTextArea getParaResJTextArea() {
		if(paraResJTextArea == null) {
			paraResJTextArea = new JTextArea();
			paraResJTextArea.setEditable(false);
		}
		return paraResJTextArea;
	}
	
	private JTable getParaInfoJTable() {
		if (paraInfoJTable == null) {
			String[] name = new String[] {"参数名", "数据类型"};
			int opIndexSelected = operationComboBox.getSelectedIndex();
			OperationInfo opInfo = opInfoList.get(opIndexSelected);
			paraInfoList = opInfo.getParaList();
			paraInfoTableModel = new DefaultTableModel(null, name);
			for (ParameterInfo pi : paraInfoList) {
				paraInfoTableModel.addRow(new String[] {pi.getName(), pi.getClassInfo()});
			}
			paraInfoJTable = new JTable(paraInfoTableModel) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			paraInfoJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			paraInfoJTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					int selectedRow = paraInfoJTable.getSelectedRow();
					if (paraResJTextArea != null && paraInfoList != null && selectedRow >= 0)
						paraResJTextArea.setText(paraInfoList.get(selectedRow).getRestriction());
				}
			});
		}
		return paraInfoJTable;
	}
	
	private JLabel getTestStrategyJLabel() {
		if(testStrategyJLabel == null) {
			testStrategyJLabel = new JLabel();
			testStrategyJLabel.setText("\u6d4b\u8bd5\u7b56\u7565");
			testStrategyJLabel.setBounds(12, 266, 53, 17);
		}
		return testStrategyJLabel;
	}
	
	private JComboBox getTestStrategyJComboBox() {
		if(testStrategyJComboBox == null) {
			ComboBoxModel testStrategyJComboBoxModel = 
					new DefaultComboBoxModel(
							new String[] { "Random Testing", "Dynamic Random Testing" });
			testStrategyJComboBox = new JComboBox();
			testStrategyJComboBox.setModel(testStrategyJComboBoxModel);
			testStrategyJComboBox.setBounds(24, 295, 116, 24);
			testStrategyJComboBox.setFont(new java.awt.Font("Times New Roman", 0, 12));
		}
		return testStrategyJComboBox;
	}
	
	private JButton getJButtonNext() {
		if(jButtonNext == null) {
			jButtonNext = new JButton();
			jButtonNext.setText("\u4e0b\u4e00\u6b65");
			jButtonNext.setBounds(392, 367, 80, 30);
			jButtonNext.setAction(getNextAction());
		}
		return jButtonNext;
	}
	
	private JButton getJButtonPre() {
		if(jButtonPre == null) {
			jButtonPre = new JButton();
			jButtonPre.setText("\u4e0a\u4e00\u6b65");
			jButtonPre.setBounds(238, 367, 80, 30);
		}
		return jButtonPre;
	}
	
	private AbstractAction getNextAction() {
		if(nextAction == null) {
			nextAction = new AbstractAction("\u4e0b\u4e00\u6b65", null) {
				public void actionPerformed(ActionEvent evt) {
					setting.put("Operation", (String)operationComboBox.getSelectedItem());
					setting.put("Test Strategy", (String)testStrategyJComboBox.getSelectedItem());
//					if (testStrategyJComboBox.getSelectedItem().toString().equals("Random Testing")) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							TestSettingFrame inst = new TestSettingFrame(setting, selectedOperationInfo);
							inst.setLocationRelativeTo(null);
							inst.setVisible(true);
						}
					});
//					}
//					else if (testStrategyJComboBox.getSelectedItem().toString().equals("Dynamic Random Testing")) {
//						SwingUtilities.invokeLater(new Runnable() {
//							public void run() {
//								PartitionSettingFrame inst = new PartitionSettingFrame(paraInfoList);
//								inst.setLocationRelativeTo(null);
//								inst.setVisible(true);
//							}
//						});
//					}
				}
			};
		}
		return nextAction;
	}

}
