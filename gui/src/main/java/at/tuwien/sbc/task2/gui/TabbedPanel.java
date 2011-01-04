package at.tuwien.sbc.task2.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabs;
    
    public TabbedPanel() {
        super(new GridLayout(1, 1));
        
        setTabs(new JTabbedPane());

        CreatePanel pnlOrg = new CreatePanel();
        pnlOrg.addComponentListener(pnlOrg);
        this.getTabs().addTab("Workers", null, pnlOrg, "Create Workers");
        this.getTabs().setMnemonicAt(0, KeyEvent.VK_1);
        
        // Add the tabbed pane to this panel.
        add(this.getTabs());
        
        // The following line enables to use scrolling tabs.
        this.getTabs().setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    public void setTabs(JTabbedPane tabs) {
        this.tabs = tabs;
    }

    public JTabbedPane getTabs() {
        return tabs;
    }
    
}