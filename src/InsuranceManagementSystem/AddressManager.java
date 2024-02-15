package InsuranceManagementSystem;

public class AddressManager {
    public static void addAddress(User user, Address address) {
        if (user != null && address != null) {
            user.getAddressList().add(address);
            System.out.println("Adres eklendi:" + address.getStreet() + "," + address.getCity() + "," + address.getZipCode());
        } else {
            System.out.println("Geçersiz kullanıcı veya adres bilgisi.");
        }
    }

    public static void removeAddress(User user, Address address) {
        if (user != null && address != null) {
            if (user.getAddressList().remove(address)) {
                System.out.println("Adres çıkarıldı:" + address.getStreet() + "," + address.getCity() + "," + address.getZipCode());
            }else{
                System.out.println("Belirtilen adres kullanıcının adres defterinde bulunamadı.");
            }
        }else{
            System.out.println("Geçersiz kullanıcı veya adres bilgisi.");
        }
    }
}
