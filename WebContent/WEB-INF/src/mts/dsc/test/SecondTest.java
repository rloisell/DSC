/**
 * 
 */
package mts.dsc.test;

import java.util.Date;	
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import ormsamples.CreateDSCData;
import org.orm.*;

/**
 * @author loiselle
 * 
 *
 */

public class SecondTest {
	private static final int ROW_COUNT = 100;
	
	public void manipulateTestData() throws PersistentException {
		PersistentTransaction t = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().beginTransaction();
		try {
			mts.dsc.orm.user.User testUser1 = mts.dsc.orm.user.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : User_User1, User_User, User_Position, Department_User, User_Auth, Activity, Department, roleID, ncsDate, email, lastName, firstName, empId
			testUser1.setEmpId(15299);
			testUser1.setFirstName("Keith");
			testUser1.setLastName("Duma");
			testUser1.setEmail("snipe_187@hotmail.com");
			Date date1 = new Date(109,1,15);
			Date ncs1 = date1;
			testUser1.setNcsDate(ncs1);
			testUser1.setRoleID(1);
			System.out.println("\n--> ADDING USER \n\n"+ testUser1.toString());
			mts.dsc.orm.user.UserDAO.save(testUser1);
			
			mts.dsc.orm.user.User testUser2 = mts.dsc.orm.user.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : User_User1, User_User, User_Position, Department_User, User_Auth, Activity, Department, roleID, ncsDate, email, lastName, firstName, empId
			testUser2.setEmpId(99901);
			testUser2.setFirstName("Matthew");
			testUser2.setLastName("Ammeter");
			testUser2.setEmail("acs-39093-and-mts-project-2009@googlegroups.com");
			Date date2 = new Date(109,1,15);
			Date ncs2 = date2;
			testUser2.setNcsDate(ncs2);
			testUser2.setRoleID(1);
			System.out.println("\n--> ADDING USER \n\n"+ testUser2.toString());
			mts.dsc.orm.user.UserDAO.save(testUser2);

			mts.dsc.orm.user_auth.User_Auth xUser_Auth = mts.dsc.orm.user_auth.User_AuthDAO.createUser_Auth();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : password, userName, Useremp
			xUser_Auth.setUseremp(testUser1);
			xUser_Auth.setUserName("kduma");
			xUser_Auth.setPassword("REDACTED_TEST_PASSWORD");
			System.out.println("\n===> SETTING USER AUTH \n\n"+ xUser_Auth.toString());
			mts.dsc.orm.user_auth.User_AuthDAO.save(xUser_Auth);

			// NOW THAT USER AUTH HAS BEEN CREATED, ASSOCIATE THE USER TO THE USER_AUTH OBJECT
			testUser1.setUser_Auth(xUser_Auth);
			mts.dsc.orm.user.UserDAO.save(testUser1);
			
			mts.dsc.orm.user_auth.User_Auth aUser_Auth = mts.dsc.orm.user_auth.User_AuthDAO.createUser_Auth();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : password, userName, Useremp
			aUser_Auth.setUseremp(testUser2);
			aUser_Auth.setUserName("mammeter");
			aUser_Auth.setPassword("REDACTED_TEST_PASSWORD");
			System.out.println("\n===> SETTING USER AUTH \n\n"+ aUser_Auth.toString());
			mts.dsc.orm.user_auth.User_AuthDAO.save(aUser_Auth);
			
			// NOW THAT USER AUTH HAS BEEN CREATED, ASSOCIATE THE USER TO THE USER_AUTH OBJECT
			testUser2.setUser_Auth(aUser_Auth);
			mts.dsc.orm.user.UserDAO.save(testUser2);
			
			// LOAD USER_AUTH BY QUERY OF USERNAME, UPDATE PASSWORD AND SAVE
			mts.dsc.orm.user_auth.User_Auth aUser_Auth2 = mts.dsc.orm.user_auth.User_AuthDAO.loadUser_AuthByQuery("User_Auth.userName='rloisel1'", null);
			// Update the properties of the persistent object
			System.out.println("+++> CHANGING USER AUTH - ORIGINAL\n\n"+ aUser_Auth2.toString());
			aUser_Auth2.setPassword("s0l0cr00");
			System.out.println("===> CHANGING USER AUTH - UPDATED\n\n"+ aUser_Auth2.toString());			
			mts.dsc.orm.user_auth.User_AuthDAO.save(aUser_Auth2);
			
			System.out.println("\n\nListing User_Auth...");
			mts.dsc.orm.user_auth.User_Auth[] xUser_Auths = mts.dsc.orm.user_auth.User_AuthDAO.listUser_AuthByQuery(null, null);
			int length = Math.min(xUser_Auths.length, ROW_COUNT);
			for (int i = 0; i < length; i++) {
				System.out.println(xUser_Auths[i]);
			}
			System.out.println(length + " record(s) retrieved.");
			
			System.out.println("\n\nListing User...");
			mts.dsc.orm.user.User[] testUser1s = mts.dsc.orm.user.UserDAO.listUserByQuery(null, null);
			length = Math.min(testUser1s.length, ROW_COUNT);
			for (int i = 0; i < length; i++) {
				System.out.println(testUser1s[i]);
			}
			System.out.println(length + " record(s) retrieved.");
			
			
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
		
	public static void main(String[] args) {
		try {
			SecondTest createDSCTestData = new SecondTest();
			try {
				createDSCTestData.manipulateTestData();
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
