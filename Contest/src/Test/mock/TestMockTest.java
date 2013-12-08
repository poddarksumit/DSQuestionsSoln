/**
 * 
 */
package Test.mock;

import java.sql.SQLException;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * This class is used to
 * 
 * @author Sumit 15-Aug-2013
 * 
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ TestMock.class })
public class TestMockTest extends TestCase {

	TestMock mockClass = null;

	@Override
	@Before
	public void setUp() {
		mockClass = PowerMock.createMock(TestMock.class);
	}

	@Test
	public void testGetAddressByAddressTypeS() throws SQLException {
		EasyMock.expect(mockClass.executeStatmentForAddrssCount("D"))
				.andReturn(7905472).times(1);
		PowerMock.replay(mockClass);
		int abc = new TestMock().getAddressByAddressTypeS("D");
		PowerMock.verify(mockClass);
	}
}
