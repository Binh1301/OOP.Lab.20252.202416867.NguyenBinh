package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.screen.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected final Store store;

    protected AddItemToStoreScreen(Store store, String title) {
        this.store = store;

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(createNorth(), BorderLayout.NORTH);
        getContentPane().add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(1024, 768);
        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(e -> {
            new StoreManagerScreen(store);
            dispose();
        });
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            dispose();
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCdItem = new JMenuItem("Add CD");
        addCdItem.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            dispose();
        });
        smUpdateStore.add(addCdItem);

        JMenuItem addDvdItem = new JMenuItem("Add DVD");
        addDvdItem.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        });
        smUpdateStore.add(addDvdItem);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    protected abstract JPanel createCenter();
}
