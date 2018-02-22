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
package mts.dsc.orm.expense_activity;

public class Expense_Activity {
	public Expense_Activity() {
	}
	
	private mts.dsc.orm.activity.Activity Activityactivity;
	
	private mts.dsc.orm.director_code.Director_Code Director_CodedirectorCode;
	
	private mts.dsc.orm.reason_code.Reason_Code Reason_CodereasonCode;
	
	private mts.dsc.orm.cpc_code.CPC_Code CPC_CodecpcCode;
	
	public void setActivityactivity(mts.dsc.orm.activity.Activity value) {
		this.Activityactivity = value;
	}
	
	public mts.dsc.orm.activity.Activity getActivityactivity() {
		return Activityactivity;
	}
	
	public mts.dsc.orm.activity.Activity getORMID() {
		return getActivityactivity();
	}
	
	public void setDirector_CodedirectorCode(mts.dsc.orm.director_code.Director_Code value) {
		this.Director_CodedirectorCode = value;
	}
	
	public mts.dsc.orm.director_code.Director_Code getDirector_CodedirectorCode() {
		return Director_CodedirectorCode;
	}
	
	public void setReason_CodereasonCode(mts.dsc.orm.reason_code.Reason_Code value) {
		this.Reason_CodereasonCode = value;
	}
	
	public mts.dsc.orm.reason_code.Reason_Code getReason_CodereasonCode() {
		return Reason_CodereasonCode;
	}
	
	public void setCPC_CodecpcCode(mts.dsc.orm.cpc_code.CPC_Code value) {
		this.CPC_CodecpcCode = value;
	}
	
	public mts.dsc.orm.cpc_code.CPC_Code getCPC_CodecpcCode() {
		return CPC_CodecpcCode;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(((getActivityactivity() == null) ? "" : String.valueOf(getActivityactivity().getORMID())));
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Expense_Activity[ ");
			if (getActivityactivity() != null)
				sb.append("Activityactivity.Persist_ID=").append(getActivityactivity().toString(true)).append(" ");
			else
				sb.append("Activityactivity=null ");
			if (getDirector_CodedirectorCode() != null)
				sb.append("Director_CodedirectorCode.Persist_ID=").append(getDirector_CodedirectorCode().toString(true)).append(" ");
			else
				sb.append("Director_CodedirectorCode=null ");
			if (getReason_CodereasonCode() != null)
				sb.append("Reason_CodereasonCode.Persist_ID=").append(getReason_CodereasonCode().toString(true)).append(" ");
			else
				sb.append("Reason_CodereasonCode=null ");
			if (getCPC_CodecpcCode() != null)
				sb.append("CPC_CodecpcCode.Persist_ID=").append(getCPC_CodecpcCode().toString(true)).append(" ");
			else
				sb.append("CPC_CodecpcCode=null ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
