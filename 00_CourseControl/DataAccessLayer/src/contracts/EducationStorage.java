package contracts;

import education.*;
import java.util.List;

public interface EducationStorage {

    public void insertEducation(Education education, int persoID) throws Exception;

    public List<Education> pullEducation(int id) throws Exception;

}
