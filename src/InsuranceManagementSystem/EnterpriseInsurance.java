package InsuranceManagementSystem;

import java.util.Date;

public class EnterpriseInsurance extends Insurance{
    private String coverageType;

    public EnterpriseInsurance(String insuranceName, double insuranceFee, Date startDate, Date endDate, String coverageType) {
        super(insuranceName, insuranceFee, startDate, endDate);
        this.coverageType = coverageType;
    }

    @Override
    public void calculate(){
        //Enterprise'a özgü hesaplama.
        System.out.println("Enterprise Insurance Calculation");
    }
}
