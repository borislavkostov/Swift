package contracts;

import insurance.SocialInsuranceRecord;

public interface SocialInsuranceStorage {

    public void enterSocialInsurance(SocialInsuranceRecord ins, int person_id) throws Exception;
}
