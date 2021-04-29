package pro_Library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pro_Library.dao.MemberpDao;
import pro_Library.database.JdbcConn;
import pro_Library.dto.BookInformation;
import pro_Library.dto.Memberp;
import pro_Library.dto.Profile;

public class MemberpDaoImpl implements MemberpDao {
	private static MemberpDaoImpl instance = new MemberpDaoImpl();
	
	public static MemberpDaoImpl getInstance() {
		return instance;
	}
	
	private MemberpDaoImpl() {}

	private Connection con;
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	@Override
	public List<Memberp> selectMemberpByAll() {
		String sql = "select P_NO, M_ID, M_PASS from Memberp";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Memberp> list = new ArrayList<>();
				do {
					list.add(getMemberp(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Memberp getMemberp(ResultSet rs) throws SQLException {
		int pNo = rs.getInt("P_NO");
		String mID = rs.getString("M_ID");
		String mPass = rs.getString("M_PASS");
		
		return new Memberp(pNo, mID, mPass);
	}
	
	@Override
	public Memberp selectLoginMemberp(Memberp memberp) {
		String sql = "SELECT M_ID " 
				+ 	 "  FROM Memberp " 
				+	 " WHERE M_ID = ?" 
				+	 "   AND M_PASS = password(?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, memberp.getpNo());
			pstmt.setString(2, memberp.getmID());
			pstmt.setString(3, memberp.getmPass());
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return new Memberp(rs.getInt("P_NO"), null, null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertMemberp(Memberp memberp) {
		String sql = "insert into Memberp values (?, ?, ?)";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, memberp.getpNo());
			pstmt.setString(2, memberp.getmID());
			pstmt.setString(3, memberp.getmPass());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deletMemberp(int pNo) {
		String sql = "delete from Memberp where P_NO = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, pNo);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Memberp selectMemberpByNo(Memberp memberp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMemberp(Memberp memberp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Memberp> selectMemberpByProfile(Memberp memberp) {
		String sql = "create or replace view vw_pro_Library_mem as" + 
				 "select P.P_NO" + 
				 "     , P.P_NAME" + 
				 "     , P.P_BIRTH" + 
				 "     , P.P_PHONE" + 
				 "     , P.P_CELLPHONE" + 
				 "     , P.P_ADDRESS" + 
				 "     , M.M_ID" + 
				 " from Profile p " + 
				 " join memberp m on p.P_NO = m.P_NO";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, memberp.getpNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getProfile(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Memberp> getProfile(ResultSet rs) throws SQLException {
		int pNo = rs.getInt("P_NO");
		String pName = rs.getString("P_NAME");
		String pBirth = rs.getString("P_BIRTH");
		String pPhone = rs.getString("P_PHONE");
		String pCellphone = rs.getString("P_CELLPHONE");
		String pAddress = rs.getString("P_ADDRESS");
		String mID = rs.getString("M_ID");
		
		return new Memberp(pNo, pName, pBirth, pPhone, pCellphone, pAddress, mID);
	}

	@Override
	public List<Memberp> selectMemberpByBookInfomation(BookInformation bookinfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
