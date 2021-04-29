package pro_Library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;
import javax.swing.table.DefaultTableModel;

import pro_Library.dao.BookInformationDao;
import pro_Library.database.JdbcConn;
import pro_Library.dto.BookInformation;

public class BookInformationDaoImpl implements BookInformationDao {
	private static BookInformationDaoImpl instance = new BookInformationDaoImpl();

	public static BookInformationDaoImpl getInstance() {
		return instance;
	}

	private String word;

	@Override
	public List<BookInformation> selectBookInformationByAll() {
		String sql = "select B_NO, B_NAME, B_DIVISION, B_RENTAL from book_information";
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
	public BookInformation selectBookInformationByNo(BookInformation bookinformation) {
		String sql = "select B_NO, B_NAME, B_DIVISION, B_RENTAL" + "from book_information where B_NO = ?";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookinformation.getbNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getBookInformation(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBookInformation(BookInformation bookinformation) {
		String sql = "insert into Book_Information values (?, ?, ?, ?)";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookinformation.getbNo());
			pstmt.setString(2, bookinformation.getbName());
			pstmt.setString(3, bookinformation.getbDivision());
			pstmt.setString(4, bookinformation.getbRental());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBookInformation(BookInformation bookinformation) {
		String sql = "update book_information"
				+ "set B_NO = ?, B_NAME = ?, B_DIVISION = ?, B_RENTAL = ? where B_NO = ?";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookinformation.getbNo());
			pstmt.setString(2, bookinformation.getbName());
			pstmt.setString(3, bookinformation.getbDivision());
			pstmt.setString(4, bookinformation.getbRental());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBookInformation(int bNo) {
		String sql = "delete from book_information where B_NO = ?";
		try (Connection con = JdbcConn.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<BookInformation> selectBookInformationBybNo(BookInformation bookinformation) {
		String sql = "select B_NO, B_NAME, B_DIVISION, B_RENTAL from vw_Book_Information where B_NO = ?";
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
		String sql = "select B_NO, B_NAME, B_DIVISION, B_RENTAL from vw_Book_Information where B_NAME = ?";
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
		String sql = "select B_NO, B_NAME, B_DIVISION, B_RENTAL from vw_Book_Information where B_DIVISION = ?";
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
		String sql = "select B_NO, B_NAME, B_DIVISION, B_RENTAL from vw_Book_Information where B_RENTAL = ?";
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

	@Override
	public List<BookInformation> showBookInformationList() {
		String sql = "select B_NO, B_NAME, B_DIVISION, B_RENTAL from book_information";
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

	@Override
	public List<BookInformation> selectBookInformationByAll(DefaultTableModel dt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getUserSearch(DefaultTableModel dt, String fieldName, String text) {
		 String sql = "SELECT * FROM TB_USERLIST WHERE " + fieldName.trim()
         				+ " LIKE '%" + word.trim() + "%'";
		 
		 try (Connection con = JdbcConn.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					List<BookInformation> list = new ArrayList<>();
					do {
						list.add(getBookInformation(rs));
					} while (rs.next());
					return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return;
		}

}
