package InsuranceManagementSystem;

public  class IndividualAccount extends Account{

    private String insuranceType;

    public IndividualAccount(int accountId, User user) {
        super(accountId, user);
        this.insuranceType = insuranceType;
    }

    @Override
    public void addInsurance(Insurance insurance){

        super.addInsurance(insurance);
    }


    @Override
    public void calculateBalance() {

    }

}
