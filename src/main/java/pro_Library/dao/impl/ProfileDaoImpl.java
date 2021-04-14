package pro_Library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pro_Library.dao.ProfileDao;
import pro_Library.database.JdbcConn;
import pro_Library.dto.Profile;

public class ProfileDaoImpl implements ProfileDao {
	private static ProfileDaoImpl instance = new ProfileDaoImpl();
	
	public static ProfileDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Profile> selectProfileByAll() {
		String sql = "select P_NO, P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS from Profile";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if(rs.next()) {
				List<Profile> list = new ArrayList<>();
				do {
					list.add(getProfile(rs));
				} while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Profile getProfile(ResultSet rs) throws SQLException {
		int pNo = rs.getInt("pNo");
		String pName = rs.getString("pName");
		Date pBirth = rs.getDate("pBirth");
		String pPhone = rs.getString("pPhone");
		String pCellphone = rs.getString("pCellphone");
		String pAddress = rs.getString("pAddress");
		
		return new Profile(pNo, pName, pBirth, pPhone, pCellphone, pAddress);
	}

	@Override
	public Profile selectProfileByNo(Profile profile) {
		String sql = "select P_NO, P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS from Profile where P_NO = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setLong(1, profile.getpNo());
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					return getProfile(rs);
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertProfile(Profile profile) {
		String sql = "insert into Profile values (?, ?, ?, ?, ?, ?)";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, profile.getpNo());
			pstmt.setString(2, profile.getpName());
			pstmt.setDate(3, (java.sql.Date) profile.getpBirth());
			pstmt.setString(4, profile.getpPhone());
			pstmt.setString(5, profile.getpCellphone());
			pstmt.setString(6, profile.getpAddress());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateProfile(Profile profile) {
		String sql = "update Profile set P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS = ? where P_NO = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, profile.getpName());
			pstmt.setInt(1, profile.getpNo());
			pstmt.setDate(3, (java.sql.Date) profile.getpBirth());
			pstmt.setString(4, profile.getpPhone());
			pstmt.setString(5, profile.getpCellphone());
			pstmt.setString(6, profile.getpAddress());
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteProfile(int pNo) {
		String sql = "delete from Profile where P_NO = ?";
		try(Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, pNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
