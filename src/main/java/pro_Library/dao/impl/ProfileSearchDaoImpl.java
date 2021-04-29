package pro_Library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pro_Library.dao.ProfileSearchDao;
import pro_Library.database.JdbcConn;
import pro_Library.dto.BookInformation;
import pro_Library.dto.Profile;

public class ProfileSearchDaoImpl implements ProfileSearchDao {

	@Override
	public List<Profile> showProfileList() {
		String sql = "select P_NO, P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS from Profile";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Profile> list = new ArrayList<>();
				do {
					list.add(getProfile(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Profile getProfile(ResultSet rs) throws SQLException {
		int pNo = rs.getInt("P_NO");
		String pName = rs.getString("P_NAME");
		String pBirth = rs.getString("P_BIRTH");
		String pPhone = rs.getString("P_PHONE");
		String pCellphone = rs.getString("P_CELLPHONE");
		String pAddress = rs.getString("P_ADDRESS");

		return new Profile(pNo, pName, pBirth, pPhone, pCellphone, pAddress);
	}

	@Override
	public List<Profile> selectProfileBypNo(Profile profile) {
		String sql = "select P_NO from Profile where P_NO = ?";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, profile.getpNo());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Profile> list = new ArrayList<Profile>();
					do {
						list.add(getProfile(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Profile> selectProfileBypName(Profile profile) {
		String sql = "select B_NAME from Profile where B_NAME = ?";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, profile.getpName());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Profile> list = new ArrayList<Profile>();
					do {
						list.add(getProfile(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Profile> selectProfileBypBirth(Profile profile) {
		String sql = "select P_BIRTH from Profile where P_BIRTH = ?";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, profile.getpBirth());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Profile> list = new ArrayList<Profile>();
					do {
						list.add(getProfile(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Profile> selectProfileBypPhone(Profile profile) {
		String sql = "select P_PHONE from Profile where P_PHONE = ?";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, profile.getpPhone());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Profile> list = new ArrayList<Profile>();
					do {
						list.add(getProfile(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Profile> selectProfileByppCellphone(Profile profile) {
		String sql = "select P_CELLPHONE from Profile where P_CELLPHONE = ?";
		try (Connection con = JdbcConn.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, profile.getpCellphone());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Profile> list = new ArrayList<Profile>();
					do {
						list.add(getProfile(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Profile> selectProfileBypAddress(Profile profile) {
		String sql = "select P_ADDRESS from Profile where P_ADRESS = ?";
		try (Connection con = JdbcConn.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, profile.getpAddress());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<Profile> list = new ArrayList<Profile>();
					do {
						list.add(getProfile(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
