package InsuranceManagementSystem;
import java.util.Date;

public class ResidenceInsurance extends Insurance{
    private int coveredPropertyDamage;

    public ResidenceInsurance(String insuranceName, double insuranceFee, Date startDate, Date endDate, int coveredPropertyDamage) {
        super(insuranceName, insuranceFee, startDate, endDate);
        this.coveredPropertyDamage = coveredPropertyDamage;
    }
    @Override
    public void calculate(){
        //ResidenceInsurance'a özgü hesaplama
        System.out.println("Residence Insurance Calculation ");
    }
}
