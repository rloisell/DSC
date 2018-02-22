/* THIS IS THE EMPLOYEE CLASS:
 * THE EMPLOYEE CLASS HANDLES ALL THE BUSINESS LOGIC OF ADDING/RECORDING THE ACTIVITIES TO THE LOCAL DATA STRUCTURE
 * WHICH IN THE PROCESS SAVES THE INFO TO THE DATABAS USING THE ACTITIVY CONTAINER METHODS PROVIDED TO IT.
 * THE USER WOULD INTERACT WITH THIS OBJECT TO UPDATE CHANGE PERSONAL INFORMATION AS WELL USING ACCESSOR METHODS
 */
package mts.dsc.employee;

import java.text.SimpleDateFormat;
import java.util.*;

import org.orm.*;

import mts.dsc.activitycontainer.*;
import mts.dsc.orm.*;
import mts.dsc.orm.position.Position;
import mts.dsc.orm.user_position.User_Position;


/**
 * @author loiselle
 *
 */
public class EmployeeTest4{
	// LOCAL REFERENCE TO USER
	private mts.dsc.orm.user.User aUser;
	
	// LOCAL REFERENCE TO POSITIONS
	private Set myPositions;
	private Object positionsArray[];
	private mts.dsc.orm.position.Position aPosition;
	
	// CURRENT HOURS AND REQUIRED HOURS
	private double requiredHours = 0;
	private double hours = 0;
	private double overtime = 0;
	
	// ACTIVITIES COLLECTION
	private ActivityContainer[] todaysActivities;
	
	// LOCAL REFERENCE TO DATE
	private mts.dsc.orm.calendar.Calendar today;
	private String dateFormatString = new String("yyyy-MM-dd");
	private SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
	
	private String yearFormatString = new String("yyyy");
	private SimpleDateFormat yearFormat = new SimpleDateFormat(yearFormatString);
	
	private String monthFormatString = new String("MM");
	private SimpleDateFormat monthFormat = new SimpleDateFormat(monthFormatString);
	
	private String dayFormatString = new String("dd");
	private SimpleDateFormat dayFormat = new SimpleDateFormat(dayFormatString);
	
	// DEFAULT CONSTRUCTOR
	public EmployeeTest4() {
	}
	
	// CONSTRUCTOR TO POPULATE EMPLOYEE WITH USER, POSITION, ETC
	public EmployeeTest4( mts.dsc.orm.user.User aUser ) {
		// POPULATE EMPLOYEE WITH CURRENT USER
		this.aUser = aUser;
		
		// POPULATE EMPLOYEE WITH USERS CURRENT POSITION

		this.myPositions = aUser.getUser_Position();
		this.positionsArray = myPositions.toArray();
		this.aPosition = ((User_Position)positionsArray[myPositions.size() - 1]).getPositionposition();
		
		// LOAD TODAYS ACTIVITIES
		try {
			Date todaysDate = new Date();
			today = mts.dsc.orm.calendar.CalendarDAO.loadCalendarByORMID(todaysDate);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		todaysActivities = getTodaysActivities();
		
		
		// POPULATE EMPLOYEE WITH REQUIRED HOURS IF NOT A MANAGER
		if ( aPosition.getPositionID() != 4) {
			requiredHours = setRequiredHours( aPosition );
		}
	} // END CONSTRUCTOR
	
	// METHODS

	// SET REQUIRED HOURS
	// FUTURE: ADD ADDITIONAL TO DEAL WITH NON FULL TIME EMPLOYEES
	public double setRequiredHours( mts.dsc.orm.position.Position curPosition ) {
		double reqHrs = 0;
		if ( today.getCalendar_CategorycalendarCategory().getCalendarCategory() != 0 ) {
			return reqHrs;
		}
		else {
			mts.dsc.orm.union.Union myUnion = curPosition.getUnionunion();
			if ((myUnion.getUnionId() == 0)&&(curPosition.getStatus().equalsIgnoreCase("FT"))) {
				reqHrs = 7.5;
				return reqHrs;
			} else if ((myUnion.getUnionId() == 1)&&(curPosition.getStatus().equalsIgnoreCase("FT"))) {
				reqHrs = 7.38;	
				return reqHrs;
			} else if ((myUnion.getUnionId() == 2)&&(curPosition.getStatus().equalsIgnoreCase("FT"))) {
				reqHrs = 7.25;
				return reqHrs;
			}
		}
		return -1;
	} // END SET REQUIRED HOURS
	
	// GET OVER TIME
	public double getOvertime() {
		return overtime;
	}	
	
	// SET DATE WITH mts.dsc.orm.calendar.Calendar
	public void setDate(mts.dsc.orm.calendar.Calendar aDate) {
		today = aDate;
	} // END SET DATE
	
	// SET DATE WITH YEAR, MONTH, DATE FROM JS CALENDAR
	public void setDate(int year, int month, int date) {
		java.util.Date aDate = new Date(year-month-date);
		try {
			today = mts.dsc.orm.calendar.CalendarDAO.loadCalendarByORMID(aDate);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// GET DATE
	public mts.dsc.orm.calendar.Calendar getDate() {
		return today;
	} // END GET DATE
	
	// GET REGUIRED HOURS
	public double getRequiredHours() {
		return this.requiredHours;
	} // END GET REQUIRED HOURS
	
	// GET CURRENT HOURS
	public double getCurrentHours() {
		return this.hours;
	} // END CURRENT HOURS
	
	// GET EMPLOYEE ID
	public int getEmpId() {
		return aUser.getEmpId();
	}
	
	// SET ROLE ID - CONTROLS USER, MGR, SYS ADMIN ACCESS
	public void setRole(int roleId) {
		aUser.setRoleID(roleId);
		try {
			mts.dsc.orm.user.UserDAO.save(aUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SET ROLD ID
	
	// GET ROLE ID - CONTROLS USER, MGR, SYS ADMIN ACCESS
	public int getRole() {
		return aUser.getRoleID();
	} // END GET ROLE ID
	
	// SET FIRST NAME
	public void setFirstName( String fName ) {
		aUser.setFirstName(fName);
		try {
			mts.dsc.orm.user.UserDAO.save(aUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SET FIRST NAME
	
	// GET FIRST NAME
	public String getFirstName() {
		return aUser.getFirstName();
	} // END GET FIRST NAME
	
	// SET LAST NAME
	public void setLastName( String lName ) {
		aUser.setLastName(lName);
		try {
			mts.dsc.orm.user.UserDAO.save(aUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SET LAST NAME
	
	// GET LAST NAME
	public String getLastName() {
		return aUser.getLastName();
	} // END GET LAST NAME
	
	// SET EMAIL
	public void setEmail( String email ) {
		aUser.setEmail(email);
		try {
			mts.dsc.orm.user.UserDAO.save(aUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SET EMAIL
	
	// GET EMAIL
	public String getEmail() {
		return aUser.getEmail();
	} // END GET EMAIL
	
	// SET NCS DATE
	public void setNCS( java.util.Date aDate ) {
		aUser.setNcsDate(aDate);
		try {
			mts.dsc.orm.user.UserDAO.save(aUser);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SET NCS
	
	// GET NCS DATE
	public java.util.Date getNCS() {
		return aUser.getNcsDate();
	}
	
	// GET POSITION 
	public String getPositionDesc() {
		return aPosition.getDescription();
	}
	
	// ADD ACTIVITY
	public void setActivity( mts.dsc.activitycontainer.ActivityContainer anActivity ) {
		// ADDING CURRENT ACTIVITY, REMEMBERING TO CALL ACTIVITYCONTAINER.SAVE()
		anActivity.setCalandardate(today);
		mts.dsc.activitycontainer.ActivityContainer [] addedActivities = new mts.dsc.activitycontainer.ActivityContainer[todaysActivities.length + 1];
		System.arraycopy(todaysActivities, 0, addedActivities, 0, todaysActivities.length) ;
		hours += anActivity.getActualDuration();
		if (hours > getRequiredHours()) {
			overtime = hours - getRequiredHours();
		}
		anActivity.save();
		} // END SET ACTIVITY
	
	// RETURN TODAYS ACTIVITIES
	public mts.dsc.activitycontainer.ActivityContainer[] getTodaysActivities() {
		todaysActivities = getDateActivities(today);
		return todaysActivities;
	} // END GET TODAYS ACTIVITIES
	
	// RETURN <DATE> ACTIVITIES
	public mts.dsc.activitycontainer.ActivityContainer[] getDateActivities(mts.dsc.orm.calendar.Calendar aDate) {
		mts.dsc.activitycontainer.ActivityContainer [] loadTodaysActivities = new mts.dsc.activitycontainer.ActivityContainer [0];
		try {
			hours = 0;
			
			/*
			 * USED THIS TO DETERMINE PROPER FORMAT OF DATE TO USE FOR QUERY
			System.out.println("DATE FORMAT, GET DATE ACTIVITIES: "+ dateFormat.format(aDate.getDate()) +" FOR: "+aUser.getEmpId());
			int yyyy = Integer.parseInt(yearFormat.format(aDate.getDate()));
			int mm = Integer.parseInt(monthFormat.format(aDate.getDate()));
			int dd = Integer.parseInt(dayFormat.format(aDate.getDate()));
			System.out.println(" INTEGER --> : "+ yyyy +"-"+ mm +"-"+ dd);
			java.util.Date now = new Date(yyyy-mm-dd);
			System.out.println(" DATE -----> : "+ now);
			*/
			
			String myDate = dateFormat.format(aDate.getDate());
			System.out.println(" STRING ---> : "+ myDate);
			
			String myQuery = new String("UserempId="+ aUser.getEmpId() +" AND Calendardate=\'"+ myDate +"\'");
			mts.dsc.orm.activity.Activity [] allActivities = mts.dsc.orm.activity.ActivityDAO.listActivityByQuery(myQuery, "activityID");
			loadTodaysActivities = new mts.dsc.activitycontainer.ActivityContainer[allActivities.length];
			// LOAD MY ACTIVITIES
			for( int x = 0; x < allActivities.length; x++ ) {
				mts.dsc.orm.activity.Activity anActivity = (mts.dsc.orm.activity.Activity) allActivities[x];
				if ( anActivity.getUseremp().getEmpId() == aUser.getEmpId() ) {
					mts.dsc.activitycontainer.ActivityContainer curActivity = new mts.dsc.activitycontainer.ActivityContainer(anActivity.getBudgetbudget().getBudgetId());
					curActivity.setActivity(anActivity);
					if ( anActivity.getBudgetbudget().getBudgetId() == 1) {
						String actID; 
						actID = String.valueOf(anActivity.getBudgetbudget().getBudgetId());
						mts.dsc.orm.expense_activity.Expense_Activity expA = mts.dsc.orm.expense_activity.Expense_ActivityDAO.loadExpense_ActivityByQuery("ActivityactivityID="+actID, null);
						curActivity.setExpActivity(expA);
					}
					else if ( anActivity.getBudgetbudget().getBudgetId() == 2) {
						String actID; 
						actID = String.valueOf(anActivity.getBudgetbudget().getBudgetId());
						mts.dsc.orm.project_activity.Project_Activity proA = mts.dsc.orm.project_activity.Project_ActivityDAO.loadProject_ActivityByQuery("ActivityactivityID="+actID, null);
						curActivity.setProActivity(proA);
					}
					loadTodaysActivities[x] = curActivity;
					hours += anActivity.getActualDuration();
					if (hours > getRequiredHours()) {
						overtime = hours - getRequiredHours();
					}
				}
			}
			return loadTodaysActivities;
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		return loadTodaysActivities;
	} // END RETURN <DATE> ACTIVITIES
	
	// REFRESH MY SELF
	public void refresh() {
		// ADD CODE TO REFRESH VARIOUS OBJECT HERE
		try {
			mts.dsc.orm.user.UserDAO.refresh(aUser);
			mts.dsc.orm.position.PositionDAO.refresh(aPosition);
			for ( int x = 0; x < todaysActivities.length; x++ ) {
				mts.dsc.activitycontainer.ActivityContainer anActivity = todaysActivities[x];
				anActivity.refresh();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	} // END REFRESH

	//TEST
	public static void main(String[] args) {
		// TRY LOADING CORRESPONDING EMPLOYEE OBJECT
		try {
			mts.dsc.orm.user.User testUser = mts.dsc.orm.user.UserDAO.loadUserByQuery("User='15298'", null);
			mts.dsc.orm.user.User testUser1 = mts.dsc.orm.user.UserDAO.loadUserByQuery("User='15299'", null);
			mts.dsc.orm.user.User testUser2 = mts.dsc.orm.user.UserDAO.loadUserByQuery("User='10101'", null);
			mts.dsc.orm.user.User testUser3 = mts.dsc.orm.user.UserDAO.loadUserByQuery("User='99901'", null);
			
			/*
			// COMMMENT THIS OUT WHEN YOU DONT WANT TO CREATE ANY MORE ACTIVITIES IN THE DATABASE;
			mts.dsc.activitycontainer.ActivityContainer a = new mts.dsc.activitycontainer.ActivityContainer(1); 
			mts.dsc.activitycontainer.ActivityContainer a1 = new mts.dsc.activitycontainer.ActivityContainer(2); 
			mts.dsc.activitycontainer.ActivityContainer a2 = new mts.dsc.activitycontainer.ActivityContainer(2); 
			mts.dsc.activitycontainer.ActivityContainer a3 = new mts.dsc.activitycontainer.ActivityContainer(1); 

			// SOME ACTIVITIES STUFF - THIS IS HANDELED BY THE DROPDOWN MENUS
			// EXPENSE
			mts.dsc.orm.director_code.Director_Code director = mts.dsc.orm.director_code.Director_CodeDAO.loadDirector_CodeByORMID("M000036");
			mts.dsc.orm.director_code.Director_Code director1 = mts.dsc.orm.director_code.Director_CodeDAO.loadDirector_CodeByORMID("M000036");
			mts.dsc.orm.reason_code.Reason_Code reason = mts.dsc.orm.reason_code.Reason_CodeDAO.loadReason_CodeByORMID("OC");
			mts.dsc.orm.reason_code.Reason_Code reason1 = mts.dsc.orm.reason_code.Reason_CodeDAO.loadReason_CodeByORMID("OH");
			mts.dsc.orm.cpc_code.CPC_Code cpc = mts.dsc.orm.cpc_code.CPC_CodeDAO.loadCPC_CodeByORMID("Z005");
			mts.dsc.orm.cpc_code.CPC_Code cpc1 = mts.dsc.orm.cpc_code.CPC_CodeDAO.loadCPC_CodeByORMID("Z011");
			mts.dsc.orm.category.Category cat = mts.dsc.orm.category.CategoryDAO.loadCategoryByORMID(1);
			mts.dsc.orm.category.Category cat1 = mts.dsc.orm.category.CategoryDAO.loadCategoryByORMID(1);
			// PROJECT
			mts.dsc.orm.project.Project p = mts.dsc.orm.project.ProjectDAO.loadProjectByORMID("P99999");
			mts.dsc.orm.project.Project p1 = mts.dsc.orm.project.ProjectDAO.loadProjectByORMID("P03892");
			mts.dsc.orm.network_numbers.Network_Numbers n0 = mts.dsc.orm.network_numbers.Network_NumbersDAO.loadNetwork_NumbersByORMID(9735373);
			mts.dsc.orm.network_numbers.Network_Numbers n1 = mts.dsc.orm.network_numbers.Network_NumbersDAO.loadNetwork_NumbersByORMID(9738693);
			mts.dsc.orm.activity_codes.Activity_Codes ac = mts.dsc.orm.activity_codes.Activity_CodesDAO.loadActivity_CodesByORMID(115);
			mts.dsc.orm.activity_codes.Activity_Codes ac1 = mts.dsc.orm.activity_codes.Activity_CodesDAO.loadActivity_CodesByORMID(150);
			mts.dsc.orm.category.Category cat2 = mts.dsc.orm.category.CategoryDAO.loadCategoryByORMID(11);
			mts.dsc.orm.category.Category cat3 = mts.dsc.orm.category.CategoryDAO.loadCategoryByORMID(11);
			
			// SETUP ACTIVITY CONTAINERS
			a.setUseremp(testUser);
			a.setDescription("DSC DEVELOPMENT");
			a.setActualDuration(450);
			a.setDirector_Code(director);
			a.setReason_Code(reason);
			a.setCPC_Code(cpc);
			a.setCategory(cat);
			
			a1.setUseremp(testUser1);
			a1.setDescription("Migrate server boulder to OSS net");
			a1.setActualDuration(300);
			a1.setProject(p);
			a1.setNetwork_Number(n0);
			a1.setActivity_Code(ac);
			a1.setCategory(cat2);
			
						
			a2.setUseremp(testUser1);
			a2.setDescription("SSH server, routing statment development");
			a2.setActualDuration(300);
			a2.setProject(p1);
			a2.setNetwork_Number(n1);
			a2.setActivity_Code(ac1);
			a2.setCategory(cat3);
			
			a3.setUseremp(testUser3);
			a3.setDescription("Core Router SNMP Vulnerability");
			a3.setActualDuration(400);
			a3.setDirector_Code(director1);
			a3.setReason_Code(reason1);
			a3.setCPC_Code(cpc1);
			a3.setCategory(cat1);
			*/
			
			
			
			try {
				// CREATE AN EMPLOYEE OBJECT, THEN PRINT IT OUT
				EmployeeTest4 anEmployee = new EmployeeTest4(testUser);
				EmployeeTest4 anEmployee1 = new EmployeeTest4(testUser1);
				EmployeeTest4 anEmployee2 = new EmployeeTest4(testUser2);
				EmployeeTest4 anEmployee3 = new EmployeeTest4(testUser3);
				// System.out.println("--> LOADED WITH: "+ anEmployee.getDate().toString());						
			
				// SOME MORE TESTING
				System.out.println("** EMPLOYEE: "+ anEmployee.getFirstName() +" "+ anEmployee.getLastName() +" POSITION: "+ anEmployee.getPositionDesc() +" REQUIRED HOURS: "+ anEmployee.getRequiredHours() +" ROLE: "+ anEmployee.getRole());
				//anEmployee.setActivity(a);
				System.out.println("SOME ACTIVITIES FOR: "+ anEmployee.getFirstName() +" "+ anEmployee.getLastName());
				ActivityContainer[] someActivities;
				someActivities = anEmployee.getTodaysActivities();
				for( int x = 0; x < someActivities.length; x ++) {
					ActivityContainer thisActivity = someActivities[x];
					System.out.println(anEmployee.getFirstName()+"'s ACTIVITY FOR TODAY -> "+ thisActivity.getDescription() +" : "+ thisActivity.getCategory());
				}
				System.out.println("Hours:"+ anEmployee.getCurrentHours()/60 +"\n");
			
				// emp1
				System.out.println("** EMPLOYEE: "+ anEmployee1.getFirstName() +" "+ anEmployee1.getLastName() +" POSITION: "+ anEmployee1.getPositionDesc() +" REQUIRED HOURS: "+ anEmployee1.getRequiredHours() +" ROLE: "+ anEmployee1.getRole());
				//anEmployee1.setActivity(a3);
				System.out.println("SOME ACTIVITIES FOR: "+ anEmployee1.getFirstName() +" "+ anEmployee1.getLastName());
				mts.dsc.activitycontainer.ActivityContainer[] someActivities1;
				someActivities1 = anEmployee1.getTodaysActivities();
				for( int x = 0; x < someActivities1.length; x ++) {
					ActivityContainer thisActivity = someActivities1[x];
					System.out.println(anEmployee1.getFirstName()+"'s ACTIVITY FOR TODAY -> "+ thisActivity.getDescription() +" : "+ thisActivity.getCategory());
				}
				System.out.println("Hours:"+ anEmployee1.getCurrentHours()/60+"\n");
				
				// emp2
				System.out.println("** EMPLOYEE: "+ anEmployee2.getFirstName() +" "+ anEmployee2.getLastName() +" POSITION: "+ anEmployee2.getPositionDesc() +" REQUIRED HOURS: "+ anEmployee2.getRequiredHours() +" ROLE: "+ anEmployee.getRole());
				System.out.println("Hours:"+ anEmployee2.getCurrentHours()/60 +"\n");
								
				// emp3
				System.out.println("** EMPLOYEE: "+ anEmployee3.getFirstName() +" "+ anEmployee3.getLastName() +" POSITION: "+ anEmployee3.getPositionDesc() +" REQUIRED HOURS: "+ anEmployee3.getRequiredHours() +" ROLE: "+ anEmployee.getRole());
				//anEmployee3.setActivity(a1);
				//anEmployee3.setActivity(a2);
				System.out.println("SOME ACTIVITIES FOR: "+ anEmployee3.getFirstName() +" "+ anEmployee3.getLastName());
				mts.dsc.activitycontainer.ActivityContainer[] someActivities3;
				someActivities3 = anEmployee3.getTodaysActivities();
				for( int x = 0; x < someActivities3.length; x ++) {
					ActivityContainer thisActivity = someActivities3[x];
					System.out.println(anEmployee3.getFirstName()+"'s ACTIVITY FOR TODAY -> "+ thisActivity.getDescription() +" : "+ thisActivity.getCategory());
				}
				System.out.println("Hours:"+ anEmployee3.getCurrentHours()/60 +"\n");
			}
			finally {
				mts.dsc.orm.department_user.DSCPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
