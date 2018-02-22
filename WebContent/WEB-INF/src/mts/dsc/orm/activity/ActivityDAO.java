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
package mts.dsc.orm.activity;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class ActivityDAO {
	public static Activity loadActivityByORMID(int activityID) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadActivityByORMID(session, activityID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity loadActivityByORMID(int activityID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadActivityByORMID(session, activityID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity loadActivityByORMID(PersistentSession session, int activityID) throws PersistentException {
		try {
			return (Activity) session.load(mts.dsc.orm.activity.Activity.class, new Integer(activityID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity loadActivityByORMID(PersistentSession session, int activityID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Activity) session.load(mts.dsc.orm.activity.Activity.class, new Integer(activityID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity[] listActivityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listActivityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity[] listActivityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listActivityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity[] listActivityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.activity.Activity as Activity");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Activity[]) list.toArray(new Activity[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity[] listActivityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.activity.Activity as Activity");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Activity[]) list.toArray(new Activity[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity loadActivityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadActivityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity loadActivityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadActivityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity loadActivityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Activity[] activitys = listActivityByQuery(session, condition, orderBy);
		if (activitys != null && activitys.length > 0)
			return activitys[0];
		else
			return null;
	}
	
	public static Activity loadActivityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Activity[] activitys = listActivityByQuery(session, condition, orderBy, lockMode);
		if (activitys != null && activitys.length > 0)
			return activitys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateActivityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateActivityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateActivityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateActivityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateActivityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.activity.Activity as Activity");
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
	
	public static java.util.Iterator iterateActivityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.activity.Activity as Activity");
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
	
	public static Activity createActivity() {
		return new mts.dsc.orm.activity.Activity();
	}
	
	public static boolean save(mts.dsc.orm.activity.Activity activity) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(activity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.activity.Activity activity) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(activity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.activity.Activity activity)throws PersistentException {
		try {
			if(activity.getCalandardate() != null) {
				activity.getCalandardate().getActivity().remove(activity);
			}
			
			if(activity.getUseremp() != null) {
				activity.getUseremp().getActivity().remove(activity);
			}
			
			if(activity.getBudgetbudget() != null) {
				activity.getBudgetbudget().getActivity().remove(activity);
			}
			
			if(activity.getCategorycategory() != null) {
				activity.getCategorycategory().getActivity().remove(activity);
			}
			
			if(activity.getProject_Activity() != null) {
				activity.getProject_Activity().setActivityactivity(null);
			}
			
			if(activity.getExpense_Activity() != null) {
				activity.getExpense_Activity().setActivityactivity(null);
			}
			
			return delete(activity);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.activity.Activity activity, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(activity.getCalandardate() != null) {
				activity.getCalandardate().getActivity().remove(activity);
			}
			
			if(activity.getUseremp() != null) {
				activity.getUseremp().getActivity().remove(activity);
			}
			
			if(activity.getBudgetbudget() != null) {
				activity.getBudgetbudget().getActivity().remove(activity);
			}
			
			if(activity.getCategorycategory() != null) {
				activity.getCategorycategory().getActivity().remove(activity);
			}
			
			if(activity.getProject_Activity() != null) {
				activity.getProject_Activity().setActivityactivity(null);
			}
			
			if(activity.getExpense_Activity() != null) {
				activity.getExpense_Activity().setActivityactivity(null);
			}
			
			try {
				session.delete(activity);
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
	
	public static boolean refresh(mts.dsc.orm.activity.Activity activity) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(activity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
