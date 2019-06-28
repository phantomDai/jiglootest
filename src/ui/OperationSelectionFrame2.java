package ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
public class OperationSelectionFrame2 extends javax.swing.JFrame {

	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JList parameterInfoJList;
	private JScrollPane jScrollPane2;
	private JTextArea jTextAreaParameterRestriction;
	private JLabel jLabelParameterRestriction;
	private JLabel jLabelParameterInformation;
	private AbstractAction operationSelectionAction;
	private JComboBox operationSelectionComboBox;
	private JLabel operationSelectionLabel;
	private java.util.List<OperationInfo> opInfoList;
	private java.util.List<ParameterInfo> pmInfoList;
	private ListSelectionListener lslistener;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				OperationSelectionFrame2 inst = new OperationSelectionFrame2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public OperationSelectionFrame2() {
		super();
		initGUI();
	}
	
	public OperationSelectionFrame2(java.util.List list) {
		super();
		lslistener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					parameterSelectionChanged();
				}
			};
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
					operationSelectionLabel = new JLabel();
					jPanel1.add(operationSelectionLabel);
					operationSelectionLabel.setText("\u8bf7\u9009\u62e9\u5f85\u6d4b\u8bd5\u7684\u64cd\u4f5c");
					operationSelectionLabel.setBounds(12, 36, 128, 17);
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
					operationSelectionComboBox = new JComboBox();
					jPanel1.add(operationSelectionComboBox);
					operationSelectionComboBox.setModel(operationSelectionComboBoxModel);
					operationSelectionComboBox.setBounds(140, 32, 162, 24);
					operationSelectionComboBox.setAction(getOperationSelectionAction());
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(24, 101, 188, 132);
					{
						ListModel parameterInfoListModel = 
								new DefaultComboBoxModel(
										new String[] {});
						parameterInfoJList = new JList();
						parameterInfoJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						jScrollPane1.setViewportView(parameterInfoJList);
						parameterInfoJList.setModel(parameterInfoListModel);
						parameterInfoJList.setPreferredSize(new java.awt.Dimension(185, 129));
						parameterInfoJList.addListSelectionListener(lslistener);
					}
				}
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2);
					jPanel1.add(getJLabelParameterInformation());
					jPanel1.add(getJLabelParameterRestriction());
					jScrollPane2.setBounds(274, 101, 183, 132);
					jScrollPane2.setViewportView(getJTextAreaParameterRestriction());
				}
			}
			pack();
			this.setSize(502, 377);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private AbstractAction getOperationSelectionAction() {
		if(operationSelectionAction == null) {
			operationSelectionAction = new AbstractAction("", null) {
				public void actionPerformed(ActionEvent evt) {
					int opIndexSelected = operationSelectionComboBox.getSelectedIndex();
					OperationInfo opInfo = opInfoList.get(opIndexSelected);
					pmInfoList = opInfo.getParaList();
					DefaultComboBoxModel dcbm = (DefaultComboBoxModel)(parameterInfoJList.getModel());
					dcbm.removeAllElements();
					for (ParameterInfo pi : pmInfoList) {
						dcbm.addElement(pi.toString());
					}
				}
			};
		}
		return operationSelectionAction;
	}
	
	private JLabel getJLabelParameterInformation() {
		if(jLabelParameterInformation == null) {
			jLabelParameterInformation = new JLabel();
			jLabelParameterInformation.setText("\u8f93\u5165\u53c2\u6570");
			jLabelParameterInformation.setBounds(24, 73, 61, 17);
		}
		return jLabelParameterInformation;
	}
	
	private JLabel getJLabelParameterRestriction() {
		if(jLabelParameterRestriction == null) {
			jLabelParameterRestriction = new JLabel();
			jLabelParameterRestriction.setText("\u53c2\u6570\u8bf4\u660e");
			jLabelParameterRestriction.setBounds(274, 73, 64, 17);
		}
		return jLabelParameterRestriction;
	}
	
	private JTextArea getJTextAreaParameterRestriction() {
		if(jTextAreaParameterRestriction == null) {
			jTextAreaParameterRestriction = new JTextArea();
			jTextAreaParameterRestriction.setEditable(false);
		}
		return jTextAreaParameterRestriction;
	}
	
	private void parameterSelectionChanged() {
		int parameterIndexSelected = parameterInfoJList.getSelectedIndex();
		if (parameterIndexSelected >= 0) {
			String rstrction = pmInfoList.get(parameterIndexSelected).getRestriction();
			jTextAreaParameterRestriction.setText(rstrction);
		}
	}

}
