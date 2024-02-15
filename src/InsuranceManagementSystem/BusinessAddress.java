package InsuranceManagementSystem;


public class BusinessAddress implements Address {
    private String street;
    private String city;
    private String zipCode;


    public BusinessAddress(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String getStreet(){
        return street;
    }
    @Override
    public String getCity(){
        return city;
    }
    public String getZipCode(){
        return zipCode;
    }
}
