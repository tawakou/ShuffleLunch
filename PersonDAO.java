package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonDAO implements Serializable {
	private Connection con;

	/**
	 * コンストラクタ
	 * @param コネクション
	 */
	public PersonDAO(Connection con) {
		this.con=con;
	}

	/**
	 * テンプレート
	 * @param テンプレート
	 * @return テンプレート
	 */
	public int regi(String name,String pass) throws SQLException {

		int ok = 0;
		String sql = "insert into person(name,pass) values(?,?)";
		PreparedStatement pStmt = con.prepareStatement(sql);
		pStmt.setString(1, name);
		pStmt.setString(2, pass);
		ok = pStmt.executeUpdate();

		return ok;
	}

	}
