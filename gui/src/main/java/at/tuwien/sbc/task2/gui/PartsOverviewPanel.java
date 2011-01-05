package at.tuwien.sbc.task2.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.connection.CentralController;
import at.tuwien.sbc.task2.interfaces.TeddyPart;


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
public class PartsOverviewPanel extends javax.swing.JPanel implements ActionListener, ComponentListener {

	private static final Logger logger = Logger.getLogger(PartsOverviewPanel.class);
	private JPanel jPanel1;
	private JTextArea partTextArea;
	private JScrollPane textAreaScrollPanel;
	private JButton refreshButton;
	private JPanel jPanel2;

	public PartsOverviewPanel() {
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
					textAreaScrollPanel = new JScrollPane();
					jPanel1.add(textAreaScrollPanel);
					textAreaScrollPanel.setBounds(12, 12, 576, 336);
					{
						partTextArea = new JTextArea();
						textAreaScrollPanel.setViewportView(partTextArea);
						partTextArea.setBounds(24, 12, 552, 325);
						partTextArea.setEditable(false);
					}
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

	private List<TeddyPart> getTeddyPartList() {
		return CentralController.getInstance().findTeddyParts();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("refreshButton")) {
			updateTextArea();
		}

	}

	private void updateTextArea() {
		StringBuffer sb = new StringBuffer();
		for(TeddyPart tp : getTeddyPartList()) {
			sb.append(tp.toString()+"\n");
		}
		partTextArea.setText(sb.toString() + "\n");
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

}
