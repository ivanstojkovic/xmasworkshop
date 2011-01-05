package at.tuwien.sbc.task2.gui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabs;
    
    public TabbedPanel() {
        super(new GridLayout(1, 1));
        
        setTabs(new JTabbedPane());

        CreatePanel createPanel = new CreatePanel();
        createPanel.addComponentListener(createPanel);
        this.getTabs().addTab("Workers", null, createPanel, "Create Workers");
        this.getTabs().setMnemonicAt(0, KeyEvent.VK_1);
        
        TeddyBearOverviewPanel teddyBearOverviewPanel = new TeddyBearOverviewPanel();
        teddyBearOverviewPanel.addComponentListener(teddyBearOverviewPanel);
        this.getTabs().addTab("Teddy Bear Overview", null, teddyBearOverviewPanel, "Teddy Bears Overview");
        this.getTabs().setMnemonicAt(0, KeyEvent.VK_2);

        PartsOverviewPanel teddyPartOverviewPanel = new PartsOverviewPanel();
        teddyPartOverviewPanel.addComponentListener(teddyPartOverviewPanel);
        this.getTabs().addTab("Teddy Parts Overview", null, teddyPartOverviewPanel, "Teddy Parts Overview");
        this.getTabs().setMnemonicAt(0, KeyEvent.VK_3);
        
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