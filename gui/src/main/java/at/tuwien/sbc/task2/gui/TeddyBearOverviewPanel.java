package at.tuwien.sbc.task2.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.BorderFactory;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.connection.CentralController;
import at.tuwien.sbc.task2.xwmodel.TeddyBear;


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
public class TeddyBearOverviewPanel extends javax.swing.JPanel implements ActionListener, ComponentListener, ListSelectionListener {

	private static final Logger logger = Logger.getLogger(TeddyBearOverviewPanel.class);
	private JPanel jPanel1;
	private JList jList1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JList jList3;
    private JList jList2;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane3;
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
				jPanel2 = new JPanel();
				this.add(jPanel2, BorderLayout.SOUTH);
				jPanel2.setPreferredSize(new java.awt.Dimension(600, 68));
				jPanel2.setLayout(null);
				{
					refreshButton = new JButton();
					jPanel2.add(refreshButton);
					refreshButton.setText("Refresh");
					refreshButton.setBounds(21, 21, 99, 22);
					refreshButton.addActionListener(this);
					refreshButton.setActionCommand("refreshButton");
				}
			}
			{
			    jPanel1 = new JPanel();
                this.add(jPanel1, BorderLayout.NORTH);
			    jPanel1.setLayout(null);
			    jPanel1.setPreferredSize(new java.awt.Dimension(600, 337));
			    jPanel1.setSize(new java.awt.Dimension(600, 54));
			    {
			        jScrollPane1 = new JScrollPane();
			        jPanel1.add(jScrollPane1);
			        jScrollPane1.setBounds(8, 4, 207, 109);
                    jScrollPane1.setBorder(BorderFactory.createTitledBorder("Teddy Bear Container"));
			        {
			            ListModel jList1Model = new DefaultComboBoxModel(getTeddyBearList());
			            jList1 = new JList();
			            jScrollPane1.setViewportView(jList1);
			            jList1.setModel(jList1Model);
			            jList1.setBounds(12, 12, 162, 325);
			            jList1.setName("teddyBearList");
                        jList1.setPreferredSize(new java.awt.Dimension(162, 325));
			            jList1.addListSelectionListener(this);
			        }
			    }
			    {
			        jScrollPane2 = new JScrollPane();
			        jPanel1.add(jScrollPane2);
			        jScrollPane2.setBounds(227, 12, 367, 313);
			        {
			            teddyBearInfoTextArea = new JTextArea();
                        jScrollPane2.setViewportView(teddyBearInfoTextArea);
			            teddyBearInfoTextArea.setBounds(148, 7, 447, 328);
                        teddyBearInfoTextArea.setPreferredSize(new java.awt.Dimension(434, 321));
			        }
			    }
			    {
			        jScrollPane3 = new JScrollPane();
			        jPanel1.add(jScrollPane3);
                    jScrollPane3.setBounds(12, 125, 197, 93);
                    jScrollPane3.setBorder(BorderFactory.createTitledBorder("Logistics Container"));
                    {
                        ListModel jList2Model = 
                            new DefaultComboBoxModel(this.getReadyTeddyBearsList());
                        jList2 = new JList();
                        jScrollPane3.setViewportView(jList2);
                        jList2.setModel(jList2Model);
                        jList2.setPreferredSize(new java.awt.Dimension(187, 115));
                        jList2.addListSelectionListener(this);
                    }
			    }
			    {
			        jScrollPane4 = new JScrollPane();
			        jPanel1.add(jScrollPane4);
                    jScrollPane4.setBounds(12, 236, 197, 89);
                    jScrollPane4.setBorder(BorderFactory.createTitledBorder("Defective Container"));
                    {
                        ListModel jList3Model = 
                            new DefaultComboBoxModel(this.getDefectiveTeddyBearList());
                        jList3 = new JList();
                        jScrollPane4.setViewportView(jList3);
                        jList3.setModel(jList3Model);
                        jList3.addListSelectionListener(this);
                    }
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object[] getDefectiveTeddyBearList() {
	    logger.info("getDefectiveTeddyBearList");
        return CentralController.getInstance().findDefectiveTeddyBears().toArray();
    }

    private Object[] getReadyTeddyBearsList() {
        logger.info("getReadyTeddyBearList");
        return CentralController.getInstance().findReadyTeddyBears().toArray();
    }

    private Object[] getTeddyBearList() {
		logger.info("getTeddyBearList");
		return CentralController.getInstance().findTeddyBears().toArray();
	}

	public void actionPerformed(ActionEvent arg0) {
		logger.info("actionPerformed");
		if(arg0.getActionCommand().equals("refreshButton")) {
			updateTeddyBearLists();
		}

	}

	private void updateTeddyBearLists() {
		jList1.setModel(new DefaultComboBoxModel(getTeddyBearList()));
		jList2.setModel(new DefaultComboBoxModel(getReadyTeddyBearsList()));
		jList3.setModel(new DefaultComboBoxModel(getDefectiveTeddyBearList()));
	}

	private void updateTextArea(TeddyBear tb) {
		if (tb == null) {
			teddyBearInfoTextArea.setText("");
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append(tb.toString()+"\n");
			sb.append("ready= " + tb.isReady() +"\n");
			sb.append("defective= " +tb.isDefective() +"\n");
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
	public void valueChanged(ListSelectionEvent evt) {
	    TeddyBear selectedTB = null;
	    if (evt.getSource() == jList1) {
	        selectedTB = (TeddyBear) jList1.getSelectedValue();
	        
	    } else if (evt.getSource() == jList2) {
	        selectedTB = (TeddyBear) jList2.getSelectedValue();
	        
	    } else if (evt.getSource() == jList3) {
	        selectedTB = (TeddyBear) jList3.getSelectedValue();
	    }
	    
		updateTextArea(selectedTB);
	}

}
