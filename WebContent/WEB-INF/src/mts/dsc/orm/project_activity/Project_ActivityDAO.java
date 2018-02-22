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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class Project_ActivityDAO {
	public static Project_Activity[] listProject_ActivityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listProject_ActivityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project_Activity[] listProject_ActivityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listProject_ActivityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project_Activity[] listProject_ActivityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.project_activity.Project_Activity as Project_Activity");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Project_Activity[]) list.toArray(new Project_Activity[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project_Activity[] listProject_ActivityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.project_activity.Project_Activity as Project_Activity");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Project_Activity[]) list.toArray(new Project_Activity[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project_Activity loadProject_ActivityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadProject_ActivityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project_Activity loadProject_ActivityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadProject_ActivityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project_Activity loadProject_ActivityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Project_Activity[] project_Activitys = listProject_ActivityByQuery(session, condition, orderBy);
		if (project_Activitys != null && project_Activitys.length > 0)
			return project_Activitys[0];
		else
			return null;
	}
	
	public static Project_Activity loadProject_ActivityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Project_Activity[] project_Activitys = listProject_ActivityByQuery(session, condition, orderBy, lockMode);
		if (project_Activitys != null && project_Activitys.length > 0)
			return project_Activitys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProject_ActivityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateProject_ActivityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProject_ActivityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateProject_ActivityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProject_ActivityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.project_activity.Project_Activity as Project_Activity");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProject_ActivityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.project_activity.Project_Activity as Project_Activity");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project_Activity createProject_Activity() {
		return new mts.dsc.orm.project_activity.Project_Activity();
	}
	
	public static boolean save(mts.dsc.orm.project_activity.Project_Activity project_Activity) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(project_Activity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.project_activity.Project_Activity project_Activity) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(project_Activity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.project_activity.Project_Activity project_Activity)throws PersistentException {
		try {
			if(project_Activity.getProjectprojectNo() != null) {
				project_Activity.getProjectprojectNo().getProject_Activity().remove(project_Activity);
			}
			
			if(project_Activity.getNetwork_NumbersnetworkNumber() != null) {
				project_Activity.getNetwork_NumbersnetworkNumber().getProject_Activity().remove(project_Activity);
			}
			
			if(project_Activity.getActivity_CodesactivityCode() != null) {
				project_Activity.getActivity_CodesactivityCode().getProject_Activity().remove(project_Activity);
			}
			
			if(project_Activity.getActivityactivity() != null) {
				project_Activity.getActivityactivity().setProject_Activity(null);
			}
			
			return delete(project_Activity);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.project_activity.Project_Activity project_Activity, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(project_Activity.getProjectprojectNo() != null) {
				project_Activity.getProjectprojectNo().getProject_Activity().remove(project_Activity);
			}
			
			if(project_Activity.getNetwork_NumbersnetworkNumber() != null) {
				project_Activity.getNetwork_NumbersnetworkNumber().getProject_Activity().remove(project_Activity);
			}
			
			if(project_Activity.getActivity_CodesactivityCode() != null) {
				project_Activity.getActivity_CodesactivityCode().getProject_Activity().remove(project_Activity);
			}
			
			if(project_Activity.getActivityactivity() != null) {
				project_Activity.getActivityactivity().setProject_Activity(null);
			}
			
			try {
				session.delete(project_Activity);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(mts.dsc.orm.project_activity.Project_Activity project_Activity) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(project_Activity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
