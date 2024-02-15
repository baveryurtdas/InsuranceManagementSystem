package InsuranceManagementSystem;
import java.util.Date;
public class CarInsurance extends Insurance {
    private int coveredAccidents;

    public CarInsurance(String insuranceName, double insuranceFee, Date startDate, Date endDate, int coveredAccidents) {
        super(insuranceName, insuranceFee, startDate, endDate);
        this.coveredAccidents = coveredAccidents;
    }

    @Override
    public void calculate(){
        // Car Insurance'a özgü hesaplama
        System.out.println("Car Insurance Calculation");
    }
}
