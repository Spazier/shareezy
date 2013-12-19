/*
 * This file is part of shareezy, a software system for sharing resources.
 *
 * Copyright (C) 2013  	e1_cakir,
 * 						Maurice Engelskirchen
 * 						burghard.britzke (bubi@charmides.in-berlin.de)
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.SynchronizationType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.RegistrierungBean;

/**
 * Testet die RegistrierungBean
 * 
 * @author e1_cakir, Maurice Engelskirchen
 * @author burghard.britzke (bubi@charmides.in-berlin.de)
 */
public class RegistrierungBeanTest {

	public boolean closeSent;
	public boolean getTransactionSent;
	public boolean beginSent;
	public boolean commitSent;
	public boolean createEntityManagerSent;

	/**
	 * Eine MockTransaction ist eine EntityTransaction, die ausschließlich als
	 * Attrappe für Tests benutzt wird.
	 * 
	 * @author burghard.britzke (bubi@charmides.in-berlin.de)
	 */
	private class MockTransaction implements EntityTransaction {

		/**
		 * Vermerkt, ob die Transaction gestartet wurde.
		 */
		@Override
		public void begin() {
			beginSent = true;
		}

		/**
		 * Vermerkt, ob die Transaction erfolgreich beendet wurde.
		 */
		@Override
		public void commit() {
			commitSent = true;
		}

		@Override
		public void rollback() {
		}

		// -------------------------------------------
		// Die Methoden unterhalb werden nicht benutzt
		@Override
		public boolean getRollbackOnly() {
			return false;
		}

		@Override
		public boolean isActive() {
			return false;
		}

		@Override
		public void setRollbackOnly() {
		}
	}

	/**
	 * Ein MockEntityManager ist ein EntityManger, der ausschließlich als
	 * Attrappe (MOCK) für Tests dient.
	 * 
	 * @author burghard.britzke (bubi@charmides.in-berlin.de)
	 */
	private class MockEntityManager implements EntityManager {

		/**
		 * Vermerkt, ob eine Transaction vom EntityManager abgefragt wurde.
		 * Antwortet mit einer MockTransaction.
		 */
		@Override
		public EntityTransaction getTransaction() {
			getTransactionSent = true;
			return new MockTransaction();
		}

		/**
		 * Vermerkt, ob der EntityManager geschlossen wurde.
		 */
		@Override
		public void close() {
			closeSent = true;
		}

		// ---------------------------------------------
		// Die Methoden unterhalb werden nicht benötigt
		@Override
		public void clear() {
		}

		@Override
		public boolean contains(Object arg0) {
			return false;
		}

		@Override
		public <T> EntityGraph<T> createEntityGraph(Class<T> arg0) {
			return null;
		}

		@Override
		public EntityGraph<?> createEntityGraph(String arg0) {
			return null;
		}

		@Override
		public Query createNamedQuery(String arg0) {
			return null;
		}

		@Override
		public <T> TypedQuery<T> createNamedQuery(String arg0, Class<T> arg1) {
			return null;
		}

		@Override
		public StoredProcedureQuery createNamedStoredProcedureQuery(String arg0) {
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0) {
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0, Class arg1) {
			return null;
		}

		@Override
		public Query createNativeQuery(String arg0, String arg1) {
			return null;
		}

		@Override
		public Query createQuery(String arg0) {
			return null;
		}

		@Override
		public <T> TypedQuery<T> createQuery(CriteriaQuery<T> arg0) {
			return null;
		}

		@Override
		public Query createQuery(CriteriaUpdate arg0) {
			return null;
		}

		@Override
		public Query createQuery(CriteriaDelete arg0) {
			return null;
		}

		@Override
		public <T> TypedQuery<T> createQuery(String arg0, Class<T> arg1) {
			return null;
		}

		@Override
		public StoredProcedureQuery createStoredProcedureQuery(String arg0) {
			return null;
		}

		@Override
		public StoredProcedureQuery createStoredProcedureQuery(String arg0,
				Class... arg1) {
			return null;
		}

		@Override
		public StoredProcedureQuery createStoredProcedureQuery(String arg0,
				String... arg1) {
			return null;
		}

		@Override
		public void detach(Object arg0) {

		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1) {
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, Map<String, Object> arg2) {
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2) {
			return null;
		}

		@Override
		public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2,
				Map<String, Object> arg3) {
			return null;
		}

		@Override
		public void flush() {
		}

		@Override
		public CriteriaBuilder getCriteriaBuilder() {
			return null;
		}

		@Override
		public Object getDelegate() {
			return null;
		}

		@Override
		public EntityGraph<?> getEntityGraph(String arg0) {
			return null;
		}

		@Override
		public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> arg0) {
			return null;
		}

		@Override
		public EntityManagerFactory getEntityManagerFactory() {
			return null;
		}

		@Override
		public FlushModeType getFlushMode() {
			return null;
		}

		@Override
		public LockModeType getLockMode(Object arg0) {
			return null;
		}

		@Override
		public Metamodel getMetamodel() {
			return null;
		}

		@Override
		public Map<String, Object> getProperties() {
			return null;
		}

		@Override
		public <T> T getReference(Class<T> arg0, Object arg1) {
			return null;
		}

		@Override
		public boolean isJoinedToTransaction() {
			return false;
		}

		@Override
		public boolean isOpen() {
			return false;
		}

		@Override
		public void joinTransaction() {
		}

		@Override
		public void lock(Object arg0, LockModeType arg1) {
		}

		@Override
		public void lock(Object arg0, LockModeType arg1,
				Map<String, Object> arg2) {
		}

		@Override
		public <T> T merge(T arg0) {
			return null;
		}

		@Override
		public void persist(Object arg0) {
		}

		@Override
		public void refresh(Object arg0) {
		}

		@Override
		public void refresh(Object arg0, Map<String, Object> arg1) {
		}

		@Override
		public void refresh(Object arg0, LockModeType arg1) {
		}

		@Override
		public void refresh(Object arg0, LockModeType arg1,
				Map<String, Object> arg2) {
		}

		@Override
		public void remove(Object arg0) {
		}

		@Override
		public void setFlushMode(FlushModeType arg0) {
		}

		@Override
		public void setProperty(String arg0, Object arg1) {
		}

		@Override
		public <T> T unwrap(Class<T> arg0) {
			return null;
		}
	}

	/**
	 * Ein MockEntityManager ist ein EntityManager, der ausschließlich als
	 * Attrappe (MOCK) zum Testen verwendet wird.
	 * 
	 * @author burghard.britzke bubi@charmides.in-berlin.de
	 */
	private class MockEntityManagerFactory implements EntityManagerFactory {

		/**
		 * Vermerkt, ob ein EntityManager über diese Factory erstellt wurde.
		 * Antwortet mit einem MockEntityManager.
		 * 
		 * @see MockEntityManager
		 */
		@Override
		public EntityManager createEntityManager() {
			createEntityManagerSent = true;
			return new MockEntityManager();
		}

		// ---------------------------------------------
		// Die Methoden unterhalb werden nicht verwendet
		@Override
		public <T> void addNamedEntityGraph(String arg0, EntityGraph<T> arg1) {
		}

		@Override
		public void addNamedQuery(String arg0, Query arg1) {
		}

		@Override
		public void close() {
		}

		@Override
		public EntityManager createEntityManager(Map arg0) {
			return null;
		}

		@Override
		public EntityManager createEntityManager(SynchronizationType arg0) {
			return null;
		}

		@Override
		public EntityManager createEntityManager(SynchronizationType arg0,
				Map arg1) {
			return null;
		}

		@Override
		public Cache getCache() {
			return null;
		}

		@Override
		public CriteriaBuilder getCriteriaBuilder() {
			return null;
		}

		@Override
		public Metamodel getMetamodel() {
			return null;
		}

		@Override
		public PersistenceUnitUtil getPersistenceUnitUtil() {
			return null;
		}

		@Override
		public Map<String, Object> getProperties() {
			return null;
		}

		@Override
		public boolean isOpen() {
			return false;
		}

		@Override
		public <T> T unwrap(Class<T> arg0) {
			return null;
		}
	}

	private RegistrierungBean proband;
	private String nullTest = null;

	/**
	 * Setzt den Probanden auf.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		EntityManagerFactory emf = new MockEntityManagerFactory();
		proband = new RegistrierungBean();

		// Beschreibung der Klasse holen
		Class<? extends RegistrierungBean> clazz = proband.getClass();
		// Beschreibung der Eigenschaft holen
		Field field = clazz.getDeclaredField("emf");
		// Zugriff auf private Eigenschaft erlauben
		field.setAccessible(true);
		// EntityManagerFactory in den Proband injizieren
		field.set(proband, emf);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.RegestrierungsBean#datensatzPrüfen()}.
	 */
	@Test
	public void testDatensatzPrüfen() {
		String übergebenerWert = null;
		assertEquals(nullTest, übergebenerWert);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.RegestrierungsBean#datensatzEinfügen()}.
	 * Testet, ob ein Datensatz eingefügt wird.
	 */
	@Test
	public void testDatensatzEinfügen() {

		String antwort = proband.datensatzEinfügen();

		assertNull("die Antwort muss null sein", antwort);
//		assertTrue(
//				"Es muss ein EntityManager aus einer Factory erzeugt worden sein",
//				createEntityManagerSent);
	}

	/**
	 * Test method for
	 * {@link org.shareezy.beans.RegestrierungsBean#validierungsEmail()}.
	 */
	@Test
	public void testValidierungsEmail() {
		String übergebenerWert = null;
		assertEquals(nullTest, übergebenerWert);
	}
}