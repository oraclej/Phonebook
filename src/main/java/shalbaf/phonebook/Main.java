package shalbaf.phonebook;

import shalbaf.phonebook.dao.ContactDAO;
import shalbaf.phonebook.entity.ContactEntity;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ContactDAO contactDAO = new ContactDAO();
        while (true){
            int item = Integer.parseInt(showMainMenu());
            switch (item) {
                case 1:
                    String mobile = showMenuSearchMobile();
                    ContactEntity contact = contactDAO.searchContact(mobile);
                    if(contact == null)
                        System.out.println("No Record Found");
                    else
                        System.out.println(contact);
                    break;
                case 2:
                    String[] arr = showMenuSearchNameFamily();
                    List<ContactEntity> list = contactDAO.searchAllContacts(arr[0], arr[1]);
                    if(list == null || list.isEmpty())
                        System.out.println("No record found");
                    else
                        for (ContactEntity contactEntity : list) {
                            System.out.println(contactEntity);
                        }
                    break;
                case 3:
                    String[] arr2 = showMenuAdd();
                    ContactEntity contactEntity = new ContactEntity();
                    contactEntity.setMobile(arr2[0]);
                    contactEntity.setName(arr2[1]);
                    contactEntity.setFamily(arr2[2]);
                    if(contactDAO.addContact(contactEntity))
                        System.out.println("One Record is added");
                    else
                        System.out.println("Can not add record");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    public static String showMainMenu() {
        System.out.println("Welcome to my phone book");
        System.out.println("1) Search by mobile no");
        System.out.println("2) Search by name or family");
        System.out.println("3) Add new Contact");
        System.out.println("0) Exit");
        System.out.print("Choose ant item>");
        return scanner.nextLine();
    }

    public static String showMenuSearchMobile() {
        System.out.print("Enter a mobile number>");
        return scanner.nextLine();
    }

    public static String[] showMenuSearchNameFamily() {
        System.out.print("Enter a name>");
        String name = scanner.nextLine();
        System.out.print("Enter a family>");
        String family = scanner.nextLine();
        String[] arr = {name, family};
        return arr;
    }

    public static String[] showMenuAdd() {
        System.out.print("Enter a mobile>");
        String mobile = scanner.nextLine();
        System.out.print("Enter a name>");
        String name = scanner.nextLine();
        System.out.print("Enter a family>");
        String family = scanner.nextLine();
        String[] arr = {mobile, name, family};
        return arr;
    }
}
