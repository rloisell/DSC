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
package mts.dsc.orm.reason_code;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class Reason_CodeDAO {
	public static Reason_Code loadReason_CodeByORMID(String reasonCode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadReason_CodeByORMID(session, reasonCode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Reason_Code loadReason_CodeByORMID(String reasonCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadReason_CodeByORMID(session, reasonCode, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Reason_Code loadReason_CodeByORMID(PersistentSession session, String reasonCode) throws PersistentException {
		try {
			return (Reason_Code) session.load(mts.dsc.orm.reason_code.Reason_Code.class, reasonCode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Reason_Code loadReason_CodeByORMID(PersistentSession session, String reasonCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Reason_Code) session.load(mts.dsc.orm.reason_code.Reason_Code.class, reasonCode, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Reason_Code[] listReason_CodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listReason_CodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Reason_Code[] listReason_CodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listReason_CodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Reason_Code[] listReason_CodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.reason_code.Reason_Code as Reason_Code");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Reason_Code[]) list.toArray(new Reason_Code[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Reason_Code[] listReason_CodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.reason_code.Reason_Code as Reason_Code");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Reason_Code[]) list.toArray(new Reason_Code[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Reason_Code loadReason_CodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadReason_CodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Reason_Code loadReason_CodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadReason_CodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Reason_Code loadReason_CodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Reason_Code[] reason_Codes = listReason_CodeByQuery(session, condition, orderBy);
		if (reason_Codes != null && reason_Codes.length > 0)
			return reason_Codes[0];
		else
			return null;
	}
	
	public static Reason_Code loadReason_CodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Reason_Code[] reason_Codes = listReason_CodeByQuery(session, condition, orderBy, lockMode);
		if (reason_Codes != null && reason_Codes.length > 0)
			return reason_Codes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateReason_CodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateReason_CodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReason_CodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateReason_CodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReason_CodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.reason_code.Reason_Code as Reason_Code");
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
	
	public static java.util.Iterator iterateReason_CodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.reason_code.Reason_Code as Reason_Code");
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
	
	public static Reason_Code createReason_Code() {
		return new mts.dsc.orm.reason_code.Reason_Code();
	}
	
	public static boolean save(mts.dsc.orm.reason_code.Reason_Code reason_Code) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(reason_Code);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.reason_code.Reason_Code reason_Code) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(reason_Code);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.reason_code.Reason_Code reason_Code)throws PersistentException {
		try {
			mts.dsc.orm.expense_activity.Expense_Activity[] lExpense_Activitys = (mts.dsc.orm.expense_activity.Expense_Activity[])reason_Code.getExpense_Activity().toArray(new mts.dsc.orm.expense_activity.Expense_Activity[reason_Code.getExpense_Activity().size()]);
			for(int i = 0; i < lExpense_Activitys.length; i++) {
				lExpense_Activitys[i].setReason_CodereasonCode(null);
			}
			return delete(reason_Code);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.reason_code.Reason_Code reason_Code, org.orm.PersistentSession session)throws PersistentException {
		try {
			mts.dsc.orm.expense_activity.Expense_Activity[] lExpense_Activitys = (mts.dsc.orm.expense_activity.Expense_Activity[])reason_Code.getExpense_Activity().toArray(new mts.dsc.orm.expense_activity.Expense_Activity[reason_Code.getExpense_Activity().size()]);
			for(int i = 0; i < lExpense_Activitys.length; i++) {
				lExpense_Activitys[i].setReason_CodereasonCode(null);
			}
			try {
				session.delete(reason_Code);
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
	
	public static boolean refresh(mts.dsc.orm.reason_code.Reason_Code reason_Code) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(reason_Code);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
