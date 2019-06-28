package ui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import cn.edu.ustb.webservicetester.model.OperationInfo;
import cn.edu.ustb.webservicetester.model.TestCase;
import cn.edu.ustb.webservicetester.model.TestSet;
import cn.edu.ustb.webservicetester.model.TestSetWithPartition;
import cn.edu.ustb.webservicetester.thread.TestCaseExecuter;
import cn.edu.ustb.webservicetester.thread.TestProcessWriter;
import cn.edu.ustb.webservicetester.util.ServiceInvoker;


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
public class ExecutionFrame extends javax.swing.JFrame {
	private Color bgColor = new Color(252, 252, 203);
	private JSplitPane jSplitPane1;
	private JSplitPane jSplitPane2;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JTextField jTextField1;
	private ButtonGroup buttonGroup1;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton2;
	private AbstractAction abstractAction1;
	private JButton jButton1;
	private JTextPane jTextPane1;
	private StyledDocument doc;
	private JPanel jPanel1;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private Timer timeAction;
	private JLabel jLabel11;
	private JTextField jTextField3;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JTextField jTextField2;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton1;
	private int testI = 0;
	private boolean isStop = false;
	private java.util.Map<String, String> testSetting;
	private OperationInfo operationInfo;
	private TestSet testSet = null;
	private TestSetWithPartition testSetWP = null;
	private java.util.Queue<String> pQueue = new java.util.concurrent.ConcurrentLinkedQueue<String>();
	private boolean testFinished = false;
	private Thread executeThread = null;
	private Thread showProcessThread = null;
	private double epsilon = 0.0;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ExecutionFrame inst = new ExecutionFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ExecutionFrame() {
		super();
		initGUI();
	}
	
	public ExecutionFrame(java.util.Map<String, String> tSetting, OperationInfo oi, TestSet ts) {
		super();
		testSetting = tSetting;
		operationInfo = oi;
		testSet = ts;
		initGUI(tSetting, oi);
	}
	
	public ExecutionFrame(java.util.Map<String, String> tSetting, OperationInfo oi, TestSetWithPartition tswp) {
		super();
		testSetting = tSetting;
		operationInfo = oi;
		testSetWP = tswp;
		System.out.println(testSetWP.numOfPartitions());
		System.out.println(testSetWP.numOfTestCases());
		initGUI(tSetting, oi);
	}
	
	private void initGUI(Map<String, String> tSetting, OperationInfo oi) {
		try {
			setTitle("测试执行");
			getContentPane().add(getJSplitPane1());
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setResizable(false);
			pack();
			setSize(800, 600);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Component getJSplitPane1() {
		jSplitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		jSplitPane1.setDividerLocation(440);
		jSplitPane1.setDividerSize(5);
		jSplitPane1.setEnabled(false);
		jSplitPane1.add(getJSplitPane2(), JSplitPane.LEFT);
		jSplitPane1.add(getJPanel3(), JSplitPane.RIGHT);
		return jSplitPane1;
	}

	private Component getJSplitPane2() {
		jSplitPane2 = new JSplitPane();
		jSplitPane2.setDividerLocation(200);
		jSplitPane2.setDividerSize(5);
		jSplitPane2.setEnabled(false);
		jSplitPane2.add(getJScrollPane1(), JSplitPane.LEFT);
		jSplitPane2.add(getJScrollPane2(), JSplitPane.RIGHT);
		return jSplitPane2;
	}
	
	private Component getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBackground(new java.awt.Color(228,236,243));
			jScrollPane2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Testing Process", TitledBorder.TRAILING, TitledBorder.TOP));
			jScrollPane2.setViewportView(getJPane2());
		}
		return jScrollPane2;
	}

	private Component getJPane2() {
		jPanel2 = new JPanel();
		GridLayout jPanel2Layout = new GridLayout(1, 1);
		jPanel2Layout.setColumns(1);
		jPanel2Layout.setHgap(5);
		jPanel2Layout.setVgap(5);
		jPanel2.setBackground(bgColor);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2.add(getJTextPane1());
		return jPanel2;
	}

	private Component getJTextPane1() {
		jTextPane1 = new JTextPane();
		jTextPane1.setBackground(new java.awt.Color(228,236,243));
		doc = jTextPane1.getStyledDocument();
		return jTextPane1;
	}

	private Component getJScrollPane1() {
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setBackground(new java.awt.Color(228,236,243));
		jScrollPane1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Test Setting", TitledBorder.LEADING, TitledBorder.TOP));
		jScrollPane1.setViewportView(getJPanel1());
		return jScrollPane1;
	}

	private Component getJPanel1() {
		jPanel1 = new JPanel();
		GridBagLayout jPanel1Layout = new GridBagLayout();
		jPanel1.setBackground(new java.awt.Color(228,236,243));
		jPanel1Layout.rowWeights = new double[testSetting.size() * 2 + 1];
		jPanel1Layout.rowHeights = new int[testSetting.size() * 2 + 1];
		for (int i = 0; i <= testSetting.size() * 2; ++i) {
			jPanel1Layout.rowWeights[i] = 0.1;
			if (i == testSetting.size() * 2) {
				jPanel1Layout.rowHeights[i] = 7;
			} else {
				if (i % 2 == 0) {
					jPanel1Layout.rowHeights[i] = 25;
				} else {
					jPanel1Layout.rowHeights[i] = 30;
				}
			}
		}
		jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
		jPanel1Layout.columnWidths = new int[] {7, 7, 7, 7, 7};
		jPanel1.setLayout(jPanel1Layout);
		JLabel jLabelTemp1, jLabelTemp2;
		java.util.Iterator<String> keyIter = testSetting.keySet().iterator();
		int settingIndex = 0;
		while (keyIter.hasNext()) {
			StringBuffer labelBuf = new StringBuffer(" · ");
			String key = keyIter.next();
			labelBuf.append(key);
			String value = testSetting.get(key);
			System.out.print(key);
			System.out.print(":");
			System.out.println(value);
			jLabelTemp1 = new JLabel(labelBuf.toString());
			jLabelTemp2 = new JLabel(value);
			jPanel1.add(jLabelTemp1, new GridBagConstraints(0, settingIndex * 2, 4, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel1.add(jLabelTemp2, new GridBagConstraints(1, settingIndex * 2 + 1, 3, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//			jLabelTemp1 = new JLabel(labelBuf.toString());
//			jLabelTemp2 = new JLabel(value);
//			jPanel1.add(jLabelTemp1, new GridBagConstraints(0, settingIndex * 2, 4, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//			jPanel1.add(jLabelTemp2, new GridBagConstraints(1, settingIndex * 2 + 1, 3, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			++settingIndex;
		}
		return jPanel1;
	}

	private Component getJPanel3() {
		jPanel3 = new JPanel();
		GridBagLayout jPanel3Layout = new GridBagLayout();
		jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
		jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7};
		jPanel3Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.0, 0.1, 0.0, 0.1, 0.0, 0.1};
		jPanel3Layout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
		jPanel3.setLayout(jPanel3Layout);
		jPanel3.setBackground(new java.awt.Color(228,236,243));
		jPanel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Test Controller", TitledBorder.CENTER, TitledBorder.TOP));
		jPanel3.add(getJButton1(), new GridBagConstraints(7, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJButton2(), new GridBagConstraints(9, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJButton3(), new GridBagConstraints(11, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJButton4(), new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJRadioButton1(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJRadioButton2(), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJTextField1(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJTextField2(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJLabel9(), new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJLabel10(), new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJTextField3(), new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		jPanel3.add(getJLabel11(), new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		getButtonGroup1();
		return jPanel3;
	}

	private Component getJButton1() {
		jButton1 = new JButton();
		jButton1.setText("Start");
		jButton1.setAction(getAbstractAction1());
		return jButton1;
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jSplitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				getContentPane().add(jSplitPane1);
				setResizable(false);
//				jSplitPane1.setOneTouchExpandable(true);
//				jSplitPane1.setContinuousLayout(true);
				{
					jSplitPane2 = new JSplitPane();
					jSplitPane1.add(jSplitPane2, JSplitPane.LEFT);
					
					{
					jPanel2 = new JPanel();
						GridLayout jPanel2Layout = new GridLayout(1, 1);
						jPanel2Layout.setColumns(1);
						jPanel2Layout.setHgap(5);
						jPanel2Layout.setVgap(5);
						jSplitPane2.add(jPanel2, JSplitPane.RIGHT);
						jPanel2.setBackground(bgColor);
						jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Testing Process", TitledBorder.TRAILING, TitledBorder.TOP));
						jPanel2.setLayout(jPanel2Layout);
						{
							jTextPane1 = new JTextPane();
							jPanel2.add(jTextPane1);
							jTextPane1.setBackground(bgColor);
							jTextPane1.setText("jTextPane1\n");
							doc = jTextPane1.getStyledDocument();
							javax.swing.text.SimpleAttributeSet attr = new javax.swing.text.SimpleAttributeSet();
							StyleConstants.setBold(attr, true);
							StyleConstants.setForeground(attr, Color.RED);
							doc.insertString(doc.getLength(), "jTextPane2\n", attr);
							StyleConstants.setBold(attr, false);
							StyleConstants.setForeground(attr, Color.BLACK);
							doc.insertString(doc.getLength(), "jTextPane3\n", attr);
							addTestProcess();
						}

					}
					{
						jScrollPane1 = new JScrollPane();
						jScrollPane1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Test Setting", TitledBorder.LEADING, TitledBorder.TOP));
						jScrollPane1.setBackground(bgColor);
						jSplitPane2.add(jScrollPane1, JSplitPane.LEFT);
						{
							jPanel1 = new JPanel();
							GridBagLayout jPanel1Layout = new GridBagLayout();
							jScrollPane1.setViewportView(jPanel1);
							jPanel1.setBackground(bgColor);
//							jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Test Setting", TitledBorder.LEADING, TitledBorder.TOP));
							jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
							jPanel1Layout.rowHeights = new int[] {25, 30, 25, 30, 25, 30, 25, 30, 7};
							jPanel1Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
							jPanel1Layout.columnWidths = new int[] {7, 7, 7, 7};
							jPanel1.setLayout(jPanel1Layout);
							{
								JLabel jLabel1 = new JLabel();
								jPanel1.add(jLabel1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jLabel1.setText(" · Web Service:  ");
							}
							{
								JLabel jLabel2 = new JLabel();
								jPanel1.add(jLabel2, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jLabel2.setText("localhost:8080/axis2/services/AddService");
							}
							{
								JLabel jLabel3 = new JLabel();
								jPanel1.add(jLabel3, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jLabel3.setText(" · Operation: ");
							}
							{
								JLabel jLabel4 = new JLabel();
								jPanel1.add(jLabel4, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jLabel4.setText("add");
							}
							{
								JLabel jLabel5 = new JLabel();
								jPanel1.add(jLabel5, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jLabel5.setText(" · Teseting Strategy:");
							}
							{
								JLabel jLabel6 = new JLabel();
								jPanel1.add(jLabel6, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jLabel6.setText("Random Testing");
							}
							{
								JLabel jLabel7 = new JLabel();
								jPanel1.add(jLabel7, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jLabel7.setText(" · Test Suite:");
							}
							{
								JLabel jLabel8 = new JLabel();
								jPanel1.add(jLabel8, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
								jLabel8.setText("testcaseset4addservice$add.xml");
							}
						}
					}
					jSplitPane2.setDividerLocation(200);
					jSplitPane2.setDividerSize(5);
					jSplitPane2.setEnabled(false);
				}
				{
					jPanel3 = new JPanel();
					GridBagLayout jPanel3Layout = new GridBagLayout();
					jSplitPane1.add(jPanel3, JSplitPane.RIGHT);
					jPanel3.setBackground(bgColor);
					jPanel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Test Controller", TitledBorder.CENTER, TitledBorder.TOP));
					jPanel3Layout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.rowHeights = new int[] {7, 7, 7, 7};
					jPanel3Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
					jPanel3Layout.columnWidths = new int[] {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
					jPanel3.setLayout(jPanel3Layout);
					{
						jButton1 = new JButton();
						jButton1.setText("Start");
						jButton1.setAction(getAbstractAction1());
						jPanel3.add(jButton1, new GridBagConstraints(7, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jPanel3.add(getJButton2(), new GridBagConstraints(9, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
						jPanel3.add(getJButton3(), new GridBagConstraints(11, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
						jPanel3.add(getJButton4(), new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
					}
				}
				jSplitPane1.setDividerLocation(450);
				jSplitPane1.setDividerSize(5);
				jSplitPane1.setEnabled(false);
			}
			pack();
			setSize(800, 600);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	private void addTestProcess() {
		timeAction = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet attr = new SimpleAttributeSet();
				if (testI++ < 10) {
					if (testI % 3 == 0) {
						StyleConstants.setBold(attr, true);
						StyleConstants.setForeground(attr, Color.RED);
					} else {
						StyleConstants.setBold(attr, false);
						StyleConstants.setForeground(attr, Color.BLACK);
					}
					try {
						doc.insertString(doc.getLength(), "动态添加第"+testI+"行\n", attr);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		timeAction.start();
	}
	
	private AbstractAction getAbstractAction1() {
		if(abstractAction1 == null) {
			abstractAction1 = new AbstractAction("Start", null) {
				int tem = -1;
				int tec = -1;
				public void actionPerformed(ActionEvent evt) {
					if (jRadioButton1.isSelected()) {
						tem = new Integer(jTextField1.getText());
						tec = TestCaseExecuter.NUM_OF_CASES;
					} else if (jRadioButton2.isSelected()){
						tem = new Integer(jTextField2.getText());
						tec = TestCaseExecuter.NUM_OF_FAULTS;
					}
					
					if (testSet != null) {
						executeThread = new Thread(new TestCaseExecuter(testSetting.get("Web Service"), operationInfo, testSet, pQueue, tec, tem));
					} else if (testSetWP != null) {
						if (testSetting.get("Epsilon") == null) {
							executeThread = new Thread(new TestCaseExecuter(testSetting.get("Web Service"), operationInfo, testSetWP, pQueue, tec, tem));
						} else {
							double e = Double.parseDouble(testSetting.get("Epsilon"));
							executeThread = new Thread(new TestCaseExecuter(testSetting.get("Web Service"), operationInfo, testSetWP, e, pQueue, tec, tem));
						}
					} else {}
					executeThread.start();
					showProcessThread = new Thread(new TestProcessWriter(doc, pQueue));
					showProcessThread.start();
				}
			};
		}
		return abstractAction1;
	}
	
	private JButton getJButton2() {
		if(jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Stop");
		}
		return jButton2;
	}
	
	private JButton getJButton3() {
		if(jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Download report");
		}
		return jButton3;
	}
	
	private JButton getJButton4() {
		if(jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("<< Back");
		}
		return jButton4;
	}
	
	private ButtonGroup getButtonGroup1() {
		if(buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
			buttonGroup1.add(jRadioButton1);
			buttonGroup1.add(jRadioButton2);
		}
		return buttonGroup1;
	}
	
	private JRadioButton getJRadioButton1() {
		if(jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setBackground(new java.awt.Color(228,236,243));
			jRadioButton1.setText("执行");
			jRadioButton1.setSelected(true);
		}
		return jRadioButton1;
	}
	
	private JRadioButton getJRadioButton2() {
		if(jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setBackground(new java.awt.Color(228,236,243));
			jRadioButton2.setText("杀死");
		}
		return jRadioButton2;
	}
	
	private JTextField getJTextField1() {
		if(jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("");
		}
		return jTextField1;
	}
	
	private JTextField getJTextField2() {
		if(jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setText("");
		}
		return jTextField2;
	}
	
	private JLabel getJLabel9() {
		if(jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("个测试用例后停止");
		}
		return jLabel9;
	}
	
	private JLabel getJLabel10() {
		if(jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("个错误后停止");
		}
		return jLabel10;
	}
	
	private JTextField getJTextField3() {
		if(jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setText("");
			jTextField3.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					jTextField3KeyPressed(evt);
				}
			});
		}
		return jTextField3;
	}
	
	private JLabel getJLabel11() {
		if(jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("概率调整参数：");
		}
		return jLabel11;
	}
	
	private void jTextField3KeyPressed(KeyEvent evt) {
		System.out.println("jTextField3.keyPressed, event="+evt);
		if (evt.getKeyChar() == '\n') {
			System.out.println(jTextField3.getText());
			double e = Double.parseDouble(jTextField3.getText());
			testSetting.put("Epsilon", jTextField3.getText());
		}
	}

}
