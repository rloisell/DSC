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
package mts.dsc.orm.director_code;

public class Director_Code {
	public Director_Code() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Director_Code))
			return false;
		Director_Code director_code = (Director_Code)aObj;
		if ((getDirectorCode() != null && !getDirectorCode().equals(director_code.getDirectorCode())) || (getDirectorCode() == null && director_code.getDirectorCode() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getDirectorCode() == null ? 0 : getDirectorCode().hashCode());
		return hashcode;
	}
	
	private String directorCode;
	
	private String description;
	
	private java.util.Set Expense_Activity = new java.util.HashSet();
	
	public void setDirectorCode(String value) {
		this.directorCode = value;
	}
	
	public String getDirectorCode() {
		return directorCode;
	}
	
	public String getORMID() {
		return getDirectorCode();
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
			return String.valueOf(getDirectorCode());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Director_Code[ ");
			sb.append("DirectorCode=").append(getDirectorCode()).append(" ");
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
