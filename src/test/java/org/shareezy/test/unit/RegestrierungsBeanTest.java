/**
 * 
 */
package org.shareezy.test.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.shareezy.beans.AccountBearbeitenBean;

/**
 * @author e1_cakir, Maurice Engelskirchen
 *
 */
public class RegestrierungsBeanTest {
	
	private RegestrierungsBeanTest proband;
	private String nullTest = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		proband = new RegestrierungsBeanTest();
	}

	/**
	 * Test method for {@link org.shareezy.beans.RegestrierungsBean#datensatzPrüfen()}.
	 */
	@Test
	public void testDatensatzPrüfen() {
		String übergebenerWert = null;
		assertEquals(nullTest, übergebenerWert);
	}

	/**
	 * Test method for {@link org.shareezy.beans.RegestrierungsBean#datensatzEinfügen()}.
	 */
	@Test
	public void testDatensatzEinfügen() {
		String übergebenerWert = null;
		assertEquals(nullTest, übergebenerWert);
	}

	/**
	 * Test method for {@link org.shareezy.beans.RegestrierungsBean#validierungsEmail()}.
	 */
	@Test
	public void testValidierungsEmail() {
		String übergebenerWert = null;
		assertEquals(nullTest, übergebenerWert);
	}

}
