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
package mts.dsc.orm.calendar_category;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class Calendar_CategoryDAO {
	public static Calendar_Category loadCalendar_CategoryByORMID(int calendarCategory) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadCalendar_CategoryByORMID(session, calendarCategory);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Calendar_Category loadCalendar_CategoryByORMID(int calendarCategory, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadCalendar_CategoryByORMID(session, calendarCategory, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Calendar_Category loadCalendar_CategoryByORMID(PersistentSession session, int calendarCategory) throws PersistentException {
		try {
			return (Calendar_Category) session.load(mts.dsc.orm.calendar_category.Calendar_Category.class, new Integer(calendarCategory));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Calendar_Category loadCalendar_CategoryByORMID(PersistentSession session, int calendarCategory, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Calendar_Category) session.load(mts.dsc.orm.calendar_category.Calendar_Category.class, new Integer(calendarCategory), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Calendar_Category[] listCalendar_CategoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listCalendar_CategoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Calendar_Category[] listCalendar_CategoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listCalendar_CategoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Calendar_Category[] listCalendar_CategoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.calendar_category.Calendar_Category as Calendar_Category");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Calendar_Category[]) list.toArray(new Calendar_Category[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Calendar_Category[] listCalendar_CategoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.calendar_category.Calendar_Category as Calendar_Category");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Calendar_Category[]) list.toArray(new Calendar_Category[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Calendar_Category loadCalendar_CategoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadCalendar_CategoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Calendar_Category loadCalendar_CategoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadCalendar_CategoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Calendar_Category loadCalendar_CategoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Calendar_Category[] calendar_Categorys = listCalendar_CategoryByQuery(session, condition, orderBy);
		if (calendar_Categorys != null && calendar_Categorys.length > 0)
			return calendar_Categorys[0];
		else
			return null;
	}
	
	public static Calendar_Category loadCalendar_CategoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Calendar_Category[] calendar_Categorys = listCalendar_CategoryByQuery(session, condition, orderBy, lockMode);
		if (calendar_Categorys != null && calendar_Categorys.length > 0)
			return calendar_Categorys[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCalendar_CategoryByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateCalendar_CategoryByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCalendar_CategoryByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateCalendar_CategoryByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCalendar_CategoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.calendar_category.Calendar_Category as Calendar_Category");
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
	
	public static java.util.Iterator iterateCalendar_CategoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.calendar_category.Calendar_Category as Calendar_Category");
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
	
	public static Calendar_Category createCalendar_Category() {
		return new mts.dsc.orm.calendar_category.Calendar_Category();
	}
	
	public static boolean save(mts.dsc.orm.calendar_category.Calendar_Category calendar_Category) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(calendar_Category);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.calendar_category.Calendar_Category calendar_Category) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(calendar_Category);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.calendar_category.Calendar_Category calendar_Category)throws PersistentException {
		try {
			mts.dsc.orm.calendar.Calendar[] lCalandars = (mts.dsc.orm.calendar.Calendar[])calendar_Category.getCalandar().toArray(new mts.dsc.orm.calendar.Calendar[calendar_Category.getCalandar().size()]);
			for(int i = 0; i < lCalandars.length; i++) {
				lCalandars[i].setCalendar_CategorycalendarCategory(null);
			}
			return delete(calendar_Category);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.calendar_category.Calendar_Category calendar_Category, org.orm.PersistentSession session)throws PersistentException {
		try {
			mts.dsc.orm.calendar.Calendar[] lCalandars = (mts.dsc.orm.calendar.Calendar[])calendar_Category.getCalandar().toArray(new mts.dsc.orm.calendar.Calendar[calendar_Category.getCalandar().size()]);
			for(int i = 0; i < lCalandars.length; i++) {
				lCalandars[i].setCalendar_CategorycalendarCategory(null);
			}
			try {
				session.delete(calendar_Category);
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
	
	public static boolean refresh(mts.dsc.orm.calendar_category.Calendar_Category calendar_Category) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(calendar_Category);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
