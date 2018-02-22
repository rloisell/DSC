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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class Expense_ActivityDAO {
	public static Expense_Activity[] listExpense_ActivityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listExpense_ActivityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Expense_Activity[] listExpense_ActivityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listExpense_ActivityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Expense_Activity[] listExpense_ActivityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.expense_activity.Expense_Activity as Expense_Activity");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Expense_Activity[]) list.toArray(new Expense_Activity[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Expense_Activity[] listExpense_ActivityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.expense_activity.Expense_Activity as Expense_Activity");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Expense_Activity[]) list.toArray(new Expense_Activity[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Expense_Activity loadExpense_ActivityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadExpense_ActivityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Expense_Activity loadExpense_ActivityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadExpense_ActivityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Expense_Activity loadExpense_ActivityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Expense_Activity[] expense_Activitys = listExpense_ActivityByQuery(session, condition, orderBy);
		if (expense_Activitys != null && expense_Activitys.length > 0)
			return expense_Activitys[0];
		else
			return null;
	}
	
	public static Expense_Activity loadExpense_ActivityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Expense_Activity[] expense_Activitys = listExpense_ActivityByQuery(session, condition, orderBy, lockMode);
		if (expense_Activitys != null && expense_Activitys.length > 0)
			return expense_Activitys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateExpense_ActivityByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateExpense_ActivityByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateExpense_ActivityByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateExpense_ActivityByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateExpense_ActivityByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.expense_activity.Expense_Activity as Expense_Activity");
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
	
	public static java.util.Iterator iterateExpense_ActivityByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.expense_activity.Expense_Activity as Expense_Activity");
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
	
	public static Expense_Activity createExpense_Activity() {
		return new mts.dsc.orm.expense_activity.Expense_Activity();
	}
	
	public static boolean save(mts.dsc.orm.expense_activity.Expense_Activity expense_Activity) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(expense_Activity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.expense_activity.Expense_Activity expense_Activity) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(expense_Activity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.expense_activity.Expense_Activity expense_Activity)throws PersistentException {
		try {
			if(expense_Activity.getActivityactivity() != null) {
				expense_Activity.getActivityactivity().setExpense_Activity(null);
			}
			
			if(expense_Activity.getDirector_CodedirectorCode() != null) {
				expense_Activity.getDirector_CodedirectorCode().getExpense_Activity().remove(expense_Activity);
			}
			
			if(expense_Activity.getReason_CodereasonCode() != null) {
				expense_Activity.getReason_CodereasonCode().getExpense_Activity().remove(expense_Activity);
			}
			
			if(expense_Activity.getCPC_CodecpcCode() != null) {
				expense_Activity.getCPC_CodecpcCode().getExpense_Activity().remove(expense_Activity);
			}
			
			return delete(expense_Activity);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.expense_activity.Expense_Activity expense_Activity, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(expense_Activity.getActivityactivity() != null) {
				expense_Activity.getActivityactivity().setExpense_Activity(null);
			}
			
			if(expense_Activity.getDirector_CodedirectorCode() != null) {
				expense_Activity.getDirector_CodedirectorCode().getExpense_Activity().remove(expense_Activity);
			}
			
			if(expense_Activity.getReason_CodereasonCode() != null) {
				expense_Activity.getReason_CodereasonCode().getExpense_Activity().remove(expense_Activity);
			}
			
			if(expense_Activity.getCPC_CodecpcCode() != null) {
				expense_Activity.getCPC_CodecpcCode().getExpense_Activity().remove(expense_Activity);
			}
			
			try {
				session.delete(expense_Activity);
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
	
	public static boolean refresh(mts.dsc.orm.expense_activity.Expense_Activity expense_Activity) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(expense_Activity);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
