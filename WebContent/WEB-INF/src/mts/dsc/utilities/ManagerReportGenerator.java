package mts.dsc.utilities;

import java.util.Collection;
import java.util.GregorianCalendar;

import org.orm.PersistentException;

import mts.dsc.employee.Employee;
import mts.dsc.orm.category.Category;
import mts.dsc.orm.category.CategoryDAO;

public class ManagerReportGenerator {
	
	public static String[][] generateWeeklyReport(Collection<Employee> employees, GregorianCalendar startDate) {
		String[][] reportContent=new String[9][];
		/*FIX THIS*/int numCategories=0;//FIX THIS
		String[] headings=new String[7+2*numCategories];
		
		
		return null;
	}
	
	public static String[][] generateYearlyReport(Collection<Employee> employees, GregorianCalendar startDate) {
		String[][] reportContent=new String[52][];
		GregorianCalendar temp=startDate;
		for(int i=0; i<52; i++) {
			String[][] week=generateWeeklyReport(employees, temp);
			reportContent[i+1]=week[8];
			temp.add(temp.DAY_OF_WEEK_IN_MONTH,7);
			if(i==0) {reportContent[0]=week[0];}
		}
		return reportContent;
	}
	
	private static void populateHeading(String[] headings) {
		headings[0]="Key Indicator";
		headings[1]="TOTAL1 Overtime";
		headings[2]="TOTAL2 Capital";
		headings[3]="TOTAL3 Expense";
		headings[4]="TOTAL4 Absent";
		headings[5]="TOTAL5 Sick";
		headings[6]="TOTAL6 Vacation";
		
		try {
			Category[] categories=CategoryDAO.listCategoryByQuery(null, null);
		} 
		catch (PersistentException e) {
			
		}
	}
}