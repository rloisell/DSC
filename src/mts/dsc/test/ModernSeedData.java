/*
 * ModernSeedData.java
 * Ryan Loiselle — Developer / Architect
 * GitHub Copilot — AI pair programmer / code generation
 * February 2026
 *
 * AI-assisted: seeded legacy ORM data from modernization values in GUI-safe order;
 * reviewed and directed by Ryan Loiselle.
 */
package mts.dsc.test;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import org.orm.ORMDatabaseInitiator;
import org.orm.PersistentSession;

import mts.dsc.activitycontainer.ActivityContainer;
import mts.dsc.orm.activity.Activity;
import mts.dsc.orm.activity.ActivityDAO;
import mts.dsc.orm.activity_codes.Activity_Codes;
import mts.dsc.orm.activity_codes.Activity_CodesDAO;
import mts.dsc.orm.budget.Budget;
import mts.dsc.orm.budget.BudgetDAO;
import mts.dsc.orm.calendar.CalendarDAO;
import mts.dsc.orm.calendar_category.Calendar_Category;
import mts.dsc.orm.calendar_category.Calendar_CategoryDAO;
import mts.dsc.orm.category.Category;
import mts.dsc.orm.category.CategoryDAO;
import mts.dsc.orm.cpc_code.CPC_Code;
import mts.dsc.orm.cpc_code.CPC_CodeDAO;
import mts.dsc.orm.department.Department;
import mts.dsc.orm.department.DepartmentDAO;
import mts.dsc.orm.department_user.Department_User;
import mts.dsc.orm.department_user.Department_UserDAO;
import mts.dsc.orm.director_code.Director_Code;
import mts.dsc.orm.director_code.Director_CodeDAO;
import mts.dsc.orm.network_numbers.Network_Numbers;
import mts.dsc.orm.network_numbers.Network_NumbersDAO;
import mts.dsc.orm.position.Position;
import mts.dsc.orm.position.PositionDAO;
import mts.dsc.orm.project.Project;
import mts.dsc.orm.project.ProjectDAO;
import mts.dsc.orm.reason_code.Reason_Code;
import mts.dsc.orm.reason_code.Reason_CodeDAO;
import mts.dsc.orm.union.Union;
import mts.dsc.orm.union.UnionDAO;
import mts.dsc.orm.user.User;
import mts.dsc.orm.user.UserDAO;
import mts.dsc.orm.user_auth.User_Auth;
import mts.dsc.orm.user_auth.User_AuthDAO;
import mts.dsc.orm.user_position.User_Position;
import mts.dsc.orm.user_position.User_PositionDAO;

public class ModernSeedData {
	// ── ENTRY ─────────────────────────────────────────────────────────────────
	// seeds data in a GUI-safe sequence using ORM objects
	public static void main(String[] args) {
		try {
			ModernSeedData seeder = new ModernSeedData();
			try {
				seeder.seedAll();
			} finally {
				mts.dsc.orm.department_user.DSCPersistentManager.instance().disposePersistentManager();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end main

	// ── SEEDING ───────────────────────────────────────────────────────────────
	// seeds all required lookup and activity data for the legacy UI
	public void seedAll() throws PersistentException {
		applyDbOverrides();
		// Schema already created via scripts/DSC_mysql8.ddl
		// ensureSchema();
		
		// Disable FK checks to simplify circular User/Department seeding
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			session.connection().createStatement().execute("SET FOREIGN_KEY_CHECKS=0");
		} catch (Exception e) {
			throw new PersistentException("Failed to disable FK checks", e);
		}
		
		PersistentTransaction t = mts.dsc.orm.department_user.DSCPersistentManager.instance()
				.getSession()
				.beginTransaction();
		try {
			Date today = truncateDate(new Date());

			Budget expenseBudget = ensureBudget("Expense");
			Budget capitalBudget = ensureBudget("Capital");
			validateBudgetIds(expenseBudget, capitalBudget);

			Union union0 = ensureUnion(0, "IBEW Local 2085");
			Union union1 = ensureUnion(1, "CUPE Local 500");
			Union union2 = ensureUnion(2, "Non-Union");

			Position posDev = ensurePosition(1, 1001, "Software Developer", "FT", union0);
			Position posSenior = ensurePosition(2, 1002, "Senior Developer", "FT", union0);
			Position posLead = ensurePosition(3, 1003, "Team Lead", "FT", union1);
			Position posManager = ensurePosition(4, 1004, "Project Manager", "FT", union2);
			Position posQa = ensurePosition(5, 1005, "QA Analyst", "FT", union1);
			Position posDba = ensurePosition(6, 1006, "Database Administrator", "FT", union2);

			User userRyan = ensureUser(15298, "Ryan", "Loiselle", "ryan@example.com", date(2020, 1, 2), -1);
			User userDuncan = ensureUser(10101, "Duncan", "McGregor", "duncan@example.com", date(2018, 6, 12), 2);
			User userKeith = ensureUser(15299, "Keith", "Duma", "keith@example.com", date(2021, 3, 15), 1);
			User userMatthew = ensureUser(99901, "Matthew", "Ammeter", "matthew@example.com", date(2019, 9, 30), 1);

			ensureUserAuth(userRyan, "rloisel1", "test-password");
			ensureUserAuth(userDuncan, "dmcgregor", "test-password");
			ensureUserAuth(userKeith, "kduma", "test-password");
			ensureUserAuth(userMatthew, "mammeter", "test-password");

			Department deptEng = ensureDepartment(1, "Engineering", userRyan);
			Department deptOps = ensureDepartment(2, "OSS Operations", userDuncan);
			Department deptQa = ensureDepartment(3, "Quality Assurance", userMatthew);
			Department deptProd = ensureDepartment(4, "Product Management", userKeith);

			ensureUserPosition(userRyan, posLead, today);
			ensureUserPosition(userDuncan, posManager, today);
			ensureUserPosition(userKeith, posDev, today);
			ensureUserPosition(userMatthew, posQa, today);

			ensureDepartmentUser(userRyan, deptEng, today);
			ensureDepartmentUser(userDuncan, deptOps, today);
			ensureDepartmentUser(userKeith, deptEng, today);
			ensureDepartmentUser(userMatthew, deptQa, today);

			ensureCategory("Development");
			ensureCategory("Testing");
			ensureCategory("Documentation");
			ensureCategory("Planning");
			ensureCategory("Support");

			// AI-assisted: map modernization activity codes to legacy numeric IDs.
			ensureActivityCode(10, "DEV - Development work");
			ensureActivityCode(11, "TEST - Testing and QA");
			ensureActivityCode(12, "MEET - Meetings and planning");
			ensureActivityCode(13, "DOC - Documentation");
			ensureActivityCode(14, "TRAIN - Training activities");
			ensureActivityCode(15, "PLAN - Project planning");
			ensureActivityCode(16, "DEPLOY - Deployment and release");
			ensureActivityCode(17, "REVIEW - Code review");
			ensureActivityCode(18, "RESEARCH - Research and discovery");
			ensureActivityCode(19, "BUG - Bug fixing");
			ensureActivityCode(20, "SUPPORT - User support");
			ensureActivityCode(21, "ADMIN - Administrative work");

			ensureNetworkNumber(1000, "Network 1000");
			ensureNetworkNumber(1001, "Network 1001");
			ensureNetworkNumber(1002, "Network 1002");
			ensureNetworkNumber(1003, "Network 1003");
			ensureNetworkNumber(1004, "Network 1004");
			ensureNetworkNumber(1005, "Network 1005");
			ensureNetworkNumber(1006, "Network 1006");
			ensureNetworkNumber(1007, "Network 1007");
			ensureNetworkNumber(1008, "Network 1008");
			ensureNetworkNumber(1009, "Network 1009");
			ensureNetworkNumber(1010, "Network 1010");
			ensureNetworkNumber(1011, "Network 1011");

			ensureProject("P00001", "Website Redesign");
			ensureProject("P00002", "Security Hardening");
			ensureProject("P00003", "Database Migration");
			ensureProject("P00004", "Mobile App Development");
			ensureProject("P00005", "Legacy System Integration");
			ensureProject("P00006", "API Modernization");
			ensureProject("P00007", "Performance Optimization");
			ensureProject("P00008", "Documentation Update");

			ensureDirectorCode("DIR001", "Engineering Director Approval");
			ensureDirectorCode("DIR002", "Operations Director Approval");
			ensureDirectorCode("DIR003", "Finance Director Approval");
			ensureDirectorCode("DIR004", "Executive Director Approval");

			ensureReasonCode("M1", "Equipment Maintenance");
			ensureReasonCode("U1", "System Upgrade");
			ensureReasonCode("S1", "Technical Support");
			ensureReasonCode("T1", "Staff Training");
			ensureReasonCode("B1", "Business Meeting");

			ensureCpcCode("C100", "General Operations");
			ensureCpcCode("C200", "Infrastructure");
			ensureCpcCode("C300", "Development");
			ensureCpcCode("C400", "Support");
			ensureCpcCode("C500", "Admin");

			Calendar_Category workday = ensureCalendarCategory("Workday", "Standard work day");
			Calendar_Category holiday = ensureCalendarCategory("Holiday", "Statutory holiday");
			Calendar_Category eventCat = ensureCalendarCategory("Company Event", "Company event");
			Calendar_Category training = ensureCalendarCategory("Training Day", "Training events");

			ensureCalendar(date(2026, 1, 1), holiday);
			ensureCalendar(date(2026, 3, 15), eventCat);
			ensureCalendar(date(2026, 7, 1), holiday);
			ensureCalendar(date(2026, 12, 25), holiday);
			ensureCalendar(date(2026, 12, 26), holiday);
			ensureCalendar(today, workday);

			Category devCategory = loadCategoryByName("Development");
			Category supportCategory = loadCategoryByName("Support");
			Project projSecurity = loadProjectByNo("P00002");
			Network_Numbers net1000 = loadNetworkNumber(1000);
			Activity_Codes actDev = loadActivityCode(10);
			Director_Code dirCode = loadDirectorCode("DIR001");
			Reason_Code reasonCode = loadReasonCode("S1");
			CPC_Code cpcCode = loadCpcCode("C300");

			seedProjectActivityIfMissing(userRyan, today, devCategory, capitalBudget.getBudgetId(),
					"Development Sprint", projSecurity, net1000, actDev, 480);
			seedExpenseActivityIfMissing(userRyan, today, supportCategory, expenseBudget.getBudgetId(),
					"Training Conference", dirCode, reasonCode, cpcCode, 480);

			seedProjectActivityIfMissing(userDuncan, today, devCategory, capitalBudget.getBudgetId(),
					"Security Hardening Planning", projSecurity, net1000, actDev, 180);

			seedProjectActivityIfMissing(userKeith, today, devCategory, capitalBudget.getBudgetId(),
					"Feature Development", projSecurity, net1000, actDev, 300);

			seedExpenseActivityIfMissing(userMatthew, today, supportCategory, expenseBudget.getBudgetId(),
					"Support Coverage", dirCode, reasonCode, cpcCode, 120);

			t.commit();
			
			// Re-enable FK checks
			try {
				PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
				session.connection().createStatement().execute("SET FOREIGN_KEY_CHECKS=1");
			} catch (Exception e) {
				throw new PersistentException("Failed to re-enable FK checks", e);
			}
		} catch (Exception e) {
			t.rollback();
			throw e;
		}
		System.out.println("✓ Data seeded successfully!");
	} // end seedAll

	// ── HELPERS ───────────────────────────────────────────────────────────────
	// creates a date with local midnight for stable ORM IDs
	private Date date(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	} // end date

	// normalizes a date to midnight for comparisons
	private Date truncateDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	} // end truncateDate

	// ensures a budget exists by description
	private Budget ensureBudget(String description) throws PersistentException {
		int budgetId = description.equals("Expense") ? 1 : 2;
		try {
			Budget budget = BudgetDAO.loadBudgetByORMID(budgetId);
			if (budget != null) {
				return budget;
			}
		} catch (Exception e) {
			// Budget not found; will insert below
		}
		// Use raw SQL to insert budget with explicit ID (setter is private in ORM entity)
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			String sql = "INSERT INTO Budget (BudgetId, budgetDescription) VALUES (" + budgetId + ", '" + description + "')";
			session.connection().createStatement().executeUpdate(sql);
			session.flush();
			return BudgetDAO.loadBudgetByORMID(budgetId);
		} catch (Exception e) {
			throw new PersistentException("Failed to create budget: " + description, e);
		}
	} // end ensureBudget

	// validates that budgets map to ActivityContainer expectations
	private void validateBudgetIds(Budget expenseBudget, Budget capitalBudget) {
		if (expenseBudget.getBudgetId() != 1 || capitalBudget.getBudgetId() != 2) {
			throw new IllegalStateException("Budget IDs must be 1 (Expense) and 2 (Capital) for ActivityContainer.");
		}
	} // end validateBudgetIds

	// ensures a union exists
	private Union ensureUnion(int unionId, String unionName) throws PersistentException {
		Union union = UnionDAO.loadUnionByQuery("unionId=" + unionId, null);
		if (union != null) {
			return union;
		}
		union = UnionDAO.createUnion();
		union.setUnionId(unionId);
		union.setUnionName(unionName);
		UnionDAO.save(union);
		return union;
	} // end ensureUnion

	// ensures a position exists
	private Position ensurePosition(int positionId, int latCode, String description, String status, Union union) throws PersistentException {
		Position position = PositionDAO.loadPositionByQuery("positionID=" + positionId, null);
		if (position != null) {
			return position;
		}
		position = PositionDAO.createPosition();
		position.setPositionID(positionId);
		position.setLatCode(latCode);
		position.setDescription(description);
		position.setStatus(status);
		position.setUnionunion(union);
		PositionDAO.save(position);
		return position;
	} // end ensurePosition

	// ensures a user exists by employee id; FK checks disabled, so manager/dept set later
	private User ensureUser(int empId, String firstName, String lastName, String email, Date ncsDate, int roleId) throws PersistentException {
		// Use raw SQL for insert with all required fields (ORM doesn't expose manager/position setters)
		try {
			java.sql.Connection conn = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().connection();
			java.sql.Statement stmt = conn.createStatement();
			// Check if user exists
			java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE empId=" + empId);
			if (rs.next()) {
				rs.close();
				return UserDAO.loadUserByORMID(empId);
			}
			rs.close();
			// Insert user with temporary/self-ref values for manager, position=1, deptID=1
			String sql = String.format(
				"INSERT INTO User (empId, firstName, lastName, email, ncsDate, roleID, manager, PositionpositionID, DepartmentdeptID) " +
				"VALUES (%d, '%s', '%s', '%s', '%s', %d, %d, 1, 1)",
				empId, firstName, lastName, email, new SimpleDateFormat("yyyy-MM-dd").format(ncsDate), roleId, empId
			);
			stmt.executeUpdate(sql);
			return UserDAO.loadUserByORMID(empId);
		} catch (Exception e) {
			throw new PersistentException("Failed to create user empId=" + empId, e);
		}
	} // end ensureUser

	// removed updateUserDeptAndManager — not needed with FK checks disabled

	// ensures a user auth record exists and is linked to the user
	private void ensureUserAuth(User user, String username, String password) throws PersistentException {
		User_Auth auth = User_AuthDAO.loadUser_AuthByQuery("userName='" + username + "'", null);
		if (auth == null) {
			auth = User_AuthDAO.createUser_Auth();
			auth.setUserName(username);
		}
		auth.setUseremp(user);
		auth.setPassword(password);
		User_AuthDAO.save(auth);
		user.setUser_Auth(auth);
		UserDAO.save(user);
	} // end ensureUserAuth

	// ensures a department exists by name
	private Department ensureDepartment(int deptId, String deptName, User manager) throws PersistentException {
		Department dept = DepartmentDAO.loadDepartmentByQuery("deptName='" + deptName + "'", null);
		if (dept == null) {
			dept = DepartmentDAO.createDepartment();
			dept.setDeptID(deptId);
			dept.setDeptName(deptName);
		}
		dept.setUseremp(manager);
		DepartmentDAO.save(dept);
		return dept;
	} // end ensureDepartment

	// ensures a user position link exists
	private void ensureUserPosition(User user, Position position, Date startDate) throws PersistentException {
		String condition = "UserempId=" + user.getEmpId() + " AND PositionpositionID=" + position.getPositionID()
				+ " AND startDate='" + formatDate(startDate) + "'";
		User_Position existing = User_PositionDAO.loadUser_PositionByQuery(condition, null);
		if (existing != null) {
			return;
		}
		User_Position link = User_PositionDAO.createUser_Position();
		link.setUseremp(user);
		link.setPositionposition(position);
		link.setStartDate(startDate);
		User_PositionDAO.save(link);
	} // end ensureUserPosition

	// ensures a department user link exists
	private void ensureDepartmentUser(User user, Department dept, Date startDate) throws PersistentException {
		String condition = "UserempId=" + user.getEmpId() + " AND DepartmentdeptID=" + dept.getDeptID()
				+ " AND startDate='" + formatDate(startDate) + "'";
		Department_User existing = Department_UserDAO.loadDepartment_UserByQuery(condition, null);
		if (existing != null) {
			return;
		}
		Department_User link = Department_UserDAO.createDepartment_User();
		link.setUseremp(user);
		link.setDepartmentdept(dept);
		link.setStartDate(startDate);
		Department_UserDAO.save(link);
	} // end ensureDepartmentUser

	// ensures a category exists by name
	private void ensureCategory(String name) throws PersistentException {
		Category category = CategoryDAO.loadCategoryByQuery("categoryName='" + name + "'", null);
		if (category != null) {
			return;
		}
		category = CategoryDAO.createCategory();
		category.setCategoryName(name);
		CategoryDAO.save(category);
	} // end ensureCategory

	// loads a category by name
	private Category loadCategoryByName(String name) throws PersistentException {
		return CategoryDAO.loadCategoryByQuery("categoryName='" + name + "'", null);
	} // end loadCategoryByName

	// ensures an activity code exists
	private void ensureActivityCode(int code, String description) throws PersistentException {
		Activity_Codes existing = Activity_CodesDAO.loadActivity_CodesByQuery("activityCode=" + code, null);
		if (existing != null) {
			return;
		}
		Activity_Codes item = Activity_CodesDAO.createActivity_Codes();
		item.setActivityCode(code);
		item.setDescription(description);
		Activity_CodesDAO.save(item);
	} // end ensureActivityCode

	// loads an activity code by id
	private Activity_Codes loadActivityCode(int code) throws PersistentException {
		return Activity_CodesDAO.loadActivity_CodesByQuery("activityCode=" + code, null);
	} // end loadActivityCode

	// ensures a network number exists
	private void ensureNetworkNumber(int number, String description) throws PersistentException {
		Network_Numbers existing = Network_NumbersDAO.loadNetwork_NumbersByQuery("networkNumber=" + number, null);
		if (existing != null) {
			return;
		}
		Network_Numbers item = Network_NumbersDAO.createNetwork_Numbers();
		item.setNetworkNumber(number);
		item.setDescription(description);
		Network_NumbersDAO.save(item);
	} // end ensureNetworkNumber

	// loads a network number by id
	private Network_Numbers loadNetworkNumber(int number) throws PersistentException {
		return Network_NumbersDAO.loadNetwork_NumbersByQuery("networkNumber=" + number, null);
	} // end loadNetworkNumber

	// ensures a project exists
	private void ensureProject(String projectNo, String description) throws PersistentException {
		Project existing = ProjectDAO.loadProjectByQuery("projectNo='" + projectNo + "'", null);
		if (existing != null) {
			return;
		}
		Project project = ProjectDAO.createProject();
		project.setProjectNo(projectNo);
		project.setDescription(description);
		ProjectDAO.save(project);
	} // end ensureProject

	// loads a project by number
	private Project loadProjectByNo(String projectNo) throws PersistentException {
		return ProjectDAO.loadProjectByQuery("projectNo='" + projectNo + "'", null);
	} // end loadProjectByNo

	// ensures a director code exists
	private void ensureDirectorCode(String code, String description) throws PersistentException {
		Director_Code existing = Director_CodeDAO.loadDirector_CodeByQuery("directorCode='" + code + "'", null);
		if (existing != null) {
			return;
		}
		Director_Code item = Director_CodeDAO.createDirector_Code();
		item.setDirectorCode(code);
		item.setDescription(description);
		Director_CodeDAO.save(item);
	} // end ensureDirectorCode

	// loads a director code
	private Director_Code loadDirectorCode(String code) throws PersistentException {
		return Director_CodeDAO.loadDirector_CodeByQuery("directorCode='" + code + "'", null);
	} // end loadDirectorCode

	// ensures a reason code exists
	private void ensureReasonCode(String code, String description) throws PersistentException {
		Reason_Code existing = Reason_CodeDAO.loadReason_CodeByQuery("reasonCode='" + code + "'", null);
		if (existing != null) {
			return;
		}
		Reason_Code item = Reason_CodeDAO.createReason_Code();
		item.setReasonCode(code);
		item.setDescription(description);
		Reason_CodeDAO.save(item);
	} // end ensureReasonCode

	// loads a reason code
	private Reason_Code loadReasonCode(String code) throws PersistentException {
		return Reason_CodeDAO.loadReason_CodeByQuery("reasonCode='" + code + "'", null);
	} // end loadReasonCode

	// ensures a CPC code exists
	private void ensureCpcCode(String code, String description) throws PersistentException {
		CPC_Code existing = CPC_CodeDAO.loadCPC_CodeByQuery("cpcCode='" + code + "'", null);
		if (existing != null) {
			return;
		}
		CPC_Code item = CPC_CodeDAO.createCPC_Code();
		item.setCpcCode(code);
		item.setDescription(description);
		CPC_CodeDAO.save(item);
	} // end ensureCpcCode

	// loads a CPC code
	private CPC_Code loadCpcCode(String code) throws PersistentException {
		return CPC_CodeDAO.loadCPC_CodeByQuery("cpcCode='" + code + "'", null);
	} // end loadCpcCode

	// ensures a calendar category exists
	private Calendar_Category ensureCalendarCategory(String name, String description) throws PersistentException {
		Calendar_Category existing = Calendar_CategoryDAO.loadCalendar_CategoryByQuery("calendarCatName='" + name + "'", null);
		if (existing != null) {
			return existing;
		}
		Calendar_Category category = Calendar_CategoryDAO.createCalendar_Category();
		category.setCalendarCatName(name);
		category.setDescription(description);
		Calendar_CategoryDAO.save(category);
		return category;
	} // end ensureCalendarCategory

	// ensures a calendar entry exists
	private void ensureCalendar(Date date, Calendar_Category category) throws PersistentException {
		String condition = "date='" + formatDate(date) + "'";
		mts.dsc.orm.calendar.Calendar existing = CalendarDAO.loadCalendarByQuery(condition, null);
		if (existing != null) {
			return;
		}
		mts.dsc.orm.calendar.Calendar entry = CalendarDAO.createCalendar();
		entry.setDate(date);
		entry.setCalendar_CategorycalendarCategory(category);
		CalendarDAO.save(entry);
	} // end ensureCalendar

	// seeds a project activity in the same flow as the UI
	private void seedProjectActivityIfMissing(User user, Date date, Category category, int budgetId,
			String description, Project project, Network_Numbers network, Activity_Codes code, int actualMinutes) throws PersistentException {
		String condition = "UserempId=" + user.getEmpId() + " AND Calendardate='" + formatDate(date) + "' AND description='" + description + "'";
		Activity existing = ActivityDAO.loadActivityByQuery(condition, null);
		if (existing != null) {
			return;
		}

		ActivityContainer container = new ActivityContainer(budgetId);
		container.setUseremp(user);
		container.setCalandardate(loadCalendarByDate(date));
		container.setCategory(category);
		container.setDescription(description);
		container.setActualDuration(actualMinutes);
		container.setPlannedDuration(toTime(actualMinutes));
		container.setStartTime(new Timestamp(System.currentTimeMillis()));
		container.setEndTime(new Timestamp(System.currentTimeMillis()));
		container.setProject(project);
		container.setNetwork_Number(network);
		container.setActivity_Code(code);
		container.save();
	} // end seedProjectActivityIfMissing

	// seeds an expense activity in the same flow as the UI
	private void seedExpenseActivityIfMissing(User user, Date date, Category category, int budgetId,
			String description, Director_Code director, Reason_Code reason, CPC_Code cpc, int actualMinutes) throws PersistentException {
		String condition = "UserempId=" + user.getEmpId() + " AND Calendardate='" + formatDate(date) + "' AND description='" + description + "'";
		Activity existing = ActivityDAO.loadActivityByQuery(condition, null);
		if (existing != null) {
			return;
		}

		ActivityContainer container = new ActivityContainer(budgetId);
		container.setUseremp(user);
		container.setCalandardate(loadCalendarByDate(date));
		container.setCategory(category);
		container.setDescription(description);
		container.setActualDuration(actualMinutes);
		container.setPlannedDuration(toTime(actualMinutes));
		container.setStartTime(new Timestamp(System.currentTimeMillis()));
		container.setEndTime(new Timestamp(System.currentTimeMillis()));
		container.setDirector_Code(director);
		container.setReason_Code(reason);
		container.setCPC_Code(cpc);
		container.save();
	} // end seedExpenseActivityIfMissing

	// loads a calendar by date
	private mts.dsc.orm.calendar.Calendar loadCalendarByDate(Date date) throws PersistentException {
		String condition = "date='" + formatDate(date) + "'";
		return CalendarDAO.loadCalendarByQuery(condition, null);
	} // end loadCalendarByDate

	// formats dates for ORM query usage
	private String formatDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	} // end formatDate

	// converts minutes to a java.sql.Time value
	private Time toTime(int minutes) {
		int hours = minutes / 60;
		int mins = minutes % 60;
		return Time.valueOf(String.format("%02d:%02d:00", hours, mins));
	} // end toTime

	// applies DB connection overrides for CLI usage
	private void applyDbOverrides() throws PersistentException {
		String url = readEnv("DB_URL");
		String host = readEnv("DB_HOST");
		String port = readEnv("DB_PORT");
		String name = readEnv("DB_NAME");
		String user = readEnv("DB_USER");
		String password = readEnv("DB_PASSWORD");
		if (url == null) {
			url = buildJdbcUrl(host, port, name);
		}
		if (url == null || user == null || password == null) {
			throw new IllegalStateException("Set DB_URL (or DB_HOST/DB_PORT/DB_NAME), DB_USER, and DB_PASSWORD before seeding.");
		}
		Properties props = new Properties();
		props.setProperty("connection.url", url);
		props.setProperty("connection.username", user);
		props.setProperty("connection.password", password);
		props.setProperty("connection.driver_class", "com.mysql.jdbc.Driver");
		props.setProperty("dialect", "org.hibernate.dialect.MySQLInnoDBDialect");

		org.orm.cfg.JDBCConnectionSetting setting = new org.orm.cfg.JDBCConnectionSetting(
				"com.mysql.jdbc.Driver",
				"org.hibernate.dialect.MySQLInnoDBDialect",
				url,
				user,
				password);
		mts.dsc.orm.department_user.DSCPersistentManager.setJDBCConnectionSetting(setting);
		mts.dsc.orm.department_user.DSCPersistentManager.setHibernateProperties(props);
	} // end applyDbOverrides

	// creates the schema if it does not already exist
	private void ensureSchema() {
		try {
			ORMDatabaseInitiator.createSchema(mts.dsc.orm.department_user.DSCPersistentManager.instance());
		} catch (Exception e) {
			// Ignore errors when schema already exists.
		}
	} // end ensureSchema

	// reads a non-empty env var
	private String readEnv(String name) {
		String value = System.getenv(name);
		if (value == null) {
			return null;
		}
		value = value.trim();
		return value.isEmpty() ? null : value;
	} // end readEnv

	// builds a JDBC URL from host/port/name
	private String buildJdbcUrl(String host, String port, String name) {
		if (name == null) {
			return null;
		}
		String resolvedHost = host == null ? "localhost" : host;
		String resolvedPort = port == null ? "4306" : port;
		return "jdbc:mysql://" + resolvedHost + ":" + resolvedPort + "/" + name
				+ "?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
	} // end buildJdbcUrl
} // end ModernSeedData
