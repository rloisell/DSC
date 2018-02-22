package mts.dsc.utilities;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.text.Position;

import org.orm.PersistentException;
import mts.dsc.activitycontainer.ActivityContainer;
import mts.dsc.employee.Employee;
import mts.dsc.orm.calendar.CalendarDAO;
import mts.dsc.orm.user_position.User_Position;
import mts.dsc.orm.user_position.User_PositionDAO;

public class UserReportGenerator {
	
	public static String[][] generateWeeklyReport(Employee e, GregorianCalendar startDate) {
		if(e==null||startDate==null) {return null;}
		while(startDate.get(Calendar.DAY_OF_WEEK)!=Calendar.THURSDAY) {
			startDate.add(Calendar.DAY_OF_WEEK, -1);
		}
		String[][] reportContent=new String[8][];
		String[] headings=getHeading();
		reportContent[0]=headings;
		GregorianCalendar temp=startDate;
		for(int i=0; i<7; i++) {
			String[][] daily=generateDailyReport(e, temp);
			temp.add(Calendar.DATE, 1);
			reportContent[i+1]=daily[1];
		}
		return reportContent;
	}
	
	public static String[][] generateDailyReport(Employee e, GregorianCalendar gC) {
		if(e==null||gC==null) {return null;}
		try {
			mts.dsc.orm.calendar.Calendar c=CalendarDAO.loadCalendarByORMID(gC.getTime());
			if(c==null) {throw new IllegalStateException(gC.getTime().toString());}
			e.setDate(c);
		}
		catch (PersistentException e2) {
			e2.printStackTrace();
		}
		String[][] reportContent=new String[2][];
		String[] headings=getHeading();
		reportContent[0]=headings;
		String[] column=new String[reportContent[0].length];
		for(int j=0; j<column.length; j++) {
			column[j]="0.0";
		}
		column[0]=getDay(gC);
		User_Position[] pA=null;
		try {
			pA = User_PositionDAO.listUser_PositionByQuery("UserempId="+e.getEmpId(), "startDate");
		}
		catch (PersistentException e1) {
			e1.printStackTrace();
		}
		column[4]=""+e.setRequiredHours(pA[pA.length-1].getPositionposition());
		ActivityContainer[] aCA = e.getTodaysActivities();
		double hours=0;
		for(ActivityContainer aC : aCA) {
			hours+=((double)(aC.getActualDuration())/60);
			if(aC.getBudget().getBudgetId()==1) {//expense
				column[3]=""+(Double.parseDouble(column[3])+((double)(aC.getActualDuration())/60));
			}
			else if(aC.getBudget().getBudgetId()==2) {//capital
				column[2]=""+(Double.parseDouble(column[2])+((double)(aC.getActualDuration())/60));
			}
			if(aC.getCategory().getCategoryID()==7) {//absent
				column[5]=""+(Double.parseDouble(column[5])+((double)(aC.getActualDuration())/60));
			}
			else if(aC.getCategory().getCategoryID()==3) {//sick
				column[6]=""+(Double.parseDouble(column[6])+((double)(aC.getActualDuration())/60));
			}
			else if(aC.getCategory().getCategoryID()==2) {//vacation
				column[7]=""+(Double.parseDouble(column[7])+((double)(aC.getActualDuration())/60));
			}
		}
		double oT=hours-Double.parseDouble(column[4]);
		if(oT<0) {oT=0;}
		column[1]=String.valueOf(oT);
		for(int i=1; i<column.length; i++) {
			column[i]=String.valueOf(format(Double.parseDouble(column[i])));
		}
		reportContent[1]=column;
		return reportContent;
	}
	
	private static String getDay(GregorianCalendar gC) {
		int i=gC.get(Calendar.DAY_OF_WEEK);
		if(i==Calendar.SUNDAY) {return "Sunday";}
		else if(i==Calendar.MONDAY) {return "Monday";}
		else if(i==Calendar.TUESDAY) {return "Tuesday";}
		else if(i==Calendar.WEDNESDAY) {return "Wednesday";}
		else if(i==Calendar.THURSDAY) {return "Thursday";}
		else if(i==Calendar.FRIDAY) {return "Friday";}
		else  {return "Saturday";}
	}
	
	private static String[] getHeading() {
		String[] headings=new String[8];
		headings[0]="Key Indicator";
		headings[1]="TOTAL1 Overtime";
		headings[2]="TOTAL2 Capital";
		headings[3]="TOTAL3 Expense";
		headings[4]="TOTAL4 Defined";
		headings[5]="TOTAL4 Absent";
		headings[6]="TOTAL5 Sick";
		headings[7]="TOTAL6 Vacation";
		return headings;
	}
	
	private static double format(double value) {
		long temp=Math.round(100*(value));
		return (double)temp/100;
	}
}
