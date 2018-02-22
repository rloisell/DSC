/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: MTS Allstream Inc.
 * License Type: Purchased
 */
package mts.dsc.orm.budget;

/**
 * Currently  there are 2 budget types, Expense = 0 and Capital = 1. Another table was created to allow this category to get more granular with time. The selection of a row in this table allows the application to determine if there is a corresponding Project_Activity or Expense_Activity record.
 */
public class Budget {
	public Budget() {
	}
	
	private int budgetId;
	
	private String budgetDescription;
	
	private java.util.Set Activity = new java.util.HashSet();
	
	private void setBudgetId(int value) {
		this.budgetId = value;
	}
	
	public int getBudgetId() {
		return budgetId;
	}
	
	public int getORMID() {
		return getBudgetId();
	}
	
	public void setBudgetDescription(String value) {
		this.budgetDescription = value;
	}
	
	public String getBudgetDescription() {
		return budgetDescription;
	}
	
	public void setActivity(java.util.Set value) {
		this.Activity = value;
	}
	
	public java.util.Set getActivity() {
		return Activity;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getBudgetId());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Budget[ ");
			sb.append("BudgetId=").append(getBudgetId()).append(" ");
			sb.append("BudgetDescription=").append(getBudgetDescription()).append(" ");
			sb.append("Activity.size=").append(getActivity().size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
