package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import cn.edu.ustb.webservicetester.model.OperationInfo;
import cn.edu.ustb.webservicetester.model.ParameterInfo;
import cn.edu.ustb.webservicetester.model.TestSet;
import cn.edu.ustb.webservicetester.model.TestSetWithPartition;
import cn.edu.ustb.webservicetester.util.Partitioner;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class PartitionSettingFrame2 extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private AbstractAction abstractAction1;
	private JComboBox jComboBox1;
	private JTable jTable1;
	private TableModel jTable1Model;
	private AbstractAction abstractAction2;
	private JScrollPane jScrollPane2;
	private JTable jTable2;
	private TableModel jTable2Model;
	private JButton jButtonPre;
	private JButton jButtonNext;
	private AbstractAction removePartitionAction;
	private JButton jButtonRemovePartition;
	private AbstractAction abstractActionAddPartition;
	private JButton jButtonAddPartition;
	private java.util.List<ParameterInfo> paraInfoList;
	private OperationInfo operaInfo;
	private Map<String, String> testSetting;
	private TestSet testSet;
	private boolean addColumn = true;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PartitionSettingFrame2 inst = new PartitionSettingFrame2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public PartitionSettingFrame2() {
		super();
		initGUI();
	}
	
	public PartitionSettingFrame2(Map<String, String> testSettingMap, OperationInfo oi, TestSet ts) {
		super();
		operaInfo = oi;
		paraInfoList = operaInfo.getParaList();
		testSetting = testSettingMap;
		testSet = ts;
		initGUI();
	}

	private void initGUI() {
		try {
			setTitle("分区设定");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			GridLayout thisLayout = new GridLayout(1, 1);
			getContentPane().setLayout(thisLayout);
			getContentPane().setBackground(new java.awt.Color(228,236,243));
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(228,236,243));
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(12, 10, 470, 200);
					jScrollPane1.setViewportView(getJTable1());
				}
				{
					ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
							new String[] { "平均分布", "比例分布", "人工设定" });
					jComboBox1 = new JComboBox();
					jPanel1.add(jComboBox1);
					jPanel1.add(getJButtonAddPartition());
					jPanel1.add(getJButtonRemovePartition());
					jPanel1.add(getJButtonNext());
					jPanel1.add(getJButtonPre());
					jPanel1.add(getJScrollPane2());
					jComboBox1.setModel(jComboBox1Model);
					jComboBox1.setBounds(12, 222, 105, 24);
					jComboBox1.setAction(getAbstractAction1());
				}
			}
			pack();
			setSize(500, 444);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private Component getJTable1() {
		if (operaInfo == null) {
			jTable1Model = new DefaultTableModel(new String[][] { { "1", "国际航班",
					"经济舱", "学生", "43.3", "20030.0" } }, new String[] { "编号",
					"航班类型", "座舱等级", "乘客", "行李重量", "经济舱票价" });
		} else {
			String[] columnNames = new String[paraInfoList.size() + 1];
			for (int i = 0; i <= paraInfoList.size(); ++i) {
				if (i == 0) {
					columnNames[i] = "id";
				} else {
					columnNames[i] = paraInfoList.get(i - 1).getName();
				}
			}
			jTable1Model = new DefaultTableModel(new String[][] {}, columnNames);
		}
		jTable1 = new JTable(jTable1Model);
		jTable1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				int cidx = 5;
				if (e.getKeyChar() == '\n') {
					System.out.println(jTable1.getColumnCount());
					System.out.println(jTable1.getSelectedColumn());
					if (jTable1.getSelectedColumn() >= cidx
							&& jTable1.getSelectedRow() >= jTable1
									.getRowCount() - 1
							&& jTable1.getValueAt(jTable1.getSelectedRow(),
									cidx) != null
							&& jTable1
									.getValueAt(jTable1.getSelectedRow(), cidx)
									.toString().length() > 0) {
						// System.out.println(paraPartitionTable.getValueAt(paraPartitionTable.getSelectedRow(),
						// paraPartitionTable.getSelectedColumn()).toString().length());
						jTable1.editCellAt(jTable1.getSelectedRow(),
								jTable1.getSelectedColumn());
						((DefaultTableModel) jTable1Model)
								.addRow(new String[] { new Integer(jTable1
										.getRowCount() + 1).toString() });
					}
					jTable1.editCellAt(jTable1.getSelectedRow(),
							jTable1.getSelectedColumn());
				}
			}
		});
		return jTable1;
	}

	private AbstractAction getAbstractAction1() {
		if (abstractAction1 == null) {
			abstractAction1 = new AbstractAction("abstractAction1", null) {
				public void actionPerformed(ActionEvent evt) {
					if (jComboBox1.getSelectedItem().equals("人工设定")) {
						if (addColumn) {
							addColumn = false;
							((DefaultTableModel) jTable1Model)
									.addColumn("初始概率");
						}
					}
					if (jComboBox1.getSelectedItem().equals("平均分布") || jComboBox1.getSelectedItem().equals("比例分布")) {
						if (!addColumn) {
							addColumn = true;
							DefaultTableModel dtm = (DefaultTableModel) jTable1Model;
							int columnCount = dtm.getColumnCount() - 1;
							if (columnCount >= 0) {
								TableColumnModel tcm = jTable1.getColumnModel();
								TableColumn tc = tcm.getColumn(columnCount);
								dtm.setColumnCount(columnCount);
								tcm.removeColumn(tc);
								dtm.setColumnCount(columnCount);
							}
						}
					}
					System.out.println(jTable1.getColumnCount());
				}
			};
		}
		return abstractAction1;
	}

	private JButton getJButtonAddPartition() {
		if (jButtonAddPartition == null) {
			jButtonAddPartition = new JButton();
			jButtonAddPartition.setText("\u6dfb\u52a0\u5206\u533a");
			jButtonAddPartition.setBounds(229, 220, 100, 30);
			jButtonAddPartition.setAction(getAbstractActionAddPartition());
		}
		return jButtonAddPartition;
	}

	private AbstractAction getAbstractActionAddPartition() {
		if (abstractActionAddPartition == null) {
			abstractActionAddPartition = new AbstractAction("添加分区", null) {
				public void actionPerformed(ActionEvent evt) {
					((DefaultTableModel) jTable1Model)
							.addRow(new String[] { new Integer(jTable1
									.getRowCount() + 1).toString() });
				}
			};
		}
		return abstractActionAddPartition;
	}
	
	private JButton getJButtonRemovePartition() {
		if(jButtonRemovePartition == null) {
			jButtonRemovePartition = new JButton();
			jButtonRemovePartition.setText("\u5220\u9664\u5206\u533a");
			jButtonRemovePartition.setBounds(382, 220, 100, 30);
			jButtonRemovePartition.setAction(getRemovePartitionAction());
		}
		return jButtonRemovePartition;
	}
	
	private AbstractAction getRemovePartitionAction() {
		if(removePartitionAction == null) {
			removePartitionAction = new AbstractAction("\u5220\u9664\u5206\u533a", null) {
				public void actionPerformed(ActionEvent evt) {
					DefaultTableModel dtm = (DefaultTableModel)jTable1Model;
					if (jTable1Model.getRowCount() > 1)
						dtm.removeRow(dtm.getRowCount() - 1);
				}
			};
		}
		return removePartitionAction;
	}
	
	private JButton getJButtonNext() {
		if(jButtonNext == null) {
			jButtonNext = new JButton();
			jButtonNext.setText("\u4e0b\u4e00\u6b65");
			jButtonNext.setBounds(329, 346, 80, 30);
			jButtonNext.setAction(getAbstractAction2());
		}
		return jButtonNext;
	}
	
	private JButton getJButtonPre() {
		if(jButtonPre == null) {
			jButtonPre = new JButton();
			jButtonPre.setText("\u4e0a\u4e00\u6b65");
			jButtonPre.setBounds(229, 346, 80, 30);
		}
		return jButtonPre;
	}
	
	private JScrollPane getJScrollPane2() {
		if(jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBounds(12, 267, 179, 109);
			jScrollPane2.setViewportView(getJTable2());
		}
		return jScrollPane2;
	}
	
	private JTable getJTable2() {
		if(jTable2 == null) {
			if (operaInfo == null) {
				jTable2Model = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
			} else {
				String[] columnNames = new String[] {"参数名", "取值类型"};
				Object[][] datas = new Object[paraInfoList.size()][2];
				for (int i = 0; i < paraInfoList.size(); ++i) {
					datas[i][0] = paraInfoList.get(i).getName();
					datas[i][1] = "";
				}
				jTable2Model = new DefaultTableModel(datas, columnNames);
			}
			jTable2 = new JTable() {
				public boolean isCellEditable(int row, int column) {
					if (column == 0) {
						return false;
					} else {
						return true;
					}
				}
			};
			jTable2.setModel(jTable2Model);
//			for (int i = 0; i < jTable2.getRowCount(); ++i) {
			JComboBox c = new JComboBox();
			c.addItem("无所谓");
			c.addItem("连续型");
			c.addItem("离散型");
			jTable2.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(c));
//			}
		}
		return jTable2;
	}
	
	private AbstractAction getAbstractAction2() {
		if(abstractAction2 == null) {
			abstractAction2 = new AbstractAction("下一步", null) {
				public void actionPerformed(ActionEvent evt) {
					for (int i = 0; i < paraInfoList.size(); ++i) {
						ParameterInfo pi = paraInfoList.get(i);
						if (((String)jTable2.getValueAt(i, 1)).equals("无所谓")) {
							pi.setType(ParameterInfo.WHATEVER);
						} else if (((String)jTable2.getValueAt(i, 1)).equals("连续型")) {
							pi.setType(ParameterInfo.CONTINUOUS);
						} else if (((String)jTable2.getValueAt(i, 1)).equals("离散型")) {
							pi.setType(ParameterInfo.SCATTERED);
						} else {
							System.out.println("参数取值类型设置出错！！！");//do nothing temporary
						}
					}
					java.util.List<java.util.Map<ParameterInfo, String>> partScenaList = new java.util.LinkedList<Map<ParameterInfo,String>>();
					java.util.Map<ParameterInfo, String> tempRules = null;
					for (int i = 0; i < jTable1.getRowCount(); ++i) {
						tempRules = new java.util.HashMap<ParameterInfo, String>();
						for (int j = 0; j < paraInfoList.size(); ++j) {
							tempRules.put(paraInfoList.get(j), (String)jTable1.getValueAt(i, j + 1));
						}
						partScenaList.add(tempRules);
					}
					Partitioner ptner = new Partitioner();
					TestSetWithPartition testSetWP = ptner.makePartitions(testSet, partScenaList);
					ExecutionFrame ef = new ExecutionFrame(testSetting, operaInfo, testSetWP);
					ef.setLocationRelativeTo(null);
					ef.setVisible(true);
				}
			};
		}
		return abstractAction2;
	}

}
