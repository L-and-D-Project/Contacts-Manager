import util.Input;

import java.io.File;
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
        System.out.println(contacts);
   /*
    psuedocode

    ------read contacts from file
    exitNow = false
       while (exitNow = false) {
       display the menu
       get choice
       switch (choice)
            1 - view contacts
            2- add new contact
            3 - search contacts
            4 - delete contact
            5 - exit; exitNow = true;
       }
    write contacts back to file

     */
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

    }

    public void getChoice () {
        // actually use something from input class
    }

    public void viewFormattedContacts() {

    }

    public void addContact() {
        //get input
        //format it
        //add it to contactList
    }

    public void searchForContact() {

    }

    public void deleteContact() {

    }

}
