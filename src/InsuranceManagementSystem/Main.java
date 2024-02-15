package InsuranceManagementSystem;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static int productAccountIdCounter = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        //Account Manager sınıfı oluşturma
        AccountManager accountManager = new AccountManager();
        //Kullanıcı kaydı oluşturma.
        System.out.println("Welcome Insurance Management System");
        System.out.println("Create a new account");
        Account newAccount = createAccount(scan);
        if (newAccount != null) {
            accountManager.addAccount(newAccount);

            System.out.print("Login - Email : ");
            String loginEmail = scan.nextLine();

            System.out.print("Login - Password : ");
            String loginPassword = scan.nextLine();

            Account loggedInAccount = login(accountManager, loginEmail, loginPassword);
            if (loggedInAccount != null) {
                System.out.println("Login Successful.");
                System.out.print("Do you want to add insurance ? (Yes/No) : ");
                String addInsuranceChoice = scan.nextLine().toLowerCase();
                if (addInsuranceChoice.equals("yes")) {
                    Insurance newInsurance = addInsurance(scan);
                    loggedInAccount.addInsurance(newInsurance);
                    System.out.println("Insurance added successfully");
                } else {
                    System.out.println("No insurance added.");
                }

                loggedInAccount.showUserInfo();
            } else {
                System.out.println("Login failed.");
            }

        } else {
            System.out.println("Account creation failed.");
        }


    }


    public static Account createAccount(Scanner scan) {


        System.out.print("Name : ");
        String name = scan.nextLine();

        System.out.print("Surname : ");
        String surname = scan.nextLine();

        System.out.print("Email : ");
        String email = scan.nextLine();

        System.out.print("Password : ");
        String password = scan.nextLine();

        System.out.print("Profession : ");
        String profession = scan.nextLine();

        System.out.print("Age : ");
        int age = scan.nextInt();
        scan.nextLine();

        User user = new User(name, surname, email, password, profession, age, new ArrayList<>(), null);

        //Ev adresini ekleme

        System.out.print("Home Adress - Street : ");
        String homeStreet = scan.nextLine();

        System.out.print("Home Adress - City : ");
        String homeCity = scan.nextLine();

        System.out.print("Home Address - ZipCode : ");
        String homeZipCode = scan.nextLine();

        Address homeAdress = new HomeAddress(homeStreet, homeCity, homeZipCode);
        AddressManager.addAddress(user, homeAdress);

        //İş Adresi Ekleme

        System.out.print("Busines Address - Street : ");
        String businessStreet = scan.nextLine();

        System.out.print("Busines Address - City : ");
        String businessCity = scan.nextLine();

        System.out.print("Busines Address - ZipCode : ");
        String businessZipCode = scan.nextLine();

        Address businessAdress = new BusinessAddress(businessStreet, businessCity, businessZipCode);
        AddressManager.addAddress(user, businessAdress);


        char accountType;

        do {
            System.out.print("Create an Individual(I) or Enterprise (E) account : ");
            accountType = scan.nextLine().toUpperCase().charAt(0);
        } while (accountType != 'I' && accountType != 'E');


        switch (accountType) {
            case 'I':
                return new IndividualAccount(productAccountIdCounter, user);

            case 'E':
                return new EnterpriseAccount(productAccountIdCounter++, user);

            default:
                System.out.println("Invalid Option");
                break;

        }
        return null;

    }

    public static Account login(AccountManager accountManager, String email, String password) {
        //Account manager sınıfında ki login metodunu çağırma
        return accountManager.login(email, password);
    }

    public static Insurance addInsurance(Scanner scan) {
        System.out.println("Please select the insurance you want to have");
        System.out.println("1 - Health Insurance");
        System.out.println("2 - Car Insurance");
        System.out.println("3 - Residence Insurance");
        System.out.println("4 - Travel Insurance");
        int insuranceType;

        do {
            System.out.print("Enter your choice(1-4) :");
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scan.next();
            }
            insuranceType = scan.nextInt();
        } while (insuranceType < 1 || insuranceType > 4);
        scan.nextLine();

        switch (insuranceType) {
            case 1:
                return new HealthInsurance("Health Insurance", 1000, new Date(), new Date(), 10000);
            case 2:
                return new CarInsurance("Car Insurance", 2000, new Date(), new Date(), 20000);
            case 3:
                return new ResidenceInsurance("Residence Insurance", 5000, new Date(), new Date(), 50000);
            case 4:
                return new TravelInsurance("Travel Insurance", 500, new Date(), new Date(), "1000 km");
            default:
                System.out.println("Invalid Option");
                break;
        }

        return null;
    }


}
