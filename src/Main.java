import java.util.Scanner;

public class Main {

    private static Scanner scanner= new Scanner(System.in);
    private static MobilePhone myContacts = new MobilePhone("01230120");

    public static void main(String[] args) {
        System.out.println("welcome to Mahdi Project 0.00");
        startPhone();
        printActions();
        boolean quit = false;
        while (!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("shutting down...");
                    quit = true;
                    break;
                case 1:
                    myContacts.printContacts();
                    break;
                case 2 :
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContacts();
                    break;
                case 6:
                    printActions();
            }

        }

    }
    private static void startPhone(){
        System.out.println("Starting phone...");
    }
    private static void printActions(){
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - to shutdown\n"+
                "1 - to display contacts\n"+
                "2 - to add a new contact\n"+
                "3 - to update existing contact\n"+
                "4 - to remove existing contact\n"+
                "5 - search contacts\n"+
                "6 - print actions list");
        System.out.println("choose your action: ");
    }

    private static void addContact(){
        System.out.println("enter name");
        String name = scanner.nextLine();
        System.out.println("enter phone number");
        String number = scanner.nextLine();
        Contacts contact = new Contacts(name,number);
        if (myContacts.addNewContact(contact)){
            System.out.println("contact has been added");
        }

    }
    private static void updateContact(){
        System.out.println("enter contact name");
        String oldName = scanner.nextLine();
//        myContacts.queryContact(oldName);
        Contacts oldContact = myContacts.queryContact(oldName);

        System.out.println("enter new name");
        String newName = scanner.nextLine();
        System.out.println("enter new number");
        String newNumber = scanner.nextLine();
        Contacts newContact = new Contacts(newName,newNumber);

        myContacts.updateContact(oldContact,newContact);
    }
    private static void removeContact(){
        System.out.println("enter contact to be removed");
        String name = scanner.nextLine();
        Contacts removeContact = myContacts.queryContact(name);
        myContacts.removeContact(removeContact);
    }
    private static void searchContacts(){
        System.out.println("enter contact Name: ");
        String name = scanner.nextLine();
        myContacts.queryContact(myContacts.queryContact(name));
    }

}
