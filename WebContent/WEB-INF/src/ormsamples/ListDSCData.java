/**
 * Licensee: MTS Allstream Inc.
 * License Type: Purchased
 */
package ormsamples;

import mts.dsc.orm.calendar.Calendar;

import org.orm.*;
public class ListDSCData {
	private static final int ROW_COUNT = 400;
	
public void listTestData() throws PersistentException {
		System.out.println("\nListing Activity...");
		mts.dsc.orm.activity.Activity[] mtsdscormActivityActivitys = mts.dsc.orm.activity.ActivityDAO.listActivityByQuery(null, null);
		int length = Math.min(mtsdscormActivityActivitys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormActivityActivitys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Category...");
		mts.dsc.orm.category.Category[] mtsdscormCategoryCategorys = mts.dsc.orm.category.CategoryDAO.listCategoryByQuery(null, null);
		length = Math.min(mtsdscormCategoryCategorys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormCategoryCategorys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Budget...");
		mts.dsc.orm.budget.Budget[] mtsdscormBudgetBudgets = mts.dsc.orm.budget.BudgetDAO.listBudgetByQuery(null, null);
		length = Math.min(mtsdscormBudgetBudgets.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormBudgetBudgets[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing User...");
		mts.dsc.orm.user.User[] mtsdscormUserUsers = mts.dsc.orm.user.UserDAO.listUserByQuery(null, null);
		length = Math.min(mtsdscormUserUsers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormUserUsers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Union...");
		mts.dsc.orm.union.Union[] mtsdscormUnionUnions = mts.dsc.orm.union.UnionDAO.listUnionByQuery(null, null);
		length = Math.min(mtsdscormUnionUnions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormUnionUnions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Position...");
		mts.dsc.orm.position.Position[] mtsdscormPositionPositions = mts.dsc.orm.position.PositionDAO.listPositionByQuery(null, null);
		length = Math.min(mtsdscormPositionPositions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormPositionPositions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Calendar...");
		mts.dsc.orm.calendar.Calendar[] mtsdscormCalendarCalendars = mts.dsc.orm.calendar.CalendarDAO.listCalendarByQuery(null, "Calendar.date");
		length = Math.min(mtsdscormCalendarCalendars.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormCalendarCalendars[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Calendar_Category...");
		mts.dsc.orm.calendar_category.Calendar_Category[] mtsdscormCalendar_categoryCalendar_Categorys = mts.dsc.orm.calendar_category.Calendar_CategoryDAO.listCalendar_CategoryByQuery(null, null);
		length = Math.min(mtsdscormCalendar_categoryCalendar_Categorys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormCalendar_categoryCalendar_Categorys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing User_Auth...");
		mts.dsc.orm.user_auth.User_Auth[] mtsdscormUser_AuthUser_Auths = mts.dsc.orm.user_auth.User_AuthDAO.listUser_AuthByQuery(null, null);
		length = Math.min(mtsdscormUser_AuthUser_Auths.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormUser_AuthUser_Auths[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Expense_Activity...");
		mts.dsc.orm.expense_activity.Expense_Activity[] mtsdscormExpense_ActivityExpense_Activitys = mts.dsc.orm.expense_activity.Expense_ActivityDAO.listExpense_ActivityByQuery(null, null);
		length = Math.min(mtsdscormExpense_ActivityExpense_Activitys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormExpense_ActivityExpense_Activitys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Director_Code...");
		mts.dsc.orm.director_code.Director_Code[] mtsdscormDirector_CodeDirector_Codes = mts.dsc.orm.director_code.Director_CodeDAO.listDirector_CodeByQuery(null, null);
		length = Math.min(mtsdscormDirector_CodeDirector_Codes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormDirector_CodeDirector_Codes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Reason_Code...");
		mts.dsc.orm.reason_code.Reason_Code[] mtsdscormReason_CodeReason_Codes = mts.dsc.orm.reason_code.Reason_CodeDAO.listReason_CodeByQuery(null, null);
		length = Math.min(mtsdscormReason_CodeReason_Codes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormReason_CodeReason_Codes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Network_Numbers...");
		mts.dsc.orm.network_numbers.Network_Numbers[] mtsdscormNetwork_NumbersNetwork_Numberses = mts.dsc.orm.network_numbers.Network_NumbersDAO.listNetwork_NumbersByQuery(null, null);
		length = Math.min(mtsdscormNetwork_NumbersNetwork_Numberses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormNetwork_NumbersNetwork_Numberses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Project_Activity...");
		mts.dsc.orm.project_activity.Project_Activity[] mtsdscormProject_ActivityProject_Activitys = mts.dsc.orm.project_activity.Project_ActivityDAO.listProject_ActivityByQuery(null, null);
		length = Math.min(mtsdscormProject_ActivityProject_Activitys.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormProject_ActivityProject_Activitys[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Activity_Codes...");
		mts.dsc.orm.activity_codes.Activity_Codes[] mtsdscormActivity_CodesActivity_Codeses = mts.dsc.orm.activity_codes.Activity_CodesDAO.listActivity_CodesByQuery(null, null);
		length = Math.min(mtsdscormActivity_CodesActivity_Codeses.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormActivity_CodesActivity_Codeses[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Project...");
		mts.dsc.orm.project.Project[] mtsdscormProjectProjects = mts.dsc.orm.project.ProjectDAO.listProjectByQuery(null, null);
		length = Math.min(mtsdscormProjectProjects.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormProjectProjects[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Department...");
		mts.dsc.orm.department.Department[] mtsdscormDepartmentDepartments = mts.dsc.orm.department.DepartmentDAO.listDepartmentByQuery(null, null);
		length = Math.min(mtsdscormDepartmentDepartments.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormDepartmentDepartments[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing CPC_Code...");
		mts.dsc.orm.cpc_code.CPC_Code[] mtsdscormCPC_CodeCPC_Codes = mts.dsc.orm.cpc_code.CPC_CodeDAO.listCPC_CodeByQuery(null, null);
		length = Math.min(mtsdscormCPC_CodeCPC_Codes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormCPC_CodeCPC_Codes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing User_Position...");
		mts.dsc.orm.user_position.User_Position[] mtsdscormUser_PositionUser_Positions = mts.dsc.orm.user_position.User_PositionDAO.listUser_PositionByQuery(null, null);
		length = Math.min(mtsdscormUser_PositionUser_Positions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormUser_PositionUser_Positions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing User_User...");
		mts.dsc.orm.user_user.User_User[] mtsdscormUser_UserUser_Users = mts.dsc.orm.user_user.User_UserDAO.listUser_UserByQuery(null, null);
		length = Math.min(mtsdscormUser_UserUser_Users.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormUser_UserUser_Users[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("\nListing Department_User...");
		mts.dsc.orm.department_user.Department_User[] mtsdscormDepartment_UserDepartment_Users = mts.dsc.orm.department_user.Department_UserDAO.listDepartment_UserByQuery(null, null);
		length = Math.min(mtsdscormDepartment_UserDepartment_Users.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(mtsdscormDepartment_UserDepartment_Users[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public static void main(String[] args) {
		try {
			ListDSCData listDSCData = new ListDSCData();
			try {
				listDSCData.listTestData();
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
