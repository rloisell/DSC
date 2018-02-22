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
package mts.dsc.orm.reason_code;

public class Reason_Code {
	public Reason_Code() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Reason_Code))
			return false;
		Reason_Code reason_code = (Reason_Code)aObj;
		if ((getReasonCode() != null && !getReasonCode().equals(reason_code.getReasonCode())) || (getReasonCode() == null && reason_code.getReasonCode() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getReasonCode() == null ? 0 : getReasonCode().hashCode());
		return hashcode;
	}
	
	private String reasonCode;
	
	private String description;
	
	private java.util.Set Expense_Activity = new java.util.HashSet();
	
	public void setReasonCode(String value) {
		this.reasonCode = value;
	}
	
	public String getReasonCode() {
		return reasonCode;
	}
	
	public String getORMID() {
		return getReasonCode();
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setExpense_Activity(java.util.Set value) {
		this.Expense_Activity = value;
	}
	
	public java.util.Set getExpense_Activity() {
		return Expense_Activity;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getReasonCode());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Reason_Code[ ");
			sb.append("ReasonCode=").append(getReasonCode()).append(" ");
			sb.append("Description=").append(getDescription()).append(" ");
			sb.append("Expense_Activity.size=").append(getExpense_Activity().size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
