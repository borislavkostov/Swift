package businesslogic;

import education.Education;
import education.EducationDegree;
import insurance.SocialInsuranceRecord;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import personaldetails.Citizen;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class SocialInsuranceChecker {

    public static boolean check(Citizen person) {
        boolean check = false;
        for (Education education : person.getEducations()) {
            if (education != null && education.getDegree() != EducationDegree.Primary) {
                check = true;
                break;
            } else {
                check = false;
            }
        }
        if(check){
        for (SocialInsuranceRecord soc : person.getSocialInsuranceRecords()) {
            YearMonth ym = YearMonth.of(soc.getYear(), soc.getMonth());
            int month = (Calendar.getInstance().get(Calendar.MONTH)-3)+13;
            int year = Calendar.getInstance().get(Calendar.YEAR);
            if(month>Calendar.getInstance().get(Calendar.MONTH)){
                year-=1;
            }
            if (ym.compareTo(YearMonth.of(year, month)) <= 0) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        }else{
            return check;
        }
        return check;
    }

    public static double sumAmount(Citizen person) {
        List<Double> dbList=new ArrayList<>();
        for (SocialInsuranceRecord soc : person.getSocialInsuranceRecords()) {
            YearMonth ym = YearMonth.of(soc.getYear(), soc.getMonth());
            int month = (Calendar.getInstance().get(Calendar.MONTH)-3)+13;
            int year = Calendar.getInstance().get(Calendar.YEAR);
            if (ym.compareTo(YearMonth.of(year - 2, month)) > 0) {
                dbList.add(soc.getAmount());
            }
        }
         Double average = dbList.stream().mapToDouble(val -> val).average().getAsDouble();
        return average;
    }
}
