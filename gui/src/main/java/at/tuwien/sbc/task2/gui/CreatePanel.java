package at.tuwien.sbc.task2.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import at.tuwien.sbc.task2.thread.ProduktionElfThread;
import at.tuwien.sbc.task2.worker.production.ProductionElf;
import at.tuwien.sbc.task2.xwmodel.TeddyBearPart;

public class CreatePanel extends javax.swing.JPanel implements ActionListener, ComponentListener {

	private static final Logger logger = Logger.getLogger(CreatePanel.class);
	private JPanel jPanel1;
	private JTextField errorRateTextField;
	private JComboBox partComboBox;
	private JButton createElfButton;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JTextField countTextField;
	private JTextField elfNameTextField;
	private JLabel errorRateLabel;
	private JLabel countLabel;
	private JLabel partLabel;
	private JLabel ElfNameLabel;

	public CreatePanel() {
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
				BorderLayout jPanel1Layout = new BorderLayout();
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(600, 184));
				jPanel1.setSize(new java.awt.Dimension(600, 54));
				{
					jPanel2 = new JPanel();
					GridLayout jPanel2Layout = new GridLayout(4, 2);
					jPanel2Layout.setColumns(2);
					jPanel2Layout.setHgap(5);
					jPanel2Layout.setVgap(5);
					jPanel1.add(jPanel2, BorderLayout.NORTH);
					jPanel2.setLayout(jPanel2Layout);
					jPanel2.setPreferredSize(new java.awt.Dimension(600, 137));
					jPanel2.setSize(new java.awt.Dimension(600, 150));
					{
						ElfNameLabel = new JLabel();
						jPanel2.add(ElfNameLabel);
						ElfNameLabel.setText("Name");
					}
					{
						elfNameTextField = new JTextField();
						jPanel2.add(elfNameTextField);
					}
					{
						partLabel = new JLabel();
						jPanel2.add(partLabel);
						partLabel.setText("Teddy Bear Part");
					}
					{
						ComboBoxModel partComboBoxModel = new DefaultComboBoxModel(TeddyBearPart.values());
						partComboBox = new JComboBox();
						jPanel2.add(partComboBox);
						partComboBox.setModel(partComboBoxModel);
					}
					{
						countLabel = new JLabel();
						jPanel2.add(countLabel);
						countLabel.setText("Count");
					}
					{
						countTextField = new JTextField();
						jPanel2.add(countTextField);
					}
					{
						errorRateLabel = new JLabel();
						jPanel2.add(errorRateLabel);
						errorRateLabel.setText("Error Rate");
					}
					{
						errorRateTextField = new JTextField();
						jPanel2.add(errorRateTextField);
					}
				}
				{
					jPanel3 = new JPanel();
					BorderLayout jPanel3Layout = new BorderLayout();
					jPanel1.add(jPanel3, BorderLayout.SOUTH);
					jPanel3.setLayout(jPanel3Layout);
					jPanel3.setPreferredSize(new java.awt.Dimension(600, 33));
					{
						createElfButton = new JButton();
						jPanel3.add(createElfButton, BorderLayout.EAST);
						createElfButton.setText("Create Elf");
						createElfButton.setPreferredSize(new java.awt.Dimension(98, 61));
						createElfButton.setSize(new java.awt.Dimension(100, 46));
						createElfButton.setActionCommand("createElfButton");
						createElfButton.addActionListener(this);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("createElfButton")) {
			new ProduktionElfThread(
					new ProductionElf(elfNameTextField.getText(), Integer.parseInt(errorRateTextField.getText()),
							(TeddyBearPart) partComboBox.getSelectedItem(), Integer.parseInt(countTextField.getText()))).start();
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

}
