package at.tuwien.sbc.task2.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import at.tuwien.sbc.task2.common.Constants;

public class MainFrame extends javax.swing.JFrame implements ActionListener {

    private JTabbedPane tbPnl;
    private JPanel pnlOverview;
    private JMenuItem itmRemoveNotifications;
    private JMenuItem itmRead;
    private JMenuItem itmClear;
    private JMenu mnNotifications;
    private JLabel lblGreet;
    private JPanel pnlGreet;
    private JMenuItem itmLogout;
    private JMenuItem itmHelp;
    private JMenuItem itmAbout;
    private JMenuItem itmQuit;
    private JMenuItem itmLogReg;
    private JMenu jMenu2;
    private JMenu jMenu1;
    private JMenuBar menuBar;
    private JPanel pnlMain;
    private JLabel lbl2;
    private JLabel lbl;
    private JPanel pnlOrg;

    private TabbedPanel tabs;

    public MainFrame() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            BorderLayout thisLayout = new BorderLayout();
            // this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            getContentPane().setLayout(thisLayout);
            this.setTitle("XMasWorkshop");
            {
                menuBar = new JMenuBar();
                setJMenuBar(menuBar);
                {
                    jMenu1 = new JMenu();
                    menuBar.add(jMenu1);
                    jMenu1.setText("XMasWorkshop");
                    {
                        itmQuit = new JMenuItem();
                        jMenu1.add(itmQuit);
                        itmQuit.setText("Quit");
                        itmQuit.setActionCommand(Constants.CMD_MENU_QUIT);
                        itmQuit.addActionListener(this);
                    }
                }
            }
            {
                this.tabs = new TabbedPanel();
                getContentPane().add(this.tabs, BorderLayout.CENTER);
                tabs.setPreferredSize(new java.awt.Dimension(620, 450));
            }

            pack();
            this.setSize(620, 450);
        } catch (Exception e) {
            // add your error handling code here
            e.printStackTrace();
        }
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Constants.CMD_MENU_QUIT)) {
			this.dispose();
            System.exit(0);
		}
	}


}
