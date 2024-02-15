package InsuranceManagementSystem;

public class EnterpriseAccount extends Account {


    public EnterpriseAccount(int accountId, User user) {
        super(accountId, user);

    }

    @Override
    public void addInsurance(Insurance insurance){
        super.addInsurance(insurance);
    }


    @Override
    public void calculateBalance() {

    }




}
