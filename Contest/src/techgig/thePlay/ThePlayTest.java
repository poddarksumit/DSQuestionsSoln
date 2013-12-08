package techgig.thePlay;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public class ThePlayTest extends TestCase {

	ThePlay thePlay = null;
	TeamNumber teamMember = null;

	@Override
	@Before
	public void setUp() {
		thePlay = new ThePlay();
		teamMember = EasyMock.createMock(TeamNumber.class);
	}

	@Test
	public void test_CombinationResult_1() {
		assertEquals(21, thePlay.getCombinationResult(6, 3));
	}

	@Test
	public void test__CombinationResult_2() {
		assertEquals(21, thePlay.getCombinationResult(0, 3));
	}

	@Test
	public void test_CombinationResult_3() {
		assertEquals(20, thePlay.getCombinationResult(6, 3));
	}

	@Test
	public void test_Factorial_1() {
		assertEquals(6, thePlay.getFactorial(3));
	}

	@Test
	public void test_Factorial_2() {
		assertEquals(0, thePlay.getFactorial(0));
	}

	@Test
	public void test_Factorial_3() {
		assertEquals(5, thePlay.getFactorial(-6));
	}

	@Test
	public void test_Factorial_4() {
		assertEquals(720, thePlay.getFactorial(6));
	}

	// Easy Mock.

	@Test
	public void test_verifyInput_1() {

		// Mock team member.
		EasyMock.expect(teamMember.getTotalBoys()).andReturn(1);
		EasyMock.expect(teamMember.getTotalGirl()).andReturn(0);
		EasyMock.expect(teamMember.getTotalTeam()).andReturn(4);
		EasyMock.replay(teamMember);
		assertEquals(false, thePlay.verifyInput(1, teamMember));
		EasyMock.verify(teamMember);
	}

	@Test
	public void test_verifyInput_2() {
		EasyMock.expect(teamMember.getTotalBoys()).andReturn(6);
		EasyMock.expect(teamMember.getTotalGirl()).andReturn(5);
		EasyMock.expect(teamMember.getTotalTeam()).andReturn(4);
		EasyMock.replay(teamMember);
		assertEquals(false, thePlay.verifyInput(1, teamMember));
		EasyMock.verify(teamMember);
	}

	@Test
	public void test_verifyInput_3() {
		EasyMock.expect(teamMember.getTotalBoys()).andReturn(5);
		EasyMock.expect(teamMember.getTotalGirl()).andReturn(1);
		EasyMock.expect(teamMember.getTotalTeam()).andReturn(5);
		EasyMock.replay(teamMember);
		assertEquals(true, thePlay.verifyInput(1, teamMember));
		EasyMock.verify(teamMember);
	}

	@Test
	public void test_manipulatePlayerCount_1() {
		thePlay.manipulatePlayerCount(1, "(7,6,8)");
	}

	@Test
	public void test_manipulatePlayerCount_2() {
		thePlay.manipulatePlayerCount(1, "(7,6,13)");
	}

	@Test
	public void test_manipulatePlayerCount_3() {
		thePlay.manipulatePlayerCount(1, "(5,2,5)");
	}
}
