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
package mts.dsc.orm.project_activity;

public class Project_Activity {
	public Project_Activity() {
	}
	
	private mts.dsc.orm.project.Project ProjectprojectNo;
	
	private mts.dsc.orm.network_numbers.Network_Numbers Network_NumbersnetworkNumber;
	
	private mts.dsc.orm.activity_codes.Activity_Codes Activity_CodesactivityCode;
	
	private mts.dsc.orm.activity.Activity Activityactivity;
	
	public void setActivityactivity(mts.dsc.orm.activity.Activity value) {
		this.Activityactivity = value;
	}
	
	public mts.dsc.orm.activity.Activity getActivityactivity() {
		return Activityactivity;
	}
	
	public mts.dsc.orm.activity.Activity getORMID() {
		return getActivityactivity();
	}
	
	public void setNetwork_NumbersnetworkNumber(mts.dsc.orm.network_numbers.Network_Numbers value) {
		this.Network_NumbersnetworkNumber = value;
	}
	
	public mts.dsc.orm.network_numbers.Network_Numbers getNetwork_NumbersnetworkNumber() {
		return Network_NumbersnetworkNumber;
	}
	
	public void setActivity_CodesactivityCode(mts.dsc.orm.activity_codes.Activity_Codes value) {
		this.Activity_CodesactivityCode = value;
	}
	
	public mts.dsc.orm.activity_codes.Activity_Codes getActivity_CodesactivityCode() {
		return Activity_CodesactivityCode;
	}
	
	public void setProjectprojectNo(mts.dsc.orm.project.Project value) {
		this.ProjectprojectNo = value;
	}
	
	public mts.dsc.orm.project.Project getProjectprojectNo() {
		return ProjectprojectNo;
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
			sb.append("Project_Activity[ ");
			if (getProjectprojectNo() != null)
				sb.append("ProjectprojectNo.Persist_ID=").append(getProjectprojectNo().toString(true)).append(" ");
			else
				sb.append("ProjectprojectNo=null ");
			if (getNetwork_NumbersnetworkNumber() != null)
				sb.append("Network_NumbersnetworkNumber.Persist_ID=").append(getNetwork_NumbersnetworkNumber().toString(true)).append(" ");
			else
				sb.append("Network_NumbersnetworkNumber=null ");
			if (getActivity_CodesactivityCode() != null)
				sb.append("Activity_CodesactivityCode.Persist_ID=").append(getActivity_CodesactivityCode().toString(true)).append(" ");
			else
				sb.append("Activity_CodesactivityCode=null ");
			if (getActivityactivity() != null)
				sb.append("Activityactivity.Persist_ID=").append(getActivityactivity().toString(true)).append(" ");
			else
				sb.append("Activityactivity=null ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
