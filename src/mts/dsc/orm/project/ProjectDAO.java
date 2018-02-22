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
package mts.dsc.orm.project;

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class ProjectDAO {
	public static Project loadProjectByORMID(String projectNo) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadProjectByORMID(session, projectNo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project loadProjectByORMID(String projectNo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadProjectByORMID(session, projectNo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project loadProjectByORMID(PersistentSession session, String projectNo) throws PersistentException {
		try {
			return (Project) session.load(mts.dsc.orm.project.Project.class, projectNo);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project loadProjectByORMID(PersistentSession session, String projectNo, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Project) session.load(mts.dsc.orm.project.Project.class, projectNo, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project[] listProjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listProjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project[] listProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return listProjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project[] listProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.project.Project as Project");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Project[]) list.toArray(new Project[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project[] listProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.project.Project as Project");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Project[]) list.toArray(new Project[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project loadProjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadProjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project loadProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return loadProjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Project loadProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Project[] projects = listProjectByQuery(session, condition, orderBy);
		if (projects != null && projects.length > 0)
			return projects[0];
		else
			return null;
	}
	
	public static Project loadProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Project[] projects = listProjectByQuery(session, condition, orderBy, lockMode);
		if (projects != null && projects.length > 0)
			return projects[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProjectByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateProjectByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProjectByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession();
			return iterateProjectByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProjectByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.project.Project as Project");
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
	
	public static java.util.Iterator iterateProjectByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From mts.dsc.orm.project.Project as Project");
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
	
	public static Project createProject() {
		return new mts.dsc.orm.project.Project();
	}
	
	public static boolean save(mts.dsc.orm.project.Project project) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().saveObject(project);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(mts.dsc.orm.project.Project project) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().deleteObject(project);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.project.Project project)throws PersistentException {
		try {
			mts.dsc.orm.project_activity.Project_Activity[] lProject_Activitys = (mts.dsc.orm.project_activity.Project_Activity[])project.getProject_Activity().toArray(new mts.dsc.orm.project_activity.Project_Activity[project.getProject_Activity().size()]);
			for(int i = 0; i < lProject_Activitys.length; i++) {
				lProject_Activitys[i].setProjectprojectNo(null);
			}
			return delete(project);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(mts.dsc.orm.project.Project project, org.orm.PersistentSession session)throws PersistentException {
		try {
			mts.dsc.orm.project_activity.Project_Activity[] lProject_Activitys = (mts.dsc.orm.project_activity.Project_Activity[])project.getProject_Activity().toArray(new mts.dsc.orm.project_activity.Project_Activity[project.getProject_Activity().size()]);
			for(int i = 0; i < lProject_Activitys.length; i++) {
				lProject_Activitys[i].setProjectprojectNo(null);
			}
			try {
				session.delete(project);
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
	
	public static boolean refresh(mts.dsc.orm.project.Project project) throws PersistentException {
		try {
			mts.dsc.orm.department_user.DSCPersistentManager.instance().getSession().refresh(project);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
