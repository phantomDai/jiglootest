package test;
import java.awt.BorderLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class TestJTableFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTable jTable1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TestJTableFrame inst = new TestJTableFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TestJTableFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(null);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(29, 36, 195, 136);
					jScrollPane1.setViewportView(getJTable1());
				}
			}
			pack();
			setSize(400, 300);
			jTable1.editCellAt(0, 0);
			jTable1.getEditorComponent().requestFocusInWindow();
//			jTable1.requestFocusInWindow();
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private JTable getJTable1() {
		if (jTable1 == null) {
			String[] s1 = new String[] {"小王", "0001"};
			String[] s2 = new String[] {"小芳", "0002"};
			String[][] data = new String[][] {s1, s2};
			String[] name = new String[] {"姓名", "工号"};
			jTable1 = new JTable(data, name);
//			jTable1.editCellAt(0, 0);
//			jTable1.getEditorComponent().requestFocusInWindow();
		}
		return jTable1;
	}

}
