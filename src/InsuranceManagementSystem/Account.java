package InsuranceManagementSystem;


import java.util.ArrayList;
import java.util.Objects;

enum AuthenticationStatus {
    SUCCESS,
    FAIL
}

public abstract class Account implements Comparable<Account> {
    private AuthenticationStatus authenticationStatus;
    public int accountId;
    protected User user;
    protected ArrayList<Insurance> insurancesList;

    public Account(int accountId, User user) {
        this.accountId = accountId;
        this.user = user;
        this.insurancesList = new ArrayList<>();
    }

    public Account() {
        this.authenticationStatus = AuthenticationStatus.FAIL;
        this.user = null;

    }


    @Override
    public int compareTo(Account other) {
        return this.user.getEmail().compareTo(other.user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getEmail());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account other = (Account) obj;
        return Objects.equals(user.getEmail(), other.user.getEmail());
    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        //Burada email ve şifre kontrolü yapılır
        // Eğer doğruysa authenticationStatus SUCCESS, aksi halde FAIL döner.
        if (user != null && email.equalsIgnoreCase(user.getEmail()) && password.equals(user.getPassword())) {
            authenticationStatus = AuthenticationStatus.SUCCESS;
        } else {
            throw new InvalidAuthenticationException("Invalid email or password");
        }
    }



    // Adres Ekleme Fonksiyonu
    public void addAddress(Address address) {
        if (authenticationStatus == AuthenticationStatus.SUCCESS && user != null) {
            user.getAddressList().add(address);
            System.out.println("Adres added succesfully");
        } else {
            System.out.println("Authentication failed. Cannot add address.");
        }
    }

    public void removeAddress(Address address) {
        if (authenticationStatus == AuthenticationStatus.SUCCESS && user != null) {
            if (user.getAddressList().remove(address)) {
                System.out.println("Address removed succesfully.");
            } else {
                System.out.println("Address not found in user's address list");
            }
        } else {
            System.out.println("Authentication failed. Cannot remove address.");
        }
    }

    public void addInsurance(Insurance insurance) {
        if (authenticationStatus == AuthenticationStatus.SUCCESS && user != null) {
            insurancesList.add(insurance);
            System.out.println("Insurance added succesfully");
        } else {
            System.out.println("Authentication failed. Cannot add insurance.");
        }
    }


    public abstract void calculateBalance();

    public final void showUserInfo() {
        System.out.println("User Information : ");
        System.out.println("Name : " + user.getName() + " " + user.getSurname());
        System.out.println("Email : " + user.getEmail());
        System.out.println("Profession : " + user.getProfession());
        System.out.println("Age : " + user.getAge());
        System.out.println("Account Type : " + getClass().getSimpleName());



        System.out.println("Addresses : ");
        for (Address address : user.getAddressList()) {
            System.out.println("Address Type : " + address.getClass().getSimpleName());
            System.out.println("Street : " + address.getStreet());
            System.out.println("City : " + address.getCity());
            System.out.println("Zip Code : " + address.getZipCode());
            System.out.println("-------------");
        }

        System.out.println("Insurances : ");
        for(Insurance insurance : insurancesList){
            System.out.println("Insurance Name : " + insurance.getInsuranceName());
            System.out.println("Insurance Fee : "  + insurance.getInsuranceFee());
            System.out.println("Insurance Start Date : " + insurance.getStartDate());
            System.out.println("Insurance End Date : " + insurance.getEndDate());
            System.out.println("---------");
        }

    }
}
