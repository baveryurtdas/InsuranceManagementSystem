package InsuranceManagementSystem;
import java.util.Date;

public class TravelInsurance extends Insurance{
    private final String travelDestination;

    public TravelInsurance(String insuranceName, double insuranceFee, Date startDate, Date endDate, String travelDestination) {
        super(insuranceName, insuranceFee, startDate, endDate);
        this.travelDestination = travelDestination;
    }

    @Override
    public void calculate(){
        //TravelInsurance'a özgü hesaplama
        System.out.println("Travel Insurance Calculation");
    }
}
