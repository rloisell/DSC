/**
 * Licensee: MTS Allstream Inc.
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class CreateDSCData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().beginTransaction();
		try {
			mts.dsc.orm.activity.Activity lmtsdscormActivityActivity = mts.dsc.orm.activity.ActivityDAO.createActivity();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Expense_Activity, Project_Activity, Categorycategory, Budgetbudget, Useremp, actualDuration, Calandardate
			mts.dsc.orm.activity.ActivityDAO.save(lmtsdscormActivityActivity);
			mts.dsc.orm.category.Category lmtsdscormCategoryCategory = mts.dsc.orm.category.CategoryDAO.createCategory();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Activity, categoryName
			mts.dsc.orm.category.CategoryDAO.save(lmtsdscormCategoryCategory);
			mts.dsc.orm.budget.Budget lmtsdscormBudgetBudget = mts.dsc.orm.budget.BudgetDAO.createBudget();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Activity, budgetDescription
			mts.dsc.orm.budget.BudgetDAO.save(lmtsdscormBudgetBudget);
			mts.dsc.orm.user.User lmtsdscormUserUser = mts.dsc.orm.user.UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : User_User1, User_User, User_Position, Department_User, User_Auth, Activity, Department, roleID, ncsDate, email, lastName, firstName, empId
			mts.dsc.orm.user.UserDAO.save(lmtsdscormUserUser);
			mts.dsc.orm.union.Union lmtsdscormUnionUnion = mts.dsc.orm.union.UnionDAO.createUnion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Position, unionId
			mts.dsc.orm.union.UnionDAO.save(lmtsdscormUnionUnion);
			mts.dsc.orm.position.Position lmtsdscormPositionPosition = mts.dsc.orm.position.PositionDAO.createPosition();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : User_Position, Unionunion, status, latCode, positionID
			mts.dsc.orm.position.PositionDAO.save(lmtsdscormPositionPosition);
			mts.dsc.orm.calendar.Calendar lmtsdscormCalendarCalendar = mts.dsc.orm.calendar.CalendarDAO.createCalendar();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Activity, date, Calendar_CategorycalendarCategory
			mts.dsc.orm.calendar.CalendarDAO.save(lmtsdscormCalendarCalendar);
			mts.dsc.orm.calendar_category.Calendar_Category lmtsdscormCalendar_categoryCalendar_Category = mts.dsc.orm.calendar_category.Calendar_CategoryDAO.createCalendar_Category();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Calandar, calendarCatName
			mts.dsc.orm.calendar_category.Calendar_CategoryDAO.save(lmtsdscormCalendar_categoryCalendar_Category);
			mts.dsc.orm.user_auth.User_Auth lmtsdscormUser_AuthUser_Auth = mts.dsc.orm.user_auth.User_AuthDAO.createUser_Auth();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : password, userName, Useremp
			mts.dsc.orm.user_auth.User_AuthDAO.save(lmtsdscormUser_AuthUser_Auth);
			mts.dsc.orm.expense_activity.Expense_Activity lmtsdscormExpense_ActivityExpense_Activity = mts.dsc.orm.expense_activity.Expense_ActivityDAO.createExpense_Activity();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : CPC_CodecpcCode, Reason_CodereasonCode, Director_CodedirectorCode
			mts.dsc.orm.expense_activity.Expense_ActivityDAO.save(lmtsdscormExpense_ActivityExpense_Activity);
			mts.dsc.orm.director_code.Director_Code lmtsdscormDirector_CodeDirector_Code = mts.dsc.orm.director_code.Director_CodeDAO.createDirector_Code();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Expense_Activity, directorCode
			mts.dsc.orm.director_code.Director_CodeDAO.save(lmtsdscormDirector_CodeDirector_Code);
			mts.dsc.orm.reason_code.Reason_Code lmtsdscormReason_CodeReason_Code = mts.dsc.orm.reason_code.Reason_CodeDAO.createReason_Code();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Expense_Activity, reasonCode
			mts.dsc.orm.reason_code.Reason_CodeDAO.save(lmtsdscormReason_CodeReason_Code);
			mts.dsc.orm.network_numbers.Network_Numbers lmtsdscormNetwork_NumbersNetwork_Numbers = mts.dsc.orm.network_numbers.Network_NumbersDAO.createNetwork_Numbers();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Project_Activity, networkNumber
			mts.dsc.orm.network_numbers.Network_NumbersDAO.save(lmtsdscormNetwork_NumbersNetwork_Numbers);
			mts.dsc.orm.project_activity.Project_Activity lmtsdscormProject_ActivityProject_Activity = mts.dsc.orm.project_activity.Project_ActivityDAO.createProject_Activity();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Activity_CodesactivityCode, Network_NumbersnetworkNumber, ProjectprojectNo
			mts.dsc.orm.project_activity.Project_ActivityDAO.save(lmtsdscormProject_ActivityProject_Activity);
			mts.dsc.orm.activity_codes.Activity_Codes lmtsdscormActivity_CodesActivity_Codes = mts.dsc.orm.activity_codes.Activity_CodesDAO.createActivity_Codes();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Project_Activity, activityCode
			mts.dsc.orm.activity_codes.Activity_CodesDAO.save(lmtsdscormActivity_CodesActivity_Codes);
			mts.dsc.orm.project.Project lmtsdscormProjectProject = mts.dsc.orm.project.ProjectDAO.createProject();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Project_Activity, projectNo
			mts.dsc.orm.project.ProjectDAO.save(lmtsdscormProjectProject);
			mts.dsc.orm.department.Department lmtsdscormDepartmentDepartment = mts.dsc.orm.department.DepartmentDAO.createDepartment();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Department_User, HasDC, UsedBy, deptName, deptID, Useremp
			mts.dsc.orm.department.DepartmentDAO.save(lmtsdscormDepartmentDepartment);
			mts.dsc.orm.cpc_code.CPC_Code lmtsdscormCPC_CodeCPC_Code = mts.dsc.orm.cpc_code.CPC_CodeDAO.createCPC_Code();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : Expense_Activity, cpcCode
			mts.dsc.orm.cpc_code.CPC_CodeDAO.save(lmtsdscormCPC_CodeCPC_Code);
			mts.dsc.orm.user_position.User_Position lmtsdscormUser_PositionUser_Position = mts.dsc.orm.user_position.User_PositionDAO.createUser_Position();
			// Initialize the properties of the persistent object here
			mts.dsc.orm.user_position.User_PositionDAO.save(lmtsdscormUser_PositionUser_Position);
			mts.dsc.orm.user_user.User_User lmtsdscormUser_UserUser_User = mts.dsc.orm.user_user.User_UserDAO.createUser_User();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : startDate
			mts.dsc.orm.user_user.User_UserDAO.save(lmtsdscormUser_UserUser_User);
			mts.dsc.orm.department_user.Department_User lmtsdscormDepartment_UserDepartment_User = mts.dsc.orm.department_user.Department_UserDAO.createDepartment_User();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : startDate
			mts.dsc.orm.department_user.Department_UserDAO.save(lmtsdscormDepartment_UserDepartment_User);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateDSCData createDSCData = new CreateDSCData();
			try {
				createDSCData.createTestData();
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
