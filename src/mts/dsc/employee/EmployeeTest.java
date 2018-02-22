/**
 * THIS IS THE EMPLOYEE CLASS:
 * THE EMPLOYEE CLASS HANDLES ALL THE BUSINESS LOGIC OF ADDING THE ACTIVITIES TO THE DATABASE
 * AND THEN ADDING THEM TO THE EMPLOYEE OBJECT ASSOCIATED WITH THE SESSION.
 */
package mts.dsc.employee;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.orm.*;

import mts.dsc.activitycontainer.*;
import mts.dsc.orm.*;
import mts.dsc.orm.position.Position;
import mts.dsc.orm.user_position.User_Position;


/**
 * @author loiselle
 *
 */
public class EmployeeTest {
	// LOCAL REFERENCE TO USER
	private mts.dsc.orm.user.User aUser;
	
	// LOCAL REFERENCE TO POSITIONS
	private Set myPositions;
	private Object positionsArray[];
	private mts.dsc.orm.position.Position aPosition;
	
	// CURRENT HOURS AND REQUIRED HOURS
	private double requiredHours = 0;
	private double hours = 0;
	
	// ACTIVITIES COLLECTION
	private Collection<ActivityContainer> todaysActivities = new HashSet<ActivityContainer>();
	
	// DEFAULT CONSTRUCTOR
	public EmployeeTest() {
	}
	
	// CONSTRUCTOR TO POPULATE EMPLOYEE WITH USER, POSITION, ETC
	public EmployeeTest( mts.dsc.orm.user.User aUser ) {
		// POPULATE EMPLOYEE WITH CURRENT USER
		this.aUser = aUser;
		
		// POPULATE EMPLOYEE WITH USERS CURRENT POSITION
		this.myPositions = aUser.getUser_Position();
		this.positionsArray = myPositions.toArray();
		this.aPosition = ((User_Position)positionsArray[myPositions.size() - 1]).getPositionposition();
		
		// POPULATE EMPLOYEE WITH REQUIRED HOURS IF NOT A MANAGER
		if ( aPosition.getPositionID() != 4) {
			requiredHours = setRequiredHours( aPosition );
		}
		
	} // END CONSTRUCTOR
	
	// METHODS

	// GET EMPLOYEE INFO - FOR TESTING
	public void getEmpInfo() {
		System.out.println("-- MAIN --\n -> USER INFO --> "+ aUser.toString());
		System.out.println(" -> POSITION INFO --> "+ aPosition.toString());
	} // END GET EMPLOYEE INFO
	
	// SET REQUIRED HOURS
	// FUTURE: ADD ADDITIONAL TO DEAL WITH NON FULL TIME EMPLOYEES
	public double setRequiredHours( mts.dsc.orm.position.Position curPosition ) {
		double reqHrs = 0;
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
		return -1;
	} // END SET REQUIRED HOURS
	
	// GET REGUIRED HOURS
	public double getRequiredHours() {
		return this.requiredHours;
	} // END GET REQUIRED HOURS
	
	// GET CURRENT HOURS
	public double getCurrentHours() {
		return this.hours;
	} // END CURRENT HOURS
	
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
	}
	
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
	
	// ADD ACTIVITY
	public void setActivity( ) {
		// TODO
		
	}
	
	public Collection<ActivityContainer> getActivities() {
		return todaysActivities;
	}
	
	//
	// INTERNAL DRIVE TO TEST EMPLOYEE CLASS, COMMENT OUT FOR DEPLOYEMENT
	//
	public static void main( String [] args ) {
		// TRY LOADING CORRESPONDING EMPLOYEE OBJECT
		try {
			mts.dsc.orm.user.User testUser = mts.dsc.orm.user.UserDAO.loadUserByQuery("User='15298'", null);
			
			try {
			// CREATE AN EMPLOYEE OBJECT, THEN PRINT IT OUT
			EmployeeTest anEmployee = new EmployeeTest(testUser);
			anEmployee.getEmpInfo();
						
			// SOME MORE TESTING
			System.out.println("\n\n ** MORE ** \n\n EMPLOYEE: "+ anEmployee.getFirstName() +" "+ anEmployee.getLastName() +" POSITION: "+ 
					anEmployee.aPosition.getDescription() +" REQUIRED HOURS: "+ anEmployee.requiredHours +" ROLE: "+ anEmployee.getRole());
		
			}
			finally {
				mts.dsc.orm.department_user.DSCPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END MAIN
	
} // END EMPLOYEE
