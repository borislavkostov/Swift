package businesslogic;

import education.Education;
import education.EducationDegree;
import insurance.SocialInsuranceRecord;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import personaldetails.Citizen;

public class SocialInsuranceChecker {

    public static boolean check(HttpServletRequest request, Citizen person) {
        boolean isChecked = false;
        if (request.getParameter("btSocialInsurance") != null) {
            isChecked = true;
        }
        for (Education education : person.getEducations()) {
            if (education.getDegree() == EducationDegree.Bachelor) {
                isChecked = true;
                break;
            } else if (education.getDegree() == EducationDegree.Doctorate) {
                isChecked = true;
                break;
            } else if (education.getDegree() == EducationDegree.Master) {
                isChecked = true;
                break;
            } else if (education.getDegree() == EducationDegree.Secondary) {
                isChecked = true;
                break;
            } else {
                isChecked = false;
                return isChecked;
            }
        }
        for (SocialInsuranceRecord soc : person.getSocialInsuranceRecords()) {
            if (soc.getYear() == Calendar.getInstance().get(Calendar.YEAR)) {
                if (soc.getMonth() == Calendar.getInstance().get(Calendar.MONTH) || soc.getMonth() == Calendar.getInstance().get(Calendar.MONTH - 1) || soc.getMonth() == Calendar.getInstance().get(Calendar.MONTH - 2)) {
                    isChecked=true;
                    break;
                }
            }else{
                isChecked=false;
            }
        }
        return isChecked;
    }
    public void SocialInsurance(boolean check,Citizen person){
        if(check==true){
            
        }
    }
}
