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
package mts.dsc.orm.category;

public class Category {
	public Category() {
	}
	
	private int categoryID;
	
	private String categoryName;
	
	private java.util.Set Activity = new java.util.HashSet();
	
	private void setCategoryID(int value) {
		this.categoryID = value;
	}
	
	public int getCategoryID() {
		return categoryID;
	}
	
	public int getORMID() {
		return getCategoryID();
	}
	
	public void setCategoryName(String value) {
		this.categoryName = value;
	}
	
	public String getCategoryName() {
		return categoryName;
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
			return String.valueOf(getCategoryID());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Category[ ");
			sb.append("CategoryID=").append(getCategoryID()).append(" ");
			sb.append("CategoryName=").append(getCategoryName()).append(" ");
			sb.append("Activity.size=").append(getActivity().size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
