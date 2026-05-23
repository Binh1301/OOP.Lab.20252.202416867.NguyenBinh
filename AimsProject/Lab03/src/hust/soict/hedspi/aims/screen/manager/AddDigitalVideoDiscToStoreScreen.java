package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField directorField;
    private JTextField lengthField;
    private JTextField costField;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD");
    }

    @Override
    protected JPanel createCenter() {
        JPanel wrapper = new JPanel(new BorderLayout());
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));

        titleField = new JTextField(20);
        categoryField = new JTextField(20);
        directorField = new JTextField(20);
        lengthField = new JTextField(20);
        costField = new JTextField(20);

        form.add(new JLabel("Title"));
        form.add(titleField);
        form.add(new JLabel("Category"));
        form.add(categoryField);
        form.add(new JLabel("Director"));
        form.add(directorField);
        form.add(new JLabel("Length"));
        form.add(lengthField);
        form.add(new JLabel("Cost"));
        form.add(costField);

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(e -> addDvdToStore());

        wrapper.add(form, BorderLayout.CENTER);
        wrapper.add(addButton, BorderLayout.SOUTH);
        return wrapper;
    }

    private void addDvdToStore() {
        DigitalVideoDisc dvd = new DigitalVideoDisc(titleField.getText(), categoryField.getText(),
                directorField.getText(), Integer.parseInt(lengthField.getText()),
                Float.parseFloat(costField.getText()));

        store.addMedia(dvd);
        new StoreManagerScreen(store);
        dispose();
    }
}
