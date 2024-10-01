import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Phonebook extends JFrame {
    private final ArrayList<Contact> phonebook;

    public Phonebook() {
        phonebook = new ArrayList<>();
        // Create GUI components and layout
        setTitle("Phonebook Application");
        setSize(400, 400);
        setLayout(new GridLayout(5, 2));

        // Fields for input
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();


        // Buttons for operations
        JButton addButton = new JButton("Add Contact");
        JButton searchButton = new JButton("Search Contact");
        JButton displayButton = new JButton("Display All");
        JButton deleteButton = new JButton("Delete Contact");
        JButton sortButton = new JButton("Sort Contacts");

        // Add components to the layout
        add(nameLabel); add(nameField);
        add(phoneLabel); add(phoneField);
        add(addButton); add(searchButton);
        add(displayButton); add(deleteButton);
        add(sortButton);

        // Add button actions
        addButton.addActionListener(e -> addContact(nameField.getText(), phoneField.getText()));
        searchButton.addActionListener(e -> searchContact(nameField.getText()));
        displayButton.addActionListener(e -> displayAllContacts());
        deleteButton.addActionListener(e -> deleteContact(nameField.getText()));
        sortButton.addActionListener(e -> sortContacts());

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // add contact method
    private void addContact(String name, String phone) {
        Contact contact = new Contact(name, phone);
        phonebook.add(contact);
        JOptionPane.showMessageDialog(this, "Contact Added");
    }

    // search contact method
    private void searchContact(String name) {
        for (Contact contact : phonebook) {
            if (contact.getName().equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(this, "Found: " + contact.getPhoneNumber());
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Contact Not Found");
    }
    //display all contacts method
    private void displayAllContacts() {
        StringBuilder contacts = new StringBuilder();
        for (Contact contact : phonebook) {
            contacts.append(contact.getName()).append(": ").append(contact.getPhoneNumber()).append("\n");
        }
        JOptionPane.showMessageDialog(this, contacts.toString());
    }
    //delete contact method
    private void deleteContact(String name) {
        phonebook.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
        JOptionPane.showMessageDialog(this, "Contact Deleted");
    }

    // sort contacts method
    private void sortContacts() {
        Collections.sort(phonebook, Comparator.comparing(Contact::getName));
        JOptionPane.showMessageDialog(this, "Contacts sorted by name.");
    }

}
