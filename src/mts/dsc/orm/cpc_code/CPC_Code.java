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
package mts.dsc.orm.cpc_code;

public class CPC_Code {
	public CPC_Code() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof CPC_Code))
			return false;
		CPC_Code cpc_code = (CPC_Code)aObj;
		if ((getCpcCode() != null && !getCpcCode().equals(cpc_code.getCpcCode())) || (getCpcCode() == null && cpc_code.getCpcCode() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getCpcCode() == null ? 0 : getCpcCode().hashCode());
		return hashcode;
	}
	
	private String cpcCode;
	
	private String description;
	
	private java.util.Set Expense_Activity = new java.util.HashSet();
	
	public void setCpcCode(String value) {
		this.cpcCode = value;
	}
	
	public String getCpcCode() {
		return cpcCode;
	}
	
	public String getORMID() {
		return getCpcCode();
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
			return String.valueOf(getCpcCode());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("CPC_Code[ ");
			sb.append("CpcCode=").append(getCpcCode()).append(" ");
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
