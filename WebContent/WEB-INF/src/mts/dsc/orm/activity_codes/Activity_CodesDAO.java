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
package mts.dsc.orm.activity_codes;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class Activity_CodesDAO {
	public static Activity_Codes loadActivity_CodesByORMID(int activityCode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadActivity_CodesByORMID(session, activityCode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity_Codes loadActivity_CodesByORMID(int activityCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadActivity_CodesByORMID(session, activityCode, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity_Codes loadActivity_CodesByORMID(PersistentSession session, int activityCode) throws PersistentException {
		try {
			return (Activity_Codes) session.load(mts.dsc.orm.activity_codes.Activity_Codes.class, new Integer(activityCode));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity_Codes loadActivity_CodesByORMID(PersistentSession session, int activityCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Activity_Codes) session.load(mts.dsc.orm.activity_codes.Activity_Codes.class, new Integer(activityCode), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity_Codes[] listActivity_CodesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listActivity_CodesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity_Codes[] listActivity_CodesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listActivity_CodesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity_Codes[] listActivity_CodesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.activity_codes.Activity_Codes as Activity_Codes");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Activity_Codes[]) list.toArray(new Activity_Codes[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity_Codes[] listActivity_CodesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.activity_codes.Activity_Codes as Activity_Codes");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Activity_Codes[]) list.toArray(new Activity_Codes[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity_Codes loadActivity_CodesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadActivity_CodesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity_Codes loadActivity_CodesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadActivity_CodesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Activity_Codes loadActivity_CodesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Activity_Codes[] activity_Codeses = listActivity_CodesByQuery(session, condition, orderBy);
		if (activity_Codeses != null && activity_Codeses.length > 0)
			return activity_Codeses[0];
		else
			return null;
	}
	
	public static Activity_Codes loadActivity_CodesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Activity_Codes[] activity_Codeses = listActivity_CodesByQuery(session, condition, orderBy, lockMode);
		if (activity_Codeses != null && activity_Codeses.length > 0)
			return activity_Codeses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateActivity_CodesByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateActivity_CodesByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateActivity_CodesByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateActivity_CodesByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateActivity_CodesByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.activity_codes.Activity_Codes as Activity_Codes");
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
	
	public static java.util.Iterator iterateActivity_CodesByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.activity_codes.Activity_Codes as Activity_Codes");
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
	
	public static Activity_Codes createActivity_Codes() {
		return new mts.dsc.orm.activity_codes.Activity_Codes();
	}
	
	public static boolean save(mts.dsc.orm.activity_codes.Activity_Codes activity_Codes) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(activity_Codes);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.activity_codes.Activity_Codes activity_Codes) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(activity_Codes);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.activity_codes.Activity_Codes activity_Codes)throws PersistentException {
		try {
			mts.dsc.orm.project_activity.Project_Activity[] lProject_Activitys = (mts.dsc.orm.project_activity.Project_Activity[])activity_Codes.getProject_Activity().toArray(new mts.dsc.orm.project_activity.Project_Activity[activity_Codes.getProject_Activity().size()]);
			for(int i = 0; i < lProject_Activitys.length; i++) {
				lProject_Activitys[i].setActivity_CodesactivityCode(null);
			}
			return delete(activity_Codes);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.activity_codes.Activity_Codes activity_Codes, org.orm.PersistentSession session)throws PersistentException {
		try {
			mts.dsc.orm.project_activity.Project_Activity[] lProject_Activitys = (mts.dsc.orm.project_activity.Project_Activity[])activity_Codes.getProject_Activity().toArray(new mts.dsc.orm.project_activity.Project_Activity[activity_Codes.getProject_Activity().size()]);
			for(int i = 0; i < lProject_Activitys.length; i++) {
				lProject_Activitys[i].setActivity_CodesactivityCode(null);
			}
			try {
				session.delete(activity_Codes);
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
	
	public static boolean refresh(mts.dsc.orm.activity_codes.Activity_Codes activity_Codes) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(activity_Codes);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
