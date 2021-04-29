package pro_Library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pro_Library.dao.BookSearchDao;
import pro_Library.database.JdbcConn;
import pro_Library.dto.BookInformation;

public class BookSearchDaoImpl implements BookSearchDao {
	private static BookSearchDaoImpl instance = new BookSearchDaoImpl();
	
	public static BookSearchDaoImpl getInstance() {
		return instance;
	}

	private List<BookInformation> list;
			
	@Override
	public List<BookInformation> showBookInformationList() {
		String sql = "select B_NO, B_NAME, B_DIVISION from book_information";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<BookInformation> list = new ArrayList<>(); 
				do {
					list.add(getBookInformation(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BookInformation getBookInformation(ResultSet rs) throws SQLException {
		int bNo = rs.getInt("B_NO");
		String bName = rs.getString("B_NAME");
		String bDivision = rs.getString("B_DIVISION");
		String bRental = rs.getString("B_RENTAL");

		return new BookInformation(bNo, bName, bDivision, bRental);
	}

	@Override
	public List<BookInformation> selectBookInformationBybNo(BookInformation bookinformation) {
		String sql = "select B_NO from Book_Information where B_NO = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookinformation.getbNo());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookInformation> list = new ArrayList<BookInformation>();
					do {
						list.add(getBookInformation(rs));
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
	public List<BookInformation> selectBookInformationBybName(BookInformation bookinformation) {
		String sql = "select B_NAME from Book_Information where B_NAME = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, bookinformation.getbName());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookInformation> list = new ArrayList<BookInformation>();
					do {
						list.add(getBookInformation(rs));
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
	public List<BookInformation> selectBookInformationBybDivision(BookInformation bookinformation) {
		String sql = "select B_DIVISION from Book_Information where B_DIVISION = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, bookinformation.getbDivision());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookInformation> list = new ArrayList<BookInformation>();
					do {
						list.add(getBookInformation(rs));
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
	public List<BookInformation> selectBookInformationBybRental(BookInformation bookinformation) {
		String sql = "select B_RENTAL from Book_Information where B_RENTAL = ?";
		try (Connection con = JdbcConn.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, bookinformation.getbRental());

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookInformation> list = new ArrayList<BookInformation>();
					do {
						list.add(getBookInformation(rs));
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
