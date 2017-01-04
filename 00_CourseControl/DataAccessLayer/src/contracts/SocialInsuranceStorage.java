package contracts;

import insurance.SocialInsuranceRecord;
import java.util.List;

public interface SocialInsuranceStorage {

    public void enterSocialInsurance(SocialInsuranceRecord ins, int person_id) throws Exception;

    public List<SocialInsuranceRecord> pullSocialInsurance(int personID) throws Exception;
}
