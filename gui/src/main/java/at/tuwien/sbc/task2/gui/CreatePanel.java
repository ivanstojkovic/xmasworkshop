package at.tuwien.sbc.task2.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class CreatePanel extends javax.swing.JPanel implements ActionListener, MouseListener,
        ComponentListener, ItemListener {

    private static final Logger logger = Logger.getLogger(CreatePanel.class);
    
    private JPanel pnlCenter;

    public CreatePanel() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            BorderLayout thisLayout = new BorderLayout();
            this.setLayout(thisLayout);
            this.setPreferredSize(new java.awt.Dimension(600, 600));
            this.setSize(600, 600);
            {
                pnlCenter = new JPanel();
                GridLayout pnlCenterLayout = new GridLayout(1, 2);
                pnlCenterLayout.setColumns(1);
                pnlCenterLayout.setHgap(5);
                pnlCenterLayout.setVgap(5);
                pnlCenter.setLayout(pnlCenterLayout);
                this.add(pnlCenter, BorderLayout.CENTER);
                pnlCenter.setPreferredSize(new java.awt.Dimension(600, 250));
                pnlCenter.setSize(600, 250);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
