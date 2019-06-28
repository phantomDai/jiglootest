package ui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class OperationSelectFrame extends javax.swing.JFrame {
	private JPanel OperationSelectPanel;
	private AbstractAction abstractAction_operationSelect;
	private JButton Button_OperationSelectNext;
	private JComboBox OperationSelectComboBox;
	private JLabel OperationSelectLabel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				OperationSelectFrame inst = new OperationSelectFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public OperationSelectFrame() {
		super();
		initGUI();
	}
	
	public OperationSelectFrame(Set<String> opList) {
		super();
		String[] optionList= new String[opList.size()];
		opList.toArray(optionList);
		initGUI(optionList);
	}
	
	private void initGUI() {
		initGUI(null);
	}
	
	private void initGUI(String[] optionList) {
		try {
			this.setTitle("操作选择");
			this.setResizable(false);//关闭最大化
			GridLayout thisLayout = new GridLayout(1, 1);
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				OperationSelectPanel = new JPanel();
				getContentPane().add(OperationSelectPanel);
				OperationSelectPanel.setBackground(new java.awt.Color(252,252,203));
				OperationSelectPanel.setPreferredSize(new java.awt.Dimension(403, 275));
				OperationSelectPanel.setLayout(null);
				{
					OperationSelectLabel = new JLabel();
					OperationSelectPanel.add(OperationSelectLabel);
					OperationSelectLabel.setText("\u8bf7\u9009\u62e9\u5f85\u6d4b\u7684\u64cd\u4f5c");
					OperationSelectLabel.setBounds(18, 28, 122, 17);
				}
				{
					ComboBoxModel OptionSelectComboBoxModel;
					if (optionList == null) {
						OptionSelectComboBoxModel = 
								new DefaultComboBoxModel(new String[] {"Item One", "Item Two"});
					} else {
						OptionSelectComboBoxModel = 
								new DefaultComboBoxModel(optionList);
					}
					OperationSelectComboBox = new JComboBox();
					OperationSelectPanel.add(OperationSelectComboBox);
					OperationSelectComboBox.setModel(OptionSelectComboBoxModel);
					OperationSelectComboBox.setBounds(20, 65, 199, 24);
				}
				{
					Button_OperationSelectNext = new JButton();
					OperationSelectPanel.add(Button_OperationSelectNext);
					Button_OperationSelectNext.setText("\u4e0b\u4e00\u6b65");
					Button_OperationSelectNext.setBounds(272, 198, 80, 24);
					Button_OperationSelectNext.setAction(getAbstractAction_operationSelect());
				}
			}
			pack();
			setSize(412, 311);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAbstractAction_operationSelect() {
		if(abstractAction_operationSelect == null) {
			abstractAction_operationSelect = new AbstractAction("\u4e0b\u4e00\u6b65", null) {
				public void actionPerformed(ActionEvent evt) {
					//TODO
				}
			};
		}
		return abstractAction_operationSelect;
	}

}
