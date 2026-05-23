package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.screen.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField artistField;
    private JTextField directorField;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add CD");
    }

    @Override
    protected JPanel createCenter() {
        JPanel wrapper = new JPanel(new BorderLayout());
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));

        titleField = new JTextField(20);
        categoryField = new JTextField(20);
        costField = new JTextField(20);
        artistField = new JTextField(20);
        directorField = new JTextField(20);

        form.add(new JLabel("Title"));
        form.add(titleField);
        form.add(new JLabel("Category"));
        form.add(categoryField);
        form.add(new JLabel("Cost"));
        form.add(costField);
        form.add(new JLabel("Artist"));
        form.add(artistField);
        form.add(new JLabel("Director"));
        form.add(directorField);

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> addCdToStore());

        wrapper.add(form, BorderLayout.CENTER);
        wrapper.add(addButton, BorderLayout.SOUTH);
        return wrapper;
    }

    private void addCdToStore() {
        CompactDisc cd = new CompactDisc(titleField.getText(), categoryField.getText(),
                artistField.getText(), directorField.getText(), Float.parseFloat(costField.getText()));

        store.addMedia(cd);
        new StoreManagerScreen(store);
        dispose();
    }
}
