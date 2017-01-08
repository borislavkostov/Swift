package contracts;

import insurance.SocialInsuranceRecord;
import java.util.List;
import Exception.DALException;

public interface SocialInsuranceStorage {

    public void enterSocialInsurance(List<SocialInsuranceRecord> ins, int person_id) throws Exception;

    public List<SocialInsuranceRecord> pullSocialInsurance(int personID) throws DALException;
}
