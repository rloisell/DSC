/**
 * Licensee: MTS Allstream Inc.
 * License Type: Purchased
 */
package ormsamples;

import org.orm.*;
public class DeleteDSCData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().beginTransaction();
		try {
			mts.dsc.orm.activity.Activity lmtsdscormActivityActivity = mts.dsc.orm.activity.ActivityDAO.loadActivityByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.activity.ActivityDAO.delete(lmtsdscormActivityActivity);
			mts.dsc.orm.category.Category lmtsdscormCategoryCategory = mts.dsc.orm.category.CategoryDAO.loadCategoryByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.category.CategoryDAO.delete(lmtsdscormCategoryCategory);
			mts.dsc.orm.budget.Budget lmtsdscormBudgetBudget = mts.dsc.orm.budget.BudgetDAO.loadBudgetByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.budget.BudgetDAO.delete(lmtsdscormBudgetBudget);
			mts.dsc.orm.user.User lmtsdscormUserUser = mts.dsc.orm.user.UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.user.UserDAO.delete(lmtsdscormUserUser);
			mts.dsc.orm.union.Union lmtsdscormUnionUnion = mts.dsc.orm.union.UnionDAO.loadUnionByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.union.UnionDAO.delete(lmtsdscormUnionUnion);
			mts.dsc.orm.position.Position lmtsdscormPositionPosition = mts.dsc.orm.position.PositionDAO.loadPositionByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.position.PositionDAO.delete(lmtsdscormPositionPosition);
			mts.dsc.orm.calendar.Calendar lmtsdscormCalendarCalendar = mts.dsc.orm.calendar.CalendarDAO.loadCalendarByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.calendar.CalendarDAO.delete(lmtsdscormCalendarCalendar);
			mts.dsc.orm.calendar_category.Calendar_Category lmtsdscormCalendar_categoryCalendar_Category = mts.dsc.orm.calendar_category.Calendar_CategoryDAO.loadCalendar_CategoryByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.calendar_category.Calendar_CategoryDAO.delete(lmtsdscormCalendar_categoryCalendar_Category);
			mts.dsc.orm.user_auth.User_Auth lmtsdscormUser_AuthUser_Auth = mts.dsc.orm.user_auth.User_AuthDAO.loadUser_AuthByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.user_auth.User_AuthDAO.delete(lmtsdscormUser_AuthUser_Auth);
			mts.dsc.orm.expense_activity.Expense_Activity lmtsdscormExpense_ActivityExpense_Activity = mts.dsc.orm.expense_activity.Expense_ActivityDAO.loadExpense_ActivityByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.expense_activity.Expense_ActivityDAO.delete(lmtsdscormExpense_ActivityExpense_Activity);
			mts.dsc.orm.director_code.Director_Code lmtsdscormDirector_CodeDirector_Code = mts.dsc.orm.director_code.Director_CodeDAO.loadDirector_CodeByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.director_code.Director_CodeDAO.delete(lmtsdscormDirector_CodeDirector_Code);
			mts.dsc.orm.reason_code.Reason_Code lmtsdscormReason_CodeReason_Code = mts.dsc.orm.reason_code.Reason_CodeDAO.loadReason_CodeByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.reason_code.Reason_CodeDAO.delete(lmtsdscormReason_CodeReason_Code);
			mts.dsc.orm.network_numbers.Network_Numbers lmtsdscormNetwork_NumbersNetwork_Numbers = mts.dsc.orm.network_numbers.Network_NumbersDAO.loadNetwork_NumbersByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.network_numbers.Network_NumbersDAO.delete(lmtsdscormNetwork_NumbersNetwork_Numbers);
			mts.dsc.orm.project_activity.Project_Activity lmtsdscormProject_ActivityProject_Activity = mts.dsc.orm.project_activity.Project_ActivityDAO.loadProject_ActivityByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.project_activity.Project_ActivityDAO.delete(lmtsdscormProject_ActivityProject_Activity);
			mts.dsc.orm.activity_codes.Activity_Codes lmtsdscormActivity_CodesActivity_Codes = mts.dsc.orm.activity_codes.Activity_CodesDAO.loadActivity_CodesByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.activity_codes.Activity_CodesDAO.delete(lmtsdscormActivity_CodesActivity_Codes);
			mts.dsc.orm.project.Project lmtsdscormProjectProject = mts.dsc.orm.project.ProjectDAO.loadProjectByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.project.ProjectDAO.delete(lmtsdscormProjectProject);
			mts.dsc.orm.department.Department lmtsdscormDepartmentDepartment = mts.dsc.orm.department.DepartmentDAO.loadDepartmentByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.department.DepartmentDAO.delete(lmtsdscormDepartmentDepartment);
			mts.dsc.orm.cpc_code.CPC_Code lmtsdscormCPC_CodeCPC_Code = mts.dsc.orm.cpc_code.CPC_CodeDAO.loadCPC_CodeByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.cpc_code.CPC_CodeDAO.delete(lmtsdscormCPC_CodeCPC_Code);
			mts.dsc.orm.user_position.User_Position lmtsdscormUser_PositionUser_Position = mts.dsc.orm.user_position.User_PositionDAO.loadUser_PositionByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.user_position.User_PositionDAO.delete(lmtsdscormUser_PositionUser_Position);
			mts.dsc.orm.user_user.User_User lmtsdscormUser_UserUser_User = mts.dsc.orm.user_user.User_UserDAO.loadUser_UserByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.user_user.User_UserDAO.delete(lmtsdscormUser_UserUser_User);
			mts.dsc.orm.department_user.Department_User lmtsdscormDepartment_UserDepartment_User = mts.dsc.orm.department_user.Department_UserDAO.loadDepartment_UserByQuery(null, null);
			// Delete the persistent object
			mts.dsc.orm.department_user.Department_UserDAO.delete(lmtsdscormDepartment_UserDepartment_User);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteDSCData deleteDSCData = new DeleteDSCData();
			try {
				deleteDSCData.deleteTestData();
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
