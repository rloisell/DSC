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

public class FirstTest {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().beginTransaction();
		try {
			mts.dsc.orm.user.User mTSDSCORMUserUser = mts.dsc.orm.user.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : User_User1, User_User, User_Position, Department_User, User_Auth, Activity, Department, roleID, ncsDate, email, lastName, firstName, empId
			mTSDSCORMUserUser.setEmpId(15298);
			mTSDSCORMUserUser.setFirstName("Ryan");
			mTSDSCORMUserUser.setLastName("Loiselle");
			mTSDSCORMUserUser.setEmail("ryan.loiselle@azonicnet.com");
			Date date1 = new Date(1990,12,12);
			Date ncs1 = date1;
			mTSDSCORMUserUser.setNcsDate(ncs1);
			mTSDSCORMUserUser.setRoleID(-1);
			mts.dsc.orm.user.UserDAO.save(mTSDSCORMUserUser);
			
			mts.dsc.orm.user.User testUser2 = mts.dsc.orm.user.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : User_User1, User_User, User_Position, Department_User, User_Auth, Activity, Department, roleID, ncsDate, email, lastName, firstName, empId
			testUser2.setEmpId(10101);
			testUser2.setFirstName("Duncan");
			testUser2.setLastName("McGregor");
			testUser2.setEmail("duncan.mcgregor@mtsallstream.com");
			Date date2 = new Date(1990,12,12);
			Date ncs2 = date2;
			testUser2.setNcsDate(ncs2);
			testUser2.setRoleID(2);
			mts.dsc.orm.user.UserDAO.save(testUser2);

			mts.dsc.orm.user_auth.User_Auth mTSDSCORMUser_AuthUser_Auth = mts.dsc.orm.user_auth.User_AuthDAO.createUser_Auth();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : password, userName, Useremp
			mTSDSCORMUser_AuthUser_Auth.setUseremp(mTSDSCORMUserUser);
			mTSDSCORMUser_AuthUser_Auth.setUserName("rloisel1");
			mTSDSCORMUser_AuthUser_Auth.setPassword("a11ezpr&");
			mts.dsc.orm.user_auth.User_AuthDAO.save(mTSDSCORMUser_AuthUser_Auth);

			mts.dsc.orm.project.Project mTSDSCORMProjectProject = mts.dsc.orm.project.ProjectDAO.createProject();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Project_Activity, projectNo
			mTSDSCORMProjectProject.setProjectNo("P99999");
			mTSDSCORMProjectProject.setDescription("ANOTHER TEST PROJECT");
			mts.dsc.orm.project.ProjectDAO.save(mTSDSCORMProjectProject);
			
			mts.dsc.orm.department.Department mTSDSCORMDepartmentDepartment = mts.dsc.orm.department.DepartmentDAO.createDepartment();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Department_User, HasDC, UsedBy, deptName, deptID, Useremp
			mTSDSCORMDepartmentDepartment.setDeptID(0);
			mTSDSCORMDepartmentDepartment.setDeptName("OSS Operations");
			mTSDSCORMDepartmentDepartment.setUseremp(testUser2);
			mts.dsc.orm.department.DepartmentDAO.save(mTSDSCORMDepartmentDepartment);
			
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
		
	public static void main(String[] args) {
		try {
			FirstTest createDSCTestData = new FirstTest();
			try {
				createDSCTestData.createTestData();
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
