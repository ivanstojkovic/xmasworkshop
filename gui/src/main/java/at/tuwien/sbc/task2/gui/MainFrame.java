package at.tuwien.sbc.task2.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import at.tuwien.sbc.task2.common.Constants;


/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
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
            ImageIcon cal = new ImageIcon(ClassLoader.getSystemResource("images/cal.png"));
            this.setIconImage(cal.getImage());
            {
                pnlGreet = new JPanel();
                getContentPane().add(pnlGreet, BorderLayout.NORTH);
                pnlGreet.setLayout(null);
                pnlGreet.setPreferredSize(new java.awt.Dimension(725, 69));
                {
                    lblGreet = new JLabel();
                    pnlGreet.add(lblGreet);
                    lblGreet.setText("You are currently not logged in");
                    lblGreet.setBounds(12, 13, 226, 15);
                }
            }
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
                {
                    jMenu2 = new JMenu();
                    menuBar.add(jMenu2);
                    jMenu2.setText("Help");
                    {
                        itmAbout = new JMenuItem();
                        jMenu2.add(itmAbout);
                        itmAbout.setText("About");
                        itmAbout.setActionCommand(Constants.CMD_MENU_ABOUT);
                        itmAbout.addActionListener(this);
                    }
                    {
                        itmClear = new JMenuItem();
                        jMenu2.add(itmClear);
                        itmClear.setText("Clear");
                        itmClear.setActionCommand(Constants.CMD_MENU_CLEAR);
                        itmClear.setBounds(-43, 19, 47, 23);
                        itmClear.addActionListener(this);
                    }
                    {
                        itmHelp = new JMenuItem();
                        jMenu2.add(itmHelp);
                        itmHelp.setText("Help");
                        itmHelp.setActionCommand(Constants.CMD_MENU_HELP);
                        itmHelp.addActionListener(this);
                    }
                }
            }
            {
                this.tabs = new TabbedPanel();
                this.tabs.enableTab(-1, false);
                getContentPane().add(this.tabs, BorderLayout.CENTER);
                tabs.setPreferredSize(new java.awt.Dimension(725, 357));
            }

            pack();
            this.setSize(643, 560);
        } catch (Exception e) {
            // add your error handling code here
            e.printStackTrace();
        }
    }

	public void actionPerformed(ActionEvent e) {

		
	}


}
