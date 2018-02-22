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
package mts.dsc.orm.cpc_code;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class CPC_CodeDAO {
	public static CPC_Code loadCPC_CodeByORMID(String cpcCode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadCPC_CodeByORMID(session, cpcCode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CPC_Code loadCPC_CodeByORMID(String cpcCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadCPC_CodeByORMID(session, cpcCode, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CPC_Code loadCPC_CodeByORMID(PersistentSession session, String cpcCode) throws PersistentException {
		try {
			return (CPC_Code) session.load(mts.dsc.orm.cpc_code.CPC_Code.class, cpcCode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CPC_Code loadCPC_CodeByORMID(PersistentSession session, String cpcCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CPC_Code) session.load(mts.dsc.orm.cpc_code.CPC_Code.class, cpcCode, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CPC_Code[] listCPC_CodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listCPC_CodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CPC_Code[] listCPC_CodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listCPC_CodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CPC_Code[] listCPC_CodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.cpc_code.CPC_Code as CPC_Code");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (CPC_Code[]) list.toArray(new CPC_Code[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CPC_Code[] listCPC_CodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.cpc_code.CPC_Code as CPC_Code");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (CPC_Code[]) list.toArray(new CPC_Code[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CPC_Code loadCPC_CodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadCPC_CodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CPC_Code loadCPC_CodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadCPC_CodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static CPC_Code loadCPC_CodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		CPC_Code[] cPC_Codes = listCPC_CodeByQuery(session, condition, orderBy);
		if (cPC_Codes != null && cPC_Codes.length > 0)
			return cPC_Codes[0];
		else
			return null;
	}
	
	public static CPC_Code loadCPC_CodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		CPC_Code[] cPC_Codes = listCPC_CodeByQuery(session, condition, orderBy, lockMode);
		if (cPC_Codes != null && cPC_Codes.length > 0)
			return cPC_Codes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateCPC_CodeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateCPC_CodeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCPC_CodeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateCPC_CodeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateCPC_CodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.cpc_code.CPC_Code as CPC_Code");
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
	
	public static java.util.Iterator iterateCPC_CodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.cpc_code.CPC_Code as CPC_Code");
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
	
	public static CPC_Code createCPC_Code() {
		return new mts.dsc.orm.cpc_code.CPC_Code();
	}
	
	public static boolean save(mts.dsc.orm.cpc_code.CPC_Code cPC_Code) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(cPC_Code);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.cpc_code.CPC_Code cPC_Code) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(cPC_Code);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.cpc_code.CPC_Code cPC_Code)throws PersistentException {
		try {
			mts.dsc.orm.expense_activity.Expense_Activity[] lExpense_Activitys = (mts.dsc.orm.expense_activity.Expense_Activity[])cPC_Code.getExpense_Activity().toArray(new mts.dsc.orm.expense_activity.Expense_Activity[cPC_Code.getExpense_Activity().size()]);
			for(int i = 0; i < lExpense_Activitys.length; i++) {
				lExpense_Activitys[i].setCPC_CodecpcCode(null);
			}
			return delete(cPC_Code);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.cpc_code.CPC_Code cPC_Code, org.orm.PersistentSession session)throws PersistentException {
		try {
			mts.dsc.orm.expense_activity.Expense_Activity[] lExpense_Activitys = (mts.dsc.orm.expense_activity.Expense_Activity[])cPC_Code.getExpense_Activity().toArray(new mts.dsc.orm.expense_activity.Expense_Activity[cPC_Code.getExpense_Activity().size()]);
			for(int i = 0; i < lExpense_Activitys.length; i++) {
				lExpense_Activitys[i].setCPC_CodecpcCode(null);
			}
			try {
				session.delete(cPC_Code);
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
	
	public static boolean refresh(mts.dsc.orm.cpc_code.CPC_Code cPC_Code) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(cPC_Code);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
