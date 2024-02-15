package InsuranceManagementSystem;

import java.util.Date;
import java.util.Calendar;

public abstract class Insurance {

    private String insuranceName;
    private double insuranceFee;
    private Date startDate;
    private Date endDate;

    public Insurance(String insuranceName, double insuranceFee, Date startDate, Date endDate) {
        this.insuranceName = insuranceName;
        this.insuranceFee = insuranceFee;
        this.startDate = startDate;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR,1);
        this.endDate = calendar.getTime();

    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public double getInsuranceFee() {
        return insuranceFee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public abstract void calculate();

}
