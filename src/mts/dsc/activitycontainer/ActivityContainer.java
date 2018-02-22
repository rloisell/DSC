/**
 * THIS IS THE ACTIVITY CONTAINER CLASS, IT ENCAPSULATES THE ACTIVITIES BEING TRACKED.
 * THE CONSTRUCTOR INSTANTIATES AN ACTIVITY OBJECT, THE TAKES THE BUDGET ID SELECTED 
 * FROM THE REQUEST FORM AND INSTANTIATES THE APPROPRIATE CORRESPONDING PROJECT_ACTIVITY 
 * OR EXPENSE_ACTIVITY. 
 * IT IS RESPONSBILE FOR USING THE ORM MODEL TO SAVE THE INFORMATION TO THE DATABASE FOR STORAGE.  
 */
package mts.dsc.activitycontainer;

import mts.dsc.orm.activity.*;
import mts.dsc.orm.expense_activity.*;
import mts.dsc.orm.project_activity.*;

/**
 * @author loiselle
 *
 */
public class ActivityContainer {
	mts.dsc.orm.activity.Activity anActivity;
	mts.dsc.orm.expense_activity.Expense_Activity aExpActivity;
	mts.dsc.orm.project_activity.Project_Activity aProActivity;
	
	// DEFAULT CONSTRUCTOR
	public ActivityContainer() {
	} // END DEFAULT CONSTRUCTOR

	// CONTRUCTOR
	public ActivityContainer( int budgetID ) {
		mts.dsc.orm.budget.Budget aBudget = mts.dsc.orm.budget.BudgetDAO.createBudget();
		try {
			anActivity = mts.dsc.orm.activity.ActivityDAO.createActivity();
			aBudget = mts.dsc.orm.budget.BudgetDAO.loadBudgetByORMID(budgetID);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		anActivity.setBudgetbudget(aBudget);
		if ( budgetID == 1 ) {
			// EXPENSE
			try {
			aExpActivity = mts.dsc.orm.expense_activity.Expense_ActivityDAO.createExpense_Activity();
			aExpActivity.setActivityactivity(anActivity);
			anActivity.setExpense_Activity(aExpActivity);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} else if ( budgetID == 2 ) {
			// CAPITAL
			try {
			aProActivity = mts.dsc.orm.project_activity.Project_ActivityDAO.createProject_Activity();
			aProActivity.setActivityactivity(anActivity);
			anActivity.setProject_Activity(aProActivity);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	} // END CONSTRUCTOR

	// METHODS
	// ACTIVITY RELATED ACCESSOR METHODS
	
	// USED BY GET EMPLOYEE GET DATE ACTIVITIES
	public void setActivity(mts.dsc.orm.activity.Activity anAct) {
		this.anActivity = anAct;
	}
	
	public void setProActivity(mts.dsc.orm.project_activity.Project_Activity pAct) {
		this.aProActivity = pAct;
	}
	
	public void setExpActivity(mts.dsc.orm.expense_activity.Expense_Activity eAct) {
		this.aExpActivity = eAct;
	}
	
	
	// LOCAL VARIABLE ACCESSORS
	public int getActivityID() {
		return anActivity.getActivityID();
	}

	public void setDescription(String value) {
		anActivity.setDescription(value) ;
	}
	
	public String getDescription() {
		return anActivity.getDescription();
	}
	
	public void setStartTime(java.sql.Timestamp value) {
		anActivity.setStartTime(value);
	}
	
	public java.sql.Timestamp getStartTime() {
		return anActivity.getStartTime();
	}
	
	public void setEndTime(java.sql.Timestamp value) {
		anActivity.setEndTime(value);
	}
	
	public java.sql.Timestamp getEndTime() {
		return anActivity.getEndTime();
	}
	
	public void setPlannedDuration(java.sql.Time value) {
		anActivity.setPlannedDuration(value);
	}
	
	public java.sql.Time getPlannedDuration() {
		return anActivity.getPlannedDuration();
	}
	
	public void setActualDuration(int value) {
		anActivity.setActualDuration(value);
	}
	
	public int getActualDuration() {
		return anActivity.getActualDuration();
	}
	
	public void setCalandardate(mts.dsc.orm.calendar.Calendar value) {
		anActivity.setCalandardate(value);
	}
	
	public mts.dsc.orm.calendar.Calendar getCalandardate() {
		return anActivity.getCalandardate();
	}
	
	public void setUseremp(mts.dsc.orm.user.User value) {
		anActivity.setUseremp(value);
	}
	
	public mts.dsc.orm.user.User getUseremp() {
		return anActivity.getUseremp();
	}
	
	public void setCategory(mts.dsc.orm.category.Category value) {
		anActivity.setCategorycategory(value);
	}
	
	public mts.dsc.orm.category.Category getCategory() {
		return anActivity.getCategorycategory();
	}
	
	public void setBudget(mts.dsc.orm.budget.Budget value) {
		anActivity.setBudgetbudget(value);
	}
	
	public mts.dsc.orm.budget.Budget getBudget() {
		return anActivity.getBudgetbudget();
	}
	
	
	// PROJECT RELATED ACCESSOR
	public mts.dsc.orm.project_activity.Project_Activity getProject_Activity() {
		return anActivity.getProject_Activity();
	}

	public void setNetwork_Number(mts.dsc.orm.network_numbers.Network_Numbers value) {
		aProActivity.setNetwork_NumbersnetworkNumber(value);
	}
	
	public mts.dsc.orm.network_numbers.Network_Numbers getNetwork_Number() {
		return aProActivity.getNetwork_NumbersnetworkNumber();
	}
	
	public void setActivity_Code(mts.dsc.orm.activity_codes.Activity_Codes value) {
		aProActivity.setActivity_CodesactivityCode(value);
	}
	
	public mts.dsc.orm.activity_codes.Activity_Codes getActivity_Code() {
		return aProActivity.getActivity_CodesactivityCode();
	}
	
	public void setProject(mts.dsc.orm.project.Project value) {
		aProActivity.setProjectprojectNo(value);
	}
	
	public mts.dsc.orm.project.Project getProject() {
		return aProActivity.getProjectprojectNo();
	}
	
	// EXPENSE RELATED ACCESSOR
	public mts.dsc.orm.expense_activity.Expense_Activity getExpense_Activity() {
		return anActivity.getExpense_Activity();
	}
	
	public void setDirector_Code(mts.dsc.orm.director_code.Director_Code value) {
		aExpActivity.setDirector_CodedirectorCode(value);
	}
	
	public mts.dsc.orm.director_code.Director_Code getDirector_Code() {
		return aExpActivity.getDirector_CodedirectorCode();
	}
	
	public void setReason_Code(mts.dsc.orm.reason_code.Reason_Code value) {
		aExpActivity.setReason_CodereasonCode(value);
	}
	
	public mts.dsc.orm.reason_code.Reason_Code getReason_Code() {
		return aExpActivity.getReason_CodereasonCode();
	}
	
	public void setCPC_Code(mts.dsc.orm.cpc_code.CPC_Code value) {
		aExpActivity.setCPC_CodecpcCode(value);
	}
	
	public mts.dsc.orm.cpc_code.CPC_Code getCPC_Code() {
		return aExpActivity.getCPC_CodecpcCode();
	}
	
	// SAVE ACTIVITY CONTAINER CALLED BY EMPLOYEE. 
	public void save() {
		try {
			mts.dsc.orm.budget.Budget aBudget = mts.dsc.orm.budget.BudgetDAO.createBudget();
			aBudget = this.anActivity.getBudgetbudget();
			int myBudget = aBudget.getBudgetId();
			// SAVE THINGS AS NEEDED NOW			
			mts.dsc.orm.activity.ActivityDAO.save(this.anActivity);
			if ( myBudget == 1 ) {
				// EXPENSE
				mts.dsc.orm.expense_activity.Expense_ActivityDAO.save(this.aExpActivity);
			} else if ( myBudget == 2 ) {
				// CAPITAL
				mts.dsc.orm.project_activity.Project_ActivityDAO.save(this.aProActivity);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END SAVE ACTIVITY
	
	// REFRESH CURRENT ACTIVITY CONTAINER
	public void refresh() {
		try {
			mts.dsc.orm.budget.Budget aBudget = mts.dsc.orm.budget.BudgetDAO.createBudget();
			aBudget = this.anActivity.getBudgetbudget();
			int myBudget = aBudget.getBudgetId();
			// SAVE THINGS AS NEEDED NOW			
			mts.dsc.orm.activity.ActivityDAO.refresh(this.anActivity);
			if ( myBudget == 1 ) {
				// EXPENSE
				mts.dsc.orm.expense_activity.Expense_ActivityDAO.refresh(this.aExpActivity);
			} else if ( myBudget == 2 ) {
				// CAPITAL
				mts.dsc.orm.project_activity.Project_ActivityDAO.refresh(this.aProActivity);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	} // END REFRESH
	
	// UPDATE ACTIVITY CONTAINER CALLED BY EMPLOYEE. 
	public void update() {
		this.save();
	} // END UPDATE ACTIVITY
	
	// DELETE ACTIVITY
	public boolean delete() {
			try {
				mts.dsc.orm.budget.Budget aBudget = mts.dsc.orm.budget.BudgetDAO.createBudget();
				aBudget = this.anActivity.getBudgetbudget();
				int myBudget = aBudget.getBudgetId();
				// SAVE THINGS AS NEEDED NOW			
				mts.dsc.orm.activity.ActivityDAO.delete(this.anActivity);
				if ( myBudget == 1 ) {
					// EXPENSE
					mts.dsc.orm.expense_activity.Expense_ActivityDAO.delete(this.aExpActivity);
				} else if ( myBudget == 2 ) {
					// CAPITAL
					mts.dsc.orm.project_activity.Project_ActivityDAO.delete(this.aProActivity);
				}
				return true;
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	
}
