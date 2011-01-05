package at.tuwien.sbc.task2.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.connection.CentralController;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;

public class TeddyBearOverviewPanel extends javax.swing.JPanel implements ActionListener, ComponentListener, ListSelectionListener {

	private static final Logger logger = Logger.getLogger(TeddyBearOverviewPanel.class);
	private JPanel jPanel1;
	private JList jList1;
	private JButton refreshButton;
	private JPanel jPanel2;
	private JTextArea teddyBearInfoTextArea;

	public TeddyBearOverviewPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(600, 253));
			this.setSize(600, 400);
			{
				jPanel1 = new JPanel();
				this.add(jPanel1, BorderLayout.NORTH);
				jPanel1.setLayout(null);
				jPanel1.setPreferredSize(new java.awt.Dimension(600, 337));
				jPanel1.setSize(new java.awt.Dimension(600, 54));
				{
					ListModel jList1Model = new DefaultComboBoxModel(getTeddyBearList());
					jList1 = new JList();
					jPanel1.add(jList1, "Center");
					jList1.setModel(jList1Model);
					jList1.setBounds(12, 12, 162, 325);
					jList1.setName("teddyBearList");
					jList1.addListSelectionListener(this);
				}
				{
					teddyBearInfoTextArea = new JTextArea();
					jPanel1.add(teddyBearInfoTextArea);
					teddyBearInfoTextArea.setBounds(186, 12, 800, 325);
				}
			}
			{
				jPanel2 = new JPanel();
				this.add(jPanel2, BorderLayout.SOUTH);
				jPanel2.setPreferredSize(new java.awt.Dimension(600, 38));
				jPanel2.setLayout(null);
				{
					refreshButton = new JButton();
					jPanel2.add(refreshButton);
					refreshButton.setText("Refresh");
					refreshButton.setBounds(22, 6, 58, 22);
					refreshButton.addActionListener(this);
					refreshButton.setActionCommand("refreshButton");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object[] getTeddyBearList() {
		logger.info("getTeddyBearList");
		return CentralController.getInstance().findTeddyBears().toArray();
	}

	public void actionPerformed(ActionEvent arg0) {
		logger.info("actionPerformed");
		if(arg0.getActionCommand().equals("refreshButton")) {
			updateTeddyBearList();
		}

	}

	private void updateTeddyBearList() {
		jList1.setModel(new DefaultComboBoxModel(getTeddyBearList()));
	}

	private void updateTextArea(TeddyBear tb) {
		if (tb == null) {
			teddyBearInfoTextArea.setText("");
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append(tb.toString()+"\n");
			sb.append(tb.getHat().toString()+"\n");
			sb.append(tb.getHead().toString()+"\n");
			sb.append(tb.getBody().toString()+"\n");
			sb.append(tb.getLeftHand().toString()+"\n");
			sb.append(tb.getRightHand().toString()+"\n");
			sb.append(tb.getLeftLeg().toString()+"\n");
			sb.append(tb.getRightLeg().toString()+"\n");
			teddyBearInfoTextArea.setText(sb.toString()+"\n");
		}
	}

	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		TeddyBear selectedTB = (TeddyBear) jList1.getSelectedValue();
		updateTextArea(selectedTB);
	}

}
