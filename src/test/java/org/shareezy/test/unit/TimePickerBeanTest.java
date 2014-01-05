/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.mail.Transport;
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
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.shareezy.beans.TimePickerBean;
import org.shareezy.entities.Buchung;



/**
 * JUnit-Test zum Testen der Beans und dessen Methoden
 * 
 * @author Vanessa Krohn
 * 
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Session.class, Transport.class })
public class TimePickerBeanTest {

	private TimePickerBean proband;
	private Date timeframe;
	
	public boolean closeSent;
	public boolean getTransactionSent;
	public boolean beginSent;
	public boolean commitSent;
	public boolean createEntityManagerSent;
	public boolean persistSent;
	public Buchung buchung;

	/**
	 * Eine MockTransaction ist eine EntityTransaction, die ausschließlich als
	 * Attrappe für Tests benutzt wird.
	 * 
	 */
	private class MockEntityTransaction implements EntityTransaction {

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
	 */
	private class MockEntityManager implements EntityManager {

		/**
		 * Vermerkt, ob eine Transaction vom EntityManager abgefragt wurde.
		 * Antwortet mit einer MockTransaction.
		 */
		@Override
		public EntityTransaction getTransaction() {
			getTransactionSent = true;
			return new MockEntityTransaction();
		}

		/**
		 * Vermerkt, ob der EntityManager geschlossen wurde.
		 */
		@Override
		public void close() {
			closeSent = true;
		}

		/**
		 * Zeichnet auf, ob die Nachricht persist gesendet wurde.
		 */
		public void persist(Object arg0) {
			buchung = (Buchung) arg0;
			persistSent = true;
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

	

	/**
	 * Erzeugt einen neuen Probanden der zutestenden Klasse.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new TimePickerBean();
		EntityManagerFactory emf = new MockEntityManagerFactory();
		
		Class<? extends TimePickerBean> clazz = proband.getClass();
		Field field = clazz.getDeclaredField("emf");
		field.setAccessible(true);
		field.set(proband, emf);
	}
	
	/**
	 * Testmethode für addDatensatz()
	 * {@link org.shareezy.beans.TimePickerBean#addDatensatz()}.
	 */
	@Test
	public void testAddDatensatz() {
		String antwort = proband.addDatensatz();
		assertTrue(
				"Es muss ein EntityManager aus einer Factory erzeugt worden sein",
				createEntityManagerSent);
		assertTrue(
				"Es muss eine Transaction vom EntityManager abgefragt werden",
				getTransactionSent);
		assertTrue("Es muss die Transaktion gestartet werden", beginSent);
		assertTrue("Das Entity muss 'persisted' werden", persistSent);
		assertNotNull("Buchung darf nicht 'null' sein", buchung);
		assertTrue(
				"Die Transaktion muss erfolgreich abgeschlossen worden sein",
				commitSent);
	}

	/**
	 * Testmethode für getTimeframe() überprüft den Rückgabewert timeframe
	 * {@link org.shareezy.beans.TimePickerBean#getTimeframe()}.
	 */
	@Test
	public void testGetTimeframe() {
		Date tframe = proband.getTimeframe();
		assertEquals(timeframe, tframe);
	}

	/**
	 * Testmethode für checkDate(); hat keinen Rückgabewert
	 * {@link org.shareezy.beans.TimePickerBean#checkDate()}.
	 */
	@Test
	public void testCheckDate() {

	}

}
