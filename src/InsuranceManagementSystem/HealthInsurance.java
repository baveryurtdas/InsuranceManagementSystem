package InsuranceManagementSystem;
import java.util.Date;

public class HealthInsurance extends Insurance{
    private int coveredMedicalExpenses;

    public HealthInsurance(String insuranceName, double insuranceFee, Date startDate, Date endDate, int coveredMedicalExpenses) {
        super(insuranceName, insuranceFee, startDate, endDate);
        this.coveredMedicalExpenses = coveredMedicalExpenses;
    }

    @Override
    public void calculate(){
        //Health'e özgü hesaplama
        System.out.println("Health Insurance Calculation");
    }

}
