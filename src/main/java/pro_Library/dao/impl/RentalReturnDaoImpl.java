package pro_Library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pro_Library.dao.RentalReturnDao;
import pro_Library.database.JdbcConn;
import pro_Library.dto.RentalReturn;

public class RentalReturnDaoImpl implements RentalReturnDao {
	private static RentalReturnDaoImpl instance = new RentalReturnDaoImpl();

	public static RentalReturnDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<RentalReturn> selectRentalReturnByAll() {
		String sql = "select P_NO, B_NO, B_R_DATE, B_RETURN, B_OVERDUE from rental_return";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<RentalReturn> list = new ArrayList<>();
				do {
					list.add(getRentalReturn(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private RentalReturn getRentalReturn(ResultSet rs) throws SQLException {
		int pNo = rs.getInt("P_NO");
		int bNo = rs.getInt("B_NO");
		Date brDate = rs.getDate("B_R_DATE");
		Date bReturn = rs.getDate("B_RETURN");
		Date bOverdue = rs.getDate("B_OVERDUE");
				
		return new RentalReturn(pNo, bNo, brDate, bReturn, bOverdue);
	}

	@Override
	public RentalReturn selectRentalReturnByNo(RentalReturn rentalreturn) {
		String sql = "select P_NO, B_NO, B_R_DATE, B_RETURN, B_OVERDUE from rental_return where P_NO = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, rentalreturn.getpNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getRentalReturn(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insetRentalReturn(RentalReturn rentalreturn) {
		String sql = "insert into rental_return values (?, ?, ?, ?, ?)";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, rentalreturn.getpNo());
			pstmt.setInt(2, rentalreturn.getbNo());
			pstmt.setDate(3, rentalreturn.getBrDate());
			pstmt.setDate(4, rentalreturn.getbReturn());
			pstmt.setDate(5, rentalreturn.getbOverdue());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateRentalReturn(RentalReturn rentalreturn) {
		String sql = "update rental_return" + 
					 "set P_NO = ?, B_NO = ?, B_R_DATE = ?, B_RETURN = ?, B_OVERDUE = ? where P_NO = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, rentalreturn.getpNo());
			pstmt.setInt(2, rentalreturn.getbNo());
			pstmt.setDate(3, rentalreturn.getBrDate());
			pstmt.setDate(4, rentalreturn.getbReturn());
			pstmt.setDate(5, rentalreturn.getbOverdue());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteRentalReturn(int pNo) {
		String sql = "delete from rental_return where P_NO = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, pNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
