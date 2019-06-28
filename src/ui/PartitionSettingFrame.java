package ui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import cn.edu.ustb.webservicetester.model.ParameterIntervalScenario;
import cn.edu.ustb.webservicetester.model.ParameterInfo;
import cn.edu.ustb.webservicetester.model.ParameterPartitionScenario;


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
public class PartitionSettingFrame extends javax.swing.JFrame implements ItemListener{
	private java.util.List<ParameterInfo> paraInfos;
	private java.util.List<JComboBox> paraTypeList;
	private java.util.List<JCheckBox> paraList;
	private JLabel partitionBasisJLabel;
	private JLabel partitionSettingJLabel;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private java.util.Map<JCheckBox, JComboBox> paraTypePair;
	private JTable paraPartitionTable;
	private DefaultTableModel paraPartitionTableModel;
	private java.util.Map<String, DefaultTableModel> paraPartitionScenarioTableModels;
	private JButton preStepButton;
	private JButton nextStepButton;
	public static final int DISTANCE1 = 29;
	public static final int DISTANCE2 = 30;
	public static final int CHECK_BOX_X = 26;
	public static final int CHECK_BOX_Y = 51;
	public static final int CHECK_BOX_WIDTH = 105;
	public static final int CHECK_BOX_HEIGHT = 21;
	private AbstractAction nextStepAction;
	public static final int COMBO_BOX_X = 155;
	public static final int COMBO_BOX_Y = 49;
	public static final int COMBO_BOX_WIDTH = 118;
	public static final int COMBO_BOX_HEIGHT = 24;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PartitionSettingFrame inst = new PartitionSettingFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public PartitionSettingFrame() {
		super();
		initGUI();
	}
	
	public PartitionSettingFrame(java.util.List<ParameterInfo> paraInfoList) {
		super();
		initGUI(paraInfoList);
	}
	
	private void initGUI() {
		initGUI(null);
	}
	
	private void initGUI(java.util.List<ParameterInfo> paraInfoList) {
		if (paraInfoList == null) {
			paraInfos = new java.util.LinkedList<ParameterInfo>();
			for (int i = 0; i < 4; ++i) {
				ParameterInfo tpi = new ParameterInfo();
				tpi.setName("parameter " + (i + 1));
				tpi.setRestriction("");
				tpi.setClassInfo("Object");
				paraInfos.add(tpi);
			}
		}
		else {
			paraInfos = paraInfoList;
		}
		try {
			GridLayout thisLayout = new GridLayout(1, 1);
			thisLayout.setHgap(5);
			thisLayout.setVgap(5);
			thisLayout.setColumns(1);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("\u5206\u533a\u8bbe\u5b9a");
			setResizable(false);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(252,252,203));
				{
					partitionBasisJLabel = new JLabel();
					jPanel1.add(partitionBasisJLabel);
					partitionBasisJLabel.setText("1. \u9009\u62e9\u5206\u533a\u4f9d\u636e\u53c2\u6570");
					partitionBasisJLabel.setBounds(26, 22, 129, 17);
				}
				{
					paraList = new java.util.ArrayList<JCheckBox>(paraInfos.size());
					paraTypeList = new java.util.ArrayList<JComboBox>(paraInfos.size());
					paraPartitionScenarioTableModels = new java.util.HashMap<String, DefaultTableModel>(paraInfos.size());
					paraTypePair = new java.util.HashMap<JCheckBox, JComboBox>();
					for (int i = 0; i < paraInfos.size(); ++i) {
						JCheckBox tempCheckBox = new JCheckBox();
						jPanel1.add(tempCheckBox);
						tempCheckBox.setText(paraInfos.get(i).getName());
						tempCheckBox.setBounds(CHECK_BOX_X, CHECK_BOX_Y + DISTANCE2 * i, CHECK_BOX_WIDTH, CHECK_BOX_HEIGHT);
						tempCheckBox.addItemListener(this);
						tempCheckBox.setBackground(new java.awt.Color(252, 252, 203));
						paraList.add(tempCheckBox);

						JComboBox tempComboBox = new JComboBox();
						jPanel1.add(tempComboBox);
						tempComboBox.setModel(getComboBoxModel());
						tempComboBox.setBounds(COMBO_BOX_X, COMBO_BOX_Y + DISTANCE2 * i, COMBO_BOX_WIDTH, COMBO_BOX_HEIGHT);
						tempComboBox.setVisible(false);
						paraTypeList.add(tempComboBox);
						
						paraTypePair.put(tempCheckBox, tempComboBox);
						
						DefaultTableModel tdtm = new DefaultTableModel(null, new String[]{"", "参数 " + tempCheckBox.getText() + " 的分区区间", "权重"});
						paraPartitionScenarioTableModels.put(tempCheckBox.getText(), tdtm);
					}
				}
				{
					partitionSettingJLabel = new JLabel();
					jPanel1.add(partitionSettingJLabel);
					partitionSettingJLabel.setText("2. 设定各参数分区");
					partitionSettingJLabel.setBounds(26, 22 + DISTANCE1 * 2 + DISTANCE2 * (paraInfos.size() - 1), 129, 17);
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(26, 22 + DISTANCE1 * 3 + DISTANCE2 * (paraInfos.size() - 1), 500 - 26 * 2, 444 - (22 + DISTANCE1 * 3 + DISTANCE2 * (paraInfos.size() - 1)) - 30 - DISTANCE1 * 3);
					jScrollPane1.setViewportView(getParaPartitionTable());
				}
				{
					preStepButton = new JButton();
					jPanel1.add(preStepButton);
					preStepButton.setText("上一步");
					preStepButton.setBounds(60, 444 - 30 - DISTANCE1 * 2, 80, 30);
				}
				{
					nextStepButton = new JButton();
					jPanel1.add(nextStepButton);
					nextStepButton.setText("下一步");
					nextStepButton.setBounds(500 - 60 - 80, 444 - 30 -DISTANCE1 * 2, 80, 30);
					nextStepButton.setAction(getNextStepAction());
				}
			}
			pack();
			setSize(500, 444);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private Component getParaPartitionTable() {
		if (paraPartitionTable == null) {
			String[] name = {"", "参数  的分区区间", "权重"};
			paraPartitionTableModel = new DefaultTableModel(null, name);
			paraPartitionTableModel.addRow(new String[]{"1", "", ""});
			paraPartitionTable = new JTable(paraPartitionTableModel) {
				public boolean isCellEditable(int row, int column) {
					if (column >= 1)
						return true;
					else return false;
				}
			};
			paraPartitionTable.addKeyListener(new KeyAdapter(){
				public void keyReleased(KeyEvent e) {
					if (e.getKeyChar() == '\n') {
						if (paraPartitionTable.getSelectedColumn() >= paraPartitionTable.getColumnCount() - 1
			                    && paraPartitionTable.getSelectedRow() >= paraPartitionTable.getRowCount() - 1
			                    && paraPartitionTable.getValueAt(paraPartitionTable.getSelectedRow(), paraPartitionTable.getSelectedColumn()).toString().length() > 0) {
//							System.out.println(paraPartitionTable.getValueAt(paraPartitionTable.getSelectedRow(), paraPartitionTable.getSelectedColumn()).toString().length());
							paraPartitionTable.editCellAt(paraPartitionTable.getSelectedRow(), paraPartitionTable.getSelectedColumn());
							((DefaultTableModel)paraPartitionTable.getModel()).addRow(new String[]{new Integer(paraPartitionTable.getRowCount() + 1).toString(), "", ""});
							paraPartitionTable.editCellAt(paraPartitionTable.getRowCount() - 1, 0);
						}
					}
				}
			});
		}
		return paraPartitionTable;
	}

	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		JCheckBox changedCheckBox = (JCheckBox)source;
		if (changedCheckBox.isSelected()) {
			paraTypePair.get(changedCheckBox).setVisible(true);
//			paraPartitionTableModel = paraPartitionSenarioTableModels.get(changedCheckBox.getText());
			paraPartitionTable.setModel(paraPartitionScenarioTableModels.get(changedCheckBox.getText()));
			if (paraPartitionScenarioTableModels.get(changedCheckBox.getText()).getRowCount() <= 0)
				paraPartitionScenarioTableModels.get(changedCheckBox.getText()).addRow(new String[]{"1", "", ""});
		} else {
			paraTypePair.get(changedCheckBox).setVisible(false);
			///
		}
	}
	
	private ComboBoxModel getComboBoxModel() {
		ComboBoxModel jComboBoxModel = 
				new DefaultComboBoxModel(
						new String[] { "连续型", "枚举型" });
		return jComboBoxModel;
	}
	
	private AbstractAction getNextStepAction() {
		if(nextStepAction == null) {
			nextStepAction = new AbstractAction("\u4e0b\u4e00\u6b65", null) {
				public void actionPerformed(ActionEvent evt) {
					java.util.List<ParameterPartitionScenario> partitionSetting = new java.util.ArrayList<ParameterPartitionScenario>();
					ParameterPartitionScenario tempScenario;
					for (JCheckBox jcb : paraList) {
						if (jcb.isSelected()) {
							tempScenario = new ParameterPartitionScenario();
							for (ParameterInfo pi : paraInfos) {
								if (pi.getName().equals(jcb.getText())) {
									tempScenario.setParaInfo(pi);
								}
							}
							if ("连续的".equals(paraTypePair.get(jcb).getSelectedItem())) {
								for (ParameterInfo pi :paraInfos) {
									if (pi.getName().equals(jcb.getText())) {
										pi.setType(ParameterInfo.CONTINUOUS);
									}
								}
							} else {
								for (ParameterInfo pi :paraInfos) {
									if (pi.getName().equals(jcb.getText())) {
										pi.setType(ParameterInfo.SCATTERED);
									}
								}
							}
							DefaultTableModel dtm = paraPartitionScenarioTableModels.get(jcb.getText());
							for (int i = 0; i < dtm.getRowCount(); ++i) {
								ParameterIntervalScenario paraInter = new ParameterIntervalScenario();
								paraInter.setRange(dtm.getValueAt(i, 1).toString());
								paraInter.setWeight(Integer.valueOf(dtm.getValueAt(i, 2).toString()));
								tempScenario.add(paraInter);
							}
							partitionSetting.add(tempScenario);
						} else {
							;
						}
					}
					/* 将 paraPartitionScenarios 传递给下一个页面 */
				}
			};
		}
		return nextStepAction;
	}

}
