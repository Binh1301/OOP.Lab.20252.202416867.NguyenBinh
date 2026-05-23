package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.screen.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField authorsField;

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book");
    }

    @Override
    protected JPanel createCenter() {
        JPanel wrapper = new JPanel(new BorderLayout());
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));

        titleField = new JTextField(20);
        categoryField = new JTextField(20);
        costField = new JTextField(20);
        authorsField = new JTextField(20);

        form.add(new JLabel("Title"));
        form.add(titleField);
        form.add(new JLabel("Category"));
        form.add(categoryField);
        form.add(new JLabel("Cost"));
        form.add(costField);
        form.add(new JLabel("Authors (comma separated)"));
        form.add(authorsField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> addBookToStore());

        wrapper.add(form, BorderLayout.CENTER);
        wrapper.add(addButton, BorderLayout.SOUTH);
        return wrapper;
    }

    private void addBookToStore() {
        Book book = new Book(titleField.getText(), categoryField.getText(),
                Float.parseFloat(costField.getText()));

        String authorsInput = authorsField.getText();
        if (authorsInput != null && !authorsInput.isBlank()) {
            String[] authors = authorsInput.split(",");
            for (String author : authors) {
                String trimmed = author.trim();
                if (!trimmed.isEmpty()) {
                    book.addAuthor(trimmed);
                }
            }
        }

        store.addMedia(book);
        new StoreManagerScreen(store);
        dispose();
    }
}
