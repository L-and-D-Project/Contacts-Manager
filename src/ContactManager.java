import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContactManager {

    private final Input input = new Input();
    private final String directory = "./data";
    private final String fileName = "contacts.txt";
    Path dataDirectory = Paths.get(directory);
    Path dataFile = Paths.get(directory, fileName);
    private List<String> contacts;

    public void run() {
        readContactsFromFile();
        boolean exitNow = false;
        while (!exitNow) {
            displayMainMenu();
            int choice = input.getInt(1, 5, "Please enter your choice.");
            switch (choice) {
                case 1: viewFormattedContacts(); break;
                case 2: addContact(); break;
                case 3: // search contacts
                case 4: // delete contacts
                default: exitNow = true; break;
            }
        }
        System.out.println("Thank you.  Have a great day.");
        writeContactsToFile();
    }

    public boolean fileReady() {
        if (Files.notExists(dataDirectory)) {
            try {
                Files.createDirectories(dataDirectory);            }
            catch(IOException e) {
                System.out.println("There was an error creating the directory.");
                System.out.println(e.getMessage());
            }
        }
        if (Files.notExists(dataFile)) {
            try {
                Files.createFile(dataFile);            }
            catch(IOException e) {
                System.out.println("There was an error creating the file.");
                System.out.println(e.getMessage());
            }
        }
        return true;
    }

    public void readContactsFromFile () {
        if (fileReady()) {
            try {
                contacts = Files.readAllLines(dataFile);
            } catch (IOException e) {
                System.out.println("There was an error reading the file.");
                System.out.println(e.getMessage());
            }
        }
    }

    public void writeContactsToFile() {
        if (fileReady()) {
            try {
                Files.write(dataFile, contacts);
            } catch (IOException e) {
                System.out.println("There was an error writing to the file.");
                System.out.println(e.getMessage());
            }
        }
    }

    public void displayMainMenu() {
        System.out.println("Main menu:");
        System.out.println("1 - View contacts");// done
        System.out.println("2 - Add a contact");
        System.out.println("3 - Search contacts");
        System.out.println("4 - Delete a contact");
        System.out.println("5 - Exit"); // done
        System.out.println();
    }

    public void viewFormattedContacts() {
        System.out.println("Here are your contacts:");
        System.out.println();
        System.out.println("ID number | Name                | Phone Number |");
        System.out.println("------------------------------------------------");
        for (int i = 0 ; i < contacts.size(); i++) {
            String[] parts = contacts.get(i).split(",");
            System.out.printf("%-10d| %-20s| %-12s |%n", i, parts[0], parts[1]);
        }
        System.out.println();
    }

    public void addContact() {
        String name = input.getString("Please enter the name.");
        String number = input.getString("Please enter the number with no dashes.");
        String finalContact = name + "," + number;
        contacts.add(finalContact);
        System.out.println(name + " has been added with number: " + number);
        System.out.println();
    }

    public void searchForContact() {

    }

    public void deleteContact() {

    }

}
