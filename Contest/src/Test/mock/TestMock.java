/**
 * 
 */
package Test.mock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is used to
 * 
 * @author Sumit 15-Aug-2013
 * 
 */
public class TestMock {

	Connection conn = null;
	Statement stat = null;
	PreparedStatement prepStat = null;

	public int getAddressByAddressTypeS(String addrType) throws SQLException {
		createConnection();
		stat = conn.createStatement();
		return executeStatmentForAddrssCount(addrType);
	}

	private void createConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		TestMock mck = new TestMock();
		mck.getAddressTypeByAddressTypePS("D");
	}

	public int getAddressTypeByAddressTypePS(String addrType)
			throws SQLException {
		createConnection();
		prepStat = conn
				.prepareStatement(getPrepStatementForAddressByAddrType());
		prepStat.setString(1, addrType);
		return executePrepStatmentForAddrssCount();

	}

	public String getStatementForAddressByAddrType(String addrType) {
		return "SELECT * FROM ADDRESS WHERE ADDR_TYPE = '" + addrType + "'";
	}

	public String getPrepStatementForAddressByAddrType() {
		return "SELECT * FROM ADDRESS WHERE ADDR_TYPE = ?";
	}

	public int executeStatmentForAddrssCount(String addrType)
			throws SQLException {
		ResultSet set = stat
				.executeQuery(getStatementForAddressByAddrType(addrType));
		while (set.next()) {
			return set.getInt(1);
		}
		return 0;
	}

	public int executePrepStatmentForAddrssCount() throws SQLException {
		ResultSet set = prepStat.executeQuery();
		while (set.next()) {
			return set.getInt(1);
		}
		return 0;
	}
}
